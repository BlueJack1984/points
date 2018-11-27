package com.tianbao.points.core.entity;

import com.tianbao.points.core.entity.base.ObjectPO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.persistence.Table;


/**
 * @desc 权限实体
 * @author lushusheng
 * @date 2018-11-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "authority")
public class Authority extends ObjectPO<Long> {

    /**
     * 权限编号
     */
    private String code;
    /**
     * 权限名称
     */
    private String name;
    /**
     * 权限请求对应的url地址
     */
    private String url;
    /**
     * 权限允许的名称
     */
    private String permission;
    /**
     * 权限类型，0表示菜单，1表示按钮
     */
    private Integer type;
    /**
     * 权限描述
     */
    private String description;
}