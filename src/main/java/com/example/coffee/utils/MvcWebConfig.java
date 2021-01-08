//package com.example.coffee.utils;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
///**
// * @version v1.0
// * @ProjectName: coffee
// * @ClassName: MvcWebConfig
// * @Description: TODO(一句话描述该类的功能)
// * @Author: 李茜骏
// * @Date: 2020/7/19 16:37
// */
//@Configuration
//public class MvcWebConfig  implements WebMvcConfigurer {
//
////    @Bean
////    public LoginConfig getLoginConfig(){
////        return new LoginConfig();
////    }
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        //设置拦截器  放入拦截的地址
//        registry.addInterceptor(getLoginConfig()).addPathPatterns("");
//    }
//}
