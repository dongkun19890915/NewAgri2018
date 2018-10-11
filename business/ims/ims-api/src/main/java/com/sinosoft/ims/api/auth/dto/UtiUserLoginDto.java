package com.sinosoft.ims.api.auth.dto;

import java.io.Serializable;
import java.util.Date;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:11:08.689 
 * UtiUserLoginApi操作对象
 */
public class UtiUserLoginDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性userCode/userCode */
	private String userCode ;		
	/** 属性lastSuccessLoginTime/lastSuccessLoginTime */
	private String lastSuccessLoginTime ;		
	/** 属性lastFailLoginTime/lastFailLoginTime */
	private String lastFailLoginTime ;		
	/** 属性failLoginCount/failLoginCount */
	private String failLoginCount ;		
	/** 属性locktoTime/locktoTime */
	private String lockToTime ;


	/*
	 * 属性userCode/userCode的getter方法
	 */
	public String getUserCode() {
		return userCode;
	}
	/**
	 * 属性userCode/userCode的setter方法
	 */
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}	
	/**
	 * 属性lastSuccessLoginTime/lastSuccessLoginTime的getter方法
	 */
	public String getLastSuccessLoginTime() {
		return lastSuccessLoginTime;
	}
	/**
	 * 属性lastSuccessLoginTime/lastSuccessLoginTime的setter方法
	 */
	public void setLastSuccessLoginTime(String lastSuccessLoginTime) {
		this.lastSuccessLoginTime = lastSuccessLoginTime;
	}	
	/**
	 * 属性lastFailLoginTime/lastFailLoginTime的getter方法
	 */
	public String getLastFailLoginTime() {
		return lastFailLoginTime;
	}
	/**
	 * 属性lastFailLoginTime/lastFailLoginTime的setter方法
	 */
	public void setLastFailLoginTime(String lastFailLoginTime) {
		this.lastFailLoginTime = lastFailLoginTime;
	}	
	/**
	 * 属性failLoginCount/failLoginCount的getter方法
	 */
	public String getFailLoginCount() {
		return failLoginCount;
	}
	/**
	 * 属性failLoginCount/failLoginCount的setter方法
	 */
	public void setFailLoginCount(String failLoginCount) {
		this.failLoginCount = failLoginCount;
	}	
	/**
	 * 属性locktoTime/locktoTime的getter方法
	 */
	public String getLockToTime() {
		return lockToTime;
	}
	/**
	 * 属性locktoTime/locktoTime的setter方法
	 */
	public void setLockToTime(String lockToTime) {
		this.lockToTime = lockToTime;
	}	
}
