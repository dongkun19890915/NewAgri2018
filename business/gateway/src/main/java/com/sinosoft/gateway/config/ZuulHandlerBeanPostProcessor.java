package com.sinosoft.gateway.config;

import com.sinosoft.gateway.web.GlobalHandlerInterceptor;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;
import org.springframework.cloud.netflix.zuul.web.ZuulHandlerMapping;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Jason on 2017/8/16.
 */
@Configuration
public class ZuulHandlerBeanPostProcessor extends InstantiationAwareBeanPostProcessorAdapter {

    @Autowired
    private GlobalHandlerInterceptor handlerInterceptor;

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        if(bean instanceof ZuulHandlerMapping){
            ZuulHandlerMapping handlerMapping = (ZuulHandlerMapping) bean;
            handlerMapping.setInterceptors(handlerInterceptor);
        }

        return super.postProcessAfterInstantiation(bean, beanName);
    }
}
