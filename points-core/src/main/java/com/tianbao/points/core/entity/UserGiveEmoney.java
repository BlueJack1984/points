package com.tianbao.points.core.entity;

import java.util.Date;

public class UserGiveEmoney {
    private Integer id;

    private String username;

    private Double moneybefor;

    private Double givemoney;

    private Date posttime;

    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Double getMoneybefor() {
        return moneybefor;
    }

    public void setMoneybefor(Double moneybefor) {
        this.moneybefor = moneybefor;
    }

    public Double getGivemoney() {
        return givemoney;
    }

    public void setGivemoney(Double givemoney) {
        this.givemoney = givemoney;
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