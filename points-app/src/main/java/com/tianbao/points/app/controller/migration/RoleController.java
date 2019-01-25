package com.tianbao.points.app.controller.migration;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @desc 数据迁移的角色入口
 * @author lushusheng
 * @date 2018-01-25
 */

@Api(value = "role", description = "角色")
@RestController
@RequiredArgsConstructor
@RequestMapping("/migration/role")
@Slf4j
public class RoleController {
}
