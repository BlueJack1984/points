package com.tianbao.points.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = {"com.tianbao.points.core.dao"})
//scanBasePackages可添加多项，以逗号分隔
@SpringBootApplication(scanBasePackages = {"com.tianbao.points.app", "com.tianbao.points.core"})
public class PointsAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(PointsAppApplication.class, args);
    }
}
