package com.example.coffee.api.admins;

import com.example.coffee.model.entity.Discovery;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;

@Api(tags = "DiscoveryApi")
public interface DiscoveryApi {
    @ApiOperation(value = "添加发现",notes = "正确code=200,错误code=400")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "discoveryId",value = "Id",dataType = "String",example = "1"),
            @ApiImplicitParam(name = "author",value = "作者id",dataType = "String",example = "1"),
            @ApiImplicitParam(name = "title",value = "标题",dataType = "String",example = "IP"),
            @ApiImplicitParam(name = "cover",value = "图片",dataType = "String",example = "123456"),
            @ApiImplicitParam(name = "content",value = "内容",dataType = "String",example = "发射东风水库")
    })
    @ApiResponses({
            @ApiResponse(code = 200,message = "添加成功"),
            @ApiResponse(code = 400,message = "添加失败！")
    })
    @RequestMapping(value = "/addDiscovery",method = RequestMethod.POST)
    void addDiscovery(Discovery discovery, HttpServletResponse response);

    @ApiOperation(value = "修改发现",notes = "正确code=200,错误code=400")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "discoveryId",value = "Id",dataType = "String",example = "1"),
            @ApiImplicitParam(name = "status",value = "状态 0不显示 1显示 2删除",dataType = "String",example = "0"),
            @ApiImplicitParam(name = "title",value = "标题",dataType = "String",example = "购买力平价13"),
            @ApiImplicitParam(name = "cover",value = "图片",dataType = "String",example = "12345678979"),
            @ApiImplicitParam(name = "content",value = "内容",dataType = "String",example = "撒顶顶顶12122")
    })
    @ApiResponses({
            @ApiResponse(code = 200,message = "修改成功"),
            @ApiResponse(code = 400,message = "修改失败！")
    })
    @RequestMapping(value = "/updateDiscovery",method = RequestMethod.POST)
    void updateDiscovery(Discovery discovery, HttpServletResponse response);

    @ApiOperation(value = "删除发现",notes = "正确code=200,错误code=400")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "discoveryId",value = "Id",dataType = "String",example = "1")
    })
    @ApiResponses({
            @ApiResponse(code = 200,message = "删除成功"),
            @ApiResponse(code = 400,message = "删除失败！")
    })
    @RequestMapping(value = "/deleteDiscovery",method = RequestMethod.POST)
    void deleteDiscovery(String discoveryId, HttpServletResponse response);

}
