package com.tianbao.points.admin.controller;


import com.tianbao.points.core.service.IRoleAuthorityService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @desc 角色权限关联服务入口
 * @author lushusheng
 * @date 2018-11-27
 */

@Api(value = "roleAuthority", description = "角色权限关联")
@RestController
@RequiredArgsConstructor
@RequestMapping("/role/authority")
@Slf4j
public class RoleAuthorityController {
    /**
     * 注入角色权限关联服务service
     */
    private final IRoleAuthorityService roleAuthorityServer;
}
