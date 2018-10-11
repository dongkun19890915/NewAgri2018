package com.sinosoft.pms.api.kernel.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-09-15 09:19:57.041 
 * 条款限额免赔保额表Api操作对象
 */
public class PrpDclauseLimitDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性条款代码/条款代码 */
	private String clauseCode ;		
	/** 属性限额/免赔序号/限额/免赔序号 */
	private java.lang.Integer serialNo ;		
	/** 属性限额/免陪代码/限额/免陪代码 */
	private String limitCode ;		
	/** 属性限额/免赔名称/限额/免赔名称 */
	private String limitCName ;		
	/** 属性限额/免赔级别/限额/免赔级别 */
	private String limitLevel ;		
	/** 属性限额/免赔标志/限额/免赔标志 */
	private String limitFlag ;		
	/** 属性免赔/保险金额二级标志/免赔/保险金额二级标志 */
	private String limitFlagSecond ;		
	/** 属性限额/免陪类型/限额/免陪类型 */
	private String limitType ;		
	/** 属性绝对免赔标志/绝对免赔标志 */
	private String absoluteLimitFlag ;		
	/** 属性优先级别/优先级别 */
	private String priorIty ;		
	/** 属性责任代码/责任代码 */
	private String kindCode ;		
	/** 属性标的代码/标的代码 */
	private String itemCode ;		
	/** 属性承保是否必输/承保是否必输 */
	private String isRecorded ;		
	/** 属性限额数值/限额数值 */
	private java.lang.Double limitFee ;		
	/** 属性旧限额/免陪代码/旧限额/免陪代码 */
	private String oldLimitCode ;		
	/** 属性币别/币别 */
	private String currency ;		
	/** 属性上限计算符/上限计算符 */
	private String upperOperator ;		
	/** 属性时间下限/时间下限 */
	private java.lang.Double lower ;		
	/** 属性时间上限/时间上限 */
	private java.lang.Double upper ;		
	/** 属性下限计算符/下限计算符 */
	private String lowerOperator ;		
	/** 属性适用区域Y/适用区域Y */
	private String areaMappingCode ;		
	/** 属性适用区域层级/适用区域层级 */
	private String areaLevel ;		
	/** 属性适用区域代码/适用区域代码 */
	private String areaCode ;		
	/** 属性适用区域名称/适用区域名称 */
	private String areaName ;		
	/** 属性生效日期/生效日期 */
	private java.util.Date validDate ;		
	/** 属性失效日期/失效日期 */
	private java.util.Date invalidDate ;		
	/** 属性有效标志/有效标志 */
	private String validInd ;		
	/** 属性预留字段1/预留字段1 */
	private String tcol1 ;		
	/** 属性预留字段2/预留字段2 */
	private String tcol2 ;		
	/** 属性预留字段3/预留字段3 */
	private String tcol3 ;		
	/** 属性备注/备注 */
	private String remark ;		
	/** 属性标志字段/标志字段 */
	private String flag ;		
			
			
			
			
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
	 * 属性限额/免赔序号/限额/免赔序号的getter方法
	 */
	public java.lang.Integer getSerialNo() {
		return serialNo;
	}
	/**
	 * 属性限额/免赔序号/限额/免赔序号的setter方法
	 */
	public void setSerialNo(java.lang.Integer serialNo) {
		this.serialNo = serialNo;
	}	
	/**
	 * 属性限额/免陪代码/限额/免陪代码的getter方法
	 */
	public String getLimitCode() {
		return limitCode;
	}
	/**
	 * 属性限额/免陪代码/限额/免陪代码的setter方法
	 */
	public void setLimitCode(String limitCode) {
		this.limitCode = limitCode;
	}	
	/**
	 * 属性限额/免赔名称/限额/免赔名称的getter方法
	 */
	public String getLimitCName() {
		return limitCName;
	}
	/**
	 * 属性限额/免赔名称/限额/免赔名称的setter方法
	 */
	public void setLimitCName(String limitCName) {
		this.limitCName = limitCName;
	}	
	/**
	 * 属性限额/免赔级别/限额/免赔级别的getter方法
	 */
	public String getLimitLevel() {
		return limitLevel;
	}
	/**
	 * 属性限额/免赔级别/限额/免赔级别的setter方法
	 */
	public void setLimitLevel(String limitLevel) {
		this.limitLevel = limitLevel;
	}	
	/**
	 * 属性限额/免赔标志/限额/免赔标志的getter方法
	 */
	public String getLimitFlag() {
		return limitFlag;
	}
	/**
	 * 属性限额/免赔标志/限额/免赔标志的setter方法
	 */
	public void setLimitFlag(String limitFlag) {
		this.limitFlag = limitFlag;
	}	
	/**
	 * 属性免赔/保险金额二级标志/免赔/保险金额二级标志的getter方法
	 */
	public String getLimitFlagSecond() {
		return limitFlagSecond;
	}
	/**
	 * 属性免赔/保险金额二级标志/免赔/保险金额二级标志的setter方法
	 */
	public void setLimitFlagSecond(String limitFlagSecond) {
		this.limitFlagSecond = limitFlagSecond;
	}	
	/**
	 * 属性限额/免陪类型/限额/免陪类型的getter方法
	 */
	public String getLimitType() {
		return limitType;
	}
	/**
	 * 属性限额/免陪类型/限额/免陪类型的setter方法
	 */
	public void setLimitType(String limitType) {
		this.limitType = limitType;
	}	
	/**
	 * 属性绝对免赔标志/绝对免赔标志的getter方法
	 */
	public String getAbsoluteLimitFlag() {
		return absoluteLimitFlag;
	}
	/**
	 * 属性绝对免赔标志/绝对免赔标志的setter方法
	 */
	public void setAbsoluteLimitFlag(String absoluteLimitFlag) {
		this.absoluteLimitFlag = absoluteLimitFlag;
	}	
	/**
	 * 属性优先级别/优先级别的getter方法
	 */
	public String getPriorIty() {
		return priorIty;
	}
	/**
	 * 属性优先级别/优先级别的setter方法
	 */
	public void setPriorIty(String priorIty) {
		this.priorIty = priorIty;
	}	
	/**
	 * 属性责任代码/责任代码的getter方法
	 */
	public String getKindCode() {
		return kindCode;
	}
	/**
	 * 属性责任代码/责任代码的setter方法
	 */
	public void setKindCode(String kindCode) {
		this.kindCode = kindCode;
	}	
	/**
	 * 属性标的代码/标的代码的getter方法
	 */
	public String getItemCode() {
		return itemCode;
	}
	/**
	 * 属性标的代码/标的代码的setter方法
	 */
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}	
	/**
	 * 属性承保是否必输/承保是否必输的getter方法
	 */
	public String getIsRecorded() {
		return isRecorded;
	}
	/**
	 * 属性承保是否必输/承保是否必输的setter方法
	 */
	public void setIsRecorded(String isRecorded) {
		this.isRecorded = isRecorded;
	}	
	/**
	 * 属性限额数值/限额数值的getter方法
	 */
	public java.lang.Double getLimitFee() {
		return limitFee;
	}
	/**
	 * 属性限额数值/限额数值的setter方法
	 */
	public void setLimitFee(java.lang.Double limitFee) {
		this.limitFee = limitFee;
	}	
	/**
	 * 属性旧限额/免陪代码/旧限额/免陪代码的getter方法
	 */
	public String getOldLimitCode() {
		return oldLimitCode;
	}
	/**
	 * 属性旧限额/免陪代码/旧限额/免陪代码的setter方法
	 */
	public void setOldLimitCode(String oldLimitCode) {
		this.oldLimitCode = oldLimitCode;
	}	
	/**
	 * 属性币别/币别的getter方法
	 */
	public String getCurrency() {
		return currency;
	}
	/**
	 * 属性币别/币别的setter方法
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
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
	 * 属性适用区域Y/适用区域Y的getter方法
	 */
	public String getAreaMappingCode() {
		return areaMappingCode;
	}
	/**
	 * 属性适用区域Y/适用区域Y的setter方法
	 */
	public void setAreaMappingCode(String areaMappingCode) {
		this.areaMappingCode = areaMappingCode;
	}	
	/**
	 * 属性适用区域层级/适用区域层级的getter方法
	 */
	public String getAreaLevel() {
		return areaLevel;
	}
	/**
	 * 属性适用区域层级/适用区域层级的setter方法
	 */
	public void setAreaLevel(String areaLevel) {
		this.areaLevel = areaLevel;
	}	
	/**
	 * 属性适用区域代码/适用区域代码的getter方法
	 */
	public String getAreaCode() {
		return areaCode;
	}
	/**
	 * 属性适用区域代码/适用区域代码的setter方法
	 */
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}	
	/**
	 * 属性适用区域名称/适用区域名称的getter方法
	 */
	public String getAreaName() {
		return areaName;
	}
	/**
	 * 属性适用区域名称/适用区域名称的setter方法
	 */
	public void setAreaName(String areaName) {
		this.areaName = areaName;
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
	 * 属性预留字段1/预留字段1的getter方法
	 */
	public String getTcol1() {
		return tcol1;
	}
	/**
	 * 属性预留字段1/预留字段1的setter方法
	 */
	public void setTcol1(String tcol1) {
		this.tcol1 = tcol1;
	}	
	/**
	 * 属性预留字段2/预留字段2的getter方法
	 */
	public String getTcol2() {
		return tcol2;
	}
	/**
	 * 属性预留字段2/预留字段2的setter方法
	 */
	public void setTcol2(String tcol2) {
		this.tcol2 = tcol2;
	}	
	/**
	 * 属性预留字段3/预留字段3的getter方法
	 */
	public String getTcol3() {
		return tcol3;
	}
	/**
	 * 属性预留字段3/预留字段3的setter方法
	 */
	public void setTcol3(String tcol3) {
		this.tcol3 = tcol3;
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
		
		
		
		
}
