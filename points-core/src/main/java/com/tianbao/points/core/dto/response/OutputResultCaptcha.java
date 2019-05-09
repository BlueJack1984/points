package com.tianbao.points.core.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @desc 通用返回实体，实现泛型，用于返回验证码
 * @author lushusheng
 * @date 2019-5-9
 */
@Data
@NoArgsConstructor
public class OutputResultCaptcha<T> extends OutputResult<T> {
    private String identityId;
    public OutputResultCaptcha(String identityId, T data) {
        super(data);
        this.identityId = identityId;
    }
}
