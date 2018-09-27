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
        this.put("msg", msg);
        return this;
    }

    public R code(Integer code) {
        this.put("code", code);
        return this;
    }

    public R data(Integer data) {
        this.put("data", data);
        return this;
    }
}
