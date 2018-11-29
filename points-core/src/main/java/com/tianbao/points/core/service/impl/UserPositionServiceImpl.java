package com.tianbao.points.core.service.impl;

import com.tianbao.points.core.dao.IUserPositionDao;
import com.tianbao.points.core.entity.UserPosition;
import com.tianbao.points.core.exception.ApplicationException;
import com.tianbao.points.core.service.IUserPositionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @desc 用户职位关联服务接口
 * @author lushusheng
 * @date 2018-11-27
 *
 */
@Service
@RequiredArgsConstructor
public class UserPositionServiceImpl implements IUserPositionService {

    /**
     * 注入用户职位关联dao
     */
    private final IUserPositionDao iUserPositionDao;

    @Override
    public void deleteById(Long id) throws ApplicationException {

    }

    @Override
    public UserPosition save(UserPosition record) throws ApplicationException {
        return null;
    }

    @Override
    public UserPosition saveSelective(UserPosition record) throws ApplicationException {
        return null;
    }

    @Override
    public UserPosition selectById(Long id) throws ApplicationException {
        return null;
    }

    @Override
    public void updateByIdSelective(UserPosition record) throws ApplicationException {

    }

    @Override
    public void updateById(UserPosition record) throws ApplicationException {

    }
}
