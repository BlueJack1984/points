package com.tianbao.points.core.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tianbao.points.core.constant.StatusCode;
import com.tianbao.points.core.dao.IRoleDao;
import com.tianbao.points.core.entity.Role;
import com.tianbao.points.core.exception.ApplicationException;
import com.tianbao.points.core.service.IRoleService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @desc 角色服务接口
 * @author lushusheng
 * @date 2018-11-27
 *
 */
@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements IRoleService {
    /**
     * 注入角色dao
     */
    private final IRoleDao iRoleDao;

    @Override
    public void deleteById(Long id) throws ApplicationException {

    }

    @Override
    public void save(Role record) throws ApplicationException {

    }

    @Override
    public void saveSelective(Role record) throws ApplicationException {

    }

    /**
     * @author lushusheng
     * @Date 2018-11-27
     * @Desc 根据id查询角色实体
     * @return 返回角色实体
     * @update
     */
    @Override
    public Role selectById(Long id) throws ApplicationException {
        Role role = iRoleDao.selectByPrimaryKey(id);
        return role;
    }

    @Override
    public void updateByIdSelective(Role record) throws ApplicationException {

    }

    /**
     * @desc 根据id更新实体信息
     * @author lushusheng 2018-12-03
     * @param record 角色实体
     * @return 无返回
     * @throws ApplicationException 保存异常
     */
    @Override
    public void updateById(Role record) throws ApplicationException {
        iRoleDao.updateByPrimaryKey(record);
    }

    /**
     * @author lushusheng
     * @Date 2018-11-27
     * @Desc 根据用户id查询相关角色列表，一个用户可以对应多个角色
     * @return 返回角色集合数据
     * @update
     */
    @Override
    public List<Role> getListByUserId(Long userId) throws ApplicationException {
        List<Role> roleList = iRoleDao.selectListByUserId(userId);
        return roleList;
    }

    /**
     * @desc 获取角色列表，分页展示
     * @author lushusheng 2018-12-03
     * @param pageNo 当前页码
     * @param pageSize 数据条数
     * @return 返回数据列表
     * @throws ApplicationException 保存异常
     */
    @Override
    public PageInfo<Role> getListPage(Integer pageNo, Integer pageSize) throws ApplicationException {
        PageHelper.startPage(pageNo, pageSize);
        List<Role> roleList = iRoleDao.selectListPage();
        PageInfo<Role> pageInfo = new PageInfo<>(roleList);
        return pageInfo;
    }

    /**
     * @desc 根据id删除实体
     * @author lushusheng 2018-12-03
     * @param currentId 当前用户id
     * @param id 实体id
     * @return 返回操作结果
     * @throws ApplicationException 保存异常
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(Long id, Long currentId) throws ApplicationException {
        //逻辑删除，更改status状态，是否还需要删除关联表？？？
        Role role = iRoleDao.selectByPrimaryKey(id);
        role.setStatus(StatusCode.FORBIDDEN.getCode());
        role.setUpdateTime(new Date());
        role.setUpdateUserId(currentId);
        iRoleDao.updateByPrimaryKey(role);

        //删除会员角色关联表，逻辑删除

        //删除角色权限关联表，逻辑删除
    }

    /**
     * @desc 保存实体信息
     * @author lushusheng 2018-12-03
     * @param currentId 当前用户id
     * @param name 角色名称
     * @param description 角色描述
     * @return 返回保存后的数据
     * @throws ApplicationException 保存异常
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public Role insert(String name, String description, Long currentId) throws ApplicationException {
        Role role = new Role();
        role.setName(name);
        if(! StringUtils.isEmpty(description)) {
            role.setDescription(description);
        }
        role.setStatus(StatusCode.NORMAL.getCode());
        //role.setDomain(1);
        //role.setType(1);
        role.setCreateTime(new Date());
        role.setCreateUserId(currentId);
        role.setUpdateTime(new Date());
        role.setUpdateUserId(currentId);
        iRoleDao.insert(role);
        return role;
    }
}
