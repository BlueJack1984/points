package com.tianbao.points.core.entity.base;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 定义中间层持久化对象
 * @author lushusheng
 * @date 2018-11-27
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class ObjectPO<K> extends BasicPO<K> {
    /**
     * 创建时间
     */
    protected Date createTime;
    /**
     * 创建者id
     */
    protected Long createUserId;
    /**
     * 更新时间
     */
    protected Date updateTime;
    /**
     * 更新者id
     */
    protected Long updateUserId;
}