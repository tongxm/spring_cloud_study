package com.flytodream.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletPath;
import org.springframework.cloud.netflix.zuul.filters.Route;
import org.springframework.cloud.netflix.zuul.filters.SimpleRouteLocator;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author tongxm
 * @date 2021年05月23日 3:15 下午
 */
@Configuration
public class CustomRouteLocatorConfig{

    @Resource
    protected ZuulProperties zuulProperties;

    @Bean
    public CustomRouteLocator dbRouteLocator(DispatcherServletPath server) {
        return new CustomRouteLocator(server.getPrefix(), zuulProperties);
    }


}
