package com.tianbao.points.app.controller;

import com.tianbao.points.core.service.IConsumeRecordService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @desc 消费记录入口
 * @author lushusheng
 * @date 2018-12-17
 */

@Api(value = "consumeRecord", description = "消费记录")
@RestController
@RequiredArgsConstructor
@RequestMapping("/consume/record")
@Slf4j
public class ConsumeRecordController {

    private final IConsumeRecordService consumeRecordServer;
}
