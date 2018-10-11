package com.sinosoft.pms.core.kernel.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;

import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-04 10:42:46.546 
 * 人伤费用险种对照表实体操作对象
 */
@Entity
@Table(name = "PrpDpersonFeeCodeRisk")
@IdClass(PrpDpersonFeeCodeRiskKey.class)
public class PrpDpersonFeeCodeRisk extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性险种代码/险种代码 */
	@Id
	@Column(name = "riskCode")
	private String riskCode ;/** 属性费用代码/费用代码 */
	@Id
	@Column(name = "feeCode")
	private String feeCode ;	


	/** 属性M:医疗；D:死亡伤残/M:医疗；D:死亡伤残 */
	@Column(name = "feeCategory")
	private String feeCategory ;
	/** 属性强制保险优先级/强制保险优先级 */
	@Column(name = "priority")
	private java.lang.Integer priority ;
	/** 属性有效状态位/有效状态位 */
	@Column(name = "validStatus")
	private java.lang.Integer validStatus ;
	/** 属性有效日期/有效日期 */
	@Column(name = "validDate")
	private java.util.Date validDate ;
	/**
	 * 属性险种代码/险种代码的getter方法
	 */
	public String getRiskCode() {
		return riskCode;
	}
	/**
	 * 属性险种代码/险种代码的setter方法
	 */
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	} 	
	/**
	 * 属性费用代码/费用代码的getter方法
	 */
	public String getFeeCode() {
		return feeCode;
	}
	/**
	 * 属性费用代码/费用代码的setter方法
	 */
	public void setFeeCode(String feeCode) {
		this.feeCode = feeCode;
	} 	
	/**
	 * 属性M:医疗；D:死亡伤残/M:医疗；D:死亡伤残的getter方法
	 */
	public String getFeeCategory() {
		return feeCategory;
	}
	/**
	 * 属性M:医疗；D:死亡伤残/M:医疗；D:死亡伤残的setter方法
	 */
	public void setFeeCategory(String feeCategory) {
		this.feeCategory = feeCategory;
	} 	
	/**
	 * 属性强制保险优先级/强制保险优先级的getter方法
	 */
	public java.lang.Integer getPriority() {
		return priority;
	}
	/**
	 * 属性强制保险优先级/强制保险优先级的setter方法
	 */
	public void setPriority(java.lang.Integer priority) {
		this.priority = priority;
	} 	
	/**
	 * 属性有效状态位/有效状态位的getter方法
	 */
	public java.lang.Integer getValidStatus() {
		return validStatus;
	}
	/**
	 * 属性有效状态位/有效状态位的setter方法
	 */
	public void setValidStatus(java.lang.Integer validStatus) {
		this.validStatus = validStatus;
	} 	
	/**
	 * 属性有效日期/有效日期的getter方法
	 */
	public java.util.Date getValidDate() {
		return validDate;
	}
	/**
	 * 属性有效日期/有效日期的setter方法
	 */
	public void setValidDate(java.util.Date validDate) {
		this.validDate = validDate;
	} 	
}