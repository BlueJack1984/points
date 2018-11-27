package com.tianbao.points.core.dto.response;


/**
 * @desc 枚举返回类型
 * @author lushusheng
 * @date 2018-11-21
 */
public enum OutputResultCode {

    /**
     * @desc 返回成功
     */
    SUCCESS(200, "SUCCESS"),
    /**
     * @desc 参数错误
     */
    PARAMETER_ERROR(201, "PARAMETER_ERROR"),
    /**
     * @desc 操作失败
     */
    FAILURE(400, "FAILURE"),
    /**
     * @desc 未认证通过，签名（用户名和密码）错误
     */
    UNAUTHORIZED(401, "UNAUTHORIZED"),
    /**
     * @desc 接口不存在
     */
    NOT_FOUND(404, "NOT_FOUND"),
    /**
     * @desc 服务器内部错误
     */
    SERVER_INNER_ERROR(500, "SERVER_INNER_ERROR");

    /**
     * @desc 枚举属性值
     * @author lushusheng
     * @date 2018-11-21
     */
    private int code;
    private String message;
    /**
     * @desc 构造函数
     * @author lushusheng
     * @date 2018-11-21
     */
    OutputResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
    /**
     * @desc 获取属性方法
     * @author lushusheng
     * @date 2018-11-21
     */
    public int getCode() {
        return code;
    }
    public String getMessage() {
        return message;
    }
}
