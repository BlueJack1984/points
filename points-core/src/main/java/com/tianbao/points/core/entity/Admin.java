package com.tianbao.points.core.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author lushusheng
 * @Date 2018-11-20
 * @Desc 定义管理员表对应的持久化实体
 */

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "admin", schema = "test")
public class Admin implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Short id;
    /**
     * 用户名称
     */
    @Column(name = "user_name")
    private String userName;
    /**
     * 密码
     */
    private String password;
    /**
     * 用户的超级密码
     */
    @Column(name = "super_password")
    private String superPassword;
    /**
     * 用户昵称
     */
    @Column(name = "nick_name")
    private String nickName;
    /**
     * 用户昵称
     */
    private Boolean question;
    /**
     * 用户昵称
     */
    private String answer;
    /**
     * 用户昵称
     */
    @Column(name = "nick_name")
    private Boolean levelName;
    /**
     * 用户昵称
     */
    @Column(name = "nick_name")
    private String checkAdmin;
    /**
     * 用户昵称
     */
    @Column(name = "nick_name")
    private String loginIP;
    /**
     * 用户昵称
     */
    @Column(name = "nick_name")
    private Integer loginTime;
    /**
     * 用户昵称
     */
    private String phone;
    /**
     * 用户昵称
     */
    private String email;
    /**
     * 用户昵称
     */
    private String zw;
    /**
     * 用户昵称
     */
    @Column(name = "nick_name")
    private Integer orderId;
    /**
     * 用户昵称
     */
    @Column(name = "nick_name")
    private String userId;

}