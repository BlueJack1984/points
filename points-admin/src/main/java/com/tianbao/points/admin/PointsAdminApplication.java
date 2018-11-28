package com.tianbao.points.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@MapperScan(basePackages = {"com.tianbao.points.core.dao"})
//scanBasePackages可添加多项，以逗号分隔
@SpringBootApplication(scanBasePackages = {"com.tianbao.points"})
public class PointsAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(PointsAdminApplication.class, args);
    }
}
