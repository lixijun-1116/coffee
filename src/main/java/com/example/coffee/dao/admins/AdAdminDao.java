package com.example.coffee.dao.admins;

import com.example.coffee.model.entity.AdAdmin;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface AdAdminDao {
    /**
     * 根据手机号和密码获取用户
     * @param phone
     * @param password
     * @return
     */
    AdAdmin getAdAdminByPhoneAndPassword(String phone,String password);


    List<AdAdmin> queryAdmins(@Param("query") String query,
                              @Param("index")Integer index,
                              @Param("pageSize")Integer pageSize);

    Integer getTotal(String query);

    Integer upAdminStatus(@Param("aid") Integer aid,@Param("status")Integer status);

    AdAdmin getAdAdminByAid(@Param("aid") Integer aid);

    Integer addAdAdmin(AdAdmin admin);

    Integer unqPhone(@Param("phone") String phone);

    Integer upAdAdmin(@Param("aid") Integer aid,@Param("phone")String phone,@Param("mail")String mail);

    Integer delAdAdmin(@Param("aid")Integer aid);

    List<AdAdmin> all();
}
