package com.sinosoft.sso.api.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 
 * @description spring bean操作工具类，如果需要使用dubbo方式访问，需在spring中配置此bean
 * @author ZhangJiansen
 * @date 2016年9月30日下午5:40:45
 */
public class SpringContextUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext ;  //Spring应用上下文环境 
    
    public SpringContextUtil(){
        System.out.println("******SpringContextUtil init");
    }
    
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) 
		throws BeansException 
	{
	    System.out.println("******SpringContextUtil applicationContext");
		SpringContextUtil.applicationContext = applicationContext;

	}
	
	public static ApplicationContext getApplicationContext() {  
        return applicationContext;  
    }
	
	public static Object getBean(String name){
		return applicationContext.getBean(name);
	}
	
	public static Object getBean(Class<?> type){
		return applicationContext.getBean(type);
	}

}
