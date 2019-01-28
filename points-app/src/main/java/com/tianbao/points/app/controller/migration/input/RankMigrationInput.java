package com.tianbao.points.app.controller.migration.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @desc 会员等级输入实体
 * @author lushusheng
 * @date 2019-1-28
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RankMigrationInput {

    /**
     * 会员等级id
     */
    @NotNull(message = "会员等级id参数不能为空")
    private Long id;
    /**
     * 级别名称
     */
    @NotBlank(message = "级别名称参数不能为空")
    private String name;
    /**
     * 别名
     */
    @NotBlank(message = "别名参数不能为空")
    private String alias;
    /**
     * 基准积分
     */
    @NotNull(message = "基准积分参数不能为空")
    private Integer basePoints;
    /**
     * 基准金额
     */
    @NotNull(message = "基准金额参数不能为空")
    private Double baseMoney;
    /**
     * 识别颜色
     */
    @NotBlank(message = "识别颜色参数不能为空")
    private String color;
    /**
     * 奖金封顶
     */
    @NotNull(message = "奖金封顶参数不能为空")
    private Double maxBonus;
    /**
     * 编排序号，这个唯一标识会员等级
     */
    @NotNull(message = "编排序号参数不能为空")
    private Integer order;
}
