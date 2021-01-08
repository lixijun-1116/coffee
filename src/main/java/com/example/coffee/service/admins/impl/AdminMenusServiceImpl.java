package com.example.coffee.service.admins.impl;

import com.example.coffee.dao.admins.AdminMenusDao;
import com.example.coffee.model.dto.AdminMenusDto;
import com.example.coffee.service.admins.AdminMenusService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @version v1.0
 * @ProjectName: coffee
 * @ClassName: AdminMenusServiceImpl
 * @Description: TODO(一句话描述该类的功能)
 * @Author: 李茜骏
 * @Date: 2020/4/22 23:54
 */
@Service
public class AdminMenusServiceImpl implements AdminMenusService {

    @Resource
    private AdminMenusDao adminMenusDao;
    @Override
    public List<AdminMenusDto> getMenus(Integer adminType) {
        List<AdminMenusDto> topMenu = adminMenusDao.getTopMenu(adminType);
        for (AdminMenusDto menu : topMenu) {
            menu.setChildren(adminMenusDao.getChildren(adminType,menu.getMid()));
        }
        return topMenu;
    }


}
