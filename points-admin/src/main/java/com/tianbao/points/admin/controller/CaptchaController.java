package com.tianbao.points.admin.controller;

import com.tianbao.points.core.dto.response.OutputResult;
import com.tianbao.points.core.exception.ApplicationException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

/**
 * @desc 图片验证码随机生成入口
 * @author lushusheng
 * @date 2018-12-21
 */

@Api(value = "captcha", description = "图片验证码")
@RestController
@RequiredArgsConstructor
@RequestMapping("/captcha")
@Slf4j
public class CaptchaController {

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
//    @ApiOperation(value = "随机产生4个数字，组成一个字符串返回", notes = "随机产生4个数字，组成一个字符串返回")
//    @ApiImplicitParams({})
//    @CrossOrigin
//    @GetMapping("/generate")
//    public OutputResult<String> generate() throws ApplicationException {
//        //String str="0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
//        String container = "0123456789";
//        StringBuilder captcha = new StringBuilder(CAPTCHA_BITS);
//        for(int i = 0; i < CAPTCHA_BITS; i ++) {
//            Random random = new Random();
//            /**
//             * nextInt(int n) 该方法的作用是生成一个随机的int值，该值介于[0,n)的区间，也就是0到n之间的随机int值，包含0而不包含n。
//             */
//            char single = container.charAt(random.nextInt(container.length()));
//            captcha.append(single);
//        }
//        return new OutputResult<>(captcha.toString());
//    }
}
