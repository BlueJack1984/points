package com.tianbao.points.app.dto.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @desc 新建保存会员实体信息
 * @author lushusheng
 * @date 2018-12-17
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInput {

    /**
     * 证书编号（会员账号）
     */
    @NotBlank(message = "证书编号不能为空")
    @Size(min = 1, max = 16, message = "登录账号长度有误，规范长度：1~16位")
    private String account;
    /**
     * 真实姓名
     */
    @NotBlank(message = "真实姓名不能为空")
    private String realName;
    /**
     * 会员性别
     */
    @NotNull(message = "会员性别不能为空")
    private Integer gender;
    /**
     * 会员级别id
     */
    @NotNull(message = "会员级别id不能为空")
    private Long rankId;
    /**
     * 身份证号
     */
    @NotBlank(message = "身份证号不能为空")
    private String identityNumber;
    /**
     * 登录密码
     */
    @NotBlank(message = "登录密码不能为空")
    @Size(min=6, max=18, message="密码长度有误,长度：6-18位")
    private String password;
    /**
     * 重复确认登录密码
     */
    @NotBlank(message = "重复确认登录密码不能为空")
    @Size(min=6, max=18, message="密码长度有误,长度：6-18位")
    private String surePassword;
    /**
     * 手机号
     */
    @NotBlank(message = "手机号不能为空")
    private String phone;
    /**
     * 省级
     */
    @NotBlank(message = "省级不能为空")
    private String province;
    /**
     * 市级
     */
    @NotBlank(message = "市级不能为空")
    private String city;
    /**
     * 详细地址
     */
    @NotBlank(message = "详细地址不能为空")
    private String address;
    /**
     * 发证日期
     */
    @NotBlank(message = "发证日期不能为空")
    private String certificationTime;
}
