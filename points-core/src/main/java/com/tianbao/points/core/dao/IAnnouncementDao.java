package com.tianbao.points.core.dao;

import com.tianbao.points.core.dao.base.IBaseDao;
import com.tianbao.points.core.entity.Announcement;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lushusheng
 * @Date 2018-11-29
 * @Desc 持久层基本增删改查接口
 */
@Mapper
public interface IAnnouncementDao extends IBaseDao<Announcement, Long> {

    /**
     * @desc 获取首页公告列表,分页展示
     * @author lushusheng 2018-12-04
     * @return 返回实体数据列表
     */
     List<Announcement> getListPage();

    /**
     * @desc 根据id集合更新公告数据
     * @author lushusheng 2018-12-04
     * @param announcementList 要更新的公告集合
     * @return 返回更新操作结果
     */
    void updateBatch(@Param("announcementList")List<Announcement> announcementList);

    /**
     * @desc 根据实体id列表获取首页公告列表
     * @author lushusheng 2018-12-04
     * @param ids 要查询的公告id集合
     * @return 返回实体数据列表
     */
    List<Announcement> getListByIds(@Param("ids")List<Long> ids);
}