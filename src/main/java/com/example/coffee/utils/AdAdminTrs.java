package com.example.coffee.utils;

import com.example.coffee.dao.admins.AdAdminDao;
import com.example.coffee.model.entity.AdAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @version v1.0
 * @ProjectName: coffee
 * @ClassName: AdAdminTrs
 * @Description: TODO(一句话描述该类的功能)
 * @Author: 李茜骏
 * @Date: 2021/10/8 13:58
 */

public class AdAdminTrs {

    public static List<AdAdmin> list = new ArrayList<>();

    @Autowired
    private AdAdminDao adAdminDao;

    public AdAdminTrs(){
        list = adAdminDao.all();
    }




}
