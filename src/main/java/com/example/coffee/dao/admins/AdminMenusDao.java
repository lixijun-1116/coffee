package com.example.coffee.dao.admins;

import com.example.coffee.model.dto.AdminMenusDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @version v1.0
 * @ProjectName: coffee
 * @ClassName: AdminMenusDao
 * @Description: TODO(一句话描述该类的功能)
 * @Author: 李茜骏
 * @Date: 2020/4/22 23:40
 */
public interface AdminMenusDao {

    List<AdminMenusDto> getTopMenu(@Param("adminType") Integer adminType);

    List<Object> getChildren(@Param("adminType") Integer adminType ,@Param("sid") Integer sid);
}
