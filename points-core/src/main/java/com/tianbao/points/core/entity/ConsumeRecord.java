package com.tianbao.points.core.entity;

import com.tianbao.points.core.entity.base.ObjectPO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Table;
import java.util.Date;

/**
 * @desc 权限实体
 * @author lushusheng
 * @date 2018-11-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "consume_record")
public class ConsumeRecord extends ObjectPO<Long> {
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 地区
     */
    private String district;
    /**
     * 基地名称
     */
    private String locationName;
    /**
     * 消费金额
     */
    private Double amount;
    /**
     * 消费时间
     */
    private Date consumeTime;
}
