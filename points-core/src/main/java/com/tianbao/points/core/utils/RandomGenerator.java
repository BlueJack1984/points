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

    private static final Integer RATIO_BITS = 4;
    /**
     * @author lushusheng
     * @Date 2018-11-30
     * @Desc 获取随机产生的系统权重比率系数
     * 权重比率系数范围：0.01--0.015之间随机波动，精度保持小数点后6位，即0.000001
     * @return 返回随机产生的系统权重比率系数
     * @update
     */
    public static String getRandomRatio() {
        //生成1%到1.5%之间的随机权重系数
        String container = "0123456789";
        StringBuilder ratio = new StringBuilder(RATIO_BITS);
        for(int i = 0; i < RATIO_BITS; i ++) {
            Random random = new Random();
            /**
             * nextInt(int n) 该方法的作用是生成一个随机的int值，该值介于[0,n)的区间，也就是0到n之间的随机int值，包含0而不包含n。
             */
            char single = 0;
            if(i == 0) {
                //要产生0000-4999的随机数
                single = container.charAt(random.nextInt(container.length() - 5));
            }else {
                single = container.charAt(random.nextInt(container.length()));
            }
            ratio.append(single);
        }
        String systemRatio = "0.01" + ratio.toString();
        return systemRatio;
    }
}
