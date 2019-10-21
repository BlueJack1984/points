package com.tianbao.points.admin.schedule;

import com.tianbao.points.core.service.ISystemBonusService;
import com.tianbao.points.core.utils.RandomGenerator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

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
        try {
            systemBonusService.checkout(result,110L);
        }catch (Exception ex) {
            ex.printStackTrace();
            log.info("**************出现错误：" + ex.getMessage());
        }
    }
}
