package com.tianbao.points.app.controller;


import com.tianbao.points.core.service.IStockService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
