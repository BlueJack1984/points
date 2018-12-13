package com.tianbao.points.core.service.impl;

import com.tianbao.points.core.dao.IUserPositionDao;
import com.tianbao.points.core.entity.UserPosition;
import com.tianbao.points.core.exception.ApplicationException;
import com.tianbao.points.core.service.IUserPositionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public void save(UserPosition record) throws ApplicationException {

    }

    @Override
    public void saveSelective(UserPosition record) throws ApplicationException {

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

    /**
     * @author lushusheng
     * @Date 2018-12-13
     * @Desc 根据用户id查询用户职位关联列表
     * @param userId 用户id
     * @return 返回用户职位关联列表
     * @update
     */
    @Override
    public List<UserPosition> getListByUserId(Long userId) throws ApplicationException {
        List<UserPosition> userPositionList = iUserPositionDao.getListByUserId(userId);
        return userPositionList;
    }

    /**
     * @author lushusheng
     * @Date 2018-12-13
     * @Desc 批量更新用户职位关联列表
     * @param userPositionList 更新数据
     * @return 无返回
     * @update
     */
    @Override
    public void updateBatch(List<UserPosition> userPositionList) throws ApplicationException {
        iUserPositionDao.updateBatch(userPositionList);
    }
}
