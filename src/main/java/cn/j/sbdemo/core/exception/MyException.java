package cn.j.sbdemo.core.exception;

/**
 * @author J
 * @time 2018/9/27 22:52
 * @description
 **/
public class MyException extends RuntimeException {
    public MyException() {
    }

    public MyException(String message) {
        super(message);
    }

    public MyException(String message, Throwable cause) {
        super(message, cause);
    }
}
