package com.tianbao.points.core.entity;

import java.util.Date;

public class Point {
    private Integer id;

    private Integer pid;

    private String username;

    private Double radios;

    private Double pertotal;

    private Double curtotal;

    private String checkinfo;

    private Integer status;

    private Date posttime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Double getRadios() {
        return radios;
    }

    public void setRadios(Double radios) {
        this.radios = radios;
    }

    public Double getPertotal() {
        return pertotal;
    }

    public void setPertotal(Double pertotal) {
        this.pertotal = pertotal;
    }

    public Double getCurtotal() {
        return curtotal;
    }

    public void setCurtotal(Double curtotal) {
        this.curtotal = curtotal;
    }

    public String getCheckinfo() {
        return checkinfo;
    }

    public void setCheckinfo(String checkinfo) {
        this.checkinfo = checkinfo == null ? null : checkinfo.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getPosttime() {
        return posttime;
    }

    public void setPosttime(Date posttime) {
        this.posttime = posttime;
    }
}