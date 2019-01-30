package com.tianbao.points.app.controller.migration.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @desc 会员用户输入实体
 * @author lushusheng
 * @date 2019-1-28
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserMigrationInput {
    /**
     * 用户id
     */
    @NotNull(message = "用户id参数不能为空")
    private Long id;
    /**
     * 登录账号
     */
    @NotBlank(message = "登录账号参数不能为空")
    private String account;
    /**
     * 登录密码
     */
    @NotBlank(message = "登录密码参数不能为空")
    private String password;
    /**
     * 真实姓名
     */
    @NotBlank(message = "真实姓名参数不能为空")
    private String realName;
    /**
     * 身份证号
     */
    //@NotBlank(message = "身份证号参数不能为空")
    private String identityNumber;
    /**
     * 昵称
     */
    //@NotBlank(message = "昵称参数不能为空")
    private String nickName;
    /**
     * 头像url地址
     */
    //@NotBlank(message = "头像url地址参数不能为空")
    private String headImage;
    /**
     * 手机号码
     */
    //@NotBlank(message = "手机号码参数不能为空")
    private String phone;
    /**
     * 邮箱地址
     */
    //@NotBlank(message = "邮箱地址参数不能为空")
    private String email;
    /**
     * 省级地址
     */
    //@NotBlank(message = "省级地址参数不能为空")
    private String province;
    /**
     * 所属城市
     */
    //@NotBlank(message = "所属城市参数不能为空")
    private String city;
    /**
     * 详细地址
     */
    //@NotBlank(message = "详细地址参数不能为空")
    private String address;
    /**
     * 性别
     */
    //@NotNull(message = "性别参数不能为空")
    private Integer gender;
    /**
     * 会员等级id
     */
    @NotNull(message = "会员等级id参数不能为空")
    private Long rankId;
    /**
     * 注册提问，id值为1~5
     */
    //@NotNull(message = "注册提问id参数不能为空")
    private Integer questionId;
    /**
     * 提问的答案
     */
    //@NotBlank(message = "提问的答案参数不能为空")
    private String answer;
    /**
     * 上次登录ip地址
     */
    //@NotBlank(message = "上次登录ip地址参数不能为空")
    private String lastLoginIp;
    /**
     * 本次登录ip地址
     */
    //@NotBlank(message = "本次登录ip地址参数不能为空")
    private String currentLoginIp;
    /**
     * 上次登录的时间
     */
    //@NotBlank(message = "上次登录的时间参数不能为空")
    private String lastLoginTime;
    /**
     * 本次登录的时间
     */
    //@NotBlank(message = "本次登录的时间参数不能为空")
    private String currentLoginTime;
    /**
     * 发证时间
     */
    @NotBlank(message = "发证时间参数不能为空")
    private String certificationTime;
}
