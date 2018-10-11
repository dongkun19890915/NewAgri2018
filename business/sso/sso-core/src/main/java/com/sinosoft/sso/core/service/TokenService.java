package com.sinosoft.sso.core.service;

import com.sinosoft.sso.core.entity.TokenInfo;

/**
 * 
 * @description token实体信息操作类
 * @author ZhangJiansen
 * @date 2016年9月30日下午5:40:01
 */
public interface TokenService {

	void saveToken(TokenInfo info);
	
	TokenInfo getToken(String token);
	
	void deleteToken(String token);
	
	void updateToken(TokenInfo info);

	boolean expireToken(String token);
}
