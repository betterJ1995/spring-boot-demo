package cn.j.sbdemo.api2;

import cn.j.sbdemo.entity.Product;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * @Description
 * @Author J
 * @Date 2018/9/27 8:31
 **/
@RestController
@RequestMapping("/demo2")
public class DemoApi2 {

    @Qualifier("mSession")
    private DataSource product;

    @PostMapping("/post")
    @ApiOperation("post demo 接口")
    public int postDemo() {
        System.out.println(product);
        System.out.println(product);
        System.out.println(product);
        System.out.println(1);
        return 1;
    }

    @PostMapping("/get")
    @ApiOperation("get demo 接口")
    public int getDemo() {
        System.out.println(1);
        return 1;
    }
}
