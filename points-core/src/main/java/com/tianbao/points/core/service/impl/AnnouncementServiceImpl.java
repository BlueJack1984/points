package com.tianbao.points.core.service.impl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tianbao.points.core.constant.StatusCode;
import com.tianbao.points.core.dao.IAnnouncementDao;
import com.tianbao.points.core.dto.AnnouncementDTO;
import com.tianbao.points.core.entity.Announcement;
import com.tianbao.points.core.entity.User;
import com.tianbao.points.core.exception.ApplicationException;
import com.tianbao.points.core.service.IAnnouncementService;
import com.tianbao.points.core.service.IUserService;
import com.tianbao.points.core.utils.BeanHelper;
import lombok.RequiredArgsConstructor;
import org.hibernate.dialect.CUBRIDDialect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.channels.AcceptPendingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


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
     * 注入个人信息service
     */
    private final IUserService userServer;

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

    /**
     * @desc 获取首页公告列表,分页展示
     * @author lushusheng 2018-12-04
     * @param pageNo 当前页码
     * @param pageSize 每页显示条数
     * @return 返回实体数据列表
     * @throws ApplicationException 保存异常
     */
    @Override
    public PageInfo<AnnouncementDTO> getListPage(Integer pageNo, Integer pageSize) throws ApplicationException {
        Page page = PageHelper.startPage(pageNo, pageSize);
        List<Announcement> announcementList = iAnnouncementDao.getListPage();
        if(announcementList == null) {
            return new PageInfo<>(new ArrayList<>());
        }
        List<Long> ids = new ArrayList<>();
        for(Announcement announcement: announcementList) {
            if(announcement.getUserId() != null) {
                ids.add(announcement.getUserId());
            }
        }
        List<User> userList = userServer.getListByIds(ids);
        List<AnnouncementDTO> announcementDTOList = new ArrayList<>();
        for(Announcement announcement: announcementList) {
            if(announcement == null) {
                continue;
            }
            AnnouncementDTO announcementDTO = new AnnouncementDTO();
            BeanHelper.copyProperties(announcementDTO, announcement);
            for(User user: userList) {
                if(user.getId().equals(announcement.getUserId())) {
                    announcementDTO.setUser(user);
                    break;
                }
            }
            announcementDTOList.add(announcementDTO);
        }
        PageInfo<AnnouncementDTO> pageInfo = new PageInfo<>(announcementDTOList);
        pageInfo.setTotal(page.getTotal());
        return pageInfo;
    }

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
    @Transactional(rollbackFor = Exception.class)
    @Override
    public Announcement save(String title, String content, Date publishTime, Long currentId) throws ApplicationException {
        Announcement announcement = new Announcement();
        announcement.setTitle(title);
        announcement.setContent(content);
        announcement.setPublishTime(publishTime);
        announcement.setUserId(currentId);
        announcement.setStatus(StatusCode.NORMAL.getCode());
        announcement.setCreateTime(new Date());
        announcement.setUpdateTime(new Date());
        announcement.setCreateUserId(currentId);
        announcement.setUpdateUserId(currentId);
        iAnnouncementDao.insert(announcement);
        return announcement;
    }

    /**
     * @desc 根据id集合删除公告数据，逻辑删除
     * @author lushusheng 2018-12-04
     * @param idList 要查询的公告id集合
     * @param currentId 管理员用户id
     * @return 返回删除操作结果
     * @throws ApplicationException 查询异常
     */
    public void deleteByIds(List<Long> idList, Long currentId)throws ApplicationException {
        List<Announcement> announcementList = iAnnouncementDao.getListByIds(idList);
        for(Announcement announcement: announcementList) {
            announcement.setStatus(StatusCode.FORBIDDEN.getCode());
            announcement.setUpdateUserId(currentId);
            announcement.setUpdateTime(new Date());
        }
        iAnnouncementDao.updateBatch(announcementList);
    }

    @Override
    public Announcement update(Long id, String title, String content, Date publishTime, Long currentId) throws ApplicationException {
        Announcement announcement = iAnnouncementDao.selectByPrimaryKey(id);
        if(announcement == null) {
            throw new ApplicationException(ApplicationException.ANNOUNCEMENT_NOT_EXISTS, "修改首页公告实体不存在");
        }
        announcement.setTitle(title);
        announcement.setContent(content);
        announcement.setPublishTime(publishTime);
        announcement.setUpdateTime(new Date());
        announcement.setUpdateUserId(currentId);
        iAnnouncementDao.updateByPrimaryKey(announcement);
        return announcement;
    }
}
