package com.example.coffee.api.admins;

import com.example.coffee.utils.ReturnResult;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;

@Api(tags = "用户会员")
public interface ChUserInfoApi {
    @ApiOperation(value = "查询所有的会员用户（分页）",notes = "正确code=200,错误code=410")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "uName",value = "用户姓名（可不填，用于模糊查找）",dataType = "String"),
            @ApiImplicitParam(name = "pageNum",value = "第几页",dataType = "Integer",example = "1"),
            @ApiImplicitParam(name = "pageSize",value = "每页的数量",dataType = "Integer",example = "2"),
    })
    @ApiResponses({
            @ApiResponse(code = 200,message = "查询成功"),
            @ApiResponse(code = 410,message = "用户请求的资源被删除")
    })
    @RequestMapping(value = "getAllUserByVip",method = RequestMethod.GET)
    void getAllUserByVip(@RequestParam(value = "uName",required = false,defaultValue = "") String uName,
                         @RequestParam(value = "pageNum",required = false,defaultValue = "1") Integer pageNum,
                         @RequestParam(value = "pageSize",required = false,defaultValue = "2") Integer pageSize,
                         HttpServletResponse response);

    @ApiOperation(value = "修改会员",notes = "正确code=200,错误code=410")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId",value = "用户id",dataType = "String"),

    })
    @ApiResponses({
            @ApiResponse(code = 200,message = "修改成功"),
            @ApiResponse(code = 410,message = "修改失败")
    })
    @RequestMapping(value = "updateUserVip",method = RequestMethod.PUT)
    void updateUserVip(@RequestParam(value = "userId") String userId,HttpServletResponse response);



}
