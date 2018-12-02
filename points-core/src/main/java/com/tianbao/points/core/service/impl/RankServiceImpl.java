package com.tianbao.points.core.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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

    /**
     * @author lushusheng
     * @Date 2018-12-02
     * @Desc 查询会员等级列表，分页
     * @param pageNo 表示当前页码
     * @param pageSize 表示数据条数
     * @return 返回会员等级集合数据
     * @update
     */
    @Override
    public PageInfo<Rank> getListPage(Integer pageNo, Integer pageSize) throws ApplicationException {
        PageHelper.startPage(pageNo, pageSize);
        List<Rank> rankList = iRankDao.selectListPage();
        PageInfo<Rank> pageInfo = new PageInfo<>(rankList);
        return pageInfo;
    }
}
