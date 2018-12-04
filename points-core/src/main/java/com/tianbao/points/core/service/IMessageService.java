package com.tianbao.points.core.service;

import com.github.pagehelper.PageInfo;
import com.tianbao.points.core.dto.MessageDTO;
import com.tianbao.points.core.entity.Message;
import com.tianbao.points.core.exception.ApplicationException;
import com.tianbao.points.core.service.base.IBaseService;

import java.util.List;

/**
 * @desc 留言服务接口
 * @author lushusheng
 * @date 2018-11-27
 *
 */
public interface IMessageService extends IBaseService<Message, Long> {

    /**
     * @desc 根据留言id集合查询留言列表
     * @author lushusheng 2018-12-04
     * @param ids 输入的留言集合
     * @return 返回查询的留言实体数据列表
     * @throws ApplicationException 查询异常
     */
    List<Message> getListByIds(List<Long> ids) throws ApplicationException;

}
