package com.tianbao.points.core.utils;

import com.esotericsoftware.reflectasm.MethodAccess;
import com.tianbao.points.core.utils.domain.BeanMethodAccess;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;

/**
 * 对象反射工具
 * @author lushusheng
 * @date 2018-11-29
 */
@Slf4j
public class BeanReflectHelper {
    private BeanReflectHelper(){}
    /**
     * 获取对象的属性列表
     * @param objectClass 类
     * @return 属性列表
     */
    public static List<Field> beanFields(Class objectClass){
        List<Field> fields = new ArrayList<>();
        Class tempClass = objectClass;
        while (tempClass != null) {
            //当父类为null的时候说明到达了最上层的父类(Object类).
            fields.addAll(Arrays.asList(tempClass.getDeclaredFields()));
            tempClass = tempClass.getSuperclass();
        }
        return fields;
    }

    /**
     * 反射获取类的属性对应的get和set方法
     * @param clz 类
     * @return 类的方法对象
     */
    public static BeanMethodAccess beanMethod(Class clz){
        MethodAccess methodAccess = MethodAccess.get(clz);
        List<Field> fields = beanFields(clz);
        List<String> fieldList = new ArrayList<>(fields.size());
        Map<String, Integer> methodIndex = new HashMap<>(fields.size());

        String className = clz.getName();
        for (Field field : fields){
            if (!Modifier.isPublic(field.getModifiers())
                    && !Modifier.isStatic(field.getModifiers())) {
                // 是否是私有的，是否是静态的
                // 非公共私有变量
                // 获取属性名称
                String fieldName = StringUtils.capitalize(field.getName());
                try {
                    // 获取get方法的下标
                    int getIndex = methodAccess.getIndex("get" + fieldName);
                    // 获取set方法的下标
                    int setIndex = methodAccess.getIndex("set" + fieldName);
                    // 将类名get方法名，方法下标注册到map中
                    methodIndex.put(className + "." + "get" + fieldName, getIndex);
                    // 将类名set方法名，方法下标注册到map中
                    methodIndex.put(className + "." + "set" + fieldName, setIndex);
                    // 将属性名称放入集合里
                    fieldList.add(fieldName);
                }catch (Exception e){
                    log.warn("属性：{} 没有get或者set方法", fieldName);
                }
            }
        }
        // 将类名，属性名称注册到map中
        BeanMethodAccess access = new BeanMethodAccess();
        access.setMethodIndex(methodIndex);
        access.setFieldList(fieldList);
        access.setMethodAccess(methodAccess);
        return access;
    }

    /**
     * 反射类方法，并把信息保存到映射中
     * @param clz 类
     * @param mapMethodIndex 方法索引，不能为null
     * @param mapMethod 方法映射，不能为nul
     * @param mapField 属性映射，不能为null
     * @return 方法
     */
    public static MethodAccess beanMethod(Class clz,
                                          Map<String, Integer> mapMethodIndex,
                                          Map<Class, MethodAccess> mapMethod,
                                          Map<Class, List<String>> mapField){
        BeanMethodAccess methodAccess = BeanReflectHelper.beanMethod(clz);

        // 将类名，属性名称注册到map中
        if (mapMethodIndex != null) {
            mapMethodIndex.putAll(methodAccess.getMethodIndex());
        }
        if (mapField != null) {
            mapField.put(clz, methodAccess.getFieldList());
        }
        if (mapMethod != null) {
            mapMethod.put(clz, methodAccess.getMethodAccess());
        }
        return methodAccess.getMethodAccess();
    }
}
