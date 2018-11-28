package com.tianbao.points.admin.controller;


import com.tianbao.points.admin.dto.request.AnnouncementInput;
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
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @desc 首页公告入口
 * @author lushusheng
 * @date 2018-11-27
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
     * @desc 首页公告入口
     * @author lushusheng 2018-10-09
     * @param activity activity实体对象
     * @param currentId 当前用户id
     * @return 是否保存成功
     * @throws ApplicationException 保存异常
     */
//    @ApiOperation(value = "对活动实体进行保存操作", notes = "根据activity实体和当前用户id对活动进行保存操作")
//    @ApiImplicitParams({
//            @ApiImplicitParam(paramType = "body", dataType = "Activity", name = "activity", value = "活动实体", required = true)})
    @CrossOrigin
    @PostMapping("/save")
    public OutputResult<Void> save(
            @RequestBody @Valid AnnouncementInput announcementInput,
            @RequestHeader(value = "_current_id", required = false, defaultValue = "110") Long currentId) throws Exception {
        Date publishTime = SDF.parse(announcementInput.getPublishTime());
        Announcement announcement = new Announcement();
        announcement.setTitle(announcementInput.getTitle());
        announcement.setContent(announcementInput.getContent());
        announcement.setPublishTime(publishTime);
        announcement.setUserId(currentId);
        announcementServer.save(announcement);
        return new OutputResult<>();
    }
}
