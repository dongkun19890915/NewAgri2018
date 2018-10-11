package com.sinosoft.gateway.filter;

import com.alibaba.fastjson.JSON;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.sinosoft.sso.api.dto.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.Tracer;

/**
 * Created by Jason on 2017/4/7.
 */
public class TestFilter extends ZuulFilter {
    private static Logger logger = LoggerFactory.getLogger(TestFilter.class);

    @Autowired(required = false)
    private Tracer tracer;

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
//        RequestContext ctx = RequestContext.getCurrentContext();
//        UserInfo user = new UserInfo();
//        user.setUserCode("0000017189");
//        user.setComCode("00000000");
//        user.setUserName("jason");
//        logger.info("###add header");
//        ctx.addZuulRequestHeader("sino-req-ctx-user", JSON.toJSONString(user));
        return null;
    }
}
