package com.tianbao.points.app.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @desc 修改个人信息的输入实体
 * @author lushusheng
 * @date 2019-5-9
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonalInfoInput {

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
     * 身份证号
     */
    @NotBlank(message = "身份证号不能为空")
    private String identityNumber;
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
}
