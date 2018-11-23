package cn.j.sbdemo.core.aop;

import cn.j.sbdemo.common.RrMap;
import cn.j.sbdemo.core.exception.MyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author J
 * @time 2018/9/27 22:50
 * @description RestController AOP异常处理器
 **/
@RestControllerAdvice
public class MyExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 处理自定义异常
     */
    @ExceptionHandler(MyException.class)
    public RrMap handleMyException(MyException e) {
        return RrMap.error(e.getMessage());
    }
}
