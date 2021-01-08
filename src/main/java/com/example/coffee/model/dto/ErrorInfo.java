package com.example.coffee.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class ErrorInfo<T> {

    public static final Integer ERROR=22;
    public static final Integer WARN=21;

    @ApiModelProperty
    private Integer code;
    @ApiModelProperty
    private String message;
    @ApiModelProperty(value = "这是导致异常的那个请求")
    private String url;
    @ApiModelProperty
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
