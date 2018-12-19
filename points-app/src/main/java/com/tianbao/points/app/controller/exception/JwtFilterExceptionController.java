package com.tianbao.points.app.controller.exception;

import com.tianbao.points.core.exception.ApplicationException;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 截获spring boot Error页面
 * 主要捕捉jwt异常返回界面
 */
@Controller
public class JwtFilterExceptionController implements ErrorController {

    @Override
    public String getErrorPath() {
        return "/error";
    }

    @RequestMapping(value = "/error")
    public void error(HttpServletRequest request, HttpServletResponse response) throws ApplicationException {

        // 错误处理逻辑
        Exception exception = (Exception) request.getAttribute("javax.servlet.error.exception");
        Throwable cause = exception.getCause();
        if (cause instanceof ExpiredJwtException) {
            response.setStatus(HttpStatus.GATEWAY_TIMEOUT.value());
            throw new ApplicationException(ApplicationException.JWT_EXPIRE, cause.getMessage());
        }
        if (cause instanceof MalformedJwtException) {
            response.setStatus(HttpStatus.FORBIDDEN.value());
            throw new ApplicationException(ApplicationException.JWT_FORMAT, cause.getMessage());
        }
        //throw new ApplicationException(cause.getCause().getMessage(), cause.getMessage());
    }

    //在解析JWT字符串时，如果密钥不正确，将会解析失败，抛出SignatureException异常，说明该JWT字符串是伪造的
    //在解析JWT字符串时，如果‘过期时间字段’已经早于当前时间，将会抛出ExpiredJwtException异常，说明本次请求已经失效
//        catch (SignatureException | ExpiredJwtException e) {
//        return false;
//    }
}