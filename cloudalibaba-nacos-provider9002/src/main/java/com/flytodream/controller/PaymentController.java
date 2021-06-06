package com.flytodream.controller;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.PropertyKeyConst;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.exception.NacosException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Properties;

/**
 * @Description
 * @Date 2021/6/6 18:14
 * @Author by tongxm
 */
@RestController
@RefreshScope //在控制器类加入@RefreshScope注解使当前类下的配置支持Nacos的动态刷新功能。
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    @Value("${spring.cloud.nacos.config.server-addr}")
    private String nacos;

    @GetMapping(value = "/payment/nacos/{id}")
    public String getPayment(@PathVariable("id") Integer id)
    {
        return "nacos registry, serverPort: "+ serverPort+"\t id"+id;
    }



    @GetMapping("/config/info/{dataId}")
    public String getConfigInfo(@PathVariable String dataId) throws NacosException {
        Properties properties = new Properties();
        // nacos服务器地址，127.0.0.1:8848
        properties.put(PropertyKeyConst.SERVER_ADDR, nacos);
        ConfigService configService = NacosFactory.createConfigService(properties);
        String default_group = configService.getConfig(dataId, "DEFAULT_GROUP", 1000L);
        return serverPort+"端口返回---"+default_group;
    }
}
