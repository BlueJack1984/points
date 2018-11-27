package com.tianbao.points.core.entity;

import com.tianbao.points.core.entity.base.ObjectPO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Table;


/**
 * @desc 职位实体
 * @author lushusheng
 * @date 2018-11-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "position")
public class Position extends ObjectPO<Long> {

    /**
     * 职位名称
     */
    private String name;
    /**
     * 职位所属部门id
     */
    private Long departmentId;
    /**
     * 职位的相关描述
     */
    private String description;
}