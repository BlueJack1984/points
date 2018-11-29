package com.tianbao.points.core.service.impl;

import com.tianbao.points.core.dao.IDepartmentDao;
import com.tianbao.points.core.entity.Department;
import com.tianbao.points.core.exception.ApplicationException;
import com.tianbao.points.core.service.IDepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @desc 部门服务接口
 * @author lushusheng
 * @date 2018-11-27
 *
 */
@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements IDepartmentService {
    /**
     * 注入部门dao
     */
    private final IDepartmentDao iDepartmentDao;

    @Override
    public void deleteById(Long id) throws ApplicationException {

    }

    @Override
    public Department save(Department record) throws ApplicationException {
        return null;
    }

    @Override
    public Department saveSelective(Department record) throws ApplicationException {
        return null;
    }

    @Override
    public Department selectById(Long id) throws ApplicationException {
        return null;
    }

    @Override
    public void updateByIdSelective(Department record) throws ApplicationException {

    }

    @Override
    public void updateById(Department record) throws ApplicationException {

    }

    /**
     * @author lushusheng
     * @Date 2018-11-29
     * @Desc 根据部门的id集合查询部门列表,个人档案部分使用
     * @param ids 部门的id集合
     * @return 返回部门列表
     * @update
     */
    @Override
    public List<Department> getListByIds(List<Long> ids) throws ApplicationException {
        List<Department> departmentList = iDepartmentDao.selectListByIds(ids);
        return departmentList;
    }
}
