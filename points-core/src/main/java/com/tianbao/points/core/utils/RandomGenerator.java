package com.tianbao.points.core.utils;


import lombok.extern.slf4j.Slf4j;

import java.util.Random;

/**
 * 随机数产生工具
 * @author lushusheng
 * @date 2018-11-29
 */
@Slf4j
public class RandomGenerator {

    /**
     * @author lushusheng
     * @Date 2018-11-30
     * @Desc 获取随机产生的系统权重比率系数
     * 权重比率系数范围：0.01--0.012之间随机波动，精度保持小数点后6位，即0.000001
     * @return 返回随机产生的系统权重比率系数
     * @update
     */
    public static Double getRandomRatio() {
        //生成1%到1.2%之间的随机权重系数
        Random random = new Random();
        Double systemRatio = (int)((0.01 + random.nextDouble() * 0.002) * 1000000) / 1000000.00;
        return systemRatio;
    }
}
