package com.sinosoft.sso.core.service;

import com.sinosoft.sso.api.dto.AuthResp;

/**
 * 
 * @description 权限验证
 * @author ZhangJiansen
 * @date 2016年9月30日下午5:39:30
 */
public interface AuthService {

	AuthResp validToken(String token);
	
	AuthResp logout(String token);
}
