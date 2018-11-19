package com.tianbao.points.core.entity;

import java.util.Date;

public class UpLevel {
    private Integer id;

    private String user;

    private String upuser;

    private Integer oldlevel;

    private Integer newlevel;

    private Integer points;

    private Date uptime;

    private String checkinfo;

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

    public String getUpuser() {
        return upuser;
    }

    public void setUpuser(String upuser) {
        this.upuser = upuser == null ? null : upuser.trim();
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

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Date getUptime() {
        return uptime;
    }

    public void setUptime(Date uptime) {
        this.uptime = uptime;
    }

    public String getCheckinfo() {
        return checkinfo;
    }

    public void setCheckinfo(String checkinfo) {
        this.checkinfo = checkinfo == null ? null : checkinfo.trim();
    }
}