package com.flytodream.config;

import lombok.Data;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

import java.util.Optional;

/**
 * @Description
 * @Date 2021/6/2 21:07
 * @Author by tongxm
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigApplication3344 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigApplication3344.class);
//        Tongxm tongxm = new Tongxm();
//        tongxm.setAge(25);
//        tongxm.setName("童宣敏");
        //getTongxm()
//        Tongxm tongxm1 = Optional.ofNullable(tongxm).orElseGet(()->{
//        return getTongxm();
//        });
    }

    public static Tongxm getTongxm(){
        return new Tongxm();
    }

    @Data
    static class Tongxm{
        private String name;
        private Integer age;

        @Override
        public String toString() {
            return "Tongxm{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
