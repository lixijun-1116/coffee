package com.example.coffee.utils;



public class ReturnUtils {

    public static ReturnResult returnSuccess(){
        ReturnResult result=new ReturnResult();
        result.setCode("200");
        return result;
    }

    public static ReturnResult returnSuccess(String info){
        ReturnResult result=new ReturnResult();
        result.setCode("200");
        result.setInfo(info);
        return result;
    }

    public static ReturnResult returnSuccessWithData(Object data){
        ReturnResult result=new ReturnResult();
        result.setCode("200");
        result.setData(data);
        return result;
    }

    public static ReturnResult returnSuccessWithData(Object data,String info){
        ReturnResult result=new ReturnResult();
        result.setCode("200");
        result.setData(data);
        result.setInfo(info);
        return result;
    }

    public static ReturnResult returnFailed(String code){
        ReturnResult result=new ReturnResult();
        result.setCode(code);
        return result;
    }

    public static ReturnResult returnFailed(String code,String info){
        ReturnResult result=new ReturnResult();
        result.setCode(code);
        result.setInfo(info);
        return result;
    }

    public static ReturnResult returnFailedWithData(String code,String info,Object data){
        ReturnResult result=new ReturnResult();
        result.setCode(code);
        result.setInfo(info);
        result.setData(data);
        return result;
    }
}
