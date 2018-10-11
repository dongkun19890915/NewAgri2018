package com.sinosoft.sso.core.service.impl;

import com.sinosoft.sso.api.dto.AuthResp;
import com.sinosoft.sso.core.entity.TokenInfo;
import com.sinosoft.sso.core.service.AuthService;
import com.sinosoft.sso.core.service.TokenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AuthServiceImpl implements AuthService {
	
	private static final Logger logger = LoggerFactory.getLogger(AuthServiceImpl.class);

    private TokenService tokenService;
	
	public void setTokenService(TokenService tokenService) {
		this.tokenService = tokenService;
	}


	/**
     * 
     * @description token有效性校验
     * @param token
     * @param res
     * @author ZhangJiansen
     * @date 2016年9月30日下午4:37:38
     */
	@Override
	public AuthResp validToken(String token) {
		AuthResp resp = new AuthResp();
		if(token == null){
        	logger.debug("token参数为空，需要登录获取授权");
        	resp.setRetCode("204");
        	resp.setRetMsg("token参数为空");
        	return resp;
        }
        
        //token = token.replace(' ','+');
        
        TokenInfo info = tokenService.getToken(token);
        
        if(info == null){
        	logger.debug("token不存在，无效token或已失效");
        	resp.setRetCode("500");
        	resp.setRetMsg("token无效或已过期");
        	return resp;
        }
        
        //更新token，主要是重置过期时间
        tokenService.updateToken(info);
        
        logger.debug("有效的token");
        resp.setRetCode("200");
    	resp.setRetMsg("有效的token");
    	resp.setUserInfo(info.getUserInfo());
    	return resp;
	}

	 /**
     * @description 注销登陆接口
     * @param token
     * @return AuthResp
     * @author ZhangJiansen
     * @date 2016年9月30日下午4:35:28
     */
    @Override
    public AuthResp logout(String token)
    {
        AuthResp resp = new AuthResp();
        if(token == null){
            resp.setRetCode("400");
            resp.setRetMsg("token为空，注销失败");
            //resp.setRedirectUrl(redirectUrl);
            return resp;
        }
                
        TokenInfo info = tokenService.getToken(token);
        if(info == null){
            resp.setRetCode("204");
            resp.setRetMsg("此token已注销过");
            return resp;
        }
        
        tokenService.deleteToken(token);
        
        resp.setRetCode("200");
        resp.setRetMsg("注销成功");
        resp.setUserInfo(info.getUserInfo());
        
        return resp;
    }

}
