package com.tianbao.points.core.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tianbao.points.core.constant.StatusCode;
import com.tianbao.points.core.dao.IUserMessageDao;
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
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @desc 用户留言关联服务接口
 * @author lushusheng
 * @date 2018-11-27
 *
 */
@Service
@RequiredArgsConstructor
public class UserMessageServiceImpl implements IUserMessageService {
    /**
     * 注入用户留言关联dao
     */
    private final IUserMessageDao iUserMessageDao;
    /**
     * 注入用户service
     */
    private final IUserService userServer;
    /**
     * 注入留言service
     */
    private final IMessageService messageServer;

    @Override
    public void deleteById(Long id) throws ApplicationException {

    }

    @Override
    public void save(UserMessage record) throws ApplicationException {

    }

    @Override
    public void saveSelective(UserMessage record) throws ApplicationException {

    }

    @Override
    public UserMessage selectById(Long id) throws ApplicationException {
        return null;
    }

    @Override
    public void updateByIdSelective(UserMessage record) throws ApplicationException {

    }

    @Override
    public void updateById(UserMessage record) throws ApplicationException {

    }

    /**
     * @desc 根据实体id和发送者id和接收者id删除实体
     * @author lushusheng 2018-12-01
     * @param senderId 发送者id
     * @param currentId 当前用户id
     * @param id 留言实体id
     * @return 返回删除操作结果
     */
    @Override
    public void deleteByIds(Long id, Long senderId, Long currentId) throws ApplicationException {
        //首先根据三个id查询出来关联信息
        UserMessage userMessage = iUserMessageDao.selectByIds(id, senderId, currentId);
        if(userMessage == null) {
            throw new ApplicationException(1, "");
        }
        //逻辑删除
        userMessage.setStatus(StatusCode.FORBIDDEN.getCode());
        userMessage.setUpdateTime(new Date());
        userMessage.setUpdateUserId(currentId);
        iUserMessageDao.updateByPrimaryKey(userMessage);
    }

    /**
     * @desc 根据会员id模糊查询留言关联数据
     * @author lushusheng 2018-12-04
     * @param keyword 输入的会员id，查询关键词，模糊查询，分页展示
     * @param currentId 当前管理员用户id
     * @param pageNo 当前页码
     * @param pageSize 每页数据条数
     * @return 返回查询的留言实体关联数据
     * @throws ApplicationException 查询异常
     */
    @Override
    public PageInfo<UserMessageDTO> getByCondition(String keyword, Long currentId, Integer pageNo, Integer pageSize) throws ApplicationException {
        PageHelper.startPage(pageNo, pageSize);
        List<UserMessage> userMessageList = iUserMessageDao.getByCondition(keyword, currentId);
        List<UserMessageDTO> userMessageDTOList = loadUserAndMessageProperties(userMessageList);
        PageInfo<UserMessageDTO> pageInfo = new PageInfo<>(userMessageDTOList);
        return pageInfo;
    }

    /**
     * @desc 装载属性数据
     * @author lushusheng 2018-12-04
     * @return 返回装载后的数据
     * @throws ApplicationException 查询异常
     */
    private List<UserMessageDTO> loadUserAndMessageProperties(List<UserMessage> userMessageList) throws ApplicationException {
        List<Long> userIds = new ArrayList<>();
        List<Long> messageIds = new ArrayList<>();
        for(UserMessage userMessage: userMessageList) {
            userIds.add(userMessage.getSenderId());
            messageIds.add(userMessage.getMessageId());
        }
        List<User> userList = userServer.getListByIds(userIds);
        List<Message> messageList = messageServer.getListByIds(messageIds);

        List<UserMessageDTO> userMessageDTOList = new ArrayList<>();
        for(UserMessage userMessage: userMessageList) {
            UserMessageDTO userMessageDTO = new UserMessageDTO();
            BeanHelper.copyProperties(userMessageDTO, userMessageDTO);
            for(User user: userList) {
                if(user.getId().equals(userMessage.getSenderId())) {
                    userMessageDTO.setUser(user);
                    break;
                }
            }
            for(Message message: messageList) {
                if(message.getId().equals(userMessage.getMessageId())) {
                    userMessageDTO.setMessage(message);
                    break;
                }
            }
            userMessageDTOList.add(userMessageDTO);
        }
        return userMessageDTOList;
    }
    /**
     * @desc 历史数据, 查询某个会员的历史留言记录，分页查询，已处理的留言
     * @author lushusheng 2018-12-01
     * @param senderId 发送者id
     * @param currentId 当前用户id
     * @param pageNo 当前页码
     * @param pageSize 显示数据条数
     * @return 返回查询的留言实体数据
     * @throws ApplicationException 查询异常
     */
    @Override
    public PageInfo<UserMessageDTO> getListBySenderId(Long senderId, Long currentId, Integer pageNo, Integer pageSize) throws ApplicationException {
        PageHelper.startPage(pageNo, pageSize);
        List<UserMessage> userMessageList = iUserMessageDao.selectListBySenderId(senderId, currentId);
        List<UserMessageDTO> userMessageDTOList = loadUserAndMessageProperties(userMessageList);
        PageInfo<UserMessageDTO> pageInfo = new PageInfo<>(userMessageDTOList);
        return pageInfo;
    }
}
