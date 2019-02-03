package com.tianbao.points.app;

import com.tianbao.points.app.controller.migration.input.PersonalBonusMigrationInput;
import com.tianbao.points.core.constant.StatusCode;
import com.tianbao.points.core.entity.PersonalBonus;
import com.tianbao.points.core.entity.User;
import com.tianbao.points.core.exception.ApplicationException;
import com.tianbao.points.core.service.IPersonalBonusService;
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
public class PersonalBonusMigrationTest {

    private SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:00");
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
    @Autowired
    private IPersonalBonusService personalBonusService;
    @Autowired
    private IUserService userService;

    @Test
    public void save() throws ApplicationException {
        // 读取本地csv文件的Url路径
        BufferedReader reader = null;//换成你的文件名
        String line = null;
        String params = null;
        try {
            reader = new BufferedReader(new FileReader("C:\\Users\\lushu\\Desktop\\cccc\\point_12-17.csv"));
        } catch (FileNotFoundException e) {
            log.info(e.getMessage());
        }
        try {
            reader.readLine();//第一行信息，为标题信息，不用,如果需要，注释掉
            while ((line = reader.readLine()) != null) {
                String[] items = line.split(",");//CSV格式文件为逗号分隔符文件，这里根据逗号切分
                PersonalBonusMigrationInput personalBonusMigrationInput = new PersonalBonusMigrationInput();
                loadPersonalBonusMigrationInput(personalBonusMigrationInput, items);

                User user = userService.getByAccount(personalBonusMigrationInput.getAccount());
                if (user == null) {
                    log.info("****************会员用户不存在***********会员用户不存在*******************");
                    continue;
                    //throw new ApplicationException(ApplicationException.MEMBER_USER_NOT_EXISTS, "会员用户不存在");
                }
                PersonalBonus personalBonus = new PersonalBonus();
                PersonalBonus latest = personalBonusService.getLatestByUserId(user.getId());
                if (latest == null) {
                    //第一次存入
                    personalBonus.setParentId(0L);
                } else {
                    personalBonus.setParentId(latest.getId());
                }
                personalBonus.setUserId(user.getId());
                copyProperties(personalBonus, personalBonusMigrationInput);
                personalBonus.setStatus(StatusCode.NORMAL.getCode());
                personalBonus.setCreateUserId(110L);
                personalBonus.setUpdateTime(new Date());
                personalBonus.setUpdateUserId(110L);
                personalBonusService.save(personalBonus);
            }
        } catch(IOException e){
            e.printStackTrace();
        }
    }
    private void copyProperties(PersonalBonus target, PersonalBonusMigrationInput source)throws ApplicationException {

        try {
            Date original = sdf.parse(source.getCreateTime());
            String createTime = SDF.format(original);
            target.setCreateTime(SDF.parse(createTime));
        } catch (ParseException e) {
            log.info(e.getMessage());
            throw new ApplicationException(ApplicationException.DATE_PARAM_FORMAT_ERROR, "创建时间格式错误");
        }
        target.setId(source.getId());
        target.setSystemBonusId(source.getSystemBonusId());
        target.setStartPoints(source.getStartPoints());
        target.setEndPoints(source.getEndPoints());
        target.setRatio(source.getRatio());
        target.setVisible(source.getVisible());
    }

    private void loadPersonalBonusMigrationInput(PersonalBonusMigrationInput target, String[] source) {
        if(target == null || source == null) {
            return;
        }
        target.setId(Long.parseLong(source[0]));
        target.setSystemBonusId(Long.parseLong(source[1]));
        target.setAccount(source[2]);
        target.setRatio(Double.parseDouble(source[3]));
        target.setStartPoints(Double.parseDouble(source[4]));
        target.setEndPoints(Double.parseDouble(source[5]));
        if("TRUE".equals(source[6])) {
            target.setVisible(0);
        }else {
            target.setVisible(1);
        }
        target.setCreateTime(source[7]);
    }

}
