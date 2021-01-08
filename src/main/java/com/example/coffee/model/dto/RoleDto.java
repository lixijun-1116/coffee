package com.example.coffee.model.dto;

import io.swagger.annotations.ApiModel;

import java.util.List;

@ApiModel
public class RoleDto {

    private Integer rid,status;
    private String roleName,roleDesc;
    private List<RightDtoFirst> rights;

    @Override
    public String toString() {
        return "RoleDto{" +
                "rid=" + rid +
                ", status=" + status +
                ", roleName='" + roleName + '\'' +
                ", roleDesc='" + roleDesc + '\'' +
                ", rights=" + rights +
                '}';
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public List<RightDtoFirst> getRights() {
        return rights;
    }

    public void setRights(List<RightDtoFirst> rights) {
        this.rights = rights;
    }
}
