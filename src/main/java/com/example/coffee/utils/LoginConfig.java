//package com.example.coffee.utils;
//
//import org.springframework.web.servlet.HandlerInterceptor;
//
//import javax.annotation.Resource;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
///**
// * @version v1.0
// * @ProjectName: coffee
// * @ClassName: LoginConfig
// * @Description: TODO(一句话描述该类的功能)
// * @Author: 李茜骏
// * @Date: 2020/7/19 16:36
// */
//public class LoginConfig implements HandlerInterceptor {
//
//
//    @Resource
//    private ReturnUtils returnUtils;
//
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        HttpSession session = request.getSession();
//        if (session.getAttribute("user")!=null){
//
//        }
//        return false;
//    }
//}
