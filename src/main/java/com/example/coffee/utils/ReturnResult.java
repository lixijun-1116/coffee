package com.example.coffee.utils;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @version v1.0
 * @ProjectName: coffee
 * @ClassName: ReturnResult
 * @Description: TODO(一句话描述该类的功能)
 * @Author: 李茜骏
 * @Date: 2020/4/21 22:45
 */
@ApiModel
public class ReturnResult {
    @ApiModelProperty(value = "状态码")
    private String code;
    @ApiModelProperty(value = "返回的信息")
    private String info;
    @ApiModelProperty(value = "回传的数据")
    private Object data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
