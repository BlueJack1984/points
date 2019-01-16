package com.tianbao.points.admin.controller.exception;

import com.tianbao.points.core.exception.ApplicationException;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 截获spring boot Error页面
 */
@Controller
public class GlobalErrorHandler implements ErrorController {
    @Override
    public String getErrorPath() {
        return "/error";
    }
    @RequestMapping(value = "/error")
    public void error(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 错误处理逻辑
        Exception exception = (Exception) request.getAttribute("javax.servlet.error.exception");
        if(exception == null) {
            throw new ApplicationException(ApplicationException.UNKNOWN_ERROR, "未知错误");
        }
        Throwable cause = exception.getCause();
        if (cause instanceof ExpiredJwtException) {
            //response.setStatus(HttpStatus.GATEWAY_TIMEOUT.value());
            throw new ApplicationException(ApplicationException.JWT_EXPIRED_ERROR, "用户JWT令牌过期");
        }
        if (cause instanceof MalformedJwtException) {
            //response.setStatus(HttpStatus.FORBIDDEN.value());
            throw new ApplicationException(ApplicationException.JWT_MALFORMED_ERROR, "用户JWT令牌格式错误");
        }
        throw new ApplicationException(ApplicationException.LOGIN_STATUS_ERROR, "用户未登录");
    }
}