package com.sinosoft.gateway.filter;

import com.alibaba.fastjson.JSON;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.sinosoft.framework.constant.GlobalConstant;
//import com.sinosoft.framework.dto.UserInfo;
import com.sinosoft.framework.exception.SystemException;
import com.sinosoft.sso.api.util.ConstantUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by Jason on 2017/4/7.
 */
@Component
public class RequestUserFilter extends ZuulFilter {
    private static Logger logger = LoggerFactory.getLogger(RequestUserFilter.class);

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
        RequestContext ctx = RequestContext.getCurrentContext();

        com.sinosoft.sso.api.dto.UserInfo userInfo=  (com.sinosoft.sso.api.dto.UserInfo) ctx.getRequest().getAttribute(ConstantUtil.USER_ATTRIBE_NAME);

//        UserInfo userInfo = (UserInfo) ctx.getRequest().getAttribute(ConstantUtil.USER_ATTRIBE_NAME);
        /*UserInfoApp userInfoApp = new UserInfoApp();
        userInfoApp.setName("prpins");
        Map map = new HashMap();
        map.put("comcode","12");
        map.put("riskcode","001");
        userInfoApp.setArrach(map);
        userInfo.addUserInfoApp(userInfoApp);*/
        try {
            ctx.addZuulRequestHeader(GlobalConstant.CTX_REQ_KEY_PREFIX+"user", URLEncoder.encode(JSON.toJSONString(userInfo),"UTF-8"));
        } catch (UnsupportedEncodingException e) {
            logger.error("Zuul URLEncoder error",e);
            throw new SystemException("系统进行字符编码异常",e);
        }
        return null;
    }
}
