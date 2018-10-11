package com.sinosoft.ims.api.auth.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:10:45.148 
 * UtiSolvencyApi操作对象
 */
public class UtiSolvencyDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性userCode/userCode */
	private String userCode ;		
	/** 属性modifyContent/modifyContent */
	private String modifyContent ;		
	/** 属性updateDate/updateDate */
	private java.util.Date updateDate ;		
	/** 属性id/id */
	private java.util.Date id ;		
	/**
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
	 * 属性modifyContent/modifyContent的getter方法
	 */
	public String getModifyContent() {
		return modifyContent;
	}
	/**
	 * 属性modifyContent/modifyContent的setter方法
	 */
	public void setModifyContent(String modifyContent) {
		this.modifyContent = modifyContent;
	}	
	/**
	 * 属性updateDate/updateDate的getter方法
	 */
	public java.util.Date getUpdateDate() {
		return updateDate;
	}
	/**
	 * 属性updateDate/updateDate的setter方法
	 */
	public void setUpdateDate(java.util.Date updateDate) {
		this.updateDate = updateDate;
	}	
	/**
	 * 属性id/id的getter方法
	 */
	public java.util.Date getId() {
		return id;
	}
	/**
	 * 属性id/id的setter方法
	 */
	public void setId(java.util.Date id) {
		this.id = id;
	}	
}
