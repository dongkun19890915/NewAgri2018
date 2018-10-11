package com.sinosoft.gateway.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.*;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jason on 2017/8/18.
 * !!未被使用
 */
public class FallbackProviderCreator implements ApplicationContextAware,ApplicationListener {

    private static final Logger logger = LoggerFactory.getLogger(FallbackProviderCreator.class);

    private ConfigurableApplicationContext applicationContext;

    private ZuulProperties zuulProperties;

    public FallbackProviderCreator(ZuulProperties zuulProperties){
        this.zuulProperties = zuulProperties;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = (ConfigurableApplicationContext) applicationContext;
    }

    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        if (applicationEvent instanceof ContextRefreshedEvent) {
            logger.info("begin to create fallbackprovider for every service...");
            Map<String,String> serviceProviders = parseZuulProperties(this.zuulProperties);
            createProvider(serviceProviders);
        }
    }

    private void createProvider(Map<String,String> serviceProviders){
        DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) applicationContext.getAutowireCapableBeanFactory();

        if(serviceProviders == null){
            logger.info("no service router definition found");
            return;
        }
        for(String serviceId :serviceProviders.keySet()) {
            String path = serviceProviders.get(serviceId);
            logger.info("begin create fallback provider for service:{}, and path is {}",serviceId,path);

            BeanDefinitionBuilder bdb = BeanDefinitionBuilder.rootBeanDefinition(GeneralFallbackProvider.class);
            String beanKey = serviceId+"FallbackProvider";
            bdb.getBeanDefinition().setAttribute("id", beanKey);
            bdb.addPropertyValue("serviceId", serviceId);
            bdb.addPropertyValue("servicePath", path);
            beanFactory.registerBeanDefinition(beanKey, bdb.getBeanDefinition());
        }

    }

    private Map<String,String> parseZuulProperties(ZuulProperties properties){
        Map<String,String> serviceProviders = new HashMap<String,String>();
        for(ZuulProperties.ZuulRoute route :properties.getRoutes().values()){
            String serviceId = route.getServiceId();
            String path = route.getPath();
            if(StringUtils.isEmpty(serviceId)){
                continue;
            }
            serviceProviders.put(serviceId,path);
        }

        return serviceProviders;
    }
}
