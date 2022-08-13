package com.example.javaapi.config;

import springfox.documentation.service.Contact;
//import io.swagger.annotations.Contact;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
 * Author: Chenly
 * Date: 2021-03-02 16:58
 * Description:
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    private static Logger log = LoggerFactory.getLogger(SwaggerConfig.class);
    @Bean
    public Docket createRestApi() {
        log.info("进入到swagger的配置中");
        return new Docket(DocumentationType.SWAGGER_2)
                // 指定构建api文档的详细信息的方法：apiInfo()
                .apiInfo(apiInfo())
                .select()
                // 指定要生成api接口的包路径，这里把controller作为包路径，生成controller中的所有接口
                .apis(RequestHandlerSelectors.basePackage("com.example.javaapi"))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 构建api文档的详细信息
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                // 设置页面标题
                .title("Spring Boot集成Swagger2接口总览")
                // 设置接口描述
                .description("Swagger接口学习")
                // 设置联系方式
                .contact(new Contact("测试swagger","http://localhost:5001/api/","123456@qq.com"))
                // 设置版本
                .version("1.0")
                // 构建
                .build();
    }



}
