package com.tianbao.points.core.dto.response;


import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @desc 通用返回实体，实现泛型
 * @author lushusheng
 * @date 2018-11-21
 */
@Data
@NoArgsConstructor
public class OutputResult<T> {

    /**
     * @desc 返回实体的属性值
     * @author lushusheng
     * @date 2018-11-21
     * @param code 错误代号值,默认正常返回值200
     * @param message 错误信息，默认正常返回信息"SUCCESS"
     * @param data 返回数据
     */
    private int code = 200;
    private String message = "SUCCESS";
    private T data;

    /**
     * @desc 正常返回数据
     * @author lushusheng
     * @date 2018-11-21
     */
    public OutputResult(T data) {
        this.code = OutputResultCode.SUCCESS.getCode();
        this.message = OutputResultCode.SUCCESS.getMessage();
        this.data = data;
    }

    /**
     * @desc 返回错误信息,无数据data返回
     * @author lushusheng
     * @date 2018-11-21
     */
    public OutputResult(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
