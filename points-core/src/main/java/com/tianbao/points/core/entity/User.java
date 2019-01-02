package com.tianbao.points.core.entity;

import com.tianbao.points.core.entity.base.ObjectPO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Table;
import java.util.Date;

/**
 * @desc 用户实体
 * @author lushusheng
 * @date 2018-11-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "user")
public class User extends ObjectPO<Long> {

    /**
     * 用户登录账号
     */
    private String account;
    /**
     * 用户登录密码
     */
    private String password;
    /**
     * 超级密码，只有顶级管理员角色可以使用
     */
    private String superPassword;
    /**
     * 真实姓名
     */
    private String realName;
    /**
     * 身份证号
     */
    private String identityNumber;
    /**
     * 昵称
     */
    private String nickName;
    /**
     * 头像，存储url地址
     */
    private String headImage;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 邮箱地址
     */
    private String email;
    /**
     * 性别
     */
    private Integer gender;
    /**
     * 会员等级，关联rank表
     */
    private Long rankId;
    /**
     * 注册设置的提问
     */
    private Integer questionId;
    /**
     * 用户输入的提问答案
     */
    private String answer;
    /**
     * 上一次（最近）登录系统的ip地址
     */
    private String lastLoginIp;
    /**
     * 上一次（最近）登录系统的时间
     */
    private Date lastLoginTime;
    /**
     * 当前登录系统的ip地址
     */
    private String currentLoginIp;
    /**
     * 当前登录系统的时间
     */
    private Date currentLoginTime;
    /**
     * 省级
     */
    private String province;
    /**
     * 市级
     */
    private String city;
    /**
     * 地址
     */
    private String address;
    /**
     * 发证时间
     */
    private Date certificationTime;

}