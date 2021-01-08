package com.example.coffee.controller.admins;

import com.example.coffee.api.admins.RightsApi;
import com.example.coffee.model.dto.RightDtoFirst;
import com.example.coffee.model.dto.RoleDto;
import com.example.coffee.model.entity.Right;
import com.example.coffee.service.admins.RightsService;
import com.example.coffee.utils.ReturnResult;
import com.example.coffee.utils.ReturnUtils;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @version v1.0
 * @ProjectName: coffee
 * @ClassName: RightsController
 * @Description: TODO(一句话描述该类的功能)
 * @Author: 李茜骏
 * @Date: 2020/5/5 16:17
 */
@RestController
public class RightsController implements RightsApi {

    @Resource
    private RightsService rightsService;

    @Override
    public ReturnResult queryRights() {

        try{
            List<Right> rights = rightsService.getRights();
            return ReturnUtils.returnSuccessWithData(rights);
        }catch (Exception e){
            return ReturnUtils.returnFailedWithData("500","sql error",e);
        }
    }

    @Override
    public ReturnResult queryRoles() {
        try{
            List<RoleDto> roleDtoList = rightsService.getRoles();
            return ReturnUtils.returnSuccessWithData(roleDtoList);
        }catch (Exception e){
            return ReturnUtils.returnFailedWithData("500","sql error",e);
        }

    }

    @Override
    public ReturnResult delRight(int roleId, int rightId) {
        if (rightsService.delRightWithRole(roleId,rightId)){
            return ReturnUtils.returnSuccessWithData(rightsService.getRoleById(roleId));
        }
        return ReturnUtils.returnFailed("500");
    }

    @Override
    public ReturnResult updRight(int roleId, String rightIds) {
        String[] rights=rightIds.split(",");
        try {
            if (rightsService.updRightsWithRoleId(roleId,rights)){
                return ReturnUtils.returnSuccess();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ReturnUtils.returnFailed("500");
        }
        return ReturnUtils.returnFailed("500");
    }

    @Override
    public ReturnResult queryRightsTree() {
        try{
            List<RightDtoFirst> rightList=rightsService.getRightsTree();
            System.out.println("----");
            System.out.println(rightList);
            return ReturnUtils.returnSuccessWithData(rightList);
        }catch (Exception e){
            e.printStackTrace();
            return ReturnUtils.returnFailed("500");
        }
    }
}
