package com.tianbao.points.core.service;

import com.github.pagehelper.PageInfo;
import com.tianbao.points.core.dto.MessageDTO;
import com.tianbao.points.core.entity.Message;
import com.tianbao.points.core.exception.ApplicationException;
import com.tianbao.points.core.service.base.IBaseService;

import java.util.List;

/**
 * @desc 留言服务接口
 * @author lushusheng
 * @date 2018-11-27
 *
 */
public interface IMessageService extends IBaseService<Message, Long> {

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
    MessageDTO selectByIds(Long id, Long senderId, Long currentId) throws ApplicationException;

    /**
     * @desc 根据发送者id和接收者id查询所有留言数据列表
     * @author lushusheng 2018-12-01
     * @param senderId 发送者id
     * @param currentId 当前用户id
     * @param pageNo 当前页码
     * @param pageSize 显示数据条数
     * @return 返回查询的留言实体数据
     * @throws ApplicationException 查询异常
     */
    PageInfo<MessageDTO> getListBySenderId(Long senderId, Long currentId, Integer pageNo, Integer pageSize) throws ApplicationException;

    /**
     * @desc 根据实体id和发送者id和接收者id删除实体
     * @author lushusheng 2018-12-01
     * @param senderId 发送者id
     * @param currentId 当前用户id
     * @param id 留言实体id
     * @return 返回删除操作结果
     * @throws ApplicationException 操作异常
     */
    void deleteByIds(Long id, Long senderId, Long currentId) throws ApplicationException;

}
