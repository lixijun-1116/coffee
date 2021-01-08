package com.example.coffee.model.dto;

import java.util.Date;

/**
 * @version v1.0
 * @ProjectName: coffee
 * @ClassName: UserAdminVo
 * @Description: TODO(一句话描述该类的功能)
 * @Author: 李茜骏
 * @Date: 2020/4/14 16:34
 */
public class UserAdminVo {

    private String id,uName,phone,address;
    private Integer gender,vip,status;
    private Date createTime;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getVip() {
        return vip;
    }

    public void setVip(Integer vip) {
        this.vip = vip;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "UserAdminVo{" +
                "id='" + id + '\'' +
                ", uName='" + uName + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", gender=" + gender +
                ", vip=" + vip +
                ", status=" + status +
                ", createTime=" + createTime +
                '}';
    }
}
