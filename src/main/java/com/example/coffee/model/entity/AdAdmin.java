package com.example.coffee.model.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * ad_admin
 * @author 
 */
public class AdAdmin implements Serializable {
    /**
     * 管理员id
     */
    private Integer aid;

    /**
     * 管理员姓名
     */
    private String aName;

    /**
     * 登录手机号
     */
    private String phone;

    /**
     * 登录密码
     */
    private String password;

    /**
     * 用户头像
     */
    private String avatar;

    /**
     * 用户描述
     */
    private String introduction;

    /**
     * 用户状态
     */
    private Integer status;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 最后被操作时间
     */
    private Date updateTime;

    private Integer adminType;

    private boolean state=false;

    private String mail;

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public Integer getAdminType() {
        return adminType;
    }

    public void setAdminType(Integer adminType) {
        this.adminType = adminType;
    }

    private static final long serialVersionUID = 1L;

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getaName() {
        return aName;
    }

    public void setaName(String aName) {
        this.aName = aName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "AdAdmin{" +
                "aid=" + aid +
                ", aName='" + aName + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", avatar='" + avatar + '\'' +
                ", introduction='" + introduction + '\'' +
                ", status=" + status +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", adminType=" + adminType +
                ", state=" + state +
                ", mail='" + mail + '\'' +
                '}';
    }
}