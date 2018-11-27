package com.tianbao.points.core.entity;

import java.util.Date;

public class Stock {
    private Long id;

    private Date publishTime;

    private Integer status;

    private Double shOpenExponent;

    private Double shCloseExponent;

    private Double shMaxExponent;

    private Double shMinExponent;

    private Double tbOpenExponent;

    private Double tbCloseExponent;

    private Double tbMaxExponent;

    private Double tbMinExponent;

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

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Double getShOpenExponent() {
        return shOpenExponent;
    }

    public void setShOpenExponent(Double shOpenExponent) {
        this.shOpenExponent = shOpenExponent;
    }

    public Double getShCloseExponent() {
        return shCloseExponent;
    }

    public void setShCloseExponent(Double shCloseExponent) {
        this.shCloseExponent = shCloseExponent;
    }

    public Double getShMaxExponent() {
        return shMaxExponent;
    }

    public void setShMaxExponent(Double shMaxExponent) {
        this.shMaxExponent = shMaxExponent;
    }

    public Double getShMinExponent() {
        return shMinExponent;
    }

    public void setShMinExponent(Double shMinExponent) {
        this.shMinExponent = shMinExponent;
    }

    public Double getTbOpenExponent() {
        return tbOpenExponent;
    }

    public void setTbOpenExponent(Double tbOpenExponent) {
        this.tbOpenExponent = tbOpenExponent;
    }

    public Double getTbCloseExponent() {
        return tbCloseExponent;
    }

    public void setTbCloseExponent(Double tbCloseExponent) {
        this.tbCloseExponent = tbCloseExponent;
    }

    public Double getTbMaxExponent() {
        return tbMaxExponent;
    }

    public void setTbMaxExponent(Double tbMaxExponent) {
        this.tbMaxExponent = tbMaxExponent;
    }

    public Double getTbMinExponent() {
        return tbMinExponent;
    }

    public void setTbMinExponent(Double tbMinExponent) {
        this.tbMinExponent = tbMinExponent;
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