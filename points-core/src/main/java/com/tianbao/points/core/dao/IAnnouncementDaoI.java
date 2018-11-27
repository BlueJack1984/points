package com.tianbao.points.core.dao;

import com.tianbao.points.core.dao.base.IBaseDao;
import com.tianbao.points.core.entity.Announcement;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IAnnouncementDaoI extends IBaseDao<Announcement, Long> {

}