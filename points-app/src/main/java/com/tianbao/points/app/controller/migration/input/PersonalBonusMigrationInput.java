package com.tianbao.points.app.controller.migration.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @desc 个人积分输入实体
 * @author lushusheng
 * @date 2019-1-28
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonalBonusMigrationInput {

    /**
     * 个人积分id
     */
    @NotNull(message = "个人积分id参数不能为空")
    private Long id;
    /**
     * 用户账号
     */
    @NotBlank(message = "用户账号参数不能为空")
    private String account;
    /**
     * 上次结算的id
     */
    @NotNull(message = "上次结算的id参数不能为空")
    private Long parentId;
    /**
     * 系统积分id
     */
    @NotNull(message = "系统积分id参数不能为空")
    private Long systemBonusId;
    /**
     * 用户当日结算前积分值
     */
    @NotNull(message = "用户当日结算前积分值参数不能为空")
    private Double startPoints;
    /**
     * 用户当日结算后积分值
     */
    @NotNull(message = "用户当日结算后积分值参数不能为空")
    private Double endPoints;
    /**
     * 用户当日权重比率
     */
    @NotNull(message = "用户当日权重比率参数不能为空")
    private Double ratio;
    /**
     * 在会员客户端是否可见：0表示正常可见，1表示不可见
     */
    @NotNull(message = "会员客户端是否可见参数不能为空")
    private Integer visible;
}
