package com.xdu.irent.config;

import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * @author zbq
 * @date 2022/11/11 19:12
 */
@Configuration
@EnableSwagger2
@EnableSwaggerBootstrapUI
public class SwaggerConfig {
    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
                .select().apis(RequestHandlerSelectors.basePackage("com.xdu.irent.controller")).build();
    }

    private ApiInfo apiInfo(){
        Contact con = new Contact("alex", "stackpop.top:8080/blog", "1654407501@qq.com");
        return new ApiInfo(
                "Irent Api",
                "irent api usage",
                "1.0",
                "null",
                con,
                "GPL3.0",
                "null",
                new ArrayList<>()
        );
    }
}
