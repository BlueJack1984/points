package com.tianbao.points.core.dao;

import com.tianbao.points.core.dao.base.IBaseDao;
import com.tianbao.points.core.entity.Announcement;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author lushusheng
 * @Date 2018-11-29
 * @Desc 持久层基本增删改查接口
 */
@Mapper
public interface IAnnouncementDao extends IBaseDao<Announcement, Long> {

}