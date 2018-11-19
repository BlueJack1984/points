package com.tianbao.points.core.entity;

import java.util.Date;

public class MoneyUse {
    private Integer id;

    private String username;

    private String newusername;

    private Double moneyuse;

    private Double money;

    private Double moneybefor;

    private Double emoney;

    private Double emoneybefor;

    private Integer type;

    private Date posttime;

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

    public String getNewusername() {
        return newusername;
    }

    public void setNewusername(String newusername) {
        this.newusername = newusername == null ? null : newusername.trim();
    }

    public Double getMoneyuse() {
        return moneyuse;
    }

    public void setMoneyuse(Double moneyuse) {
        this.moneyuse = moneyuse;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Double getMoneybefor() {
        return moneybefor;
    }

    public void setMoneybefor(Double moneybefor) {
        this.moneybefor = moneybefor;
    }

    public Double getEmoney() {
        return emoney;
    }

    public void setEmoney(Double emoney) {
        this.emoney = emoney;
    }

    public Double getEmoneybefor() {
        return emoneybefor;
    }

    public void setEmoneybefor(Double emoneybefor) {
        this.emoneybefor = emoneybefor;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getPosttime() {
        return posttime;
    }

    public void setPosttime(Date posttime) {
        this.posttime = posttime;
    }
}