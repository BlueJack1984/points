package com.tianbao.points.core.entity;

import java.util.Date;

public class PointList {
    private Integer id;

    private Double radios;

    private Double pertotal;

    private Double curtotal;

    private String checkinfo;

    private Date posttime;

    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Date getPosttime() {
        return posttime;
    }

    public void setPosttime(Date posttime) {
        this.posttime = posttime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}