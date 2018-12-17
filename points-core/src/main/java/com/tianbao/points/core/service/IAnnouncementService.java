package com.tianbao.points.core.service;

import com.github.pagehelper.PageInfo;
import com.tianbao.points.core.dto.AnnouncementDTO;
import com.tianbao.points.core.entity.Announcement;
import com.tianbao.points.core.exception.ApplicationException;
import com.tianbao.points.core.service.base.IBaseService;
import io.swagger.models.auth.In;

import java.nio.channels.AcceptPendingException;
import java.util.Date;
import java.util.List;

/**
 * @desc 首页公告服务接口
 * @author lushusheng
 * @date 2018-11-27
 *
 */
public interface IAnnouncementService extends IBaseService<Announcement, Long> {

    /**
     * @desc 获取首页公告列表,分页展示
     * @author lushusheng 2018-12-04
     * @param pageNo 当前页码
     * @param pageSize 每页显示条数
     * @return 返回实体数据列表
     * @throws ApplicationException 保存异常
     */
    PageInfo<AnnouncementDTO> getListPage(Integer pageNo, Integer pageSize)throws ApplicationException;

    /**
     * @author lushusheng
     * @Date 2018-12-04
     * @Desc 保存一个实体数据
     * @param title 标题
     * @param content 内容
     * @param publishTime 发布时间
     * @return 返回保存后的实体数据
     * @update
     */
    Announcement save(String title, String content, Date publishTime, Long currentId) throws ApplicationException;

    /**
     * @desc 根据id集合删除公告数据，逻辑删除
     * @author lushusheng 2018-12-04
     * @param idList 要查询的公告id集合
     * @param currentId 管理员用户id
     * @return 返回删除操作结果
     * @throws ApplicationException 查询异常
     */
    void deleteByIds(List<Long> idList, Long currentId)throws ApplicationException;
}
