package com.tianbao.points.admin.controller;

import com.github.pagehelper.PageInfo;
import com.tianbao.points.admin.dto.request.ReplyInput;
import com.tianbao.points.core.dto.MessageDTO;
import com.tianbao.points.core.dto.response.OutputListResult;
import com.tianbao.points.core.dto.response.OutputResult;
import com.tianbao.points.core.exception.ApplicationException;
import com.tianbao.points.core.service.IMessageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @desc 留言服务入口
 * @author lushusheng
 * @date 2018-11-27
 */

@Api(value = "message", description = "留言")
//@RestController
@RequiredArgsConstructor
@RequestMapping("/message")
@Slf4j
public class MessageController {
    /**
     * 注入留言服务service
     */
    //private final IMessageService messageServer;
}
