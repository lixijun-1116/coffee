package com.example.coffee.utils;

import com.example.coffee.model.dto.ErrorInfo;
import com.example.coffee.utils.exceptions.AdminException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.http.HttpServletRequest;


@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = AdminException.class)
    @ResponseBody
//    @PostConstruct
//    @PreDestroy
    public ErrorInfo<String> defaultHandler(HttpServletRequest request,
                                            Exception e)throws Exception{

        ErrorInfo<String> errorInfo=new ErrorInfo<>();
        errorInfo.setCode(ErrorInfo.WARN);
        errorInfo.setMessage(e.getMessage());
        errorInfo.setData("xxxx");
        errorInfo.setUrl(request.getRequestURL().toString());

        return errorInfo;
    }

}
