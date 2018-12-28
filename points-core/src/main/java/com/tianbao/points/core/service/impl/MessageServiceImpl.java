package com.tianbao.points.core.service.impl;


import com.baomidou.mybatisplus.toolkit.IdWorker;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tianbao.points.core.constant.StatusCode;
import com.tianbao.points.core.dao.IMessageDao;
import com.tianbao.points.core.dto.UserMessageDTO;
import com.tianbao.points.core.entity.Message;
import com.tianbao.points.core.entity.User;
import com.tianbao.points.core.entity.UserMessage;
import com.tianbao.points.core.exception.ApplicationException;
import com.tianbao.points.core.service.IMessageService;
import com.tianbao.points.core.service.IUserMessageService;
import com.tianbao.points.core.service.IUserService;
import com.tianbao.points.core.utils.BeanHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
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
     * 注入用户留言关联服务service
     */
    @Autowired
    @Lazy
    private IUserMessageService userMessageServer;
    private final IUserService userServer;

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
        Message message = iMessageDao.selectByPrimaryKey(id);
        return message;
    }

    @Override
    public void updateByIdSelective(Message record) throws ApplicationException {

    }

    @Override
    public void updateById(Message record) throws ApplicationException {
        iMessageDao.updateByPrimaryKey(record);
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
     * @desc 获取会员自己的留言列表,分页展示
     * @author lushusheng 2018-12-17
     * @param currentId 当前用户id
     * @param pageNo 当前页码
     * @param pageSize 每页显示条数
     * @return 返回实体数据列表
     * @throws ApplicationException 保存异常
     */
    @Override
    public PageInfo<UserMessageDTO> getListPage(Long currentId, Integer pageNo, Integer pageSize) throws ApplicationException {
        Page page = PageHelper.startPage(pageNo, pageSize);
        List<UserMessage> userMessageList = userMessageServer.getListPage(currentId);
        if(userMessageList == null || userMessageList.size() <= 0) {
            return new PageInfo<>(new ArrayList<>());
        }
        List<Long> messageIds = new ArrayList<>();
        List<Long> receiverIds = new ArrayList<>();
        List<Long> senderIds = new ArrayList<>();
        for(UserMessage userMessage: userMessageList) {
            messageIds.add(userMessage.getMessageId());
            receiverIds.add(userMessage.getReceiverId());
            senderIds.add(userMessage.getSenderId());
        }
        List<Message> messageList = iMessageDao.getListByIds(messageIds);
        List<User> receiverList = userServer.getListByIds(receiverIds);
        List<User> senderList = userServer.getListByIds(senderIds);
        List<UserMessageDTO> userMessageDTOList = new ArrayList<>();
        for(UserMessage userMessage: userMessageList) {
            UserMessageDTO userMessageDTO = new UserMessageDTO();
            BeanHelper.copyProperties(userMessageDTO, userMessage);
            for(Message message: messageList) {
                if(message.getId().equals(userMessage.getMessageId())) {
                    userMessageDTO.setMessage(message);
                    break;
                }
            }
            for(User receiver: receiverList) {
                if(receiver.getId().equals(userMessage.getReceiverId())) {
                    userMessageDTO.setReceiver(receiver);
                    break;
                }
            }
            for(User sender: senderList) {
                if(sender.getId().equals(userMessage.getSenderId())) {
                    userMessageDTO.setSender(sender);
                    break;
                }
            }
            userMessageDTOList.add(userMessageDTO);
        }
        PageInfo<UserMessageDTO> pageInfo = new PageInfo<>(userMessageDTOList);
        pageInfo.setTotal(page.getTotal());
        return pageInfo;
    }
    /**
     * @desc 发送（保存）一条留言数据
     * @author lushusheng 2018-12-17
     * @param title 留言参数输入实体
     * @param content 留言参数输入实体
     * @param currentId 当前用户id
     * @param idList 留言参数输入实体
     * @return 保存成功实体数据
     * @throws ApplicationException 保存异常
     */
    @Override
    public Message save(String title, String content, Long currentId, List<Long> idList) throws ApplicationException {

        Message message = insertMessage(title, content, currentId);
        //插入用户留言关联表
        insertUserMessage(message.getId(), currentId, idList);
        return message;
    }

    /**
     * @desc 根据id查询一条留言数据
     * @author lushusheng 2018-11-28
     * @param id 要查询的留言id
     * @param currentId 当前用户id
     * @param receiverId 接收者id
     * @return 返回查询的留言实体数据
     * @throws ApplicationException 查询异常
     */
    @Override
    public UserMessageDTO selectById(Long id, Long currentId, Long receiverId) throws ApplicationException {
        UserMessageDTO userMessageDTO = userMessageServer.getById(id, receiverId);
        return userMessageDTO;
    }

    /**
     * @desc 单独插入一条留言数据，完成事务
     * @author lushusheng 2018-12-17
     * @param title 留言参数输入实体
     * @param content 留言参数输入实体
     * @param currentId 当前用户id
     * @return 返回实体
     * @throws ApplicationException 保存异常
     */
    @Transactional(rollbackFor = Exception.class)
    public Message insertMessage(String title, String content, Long currentId)throws ApplicationException {
        Message message = new Message();
        message.setId(IdWorker.getId());
        message.setTitle(title);
        message.setContent(content);
        //无跳转
        message.setUrlType(2);
        message.setStatus(StatusCode.NORMAL.getCode());
        message.setCreateTime(new Date());
        message.setCreateUserId(currentId);
        message.setUpdateTime(new Date());
        message.setUpdateUserId(currentId);
        iMessageDao.insert(message);
        return message;
    }
    /**
     * @desc 批量插入用户留言关联表数据
     * @author lushusheng 2018-12-17
     * @param id 留言实体id
     * @param currentId 当前用户id
     * @param idList 留言参数输入实体
     * @return 无返回
     * @throws ApplicationException 保存异常
     */
    @Transactional(rollbackFor = Exception.class)
    public void insertUserMessage(Long id, Long currentId, List<Long> idList)throws ApplicationException {
        List<UserMessage> userMessageList = new ArrayList<>();
        for(Long receiverId: idList) {
            UserMessage userMessage = new UserMessage();
            userMessage.setId(IdWorker.getId());
            userMessage.setMessageId(id);
            userMessage.setSenderId(currentId);
            userMessage.setReceiverId(receiverId);
            userMessage.setStatus(StatusCode.UNSOVLED.getCode());
            userMessage.setCreateTime(new Date());
            userMessage.setCreateUserId(currentId);
            userMessage.setUpdateTime(new Date());
            userMessage.setUpdateUserId(currentId);
            userMessageList.add(userMessage);
        }
        userMessageServer.insertBatch(userMessageList);
    }
}
