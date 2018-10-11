package com.sinosoft.sso.api.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @description 统一登陆交互返回值对象
 * @author ZhangJiansen
 * @date 2016年9月30日下午4:59:48
 */
public class AuthResp  implements Serializable{
	
	private static final long serialVersionUID = 1L;

	/** 返回状态码 200:成功,500:失败*/
	private String retCode;
	
	/** 返回信息*/
	private String retMsg;
	
	/** 登陆用户基本信息*/
	private UserInfo userInfo;
	
	/** 认证token*/
	private String token;
	
	/**下一步需要跳转的地址，用于导航到登陆、注销页面*/
	private String redirectUrl;
	
	/** 认证后需要更新登陆状态系统url列表*/
	private List<String> redirectURLs = new ArrayList<String>();

	public String getRetCode() {
		return retCode;
	}

	public void setRetCode(String retCode) {
		this.retCode = retCode;
	}

	public String getRetMsg() {
		return retMsg;
	}

	public void setRetMsg(String retMsg) {
		this.retMsg = retMsg;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public List<String> getRedirectURLs() {
		return redirectURLs;
	}

	public void setRedirectURLs(List<String> redirectURLs) {
		this.redirectURLs = redirectURLs;
	}

    public String getRedirectUrl()
    {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl)
    {
        this.redirectUrl = redirectUrl;
    }
	
}
