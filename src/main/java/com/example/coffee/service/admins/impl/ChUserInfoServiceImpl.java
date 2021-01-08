package com.example.coffee.service.admins.impl;

import com.example.coffee.dao.admins.ChUserInfoDao;
import com.example.coffee.model.dto.UserAdminVo;
import com.example.coffee.service.admins.ChUserInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @version v1.0
 * @ProjectName: coffee
 * @ClassName: ChUserInfoServiceImpl
 * @Description: TODO(一句话描述该类的功能)
 * @Author: 李茜骏
 * @Date: 2020/4/14 17:03
 */
@Service
public class ChUserInfoServiceImpl implements ChUserInfoService {

    @Resource
    private ChUserInfoDao chUserInfoDao;


    @Override
    public PageInfo<UserAdminVo> queryAllUserByVip(Integer pageNum, Integer pageSize, String uName) {
        PageHelper.startPage(pageNum,pageSize);
        List<UserAdminVo> adminVoList = chUserInfoDao.selectAllUserByVip(uName);
        PageInfo<UserAdminVo> pageInfo = new PageInfo<UserAdminVo>(adminVoList);
        return pageInfo;
    }

    @Override
    public boolean updateUserVip(String userId) {
        Integer integer = chUserInfoDao.updateUserVip(userId);
        if (integer > 0){
            return true;
        }
        return false;
    }
}
