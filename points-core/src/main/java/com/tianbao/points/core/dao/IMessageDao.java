package com.tianbao.points.core.dao;

import com.tianbao.points.core.dao.base.IBaseDao;
import com.tianbao.points.core.dto.MessageDTO;
import com.tianbao.points.core.entity.Message;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lushusheng
 * @Date 2018-11-29
 * @Desc 持久层拓展接口
 */
@Mapper
public interface IMessageDao extends IBaseDao<Message, Long> {

    /**
     * @author lushusheng
     * @Date 2018-12-01
     * @param id 留言实体id
     * @param senderId 发送者id
     * @param currentId 当前用户id（接收者）
     * @Desc 根据id查询实体数据
     * @return 返回查询到的实体
     * @update
     */
    MessageDTO selectByIds(@Param("id") Long id, @Param("senderId") Long senderId, @Param("currentId") Long currentId);
    /**
     * @desc 根据发送者id和接收者id查询所有留言数据列表, 需要分页
     * @author lushusheng 2018-12-01
     * @param senderId 发送者id
     * @param currentId 当前用户id
     * @return 返回查询的留言实体数据
     */
    List<MessageDTO> getListBySenderId(@Param("senderId") Long senderId, @Param("currentId") Long currentId);

    /**
     * @desc 根据实体id和发送者id和接收者id删除实体
     * @author lushusheng 2018-12-01
     * @param senderId 发送者id
     * @param currentId 当前用户id
     * @param id 留言实体id
     * @return 返回删除操作结果
     */
    void deleteByIds(@Param("id")Long id, @Param("senderId")Long senderId, @Param("currentId")Long currentId);
}