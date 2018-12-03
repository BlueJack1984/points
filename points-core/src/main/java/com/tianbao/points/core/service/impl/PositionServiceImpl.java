package com.tianbao.points.core.service.impl;


import com.tianbao.points.core.dao.IPositionDao;
import com.tianbao.points.core.dto.PositionDTO;
import com.tianbao.points.core.entity.Department;
import com.tianbao.points.core.entity.Position;
import com.tianbao.points.core.exception.ApplicationException;
import com.tianbao.points.core.service.IDepartmentService;
import com.tianbao.points.core.service.IPositionService;
import com.tianbao.points.core.utils.BeanHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @desc 职位服务接口
 * @author lushusheng
 * @date 2018-11-27
 *
 */
@Service
@RequiredArgsConstructor
public class PositionServiceImpl implements IPositionService {
    /**
     * 注入职位dao
     */
    private final IPositionDao iPositionDao;
    /**
     * 注入部门service
     */
    private final IDepartmentService departmentServer;

    @Override
    public void deleteById(Long id) throws ApplicationException {

    }

    @Override
    public void save(Position record) throws ApplicationException {

    }

    @Override
    public void saveSelective(Position record) throws ApplicationException {

    }

    @Override
    public Position selectById(Long id) throws ApplicationException {
        return null;
    }

    @Override
    public void updateByIdSelective(Position record) throws ApplicationException {

    }

    @Override
    public void updateById(Position record) throws ApplicationException {

    }

    /**
     * @author lushusheng
     * @Date 2018-11-29
     * @Desc 根据管理员id查询职位列表,个人档案部分使用
     * @param userId 管理员id
     * @return 返回职位列表
     * @update
     */
    @Override
    public List<PositionDTO> getListByUserId(Long userId) throws ApplicationException {
        List<PositionDTO> positionDTOList = new ArrayList<>();
        List<Position> positionList = iPositionDao.selectListByUserId(userId);
        if(positionList == null || positionList.size() <= 0) {
            return positionDTOList;
        }
        //不为空
        List<Long> departmentIds = new ArrayList<>();
        for(Position position: positionList) {
            departmentIds.add(position.getId());
        }
        List<Department> departmentList = departmentServer.getListByIds(departmentIds);
        for(Position position: positionList) {
            PositionDTO positionDTO = new PositionDTO();
            BeanHelper.copyProperties(positionDTO, position);
            for(Department department: departmentList) {
                if(department.getId() != null && department.getId().equals(position.getDepartmentId())) {
                    positionDTO.setDepartment(department);
                    break;
                }
            }
            positionDTOList.add(positionDTO);
        }
        return positionDTOList;
    }
}
