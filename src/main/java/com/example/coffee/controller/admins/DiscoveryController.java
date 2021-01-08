package com.example.coffee.controller.admins;


import com.example.coffee.api.admins.DiscoveryApi;
import com.example.coffee.model.dto.Result;
import com.example.coffee.model.entity.Discovery;
import com.example.coffee.service.admins.DiscoveryService;
import com.example.coffee.utils.AjaxUtils;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2020/4/10.
 */
@RestController
public class DiscoveryController implements DiscoveryApi {

    @Resource
    private DiscoveryService discoveryService;
    @Override
    public void addDiscovery(Discovery discovery, HttpServletResponse response) {
        Result result = new Result();
        if (discoveryService.addDiscovery(discovery)){
            result.setCode("200");
            result.setInfo("success");
            AjaxUtils.resp(result,response);
        }else {
            result.setCode("400");
            result.setInfo("failed");
            AjaxUtils.resp(result,response);
        }
    }

    @Override
    public void updateDiscovery(Discovery discovery, HttpServletResponse response) {
        Result result = new Result();
        if (discoveryService.updateDiscovery(discovery)){
            result.setCode("200");
            result.setInfo("success");
            AjaxUtils.resp(result,response);
        }else {
            result.setCode("400");
            result.setInfo("failed");
            AjaxUtils.resp(result,response);
        }
    }

    @Override
    public void deleteDiscovery(String discoveryId, HttpServletResponse response) {
        Result result = new Result();
        if (discoveryService.deleteDiscovery(discoveryId)){
            result.setCode("200");
            result.setInfo("success");
            AjaxUtils.resp(result,response);
        }else {
            result.setCode("400");
            result.setInfo("failed");
            AjaxUtils.resp(result,response);
        }
    }
}
