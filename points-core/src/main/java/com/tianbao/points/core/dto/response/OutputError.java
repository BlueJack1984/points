package com.tianbao.points.core.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 错误的输出
 * @author lushusheng
 * @date 2018-12-06
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OutputError {
    /**
     * 错误码，0表示成功
     */
    private int code;
    /**
     * 错误消息
     */
    private String message;
}