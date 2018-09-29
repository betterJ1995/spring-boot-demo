package cn.j.sbdemo.common;


import java.util.HashMap;

/**
 * @author J
 * @time 2018/9/27 22:26
 * @description 通用返回结果类
 **/
public class R extends HashMap<String, Object> {

    public R() {
    }

    public static R ok() {
        return ok("ok");
    }

    public static R ok(String msg) {
        return new R().code(200).msg(msg);
    }

    public static R error() {
        return error("error");
    }

    public static R error(String msg) {
        return new R().code(500).msg(msg);
    }


    public R msg(String msg) {
        this.put(KEY_MSG, msg);
        return this;
    }

    public R code(Integer code) {
        this.put(KEY_CODE, code);
        return this;
    }

    public R data(Integer data) {
        this.put(KEY_DATA, data);
        return this;
    }

    private static final String KEY_MSG = "msg";
    private static final String KEY_CODE = "code";
    private static final String KEY_DATA = "data";
}
