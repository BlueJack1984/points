package com.tianbao.points.admin.controller;


import com.tianbao.points.admin.dto.request.AnnouncementInput;
import com.tianbao.points.admin.dto.request.AuthorityInput;
import com.tianbao.points.core.dto.response.OutputResult;
import com.tianbao.points.core.entity.Announcement;
import com.tianbao.points.core.entity.Authority;
import com.tianbao.points.core.exception.ApplicationException;
import com.tianbao.points.core.service.IAuthorityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.Date;

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
    /**
     * 注入权限服务service
     */
    private final IAuthorityService authorityServer;


    /**
     * @desc 保存一条权限数据
     * @author lushusheng 2018-12-17
     * @param authorityInput 权限数据实体属性
     * @param currentId 当前用户id
     * @return 保存成功实体数据
     * @throws ApplicationException 保存异常
     */
    @ApiOperation(value = "保存一条权限数据", notes = "保存一条权限数据")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "body", dataType = "AuthorityInput", name = "authorityInput", value = "权限数据实体", required = true),
        @ApiImplicitParam(paramType = "header", dataType = "Long", name = "currentId", value = "当前用户id", required = true)
    })
    @CrossOrigin
    @PostMapping("/save")
    public OutputResult<Authority> save(
            @RequestBody @Valid AuthorityInput authorityInput,
            @RequestHeader(value = "_current_id", required = false, defaultValue = "110") Long currentId) throws ApplicationException {

        Authority authority = new Authority();
        copyProperties(authority, authorityInput);
        Authority saved = authorityServer.save(authority, currentId);
        return new OutputResult<>(saved);
    }

    /**
     * @desc 拷贝权限数据的属性
     * @author lushusheng 2018-12-17
     * @param target 目标权限数据实体
     * @param authorityInput 当前用户id
     * @return 无返回
     * @throws ApplicationException 拷贝异常
     */
    private void copyProperties(Authority target, AuthorityInput authorityInput) throws ApplicationException {

        if(target == null || authorityInput == null) {
            return;
        }
        target.setName(authorityInput.getName());
        target.setUrl(authorityInput.getUrl());
        target.setPermission(authorityInput.getPermission());
        target.setType(authorityInput.getType());
        if(! StringUtils.isEmpty(authorityInput.getCode())) {
            target.setCode(authorityInput.getCode());
        }
        if(! StringUtils.isEmpty(authorityInput.getDescription())) {
            target.setDescription(authorityInput.getDescription());
        }
    }
}
