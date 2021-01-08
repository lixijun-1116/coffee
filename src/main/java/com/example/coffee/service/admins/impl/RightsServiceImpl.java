package com.example.coffee.service.admins.impl;

import com.example.coffee.dao.admins.RightsDao;
import com.example.coffee.model.dto.RightDtoFirst;
import com.example.coffee.model.dto.RightDtoSecond;
import com.example.coffee.model.dto.RoleDto;
import com.example.coffee.model.entity.Right;
import com.example.coffee.service.admins.RightsService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @version v1.0
 * @ProjectName: coffee
 * @ClassName: RightsServiceImpl
 * @Description: TODO(一句话描述该类的功能)
 * @Author: 李茜骏
 * @Date: 2020/5/5 16:19
 */
@Service
public class RightsServiceImpl implements RightsService {

    @Resource
    private RightsDao rightsDao;


    @Override
    public List<Right> getRights() {
        List<Right> rights = rightsDao.getRights();
        return rights;
    }

    @Override
    public List<RoleDto> getRoles() {
        List<RoleDto> roleDtoList = rightsDao.rolesBaseInfo();

        for (RoleDto roleDto : roleDtoList) {
            for (RightDtoFirst right:roleDto.getRights()){
                right.setChildren(rightsDao.getSecondRightByRole(roleDto.getRid(),right.getRid()));
                for (RightDtoSecond rightSec:right.getChildren()){
                    rightSec.setChildren(rightsDao.getThirdRightByRole(roleDto.getRid(),rightSec.getRid()));
                }
            }
        }
        return roleDtoList;
    }

    @Override
    public List<RightDtoFirst> getRightsTree() {

        List<Right> firstRights=rightsDao.getRightsBySid(0);
        List<RightDtoFirst> result=new ArrayList<>();

        for (Right first:firstRights) {
            //装配一级权限的属性
            RightDtoFirst dtoFirst=new RightDtoFirst();
            BeanUtils.copyProperties(first,dtoFirst);
            //查找下级的二级权限
            List<Right> secRights=rightsDao.getRightsBySid(first.getRid());
            //装配二级权限属性
            List<RightDtoSecond> children=new ArrayList<>();
            for(Right second:secRights){
                RightDtoSecond dtoSecond=new RightDtoSecond();
                BeanUtils.copyProperties(second,dtoSecond);
                //查找三级属性
                List<Right> thirdRights=rightsDao.getRightsBySid(second.getRid());
                //给二级children赋值
                dtoSecond.setChildren(thirdRights);
                children.add(dtoSecond);
            }
            //给一级children赋值
            dtoFirst.setChildren(children);
            result.add(dtoFirst);
        }

        return result;
    }

    @Override
    public RoleDto getRoleById(int rid) {

        List<RoleDto> roleDtoList = getRoles();
        for (RoleDto dto:roleDtoList) {
            if (dto.getRid()==rid){
                return dto;
            }
        }
        return null;
    }

    @Transactional
    @Override
    public boolean delRightWithRole(int roleId, int rightId) {
        //如果是三级权限，直接删除
        //如果是高级权限，先查出他所有的下级，删除所有下级，删完再删它本身
        //二三级权限，删完了再看看他的上级还有没有其他下级，没有的话，就一并删掉
        if (rightsDao.delRightWithRole(roleId, rightId)>0){
            return true;
        }
        return false;
    }

    @Transactional
    @Override
    public boolean updRightsWithRoleId(int roleId, String[] rights) throws Exception{

        rightsDao.delRightsByRole(roleId);
        rightsDao.addRightsByRole(roleId, rights);
        return true;
    }
}
