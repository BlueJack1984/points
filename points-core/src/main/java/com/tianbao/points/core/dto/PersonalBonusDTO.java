package com.tianbao.points.core.dto;


import com.tianbao.points.core.entity.PersonalBonus;
import com.tianbao.points.core.entity.User;
import lombok.Data;

/**
 * 个人积分增值的传输实体
 * 包装个人信息的相关属性
 * @author lushusheng 2018-11-28
 */
@Data
public class PersonalBonusDTO extends PersonalBonus {

    /**
     * 包装个人信息的属性
     *
     */
    private User user;
}
