package com.sinosoft.admin.web;

import com.fasterxml.jackson.core.Base64Variants;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.apache.http.HttpHeaders;
import org.springframework.beans.factory.InitializingBean;

import java.nio.charset.StandardCharsets;

/**
 * Created by Jason on 2017/8/24.
 */
public class BasicAuthFilter extends ZuulFilter implements InitializingBean{

    private String username;
    private String password;
    private String encodedAuth;

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
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        ctx.addZuulRequestHeader(HttpHeaders.AUTHORIZATION, this.encodedAuth);
        return null;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        String auth = username+":"+password;
        this.encodedAuth = "Basic "+ Base64Variants.MIME_NO_LINEFEEDS.encode(auth.getBytes(StandardCharsets.US_ASCII));
    }
}
