package com.tianbao.points.core.entity;

public class WebConfig {
    private String varname;

    private Short siteid;

    private String varinfo;

    private Short vargroup;

    private String vartype;

    private Short orderid;

    private String varvalue;

    public String getVarname() {
        return varname;
    }

    public void setVarname(String varname) {
        this.varname = varname == null ? null : varname.trim();
    }

    public Short getSiteid() {
        return siteid;
    }

    public void setSiteid(Short siteid) {
        this.siteid = siteid;
    }

    public String getVarinfo() {
        return varinfo;
    }

    public void setVarinfo(String varinfo) {
        this.varinfo = varinfo == null ? null : varinfo.trim();
    }

    public Short getVargroup() {
        return vargroup;
    }

    public void setVargroup(Short vargroup) {
        this.vargroup = vargroup;
    }

    public String getVartype() {
        return vartype;
    }

    public void setVartype(String vartype) {
        this.vartype = vartype == null ? null : vartype.trim();
    }

    public Short getOrderid() {
        return orderid;
    }

    public void setOrderid(Short orderid) {
        this.orderid = orderid;
    }

    public String getVarvalue() {
        return varvalue;
    }

    public void setVarvalue(String varvalue) {
        this.varvalue = varvalue == null ? null : varvalue.trim();
    }
}