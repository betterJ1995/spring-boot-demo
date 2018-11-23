package cn.j.sbdemo.common;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.EntityBuilder;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * http请求工具类
 * 基于 fluent-hc
 * created on 2018/11/23.
 *
 * @author J
 **/
public class HttpUtils {


    public static String get(String url) throws IOException {
        return Request.Get(url)
                .execute()
                .returnContent()
                .asString();
    }

    public static String get(String url, Map<String, String> paraMap) throws IOException {
        StringBuilder paraStr = new StringBuilder();
        Set<Map.Entry<String, String>> entrySet = paraMap.entrySet();
        for (Map.Entry<String, String> item : entrySet) {
            paraStr.append("&").append(item.getKey()).append("=").append(item.getValue());
        }
        return Request.Get(url + paraStr)
                .execute()
                .returnContent()
                .asString();
    }

    public static String postFile(String url, HttpEntity httpEntity) throws IOException {
        return Request.Post(url)
                .body(httpEntity)
                .execute()
                .returnContent()
                .asString();
    }

    public static String postJSON(String url, Object o) throws IOException {
        return Request.Post(url)
                .body(entityJSON(o))
                .execute()
                .returnContent()
                .asString();
    }

    public static String postForm(String url, List<NameValuePair> parameters) throws IOException {
        EntityBuilder entityBuilder = EntityBuilder.create();
        entityBuilder.setParameters(parameters);
        entityBuilder.setContentType(ContentType.create("application/x-www-form-urlencoded", "UTF-8"));
        return Request.Post(url)
                .body(entityBuilder.build())
                .execute()
                .returnContent()
                .asString();
    }


    /**
     * 构造发送文件的 entity
     *
     * @param bytes    byte数组
     * @param fileName 文件名
     * @param fileKey  对方接收文件的参数名
     * @return
     */
    public static HttpEntity entityFile(byte[] bytes, String fileName, String fileKey) {
        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        //设置成该模式 中文文件名 就不会出现乱码
        builder.setMode(HttpMultipartMode.RFC6532);
        //使用stream 百度接口收不到
        builder.addBinaryBody(fileKey, bytes, ContentType.MULTIPART_FORM_DATA, fileName);
        return builder.build();
    }


    /**
     * 构造发送文件的 entity
     *
     * @param paraMap 除文件以外的键值对
     * @return
     */
    public static HttpEntity entityFile(byte[] bytes, String fileName, String fileKey, Map<String, String> paraMap) {
        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        //设置成该模式 中文文件名 就不会出现乱码
        builder.setMode(HttpMultipartMode.RFC6532);
        //使用stream 百度接口收不到
        builder.addBinaryBody(fileKey, bytes, ContentType.MULTIPART_FORM_DATA, fileName);
        Set<Map.Entry<String, String>> entrySet = paraMap.entrySet();
        for (Map.Entry<String, String> item : entrySet) {
            builder.addTextBody(item.getKey(), item.getValue());
        }
        return builder.build();
    }


    /**
     * 构造发送文件的 entity
     *
     * @param paraMap 除文件以外的键值（数组）对
     * @return
     */
    public static HttpEntity entityFile1(byte[] bytes, String fileName, String fileKey, Map<String, String[]> paraMap) {
        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        //设置成该模式 中文文件名 就不会出现乱码
        builder.setMode(HttpMultipartMode.RFC6532);
        //使用stream 百度接口收不到
        builder.addBinaryBody(fileKey, bytes, ContentType.MULTIPART_FORM_DATA, fileName);
        Set<Map.Entry<String, String[]>> entrySet = paraMap.entrySet();
        for (Map.Entry<String, String[]> item : entrySet) {
            String key = item.getKey();
            String[] values = item.getValue();
            for (String valueItem : values) {
                builder.addTextBody(key, valueItem);
            }
        }
        return builder.build();
    }

    public static HttpEntity entityJSON(Object object) {
        return entityJSON(object, "UTF-8");
    }

    public static HttpEntity entityJSON(Object object, String charSet) {
        StringEntity stringEntity = null;
        stringEntity = new StringEntity(JSONObject.toJSONString(object), charSet);
        stringEntity.setContentType("application/json");
        return stringEntity;
    }

    public static String base64Img(String contentType, byte[] bytes) {
        BASE64Encoder encoder = new BASE64Encoder();
        String base64 = "data:" + contentType + ";base64," + encoder.encode(bytes);
        return base64;
    }
}
