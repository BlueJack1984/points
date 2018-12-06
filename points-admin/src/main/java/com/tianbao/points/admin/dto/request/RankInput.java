package com.tianbao.points.admin.dto.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @desc 会员等级的输入实体，用于创建实体
 * @author lushusheng
 * @date 2018-12-05
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RankInput {

    /**
     * 会员等级名称
     */
    @NotBlank(message="会员等级名称不能为空")
    private String name;
    /**
     * 会员等级别名
     */
    private String alias;
    /**
     * 该会员等级进行积分结算的基准值,正常是10元等于1积分
     * 用它来乘以权重比率
     */
    @NotNull(message="会员等级基准值不能为空")
    private Integer basePoints;
    /**
     * 晋升到该会员等级需要交纳的金额
     */
    @NotNull(message="会员等级金额不能为空")
    private Double baseMoney;
    /**
     * 会员等级标识颜色
     */
    private String color;
    /**
     * 奖金封顶
     */
    @NotNull(message="奖金封顶值不能为空")
    private Double maxBonus;
    /**
     * 排序编号
     */
    @NotNull(message="会员等级排序编号不能为空")
    private Integer order;
}
