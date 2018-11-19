package com.tianbao.points.core.entity;

public class AdminGroup {
    private Byte id;

    private String groupname;

    private String checkinfo;

    private String adminwarrant;

    private String description;

    public Byte getId() {
        return id;
    }

    public void setId(Byte id) {
        this.id = id;
    }

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname == null ? null : groupname.trim();
    }

    public String getCheckinfo() {
        return checkinfo;
    }

    public void setCheckinfo(String checkinfo) {
        this.checkinfo = checkinfo == null ? null : checkinfo.trim();
    }

    public String getAdminwarrant() {
        return adminwarrant;
    }

    public void setAdminwarrant(String adminwarrant) {
        this.adminwarrant = adminwarrant == null ? null : adminwarrant.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}