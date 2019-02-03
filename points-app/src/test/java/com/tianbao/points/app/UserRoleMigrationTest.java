package com.tianbao.points.app;

import com.baomidou.mybatisplus.toolkit.IdWorker;
import com.tianbao.points.app.controller.migration.input.PersonalBonusMigrationInput;
import com.tianbao.points.app.controller.migration.input.UserRoleMigrationInput;
import com.tianbao.points.core.constant.StatusCode;
import com.tianbao.points.core.entity.PersonalBonus;
import com.tianbao.points.core.entity.User;
import com.tianbao.points.core.entity.UserRole;
import com.tianbao.points.core.exception.ApplicationException;
import com.tianbao.points.core.service.IPersonalBonusService;
import com.tianbao.points.core.service.IUserRoleService;
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
public class UserRoleMigrationTest {

    private SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:00");
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");

    @Autowired
    private IUserRoleService userRoleService;

    @Test
    public void save() throws ApplicationException {
        // 读取本地csv文件的Url路径
        BufferedReader reader = null;//换成你的文件名
        String line = null;
        String params = null;
        try {
            reader = new BufferedReader(new FileReader("C:\\Users\\lushu\\Desktop\\cccc\\user.csv"));
        } catch (FileNotFoundException e) {
            log.info(e.getMessage());
        }
        try {
            reader.readLine();//第一行信息，为标题信息，不用,如果需要，注释掉
            while ((line = reader.readLine()) != null) {
                String[] items = line.split(",");//CSV格式文件为逗号分隔符文件，这里根据逗号切分
                UserRoleMigrationInput userRoleMigrationInput = new UserRoleMigrationInput();
                loadUserRoleMigrationInput(userRoleMigrationInput, items);

                UserRole userRole = new UserRole();
                copyProperties(userRole, userRoleMigrationInput);
                userRole.setId(IdWorker.getId());
                userRole.setStatus(StatusCode.NORMAL.getCode());
                userRole.setCreateUserId(110L);
                userRole.setCreateTime(new Date());
                userRole.setUpdateTime(new Date());
                userRole.setUpdateUserId(110L);
                userRoleService.save(userRole);
            }
        } catch(IOException e){
            e.printStackTrace();
        }
    }
    private void copyProperties(UserRole target, UserRoleMigrationInput source)throws ApplicationException {

        target.setUserId(source.getUserId());
        target.setRoleId(source.getRoleId());
    }

    private void loadUserRoleMigrationInput(UserRoleMigrationInput target, String[] source) {
        if(target == null || source == null) {
            return;
        }
        target.setUserId(Long.parseLong(source[0]));
        target.setRoleId(Long.parseLong(source[1]));
    }

}
