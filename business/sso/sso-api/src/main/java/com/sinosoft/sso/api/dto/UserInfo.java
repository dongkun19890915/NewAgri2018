package com.sinosoft.sso.api.dto;

import java.io.Serializable;

/**
 * 
 * @description 用户基础信息，用于在认证后返回给调用信息
 * @author zkr02
 * @date 2016年9月30日下午5:02:54
 */
public class UserInfo implements Serializable{

	private static final long serialVersionUID = 1L;

	/** 用户编码*/
	private String userCode;
	
	/** 用户姓名*/
	private String userName;
	
//	/** 归属机构*/
//	private String comCode;
	//归属   机构
	private String loginComCode;

	/** 属性出单机构代码/出单机构代码 */
	private String makeCom ;


	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

//	public String getComCode() {
//		return comCode;
//	}
//
//	public void setComCode(String comCode) {
//		this.comCode = comCode;
//	}


	public String getLoginComCode() {
		return loginComCode;
	}

	public void setLoginComCode(String loginComCode) {
		this.loginComCode = loginComCode;
	}

	public String getMakeCom() {
		return makeCom;
	}

	public void setMakeCom(String makeCom) {
		this.makeCom = makeCom;
	}
}
