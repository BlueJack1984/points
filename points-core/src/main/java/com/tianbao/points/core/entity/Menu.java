package com.tianbao.points.core.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 菜单
 * @author lushusheng 2018-11-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "menu")
public class Menu implements Serializable {
    @Id
    private Integer id;
    private String type;
    private String title;
    private String class;
    private String icon;
    private String tips;
    private String url;
    private String description;
    private String password;
    private String display;
    private Integer orderid;
}