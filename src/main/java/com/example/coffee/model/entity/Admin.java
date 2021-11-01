package com.example.coffee.model.entity;

/**
 * @version v1.0
 * @ProjectName: coffee
 * @ClassName: Admin
 * @Description: TODO(一句话描述该类的功能)
 * @Author: 李茜骏
 * @Date: 2021/9/24 10:26
 */
public class Admin extends AdAdmin{

    private String phone;

    /**
     * 登录密码
     */
    private String password;

    @Override
    public String getPhone() {
        return phone;
    }

    @Override
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
