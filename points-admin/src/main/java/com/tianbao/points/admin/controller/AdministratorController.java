package com.tianbao.points.admin.controller;


import com.github.pagehelper.PageInfo;
import com.tianbao.points.admin.dto.request.AdminInput;
import com.tianbao.points.admin.dto.request.AdminUpdateInput;
import com.tianbao.points.admin.dto.request.UserInput;
import com.tianbao.points.core.dto.UserDTO;
import com.tianbao.points.core.dto.response.OutputListResult;
import com.tianbao.points.core.dto.response.OutputResult;
import com.tianbao.points.core.entity.User;
import com.tianbao.points.core.exception.ApplicationException;
import com.tianbao.points.core.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @desc 管理员用户的管理入口
 * @author lushusheng
 * @date 2018-12-05
 */

@Api(value = "administrator", description = "管理员用户的管理")
@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
@Slf4j
public class AdministratorController {

    /**
     * 注入用户服务service
     */
    private final IUserService userServer;

    /**
     * @desc 查询管理员用户列表，分页展示
     * @author lushusheng 2018-12-03
     * @param currentId 当前用户id
     * @param pageNo 当前页码
     * @param pageSize 每页数据条数
     * @return 返回管理员列表信息
     * @throws ApplicationException 保存异常
     */
    @ApiOperation(value = "查询管理员列表，分页展示", notes = "查询管理员列表，分页展示")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "header", dataType = "Long", name = "currentId", value = "当前用户id", required = true),
        @ApiImplicitParam(paramType = "query", dataType = "Integer", name = "pageNo", value = "当前页码", required = false),
        @ApiImplicitParam(paramType = "query", dataType = "Integer", name = "pageSize", value = "数据条数", required = false)})
    @CrossOrigin
    @GetMapping("/list/page")
    public OutputListResult<UserDTO> getAdminListPage(
            @RequestHeader(value = "_current_id", required = false, defaultValue = "110") Long currentId,
            @RequestParam(value = "pageNo", required = false, defaultValue = "1")Integer pageNo,
            @RequestParam(value = "pageSize", required = false, defaultValue = "25")Integer pageSize)throws ApplicationException {

        PageInfo<UserDTO> pageInfo = userServer.getAdminListPage(pageNo, pageSize);
        return new OutputListResult<>(pageInfo);
    }

    /**
     * @desc 根据id查询特定管理员信息
     * @author lushusheng 2018-12-03
     * @param currentId 当前用户id
     * @param id 实体id
     * @return 返回查询管理员信息
     * @throws ApplicationException 查询异常
     */
    @ApiOperation(value = "根据id查询特定管理员信息", notes = "根据id查询特定管理员信息")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "header", dataType = "Long", name = "currentId", value = "当前用户id", required = true),
        @ApiImplicitParam(paramType = "query", dataType = "Long", name = "id", value = "实体id", required = false)})
    @CrossOrigin
    @GetMapping("/get/{id}")
    public OutputResult<UserDTO> getAdminListPage(
            @RequestHeader(value = "_current_id", required = false, defaultValue = "110") Long currentId,
            @PathVariable("id") Long id)throws ApplicationException {

        UserDTO userDTO = userServer.getPersonalInfo(id);
        return new OutputResult<>(userDTO);
    }

    /**
     * @desc 根据id删除特定管理员信息
     * @author lushusheng 2018-12-03
     * @param currentId 当前用户id
     * @param id 实体id
     * @return 返回操作结果
     * @throws ApplicationException 删除异常
     */
    @ApiOperation(value = "根据id删除特定管理员信息", notes = "根据id删除特定管理员信息")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "header", dataType = "Long", name = "currentId", value = "当前用户id", required = true),
        @ApiImplicitParam(paramType = "query", dataType = "Long", name = "id", value = "实体id", required = false)})
    @CrossOrigin
    @GetMapping("/delete/{id}")
    public OutputResult<Void> delete(
            @RequestHeader(value = "_current_id", required = false, defaultValue = "110") Long currentId,
            @PathVariable("id") Long id)throws ApplicationException {

       userServer.deleteById(id);
        return new OutputResult<>();
    }

    /**
     * @desc 保存特定管理员信息
     * @author lushusheng 2018-12-03
     * @param currentId 当前用户id
     * @param adminInput 实体参数
     * @return 返回数据
     * @throws ApplicationException 保存异常
     */
    @ApiOperation(value = "保存特定管理员信息", notes = "保存特定管理员信息")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "header", dataType = "Long", name = "currentId", value = "当前用户id", required = true),
        @ApiImplicitParam(paramType = "body", dataType = "AdminInput", name = "adminInput", value = "实体参数", required = true)})
    @CrossOrigin
    @PostMapping("/save")
    public OutputResult<UserDTO> save(
            @RequestHeader(value = "_current_id", required = false, defaultValue = "110") Long currentId,
            @RequestBody @Valid AdminInput adminInput)throws ApplicationException {
        if()
        User user = new User();
        //userServer.deleteById(id);
        return new OutputResult<>();
    }
    /**
     * @desc 修改特定管理员信息
     * @author lushusheng 2018-12-03
     * @param currentId 当前用户id
     * @param adminUpdateInput 实体参数
     * @return 返回数据
     * @throws ApplicationException 修改异常
     */
    @ApiOperation(value = "修改特定管理员信息", notes = "修改特定管理员信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", dataType = "Long", name = "currentId", value = "当前用户id", required = true),
            @ApiImplicitParam(paramType = "body", dataType = "AdminUpdateInput", name = "adminUpdateInput", value = "实体参数", required = false)})
    @CrossOrigin
    @PostMapping("/update")
    public OutputResult<UserDTO> update(
            @RequestHeader(value = "_current_id", required = false, defaultValue = "110") Long currentId,
            @RequestBody @Valid AdminUpdateInput adminUpdateInput)throws ApplicationException {

        //userServer.deleteById(id);
        return new OutputResult<>();
    }
}
