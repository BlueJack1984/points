package com.tianbao.points.core.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author lushusheng
 * @Date 2018-11-20
 * @Desc 定义管理员表对应的持久化实体
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "admin")
public class Admin implements Serializable {
    @Id
    private Short id;
    private String userName;
    private String password;
    private String superPassword;
    private String nickName;
    private Boolean question;
    private String answer;
    private Boolean levelName;
    private String checkAdmin;
    private String loginIP;
    private Integer loginTime;
    private String phone;
    private String email;
    private String zw;
    private Integer orderId;
    private String userId;

}