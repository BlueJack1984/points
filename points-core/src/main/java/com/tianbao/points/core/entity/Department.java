package com.tianbao.points.core.entity;

import com.tianbao.points.core.entity.base.ObjectPO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.persistence.Table;



/**
 * @desc 部门实体
 * @author lushusheng
 * @date 2018-11-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "department")
public class Department extends ObjectPO<Long> {

    /**
     * 部门名称
     */
    private String name;
    /**
     * 直接上级部门id
     */
    private Long parentId;
    /**
     * 部门描述
     */
    private String description;
}