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
import org.springframework.context.annotation.Bean;
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
     * @desc 根据一个id或者多个id列表删除实体
     * @author lushusheng 2018-12-04
     * @param ids 实体id列表
     * @param currentId 当前用户id
     * @return 返回操作结果
     * @throws ApplicationException 查询异常
     */
    @Override
    public void deleteByIds(List<Long> ids, Long currentId) throws ApplicationException {
        //首先根据三个id查询出来关联信息
        List<UserMessage> userMessageList = iUserMessageDao.selectListByIds(ids, currentId);
        if(userMessageList == null) {
            throw new ApplicationException(1, "不存在相关用户留言");
        }
        //逻辑删除
        for(UserMessage userMessage: userMessageList) {
            userMessage.setStatus(StatusCode.FORBIDDEN.getCode());
            userMessage.setUpdateTime(new Date());
            userMessage.setUpdateUserId(currentId);
        }
        iUserMessageDao.updateBatch(userMessageList);
    }


    /**
     * @desc 根据会员id模糊查询留言关联数据
     * @author lushusheng 2018-12-04
     * @param keyword 输入的会员id，查询关键词，模糊查询，分页展示
     * @param id 精确查询此会员id
     * @param type 查询类型：0表示未处理和已处理均查询，1表示查询未处理，2表示查询已处理
     * @param currentId 当前管理员用户id
     * @param pageNo 当前页码
     * @param pageSize 每页数据条数
     * @return 返回查询的留言实体关联数据
     * @throws ApplicationException 查询异常
     */
    @Override
    public PageInfo<UserMessageDTO> getListByCondition(String keyword, Integer type, Long id, Long currentId, Integer pageNo, Integer pageSize) throws ApplicationException {
        PageHelper.startPage(pageNo, pageSize);
        List<UserMessage> userMessageList = iUserMessageDao.selectListByCondition(keyword, type, id, currentId);
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
            BeanHelper.copyProperties(userMessageDTO, userMessage);
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
     * @desc 根据id查询实体详情
     * @author lushusheng 2018-12-04
     * @param id 实体id
     * @param currentId 当前用户id
     * @return 返回查询到的结果
     * @throws ApplicationException 查询异常
     */
    @Override
    public UserMessageDTO getById(Long id, Long currentId)throws ApplicationException {
        UserMessage userMessage = iUserMessageDao.selectById(id, currentId);
        UserMessageDTO userMessageDTO = new UserMessageDTO();
        BeanHelper.copyProperties(userMessageDTO, userMessage);
        User user = userServer.selectById(userMessage.getSenderId());
        userMessageDTO.setUser(user);
        Message message = messageServer.selectById(userMessage.getMessageId());
        userMessageDTO.setMessage(message);
        return userMessageDTO;
    }

    /**
     * @author lushusheng
     * @Date 2018-12-04
     * @Desc 根据参数更新实体数据，不管数据是否为空都更新覆盖
     * @param id 实体id
     * @param currentId 当前用户id
     * @param reply 回复
     * @param status 状态
     * @return 返回无，出错抛出异常
     * @update
     */
    @Override
    public UserMessageDTO updateById(Long id, Long currentId, String reply, Integer status) throws ApplicationException {
        UserMessage userMessage = iUserMessageDao.selectById(id, currentId);
        if(userMessage == null) {
            throw new ApplicationException(2, "查询的用户留言关联实体信息不存在");
        }
        userMessage.setStatus(status);
        userMessage.setUpdateUserId(currentId);
        userMessage.setUpdateTime(new Date());
        iUserMessageDao.updateByPrimaryKey(userMessage);
        Message message = messageServer.selectById(userMessage.getMessageId());
        message.setReply(reply);
        message.setUpdateTime(new Date());
        message.setUpdateUserId(currentId);
        messageServer.updateById(message);

        UserMessageDTO userMessageDTO = getById(id, currentId);
        return userMessageDTO;
    }

    /**
     * @desc 批量插入用户留言关联表数据
     * @author lushusheng 2018-12-17
     * @param userMessageList 留言实体集合
     * @return 无返回
     * @throws ApplicationException 保存异常
     */
    @Override
    public void insertBatch(List<UserMessage> userMessageList) throws ApplicationException {
        iUserMessageDao.insertBatch(userMessageList);
    }
}
