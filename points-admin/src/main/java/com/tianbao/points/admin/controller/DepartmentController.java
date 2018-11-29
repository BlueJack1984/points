package com.tianbao.points.admin.controller;


import com.tianbao.points.core.service.IDepartmentService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @desc 部门入口
 * @author lushusheng
 * @date 2018-11-27
 */

@Api(value = "department", description = "部门")
@RestController
@RequiredArgsConstructor
@RequestMapping("/department")
@Slf4j
public class DepartmentController {
    /**
     * 注入部门服务service
     */
    private final IDepartmentService departmentServer;

}
