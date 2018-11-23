package cn.j.sbdemo.common;


import java.util.HashMap;

/**
 * result map
 * <p>
 * 注:以Rr开头是为了方便ide自动提示
 *
 * @author J
 * @time 2018/9/27 22:26
 * @description 通用返回结果类
 **/
public class RrMap extends HashMap<String, Object> {

    public RrMap() {
    }

    public static RrMap ok() {
        return ok("ok");
    }

    public static RrMap ok(String msg) {
        return new RrMap().code(200).msg(msg);
    }

    public static RrMap error() {
        return error("error");
    }

    public static RrMap error(String msg) {
        return new RrMap().code(500).msg(msg);
    }


    public RrMap msg(String msg) {
        this.put(KEY_MSG, msg);
        return this;
    }

    public RrMap code(Integer code) {
        this.put(KEY_CODE, code);
        return this;
    }

    public RrMap data(Integer data) {
        this.put(KEY_DATA, data);
        return this;
    }

    private static final String KEY_MSG = "msg";
    private static final String KEY_CODE = "code";
    private static final String KEY_DATA = "data";
}
