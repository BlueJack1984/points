package com.tianbao.points.core.service;

import com.tianbao.points.core.entity.UserMessage;
import com.tianbao.points.core.exception.ApplicationException;
import com.tianbao.points.core.service.base.IBaseService;

/**
 * @desc 用户留言关联服务接口
 * @author lushusheng
 * @date 2018-11-27
 *
 */
public interface IUserMessageService extends IBaseService<UserMessage, Long> {

    /**
     * @desc 根据实体id和发送者id和接收者id删除实体
     * @author lushusheng 2018-12-01
     * @param senderId 发送者id
     * @param currentId 当前用户id
     * @param id 留言实体id
     * @return 返回删除操作结果
     */
    void deleteByIds(Long id, Long senderId, Long currentId) throws ApplicationException;
}
