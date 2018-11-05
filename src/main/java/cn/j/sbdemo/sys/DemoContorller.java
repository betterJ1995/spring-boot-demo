package cn.j.sbdemo.sys;

import cn.j.sbdemo.common.HttpUtils;
import cn.j.sbdemo.xzh.consts.XzhConst;
import cn.j.sbdemo.xzh.http.*;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.ByteArrayBody;
import org.apache.http.entity.mime.content.ContentBody;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.InputStreamBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Encoder;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author J
 * @Date 2018/10/26 14:17
 * @Description
 **/
@RestController
@RequestMapping("/upload")
public class DemoContorller {
    private String code = "24.49cab5a44c5fafdcb76247501a35d4e3.7200.1540801182.282335-10631502";


    @PostMapping("/img")
    public String img(MultipartFile file, Map<String, Object> params, HttpServletRequest request) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();

        String url = "https://openapi.baidu.com/rest/2.0/cambrian/media/uploadimg?access_token=" + code;

        System.out.println(request.getContentType());
        String result = "";
        try {
            HttpPost httpPost = new HttpPost(url);

            MultipartEntityBuilder builder = MultipartEntityBuilder.create();

            //设置成该模式中文文件名就不会出现乱码
            builder.setMode(HttpMultipartMode.RFC6532);
            builder.addBinaryBody("media", file.getBytes(), ContentType.MULTIPART_FORM_DATA, file.getOriginalFilename());

            HttpEntity entity = builder.build();
            httpPost.setEntity(entity);
            // 执行提交
            HttpResponse response = httpClient.execute(httpPost);
            HttpEntity responseEntity = response.getEntity();
            if (responseEntity != null) {
                System.out.println("======================");
//                System.out.println(JSONObject.toJSONString(responseEntity));
                // 将响应内容转换为字符串
                result = EntityUtils.toString(responseEntity, Charset.forName("UTF-8"));
                System.out.println(result);

                System.out.println("okok");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;

    }


    @PostMapping("/img2")
    public String img2(MultipartFile file, Map<String, Object> params, HttpServletRequest request) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();

        String url = "https://openapi.baidu.com/rest/2.0/cambrian/media/uploadimg?access_token=" + code;

        System.out.println(request.getContentType());
        String result = "";
        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        //设置成该模式 中文文件名 就不会出现乱码
        builder.setMode(HttpMultipartMode.RFC6532);
        builder.addBinaryBody("media", file.getBytes(), ContentType.MULTIPART_FORM_DATA, file.getOriginalFilename());
        HttpEntity entity = builder.build();
        try {
            result = Request.Post(url)
                    .body(entity)
                    .execute()
                    .returnContent()
                    .asString();

            System.out.println(result);
            System.out.println("===============");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;

    }

    /**
     * 代开熊掌号
     *
     * @param file1
     * @param file2
     * @param file3
     * @param file4
     * @return
     * @throws IOException
     */
    @PostMapping("/post")
    public String getDemo(MultipartFile file1, MultipartFile file2, MultipartFile file3, MultipartFile file4) throws IOException, URISyntaxException {
        String url = "https://openapi.baidu.com/rest/2.0/cambrian/tp/create_lice_xzh";

        String url0 = "https://openapi.baidu.com/rest/2.0/cambrian/tp/create_lice_xzh?tp_access_token=42.c151a8b3f67ea711e0ae0e7ae5a88a3d.7200.1540983639.NkBhmL3mDaGN8CG_m22n-36GetTy5eq50cyFscj";
        String result = "";

        String img1 = HttpUtils.base64Img(file1.getContentType(), file1.getBytes());
        String img2 = HttpUtils.base64Img(file2.getContentType(), file2.getBytes());
        String img3 = HttpUtils.base64Img(file3.getContentType(), file3.getBytes());
        String img4 = HttpUtils.base64Img(file4.getContentType(), file4.getBytes());

//        List<NameValuePair> pairList = new ArrayList<>();
//        //本系统唯一id
//        pairList.add(new BasicNameValuePair("third_id", "test201810311706"));
//        //类型
//        pairList.add(new BasicNameValuePair("type", "3"));
//        // 熊掌号名称
//        pairList.add(new BasicNameValuePair("name", "软科技"));
//        //签名
//        pairList.add(new BasicNameValuePair("wish", "软科技、专注软件研发制造啊"));
//        //领域行业
//        pairList.add(new BasicNameValuePair("domain", "1"));
//        //位置 省市
//        pairList.add(new BasicNameValuePair("location", "湖北省-武汉"));
//        //组织名称/政府名称/企业名称：与营业执照或组织机构代码证保持一致
//        pairList.add(new BasicNameValuePair("org_name", "软科技有限公司"));
//        //组织机构代码(media)/营业执照注册号(company)
//        pairList.add(new BasicNameValuePair("org_code", "13622"));
//        //运营者姓名
//        pairList.add(new BasicNameValuePair("owner_name", "542"));
//        //运营者身份证
//        pairList.add(new BasicNameValuePair("owner_id", "2542"));
//        //运营者手机号
//        pairList.add(new BasicNameValuePair("pass_phone", "15945892369"));
//        //头像
//        pairList.add(new BasicNameValuePair("avatar", img1));
//        //营业执照影印件(company)/组织机构代码证影印件
//        pairList.add(new BasicNameValuePair("org_license", img2));
//        //运营者身份证复印件
//        pairList.add(new BasicNameValuePair("owner_photo", img3));
//        //授权截图
//        pairList.add(new BasicNameValuePair("auth_img", img4));
//        result = HttpUtils.postForm(url0, pairList);
//        System.out.println(result);

        HashMap<String, Object> param = new HashMap<>();
        param.put("third_id", "test1101");
        param.put("type", "3");
        param.put("name", "软科技");
        param.put("wish", "软科技、专注软件研发制造啊");
        param.put("domain", "1");
        param.put("location", "湖北省-武汉");
        param.put("org_name", "软科技有限公司");
        param.put("org_code", "13622");
        param.put("owner_name", "高天成");
        param.put("owner_id", "1222");
        param.put("pass_phone", "45425");
        param.put("avatar", img1);
        param.put("org_license", img2);
        param.put("owner_photo", img3);
        param.put("auth_img", img4);

        HashMap<String, String> pa = new HashMap<>();
        pa.put("tp_access_token", "");

        XzhRequest xzhRequest = new XzhRequest();
        xzhRequest.setFormParams(param);
        xzhRequest.setBodyFormat(BodyFormatEnum.FORM_KV);
        xzhRequest.setHttpMethod(HttpMethodEnum.POST);
        xzhRequest.setUri(new URI(url));
        xzhRequest.setParams(pa);
        xzhRequest.setContentEncoding("utf-8");

        Integer conTimeoutMillis = XzhConst.CONNECTION_TIMEOUT_MILLS;
        Integer skTimeoutMillis = XzhConst.SOCKET_TIMEOUT_MILLIS;
        ConnectConfig clientConnectConfig = new ConnectConfig(conTimeoutMillis, skTimeoutMillis);
        xzhRequest.setConfig(clientConnectConfig);

        HashMap<String, String> headerMap = new HashMap<>();
        headerMap.put("connection", "Keep-Alive");
        xzhRequest.setHeaders(headerMap);


        XzhResponse xzhResponse = XzhHttpClient.post(xzhRequest);
        result = xzhResponse.getBody();
        System.out.println(result);

        return result;
    }
}
