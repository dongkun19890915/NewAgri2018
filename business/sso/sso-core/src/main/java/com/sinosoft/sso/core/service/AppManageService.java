package com.sinosoft.sso.core.service;

import java.util.List;

/**
 * 
 * @description sso统一管理应用信息操作类
 * @author ZhangJiansen
 * @date 2016年9月30日下午5:38:42
 */
public interface AppManageService {

	List<String> getAppsUrl();
	
	List<String> getAppsCallBackUrl(String token);
	
	String getSSOUrl();
}
