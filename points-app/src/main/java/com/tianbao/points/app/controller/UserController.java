package com.tianbao.points.app.controller;

import com.tianbao.points.core.exception.ApplicationException;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
     * @desc 保存一条公告数据
     * @author lushusheng 2018-11-28
     * @param announcementInput 首页公告实体属性：标题内容等
     * @param currentId 当前用户id
     * @return 是否保存成功
     * @throws ApplicationException 保存异常
     */
}
