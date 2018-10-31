package cn.j.sbdemo.xzh.util;

import java.util.Map;

/**
 * 公共工具类
 *
 * @author xzh
 * @date 2018/3/16 下午6:55
 */
public class CommonUtil {

    /**
     * http params build
     *
     * @param maps
     * @return
     */
    public static String httpBuildQuery(Map<String, String> maps) {
        String reString = "";
        for (String key : maps.keySet()) {
            String value = maps.get(key);
            reString += key + "=" + value + "&";
        }

        return reString.substring(0, reString.length() - 1);
    }
}