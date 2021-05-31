package com.flytodream.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpStatus;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author tongxm
 * @date 2021年05月23日 2:48 下午
 */
@Component
@Slf4j
public class AuthenFilter extends ZuulFilter {
    public static ThreadLocal<String> realPath = new ThreadLocal<String>();
    public static ThreadLocal<String> location = new ThreadLocal<String>();

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 2;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        log.info("enter into AuthenFilter-pre-2");
        // /payment/get/1
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info("url-{}",request.getRequestURI());
//        ctx.setRequest();
        location.set("cloud-order-service");
        realPath.set("/consumer/payment/get/1");



        return null;
    }
}
