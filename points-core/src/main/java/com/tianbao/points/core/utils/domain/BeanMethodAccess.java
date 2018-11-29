package com.tianbao.points.core.utils.domain;

import com.esotericsoftware.reflectasm.MethodAccess;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @description 文件描述
 * @author lushusheng
 * @date 2018-11-29
 */
@Data
public class BeanMethodAccess {
    private MethodAccess methodAccess;
    private List<String> fieldList;
    private Map<String, Integer> methodIndex;
}
