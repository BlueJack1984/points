package com.tianbao.points.admin.controller.security;

import com.tianbao.points.admin.dto.request.LoginInput;
import com.tianbao.points.admin.security.JwtToken;
import com.tianbao.points.core.dto.response.OutputResult;
import com.tianbao.points.core.dto.response.OutputResultCaptcha;
import com.tianbao.points.core.entity.Role;
import com.tianbao.points.core.entity.User;
import com.tianbao.points.core.exception.ApplicationException;
import com.tianbao.points.core.service.IRoleService;
import com.tianbao.points.core.service.IUserService;
import com.tianbao.points.core.utils.MD5;
import com.tianbao.points.core.utils.jwt.JwtUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author lushusheng
 * @description 安全管理模块，包括用户登录和退出，产生图形验证码等
 * @date 2018-12-11
 * @time 11:12
 */
@RestController
@RequestMapping("/security")
@Slf4j
@RequiredArgsConstructor
public class SecurityController {

    private final IUserService userServer;
    private final IRoleService roleServer;
    @Value("${password.encrypt.key}")
    private String PASSWORD_SECRET_KEY;
    /**
     * 保存产生的图形验证码，用于用户输入验证码在后台对比
     */
    private static final Map<String, String> captchaMap = new ConcurrentHashMap<>();
    /**
     * 设置要产生的验证码位数
     */
    private static final Integer CAPTCHA_BITS = 4;


    /**
     * @desc 随机产生4个数字，组成一个字符串返回
     * @author lushusheng 2018-12-21
     * @param
     * @return 返回一个包含4个数字（0-9之间）的字符串
     * @throws ApplicationException 生成异常
     */
    @ApiOperation(value = "随机产生4个数字，组成一个字符串返回", notes = "随机产生4个数字，组成一个字符串返回")
    @ApiImplicitParams({})
    @CrossOrigin
    @GetMapping("/captcha/generate")
    public OutputResultCaptcha<String> generateCaptcha() throws ApplicationException {
        //String str="0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String container = "0123456789";
        StringBuilder captcha = new StringBuilder(CAPTCHA_BITS);
        for(int i = 0; i < CAPTCHA_BITS; i ++) {
            Random random = new Random();
            /**
             * nextInt(int n) 该方法的作用是生成一个随机的int值，该值介于[0,n)的区间，也就是0到n之间的随机int值，包含0而不包含n。
             */
            char single = container.charAt(random.nextInt(container.length()));
            captcha.append(single);
        }
        String code = captcha.toString();
        String identityId = UUID.randomUUID().toString();
        captchaMap.put(identityId, code);
        OutputResultCaptcha<String> result = new OutputResultCaptcha<>(identityId, code);
        return result;
    }

    /**
     * @desc 用户登录功能实现
     * @author lushusheng
     * @date 2018-12-21
     * @param loginInput 用户登录信息，包括用户名，密码，图形验证码等
     * @return 返回用户登录后生产的jwt令牌
     * @throws ApplicationException 生成异常
     */
    @ApiOperation(value = "用户登录功能实现", notes = "用户登录功能实现")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "body", dataType = "LoginInput", name = "loginInput", value = "登录输入参数", required = true)})
    @CrossOrigin
    @PostMapping("/login")
    public OutputResult<JwtToken> login(@RequestBody @Valid LoginInput loginInput) throws ApplicationException {
        //判断验证码是否正确
        String userCaptcha = loginInput.getUserCaptcha();
        String savedCaptcha = captchaMap.get(loginInput.getIdentityId());
        if (! userCaptcha.equals(savedCaptcha)) {
            log.info("-----------------------------------> 验证码错误");
            throw new ApplicationException(ApplicationException.CAPTCHA_PARAM_ERROR, "验证码填写错误");
        }
        String account = loginInput.getAccount();
        String password = loginInput.getPassword();
        //从数据库中查询用户
        User user = userServer.getByAccount(account);
        if(user == null) {
            log.info("数据库中查询用户为空，数据库中没有该用户！！！");
            throw new ApplicationException(ApplicationException.ACCOUNT_PARAM_ERROR, "用户账号填写错误");
        }
        //判断是否是会员，如果是会员则返回错误
        List<Role> roleList = roleServer.getListByUserId(user.getId());
        if(roleList == null || roleList.size() <= 0 || roleList.get(0) == null ||
            ! roleList.get(0).getName().contains("管理员")) {
            log.info("数据库中查询用户的角色相关为空，该用户没有合适的角色！！！");
            throw new ApplicationException(ApplicationException.ACCOUNT_PARAM_ERROR, "用户账号填写错误");
        }
        String encoded = null;
        try {
            encoded = MD5.EncoderByMd5(password + PASSWORD_SECRET_KEY);
        } catch (Exception e) {
            log.info(e.getMessage());
            throw new ApplicationException(ApplicationException.PASSWORD_ENCRYPT_ERROR, "用户登录密码加密错误");
        }
        if(! encoded.equals(user.getPassword())) {
            throw new ApplicationException(ApplicationException.PASSWORD_PARAM_ERROR, "用户登录密码填写错误");
        }
        //返回得到的jwttoken给前端
        String token = JwtUtil.sign(account, user.getPassword());
        JwtToken jwtToken = new JwtToken(user.getId(), token);
        //获取当前ip
        InetAddress inetAddress = null;
        String currentLoginIp = null;
        try {
            inetAddress = InetAddress.getLocalHost();
            currentLoginIp = inetAddress.getHostAddress();
        } catch (UnknownHostException e) {
            log.info(e.getMessage());
            currentLoginIp = "127.0.0.1";
        }
        //登录成功后，更新登录ip
        user.setLastLoginTime(user.getCurrentLoginTime());
        user.setLastLoginIp(user.getCurrentLoginIp());
        user.setCurrentLoginIp(currentLoginIp);
        user.setCurrentLoginTime(new Date());
        user.setUpdateTime(new Date());
        user.setUpdateUserId(user.getId());
        userServer.updateById(user);
        //删除map中保存的验证码
        captchaMap.remove(loginInput.getIdentityId());
        return new OutputResult<>(jwtToken);
    }

    /**
     * @desc 查询用户是否认证登录
     * @author lushusheng
     * @date 2018-12-21
     * @return 返回用户登录后生产的jwt令牌
     * @throws ApplicationException 生成异常
     */
    @ApiOperation(value = "查询用户是否认证登录", notes = "查询用户是否认证登录")
    @ApiImplicitParams({})
    @CrossOrigin
    @GetMapping("/article")
    public OutputResult<String> article() {
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            return new OutputResult<>("You are already logged in");
        } else {
            return new OutputResult("You are guest");
        }
    }

    /**
     * @author lushusheng
     * @description 用户退出登录
     * @param currentId 当前用户id
     * @return 返回数据
     * @throws ApplicationException 修改异常
     * @date 2018-12-11
     * @time 12:12
     */
    @ApiOperation(value = "用户退出登录", notes = "用户退出登录")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "Long", name = "currentId", value = "当前用户id", required = true)})
    @CrossOrigin
    @GetMapping(value = "/logout")
    public OutputResult<String> logout(@RequestHeader(value = "_current_id") Long currentId) throws ApplicationException{
        //暂时没有业务，这里应该进行使token失效的操作
        return new OutputResult<>("用户成功退出：" + currentId);
    }
}
