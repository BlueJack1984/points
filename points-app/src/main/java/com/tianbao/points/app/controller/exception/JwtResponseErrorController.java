package com.tianbao.points.app.controller.exception;


import com.tianbao.points.core.exception.ApplicationException;
import io.jsonwebtoken.SignatureException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 截获spring boot Error页面
 * 主要捕捉jwt异常返回界面
 */
@Controller
public class JwtResponseErrorController {

    /**
     * @desc 截取/401错误页面的请求
     * @author lushusheng 2018-12-19
     * @param request 当前http请求
     * @param response 当前http响应
     * @return 返回无
     * @throws ApplicationException 异常
     */
    @RequestMapping(value = "/401")
    public void getResponse401(HttpServletRequest request, HttpServletResponse response) throws ApplicationException {

        // 抛出错误异常，统一捕获处理
        throw new ApplicationException(ApplicationException.USER_NOT_EXISTS, "查询的用户不存在");
    }
    /**
     * @desc 截取/402错误页面的请求
     * @author lushusheng 2018-12-19
     * @param request 当前http请求
     * @param response 当前http响应
     * @return 返回无
     * @throws ApplicationException 异常
     */
    @RequestMapping(value = "/402")
    public void getResponse402(HttpServletRequest request, HttpServletResponse response) throws ApplicationException {

        // 抛出错误异常，统一捕获处理
        throw new ApplicationException(ApplicationException.PASSWORD_ERROR, "用户登录密码错误");
    }
    /**
     * @desc 截取/403错误页面的请求
     * @author lushusheng 2018-12-19
     * @param request 当前http请求
     * @param response 当前http响应
     * @return 返回无
     * @throws ApplicationException 保存异常
     */
    @RequestMapping(value = "/403")
    public void getResponse403(HttpServletRequest request, HttpServletResponse response) throws ApplicationException {

        // 抛出错误异常，统一捕获处理
        throw new ApplicationException(ApplicationException.SC_NO_AUTHORITY, "token令牌认证异常");
    }
    /**
     * @desc 截取/404错误页面的请求
     * @author lushusheng 2018-12-19
     * @param request 当前http请求
     * @param response 当前http响应
     * @return 返回无
     * @throws ApplicationException 保存异常
     */
    @RequestMapping(value = "/404")
    public void getResponse404(HttpServletRequest request, HttpServletResponse response) throws ApplicationException {

        // 抛出错误异常，统一捕获处理
        throw new ApplicationException(ApplicationException.INNER_ERROR, "非认证权限异常");
    }
}
