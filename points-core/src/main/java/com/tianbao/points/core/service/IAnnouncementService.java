package com.tianbao.points.core.service;


import com.tianbao.points.core.dao.base.IBaseDao;
import com.tianbao.points.core.entity.Announcement;
import com.tianbao.points.core.service.base.IBaseService;

/**
 * @desc 返回实体的属性值
 * @author lushusheng
 * @date 2018-11-21
 * @param code 错误代号值,默认正常返回值200
 * @param message 错误信息，默认正常返回信息"SUCCESS"
 * @param data 返回数据
 */
public interface IAnnouncementService extends IBaseService<Announcement, Long> {


}
