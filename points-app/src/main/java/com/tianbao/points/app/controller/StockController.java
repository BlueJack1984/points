package com.tianbao.points.app.controller;


import com.github.pagehelper.PageInfo;
import com.tianbao.points.app.dto.request.StockInput;
import com.tianbao.points.core.dto.response.OutputListResult;
import com.tianbao.points.core.dto.response.OutputResult;
import com.tianbao.points.core.entity.Stock;
import com.tianbao.points.core.exception.ApplicationException;
import com.tianbao.points.core.service.IStockService;
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
import java.util.List;

/**
 * @desc 股票证券指数服务入口
 * @author lushusheng
 * @date 2018-11-27
 */

@Api(value = "stock", description = "股票证券指数")
@RestController
@RequiredArgsConstructor
@RequestMapping("/stock")
@Slf4j
public class StockController {
    /**
     * 注入股票证券指数服务service
     */
    private final IStockService stockServer;
    private static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    /**
     * @author lushusheng
     * @Date 2018-11-28
     * @Desc 获取股票证券指数列表
     * @return 返回查询到的数据列表
     * @update
     */
    @ApiOperation(value = "获取股票证券指数列表", notes = "分页进行查询操作")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "header", dataType = "Long", name = "currentId", value = "当前用户id", required = true),
        @ApiImplicitParam(paramType = "query", dataType = "Integer", name = "pageNo", value = "显示页码", required = false),
        @ApiImplicitParam(paramType = "query", dataType = "Integer", name = "pageSize", value = "数据条数", required = false)})
    @CrossOrigin
    @GetMapping("/list/page")
    public OutputListResult<Stock> getListPage(
            @RequestHeader(value = "_current_id", required = false, defaultValue = "110") Long currentId,
            @RequestParam(value = "pageNo", required = false, defaultValue = "1")Integer pageNo,
            @RequestParam(value = "pageSize", required = false, defaultValue = "25")Integer pageSize)throws ApplicationException {
        PageInfo<Stock> pageInfo = stockServer.getListPage(pageNo, pageSize);
        return new OutputListResult<>(pageInfo);
    }

    /**
     * @author lushusheng
     * @Date 2018-11-28
     * @Desc 根据实体id查询证券指数数据
     * @return 返回查询到的单个实体数据
     * @update
     */
    @ApiOperation(value = "查询证券指数数据", notes = "根据实体id查询证券指数数据")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "header", dataType = "Long", name = "currentId", value = "当前用户id", required = true),
        @ApiImplicitParam(paramType = "query", dataType = "Long", name = "id", value = "证券指数实体id", required = true)})
    @CrossOrigin
    @GetMapping("/get/{id}")
    public OutputResult<Stock> get(
            @RequestHeader(value = "_current_id", required = false, defaultValue = "110") Long currentId,
            @PathVariable("id") Long id)throws ApplicationException {
        Stock stock = stockServer.selectById(id);
        return new OutputResult<>(stock);
    }

    /**
     * @author lushusheng
     * @Date 2018-11-28
     * @Desc 根据实体id删除特定证券指数数据
     * @return 返回操作结果
     * @update
     */
    @ApiOperation(value = "删除特定证券指数数据", notes = "根据实体id删除特定证券指数数据")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "header", dataType = "Long", name = "currentId", value = "当前用户id", required = true),
        @ApiImplicitParam(paramType = "query", dataType = "Long", name = "id", value = "证券指数实体id", required = true)})
    @CrossOrigin
    @GetMapping("/delete/{id}")
    public OutputResult<Void> delete(
            @RequestHeader(value = "_current_id", required = false, defaultValue = "110") Long currentId,
            @PathVariable("id") Long id)throws ApplicationException {
        stockServer.deleteById(id);
        return new OutputResult<>();
    }

    /**
     * @author lushusheng
     * @Date 2018-11-28
     * @Desc 盛华天宝k线图，获取股票证券指数的列表，不分页
     * @param num 表示要取得数据条数
     * @return 返回查询到的列表数据,正序排列，最新的num条
     * @update
     */
    @ApiOperation(value = "获取股票证券指数的列表", notes = "获取股票证券指数的列表")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "header", dataType = "Long", name = "currentId", value = "当前用户id", required = true),
        @ApiImplicitParam(paramType = "query", dataType = "Integer", name = "num", value = "列表数据条数", required = true)})
    @CrossOrigin
    @GetMapping("/list/{num}")
    public OutputListResult<Stock> getListNum(
            @RequestHeader(value = "_current_id", required = false, defaultValue = "110") Long currentId,
            @PathVariable("num") Integer num)throws ApplicationException {
        if(num == null || num.intValue() <= 0) {
            throw new ApplicationException(1, "");
        }
        List<Stock> stockList = stockServer.getListNum(num);
        return new OutputListResult<>(stockList);
    }
}
