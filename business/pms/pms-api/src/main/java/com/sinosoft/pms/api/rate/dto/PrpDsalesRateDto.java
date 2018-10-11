package com.sinosoft.pms.api.rate.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-09-15 09:24:37.739 
 * 销售费用率配置表Api操作对象
 */
public class PrpDsalesRateDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性产品代码/产品代码 */
	private String riskCode ;		
	/** 属性产品名称/产品名称 */
	private String riskName ;		
	/** 属性业务来源/业务来源 */
	private String businessNature ;		
	/** 属性版次号/版次号 */
	private String versionNo ;		
	/** 属性销售费用率/销售费用率 */
	private java.lang.Double saleSRate ;		
	/** 属性生效日期/生效日期 */
	private java.util.Date effectDate ;		
	/** 属性失效日期/失效日期 */
	private java.util.Date invalidDate ;		
	/** 属性标志/标志 */
	private String flag ;		
	/** 属性备注/备注 */
	private String remark ;		
			
			
			
			
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
	 * 属性业务来源/业务来源的getter方法
	 */
	public String getBusinessNature() {
		return businessNature;
	}
	/**
	 * 属性业务来源/业务来源的setter方法
	 */
	public void setBusinessNature(String businessNature) {
		this.businessNature = businessNature;
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
	 * 属性销售费用率/销售费用率的getter方法
	 */
	public java.lang.Double getSaleSRate() {
		return saleSRate;
	}
	/**
	 * 属性销售费用率/销售费用率的setter方法
	 */
	public void setSaleSRate(java.lang.Double saleSRate) {
		this.saleSRate = saleSRate;
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
		
		
		
		
}
