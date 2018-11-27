package com.tianbao.points.admin.controller;


import com.tianbao.points.core.dto.response.OutputResult;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @desc 首页公告入口
 * @author lushusheng
 * @date 2018-11-27
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/announcement")
public class AnnouncementController {

    private final
    /**
     * @desc 首页公告入口
     * @author lushusheng
     * @date 2018-11-27
     */
    @PostMapping("/save")
    public OutputResult<Void> save() {
        return new OutputResult<>();
    }
}
