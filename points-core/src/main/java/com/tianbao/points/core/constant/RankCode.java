package com.tianbao.points.core.constant;

/**
 * @desc 会员等级枚举类
 * @author lushusheng
 * @date 2018-11-28
 *
 */
public enum RankCode {

    NORMAL(0, "正常"),
    FORBIDDEN(1, "禁用"),
    TOAUDIT(2, "待审核"),
    /**
     * 针对Message实体的status:已读和未读
     */
    READED(3, "已读"),
    UNREAD(4, "未读");
    /**
     * 会员等级编码值，对应会员等级表id
     */
    private Integer code;
    /**
     * 会员等级积分增值基数
     */
    private Double basePoint;
    /**
     * 会员等级积分增值基数
     */
    private Double basePoint;

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
