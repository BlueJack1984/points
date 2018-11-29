package com.tianbao.points.core.dto;

import com.baomidou.mybatisplus.toolkit.IdWorker;
import com.tianbao.points.core.entity.Position;
import com.tianbao.points.core.entity.Role;
import com.tianbao.points.core.entity.User;
import lombok.Data;

import java.util.List;

/**
 * 用户的传输实体
 * 包装用户的相关属性
 * @author lushusheng 2018-11-28
 */
@Data
public class UserDTO extends User {

    /**
     * 包装用户的角色属性
     * 主要确定是否超级管理员或者下级管理员
     * 考虑到兼容用户可以多角色的情况
     */
    private List<Role> roleList;
    /**
     * 包装用户的职位属性
     * 用户可具有多个部门的多个职位
     * 部门与职位映射关系：一个职位只对应一个部门，一个部门可对应多个职位
     */
    private List<PositionDTO> positionDTOList;
}
