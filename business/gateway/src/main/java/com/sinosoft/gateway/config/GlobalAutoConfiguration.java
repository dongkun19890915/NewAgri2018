package com.sinosoft.gateway.config;

import com.sinosoft.gateway.web.FallbackProviderCreator;
import com.sinosoft.gateway.web.GeneralFallbackProvider;
import com.sinosoft.gateway.web.GlobalErrorController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.cloud.netflix.zuul.filters.route.ZuulFallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Jason on 2017/7/18.
 * 全局异常自定义处理
 */
@Configuration
public class GlobalAutoConfiguration {

    @Autowired
    private ZuulProperties zuulProperties;

    @Bean
    public GlobalErrorController globalErrorController() {
        return new GlobalErrorController();
    }

    @Bean("globalFallbackProvider")
    public ZuulFallbackProvider globalFallbackProvider(){
        GeneralFallbackProvider provider = new GeneralFallbackProvider();
        provider.setServiceId("*");

        return provider;
    }

    /*@Bean
    public FallbackProviderCreator fallbackProviderCreator(){
        return new FallbackProviderCreator(zuulProperties);
    }*/
}
