package com.example.coffee.dao.admins;

import com.example.coffee.model.entity.Admin;
import org.apache.ibatis.annotations.Param;

/**
 * @version v1.0
 * @ProjectName: coffee
 * @ClassName: AdminDao
 * @Description: TODO(一句话描述该类的功能)
 * @Author: 李茜骏
 * @Date: 2021/9/24 10:29
 */
public interface AdminDao {

    Admin getTotal(@Param("aid") Integer aid);
}
