package com.tianbao.points.app.controller;


import com.github.pagehelper.PageInfo;
import com.tianbao.points.core.dto.AnnouncementDTO;
import com.tianbao.points.core.dto.response.OutputListResult;
import com.tianbao.points.core.dto.response.OutputResult;
import com.tianbao.points.core.entity.Announcement;
import com.tianbao.points.core.exception.ApplicationException;
import com.tianbao.points.core.service.IAnnouncementService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @desc 首页公告入口
 * @author lushusheng
 * @date 2018-12-17
 */

@Api(value = "announcement", description = "首页公告")
@RestController
@RequiredArgsConstructor
@RequestMapping("/announcement")
@Slf4j
public class AnnouncementController {

    private final IAnnouncementService announcementServer;
    private static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * @desc 获取首页公告列表,分页展示
     * @author lushusheng 2018-12-04
     * @param currentId 当前用户id
     * @param pageNo 当前页码
     * @param pageSize 每页显示条数
     * @return 返回实体数据列表
     * @throws ApplicationException 保存异常
     */
    @ApiOperation(value = "获取首页公告列表", notes = "获取首页公告列表")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "header", dataType = "Long", name = "currentId", value = "当前用户id", required = true),
        @ApiImplicitParam(paramType = "query", dataType = "Integer", name = "pageNo", value = "显示页码", required = false),
        @ApiImplicitParam(paramType = "query", dataType = "Integer", name = "pageSize", value = "每页显示数据条数", required = false)})
    @CrossOrigin
    @GetMapping("/list/page")
    public OutputListResult<AnnouncementDTO> getListPage(
            @RequestHeader(value = "_current_id", required = false, defaultValue = "110") Long currentId,
            @RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo,
            @RequestParam(value = "pageSize", required = false, defaultValue = "20") Integer pageSize) throws Exception {

        PageInfo<AnnouncementDTO> pageInfo = announcementServer.getListPage(pageNo, pageSize);
        return new OutputListResult<>(pageInfo);
    }

    /**
     * @desc 根据id查询一条公告数据
     * @author lushusheng 2018-11-28
     * @param id 要查询的公告id
     * @param currentId 当前用户id
     * @return 返回查询的公告实体数据
     * @throws ApplicationException 查询异常
     */
    @ApiOperation(value = "查询首页公告数据", notes = "根据id查询一条公告数据")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "query", dataType = "Long", name = "id", value = "首页公告实体id", required = true),
        @ApiImplicitParam(paramType = "header", dataType = "Long", name = "currentId", value = "当前用户id", required = true)
    })
    @CrossOrigin
    @GetMapping("/get/{id}")
    public OutputResult<Announcement> get(
            @RequestHeader(value = "_current_id", required = false, defaultValue = "110") Long currentId,
            @PathVariable Long id)throws ApplicationException {

        Announcement announcement = announcementServer.selectById(id);
        return new OutputResult<>(announcement);
    }
}
