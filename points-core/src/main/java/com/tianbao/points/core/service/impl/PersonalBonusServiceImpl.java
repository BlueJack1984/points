package com.tianbao.points.core.service.impl;


import com.tianbao.points.core.dao.IPersonalBonusDao;
import com.tianbao.points.core.entity.PersonalBonus;
import com.tianbao.points.core.exception.ApplicationException;
import com.tianbao.points.core.service.IPersonalBonusService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @desc 个人积分增值服务接口
 * @author lushusheng
 * @date 2018-11-27
 *
 */
@Service
@RequiredArgsConstructor
public class PersonalBonusServiceImpl implements IPersonalBonusService {
    /**
     * 注入个人积分增值dao
     */
    private final IPersonalBonusDao iPersonalBonusDao;

    @Override
    public void deleteById(Long id) throws ApplicationException {

    }

    @Override
    public void save(PersonalBonus record) throws ApplicationException {

    }

    @Override
    public void saveSelective(PersonalBonus record) throws ApplicationException {

    }

    @Override
    public PersonalBonus selectById(Long id) throws ApplicationException {
        return null;
    }

    @Override
    public void updateByIdSelective(PersonalBonus record) throws ApplicationException {

    }

    @Override
    public void updateById(PersonalBonus record) throws ApplicationException {

    }
}
