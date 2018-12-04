package com.tianbao.points.core.service.impl;

import com.tianbao.points.core.constant.StatusCode;
import com.tianbao.points.core.dao.IUserMessageDao;
import com.tianbao.points.core.entity.UserMessage;
import com.tianbao.points.core.exception.ApplicationException;
import com.tianbao.points.core.service.IUserMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
     * @param keyword 输入的会员id，查询关键词，模糊查询
     * @param currentId 当前管理员用户id
     * @return 返回查询的留言实体关联数据
     * @throws ApplicationException 查询异常
     */
    @Override
    public List<UserMessage> getByCondition(String keyword, Long currentId) throws ApplicationException {
        List<UserMessage> userMessageList = iUserMessageDao.getByCondition(keyword, currentId);
        return userMessageList;
    }
}
