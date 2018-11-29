package com.tianbao.points.core.service.impl;


import com.tianbao.points.core.dao.IMessageDao;
import com.tianbao.points.core.entity.Message;
import com.tianbao.points.core.exception.ApplicationException;
import com.tianbao.points.core.service.IMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
    public Message save(Message record) throws ApplicationException {
        return null;
    }

    @Override
    public Message saveSelective(Message record) throws ApplicationException {
        return null;
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
}
