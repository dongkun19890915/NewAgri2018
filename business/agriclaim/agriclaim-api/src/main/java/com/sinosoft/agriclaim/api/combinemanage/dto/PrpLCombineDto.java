package com.sinosoft.agriclaim.api.combinemanage.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-25 08:10:12.537 
 * 并案关联表Api操作对象
 */
public class PrpLCombineDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性报案号码/报案号码 */
	private String registNo ;		
	/** 属性保单号码/保单号码 */
	private String policyNo ;		
	/** 属性事故号码/事故号码 */
	private String combineNo ;		
	/** 属性修改人/修改人 */
	private String updateBy ;		
	/** 属性修改日期/修改日期 */
	private java.util.Date updateDate ;	
	/** 属性录单人员 */
	private String userCode ;
	/**
	 * 属性报案号码/报案号码的getter方法
	 */
	public String getRegistNo() {
		return registNo;
	}
	/**
	 * 属性报案号码/报案号码的setter方法
	 */
	public void setRegistNo(String registNo) {
		this.registNo = registNo;
	}	
	/**
	 * 属性保单号码/保单号码的getter方法
	 */
	public String getPolicyNo() {
		return policyNo;
	}
	/**
	 * 属性保单号码/保单号码的setter方法
	 */
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}	
	/**
	 * 属性事故号码/事故号码的getter方法
	 */
	public String getCombineNo() {
		return combineNo;
	}
	/**
	 * 属性事故号码/事故号码的setter方法
	 */
	public void setCombineNo(String combineNo) {
		this.combineNo = combineNo;
	}	
	/**
	 * 属性修改人/修改人的getter方法
	 */
	public String getUpdateBy() {
		return updateBy;
	}
	/**
	 * 属性修改人/修改人的setter方法
	 */
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}	
	/**
	 * 属性修改日期/修改日期的getter方法
	 */
	public java.util.Date getUpdateDate() {
		return updateDate;
	}
	/**
	 * 属性修改日期/修改日期的setter方法
	 */
	public void setUpdateDate(java.util.Date updateDate) {
		this.updateDate = updateDate;
	}	
	
	
	/**
	 *  录员 getter
	 */
	public String getUserCode() {
		return userCode;
	}
	/**
	 *  录员 setter
	 */
	public void setUserCode(String  userCode) {
		this.userCode = userCode;
	}	
	
	
}
