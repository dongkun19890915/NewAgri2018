package com.sinosoft.gateway.service;

import com.netflix.zuul.context.RequestContext;

/**
 * Created by Jason on 2017/8/17.
 */
public interface Limiter {
    public boolean needLimit(RequestContext context);
}
