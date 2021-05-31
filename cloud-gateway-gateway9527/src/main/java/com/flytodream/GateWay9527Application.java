package com.flytodream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Description
 * @Date 2021/5/30 18:51
 * @Author by tongxm
 */
@SpringBootApplication
@EnableEurekaClient
public class GateWay9527Application {
    public static void main(String[] args) {
        SpringApplication.run(GateWay9527Application.class);
    }
}
