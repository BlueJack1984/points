package com.tianbao.points.core.constant;


/**
 * @desc 基本服务接口
 * @author lushusheng
 * @date 2018-11-28
 *
 */
public enum StatusCode {

    NORMAL(0, "正常"),
    FORBIDDEN(1, "禁用"),
    TOAUDIT(2, "待审核"),
    /**
     * 针对Message实体的status:已读和未读
     */
    READED(3, "已读"),
    UNREAD(4, "未读");
    /**
     * 公告标题
     */
    private Integer code;
    /**
     * 公告标题
     */
    private String message;

    /**
     * 无参数构造器
     */
    StatusCode() {

    }
    /**
     * 有参数构造器
     */
    StatusCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 状态参数值获取
     */
    public Integer getCode() {
        return code;
    }
    public String getMessage() {
        return message;
    }
}
