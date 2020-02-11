package com.tianbao.points.admin.debug;

import com.tianbao.points.admin.dto.request.UserInput;
import com.tianbao.points.core.dto.response.OutputResult;
import com.tianbao.points.core.entity.PersonalBonus;
import com.tianbao.points.core.entity.Rank;
import com.tianbao.points.core.entity.User;
import com.tianbao.points.core.exception.ApplicationException;
import com.tianbao.points.core.service.IPersonalBonusService;
import com.tianbao.points.core.service.IRankService;
import com.tianbao.points.core.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class UserUpdateDebugController {

    @Autowired
    private IUserService userServer;
    @Autowired
    private IRankService rankServer;
    @Autowired
    private IPersonalBonusService personalBonusServer;

    @Test
    public void testUserUpdate() throws ApplicationException{

        UserInput userInput = new UserInput();
        userInput.setId(76L);
        userInput.setRealName("石薇");
        userInput.setRankId(4L);
        userInput.setIdentityNumber("111111111");
        userInput.setGender(0);
        userInput.setPhone("17716698285");
        userInput.setProvince("北京");
        userInput.setCity("北京市");
        userInput.setAddress("朝阳区朝阳北路");
        User user = userServer.selectById(userInput.getId());
        if(user == null) {
            throw new ApplicationException(ApplicationException.MEMBER_USER_NOT_EXISTS, "会员用户实体不存在");
        }
        //在这判断会员等级是否有变化
        Long target = userInput.getRankId();
        Long source = user.getRankId();
        handleUpdateRankParameter(target, source, user.getId());
        copyProperties(user, userInput);
        user.setUpdateTime(new Date());
        user.setUpdateUserId(110L);
        userServer.updateById(user);
    }


    public void handleUpdateRankParameter(Long target, Long source, Long userId) throws ApplicationException {
        if(target <= source) {
            return;
        }
        Rank targetRank = rankServer.selectById(target);
        Rank sourceRank = rankServer.selectById(source);
        Integer extraPoints = targetRank.getBasePoints() - sourceRank.getBasePoints();
        PersonalBonus personalBonus = personalBonusServer.getLatestByUserId(userId);
        if(null == personalBonus) {
            log.info("在更改会员等级时，给会员增加积分时出错！");
            throw new ApplicationException(ApplicationException.PERSONAL_BONUS_NOT_EXISTS, "个人积分实体不存在");
        }
        Double newEndPoints = personalBonus.getEndPoints() + extraPoints;
        personalBonus.setEndPoints(newEndPoints);
        personalBonus.setUpdateTime(new Date());
        personalBonus.setUpdateUserId(110L);
        personalBonusServer.updateById(personalBonus);
    }



    /**
     * @author lushusheng
     * @Date 2018-12-02
     * @Desc 复制更新的属性
     * @return 无返回
     * @update
     */
    private void  copyProperties(User target, UserInput source) throws ApplicationException {

        if(target == null || source == null) {
            return;
        }
        target.setRealName(source.getRealName());
        target.setRankId(source.getRankId());
        target.setIdentityNumber(source.getIdentityNumber());
        if(source.getGender() != null) {
            target.setGender(source.getGender());
        }
        if(! StringUtils.isEmpty(source.getPhone())) {
            target.setPhone(source.getPhone());
        }
        if(! StringUtils.isEmpty(source.getProvince())) {
            target.setProvince(source.getProvince());
        }
        if(! StringUtils.isEmpty(source.getCity())) {
            target.setCity(source.getCity());
        }
        if(! StringUtils.isEmpty(source.getAddress())) {
            target.setAddress(source.getAddress());
        }
    }
}
