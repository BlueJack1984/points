package com.tianbao.points.core.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 字符串转换器
 *
 * @author lushusheng 2018-12-04
 */
public class StringConverter {

    private StringConverter(){}
    /**
     * 把字符串对象转换成List<Long>集合
     * @param s 字符串
     * @return Long型集合
     */
    public static List<Long> toList(String s){
        if (s == null || "".equals(s)) {
            return null;
        }
        String[] split = s.split(",");
        List<Long> ids = new ArrayList<>();
        for (String st : split){
            Long id = Long.parseLong(st);
            ids.add(id);
        }
        return ids;
    }
}