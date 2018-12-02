package com.tianbao.points.core.service.impl;

import com.tianbao.points.core.dao.IRankDao;
import com.tianbao.points.core.entity.Rank;
import com.tianbao.points.core.exception.ApplicationException;
import com.tianbao.points.core.service.IRankService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public void save(Rank record) throws ApplicationException {

    }

    @Override
    public void saveSelective(Rank record) throws ApplicationException {

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

    /**
     * @author lushusheng
     * @Date 2018-12-01
     * @Desc 查询会员等级列表，不分页
     * @return 返回会员等级集合数据
     * @update
     */
    @Override
    public List<Rank> getList() throws ApplicationException {
        List<Rank> rankList = iRankDao.selectList();
        return rankList;
    }
}
