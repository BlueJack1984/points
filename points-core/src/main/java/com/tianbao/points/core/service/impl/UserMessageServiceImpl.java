package com.tianbao.points.core.service.impl;

import com.tianbao.points.core.dao.IUserMessageDao;
import com.tianbao.points.core.entity.UserMessage;
import com.tianbao.points.core.exception.ApplicationException;
import com.tianbao.points.core.service.IUserMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
    public UserMessage save(UserMessage record) throws ApplicationException {
        return null;
    }

    @Override
    public UserMessage saveSelective(UserMessage record) throws ApplicationException {
        return null;
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
}
