package com.tianbao.points.admin.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @desc 会员等级的输入实体,用于更新实体
 * @author lushusheng
 * @date 2018-12-05
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RankUpdateInput extends RankInput{
    /**
     * 会员等级id
     */
    @NotNull(message="会员等级id不能为空")
    private Long id;
}
