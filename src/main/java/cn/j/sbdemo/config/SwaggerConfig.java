//package cn.j.sbdemo.config;
//
//import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
//import org.springframework.beans.BeansException;
//import org.springframework.beans.factory.BeanFactory;
//import org.springframework.beans.factory.BeanFactoryAware;
//import org.springframework.beans.factory.config.ConfigurableBeanFactory;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
///**
// * @Author J
// * @Date 2018/9/27 8:49
// * @Description swagger 接口文档配置
// * 本配置根据包生成接口文档，若需要根据注解生成
// * apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
// **/
//@Configuration
//@EnableSwagger2
//@EnableSwaggerBootstrapUI
//public class SwaggerConfig implements BeanFactoryAware {
//
//    private ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();
//
//    /**
//     * UI页面显示信息
//     */
//    private final String API_BASE_PACKAGE1 = "cn.j.sbdemo.sys.api1";
//    private final String API_TITLE = "J 接口文档";
//    private final String API_DESCRIPTION = "J的demo文档描述";
//    private final String API_VERSION = "10.0";
//
//
//    private BeanFactory beanFactory;
//
//    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
//        this.beanFactory = beanFactory;
//    }
//
////    /**
////     * 接口分组一
////     *
////     * @return
////     */
////    @Bean("defaultApi1")
////    public Docket defaultApi() {
////        return new Docket(DocumentationType.SWAGGER_2)
////                //接口基本信息
////                .apiInfo(
////                        apiInfoBuilder
////                                .title(API_TITLE)
////                                .description(API_DESCRIPTION)
////                                .version(API_VERSION)
////                                .build()
////                )
////                .groupName("defaultApi1")
////                .select()
////                //该包下的接口生成接口文档
////                //注意 扫描的包是以包名为basePackage开头的包
////                //如:配置包 xx.api 若存在xx.api2   xx.api2下的接口也会被扫描进去
////                .apis(RequestHandlerSelectors.basePackage(API_BASE_PACKAGE1))
////                .paths(PathSelectors.any())
////                .build();
////    }
////
////    /**
////     * 接口分组二
////     *
////     * @return
////     */
////    @Bean("defaultApi2")
////    public Docket defaultApi2() {
////        return new Docket(DocumentationType.SWAGGER_2)
////                //接口基本信息
////                .apiInfo(
////                        apiInfoBuilder
////                                .title(API_TITLE)
////                                .description(API_DESCRIPTION)
////                                .version(API_VERSION)
////                                .build()
////                )
////                .groupName("defaultApi2")
////                .select()
////                //该包下的接口生成接口文档
////                .apis(RequestHandlerSelectors.basePackage("cn.j.sbdemo.sys.api2"))
////                .paths(PathSelectors.any()).build();
////    }
//
//    @Bean
//    public int groupApi(){
//        ConfigurableBeanFactory cfgBeanFc = (ConfigurableBeanFactory) beanFactory;
//
//        cfgBeanFc.registerSingleton("分组2",new Docket(DocumentationType.SWAGGER_2)
//                //接口基本信息
//                .apiInfo(
//                        apiInfoBuilder
//                                .title(API_TITLE)
//                                .description(API_DESCRIPTION)
//                                .version(API_VERSION)
//                                .build()
//                )
//                .groupName("defaultApi2")
//                .select()
//                //该包下的接口生成接口文档
//                .apis(RequestHandlerSelectors.basePackage("cn.j.sbdemo.sys.api2"))
//                .paths(PathSelectors.any()).build());
//        cfgBeanFc.registerSingleton("分组1",new Docket(DocumentationType.SWAGGER_2)
//                //接口基本信息
//                .apiInfo(
//                        apiInfoBuilder
//                                .title(API_TITLE)
//                                .description(API_DESCRIPTION)
//                                .version(API_VERSION)
//                                .build()
//                )
//                .groupName("defaultApi1")
//                .select()
//                //该包下的接口生成接口文档
//                //注意 扫描的包是以包名为basePackage开头的包
//                //如:配置包 xx.api 若存在xx.api2   xx.api2下的接口也会被扫描进去
//                .apis(RequestHandlerSelectors.basePackage(API_BASE_PACKAGE1))
//                .paths(PathSelectors.any())
//                .build());
//
//        return 1;
//    }
//}
