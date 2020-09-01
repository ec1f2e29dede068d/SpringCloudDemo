package com.c.w.thirteen;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.cloud.netflix.zuul.util.ZuulRuntimeException;

import javax.servlet.http.HttpServletRequest;

public class ExceptionFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return FilterConstants.ROUTE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 3;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        String uri = request.getRequestURI();
        return uri.contains("exceptionTest");
    }

    @Override
    public Object run() throws ZuulException {
        System.out.println("执行ExceptionFilter,将抛出异常");
        throw new ZuulRuntimeException(new ZuulException("exception msg", 201, "my cause"));
    }
}
