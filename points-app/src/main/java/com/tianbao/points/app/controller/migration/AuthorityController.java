package com.tianbao.points.app.controller.migration;

import com.tianbao.points.app.controller.migration.input.AuthorityMigrationInput;
import com.tianbao.points.core.dto.response.OutputResult;
import com.tianbao.points.core.exception.ApplicationException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @desc 数据迁移的权限数据入口
 * @author lushusheng
 * @date 2018-01-25
 */

@Api(value = "authority", description = "权限")
@RestController
@RequiredArgsConstructor
@RequestMapping("/migration/authority")
@Slf4j
public class AuthorityController {


    /**
     * @desc 新建保存一条权限信息
     * @author lushusheng 2018-1- 25
     * @param currentId 当前用户id
     * @param userInput 实体参数
     * @return 返回数据
     * @throws ApplicationException 保存异常
     */
    @ApiOperation(value = "新建保存一条权限信息", notes = "新建保存一条权限信息")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "header", dataType = "Long", name = "currentId", value = "当前用户id", required = true),
        @ApiImplicitParam(paramType = "body", dataType = "UserInput", name = "userInput", value = "实体参数", required = true)})
    @CrossOrigin
    @PostMapping("/save")
    //@RequiresPermissions({"app:user:save"})
    //@RequiresAuthentication
    public OutputResult<Void> save(
            @RequestHeader(value = "_current_id", required = false, defaultValue = "110") Long currentId,
            @RequestBody @Valid AuthorityMigrationInput authorityMigrationInput)throws ApplicationException {
        return new OutputResult<>();
    }
}
