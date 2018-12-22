package com.tianbao.points.core.entity.base;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Id;
import java.io.Serializable;

/**
 * 定义基本持久化对象
 * @author lushusheng
 * @date 2018-11-27
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BasicPO<K> implements Serializable {
    /**
     * 主键
     */
    @Id
    @JSONField(serializeUsing = ToStringSerializer.class)
    protected K id;
    /**
     * 状态，0表示正常，1表示禁用
     */
    protected Integer status;

    @Override
    public boolean equals(Object object){
        if (object == null){
            return false;
        }
        if (object == this){
            return true;
        }
        if (object instanceof BasicPO){
            BasicPO basic = (BasicPO)object;
            return basic.id.equals(id);
        }
        return super.equals(object);
    }

    @Override
    public int hashCode(){
        if (id == null){
            return super.hashCode();
        }
        int code;
        if (id instanceof Number){
            Number n = (Number)id;
            code = n.intValue();
        }else if (id instanceof String){
            String s = (String)id;
            code = s.hashCode();
        }else {
            code = id.hashCode();
        }
        return code;
    }
}
