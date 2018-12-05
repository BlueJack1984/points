package com.tianbao.points.admin.dto.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @desc 新建管理员信息输入实体
 * @author lushusheng
 * @date 2018-12-05
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminInput {

    /**
     * 管理员用户登录账号
     */
    @NotBlank(message="管理员用户账号不能为空")
    private String account;
    /**
     * 管理员用户密码
     */
    //@NotBlank(message="管理员用户密码不能为空")
    private String password;
    /**
     * 管理员用户密码确认
     */
    //@NotBlank(message="密码确认不能为空")
    private String surePassword;
    /**
     * 管理员用户角色id
     */
    @NotNull(message=" 角色id不能为空")
    private Long role_id;
    /**
     * 管理员用户真实姓名
     */
    @NotBlank(message=" 真实姓名不能为空")
    private String realName;
    /**
     * 管理员身份证号
     */
    @NotBlank(message="身份证号不能为空")
    private String identityNumber;
    /**
     * 管理员用户电话号码
     */
    //@NotBlank(message=" 电话号码不能为空")
    private String phone;
    /**
     * 管理员用户邮箱
     */
    //@NotBlank(message=" 邮箱不能为空")
    private String email;
    /**
     * 管理员用户排序编号
     */
    @NotNull(message="排序编号不能为空")
    private Integer order;
}
