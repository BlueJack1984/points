package com.tianbao.points.admin.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;


/**
 * @desc 证券指数修改输入实体，比保存实体多一个实体id参数
 * @author lushusheng
 * @date 2018-11-29
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StockUpdateInput {

    /**
     * 修改的实体id
     */
    @NotEmpty(message = "实体id不能为空")
    private Long id;
    /**
     * 发布时间
     */
    private String publishTime;
    /**
     * 上证开盘指数
     */
    private Double shOpenExponent;
    /**
     * 上证收盘指数
     */
    private Double shCloseExponent;
    /**
     * 上证最高指数
     */
    private Double shMaxExponent;
    /**
     * 上证最低指数
     */
    private Double shMinExponent;
    /**
     * 天宝开盘指数
     */
    private Double tbOpenExponent;
    /**
     * 天宝收盘指数
     */
    private Double tbCloseExponent;
    /**
     * 天宝最高指数
     */
    private Double tbMaxExponent;
    /**
     * 天宝最低指数
     */
    private Double tbMinExponent;
}
