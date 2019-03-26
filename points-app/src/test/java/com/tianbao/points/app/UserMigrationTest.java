package com.tianbao.points.app;

import com.tianbao.points.app.controller.migration.input.UserMigrationInput;
import com.tianbao.points.core.constant.StatusCode;
import com.tianbao.points.core.entity.User;
import com.tianbao.points.core.exception.ApplicationException;
import com.tianbao.points.core.service.IUserService;
import com.tianbao.points.core.utils.MD5;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
public class UserMigrationTest {

    private SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:00");
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
    @Autowired
    private IUserService userService;
    @Value("${password.encrypt.key}")
    private String PASSWORD_SECRET_KEY;

    @Test
    public void save() throws ApplicationException {

        // 读取本地csv文件的Url路径
        BufferedReader reader = null;//换成你的文件名
        String line = null;
        String params = null;
        try {
            reader = new BufferedReader(new FileReader("E:\\work\\盛华天宝\\服务器数据文件\\不会选\\user.csv"));
        } catch (FileNotFoundException e) {
            log.info(e.getMessage());
        }
        try {
            reader.readLine();//第一行信息，为标题信息，不用,如果需要，注释掉
            while ((line = reader.readLine()) != null) {
                String[] items = line.split(",");//CSV格式文件为逗号分隔符文件，这里根据逗号切分
                UserMigrationInput userMigrationInput = new UserMigrationInput();
                loadUserMigrationInput(userMigrationInput, items);

                User user = new User();
                copyProperties(user, userMigrationInput);
                user.setStatus(StatusCode.NORMAL.getCode());
                user.setCreateTime(new Date());
                user.setCreateUserId(110L);
                user.setUpdateTime(new Date());
                user.setUpdateUserId(110L);
                userService.save(user);
            }
        } catch (IOException e) {
            log.info(e.getMessage());
        }
    }

    private void copyProperties(User target, UserMigrationInput source)throws ApplicationException {
        if(! StringUtils.isEmpty(source.getLastLoginTime())) {
            try {
                Date lastLoginTime = sdf.parse(source.getLastLoginTime());
                target.setLastLoginTime(lastLoginTime);
            } catch (ParseException e) {
                log.info(e.getMessage());
                throw new ApplicationException(ApplicationException.DATE_PARAM_FORMAT_ERROR, "上次登录时间格式错误");
            }
        }

        if(! StringUtils.isEmpty(source.getCurrentLoginTime())) {
            try {
                Date currentLoginTime = sdf.parse(source.getCurrentLoginTime());
                target.setCurrentLoginTime(currentLoginTime);
            } catch (ParseException e) {
                log.info(e.getMessage());
                throw new ApplicationException(ApplicationException.DATE_PARAM_FORMAT_ERROR, "本次登录时间格式错误");
            }
        }
        if(! StringUtils.isEmpty(source.getCertificationTime())) {
            try {
                Date original = sdf.parse(source.getCertificationTime());
                String format = SDF.format(original);
                Date certificationTime = SDF.parse(format);
                target.setCertificationTime(certificationTime);
            } catch (ParseException e) {
                log.info(e.getMessage());
                target.setCertificationTime(null);
                //throw new ApplicationException(ApplicationException.DATE_PARAM_FORMAT_ERROR, "创建时间格式错误");
            }
        }
        target.setId(source.getId());
        target.setAccount(source.getAccount());
        //密码加密
        String encoded = null;
        try {
            encoded = MD5.EncoderByMd5(source.getPassword() + PASSWORD_SECRET_KEY);
        } catch (Exception e) {
            log.info(e.getMessage());
            throw new ApplicationException(ApplicationException.PASSWORD_ENCRYPT_ERROR, "用户登录密码加密错误");
        }
        target.setPassword(encoded);
        target.setRealName(source.getRealName());
        target.setIdentityNumber(source.getIdentityNumber());
        target.setNickName(source.getNickName());
        target.setHeadImage(source.getHeadImage());
        target.setPhone(source.getPhone());
        target.setEmail(source.getEmail());
        target.setGender(source.getGender());
        target.setRankId(source.getRankId());
        target.setQuestionId(source.getQuestionId());
        target.setAnswer(source.getAnswer());
        target.setLastLoginIp(source.getLastLoginIp());
        target.setCurrentLoginIp(source.getCurrentLoginIp());
        target.setProvince(source.getProvince());
        target.setCity(source.getCity());
        target.setAddress(source.getAddress());
    }

    private void loadUserMigrationInput(UserMigrationInput target, String[] source) {
        if(target == null || source == null) {
            return;
        }
        target.setId(Long.parseLong(source[0]));
        target.setAccount(source[1]);
        target.setPassword("888888");
        target.setRealName(source[2]);
        target.setIdentityNumber(source[3]);
        target.setNickName(source[4]);
        if(source[5] != null) {
            try {
                Long rankId = Long.parseLong(source[5]);
                target.setRankId(rankId);
            }catch(Exception ex) {
                target.setRankId(null);
            }
        }
        if(source[6] != null) {
            if(source[6].equals("TRUE")) {
                target.setGender(0);
            }else {
                target.setGender(1);
            }
        }
        target.setPhone(source[7]);
        target.setCertificationTime(source[8]);
        if(source[9] != null) {
            target.setProvince(source[9]);
        }
        if(source[10] != null) {
            target.setCity(source[10]);
        }
        if(source[11] != null && source[12] != null) {
            target.setAddress(source[11] + source[12]);
        }else if(source[11] != null) {
            target.setAddress(source[11]);
        }else if(source[12] != null){
            target.setAddress(source[12]);
        }
    }
}
