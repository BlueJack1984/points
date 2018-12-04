package com.tianbao.points.core.dao;

import com.tianbao.points.core.dao.base.IBaseDao;
import com.tianbao.points.core.dto.MessageDTO;
import com.tianbao.points.core.entity.Message;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lushusheng
 * @Date 2018-11-29
 * @Desc 持久层拓展接口
 */
@Mapper
public interface IMessageDao extends IBaseDao<Message, Long> {

    /**
     * @desc 根据会员id模糊查询留言数据
     * @author lushusheng 2018-12-04
     * @param ids 输入的留言id集合
     * @return 返回查询的留言实体数据列表
     */
    List<Message> getListByIds(@Param("ids") List<Long> ids);
}