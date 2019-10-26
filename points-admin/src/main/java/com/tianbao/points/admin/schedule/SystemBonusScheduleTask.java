package com.tianbao.points.admin.schedule;

import com.tianbao.points.core.entity.SystemBonus;
import com.tianbao.points.core.exception.ApplicationException;
import com.tianbao.points.core.service.ISystemBonusService;
import com.tianbao.points.core.utils.RandomGenerator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 实现定时结算
 * @author lushusheng
 * @date 2019-10-21
 * @desc
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class SystemBonusScheduleTask {

    private final ISystemBonusService systemBonusService;
    /**
     * 定时任务
     * 每天凌晨五点执行
     */
    @Scheduled(cron = "0 0 5 * * ?")
    public void checkoutSystemBonus() {

        String ratio = RandomGenerator.getRandomRatio();
        Double result = Double.parseDouble(ratio);
        Date today = new Date();
        //数据库中查询最新的一条数据日期
        try {
            SystemBonus systemBonus = systemBonusService.getLatest();
            if(systemBonus != null && DateUtils.isSameDay(today, systemBonus.getCreateTime())) {
                throw new ApplicationException(ApplicationException.DUPLICATE_CHECKOUT_ERROR,"同一天系统积分不能结算两次及以上");
            }
            systemBonusService.checkout(result,110L);
        }catch (Exception ex) {
            ex.printStackTrace();
            log.info("**************出现错误：" + ex.getMessage());
        }
    }
}
