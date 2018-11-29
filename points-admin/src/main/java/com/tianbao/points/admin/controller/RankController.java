package com.tianbao.points.admin.controller;

import com.tianbao.points.core.service.IRankService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @desc 会员等级服务入口
 * @author lushusheng
 * @date 2018-11-27
 */

@Api(value = "rank", description = "会员等级")
@RestController
@RequiredArgsConstructor
@RequestMapping("/rank")
@Slf4j
public class RankController {
    /**
     * 注入会员等级服务service
     */
    private final IRankService rankServer;

}
