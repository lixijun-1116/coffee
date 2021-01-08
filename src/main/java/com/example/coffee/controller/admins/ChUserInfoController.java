package com.example.coffee.controller.admins;

import com.example.coffee.api.admins.ChUserInfoApi;
import com.example.coffee.model.dto.Result;
import com.example.coffee.model.dto.UserAdminVo;
import com.example.coffee.model.entity.AdAdmin;
import com.example.coffee.service.admins.ChUserInfoService;
import com.example.coffee.utils.AjaxUtils;
import com.example.coffee.utils.ReturnResult;
import com.example.coffee.utils.ReturnUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @version v1.0
 * @ProjectName: coffee
 * @ClassName: ChUserInfoController
 * @Description: TODO(一句话描述该类的功能)
 * @Author: 李茜骏
 * @Date: 2020/4/14 17:57
 */
@RestController
public class ChUserInfoController implements ChUserInfoApi {

    @Resource
    private ChUserInfoService chUserInfoService;

    @Override
    public void getAllUserByVip(String uName, Integer pageNum, Integer pageSize, HttpServletResponse response) {
        Result result = new Result();

        System.out.println(uName);
        System.out.println(pageNum);
        System.out.println(pageSize);

        PageInfo<UserAdminVo> pageInfo = chUserInfoService.queryAllUserByVip(pageNum, pageSize, uName);
        if (pageInfo.getList() != null && pageInfo.getList().size()>0){
            result.setCode("200");
            result.setInfo("success");
            result.setData(pageInfo);
        }else {
            result.setCode("410");
            result.setInfo("gone");
        }
        AjaxUtils.resp(result,response);
    }

    @Override
    public void updateUserVip(String userId,HttpServletResponse response) {
        Result result = new Result();
        boolean b = chUserInfoService.updateUserVip(userId);
        if (b){
            result.setCode("200");
            result.setInfo("修改成功");
        }else{
            result.setCode("410");
            result.setInfo("修改失败");
        }
        AjaxUtils.resp(result,response);
    }


}
