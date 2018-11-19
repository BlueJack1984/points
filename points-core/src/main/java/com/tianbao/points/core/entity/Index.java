package com.tianbao.points.core.entity;

import java.util.Date;

public class Index {
    private Integer id;

    private String sIndex;

    private String tIndex;

    private Date postdate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getsIndex() {
        return sIndex;
    }

    public void setsIndex(String sIndex) {
        this.sIndex = sIndex == null ? null : sIndex.trim();
    }

    public String gettIndex() {
        return tIndex;
    }

    public void settIndex(String tIndex) {
        this.tIndex = tIndex == null ? null : tIndex.trim();
    }

    public Date getPostdate() {
        return postdate;
    }

    public void setPostdate(Date postdate) {
        this.postdate = postdate;
    }
}