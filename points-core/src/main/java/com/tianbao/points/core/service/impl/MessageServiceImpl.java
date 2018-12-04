package com.tianbao.points.core.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tianbao.points.core.dao.IMessageDao;
import com.tianbao.points.core.dto.MessageDTO;
import com.tianbao.points.core.entity.Message;
import com.tianbao.points.core.entity.UserMessage;
import com.tianbao.points.core.exception.ApplicationException;
import com.tianbao.points.core.service.IMessageService;
import com.tianbao.points.core.service.IUserMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @desc 留言服务接口
 * @author lushusheng
 * @date 2018-11-27
 *
 */
@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements IMessageService {
    /**
     * 注入留言dao
     */
    private final IMessageDao iMessageDao;
    /**
     * 注入用户信息关联表service
     */
    private final IUserMessageService userMessageServer;

    @Override
    public void deleteById(Long id) throws ApplicationException {

    }

    @Override
    public void save(Message record) throws ApplicationException {

    }

    @Override
    public void saveSelective(Message record) throws ApplicationException {

    }

    @Override
    public Message selectById(Long id) throws ApplicationException {
        return null;
    }

    @Override
    public void updateByIdSelective(Message record) throws ApplicationException {

    }

    @Override
    public void updateById(Message record) throws ApplicationException {

    }

    /**
     * @desc 根据留言id集合查询留言列表
     * @author lushusheng 2018-12-04
     * @param ids 输入的留言集合
     * @return 返回查询的留言实体数据列表
     * @throws ApplicationException 查询异常
     */
    @Override
    public List<Message> getListByIds(List<Long> ids) throws ApplicationException {
        List<Message> messageList = iMessageDao.getListByIds(ids);
        return messageList;
    }

    /**
     * @desc 根据发送者id和接收者id查询所有留言数据列表, 需要分页
     * @author lushusheng 2018-12-01
     * @param senderId 发送者id
     * @param currentId 当前用户id
     * @param pageNo 当前页码
     * @param pageSize 显示数据条数
     * @return 返回查询的留言实体数据
     * @throws ApplicationException 查询异常
     */
    @Override
    public PageInfo<MessageDTO> getListBySenderId(Long senderId, Long currentId, Integer pageNo, Integer pageSize) throws ApplicationException {
        PageHelper.startPage(pageNo, pageSize);
        List<MessageDTO> messageDTOList = iMessageDao.getListBySenderId(senderId, currentId);
        PageInfo<MessageDTO> pageInfo = new PageInfo<>(messageDTOList);
        return pageInfo;
    }

    /**
     * @desc 根据实体id和发送者id和接收者id删除实体
     * @author lushusheng 2018-12-01
     * @param senderId 发送者id
     * @param currentId 当前用户id
     * @param id 留言实体id
     * @return 返回删除操作结果
     * @throws ApplicationException 操作异常
     */
    @Override
    public void deleteByIds(Long id, Long senderId, Long currentId) throws ApplicationException {
        //逻辑删除，只删除用户留言关联表的信息，留言表不删除
        userMessageServer.deleteByIds(id, senderId, currentId);
    }
}
