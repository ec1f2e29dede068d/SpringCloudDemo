package com.c.w;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import javax.servlet.http.HttpServletRequest;

public class AccessFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        Object accessToken = request.getParameter("accessToken");
        if (accessToken == null) {
            System.out.println("access token is empty");
            context.setSendZuulResponse(false);
            context.setResponseStatusCode(401);
            context.setResponseBody("with no accessToken");
            context.getResponse().setContentType("application/json;charset=UTF-8");
            return null;
        }
        System.out.println("access token ok");
        return null;
    }
}
