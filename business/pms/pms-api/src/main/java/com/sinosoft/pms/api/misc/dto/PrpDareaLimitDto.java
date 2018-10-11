package com.sinosoft.pms.api.misc.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-09-15 09:15:28.416 
 * 地区限额控制配置表Api操作对象
 */
public class PrpDareaLimitDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性产品代码/产品代码 */
	private String riskCode ;		
	/** 属性产品名称/产品名称 */
	private String riskName ;		
	/** 属性地区代码/地区代码 */
	private String areaCode ;		
	/** 属性地区名称/地区名称 */
	private String areaCName ;		
	/** 属性版次号/版次号 */
	private String versionNo ;		
	/** 属性销售限额/销售限额 */
	private java.lang.Double salesLimit ;		
	/** 属性生效日期/生效日期 */
	private java.util.Date effectDate ;		
	/** 属性失效日期/失效日期 */
	private java.util.Date invalidDate ;		
	/** 属性标志/标志 */
	private String flag ;		
	/** 属性备注/备注 */
	private String remark ;		
			
			
	/** 属性更新人/更新人 */
	private String upDatedBy ;		
	/** 属性更新时间/更新时间 */
	private java.util.Date upDatedTime ;		
	/**
	 * 属性产品代码/产品代码的getter方法
	 */
	public String getRiskCode() {
		return riskCode;
	}
	/**
	 * 属性产品代码/产品代码的setter方法
	 */
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}	
	/**
	 * 属性产品名称/产品名称的getter方法
	 */
	public String getRiskName() {
		return riskName;
	}
	/**
	 * 属性产品名称/产品名称的setter方法
	 */
	public void setRiskName(String riskName) {
		this.riskName = riskName;
	}	
	/**
	 * 属性地区代码/地区代码的getter方法
	 */
	public String getAreaCode() {
		return areaCode;
	}
	/**
	 * 属性地区代码/地区代码的setter方法
	 */
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}	
	/**
	 * 属性地区名称/地区名称的getter方法
	 */
	public String getAreaCName() {
		return areaCName;
	}
	/**
	 * 属性地区名称/地区名称的setter方法
	 */
	public void setAreaCName(String areaCName) {
		this.areaCName = areaCName;
	}	
	/**
	 * 属性版次号/版次号的getter方法
	 */
	public String getVersionNo() {
		return versionNo;
	}
	/**
	 * 属性版次号/版次号的setter方法
	 */
	public void setVersionNo(String versionNo) {
		this.versionNo = versionNo;
	}	
	/**
	 * 属性销售限额/销售限额的getter方法
	 */
	public java.lang.Double getSalesLimit() {
		return salesLimit;
	}
	/**
	 * 属性销售限额/销售限额的setter方法
	 */
	public void setSalesLimit(java.lang.Double salesLimit) {
		this.salesLimit = salesLimit;
	}	
	/**
	 * 属性生效日期/生效日期的getter方法
	 */
	public java.util.Date getEffectDate() {
		return effectDate;
	}
	/**
	 * 属性生效日期/生效日期的setter方法
	 */
	public void setEffectDate(java.util.Date effectDate) {
		this.effectDate = effectDate;
	}	
	/**
	 * 属性失效日期/失效日期的getter方法
	 */
	public java.util.Date getInvalidDate() {
		return invalidDate;
	}
	/**
	 * 属性失效日期/失效日期的setter方法
	 */
	public void setInvalidDate(java.util.Date invalidDate) {
		this.invalidDate = invalidDate;
	}	
	/**
	 * 属性标志/标志的getter方法
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * 属性标志/标志的setter方法
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}	
	/**
	 * 属性备注/备注的getter方法
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * 属性备注/备注的setter方法
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}	
		
		
	/**
	 * 属性更新人/更新人的getter方法
	 */
	public String getUpDatedBy() {
		return upDatedBy;
	}
	/**
	 * 属性更新人/更新人的setter方法
	 */
	public void setUpDatedBy(String upDatedBy) {
		this.upDatedBy = upDatedBy;
	}	
	/**
	 * 属性更新时间/更新时间的getter方法
	 */
	public java.util.Date getUpDatedTime() {
		return upDatedTime;
	}
	/**
	 * 属性更新时间/更新时间的setter方法
	 */
	public void setUpDatedTime(java.util.Date upDatedTime) {
		this.upDatedTime = upDatedTime;
	}	
}
