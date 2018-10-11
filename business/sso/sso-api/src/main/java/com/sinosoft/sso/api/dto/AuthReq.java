package com.sinosoft.sso.api.dto;

/**
 * 
 * @description 权限校验请求参数
 * @author ZhangJiansen
 * @date 2016年9月30日下午4:44:52
 */
public class AuthReq {
	
    /** 用户登陆账户*/
	private String userCode;
	
	/** 登陆密码*/
	private String passWord;
	
	/** 登陆校验码*/
	private String verifyCode;

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getVerifyCode() {
		return verifyCode;
	}

	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}

}
