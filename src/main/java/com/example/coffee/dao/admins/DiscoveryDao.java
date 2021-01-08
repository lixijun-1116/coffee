package com.example.coffee.dao.admins;


import com.example.coffee.model.entity.Discovery;

/**
 * Created by Administrator on 2020/4/10.
 */
public interface DiscoveryDao {

    /**
     * 发布发现-文章
     * @param discovery
     * @return
     */
    Integer addDiscovery(Discovery discovery);

    /**
     * 修改发现-文章
     * @param discovery
     * @return
     */
    Integer updateDiscovery(Discovery discovery);

    /**
     * 删除发现-文章
     * @param discoveryId
     * @return
     */
    Integer deleteDiscovery(String discoveryId);
}
