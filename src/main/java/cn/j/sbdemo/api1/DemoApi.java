package cn.j.sbdemo.api1;

import cn.j.sbdemo.common.PageUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author J
 * @Date 2018/9/27 8:31
 **/
@RestController
@RequestMapping("/demo1")
public class DemoApi {

    @PostMapping("/post")
    @ApiOperation("post demo 接口")
    public int postDemo() {
        Integer pn = PageUtils.getPageNo();
        System.out.println(pn);
        return 1;
    }

    @GetMapping("/get")
    @ApiOperation("get demo 接口")
    public int getDemo() {
        Integer pn = PageUtils.getPageNo();
        System.out.println(pn);
        System.out.println(PageUtils.getOrderType());
        System.out.println(PageUtils.getIsASC());
        System.out.println(1);
        return 1;
    }
}
