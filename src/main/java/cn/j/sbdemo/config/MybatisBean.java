package cn.j.sbdemo.config;

import cn.j.sbdemo.entity.Product;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * created on 2018/11/19
 *
 * @author J
 **/
@Configuration
public class MybatisBean {

    @Bean("mSession")
    @Scope("prototype")
    @ConfigurationProperties(prefix = "spring.datasource")
    public Product mS() {
        return new Product().setNum(66);
    }
}
