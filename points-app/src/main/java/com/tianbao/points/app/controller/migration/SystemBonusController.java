package com.tianbao.points.app.controller.migration;


import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @desc 数据迁移的系统积分入口
 * @author lushusheng
 * @date 2018-01-25
 */

@Api(value = "systemBonus", description = "系统积分")
@RestController
@RequiredArgsConstructor
@RequestMapping("/migration/system/bonus")
@Slf4j
public class SystemBonusController {
}
