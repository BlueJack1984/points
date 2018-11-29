package com.tianbao.points.core.service;

import com.tianbao.points.core.dto.PositionDTO;
import com.tianbao.points.core.entity.Position;
import com.tianbao.points.core.exception.ApplicationException;
import com.tianbao.points.core.service.base.IBaseService;

import java.util.List;

/**
 * @desc 职位服务接口
 * @author lushusheng
 * @date 2018-11-27
 *
 */
public interface IPositionService extends IBaseService<Position, Long> {

    /**
     * @author lushusheng
     * @Date 2018-11-29
     * @Desc 根据用户id查询职位列表,个人档案部分使用
     * @return 返回职位列表
     * @update
     */
    List<PositionDTO> getListByUserId(Long userId)throws ApplicationException;
}
