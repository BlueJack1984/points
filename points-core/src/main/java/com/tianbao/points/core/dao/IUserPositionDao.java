package com.tianbao.points.core.dao;

import com.tianbao.points.core.dao.base.IBaseDao;
import com.tianbao.points.core.entity.UserPosition;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lushusheng
 * @Date 2018-11-29
 * @Desc 持久层拓展接口
 */
@Mapper
public interface IUserPositionDao extends IBaseDao<UserPosition, Long> {

    /**
     * @author lushusheng
     * @Date 2018-12-13
     * @Desc 根据用户id查询用户职位关联列表
     * @param userId 用户id
     * @return 返回用户职位关联列表
     * @update
     */
    List<UserPosition> getListByUserId(@Param("userId") Long userId);

    /**
     * @author lushusheng
     * @Date 2018-12-13
     * @Desc 批量更新用户职位关联列表
     * @param userPositionList 更新数据
     * @return 无返回
     * @update
     */
    void updateBatch(@Param("userPositionList") List<UserPosition> userPositionList);
}