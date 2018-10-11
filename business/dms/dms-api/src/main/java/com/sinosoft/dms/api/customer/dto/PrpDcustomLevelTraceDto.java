package com.sinosoft.dms.api.customer.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail codegen@sinosoft.com.cn
 * @time  2017-10-21 02:23:45.341 
 * 客户风险等级轨迹表Api操作对象
 */
public class PrpDcustomLevelTraceDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性客户代码/客户代码 */
	private String customerCode ;		
	/** 属性序号/序号 */
	private Integer lineNo ;
	/** 属性变更后风险等级/变更后风险等级 */
	private String newRiskLevel ;		
	/** 属性变更前风险等级/变更前风险等级 */
	private String oldRiskLevel ;		
	/** 属性修改时间/修改时间 */
	private java.util.Date operateDate ;		
	/** 属性修改类型/修改类型 */
	private String operateType ;		
	/** 属性操作人员代码/操作人员代码 */
	private String operateCode ;		
	/** 属性审核人代码(默认为核保人)/审核人代码(默认为核保人) */
	private String reserved ;		
	/** 属性审核时间/审核时间 */
	private java.util.Date reservedDate ;		
	/**
	 * 属性客户代码/客户代码的getter方法
	 */
	public String getCustomerCode() {
		return customerCode;
	}
	/**
	 * 属性客户代码/客户代码的setter方法
	 */
	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}	
	/**
	 * 属性序号/序号的getter方法
	 */
	public Integer getLineNo() {
		return lineNo;
	}
	/**
	 * 属性序号/序号的setter方法
	 */
	public void setLineNo(Integer lineNo) {
		this.lineNo = lineNo;
	}	
	/**
	 * 属性变更后风险等级/变更后风险等级的getter方法
	 */
	public String getNewRiskLevel() {
		return newRiskLevel;
	}
	/**
	 * 属性变更后风险等级/变更后风险等级的setter方法
	 */
	public void setNewRiskLevel(String newRiskLevel) {
		this.newRiskLevel = newRiskLevel;
	}	
	/**
	 * 属性变更前风险等级/变更前风险等级的getter方法
	 */
	public String getOldRiskLevel() {
		return oldRiskLevel;
	}
	/**
	 * 属性变更前风险等级/变更前风险等级的setter方法
	 */
	public void setOldRiskLevel(String oldRiskLevel) {
		this.oldRiskLevel = oldRiskLevel;
	}	
	/**
	 * 属性修改时间/修改时间的getter方法
	 */
	public java.util.Date getOperateDate() {
		return operateDate;
	}
	/**
	 * 属性修改时间/修改时间的setter方法
	 */
	public void setOperateDate(java.util.Date operateDate) {
		this.operateDate = operateDate;
	}	
	/**
	 * 属性修改类型/修改类型的getter方法
	 */
	public String getOperateType() {
		return operateType;
	}
	/**
	 * 属性修改类型/修改类型的setter方法
	 */
	public void setOperateType(String operateType) {
		this.operateType = operateType;
	}	
	/**
	 * 属性操作人员代码/操作人员代码的getter方法
	 */
	public String getOperateCode() {
		return operateCode;
	}
	/**
	 * 属性操作人员代码/操作人员代码的setter方法
	 */
	public void setOperateCode(String operateCode) {
		this.operateCode = operateCode;
	}	
	/**
	 * 属性审核人代码(默认为核保人)/审核人代码(默认为核保人)的getter方法
	 */
	public String getReserved() {
		return reserved;
	}
	/**
	 * 属性审核人代码(默认为核保人)/审核人代码(默认为核保人)的setter方法
	 */
	public void setReserved(String reserved) {
		this.reserved = reserved;
	}	
	/**
	 * 属性审核时间/审核时间的getter方法
	 */
	public java.util.Date getReservedDate() {
		return reservedDate;
	}
	/**
	 * 属性审核时间/审核时间的setter方法
	 */
	public void setReservedDate(java.util.Date reservedDate) {
		this.reservedDate = reservedDate;
	}	
}
