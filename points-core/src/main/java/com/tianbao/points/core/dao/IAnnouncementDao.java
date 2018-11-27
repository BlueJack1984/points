package com.tianbao.points.core.dao;

import com.tianbao.points.core.dao.base.BaseDao;
import com.tianbao.points.core.entity.Announcement;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IAnnouncementDao extends BaseDao<Announcement, Long> {

}