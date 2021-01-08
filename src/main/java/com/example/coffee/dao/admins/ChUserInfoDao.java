package com.example.coffee.dao.admins;


import com.example.coffee.model.dto.UserAdminVo;
import com.example.coffee.model.entity.AdAdmin;
import com.example.coffee.model.entity.ChUserinfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ChUserInfoDao {

    List<UserAdminVo> selectAllUserByVip(@Param("uName") String uName);



    Integer updateUserVip(@Param("userId") String userId);


}