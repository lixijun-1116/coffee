package com.example.coffee.model.entity;

import io.swagger.annotations.ApiModel;

@ApiModel
public class Right {

    private Integer rid,rlevel,subid,status;
    private String rname,path;

    @Override
    public String toString() {
        return "Right{" +
                "rid=" + rid +
                ", rlevel=" + rlevel +
                ", subid=" + subid +
                ", status=" + status +
                ", rname='" + rname + '\'' +
                ", path='" + path + '\'' +
                '}';
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getRlevel() {
        return rlevel;
    }

    public void setRlevel(Integer rlevel) {
        this.rlevel = rlevel;
    }

    public Integer getSubid() {
        return subid;
    }

    public void setSubid(Integer subid) {
        this.subid = subid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
