package com.tianbao.points.core.service.impl;


import com.tianbao.points.core.dao.IUserDao;
import com.tianbao.points.core.dto.UserDTO;
import com.tianbao.points.core.entity.User;
import com.tianbao.points.core.exception.ApplicationException;
import com.tianbao.points.core.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @desc 首页公告服务接口
 * @author lushusheng
 * @date 2018-11-27
 *
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {

    private final IUserDao iUserDao;
    /**
     * @author lushusheng
     * @Date 2018-11-28
     * @Desc 获取用户的个人档案资料，包装了职位和角色信息
     * @return 返回查询数据
     * @update
     */
    @Override
    public UserDTO getPersonalInfo(Long id) throws ApplicationException {
        return null;
    }

    /**
     * @author lushusheng
     * @Date 2018-11-28
     * @Desc 更新用户的登录密码，这里不是指超级密码
     * @return 无返回，操作错误抛出异常
     * @update
     */
    @Override
    public void updatePassword(Long id) throws ApplicationException {

    }

    /**
     * @author lushusheng
     * @Date 2018-11-28
     * @Desc 更新用户的超级密码，这个用户只有一个，顶级管理员，所以要先判断身份
     * @return 无返回，操作错误抛出异常
     * @update
     */
    @Override
    public void updateSuperPassword(Long id) throws ApplicationException {

    }

    @Override
    public void deleteById(Long id) throws ApplicationException {

    }

    @Override
    public void save(User record) throws ApplicationException {

    }

    @Override
    public void saveSelective(User record) throws ApplicationException {

    }

    @Override
    public User selectById(Long id) throws ApplicationException {
        return null;
    }

    @Override
    public void updateByIdSelective(User record) throws ApplicationException {

    }

    @Override
    public void updateById(User record) throws ApplicationException {

    }
}
