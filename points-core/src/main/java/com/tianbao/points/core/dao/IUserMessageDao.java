package com.tianbao.points.core.dao;

import com.tianbao.points.core.dao.base.IBaseDao;
import com.tianbao.points.core.entity.UserMessage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lushusheng
 * @Date 2018-11-29
 * @Desc 持久层拓展接口
 */
@Mapper
public interface IUserMessageDao extends IBaseDao<UserMessage, Long> {
    /**
     * @desc 根据实体id和发送者id和接收者id查询出实体
     * @author lushusheng 2018-12-01
     * @param senderId 发送者id
     * @param currentId 当前用户id
     * @param id 留言实体id
     * @return 返回查询结果
     */
    UserMessage selectByIds(@Param("id") Long id, @Param("senderId") Long senderId, @Param("currentId") Long currentId);
}