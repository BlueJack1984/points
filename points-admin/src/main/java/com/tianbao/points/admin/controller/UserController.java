package com.tianbao.points.admin.controller;

import com.tianbao.points.core.dto.UserDTO;
import com.tianbao.points.core.dto.response.OutputResult;
import com.tianbao.points.core.exception.ApplicationException;
import com.tianbao.points.core.service.IUserService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @desc 用户管理员入口
 * @author lushusheng
 * @date 2018-11-27
 */

@Api(value = "user", description = "用户管理员接口")
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
@Slf4j
public class UserController {
    /**
     * 注入用户服务service
     */
    private final IUserService userServer;

    /**
     * @author lushusheng
     * @Date 2018-11-28
     * @Desc 获取用户的个人档案资料，包装了职位和角色信息
     * @return 返回查询到用户数据
     * @update
     */
    @CrossOrigin
    @GetMapping("/personal/get")
    public OutputResult<UserDTO> getPersonalInfo(
            @RequestHeader(value = "_current_id", required = false, defaultValue = "110") Long currentId)throws ApplicationException {
        UserDTO userDTO = userServer.getPersonalInfo(currentId);
        return new OutputResult<>(userDTO);
    }

    /**
     * @author lushusheng
     * @Date 2018-11-28
     * @Desc 更新用户的登录密码，这里不是指超级密码
     * @return 无返回，操作错误抛出异常
     * @update
     */
    //void updatePassword(Long id)throws ApplicationException;

    /**
     * @author lushusheng
     * @Date 2018-11-28
     * @Desc 更新用户的超级密码，这个用户只有一个，顶级管理员，所以要先判断身份
     * @return 无返回，操作错误抛出异常
     * @update
     */
    //void updateSuperPassword(Long id)throws ApplicationException;


    /**
     * @desc 保存一条用户管理员数据
     * @author lushusheng 2018-11-29
     * @param announcementInput 首页公告实体属性：标题内容等
     * @param currentId 当前用户id
     * @return 是否保存成功
     * @throws ApplicationException 保存异常
     */
    @CrossOrigin
    @PostMapping("/save")
    public OutputResult<Void> save() {
        return null;
    }

}
