package cn.j.sbdemo.core.config;

import com.baomidou.mybatisplus.core.config.GlobalConfig;
import com.baomidou.mybatisplus.core.toolkit.GlobalConfigUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author J
 * @time 2018/10/1 16:23
 * @description
 **/
@Configuration
public class MybatisPlusConfig {

    @Bean("defaultGlobalConfig")
    GlobalConfig mpGlobalConfig() {
        return GlobalConfigUtils.defaults();
    }
}
