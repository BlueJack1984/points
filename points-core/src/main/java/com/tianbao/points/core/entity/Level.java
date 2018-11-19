package com.tianbao.points.core.entity;

public class Level {
    private Integer id;

    private String name;

    private String othername;

    private Integer points;

    private Double money;

    private Double maxaward;

    private Integer orderid;

    private String color;

    private String userwarrant;

    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getOthername() {
        return othername;
    }

    public void setOthername(String othername) {
        this.othername = othername == null ? null : othername.trim();
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Double getMaxaward() {
        return maxaward;
    }

    public void setMaxaward(Double maxaward) {
        this.maxaward = maxaward;
    }

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color == null ? null : color.trim();
    }

    public String getUserwarrant() {
        return userwarrant;
    }

    public void setUserwarrant(String userwarrant) {
        this.userwarrant = userwarrant == null ? null : userwarrant.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }
}