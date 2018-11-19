package com.tianbao.points.core.entity;

import java.util.Date;

public class PointTx {
    private Integer id;

    private String username;

    private Double userPoints;

    private Double oldPoints;

    private Double newPoints;

    private Double money;

    private String bankname;

    private String banknumber;

    private String uname;

    private Date sqtime;

    private Date paytime;

    private Integer status;

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

    public Double getUserPoints() {
        return userPoints;
    }

    public void setUserPoints(Double userPoints) {
        this.userPoints = userPoints;
    }

    public Double getOldPoints() {
        return oldPoints;
    }

    public void setOldPoints(Double oldPoints) {
        this.oldPoints = oldPoints;
    }

    public Double getNewPoints() {
        return newPoints;
    }

    public void setNewPoints(Double newPoints) {
        this.newPoints = newPoints;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public String getBankname() {
        return bankname;
    }

    public void setBankname(String bankname) {
        this.bankname = bankname == null ? null : bankname.trim();
    }

    public String getBanknumber() {
        return banknumber;
    }

    public void setBanknumber(String banknumber) {
        this.banknumber = banknumber == null ? null : banknumber.trim();
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname == null ? null : uname.trim();
    }

    public Date getSqtime() {
        return sqtime;
    }

    public void setSqtime(Date sqtime) {
        this.sqtime = sqtime;
    }

    public Date getPaytime() {
        return paytime;
    }

    public void setPaytime(Date paytime) {
        this.paytime = paytime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}