package com.tianbao.points.admin.controller;


import com.github.pagehelper.PageInfo;
import com.tianbao.points.admin.dto.request.StockInput;
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
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
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
    //@RequiresPermissions({"admin:stock:list"})
    //@RequiresAuthentication
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
    //@RequiresPermissions({"admin:stock:query"})
    //@RequiresAuthentication
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
    //@RequiresPermissions({"admin:stock:delete"})
    //@RequiresAuthentication
    public OutputResult<Void> delete(
            @RequestHeader(value = "_current_id", required = false, defaultValue = "110") Long currentId,
            @PathVariable("id") Long id)throws ApplicationException {
        stockServer.deleteById(id);
        return new OutputResult<>();
    }

    /**
     * @author lushusheng
     * @Date 2018-11-29
     * @Desc 修改一条证券指数数据
     * @return 返回修改后的实体，以便于回显
     * @update
     */
    @ApiOperation(value = "修改一条证券指数数据", notes = "修改一条证券指数数据")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "header", dataType = "Long", name = "currentId", value = "当前用户id", required = true),
        @ApiImplicitParam(paramType = "query", dataType = "Long", name = "id", value = "实体id", required = true),
        @ApiImplicitParam(paramType = "body", dataType = "StockInput", name = "stockInput", value = "证券指数实体更新属性", required = true)})
    @CrossOrigin
    @PostMapping("/update")
    //@RequiresPermissions({"admin:stock:update"})
    //@RequiresAuthentication
    public OutputResult<Stock> update(
            @RequestHeader(value = "_current_id", required = false, defaultValue = "110") Long currentId,
            @RequestBody StockInput stockInput)throws ApplicationException {
        //首先将实体查询出来
        if(stockInput.getId() == null) {
            throw new ApplicationException(1,"实体id不能为空");
        }
        Stock stock = stockServer.selectById(stockInput.getId());
        if(stock == null) {
            throw new ApplicationException(1, "修改证券指数实体id参数错误");
        }
        copyProperties(stock, stockInput);
        stock.setUpdateUserId(currentId);
        stock.setUpdateTime(new Date());
        stockServer.updateById(stock);
        return new OutputResult<>(stock);
    }
    /**
     * @author lushusheng
     * @Date 2018-11-29
     * @Desc 拷贝输入实体的属性到stock实体中
     * @return 无返回值，参数不合法则抛出异常
     * @update
     */
    private void copyProperties(Stock target, StockInput source) throws ApplicationException {
        Date publishTime = null;
        try {
            publishTime = SDF.parse(source.getPublishTime());
        }catch(Exception e) {
            log.info(e.getMessage());
            throw new ApplicationException(1, "");
        }
        target.setPublishTime(publishTime);
        if(source.getShOpenExponent() != null && source.getShOpenExponent().doubleValue() >= 0) {
            target.setShOpenExponent(source.getShOpenExponent());
        }
        if(source.getShCloseExponent() != null && source.getShCloseExponent().doubleValue() >= 0) {
            target.setShCloseExponent(source.getShCloseExponent());
        }
        if(source.getShMaxExponent() != null && source.getShMaxExponent().doubleValue() >= 0) {
            target.setShMaxExponent(source.getShMaxExponent());
        }
        if(source.getShMinExponent() != null && source.getShMinExponent().doubleValue() >= 0) {
            target.setShMinExponent(source.getShMinExponent());
        }
        if(source.getTbOpenExponent() != null && source.getTbOpenExponent().doubleValue() >= 0) {
            target.setTbOpenExponent(source.getTbOpenExponent());
        }
        if(source.getTbCloseExponent() != null && source.getTbCloseExponent().doubleValue() >= 0) {
            target.setTbCloseExponent(source.getTbCloseExponent());
        }
        if(source.getTbMaxExponent() != null && source.getTbMaxExponent().doubleValue() >= 0) {
            target.setTbMaxExponent(source.getTbMaxExponent());
        }
        if(source.getTbMinExponent() != null && source.getTbMinExponent().doubleValue() >= 0) {
            target.setTbMinExponent(source.getTbMinExponent());
        }
    }

    /**
     * @author lushusheng
     * @Date 2018-11-28
     * @Desc 保存一条证券指数数据
     * @return 返回保存的实体，以便于回显
     * @update
     */
    @ApiOperation(value = "保存一条证券指数数据", notes = "保存一条证券指数数据")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "header", dataType = "Long", name = "currentId", value = "当前用户id", required = true),
        @ApiImplicitParam(paramType = "body", dataType = "StockInput", name = "stockInput", value = "新建证券指数实体属性", required = true)})
    @CrossOrigin
    @PostMapping("/save")
    //@RequiresPermissions({"admin:stock:save"})
    //@RequiresAuthentication
    public OutputResult<Stock> save(
            @RequestHeader(value = "_current_id", required = false, defaultValue = "110") Long currentId,
            @RequestBody @Valid StockInput stockInput)throws ApplicationException {
        Stock stock = new Stock();
        copyProperties(stock, stockInput);
        Stock saved = stockServer.insert(currentId, stock);
        return new OutputResult<>(saved);
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
    //@RequiresPermissions({"admin:stock:list:num"})
    //@RequiresAuthentication
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
