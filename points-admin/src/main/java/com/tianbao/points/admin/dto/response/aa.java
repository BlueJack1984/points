package com.tianbao.points.admin.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @desc 系统积分增值的输出实体
 * @author lushusheng
 * @date 2018-11-30
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class aa {

    /**
     * 当前系统积分总数
     */
    private Double totalPoints;

    /**
     * 当前系统权重比率
     */
    private Double systemRatio;
}
