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
    public PageInfo<MessageDTO> getListPage(Long currentId, Integer pageNo, Integer pageSize) throws ApplicationException {

        return null;
    }
}
