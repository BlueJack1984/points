package com.tianbao.points.admin.controller;


import com.tianbao.points.core.service.IUserRoleService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @desc 用户角色关联服务入口
 * @author lushusheng
 * @date 2018-11-27
 */

@Api(value = "userRole", description = "用户角色关联")
@RestController
@RequiredArgsConstructor
@RequestMapping("/user/role")
@Slf4j
public class UserRoleController {
    /**
     * 注入用户角色关联服务service
     */
    private final IUserRoleService userRoleServer;
}
