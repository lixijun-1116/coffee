package com.example.coffee.model.entity;

/**
 * @version v1.0
 * @ProjectName: coffee
 * @ClassName: AdminMenus
 * @Description: TODO(一句话描述该类的功能)
 * @Author: 李茜骏
 * @Date: 2020/4/22 10:35
 */
public class AdminMenus {

    private String menuId,content,subId,iconPth;
    private Integer level ,index;

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSubId() {
        return subId;
    }

    public void setSubId(String subId) {
        this.subId = subId;
    }

    public String getIconPth() {
        return iconPth;
    }

    public void setIconPth(String iconPth) {
        this.iconPth = iconPth;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }
}
