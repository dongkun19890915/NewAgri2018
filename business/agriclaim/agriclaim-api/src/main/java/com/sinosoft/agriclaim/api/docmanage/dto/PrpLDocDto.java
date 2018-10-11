package com.sinosoft.agriclaim.api.docmanage.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:41:23.407 
 * 索赔单证信息表Api操作对象
 */
public class PrpLDocDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性立案号码/立案号码 */
	private String claimNo ;		
	/** 属性单证代码/单证代码 */
	private String docCode ;		
	/** 属性单证名称/单证名称 */
	private String docName ;		
	/** 属性单证份数/单证份数 */
	private java.lang.Double docCount ;		
	/** 属性签收日期/签收日期 */
	private java.util.Date signinDate ;		
	/** 属性标志字段 [1] 单证扫描情况 0:未扫描，1：已扫描/标志字段 [1] 单证扫描情况 0:未扫描，1：已扫描 */
	private String flag ;		
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
	/**
	 * 属性单证代码/单证代码的getter方法
	 */
	public String getDocCode() {
		return docCode;
	}
	/**
	 * 属性单证代码/单证代码的setter方法
	 */
	public void setDocCode(String docCode) {
		this.docCode = docCode;
	}	
	/**
	 * 属性单证名称/单证名称的getter方法
	 */
	public String getDocName() {
		return docName;
	}
	/**
	 * 属性单证名称/单证名称的setter方法
	 */
	public void setDocName(String docName) {
		this.docName = docName;
	}	
	/**
	 * 属性单证份数/单证份数的getter方法
	 */
	public java.lang.Double getDocCount() {
		return docCount;
	}
	/**
	 * 属性单证份数/单证份数的setter方法
	 */
	public void setDocCount(java.lang.Double docCount) {
		this.docCount = docCount;
	}	
	/**
	 * 属性签收日期/签收日期的getter方法
	 */
	public java.util.Date getSigninDate() {
		return signinDate;
	}
	/**
	 * 属性签收日期/签收日期的setter方法
	 */
	public void setSigninDate(java.util.Date signinDate) {
		this.signinDate = signinDate;
	}	
	/**
	 * 属性标志字段 [1] 单证扫描情况 0:未扫描，1：已扫描/标志字段 [1] 单证扫描情况 0:未扫描，1：已扫描的getter方法
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * 属性标志字段 [1] 单证扫描情况 0:未扫描，1：已扫描/标志字段 [1] 单证扫描情况 0:未扫描，1：已扫描的setter方法
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}	
}
