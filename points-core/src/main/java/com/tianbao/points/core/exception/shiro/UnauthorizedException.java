package com.tianbao.points.core.exception.shiro;


import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 应用异常
 * @author lushusheng
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UnauthorizedException extends RuntimeException {
    /**
     *
     * @param msg
     */
    public UnauthorizedException(String msg) {
        super(msg);
    }
    /**
     *
     *
     */
    public UnauthorizedException() {
        super();
    }
}