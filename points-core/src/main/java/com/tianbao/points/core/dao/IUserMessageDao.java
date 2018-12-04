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
    /**
     * @desc 根据会员id模糊查询留言关联数据
     * @author lushusheng 2018-12-04
     * @param keyword 输入的会员id，查询关键词，模糊查询，分页展示
     * @param currentId 当前管理员用户id
     * @return 返回查询的留言实体关联数据
     */
    List<UserMessage> getByCondition(@Param("keyword") String keyword, @Param("currentId") Long currentId);

    /**
     * @desc 历史数据, 查询某个会员的历史留言记录，分页查询，已处理的留言
     * @author lushusheng 2018-12-01
     * @param senderId 发送者id
     * @param currentId 当前用户id
     * @return 返回查询的留言实体数据
     */
    List<UserMessage> selectListBySenderId(@Param("senderId") Long senderId, @Param("currentId") Long currentId);
}