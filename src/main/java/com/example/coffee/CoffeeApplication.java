package com.example.coffee;

import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@MapperScan(basePackages = "com.example.coffee.dao")
@EnableSwagger2
@EnableTransactionManagement
@EnableSwaggerBootstrapUI
public class CoffeeApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        System.out.println("-----------开始启动---------");
        long beginTime = System.currentTimeMillis();
        SpringApplication.run(CoffeeApplication.class, args);
        long endTime = System.currentTimeMillis();
        System.out.println("-----------启动完毕---------;启动耗时(s):"+((endTime-beginTime)/1000));
    }

    /**
     * @Author wuxw
     * @Description implements WebMvcConfigurer 该接口,重写addResourceHandlers ,添加swagger2 UI doc样式
     * @Date 9:49 2019/3/15
     * @Param [registry]
     * @return void
     **/
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("doc.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

}
