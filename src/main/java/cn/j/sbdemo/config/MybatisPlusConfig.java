package cn.j.sbdemo.config;

import com.baomidou.mybatisplus.core.config.GlobalConfig;
import com.baomidou.mybatisplus.core.toolkit.GlobalConfigUtils;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.apache.ibatis.plugin.Interceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author J
 * @time 2018/10/1 16:23
 * @description mybatis plus
 **/
@Configuration
public class MybatisPlusConfig {

    @Bean("defaultGlobalConfig")
    GlobalConfig mpGlobalConfig() {
        return GlobalConfigUtils.defaults();
    }

    @Bean("defaultPlugins")
    Interceptor[] mpPlugins() {
        Interceptor paginationInterceptor = new PaginationInterceptor();
        return new Interceptor[]{paginationInterceptor};
    }
}
