package cn.j.sbdemo.core.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Description swagger 接口文档配置
 * @Author J
 * @Date 2018/9/27 8:49
 **/
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    /**
     * UI页面显示信息
     */
    private final String API_BASE_PACKAGE = "cn.j.sbdemo";
    private final String API_TITLE = "J 接口文档";
    private final String API_DESCRIPTION = "J的demo文档描述";
    private final String API_VERSION = "1.0";

    /**
     * createRestApi
     *
     * @return
     */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //加了ApiOperation注解的类，生成接口文档
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                //该包下的接口生成接口文档
//                .apis(RequestHandlerSelectors.basePackage(API_BASE_PACKAGE))
                .paths(PathSelectors.any()).build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(API_TITLE)
                .description(API_DESCRIPTION)
                .version(API_VERSION)
                .build();
    }


}
