package com.example.coffee.controller.admins;

import com.alibaba.fastjson.JSON;
import com.example.coffee.api.admins.AdAdminApi;
import com.example.coffee.dao.admins.AdAdminDao;
import com.example.coffee.model.dto.LoginForm;
import com.example.coffee.model.dto.Result;
import com.example.coffee.model.entity.AdAdmin;
import com.example.coffee.service.admins.AdAdminService;
import com.example.coffee.utils.*;

import com.example.coffee.utils.redis.RedisUtil;
import com.example.coffee.utils.redis.UserAgent;
import cz.mallat.uasparser.UserAgentInfo;
import io.swagger.annotations.*;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @version v1.0
 * @ProjectName: coffee
 * @ClassName: AdAdminController
 * @Description: TODO(一句话描述该类的功能)
 * @Author: 李茜骏
 * @Date: 2020/4/10 16:01
 */
@RestController
public class AdAdminController implements AdAdminApi {

    @Resource
    private AdAdminService adAdminService;

    @Resource
    private RedisUtil redisUtil;

    @Override
    public void checkAdmin(String phone,String password, HttpServletResponse response) {
        System.out.println(phone);
        System.out.println(password);
        Result result = new Result();
        AdAdmin admin = adAdminService.getAdAdminByPhoneAndPassword(phone, password);
        if (admin == null){
            result.setCode("400");
            result.setInfo("failed");
        }else {
            result.setCode("200");
            result.setInfo("success");
            result.setData(admin);
        }

        AjaxUtils.resp(result,response);
    }



    @Override
    public ReturnResult checkAdmin2(@RequestBody LoginForm loginForm, HttpServletRequest request)  {
        AdAdmin admin = adAdminService.getAdAdminByPhoneAndPassword(loginForm.getPhone(), loginForm.getPassword());
        if (admin != null){
            String ua = request.getHeader("User-Agent");
            UserAgentInfo userAgentInfo = null;
            try {
                userAgentInfo = UserAgentUtil.uaSparser.parse(ua);
            }catch (Exception e){
                e.printStackTrace();
            }
            //设备信息
            String type = userAgentInfo.getDeviceType();
            //创建token
            String token = TokenUtils.createToken(admin, type);
            //将token存入redis30分钟（没有就直接存，已存在就删掉加新的）
            try {
                saveToken(token,admin);
            } catch (Exception e) {
                return ReturnUtils.returnFailed("500","Redis error");
            }

            //System.out.println();
            return ReturnUtils.returnSuccessWithData(admin,token);
        }else {
            return ReturnUtils.returnFailed("422","login failed");
        }

    }



    private void saveToken(String token,AdAdmin admin)throws Exception{
        //应该存两个信息进redis
        //1.用户id---用户token（验证）
        String tokenKey = "yue"+admin.getAid();
        String tokenValue = null;
        if ((tokenValue =(String)redisUtil.get(tokenKey))!=null){

            redisUtil.delete(tokenKey);
            redisUtil.delete(tokenValue);
        }
        redisUtil.set(tokenKey,token,3000);


        //2.用户token---用户信息（缓存）
        redisUtil.set(token, JSON.toJSONString(admin),3000);
    }

    @Override
    public ReturnResult queryAdmins(String query, Integer pageNum, Integer pageSize) throws Exception {
        List<AdAdmin> adminList = adAdminService.queryAdmins(query, pageNum, pageSize);
        Integer total = adAdminService.getTotal(query);

        Map<String,Object> result= new HashMap<>();
        result.put("adminList", adminList);
        result.put("total",total);
        result.put("pageNum",pageNum);
        return ReturnUtils.returnSuccessWithData(result);
    }

    @Override
    public ReturnResult upAdminStatus(Integer aid, boolean state) {
        Integer status = 0;
        if (state){
            status=1;
        }
        try {
            if (adAdminService.upAdminStatus(aid,status)){
                AdAdmin admin = adAdminService.getAdAdminByAid(aid);
                return ReturnUtils.returnSuccessWithData(admin);
            }else {
                return ReturnUtils.returnFailed("500","server error");
            }
        }catch (Exception e){
            return ReturnUtils.returnFailed("502","sql error");

        }


    }

    @Override
    public ReturnResult addAdAdmin(AdAdmin admin) {
        System.out.println(admin);
        try {
            if (adAdminService.addAdAdmin(admin)){

                return ReturnUtils.returnSuccess("添加成功");
            }else {
                return ReturnUtils.returnFailed("501","数据库执行出错");
            }
        }catch (Exception e){
            return ReturnUtils.returnFailedWithData("500","后台执行出错",e);

        }
    }

    @Override
    public ReturnResult unqPhone(String phone) {
        try {
            if (adAdminService.unqPhone(phone)){

                return ReturnUtils.returnSuccess();
            }else {
                return ReturnUtils.returnFailed("505","手机号已存在");
            }
        }catch (Exception e){
            return ReturnUtils.returnFailedWithData("500","后台执行出错",e);

        }

    }

    @Override
    public ReturnResult getAdAdminByAid(Integer aid) {
        try {
            AdAdmin admin = adAdminService.getAdAdminByAid(aid);
            System.out.println(admin.getaName());
            if (admin != null){

                return ReturnUtils.returnSuccessWithData(admin);
            }else {
                return ReturnUtils.returnFailed("505","该对象不存在");
            }
        }catch (Exception e){
            return ReturnUtils.returnFailedWithData("500","后台执行出错",e);

        }
    }

    @Override
    public ReturnResult upAdAdmin(Integer aid, String phone, String mail) {
        try {
            if (adAdminService.upAdAdmin(aid, phone, mail)){
                return ReturnUtils.returnSuccess();
            }else {
                return ReturnUtils.returnFailed("203","没有修改数据");
            }
        }catch (Exception e){
            return ReturnUtils.returnFailedWithData("500","后台执行出错",e);
        }
    }

    @Override
    public ReturnResult delAdAdmin(Integer aid) {
        try {
            if (adAdminService.delAdAdmin(aid)){
                return ReturnUtils.returnSuccess();
            }else {
                return ReturnUtils.returnFailed("203","没有删除的数据");
            }
        }catch (Exception e){
            return ReturnUtils.returnFailedWithData("500","后台执行出错",e);
        }
    }
}
