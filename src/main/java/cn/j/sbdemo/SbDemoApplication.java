package cn.j.sbdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Description 启动类
 * @Author J
 * @Date 2018/9/27 8:31
 **/
@SpringBootApplication
@tk.mybatis.spring.annotation.MapperScan(basePackages = "cn.j.sbdemo.sys")
@EnableSwagger2
public class SbDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SbDemoApplication.class, args);
    }
}
