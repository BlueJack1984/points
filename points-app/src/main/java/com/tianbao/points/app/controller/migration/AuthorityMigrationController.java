package com.tianbao.points.app.controller.migration;

import com.tianbao.points.app.controller.migration.input.AuthorityMigrationInput;
import com.tianbao.points.core.constant.StatusCode;
import com.tianbao.points.core.dto.response.OutputResult;
import com.tianbao.points.core.entity.Authority;
import com.tianbao.points.core.exception.ApplicationException;
import com.tianbao.points.core.service.IAuthorityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;

/**
 * @desc 数据迁移的权限数据入口
 * @author lushusheng
 * @date 2019-01-28
 */

@Api(value = "authority", description = "权限")
@RestController
@RequiredArgsConstructor
@RequestMapping("/migration/authority")
@Slf4j
public class AuthorityMigrationController {

    private final IAuthorityService authorityService;
    /**
     * @desc 新建保存一条权限信息
     * @author lushusheng 2018-1- 25
     * @param currentId 当前用户id
     * @param authorityMigrationInput 实体参数
     * @return 返回数据
     * @throws ApplicationException 保存异常
     */
    @ApiOperation(value = "新建保存一条权限信息", notes = "新建保存一条权限信息")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "header", dataType = "Long", name = "currentId", value = "当前用户id", required = true),
        @ApiImplicitParam(paramType = "body", dataType = "AuthorityMigrationInput", name = "authorityMigrationInput", value = "实体参数", required = true)})
    @CrossOrigin
    @PostMapping("/save")
    //@RequiresPermissions({"app:user:save"})
    //@RequiresAuthentication
    public OutputResult<Authority> save(
            @RequestHeader(value = "_current_id", required = false, defaultValue = "110") Long currentId,
            @RequestBody @Valid AuthorityMigrationInput authorityMigrationInput)throws ApplicationException {
        Authority authority = new Authority();
        copyProperties(authority, authorityMigrationInput);
        authority.setStatus(StatusCode.NORMAL.getCode());
        authority.setCreateTime(new Date());
        authority.setCreateUserId(currentId);
        authority.setUpdateTime(new Date());
        authority.setUpdateUserId(currentId);
        authorityService.save(authority);
        return new OutputResult<>(authority);
    }
    private void copyProperties(Authority target, AuthorityMigrationInput source) {
        target.setId(source.getId());
        target.setCode(source.getCode());
        target.setName(source.getName());
        target.setUrl(source.getUrl());
        target.setType(source.getType());
        target.setPermission(source.getPermission());
        target.setDescription(source.getDescription());
    }
}
