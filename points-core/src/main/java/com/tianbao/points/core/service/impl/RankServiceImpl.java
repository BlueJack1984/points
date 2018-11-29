package com.tianbao.points.core.service.impl;

import com.tianbao.points.core.dao.IRankDao;
import com.tianbao.points.core.entity.Rank;
import com.tianbao.points.core.exception.ApplicationException;
import com.tianbao.points.core.service.IRankService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @desc 会员等级服务接口
 * @author lushusheng
 * @date 2018-11-27
 *
 */
@Service
@RequiredArgsConstructor
public class RankServiceImpl implements IRankService {
    /**
     * 注入会员等级dao
     */
    private final IRankDao iRankDao;

    @Override
    public void deleteById(Long id) throws ApplicationException {

    }

    @Override
    public Rank save(Rank record) throws ApplicationException {
        return null;
    }

    @Override
    public Rank saveSelective(Rank record) throws ApplicationException {
        return null;
    }

    @Override
    public Rank selectById(Long id) throws ApplicationException {
        return null;
    }

    @Override
    public void updateByIdSelective(Rank record) throws ApplicationException {

    }

    @Override
    public void updateById(Rank record) throws ApplicationException {

    }
}
