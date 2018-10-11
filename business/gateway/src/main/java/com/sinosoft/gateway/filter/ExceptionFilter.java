package com.sinosoft.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Jason on 2017/4/7.
 */
//@Component
public class ExceptionFilter extends ZuulFilter {
    private static Logger logger = LoggerFactory.getLogger(ExceptionFilter.class);

    @Override
    public String filterType() {
        /***
        pree：可以在请求被路由之前调用
        routing：在路由请求时候被调用
        post：在routing和error过滤器之后被调用
        error：处理请求时发生错误时被调用
         ***/
        return "error";
    }

    @Override
    public int filterOrder() {
        return 10;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        try{
            RequestContext ctx = RequestContext.getCurrentContext();
            Object e = ctx.get("error.exception");

            if (e != null && e instanceof ZuulException) {
                ZuulException zuulException = (ZuulException)e;
                logger.error("Zuul failure detected: " + zuulException.getMessage(), zuulException);

                ctx.remove("error.status_code");

                // Populate context with new response values
                ctx.setResponseBody("{}");
                ctx.getResponse().setContentType("application/json");
                ctx.setResponseStatusCode(500); //Can set any error code as excepted
            }
        } catch (Exception ex) {
            logger.error("Exception filtering in custom error filter", ex);
            ReflectionUtils.rethrowRuntimeException(ex);
        }
        return null;
    }
}
