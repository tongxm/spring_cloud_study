package com.flytodream.hystrix;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Payment8002ApplicationStart {
    public static void main(String[] args) {
        SpringApplication.run(Payment8002ApplicationStart.class,args);
    }

}
