package com.tianbao.points.admin.controller;

import com.tianbao.points.core.service.ISystemBonusService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @desc 系统积分增值服务入口
 * @author lushusheng
 * @date 2018-11-27
 */

@Api(value = "systemBonus", description = "系统积分增值")
@RestController
@RequiredArgsConstructor
@RequestMapping("/system/bonus")
@Slf4j
public class SystemBonusController {
    /**
     * 注入系统积分增值服务service
     */
    private final ISystemBonusService systemBonusServer;
}
