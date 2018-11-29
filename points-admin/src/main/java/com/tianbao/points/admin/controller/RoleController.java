package com.tianbao.points.admin.controller;


import com.tianbao.points.core.service.IRoleService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @desc 角色服务入口
 * @author lushusheng
 * @date 2018-11-27
 */

@Api(value = "role", description = "角色")
@RestController
@RequiredArgsConstructor
@RequestMapping("/role")
@Slf4j
public class RoleController {
    /**
     * 注入角色服务service
     */
    private final IRoleService roleServer;
}
