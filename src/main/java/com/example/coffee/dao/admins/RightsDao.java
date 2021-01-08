package com.example.coffee.dao.admins;

import com.example.coffee.model.dto.RightDtoSecond;
import com.example.coffee.model.dto.RoleDto;
import com.example.coffee.model.entity.Right;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @version v1.0
 * @ProjectName: coffee
 * @ClassName: RightsDao
 * @Description: TODO(一句话描述该类的功能)
 * @Author: 李茜骏
 * @Date: 2020/5/5 16:19
 */
public interface RightsDao {

    List<Right> getRights();

    List<RoleDto> rolesBaseInfo();

    List<RightDtoSecond> getSecondRightByRole(@Param("roleid") Integer roleid, @Param("subid") Integer subid);


    List<Right> getThirdRightByRole(@Param("roleid") Integer roleid,@Param("subid") Integer subid);

    int delRightWithRole(@Param("roleid") int roleid,@Param("rightid") int rightid);

    List<Right> getRightsBySid(@Param("subid")int subid);

    int delRightsByRole(@Param("roleid")int roleid);

    int addRightsByRole(@Param("roleid")int roleid,@Param("rights")String[] rights);
}
