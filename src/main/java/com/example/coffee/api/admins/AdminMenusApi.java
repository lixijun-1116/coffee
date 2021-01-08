package com.example.coffee.api.admins;

import com.example.coffee.model.dto.LoginForm;
import com.example.coffee.utils.ReturnResult;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Api(tags = "菜单管理")
public interface AdminMenusApi {
    @ApiOperation(value = "获取菜单",notes = "正确code=200,错误code=400")
    @ApiResponses({
            @ApiResponse(code = 200,message = "成功"),
            @ApiResponse(code = 403,message = "缺失token信息！"),
            @ApiResponse(code = 502,message = "sql error！")
    })
    @RequestMapping(value = "queryMenus",method = RequestMethod.GET)
    public ReturnResult queryMenus(HttpServletRequest request);
}
