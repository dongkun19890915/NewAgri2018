package com.sinosoft.gateway.filter;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONReader;
import com.netflix.util.Pair;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.util.HTTPRequestUtils;
import com.sinosoft.framework.constant.GlobalConstant;
import com.sinosoft.framework.exception.BaseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.ribbon.RibbonHttpResponse;
import org.springframework.cloud.sleuth.trace.DefaultTracer;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.ReflectionUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.management.LockInfo;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import java.util.zip.ZipException;

/**
 * Created by Jason on 2017/8/14.
 */
@Component
public class ResultWrapperFilter extends ZuulFilter {

    private static final Logger logger = LoggerFactory.getLogger(ResultWrapperFilter.class);

    @Value("#{'${zuul.resultWrapper.exclusion:null}'.split(',')}")
    private List<String> exclusions;

    @Autowired(required = false)
    private DefaultTracer tracer;

    @Override
    public String filterType() {
        return "post";
    }

    @Override
    public int filterOrder() {
        return -1;
    }

    @Override
    public boolean shouldFilter() {
//        RequestContext context = RequestContext.getCurrentContext();
//        return (context.getThrowable() == null) /*&& (context.getResponseStatusCode() < 400)*/ && ((!context.getZuulResponseHeaders().isEmpty()) || (context.getResponseDataStream() != null) || (context.getResponseBody() != null));

        RequestContext context = RequestContext.getCurrentContext();
        String contentType = getZuulResonseHeader(context, "Content-Type");
        String requestUri = (String) context.get("requestURI");


        AntPathMatcher pathMatcher = new AntPathMatcher();
        for (String exclusion : exclusions) {
            if (pathMatcher.match(exclusion, requestUri)) {
                return false;
            }
        }
        long len = -1;
        RibbonHttpResponse ribbonHttpResponse =null;
        try{
            ribbonHttpResponse = (RibbonHttpResponse) context.get("zuulResponse");
            len = ribbonHttpResponse.getHeaders().getContentLength();
        }catch (Exception e){
            String strlen = getZuulResonseHeader(context, "Content-Length");
            if(strlen==null||strlen.trim().length()==0){
                len=-1;
            }else{
                len=Integer.parseInt(strlen);
            }
        }

        //如果大于500报错进入过滤器处理
        if (context.getResponseStatusCode() >= 500) {
            return true;
        }
        //json进入过滤器
        if (contentType.contains(MediaType.APPLICATION_JSON_VALUE)) {
            return true;
        }
        //空数据走过滤器输出json提示
        if(len==0){
            return true;
        }
        if (contentType.toLowerCase().equals(MediaType.APPLICATION_OCTET_STREAM)) {
            return false;
        }

        return false;

//        boolean flag = (context.getThrowable() == null)
//                && ((!context.getZuulResponseHeaders().isEmpty()) || (context.getResponseDataStream() != null) || (context.getResponseBody() != null));
//
//        return flag;

    }

    @Override
    public Object run() {
        try {
            RequestContext context = RequestContext.getCurrentContext();
            int status = context.getResponse().getStatus();
            logger.debug("http status" + status);
            //int status = 0;
            String body = null;
            if (status >= 500) {
                body = getFailBody(context);
            } else if (status < 400) {
                body = getSuccessBody(context);
            } else {
                return null;
            }

            context.addZuulResponseHeader(GlobalConstant.CTX_TRANSACTION_ID,
                    tracer != null ? tracer.getCurrentSpan().traceIdString() : "99999999");
            context.setResponseStatusCode(HttpStatus.OK.value());
            context.getResponse().setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
            context.getResponse().setCharacterEncoding("UTF-8");
            context.setResponseBody(body);

        } catch (Exception e) {
            logger.error("error when filtering in SendErrorResponseFilter", e);
            ReflectionUtils.rethrowRuntimeException(e);
        }

        return null;
    }

    private String getFailBody(RequestContext context) throws UnsupportedEncodingException {
        String expMessage = null;
        String expCode = BaseException.defaultErrorCode;
        String expType = null;
        List removeHeaders = new ArrayList<Pair<String, String>>();
        for (Pair header : context.getZuulResponseHeaders()) {
            if (header.first().equals(GlobalConstant.CTX_RES_KEY_EXP_MSG)) {
                expMessage = (String) header.second();
                removeHeaders.add(header);
            } else if (header.first().equals(GlobalConstant.CTX_RES_KEY_EXP_CODE)) {
                expCode = (String) header.second();
                removeHeaders.add(header);
            } else if (header.first().equals(GlobalConstant.CTX_RES_KEY_EXP_TYPE)) {
                expType = (String) header.second();
                removeHeaders.add(header);
            }
        }

        //自定义头不传给前端
        context.getZuulResponseHeaders().removeAll(removeHeaders);
        context.addZuulResponseHeader("Content-Type", "application/json;charset=UTF-8");

        logger.error("后端服务处理失败，错误编码-{},错误信息-{},异常类型-{}", expCode, expMessage, expType);

        JSONObject body = new JSONObject();
        body.put("code", expCode);
        body.put("message", URLDecoder.decode(expMessage, "UTF-8"));

        return body.toJSONString();
    }

    private String getSuccessBody(RequestContext context) throws IOException {

        HttpServletResponse servletResponse = context.getResponse();
        Object originBody = null;

        if (context.getResponseBody() != null) {
            originBody = JSONObject.parseObject(context.getResponseBody());
        }

        boolean isGzipRequested = false;

        String requestEncoding = context.getRequest().getHeader("accept-encoding");
        if ((requestEncoding != null) && (HTTPRequestUtils.getInstance().isGzipped(requestEncoding))) {
            isGzipRequested = true;
        }

        InputStream is = null;
        is = context.getResponseDataStream();
        InputStream inputStream = is;
        if ((is != null) && (context.sendZuulResponse())) {
            if ((context.getResponseGZipped()) && (!isGzipRequested)) {
                Long len = context.getOriginContentLength();
                if ((len == null) || (len.longValue() > 0L)) {
                    try {
                        inputStream = new GZIPInputStream(is);
                    } catch (ZipException ex) {
                        logger.debug("gzip expected but not received assuming unencoded response " +
                                RequestContext.getCurrentContext()
                                        .getRequest().getRequestURL()
                                        .toString());
                        inputStream = is;
                    }
                }
            } else if ((context.getResponseGZipped()) && (isGzipRequested)) {
                servletResponse.setHeader("Content-Encoding", "gzip");
            }

            InputStreamReader isr = new InputStreamReader(inputStream);
            JSONReader jr = new JSONReader(isr);
            originBody = jr.readObject();
            inputStream.close();
            jr.close();
        }

        JSONObject body = new JSONObject();
        body.put("code", "0000");
        body.put("message", "成功");
        body.put("content", originBody);

        return body.toJSONString();
    }

    private String getZuulResonseHeader(RequestContext context, String name) {
        name = name.toLowerCase();
        List<Pair<String, String>> headers = context.getZuulResponseHeaders();
        for (Pair header : headers) {
            if (((String)header.first()).toLowerCase().equals(name)) {
                return (String) header.second();
            }
        }
        return "";
    }
}
