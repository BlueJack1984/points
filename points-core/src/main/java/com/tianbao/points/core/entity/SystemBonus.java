package com.tianbao.points.core.entity;

import java.util.Date;

public class SystemBonus {
    private Long id;

    private Double startPoints;

    private Double endPoints;

    private Double ratio;

    private Integer visible;

    private Integer status;

    private Date createTime;

    private Long createUserId;

    private Date updateTime;

    private Long updateUserId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getStartPoints() {
        return startPoints;
    }

    public void setStartPoints(Double startPoints) {
        this.startPoints = startPoints;
    }

    public Double getEndPoints() {
        return endPoints;
    }

    public void setEndPoints(Double endPoints) {
        this.endPoints = endPoints;
    }

    public Double getRatio() {
        return ratio;
    }

    public void setRatio(Double ratio) {
        this.ratio = ratio;
    }

    public Integer getVisible() {
        return visible;
    }

    public void setVisible(Integer visible) {
        this.visible = visible;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(Long updateUserId) {
        this.updateUserId = updateUserId;
    }
}