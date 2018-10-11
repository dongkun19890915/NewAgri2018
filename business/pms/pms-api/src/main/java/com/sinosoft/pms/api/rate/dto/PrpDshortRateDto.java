package com.sinosoft.pms.api.rate.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-09-15 09:24:37.739 
 * 短期费率表Api操作对象
 */
public class PrpDshortRateDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性短期费率代码/短期费率代码 */
	private String shortRateId ;		
	/** 属性旧系统短期费率/旧系统短期费率 */
	private String oldShortRateId ;		
	/** 属性序号/序号 */
	private java.lang.Integer serialno ;		
	/** 属性短期费率名称/短期费率名称 */
	private String shortRateName ;		
	/** 属性短期费率类型/短期费率类型 */
	private String rateType ;		
	/** 属性下限计算符/下限计算符 */
	private String lowerOperator ;		
	/** 属性时间下限/时间下限 */
	private java.lang.Double lower ;		
	/** 属性上限计算符/上限计算符 */
	private String upperOperator ;		
	/** 属性时间上限/时间上限 */
	private java.lang.Double upper ;		
	/** 属性短期费率方式类型/短期费率方式类型 */
	private String modeType ;		
	/** 属性实际承保下限计算符/实际承保下限计算符 */
	private String actualLowerOperator ;		
	/** 属性实际承保时间下限/实际承保时间下限 */
	private java.lang.Double actualLower ;		
	/** 属性实际承保上限计算符/实际承保上限计算符 */
	private String actuaUpperOperator ;		
	/** 属性实际承保时间上限/实际承保时间上限 */
	private java.lang.Double actuaUpper ;		
	/** 属性短期费率分子/短期费率分子 */
	private java.lang.Double shortRateNumerator ;		
	/** 属性短期费率分母/短期费率分母 */
	private java.lang.Integer shortRateDenominator ;		
	/** 属性生效日期/生效日期 */
	private java.util.Date validDate ;		
	/** 属性失效日期/失效日期 */
	private java.util.Date invalidDate ;		
	/** 属性审核标志/审核标志 */
	private String auditFlag ;		
	/** 属性有效标志/有效标志 */
	private String validInd ;		
	/** 属性标志字段/标志字段 */
	private String flag ;		
	/** 属性备注/备注 */
	private String remark ;		
			
			
			
			
	/** 属性险种代码/险种代码 */
	private String riskCode ;		
	/** 属性月份数/月份数 */
	private java.lang.Integer months ;		
	/** 属性费率/费率 */
	private java.lang.Double shortRate ;		
	/** 属性状态/状态 */
	private String validStatus ;		
	/**
	 * 属性短期费率代码/短期费率代码的getter方法
	 */
	public String getShortRateId() {
		return shortRateId;
	}
	/**
	 * 属性短期费率代码/短期费率代码的setter方法
	 */
	public void setShortRateId(String shortRateId) {
		this.shortRateId = shortRateId;
	}	
	/**
	 * 属性旧系统短期费率/旧系统短期费率的getter方法
	 */
	public String getOldShortRateId() {
		return oldShortRateId;
	}
	/**
	 * 属性旧系统短期费率/旧系统短期费率的setter方法
	 */
	public void setOldShortRateId(String oldShortRateId) {
		this.oldShortRateId = oldShortRateId;
	}	
	/**
	 * 属性序号/序号的getter方法
	 */
	public java.lang.Integer getSerialno() {
		return serialno;
	}
	/**
	 * 属性序号/序号的setter方法
	 */
	public void setSerialno(java.lang.Integer serialno) {
		this.serialno = serialno;
	}	
	/**
	 * 属性短期费率名称/短期费率名称的getter方法
	 */
	public String getShortRateName() {
		return shortRateName;
	}
	/**
	 * 属性短期费率名称/短期费率名称的setter方法
	 */
	public void setShortRateName(String shortRateName) {
		this.shortRateName = shortRateName;
	}	
	/**
	 * 属性短期费率类型/短期费率类型的getter方法
	 */
	public String getRateType() {
		return rateType;
	}
	/**
	 * 属性短期费率类型/短期费率类型的setter方法
	 */
	public void setRateType(String rateType) {
		this.rateType = rateType;
	}	
	/**
	 * 属性下限计算符/下限计算符的getter方法
	 */
	public String getLowerOperator() {
		return lowerOperator;
	}
	/**
	 * 属性下限计算符/下限计算符的setter方法
	 */
	public void setLowerOperator(String lowerOperator) {
		this.lowerOperator = lowerOperator;
	}	
	/**
	 * 属性时间下限/时间下限的getter方法
	 */
	public java.lang.Double getLower() {
		return lower;
	}
	/**
	 * 属性时间下限/时间下限的setter方法
	 */
	public void setLower(java.lang.Double lower) {
		this.lower = lower;
	}	
	/**
	 * 属性上限计算符/上限计算符的getter方法
	 */
	public String getUpperOperator() {
		return upperOperator;
	}
	/**
	 * 属性上限计算符/上限计算符的setter方法
	 */
	public void setUpperOperator(String upperOperator) {
		this.upperOperator = upperOperator;
	}	
	/**
	 * 属性时间上限/时间上限的getter方法
	 */
	public java.lang.Double getUpper() {
		return upper;
	}
	/**
	 * 属性时间上限/时间上限的setter方法
	 */
	public void setUpper(java.lang.Double upper) {
		this.upper = upper;
	}	
	/**
	 * 属性短期费率方式类型/短期费率方式类型的getter方法
	 */
	public String getModeType() {
		return modeType;
	}
	/**
	 * 属性短期费率方式类型/短期费率方式类型的setter方法
	 */
	public void setModeType(String modeType) {
		this.modeType = modeType;
	}	
	/**
	 * 属性实际承保下限计算符/实际承保下限计算符的getter方法
	 */
	public String getActualLowerOperator() {
		return actualLowerOperator;
	}
	/**
	 * 属性实际承保下限计算符/实际承保下限计算符的setter方法
	 */
	public void setActualLowerOperator(String actualLowerOperator) {
		this.actualLowerOperator = actualLowerOperator;
	}	
	/**
	 * 属性实际承保时间下限/实际承保时间下限的getter方法
	 */
	public java.lang.Double getActualLower() {
		return actualLower;
	}
	/**
	 * 属性实际承保时间下限/实际承保时间下限的setter方法
	 */
	public void setActualLower(java.lang.Double actualLower) {
		this.actualLower = actualLower;
	}	
	/**
	 * 属性实际承保上限计算符/实际承保上限计算符的getter方法
	 */
	public String getActuaUpperOperator() {
		return actuaUpperOperator;
	}
	/**
	 * 属性实际承保上限计算符/实际承保上限计算符的setter方法
	 */
	public void setActuaUpperOperator(String actuaUpperOperator) {
		this.actuaUpperOperator = actuaUpperOperator;
	}	
	/**
	 * 属性实际承保时间上限/实际承保时间上限的getter方法
	 */
	public java.lang.Double getActuaUpper() {
		return actuaUpper;
	}
	/**
	 * 属性实际承保时间上限/实际承保时间上限的setter方法
	 */
	public void setActuaUpper(java.lang.Double actuaUpper) {
		this.actuaUpper = actuaUpper;
	}	
	/**
	 * 属性短期费率分子/短期费率分子的getter方法
	 */
	public java.lang.Double getShortRateNumerator() {
		return shortRateNumerator;
	}
	/**
	 * 属性短期费率分子/短期费率分子的setter方法
	 */
	public void setShortRateNumerator(java.lang.Double shortRateNumerator) {
		this.shortRateNumerator = shortRateNumerator;
	}	
	/**
	 * 属性短期费率分母/短期费率分母的getter方法
	 */
	public java.lang.Integer getShortRateDenominator() {
		return shortRateDenominator;
	}
	/**
	 * 属性短期费率分母/短期费率分母的setter方法
	 */
	public void setShortRateDenominator(java.lang.Integer shortRateDenominator) {
		this.shortRateDenominator = shortRateDenominator;
	}	
	/**
	 * 属性生效日期/生效日期的getter方法
	 */
	public java.util.Date getValidDate() {
		return validDate;
	}
	/**
	 * 属性生效日期/生效日期的setter方法
	 */
	public void setValidDate(java.util.Date validDate) {
		this.validDate = validDate;
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
	 * 属性审核标志/审核标志的getter方法
	 */
	public String getAuditFlag() {
		return auditFlag;
	}
	/**
	 * 属性审核标志/审核标志的setter方法
	 */
	public void setAuditFlag(String auditFlag) {
		this.auditFlag = auditFlag;
	}	
	/**
	 * 属性有效标志/有效标志的getter方法
	 */
	public String getValidInd() {
		return validInd;
	}
	/**
	 * 属性有效标志/有效标志的setter方法
	 */
	public void setValidInd(String validInd) {
		this.validInd = validInd;
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
	 * 属性月份数/月份数的getter方法
	 */
	public java.lang.Integer getMonths() {
		return months;
	}
	/**
	 * 属性月份数/月份数的setter方法
	 */
	public void setMonths(java.lang.Integer months) {
		this.months = months;
	}	
	/**
	 * 属性费率/费率的getter方法
	 */
	public java.lang.Double getShortRate() {
		return shortRate;
	}
	/**
	 * 属性费率/费率的setter方法
	 */
	public void setShortRate(java.lang.Double shortRate) {
		this.shortRate = shortRate;
	}	
	/**
	 * 属性状态/状态的getter方法
	 */
	public String getValidStatus() {
		return validStatus;
	}
	/**
	 * 属性状态/状态的setter方法
	 */
	public void setValidStatus(String validStatus) {
		this.validStatus = validStatus;
	}	
}
