package com.flytodream.hystrix.controller;


import com.flytodream.hystrix.service.PaymentService;
import com.flytodream.springcloud.entities.CommonResult;
import com.flytodream.springcloud.entities.Payment;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @auther zzyy
 * @create 2020-02-18 10:43
 */
@RestController
@Slf4j
public class PaymentController
{


    @GetMapping(value = "/payment/ok")
    public String ok()
    {
        return "ok";

    }
    @GetMapping(value = "/payment/timeout")
    public String timeout()
    {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "timeout";
    }


    @GetMapping(value = "/payment/ok2")
    public String ok2()
    {
        return "ok";

    }
    @GetMapping(value = "/payment/timeout2")
    @HystrixCommand(fallbackMethod ="error",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "2000")
    })
    public String timeout2()
    {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "timeout";
    }




    @GetMapping(value = "/payment/circuit/{id}")
    @HystrixCommand(fallbackMethod ="circuiterror",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "2000"),
            //打开熔断器
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),// 是否开启断路器,
            //休眠窗口时间
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),
            //窗口期的请求次数
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),
            //窗口期的请求次数失败所占用的百分比，达到后熔断器开启
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),// 失败率达到多少后跳闸

    })
    public String circuit(@PathVariable Integer id)
    {
       if(id<0){
           throw new RuntimeException("小于1了");
       }
        return "返回成功，录入的数字是："+id;
    }


    public String error(){
        return "相应超时-provider！！！";
    }

    public String circuiterror(Integer id){
        return "熔断的fallback--输入的参数是"+id;
    }

    public String glableError(){
        return "公共相应超时-provider！！！";
    }




}
