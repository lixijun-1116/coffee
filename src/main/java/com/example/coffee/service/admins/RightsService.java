package com.example.coffee.service.admins;

import com.example.coffee.model.dto.RightDtoFirst;
import com.example.coffee.model.dto.RoleDto;
import com.example.coffee.model.entity.Right;

import java.util.List;

public interface RightsService {

    List<Right> getRights();

    List<RoleDto> getRoles();

    List<RightDtoFirst> getRightsTree();

    RoleDto getRoleById(int rid);

    boolean delRightWithRole(int roleId,int rightId);

    boolean updRightsWithRoleId(int roleId,String[] rights) throws Exception;

}
