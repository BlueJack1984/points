package com.tianbao.points.app.supplement;

import com.tianbao.points.core.service.ISystemBonusService;
import com.tianbao.points.core.utils.RandomGenerator;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 补偿用户积分，适用于未结算积分
 * @author lushusheng
 * @date 2019-04-11 20:18:24
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class PersonalBonusSupplementTest {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("");
    @Autowired
    private ISystemBonusService systemBonusService;

    @Test
    public void supplePersonalBonus() {
        //Date today = new Date();

        int circle = 0;
        String ratio = RandomGenerator.getRandomRatio();
        Double result = Double.parseDouble(ratio);
        try {
            systemBonusService.checkout(result,110L);
        }catch (Exception ex) {
            ex.printStackTrace();
            log.info("**************出现错误：" + ex.getMessage());
        }

//        for(int i = 0; i < circle; i ++) {
//            //Calendar c = Calendar.getInstance();
//            //c.setTime(sDate);
//            //c.add(Calendar.DAY_OF_MONTH, 1);
//            //比率0.010-0.015之间
//
//        }
    }
}
