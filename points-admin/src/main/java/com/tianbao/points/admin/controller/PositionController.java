package com.tianbao.points.admin.controller;


import com.tianbao.points.core.service.IPositionService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @desc 职位入口
 * @author lushusheng
 * @date 2018-11-27
 */

@Api(value = "position", description = "职位")
@RestController
@RequiredArgsConstructor
@RequestMapping("/position")
@Slf4j
public class PositionController {
    /**
     * 注入职位服务service
     */
    private final IPositionService positionServer;
}
