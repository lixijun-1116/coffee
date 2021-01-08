package com.example.coffee.service.admins.impl;

import com.example.coffee.dao.admins.AdAdminDao;
import com.example.coffee.model.entity.AdAdmin;
import com.example.coffee.service.admins.AdAdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @version v1.0
 * @ProjectName: coffee
 * @ClassName: AdAdminServiceImpl
 * @Description: TODO(一句话描述该类的功能)
 * @Author: 李茜骏
 * @Date: 2020/4/10 15:51
 */
@Service
public class AdAdminServiceImpl implements AdAdminService {

    @Resource
    private AdAdminDao adAdminDao;

    /**
     * 根据手机号和密码获取用户
     * @param phone
     * @param password
     * @return
     */
    @Override
    public AdAdmin getAdAdminByPhoneAndPassword(String phone, String password) {
        return adAdminDao.getAdAdminByPhoneAndPassword(phone, password);
    }

    @Override
    public List<AdAdmin> queryAdmins(String query, Integer pageNum, Integer pageSize) {

        Integer index = (pageNum-1)*pageSize;
        List<AdAdmin> adAdmins = adAdminDao.queryAdmins(query, index, pageSize);

        for (AdAdmin adAdmin : adAdmins) {
            if (adAdmin.getStatus() ==1){
                adAdmin.setState(true);
            }
        }
        return adAdmins;
    }

    @Override
    public Integer getTotal(String query) {
        return adAdminDao.getTotal(query);
    }

    @Override
    public boolean upAdminStatus(Integer aid, Integer status) {
        Integer integer = adAdminDao.upAdminStatus(aid, status);
        if (integer > 0){
            return true;
        }
        return false;
    }

    @Override
    public AdAdmin getAdAdminByAid(Integer aid) {
        AdAdmin admin = adAdminDao.getAdAdminByAid(aid);
        return admin;
    }

    @Override
    public boolean addAdAdmin(AdAdmin admin) {
        Integer integer = adAdminDao.addAdAdmin(admin);
        if (integer > 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean unqPhone(String phone) {
        Integer integer = adAdminDao.unqPhone(phone);
        if (integer == 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean upAdAdmin(Integer aid, String phone, String mail) {
        Integer integer = adAdminDao.upAdAdmin(aid,phone,mail);
        if (integer > 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean delAdAdmin(Integer aid) {
        Integer integer = adAdminDao.delAdAdmin(aid);
        if (integer > 0){
            return true;
        }
        return false;
    }


}
