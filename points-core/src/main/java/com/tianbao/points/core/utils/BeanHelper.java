package com.tianbao.points.core.utils;

import com.esotericsoftware.reflectasm.MethodAccess;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 对象助手工具
 * @author lushusheng
 * @date 2018-11-29
 */
@Slf4j
public class BeanHelper {
    /**
     * 类中方法的映射关系
     */
    private static ConcurrentHashMap<Class, MethodAccess> mapMethod = new ConcurrentHashMap<>();
    /**
     * 方法的索引映射
     * key：方法名称
     */
    private static ConcurrentHashMap<String, Integer> mapMethodIndex = new ConcurrentHashMap<>();
    /**
     * 类属性映射
     */
    private static ConcurrentHashMap<Class, List<String>> mapField = new ConcurrentHashMap<>();

    private BeanHelper(){}

    /**
     * 把来源对象和目标对象中相同的属性的值进行拷贝
     * @author 吴建荣
     * 本方法不支持public的属性以及静态属性的拷贝
     * @param target 拷贝目标对象
     * @param source 拷贝来源对象
     */
    public static void copyProperties(Object target, Object source) {
        MethodAccess targetMethodAccess = mapMethod.get(target.getClass());
        if (targetMethodAccess == null) {
            targetMethodAccess = BeanReflectHelper.beanMethod(target.getClass(), mapMethodIndex, mapMethod, mapField);
        }
        MethodAccess sourceMethodAccess = mapMethod.get(source.getClass());
        if (sourceMethodAccess == null) {
            sourceMethodAccess = BeanReflectHelper.beanMethod(source.getClass(), mapMethodIndex, mapMethod, mapField);
        }

        List<String> fieldList = mapField.get(source.getClass());
        for (String field : fieldList) {
            String getKey = source.getClass().getName() + "." + "get" + field;
            String setKey = target.getClass().getName() + "." + "set" + field;
            Integer setIndex = mapMethodIndex.get(setKey);
            if (setIndex != null) {
                int getIndex = mapMethodIndex.get(getKey);
                // 参数一需要反射的对象
                // 参数二class.getDeclaredMethods 对应方法的index
                // 参数对三象集合
                targetMethodAccess.invoke(target, setIndex,
                        sourceMethodAccess.invoke(source, getIndex));
            }
        }
    }
}
