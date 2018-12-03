package com.tianbao.points.core.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 验证手机号，邮箱等是否合法
 *
 * @author lushusheng 2018-12-03
 */
public class ContactUtils {


    /**
     * 判断输入字符串是否为邮箱
     *  @author lushusheng
     *  @date 2018-10-23
     * @param email 待检查的字符串
     * @return  返回检查结果
     */
    private boolean isEmail(String email) {
        boolean flag = false;
        try {
            String check = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
            Pattern regex = Pattern.compile(check);
            Matcher matcher = regex.matcher(email);
            flag = matcher.matches();
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }
    /**
     * 判断输入字符串是否为手机号
     * 11位数字，1开头，第二位数必须是3456789这些数字之一
     *  @author lushusheng
     *  @date 2018-10-23
     * @param mobileNumber 待检查的字符串
     * @return  返回检查结果
     */
    private boolean isMobileNumber(String mobileNumber) {
        boolean flag = false;
        if(mobileNumber.length() != 11) {
            return flag;
        }
        try {
            // Pattern regex = Pattern.compile("^(((13[0-9])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8})|(0\\d{2}-\\d{8})|(0\\d{3}-\\d{7})$");
            Pattern regex = Pattern.compile("^1[3456789]\\d{9}$");
            Matcher matcher = regex.matcher(mobileNumber);
            flag = matcher.matches();
        } catch (Exception e) {
            e.printStackTrace();
            flag = false;
        }
        return flag;
    }
}
