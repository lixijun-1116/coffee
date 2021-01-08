package com.example.coffee.controller.admins;

import com.example.coffee.api.admins.AdminMenusApi;
import com.example.coffee.model.dto.AdminMenusDto;
import com.example.coffee.model.dto.Result;
import com.example.coffee.service.admins.AdminMenusService;
import com.example.coffee.utils.AjaxUtils;
import com.example.coffee.utils.ReturnResult;
import com.example.coffee.utils.ReturnUtils;
import com.example.coffee.utils.redis.RedisUtil;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @version v1.0
 * @ProjectName: coffee
 * @ClassName: AdminMenusController
 * @Description: TODO(一句话描述该类的功能)
 * @Author: 李茜骏
 * @Date: 2020/4/23 0:07
 */
@RestController
public class AdminMenusController implements AdminMenusApi {

    @Resource
    private AdminMenusService adminMenusService;
    @Resource
    private RedisUtil redisUtil;
    @Override
    public ReturnResult queryMenus(HttpServletRequest request) {

        String token = request.getHeader("Authorization");
        if (token == null || token.equals("")) {
            return ReturnUtils.returnFailed("403", "缺失token信息");
        }
        Integer adminType = new Integer(token.substring(6, 7));

        String admin = (String) redisUtil.get(token);

        Map<String,Object> map = new HashMap<>();
        map.put("adminJson",admin);
        try {
            List<AdminMenusDto> menus = adminMenusService.getMenus(adminType);
            map.put("MenuList",menus);
            return ReturnUtils.returnSuccessWithData(map);
        } catch (Exception e) {
            return ReturnUtils.returnFailed("502", "sql error");
        }

    }

}
