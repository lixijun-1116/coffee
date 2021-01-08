package com.example.coffee.api.admins;

import com.example.coffee.utils.ReturnResult;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Api(tags = "权限管理")
public interface RightsApi {

    @ApiOperation(value = "获取所有权限",notes = "正确code=200,错误code=400")
    @ApiResponses({
            @ApiResponse(code = 400,message = "请求错误"),
            @ApiResponse(code = 422,message = "验证错误！"),
            @ApiResponse(code = 200,message = "返回数据！")
    })
    @RequestMapping(value = "queryRights",method = RequestMethod.GET)
    ReturnResult queryRights();

    @ApiOperation(value = "获取所有角色信息",notes = "list(tree)形式")
    @ApiResponses({
            @ApiResponse(code = 400,message = "请求错误"),
            @ApiResponse(code = 422,message = "验证错误！"),
            @ApiResponse(code = 200,message = "返回数据！")
    })
    @RequestMapping(value = "queryRoles",method = RequestMethod.GET)
    ReturnResult queryRoles();

    @ApiOperation(value = "删除角色的权限",notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "roleId",value = "角色id",paramType = "path"),
            @ApiImplicitParam(name = "rightId",value = "权限id",paramType = "path")
    })
    @ApiResponses({
            @ApiResponse(code = 502,message = "后台查询异常"),
            @ApiResponse(code = 403,message = "请求权限有误"),
            @ApiResponse(code = 200,message = "返回数据")
    })
    @RequestMapping(value = "delRight/role:/{roleId}/right:/{rightId}",method = RequestMethod.DELETE)
    ReturnResult delRight(@PathVariable("roleId")int roleId, @PathVariable("rightId")int rightId);


    @ApiOperation(value = "修改角色的权限",notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "roleId",value = "角色id",paramType = "path"),
            @ApiImplicitParam(name = "rightIds",value = "权限id的数组",paramType = "query")
    })
    @ApiResponses({
            @ApiResponse(code = 502,message = "后台查询异常"),
            @ApiResponse(code = 403,message = "请求权限有误"),
            @ApiResponse(code = 200,message = "返回数据")
    })
    @RequestMapping(value = "updRight/role:/{roleId}/{rightIds}",method = RequestMethod.POST)
    ReturnResult updRight(@PathVariable("roleId")int roleId,@PathVariable("rightIds")String rightIds);


    @ApiOperation(value = "获取所有权限",notes = "Tree形式")
    @ApiResponses({
            @ApiResponse(code = 400,message = "请求错误"),
            @ApiResponse(code = 422,message = "验证错误"),
            @ApiResponse(code = 200,message = "返回数据")
    })
    @RequestMapping(value = "queryRightsTree",method = RequestMethod.GET)
    ReturnResult queryRightsTree();
}
