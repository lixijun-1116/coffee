package com.example.coffee.api.admins;

import com.example.coffee.model.dto.LoginForm;
import com.example.coffee.model.entity.AdAdmin;
import com.example.coffee.utils.ReturnResult;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Api(tags = "Admin后台管理")
public interface AdAdminApi {

    @ApiOperation(value = "输入手机号和密码进行登录",notes = "正确code=200,错误code=400")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "phone",value = "phone",dataType = "String",example = "16606147603"),
            @ApiImplicitParam(name = "password",value = "password",dataType = "String",example = "123456")
    })
    @ApiResponses({
            @ApiResponse(code = 200,message = "登录成功"),
            @ApiResponse(code = 400,message = "手机号或密码错误！")
    })
    @RequestMapping(value = "checkAdmin",method = RequestMethod.GET)
    public void checkAdmin(String phone,String password, HttpServletResponse response);

    /**
     *
     * @param loginForm
     * @param request
     */
    @ApiOperation(value = "输入手机号和密码进行登录2",notes = "正确code=200,错误code=400")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "phone",value = "phone",dataType = "String",example = "16606147603"),
            @ApiImplicitParam(name = "password",value = "password",dataType = "String",example = "123456")
    })
    @ApiResponses({
            @ApiResponse(code = 200,message = "登录成功"),
            @ApiResponse(code = 422,message = "手机号或密码错误！"),
            @ApiResponse(code = 500,message = "Redis Error"),

    })
    @RequestMapping(value = "checkAdmin2",method = RequestMethod.POST)
    public ReturnResult checkAdmin2(@RequestBody LoginForm loginForm, HttpServletRequest request) throws Exception;

    /**
     *
     * @param query
     * @param pageNum
     * @param pageSize
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "获取所有管理员信息",notes = "正确code=200,错误code=400")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "query",value = "查询条件",dataType = "String"),
            @ApiImplicitParam(name = "pageNum",value = "当前页码",dataType = "Int"),
            @ApiImplicitParam(name = "pageSize",value = "每页显示数量",dataType = "Int")
    })
    @ApiResponses({
            @ApiResponse(code = 502,message = "后台处理异常"),
            @ApiResponse(code = 500,message = "后台查询有误！"),
            @ApiResponse(code = 200,message = "返回数据！")
    })
    @RequestMapping(value = "queryAdmins",method = RequestMethod.GET)
    public ReturnResult queryAdmins(@RequestParam(value = "query",required = false,defaultValue = "") String query ,
                                    @RequestParam(value = "pageNum",required = true)Integer pageNum,
                                    @RequestParam(value = "pageSize",required = true)Integer pageSize)throws Exception;


    @ApiOperation(value = "修改管理员状态",notes = "正确code=200,错误code=400")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "aid",value = "管理员id",dataType = "Integer"),
            @ApiImplicitParam(name = "state",value = "switch开关",dataType = "boolean")
    })
    @ApiResponses({
            @ApiResponse(code = 502,message = "sql处理异常"),
            @ApiResponse(code = 500,message = "后台查询有误！"),
            @ApiResponse(code = 200,message = "返回数据！")
    })
    @RequestMapping(value = "upAdminStatus/{aid}/state/{state}",method = RequestMethod.PUT)
    ReturnResult upAdminStatus(@PathVariable("aid")Integer aid,
                             @PathVariable("state") boolean state);

    /**
     *
     * @param admin
     * @return
     */
    @ApiOperation(value = "添加管理员",notes = "正确code=200,错误code=400")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "aName",value = "管理员姓名",dataType = "string"),
            @ApiImplicitParam(name = "phone",value = "管理员电话",dataType = "string"),
            @ApiImplicitParam(name = "password",value = "管理员密码",dataType = "string"),
            @ApiImplicitParam(name = "mail",value = "管理员邮箱",dataType = "string"),
            @ApiImplicitParam(name = "adminType",value = "管理员类型",dataType = "integer")

    })
    @ApiResponses({
            @ApiResponse(code = 502,message = "sql处理异常"),
            @ApiResponse(code = 500,message = "后台查询有误！"),
            @ApiResponse(code = 200,message = "返回数据！")
    })
    @RequestMapping(value = "addAdAdmin",method = RequestMethod.POST)
    ReturnResult addAdAdmin(@RequestBody AdAdmin admin);


    /**
     * 验证手机号重复
     * @param phone
     * @return
     */
    @ApiOperation(value = "验证手机号重复",notes = "正确code=200,错误code=400")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "phone",value = "管理员电话",dataType = "string"),
    })
    @ApiResponses({
            @ApiResponse(code = 502,message = "sql处理异常"),
            @ApiResponse(code = 500,message = "手机号已存在！"),
            @ApiResponse(code = 200,message = "返回数据！")
    })
    @RequestMapping(value = "unqPhone/{phone}",method = RequestMethod.GET)
    ReturnResult unqPhone(@PathVariable String phone);

    /**
     * 根据id获取管理员信息
     * @param aid
     * @return
     */
    @ApiOperation(value = "根据id获取管理员信息",notes = "正确code=200,错误code=400")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "aid",value = "管理员id",dataType = "Integer"),
    })
    @ApiResponses({
            @ApiResponse(code = 502,message = "sql处理异常"),
            @ApiResponse(code = 500,message = "该对象不存在！"),
            @ApiResponse(code = 200,message = "返回数据！")
    })
    @RequestMapping(value = "getAdAdminByAid/{aid}",method = RequestMethod.GET)
    ReturnResult getAdAdminByAid(@PathVariable Integer aid);

    /**
     * 修改管理员
     * @param aid
     * @param phone
     * @param mail
     * @return
     */
    @ApiOperation(value = "修改管理员",notes = "正确code=200,错误code=400")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "aid",value = "管理员id",dataType = "Integer"),
            @ApiImplicitParam(name = "phone",value = "管理员手机号",dataType = "String"),
            @ApiImplicitParam(name = "mail",value = "管理员邮箱",dataType = "String")
    })
    @ApiResponses({
            @ApiResponse(code = 502,message = "sql处理异常"),
            @ApiResponse(code = 203,message = "没有修改数据！"),
            @ApiResponse(code = 200,message = "修改成功！")
    })
    @RequestMapping(value = "upAdAdmin",method = RequestMethod.GET)
    ReturnResult upAdAdmin(@RequestParam(value = "aid",required = true) Integer aid ,
                           @RequestParam(value = "phone",required = true)String phone,
                           @RequestParam(value = "mail",required = true)String mail);


    @ApiOperation(value = "删除管理员",notes = "正确code=200,错误code=400")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "aid",value = "管理员id",dataType = "Integer")
    })
    @ApiResponses({
            @ApiResponse(code = 502,message = "sql处理异常"),
            @ApiResponse(code = 203,message = "没有删除的数据！"),
            @ApiResponse(code = 200,message = "删除成功！")
    })
    @RequestMapping(value = "delAdAdmin/{aid}",method = RequestMethod.DELETE)
    ReturnResult delAdAdmin(@PathVariable Integer aid);
}
