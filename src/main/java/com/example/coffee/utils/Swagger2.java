package com.example.coffee.utils;

import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author 李茜骏
 * @version V1.0
 * @Project: token_demo
 * @Package
 * @Description: swagger配置类
 * @date 2020 年 02 月 29 10:22 星期六
 */
@Configuration
@EnableSwagger2
@EnableSwaggerBootstrapUI
public class Swagger2 {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                // 创建api基本信息
                .apiInfo(apiInfo())
                // 返回一个ApiSelectorBuilder实例用来控制哪些接口暴露给Swagger来展现，
                // 采用指定扫描的包路径来定义，
                // Swagger会扫描该包下所有Controller定义的API，
                // 并产生文档内容（除了被@ApiIgnore指定的请求）。
                .select()
                // 扫描controller包
                .apis(RequestHandlerSelectors.basePackage("com.example.coffee.controller.admins"))
                // 设置路径筛选
                .paths(PathSelectors.any())
                // 构建
                .build();
    }

    public ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                // api标题
                .title("Cafe-Home")
                // api信息
                .contact(new Contact("", null, "1279810365.@qq.com"))
                // 版本
                .version("1.0.0")
                // 描述
                .description("咖啡屋")
                // 构建
                .build();
    }
}