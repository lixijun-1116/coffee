package com.example.coffee.service.admins;

import com.example.coffee.model.entity.AdAdmin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdAdminService {
    /**
     * 根据手机号和密码获取用户
     * @param phone
     * @param password
     * @return
     */
    AdAdmin getAdAdminByPhoneAndPassword(String phone, String password);

    List<AdAdmin> queryAdmins(String query, Integer pageNum, Integer pageSize);

    Integer getTotal(String query);

    boolean upAdminStatus(Integer aid,Integer status);

    AdAdmin getAdAdminByAid(Integer aid);

    boolean addAdAdmin(AdAdmin admin);

    boolean unqPhone(String phone);

    boolean upAdAdmin(Integer aid,String phone,String mail);

    boolean delAdAdmin(Integer aid);
}