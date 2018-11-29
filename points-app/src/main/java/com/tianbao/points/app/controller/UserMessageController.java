package com.tianbao.points.app.controller;


import com.tianbao.points.core.service.IUserMessageService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @desc 用户留言关联服务入口
 * @author lushusheng
 * @date 2018-11-27
 */

@Api(value = "userMessage", description = "用户留言关联")
@RestController
@RequiredArgsConstructor
@RequestMapping("/user/message")
@Slf4j
public class UserMessageController {
    /**
     * 注入用户留言关联服务service
     */
    private final IUserMessageService userMessageServer;
}
