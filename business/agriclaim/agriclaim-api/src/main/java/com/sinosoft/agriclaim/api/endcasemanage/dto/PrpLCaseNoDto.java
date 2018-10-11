package com.sinosoft.agriclaim.api.endcasemanage.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:42:04.174 
 * 赔案号表Api操作对象
 */
public class PrpLCaseNoDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性单证号/单证号 */
	private String certiNo ;		
	/** 属性单证类型/单证类型 */
	private String certiType ;		
	/** 属性结案号/结案号 */
	private String caseNo ;		
	/** 属性标志字段/标志字段 */
	private String flag ;		
	/** 属性立案号码/立案号码 */
	private String claimNo ;		
	/**
	 * 属性单证号/单证号的getter方法
	 */
	public String getCertiNo() {
		return certiNo;
	}
	/**
	 * 属性单证号/单证号的setter方法
	 */
	public void setCertiNo(String certiNo) {
		this.certiNo = certiNo;
	}	
	/**
	 * 属性单证类型/单证类型的getter方法
	 */
	public String getCertiType() {
		return certiType;
	}
	/**
	 * 属性单证类型/单证类型的setter方法
	 */
	public void setCertiType(String certiType) {
		this.certiType = certiType;
	}	
	/**
	 * 属性结案号/结案号的getter方法
	 */
	public String getCaseNo() {
		return caseNo;
	}
	/**
	 * 属性结案号/结案号的setter方法
	 */
	public void setCaseNo(String caseNo) {
		this.caseNo = caseNo;
	}	
	/**
	 * 属性标志字段/标志字段的getter方法
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * 属性标志字段/标志字段的setter方法
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}	
	/**
	 * 属性立案号码/立案号码的getter方法
	 */
	public String getClaimNo() {
		return claimNo;
	}
	/**
	 * 属性立案号码/立案号码的setter方法
	 */
	public void setClaimNo(String claimNo) {
		this.claimNo = claimNo;
	}	
}
