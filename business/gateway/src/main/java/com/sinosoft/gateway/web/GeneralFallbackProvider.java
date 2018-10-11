package com.sinosoft.gateway.web;

import com.netflix.zuul.context.RequestContext;
import com.sinosoft.framework.constant.GlobalConstant;
import com.sinosoft.framework.exception.SystemException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.route.ZuulFallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by Jason on 2017/6/21.
 */
public class GeneralFallbackProvider implements ZuulFallbackProvider {

    private static final Logger logger = LoggerFactory.getLogger(GeneralFallbackProvider.class);

    private static final String ERROR_CODE = "9990";
    private static final String ERROR_MSG = "服务暂时拒绝访问，请稍后再试!";
    private static final String ERROR_EXP = SystemException.class.getName();

    private String serviceId = "*";

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    @Override
    public String getRoute() {
        return this.getServiceId();
    }

    @Override
    public ClientHttpResponse fallbackResponse() {

            RequestContext context = RequestContext.getCurrentContext();
        String id = (String) context.get("serviceId");
        String uri = (String) context.get("requestURI");
        logger.warn("服务:"+id+" 熔断开关已开启，暂时拒绝转发路径为:"+uri+" 的请求!");

        return new ClientHttpResponse(){
            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers = new HttpHeaders();

                headers.add(GlobalConstant.CTX_RES_KEY_EXP_CODE, ERROR_CODE);
                headers.add(GlobalConstant.CTX_RES_KEY_EXP_TYPE, ERROR_EXP);
                try {
                    headers.add(GlobalConstant.CTX_RES_KEY_EXP_MSG, URLEncoder.encode(ERROR_MSG,"UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    logger.error("对错误信息进行url编码异常:",e);
                    headers.add(GlobalConstant.CTX_RES_KEY_EXP_MSG, "Service Temporarily Unavailable");
                }
                return headers;
            }

            @Override
            public InputStream getBody() throws IOException {
                return null;
                //return new ByteArrayInputStream(ERROR_MSG.getBytes("utf-8"));
            }

            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.SERVICE_UNAVAILABLE;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return HttpStatus.SERVICE_UNAVAILABLE.value();
            }

            @Override
            public String getStatusText() throws IOException {
                return HttpStatus.SERVICE_UNAVAILABLE.getReasonPhrase();
            }

            @Override
            public void close() {

            }
        };
    }
}
