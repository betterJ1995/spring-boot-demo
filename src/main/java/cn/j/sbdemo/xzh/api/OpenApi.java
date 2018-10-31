package cn.j.sbdemo.xzh.api;

import cn.j.sbdemo.xzh.consts.XzhConst;
import cn.j.sbdemo.xzh.http.BodyFormatEnum;
import cn.j.sbdemo.xzh.http.XzhResponse;
import org.json.JSONObject;

import java.net.URISyntaxException;
import java.util.HashMap;

/**
 * OpenAPI 调用基类
 *
 * @author xzh
 * @date 2018/3/27 上午10:25
 */
public class OpenApi extends Base {

    @Override
    public XzhResponse getInvoke(String api, HashMap<String, String> params,
                                 Integer conTime, Integer skTime) throws URISyntaxException {
        String url = XzhConst.URI_REST_PREFIXS + '/' + api;
        return super.getInvoke(url, params, conTime, skTime);
    }

    @Override
    public XzhResponse postInvoke(String api, HashMap<String, String> params,
                                  HashMap<String, Object> formParams, JSONObject body, BodyFormatEnum bodyFormat,
                                  Integer connTime, Integer skTime) throws URISyntaxException {
        String url = XzhConst.URI_REST_PREFIXS + '/' + api;
        return super.postInvoke(url, params, formParams, body, bodyFormat, connTime, skTime);
    }
}
