package com.tianbao.points.admin.controller;

import com.tianbao.points.core.service.IMessageService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @desc 留言服务入口
 * @author lushusheng
 * @date 2018-11-27
 */

@Api(value = "message", description = "留言")
@RestController
@RequiredArgsConstructor
@RequestMapping("/message")
@Slf4j
public class MessageController {
    /**
     * 注入留言服务service
     */
    private final IMessageService messageServer;


}
