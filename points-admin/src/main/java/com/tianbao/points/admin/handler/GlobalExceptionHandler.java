package com.tianbao.points.admin.handler;


import com.tianbao.points.core.dto.response.OutputError;
import com.tianbao.points.core.exception.ApplicationException;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.lang.reflect.UndeclaredThrowableException;

/**
 * 统一异常处理
 * @author lushusheng
 * @date 2018-12-06
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 拦截捕捉异常 UnknownAccountException.class
     * @param ex
     * @return
     */
    @ExceptionHandler(value = UnknownAccountException.class)
    public OutputError unknownAccountExceptionHandler(UnknownAccountException ex) {
        String message = "应用异常";
        return new OutputError(2, message, ex.getMessage());
    }

    /**
     * 拦截捕捉异常 IncorrectCredentialsException.class
     * @param ex
     * @return
     */
    @ExceptionHandler(value = IncorrectCredentialsException.class)
    public OutputError incorrectCredentialsExceptionHandler(IncorrectCredentialsException ex) {
        String message = "应用异常";
        return new OutputError(1, message, ex.getMessage());
    }


    /**
     * 拦截捕捉自定义异常 ApplicationException.class
     * @param ex
     * @return
     */
    @ExceptionHandler(value = ApplicationException.class)
    public OutputError applicationExceptionHandler(ApplicationException ex) {
        String message = "应用异常";
        return new OutputError(ex.getCode(), message, ex.getDetailMsg());
    }
    /**
     * 全局异常捕捉处理
     * @param ex
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public OutputError exceptionHandler(Exception ex) {
        Throwable throwable = ex.getCause();
        if (throwable != null && throwable.getCause() != null){
            if (throwable.getCause() instanceof UndeclaredThrowableException){
                UndeclaredThrowableException ut = (UndeclaredThrowableException)throwable.getCause();
                Throwable throwable2 = ut.getUndeclaredThrowable();
                if (throwable2 instanceof ApplicationException) {
                    ApplicationException ae = (ApplicationException) throwable2;
                    return new OutputError(ae.getCode(), ae.getMsg(), ae.getDetailMsg());
                }
            }
        }
        log.error("收到未知异常：{}", ex);
        return new OutputError(ApplicationException.INNER_ERROR, "未知错误", ex.getMessage());
    }
}
