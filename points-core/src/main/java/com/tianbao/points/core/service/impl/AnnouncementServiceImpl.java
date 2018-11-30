package com.tianbao.points.core.service.impl;


import com.tianbao.points.core.constant.StatusCode;
import com.tianbao.points.core.dao.IAnnouncementDao;
import com.tianbao.points.core.entity.Announcement;
import com.tianbao.points.core.exception.ApplicationException;
import com.tianbao.points.core.service.IAnnouncementService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;


/**
 * @desc 首页公告服务接口
 * @author lushusheng
 * @date 2018-11-27
 *
 */
@Service
@RequiredArgsConstructor
public class AnnouncementServiceImpl implements IAnnouncementService {

    private final IAnnouncementDao iAnnouncementDao;
    private static final Logger logger = LoggerFactory.getLogger(AnnouncementServiceImpl.class);
    /**
     * @author lushusheng
     * @Date 2018-11-27
     * @Desc 根据id删除实体，本项目均为逻辑删除
     * @return 返回无，出错抛出异常
     * @update
     */
    @Override
    public void deleteById(Long id) throws ApplicationException {

    }

    @Override
    @Transactional
    public void save(Announcement record) throws ApplicationException {
        record.setStatus(StatusCode.NORMAL.getCode());
        record.setCreateTime(new Date());
        record.setUpdateTime(new Date());
        record.setCreateUserId(record.getUserId());
        record.setUpdateUserId(record.getUserId());
        iAnnouncementDao.insert(record);
    }

    @Override
    public void saveSelective(Announcement record) throws ApplicationException {

    }

    @Override
    public Announcement selectById(Long id) throws ApplicationException {
        Announcement announcement = iAnnouncementDao.selectByPrimaryKey(id);
        return announcement;
    }

    @Override
    public void updateByIdSelective(Announcement record) throws ApplicationException {

    }

    @Override
    public void updateById(Announcement record) throws ApplicationException {

    }
}
