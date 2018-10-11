package com.sinosoft.pms.api.kernel.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-09-15 09:19:57.041 
 * 产品特别约定表Api操作对象
 */
public class PrpDriskEngageDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性产品代码/产品代码 */
	private String riskCode ;		
	/** 属性条款代码/条款代码 */
	private String clauseCode ;		
	/** 属性特别约定代码/特别约定代码 */
	private String engageCode ;		
	/** 属性旧特约代码/旧特约代码 */
	private String oldEngageCode ;		
	/** 属性特别约定中文名称/特别约定中文名称 */
	private String engageCName ;		
	/** 属性特别约定英文名称/特别约定英文名称 */
	private String engageEName ;		
	/** 属性语种标识/语种标识 */
	private String language ;		
	/** 属性特别约定描述/特别约定描述 */
	private String engageDesc ;		
	/** 属性承保是否可改/承保是否可改 */
	private String changeAble ;		
	/** 属性承保自动带出标识/承保自动带出标识 */
	private String autoFlag ;		
	/** 属性特别约定层级/特别约定层级 */
	private String engageLevel ;		
	/** 属性适用区域主键/适用区域主键 */
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
	 * 属性特别约定代码/特别约定代码的getter方法
	 */
	public String getEngageCode() {
		return engageCode;
	}
	/**
	 * 属性特别约定代码/特别约定代码的setter方法
	 */
	public void setEngageCode(String engageCode) {
		this.engageCode = engageCode;
	}	
	/**
	 * 属性旧特约代码/旧特约代码的getter方法
	 */
	public String getOldEngageCode() {
		return oldEngageCode;
	}
	/**
	 * 属性旧特约代码/旧特约代码的setter方法
	 */
	public void setOldEngageCode(String oldEngageCode) {
		this.oldEngageCode = oldEngageCode;
	}	
	/**
	 * 属性特别约定中文名称/特别约定中文名称的getter方法
	 */
	public String getEngageCName() {
		return engageCName;
	}
	/**
	 * 属性特别约定中文名称/特别约定中文名称的setter方法
	 */
	public void setEngageCName(String engageCName) {
		this.engageCName = engageCName;
	}	
	/**
	 * 属性特别约定英文名称/特别约定英文名称的getter方法
	 */
	public String getEngageEName() {
		return engageEName;
	}
	/**
	 * 属性特别约定英文名称/特别约定英文名称的setter方法
	 */
	public void setEngageEName(String engageEName) {
		this.engageEName = engageEName;
	}	
	/**
	 * 属性语种标识/语种标识的getter方法
	 */
	public String getLanguage() {
		return language;
	}
	/**
	 * 属性语种标识/语种标识的setter方法
	 */
	public void setLanguage(String language) {
		this.language = language;
	}	
	/**
	 * 属性特别约定描述/特别约定描述的getter方法
	 */
	public String getEngageDesc() {
		return engageDesc;
	}
	/**
	 * 属性特别约定描述/特别约定描述的setter方法
	 */
	public void setEngageDesc(String engageDesc) {
		this.engageDesc = engageDesc;
	}	
	/**
	 * 属性承保是否可改/承保是否可改的getter方法
	 */
	public String getChangeAble() {
		return changeAble;
	}
	/**
	 * 属性承保是否可改/承保是否可改的setter方法
	 */
	public void setChangeAble(String changeAble) {
		this.changeAble = changeAble;
	}	
	/**
	 * 属性承保自动带出标识/承保自动带出标识的getter方法
	 */
	public String getAutoFlag() {
		return autoFlag;
	}
	/**
	 * 属性承保自动带出标识/承保自动带出标识的setter方法
	 */
	public void setAutoFlag(String autoFlag) {
		this.autoFlag = autoFlag;
	}	
	/**
	 * 属性特别约定层级/特别约定层级的getter方法
	 */
	public String getEngageLevel() {
		return engageLevel;
	}
	/**
	 * 属性特别约定层级/特别约定层级的setter方法
	 */
	public void setEngageLevel(String engageLevel) {
		this.engageLevel = engageLevel;
	}	
	/**
	 * 属性适用区域主键/适用区域主键的getter方法
	 */
	public String getAreaMappingCode() {
		return areaMappingCode;
	}
	/**
	 * 属性适用区域主键/适用区域主键的setter方法
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
