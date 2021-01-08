package com.example.coffee.service.admins;

import com.example.coffee.model.entity.Discovery;

/**
 * Created by Administrator on 2020/4/10.
 */
public interface DiscoveryService {
    /**
     * 发布发现-文章
     * @param discovery
     * @return
     */
    boolean addDiscovery(Discovery discovery);

    /**
     * 修改发现-文章
     * @param discovery
     * @return
     */
    boolean updateDiscovery(Discovery discovery);

    /**
     * 删除发现-文章
     * @param discoveryId
     * @return
     */
    boolean deleteDiscovery(String discoveryId);
}
