package com.tianbao.points.app;

import com.tianbao.points.app.controller.migration.input.PersonalBonusMigrationInput;
import com.tianbao.points.app.controller.migration.input.SystemBonusMigrationInput;
import com.tianbao.points.core.constant.StatusCode;
import com.tianbao.points.core.entity.PersonalBonus;
import com.tianbao.points.core.entity.SystemBonus;
import com.tianbao.points.core.entity.User;
import com.tianbao.points.core.exception.ApplicationException;
import com.tianbao.points.core.service.IPersonalBonusService;
import com.tianbao.points.core.service.ISystemBonusService;
import com.tianbao.points.core.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SystemBonusMigrationTest {

    private SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:00");
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
    @Autowired
    private ISystemBonusService systemBonusService;

    @Test
    public void save() throws ApplicationException {
        // 读取本地csv文件的Url路径
        BufferedReader reader = null;//换成你的文件名
        String line = null;
        String params = null;
        try {
            reader = new BufferedReader(new FileReader("E:\\work\\盛华天宝\\服务器数据文件\\唯我独尊是我的\\pointlist.csv"));
        } catch (FileNotFoundException e) {
            log.info(e.getMessage());
        }
        try {
            reader.readLine();//第一行信息，为标题信息，不用,如果需要，注释掉
            while ((line = reader.readLine()) != null) {
                String[] items = line.split(",");//CSV格式文件为逗号分隔符文件，这里根据逗号切分
                SystemBonusMigrationInput systemBonusMigrationInput = new SystemBonusMigrationInput();
                loadSystemBonusMigrationInput(systemBonusMigrationInput, items);

                SystemBonus systemBonus = new SystemBonus();
                copyProperties(systemBonus, systemBonusMigrationInput);
                systemBonus.setStatus(StatusCode.NORMAL.getCode());
                systemBonus.setCreateUserId(110L);
                systemBonus.setUpdateTime(new Date());
                systemBonus.setUpdateUserId(110L);
                systemBonusService.save(systemBonus);
            }
        } catch (IOException e) {
            log.info(e.getMessage());
        }
    }

    private void copyProperties(SystemBonus target, SystemBonusMigrationInput source)throws ApplicationException {

        try {
            Date original = sdf.parse(source.getCreateTime());
            String format = SDF.format(original);
            target.setCreateTime(SDF.parse(format));
        } catch (ParseException e) {
            log.info(e.getMessage());
            throw new ApplicationException(ApplicationException.DATE_PARAM_FORMAT_ERROR, "创建时间格式错误");
        }
        target.setId(source.getId());
        target.setStartPoints(source.getStartPoints());
        target.setEndPoints(source.getEndPoints());
        target.setRatio(source.getRatio());
        target.setVisible(source.getVisible());
    }

    private void loadSystemBonusMigrationInput(SystemBonusMigrationInput target, String[] source) {
        if(target == null || source == null) {
            return;
        }
        target.setId(Long.parseLong(source[0]));
        target.setRatio(Double.parseDouble(source[1]));
        target.setStartPoints(Double.parseDouble(source[2]));
        target.setEndPoints(Double.parseDouble(source[3]));
        if("TRUE".equals(source[4]) || "true".equals(source[4])) {
            target.setVisible(0);
        }else {
            target.setVisible(1);
        }
        target.setCreateTime(source[5]);
    }
}
