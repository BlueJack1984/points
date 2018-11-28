package com.tianbao.points.core.dto;


import com.tianbao.points.core.entity.Department;
import com.tianbao.points.core.entity.Position;
import lombok.Data;

/**
 * 职位的传输实体
 * 包装职位所属部门的相关属性
 * @author lushusheng 2018-11-28
 */
@Data
public class PositionDTO extends Position {

    /**
     * 包装职位的所属部门属性
     *
     */
    private Department department;
}
