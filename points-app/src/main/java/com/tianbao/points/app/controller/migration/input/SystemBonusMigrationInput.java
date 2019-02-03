package com.tianbao.points.app.controller.migration.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @desc 系统积分输入实体
 * @author lushusheng
 * @date 2019-1-28
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SystemBonusMigrationInput {

    /**
     * 系统积分id
     */
    @NotNull(message = "系统积分id参数不能为空")
    private Long id;
    /**
     * 系统当日结算前积分值
     */
    @NotNull(message = "系统当日结算前积分值参数不能为空")
    private Double startPoints;
    /**
     * 系统当日结算后积分值
     */
    @NotNull(message = "系统当日结算后积分值参数不能为空")
    private Double endPoints;
    /**
     * 系统当日权重比率，与当日的个人比率相同
     */
    @NotNull(message = "系统当日权重比率参数不能为空")
    private Double ratio;
    /**
     * 在会员客户端是否可见：0表示正常可见，1表示不可见
     */
    @NotNull(message = "会员客户端是否可见参数不能为空")
    private Integer visible;

    /**
     * 创建时间
     */
    @NotBlank(message = "创建时间参数不能为空")
    private String createTime;
}
