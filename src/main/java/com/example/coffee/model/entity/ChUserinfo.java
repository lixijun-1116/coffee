package com.example.coffee.model.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * ch_userinfo
 * @author 
 */
public class ChUserinfo implements Serializable {
    /**
     * 用户id
     */
    private String userId;

    /**
     * 用户昵称
     */
    private String uName;

    /**
     * 用户年龄
     */
    private Integer age;

    /**
     * 0男 1女
     */
    private Integer gender;

    /**
     * 用户头像
     */
    private String avatar;

    /**
     * 用户地址
     */
    private String address;

    /**
     * 个人签名
     */
    private String description;

    /**
     * 0普通用户 1会员
     */
    private Integer vip;

    /**
     * 会员到期时间 按照整日0点计算
     */
    private Date expirationTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }



    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getVip() {
        return vip;
    }

    public void setVip(Integer vip) {
        this.vip = vip;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public Date getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(Date expirationTime) {
        this.expirationTime = expirationTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "ChUserinfo{" +
                "userId='" + userId + '\'' +
                ", uName='" + uName + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", avatar='" + avatar + '\'' +
                ", address='" + address + '\'' +
                ", description='" + description + '\'' +
                ", vip=" + vip +
                ", expirationTime=" + expirationTime +
                ", updateTime=" + updateTime +
                '}';
    }
}