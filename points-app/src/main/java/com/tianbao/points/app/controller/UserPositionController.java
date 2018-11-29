package com.tianbao.points.app.controller;


import com.tianbao.points.core.service.IUserPositionService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @desc 用户职位关联服务入口
 * @author lushusheng
 * @date 2018-11-27
 */

@Api(value = "userPosition", description = " 用户职位关联")
@RestController
@RequiredArgsConstructor
@RequestMapping("/user/position")
@Slf4j
public class UserPositionController {
    /**
     * 注入用户职位关联服务service
     */
    private final IUserPositionService userPositionServer;
}
