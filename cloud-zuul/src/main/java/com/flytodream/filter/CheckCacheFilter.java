package com.flytodream.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletPath;
import org.springframework.cloud.netflix.zuul.filters.Route;
import org.springframework.cloud.netflix.zuul.filters.RouteLocator;
import org.springframework.cloud.netflix.zuul.filters.SimpleRouteLocator;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UrlPathHelper;

import javax.servlet.http.HttpServletRequest;

/**
 * @author tongxm
 * @date 2021年05月23日 2:51 下午
 */
@Component
@Slf4j
public class CheckCacheFilter extends ZuulFilter {

    private RouteLocator routeLocator;

    @Autowired
    public void setRouteLocator(DispatcherServletPath server, ZuulProperties zuulProperties) {
        routeLocator = new SimpleRouteLocator(server.getPrefix(), zuulProperties);
    }
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;

    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        Route route = route(RequestContext.getCurrentContext().getRequest());
        log.info(route.getId());
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        log.info("enter into CheckCacheFilter-pre-0");

        return null;
    }

    private Route route(HttpServletRequest request) {
        String requestURI = new UrlPathHelper().getPathWithinApplication(request);
        return routeLocator.getMatchingRoute(requestURI);
    }
}
