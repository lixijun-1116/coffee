package com.example.coffee.service.admins.impl;

import com.example.coffee.dao.admins.DiscoveryDao;
import com.example.coffee.model.entity.Discovery;
import com.example.coffee.service.admins.DiscoveryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2020/4/10.
 */
@Service
public class DiscoveryServiceImpl implements DiscoveryService {
    @Resource
    private DiscoveryDao discoveryDao;
    @Override
    public boolean addDiscovery(Discovery discovery) {
        Integer integer = discoveryDao.addDiscovery(discovery);
        if (integer>0){
            return true;
        }else {
            return false;
        }

    }

    @Override
    public boolean updateDiscovery(Discovery discovery) {
        Integer integer = discoveryDao.updateDiscovery(discovery);
        if (integer>0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean deleteDiscovery(String discoveryId) {
        Integer integer = discoveryDao.deleteDiscovery(discoveryId);
        if (integer>0){
            return true;
        }else {
            return false;
        }
    }
}
