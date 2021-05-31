package com.flytodream.config;

import com.flytodream.filter.AuthenFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.Route;
import org.springframework.cloud.netflix.zuul.filters.SimpleRouteLocator;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;

/**
 * @author tongxm
 * @date 2021年05月23日 3:15 下午
 */
@Slf4j
public class CustomRouteLocator extends SimpleRouteLocator {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    public CustomRouteLocator(String servletPath, ZuulProperties properties) {
        super(servletPath, properties);
    }

    @Override
    public Route getMatchingRoute(final String path) {
        log.info("entre into ---CustomRouteLocator");

        Route matchingRoute = super.getMatchingRoute(path);
        matchingRoute.setLocation(AuthenFilter.location.get());
        matchingRoute.setPath(AuthenFilter.realPath.get());
        return matchingRoute;

    }

    /**
     * 新客户端调用路由
     * 目前已经支持PathParams
     *
     * @param path
     * @return
     */
    private Route getMatchingRouteV2(final String path) {

        return null;
    }


}
