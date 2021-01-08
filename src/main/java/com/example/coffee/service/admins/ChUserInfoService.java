package com.example.coffee.service.admins;

import com.example.coffee.model.dto.UserAdminVo;
import com.github.pagehelper.PageInfo;

public interface ChUserInfoService {

    PageInfo<UserAdminVo> queryAllUserByVip(Integer pageNum,Integer pageSize,String uName);

    boolean updateUserVip(String userId);
}
