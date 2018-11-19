package com.tianbao.points.core.entity;

import java.util.Date;

public class UpPosition {
    private Integer id;

    private String user;

    private Integer oldlevel;

    private Integer newlevel;

    private Date uptime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user == null ? null : user.trim();
    }

    public Integer getOldlevel() {
        return oldlevel;
    }

    public void setOldlevel(Integer oldlevel) {
        this.oldlevel = oldlevel;
    }

    public Integer getNewlevel() {
        return newlevel;
    }

    public void setNewlevel(Integer newlevel) {
        this.newlevel = newlevel;
    }

    public Date getUptime() {
        return uptime;
    }

    public void setUptime(Date uptime) {
        this.uptime = uptime;
    }
}