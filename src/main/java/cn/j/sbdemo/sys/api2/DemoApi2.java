package cn.j.sbdemo.sys.api2;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author J
 * @Date 2018/9/27 8:31
 **/
@RestController
@RequestMapping("/demo2")
public class DemoApi2 {

    @PostMapping("/post")
    @ApiOperation("post demo 接口")
    public int postDemo(){
        System.out.println(1);
        return 1;
    }

    @PostMapping("/get")
    @ApiOperation("get demo 接口")
    public int getDemo(){
        System.out.println(1);
        return 1;
    }
}
