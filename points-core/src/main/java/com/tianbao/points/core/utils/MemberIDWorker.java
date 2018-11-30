package com.tianbao.points.core.utils;


import lombok.extern.slf4j.Slf4j;

import java.util.Random;

/**
 * 产生会员编号工具类
 * @author lushusheng
 * @date 2018-11-29
 */
@Slf4j
public class MemberIDWorker {

    /**
     * @author lushusheng
     * @Date 2018-11-30
     * @Desc 获取会员编号，采用伪随机数的简单方式实现六位会员编号
     * 会员编号范围：100000--999999
     * @return 返回随机产生的会员编号
     * @update
     */
    public static String getMemberId() {
        /**
         * 定义伪随机数种子
         * 产生随机数范围：100000--999999
         */
        Random random = new Random();
        Integer start = 100000;
        /**
         * 产生第一部分随机数
         * 产生随机数范围：0--450000(包含0,不包含450000)
         */
        Integer firstCode = random.nextInt(450000);
        /**
         * 产生第二部分随机数
         * 产生随机数范围：0--450001(包含0,不包含450001)
         */
        Integer secondCode = random.nextInt(450001);
        return new Integer(start + firstCode + secondCode).toString();
    }
}
