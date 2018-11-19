package com.tianbao.points.core.entity;

public class FailedLogin {
    private String username;

    private String ip;

    private Integer time;

    private Boolean num;

    private Boolean isadmin;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Boolean getNum() {
        return num;
    }

    public void setNum(Boolean num) {
        this.num = num;
    }

    public Boolean getIsadmin() {
        return isadmin;
    }

    public void setIsadmin(Boolean isadmin) {
        this.isadmin = isadmin;
    }
}