package com.flytodream;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Description
 * @Date 2021/6/6 18:13
 * @Author by tongxm
 */
@EnableDiscoveryClient
@SpringBootApplication
public class NacosPaymentMain9002 {
    public static void main(String[] args) {
        SpringApplication.run(NacosPaymentMain9002.class);
    }
}
