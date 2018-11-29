package com.tianbao.points.core.service.impl;


import com.tianbao.points.core.dao.IPositionDao;
import com.tianbao.points.core.entity.Position;
import com.tianbao.points.core.exception.ApplicationException;
import com.tianbao.points.core.service.IPositionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @desc 职位服务接口
 * @author lushusheng
 * @date 2018-11-27
 *
 */
@Service
@RequiredArgsConstructor
public class PositionServiceImpl implements IPositionService {
    /**
     * 注入职位dao
     */
    private final IPositionDao iPositionDao;

    @Override
    public void deleteById(Long id) throws ApplicationException {

    }

    @Override
    public void save(Position record) throws ApplicationException {

    }

    @Override
    public void saveSelective(Position record) throws ApplicationException {

    }

    @Override
    public Position selectById(Long id) throws ApplicationException {
        return null;
    }

    @Override
    public void updateByIdSelective(Position record) throws ApplicationException {

    }

    @Override
    public void updateById(Position record) throws ApplicationException {

    }
}
