package com.tianbao.points.core.dao;

import com.tianbao.points.core.dao.base.IBaseDao;
import com.tianbao.points.core.entity.RoleAuthority;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author lushusheng
 * @Date 2018-11-29
 * @Desc 持久层拓展接口
 */
@Mapper
public interface IRoleAuthorityDao extends IBaseDao<RoleAuthority, Long> {

}