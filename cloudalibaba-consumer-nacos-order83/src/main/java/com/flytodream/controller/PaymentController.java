package com.flytodream.controller;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.PropertyKeyConst;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.exception.NacosException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Properties;

/**
 * @Description
 * @Date 2021/6/6 18:14
 * @Author by tongxm
 */
@RestController
@RefreshScope //在控制器类加入@RefreshScope注解使当前类下的配置支持Nacos的动态刷新功能。
public class PaymentController {

    @Autowired
    private RestTemplate restTemplate;


    @GetMapping("/config/info/{dataId}")
    public String getConfigInfo(@PathVariable String dataId) throws NacosException {
        return restTemplate.getForObject("http://nacos-payment-provider/config/info/"+dataId,String.class);
    }
}
