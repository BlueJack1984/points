package com.tianbao.points.app.controller;


import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @desc 权限入口
 * @author lushusheng
 * @date 2018-11-27
 */

@Api(value = "authority", description = "权限")
@RestController
@RequiredArgsConstructor
@RequestMapping("/authority")
@Slf4j
public class AuthorityController {
}
