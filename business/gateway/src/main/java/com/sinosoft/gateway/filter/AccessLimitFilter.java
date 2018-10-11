package com.sinosoft.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.sinosoft.gateway.service.Limiter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * Created by Jason on 2017/8/15.
 */
public class AccessLimitFilter extends ZuulFilter{

    private static final Logger logger = LoggerFactory.getLogger(AccessLimitFilter.class);

    @Autowired
    private Limiter limiter;

    @Override
    public int filterOrder() {
        return 50000;
    }

    @Override
    public String filterType() {
        return "pre";
    }

    public boolean shouldFilter() {
        return true;
    }

    public Object run() {
        try {
            RequestContext ctx = RequestContext.getCurrentContext();
            HttpServletRequest request = ctx.getRequest();
            String authType = request.getAuthType();
            String contextPath = request.getContextPath();
            Enumeration<String> headerNames = request.getHeaderNames();

            String method = request.getMethod();
            String pathInfo = request.getPathInfo();
            String queryString = request.getQueryString();
            String sessionId = request.getRequestedSessionId();
            String remoteUser = request.getRemoteUser();
            String uri = request.getRequestURI();
            String url = request.getRequestURL().toString();
            String servletPath = request.getServletPath();
            String forwardedFor = RequestContext.getCurrentContext().getZuulRequestHeaders().get("x-forwarded-for");
            String forwardedHost = RequestContext.getCurrentContext().getZuulRequestHeaders().get("x-forwarded-host");
            String os = request.getParameter("os");

            logger.info("running javaPreFilter");
            logger.info("authType:" + authType +
                    " contextPath:" + contextPath +
                    " method:" + method + " pathInfo:" + pathInfo +
                    " queryString:" + queryString + " sessionId:" + sessionId + " remoteUser:" + remoteUser+
                    " uri:" + uri +   " servletPath:" + servletPath +" url:" + url +
                    " headerNames:"+headerNames +
                    " forwardedFor:"+forwardedFor+" forwardedHost:"+forwardedHost + " os:" + os);
            logger.info(RequestContext.getCurrentContext().getZuulRequestHeaders().toString());

            if("OPTIONS".equals(method)) {  //web端加head之前的探测请求
                logger.info("web options request allow pass.");
                return null;
            }

            //通过计算次数来判断请求是否需要限制
            if(limiter.needLimit(ctx)){
                ctx.setSendZuulResponse(false);
                ctx.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());

                logger.info("AuthorizePreFilter : the request had been limited");
            }
        }
        catch(Exception e){
            logger.info("error:", e);
        }
        return null;
    }
}
