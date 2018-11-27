package com.tianbao.points.core.dao;

import com.example.mybatisdemo.entity.RoleAuthority;

public interface RoleAuthorityMapper {
    int deleteByPrimaryKey(Long id);

    int insert(RoleAuthority record);

    int insertSelective(RoleAuthority record);

    RoleAuthority selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RoleAuthority record);

    int updateByPrimaryKey(RoleAuthority record);
}