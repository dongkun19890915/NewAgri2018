package com.sinosoft.sso.core.service.impl;

import java.util.*;

import com.sinosoft.sso.api.util.ConstantUtil;
import com.sinosoft.sso.core.service.AppManageService;
import jdk.nashorn.internal.objects.annotations.Property;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AppManageServiceImpl implements AppManageService{
	
	//用户保存需要单点登陆的系统地址，推送Cookie 或者 Session
    //private Map<String,String> ssoApps = new HashMap<String, String>();

    @Value("${ssoApps.url}")
    private String ssoApps;

    //此参数用于将单点登录地址传给调用方，主要用于dubbo服务
    private String ssoUrl;
    
    public void setSsoUrl(String ssoUrl)
    {
        this.ssoUrl = ssoUrl;
    }

    /*public void setSsoApps(Map<String, String> ssoApps) {
		this.ssoApps = ssoApps;
	}*/

	/**
     * 
     * @description 获取SSO管理的app的url地址
     * @return
     * @author ZhangJiansen
     * @date 2016年10月21日上午11:44:49
     */
    @Override
    public List<String> getAppsUrl()
    {
        List<String> urls = new ArrayList<String>();
        if(ssoApps != null) {
            StringTokenizer st = new StringTokenizer(ssoApps, ",");
            while(st.hasMoreTokens()) {
                urls.add(st.nextToken());
            }
        }
        /*Iterator<String> it = ssoApps.values().iterator();
        while(it.hasNext()){
            urls.add(it.next());
        }*/
        
        return urls;
    }


    /**
     * 
     * @description 获取SSO管理的app的url地址cookie回写地址
     * @param token
     * @return
     * @author ZhangJiansen
     * @date 2016年10月21日上午11:44:49
     */
    @Override
    public List<String> getAppsCallBackUrl(String token)
    {
        List<String> urls = new ArrayList<String>();
        if(ssoApps != null){
            StringTokenizer st = new StringTokenizer(ssoApps, ",");
            while(st.hasMoreTokens()){
                String url = st.nextToken();
                if(url.endsWith("/")){
                    url = url.substring(0, url.length()-1);
                }
                url = url+ConstantUtil.COOKIE_PATH+"?token="+token+"&jsonpCallback=?";
                urls.add(url);
            }
        }
        /*
        Iterator<String> it = ssoApps.values().iterator();
        while(it.hasNext()){
            String url = it.next();
            if(url.endsWith("/")){
                url = url.substring(0, url.length()-1);
            }
            url = url+ConstantUtil.COOKIE_PATH+"?token="+token+"&jsonpCallback=?";
            urls.add(url);
        }*/
        
        return urls;
    }


    /**
     * 
     * @description 获取SSO系统的访问地址
     * @return
     * @author ZhangJiansen
     * @date 2016年10月21日上午11:44:49
     */
    @Override
    public String getSSOUrl()
    {
        return ssoUrl;
    }
}
