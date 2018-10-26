package cn.j.sbdemo.sys;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.ByteArrayBody;
import org.apache.http.entity.mime.content.ContentBody;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Map;

/**
 * @Author J
 * @Date 2018/10/26 14:17
 * @Description
 **/
@RestController
@RequestMapping("/upload")
public class DemoContorller {
    private String code = "24.9c71484a8ed9cc048da1ac029a2b4a57.7200.1540552821.282335-10631502";

    @PostMapping("/img")
    public String img(@RequestPart("fileByte") byte[] fileByte, MultipartFile file, Map<String, Object> params, HttpServletRequest request) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();

        String url = "https://openapi.baidu.com/rest/2.0/cambrian/media/uploadimg?access_token=" + code;

        System.out.println(request.getContentType());
        String result = "";
        try {
//            String fileName = file.getOriginalFilename();
            HttpPost httpPost = new HttpPost(url);

            MultipartEntityBuilder builder = MultipartEntityBuilder.create();
//            builder.setCharset(Charset.forName("UTF-8"));
//            builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
//            // 文件流
//            builder.addBinaryBody("media", file.getInputStream(), ContentType.MULTIPART_FORM_DATA, fileName);
            // 类似浏览器表单提交，对应input的name和value
//            builder.addTextBody("media", fileName);

//            builder.addTextBody("type", "image");
            builder.addPart("media", new ByteArrayBody(fileByte, "media"));

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

    @GetMapping("/get")
    public String getDemo() throws IOException {
        String url = "https://openapi.baidu.com/rest/2.0/cambrian/user/get?start_index=0&access_token=" + code;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);

        String result = "";
        // 执行提交
        HttpResponse response = httpClient.execute(httpGet);
        HttpEntity responseEntity = response.getEntity();
        if (responseEntity != null) {
            System.out.println("======================");
            // 将响应内容转换为字符串
            result = EntityUtils.toString(responseEntity, Charset.forName("UTF-8"));
            System.out.println(result);

        }
        return result;
    }
}
