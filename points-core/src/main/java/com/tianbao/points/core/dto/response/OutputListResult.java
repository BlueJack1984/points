package com.tianbao.points.core.dto.response;

import com.baomidou.mybatisplus.plugins.Page;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @desc 通用返回实体列表，实现泛型
 * @author lushusheng
 * @date 2018-11-21
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class OutputListResult<T> extends OutputResult<List<T>> {

    /**
     * 总记录数量
     */
    private long total;

    public OutputListResult(List<T> data){
        super(data);
        this.total = data.size();
    }
    public OutputListResult(Page<T> data){
        super(data.getRecords());
        this.total = data.getTotal();
    }
}
