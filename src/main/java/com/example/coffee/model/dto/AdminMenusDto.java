package com.example.coffee.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @version v1.0
 * @ProjectName: coffee
 * @ClassName: AdminMenusDto
 * @Description: TODO(一句话描述该类的功能)
 * @Author: 李茜骏
 * @Date: 2020/4/22 10:37
 */
@ApiModel
public class AdminMenusDto {
    @ApiModelProperty(name = "mid")
    private Integer mid;
    @ApiModelProperty(name = "content")
    private String content;
    @ApiModelProperty(name = "children")
    private List<Object> children;
    @ApiModelProperty(name = "icon")
    private String icon;
    @ApiModelProperty(name = "path")
    private String path;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Object> getChildren() {
        return children;
    }

    public void setChildren(List<Object> children) {
        this.children = children;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
