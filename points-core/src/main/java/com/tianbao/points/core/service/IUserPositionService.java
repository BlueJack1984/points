package com.tianbao.points.core.service;

import com.tianbao.points.core.dto.PositionDTO;
import com.tianbao.points.core.entity.UserPosition;
import com.tianbao.points.core.exception.ApplicationException;
import com.tianbao.points.core.service.base.IBaseService;

import java.util.List;

/**
 * @desc 用户职位关联服务接口
 * @author lushusheng
 * @date 2018-11-27
 *
 */
public interface IUserPositionService extends IBaseService<UserPosition, Long> {

    /**
     * @author lushusheng
     * @Date 2018-12-13
     * @Desc 根据用户id查询用户职位关联列表
     * @param userId 用户id
     * @return 返回用户职位关联列表
     * @update
     */
    List<UserPosition> getListByUserId(Long userId)throws ApplicationException;

    /**
     * @author lushusheng
     * @Date 2018-12-13
     * @Desc 批量更新用户职位关联列表
     * @param userPositionList 更新数据
     * @return 无返回
     * @update
     */
    void updateBatch(List<UserPosition> userPositionList)throws ApplicationException;
}
