package com.tianbao.points.app.controller;


import com.tianbao.points.core.service.IPersonalBonusService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @desc 个人积分增值服务入口
 * @author lushusheng
 * @date 2018-11-27
 */

@Api(value = "personalBonus", description = "个人积分增值")
@RestController
@RequiredArgsConstructor
@RequestMapping("/personal/bonus")
@Slf4j
public class PersonalBonusController {
    /**
     * 注入个人积分增值服务service
     */
    private final IPersonalBonusService personalBonusServer;
}
