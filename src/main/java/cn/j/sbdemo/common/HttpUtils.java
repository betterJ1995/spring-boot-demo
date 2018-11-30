package cn.j.sbdemo.common;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.ByteArrayBody;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.misc.BASE64Encoder;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

/**
 * http请求工具类
 * 依赖 fluent-hc , fastjson
 * created on 2018/11/23.
 *
 * @author J
 **/
public class HttpUtils {

    private static Logger logger = LoggerFactory.getLogger(HttpUtils.class);

    /**
     * 默认超时时间 5秒
     */
    public final static int DEF_TIME_OUT = 5000;

    /**
     * 若文件以byte方式发送,则在form data里put该键表示文件名
     */
    public static final String BYTE_FILE_NAME = "byteFileName";

    private static final String ENCODING = "UTF-8";

    public static JSONObject get(String url, Map<String, String> paraMap) throws IOException {
        return get(url, paraMap, DEF_TIME_OUT, DEF_TIME_OUT);
    }


    public static JSONObject get(String url, Map<String, String> paraMap, int connTimeout, int socketTimeout) throws IOException {
        url = buildUrl(url, paraMap);
        logger.info("GET URL: {}", url);
        String re = Request.Get(url)
                .connectTimeout(connTimeout)
                .socketTimeout(socketTimeout)
                .execute()
                .returnContent()
                .asString();
        return JSONObject.parseObject(re);
    }


    /**
     * post JSON 数据
     *
     * @param url     url
     * @param paraMap url参数
     * @param jsonObj 需要转化为JSON字符串的对象，一般是一个实体或者是一个Map
     * @return
     * @throws IOException
     */
    public static JSONObject postJSON(String url, Map<String, String> paraMap, Object jsonObj) throws IOException {
        return postJSON(url, paraMap, jsonObj);
    }

    public static JSONObject postJSON(String url, Map<String, String> paraMap, Object jsonObj, int connTimeout, int socketTimeout) throws IOException {
        url = buildUrl(url, paraMap);
        logger.info("POST URL: {}", url);

        String jsonStr = JSONObject.toJSONString(jsonObj);
        logger.info("POST SEND JSON DATA: {}", jsonStr);

        StringEntity stringEntity = new StringEntity(jsonStr, ENCODING);
        stringEntity.setContentType("application/json");

        return post(url, stringEntity, connTimeout, socketTimeout);


    }

    /**
     * post 表单数据
     *
     * @param url     url
     * @param paraMap url参数Map
     * @param formMap 表单参数map
     *                发送文件 支持file类型和byte[]类型，
     *                若为byte[]类型时，需在map中传入文件名，key为{@link HttpUtils#BYTE_FILE_NAME}
     * @return
     * @throws IOException
     */
    public static JSONObject postForm(String url, Map<String, String> paraMap, Map<String, Object> formMap) throws IOException {
        return postForm(url, paraMap, formMap, DEF_TIME_OUT, DEF_TIME_OUT);
    }

    public static JSONObject postForm(String url, Map<String, String> paraMap, Map<String, Object> formMap, int connTimeout, int socketTimeout) throws IOException {

        url = buildUrl(url, paraMap);
        logger.info("POST URL: {}", url);

        MultipartEntityBuilder entityBuilder = MultipartEntityBuilder.create();
        entityBuilder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);

        if (formMap != null && formMap.size() > 0) {
            //移除对应的文件名,因为不需要打印
            String byteFileName = null;
            if (formMap.containsKey(BYTE_FILE_NAME)) {
                byteFileName = (String) formMap.remove(BYTE_FILE_NAME);
            }
            logger.info("THE NEXT IS POST SEND FORM DATA");
            Set<Map.Entry<String, Object>> entrySet = formMap.entrySet();
            for (Map.Entry<String, Object> item : entrySet) {
                String itemKey = item.getKey();
                Object itemValue = item.getValue();

                String valueToString = itemValue.toString();
                //若太长,则截取160
                logger.info("FORM ITEM : {}={}", itemKey
                        , valueToString.length() > 160 ? valueToString.substring(0, 160) : valueToString
                );

                //若是文件类型
                if (itemValue instanceof File) {
                    FileBody fileBody = new FileBody((File) itemValue);
                    entityBuilder.addPart(itemKey, fileBody);

                } else if (itemValue instanceof byte[]) {
                    //byte[]文件
                    if (StringUtils.isBlank(byteFileName)) {
                        byteFileName = RandomStringUtils.randomAlphanumeric(16);
                    }
                    ByteArrayBody byteArrayBody = new ByteArrayBody((byte[]) itemValue, ContentType.MULTIPART_FORM_DATA, byteFileName);
                    entityBuilder.addPart(itemKey, byteArrayBody);
                    //若是byte数组 不设置成该模式文件名乱码
                    entityBuilder.setMode(HttpMultipartMode.RFC6532);
                } else {
                    StringBody name = new StringBody(itemValue.toString(),
                            ContentType.TEXT_PLAIN.withCharset(ENCODING));
                    entityBuilder.addPart(itemKey, name);
                }
            }
//            logger.info("POST SEND FORM DATA : {}", formMap);
        }

        return post(url, entityBuilder.build(), connTimeout, socketTimeout);
    }


    /**
     * 转换base64
     */
    public static String base64Img(String contentType, byte[] bytes) {
        String base64 = "data:" + contentType + ";base64," + base64Img(bytes);
        return base64;
    }


    /**
     * 转换base64
     */
    public static String base64Img(byte[] bytes) {
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(bytes);
    }

    public static String buildUrl(String url, Map<String, String> params) {
        if (params == null || params.size() == 0) {
            return url;
        }

        Set<Map.Entry<String, String>> entrySet = params.entrySet();
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String, String> item : entrySet) {
            String key = item.getKey();
            String value = item.getValue();
            if (StringUtils.isNotBlank(key) && StringUtils.isNotBlank(value)) {
                stringBuilder.append(key).append("=").append(value).append("&");
            }
        }

        int len = stringBuilder.length();
        if (len > 0) {
            return url + "?" + stringBuilder.substring(0, len - 1);
        }

        return url;
    }


    private static JSONObject post(String url, HttpEntity httpEntity, int connTimeout, int socketTimeout) throws IOException {
        String re = Request.Post(url)
                .body(httpEntity)
                .connectTimeout(connTimeout)
                .socketTimeout(socketTimeout)
                .execute()
                .returnContent()
                .asString();

        return JSONObject.parseObject(re);
    }
}
