package com.sinosoft.pms.api.kernel.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-09-15 09:19:57.041 
 * 限额\免陪额表Api操作对象
 */
public class PrpDlimitDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性限额\免赔代码/限额\免赔代码 */
	private String limitCode ;		
	/** 属性旧系统免陪代码/旧系统免陪代码 */
	private String oldLimitCode ;		
	/** 属性免赔/保险金额二级标志/免赔/保险金额二级标志 */
	private String limitFlagSecond ;		
	/** 属性限额\免赔中文名称/限额\免赔中文名称 */
	private String limitCName ;		
	/** 属性限额\免赔中文简称/限额\免赔中文简称 */
	private String limitSCName ;		
	/** 属性限额\免赔英文名称/限额\免赔英文名称 */
	private String limitEName ;		
	/** 属性限额\免赔英文简称/限额\免赔英文简称 */
	private String limitSName ;		
	/** 属性限额/免陪类型/限额/免陪类型 */
	private String limitType ;		
	/** 属性绝对免赔标志/绝对免赔标志 */
	private String absoluteLimitFlag ;		
	/** 属性优先级别/优先级别 */
	private String priority ;		
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
	/** 属性审核标志/审核标志 */
	private String auditFlag ;		
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
			
			
			
			
	/** 属性险种代码/险种代码 */
	private String riskCode ;		
	/** 属性限额/免赔优先级别/限额/免赔优先级别 */
	private String limitPriority ;		
	/** 属性险别代码/险别代码 */
	private String kindCode ;		
	/** 属性标的代码/标的代码 */
	private String itemCode ;		
	/** 属性投保方式/责任分类代码/投保方式/责任分类代码 */
	private String modeCode ;		
	/** 属性赔偿限额/赔偿限额 */
	private java.lang.Double limitFee ;		
	/** 属性限额之间关系/限额之间关系 */
	private String limitRelation ;		
	/** 属性限额之间关系说明/限额之间关系说明 */
	private String limitRelationDesc ;		
	/** 属性新的限额类别代码/新的限额类别代码 */
	private String newLimitCode ;		
	/** 属性限额类别/限额类别 */
	private String limitFlag ;		
	/**
	 * 属性限额\免赔代码/限额\免赔代码的getter方法
	 */
	public String getLimitCode() {
		return limitCode;
	}
	/**
	 * 属性限额\免赔代码/限额\免赔代码的setter方法
	 */
	public void setLimitCode(String limitCode) {
		this.limitCode = limitCode;
	}	
	/**
	 * 属性旧系统免陪代码/旧系统免陪代码的getter方法
	 */
	public String getOldLimitCode() {
		return oldLimitCode;
	}
	/**
	 * 属性旧系统免陪代码/旧系统免陪代码的setter方法
	 */
	public void setOldLimitCode(String oldLimitCode) {
		this.oldLimitCode = oldLimitCode;
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
	 * 属性限额\免赔中文名称/限额\免赔中文名称的getter方法
	 */
	public String getLimitCName() {
		return limitCName;
	}
	/**
	 * 属性限额\免赔中文名称/限额\免赔中文名称的setter方法
	 */
	public void setLimitCName(String limitCName) {
		this.limitCName = limitCName;
	}	
	/**
	 * 属性限额\免赔中文简称/限额\免赔中文简称的getter方法
	 */
	public String getLimitSCName() {
		return limitSCName;
	}
	/**
	 * 属性限额\免赔中文简称/限额\免赔中文简称的setter方法
	 */
	public void setLimitSCName(String limitSCName) {
		this.limitSCName = limitSCName;
	}	
	/**
	 * 属性限额\免赔英文名称/限额\免赔英文名称的getter方法
	 */
	public String getLimitEName() {
		return limitEName;
	}
	/**
	 * 属性限额\免赔英文名称/限额\免赔英文名称的setter方法
	 */
	public void setLimitEName(String limitEName) {
		this.limitEName = limitEName;
	}	
	/**
	 * 属性限额\免赔英文简称/限额\免赔英文简称的getter方法
	 */
	public String getLimitSName() {
		return limitSName;
	}
	/**
	 * 属性限额\免赔英文简称/限额\免赔英文简称的setter方法
	 */
	public void setLimitSName(String limitSName) {
		this.limitSName = limitSName;
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
	public String getPriority() {
		return priority;
	}
	/**
	 * 属性优先级别/优先级别的setter方法
	 */
	public void setPriority(String priority) {
		this.priority = priority;
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
	 * 属性限额/免赔优先级别/限额/免赔优先级别的getter方法
	 */
	public String getLimitPriority() {
		return limitPriority;
	}
	/**
	 * 属性限额/免赔优先级别/限额/免赔优先级别的setter方法
	 */
	public void setLimitPriority(String limitPriority) {
		this.limitPriority = limitPriority;
	}	
	/**
	 * 属性险别代码/险别代码的getter方法
	 */
	public String getKindCode() {
		return kindCode;
	}
	/**
	 * 属性险别代码/险别代码的setter方法
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
	 * 属性投保方式/责任分类代码/投保方式/责任分类代码的getter方法
	 */
	public String getModeCode() {
		return modeCode;
	}
	/**
	 * 属性投保方式/责任分类代码/投保方式/责任分类代码的setter方法
	 */
	public void setModeCode(String modeCode) {
		this.modeCode = modeCode;
	}	
	/**
	 * 属性赔偿限额/赔偿限额的getter方法
	 */
	public java.lang.Double getLimitFee() {
		return limitFee;
	}
	/**
	 * 属性赔偿限额/赔偿限额的setter方法
	 */
	public void setLimitFee(java.lang.Double limitFee) {
		this.limitFee = limitFee;
	}	
	/**
	 * 属性限额之间关系/限额之间关系的getter方法
	 */
	public String getLimitRelation() {
		return limitRelation;
	}
	/**
	 * 属性限额之间关系/限额之间关系的setter方法
	 */
	public void setLimitRelation(String limitRelation) {
		this.limitRelation = limitRelation;
	}	
	/**
	 * 属性限额之间关系说明/限额之间关系说明的getter方法
	 */
	public String getLimitRelationDesc() {
		return limitRelationDesc;
	}
	/**
	 * 属性限额之间关系说明/限额之间关系说明的setter方法
	 */
	public void setLimitRelationDesc(String limitRelationDesc) {
		this.limitRelationDesc = limitRelationDesc;
	}	
	/**
	 * 属性新的限额类别代码/新的限额类别代码的getter方法
	 */
	public String getNewLimitCode() {
		return newLimitCode;
	}
	/**
	 * 属性新的限额类别代码/新的限额类别代码的setter方法
	 */
	public void setNewLimitCode(String newLimitCode) {
		this.newLimitCode = newLimitCode;
	}	
	/**
	 * 属性限额类别/限额类别的getter方法
	 */
	public String getLimitFlag() {
		return limitFlag;
	}
	/**
	 * 属性限额类别/限额类别的setter方法
	 */
	public void setLimitFlag(String limitFlag) {
		this.limitFlag = limitFlag;
	}	
}
