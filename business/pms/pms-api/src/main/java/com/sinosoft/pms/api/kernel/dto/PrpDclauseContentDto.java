package com.sinosoft.pms.api.kernel.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-09-15 09:19:57.041 
 * 条款文档表Api操作对象
 */
public class PrpDclauseContentDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性条款代码/条款代码 */
	private String clauseCode ;		
	/** 属性单证要素代码/单证要素代码 */
	private java.lang.Integer serialNo ;		
	/** 属性存储地址/存储地址 */
	private String url ;		
			
			
			
			
	/**
	 * 属性条款代码/条款代码的getter方法
	 */
	public String getClauseCode() {
		return clauseCode;
	}
	/**
	 * 属性条款代码/条款代码的setter方法
	 */
	public void setClauseCode(String clauseCode) {
		this.clauseCode = clauseCode;
	}	
	/**
	 * 属性单证要素代码/单证要素代码的getter方法
	 */
	public java.lang.Integer getSerialNo() {
		return serialNo;
	}
	/**
	 * 属性单证要素代码/单证要素代码的setter方法
	 */
	public void setSerialNo(java.lang.Integer serialNo) {
		this.serialNo = serialNo;
	}	
	/**
	 * 属性存储地址/存储地址的getter方法
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * 属性存储地址/存储地址的setter方法
	 */
	public void setUrl(String url) {
		this.url = url;
	}	
		
		
		
		
}
