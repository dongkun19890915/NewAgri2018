package com.sinosoft.pms.api.rate.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-09-15 09:24:37.739 
 * 条款责任费率下限表Api操作对象
 */
public class PrpDckRateLowerDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性费率下限代码/费率下限代码 */
	private java.lang.Integer rateLowerId ;		
	/** 属性条款责任序号/条款责任序号 */
	private java.lang.Integer clauseKindId ;		
	/** 属性条款代码/条款代码 */
	private String clauseCode ;		
	/** 属性责任代码/责任代码 */
	private String kindCode ;		
	/** 属性下限计算符/下限计算符 */
	private String lowerOperator ;		
	/** 属性下限/下限 */
	private java.lang.Double lower ;		
	/** 属性适用区域层级/适用区域层级 */
	private String areaLevel ;		
	/** 属性适用区域代码/适用区域代码 */
	private String areaCode ;		
	/** 属性适用区域名称/适用区域名称 */
	private String areaName ;		
	/** 属性预留字段1/预留字段1 */
	private String tcol1 ;		
	/** 属性预留字段2/预留字段2 */
	private String tcol2 ;		
	/** 属性预留字段3/预留字段3 */
	private String tcol3 ;		
	/** 属性备注/备注 */
	private String remark ;		
			
			
			
			
	/**
	 * 属性费率下限代码/费率下限代码的getter方法
	 */
	public java.lang.Integer getRateLowerId() {
		return rateLowerId;
	}
	/**
	 * 属性费率下限代码/费率下限代码的setter方法
	 */
	public void setRateLowerId(java.lang.Integer rateLowerId) {
		this.rateLowerId = rateLowerId;
	}	
	/**
	 * 属性条款责任序号/条款责任序号的getter方法
	 */
	public java.lang.Integer getClauseKindId() {
		return clauseKindId;
	}
	/**
	 * 属性条款责任序号/条款责任序号的setter方法
	 */
	public void setClauseKindId(java.lang.Integer clauseKindId) {
		this.clauseKindId = clauseKindId;
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
	 * 属性下限/下限的getter方法
	 */
	public java.lang.Double getLower() {
		return lower;
	}
	/**
	 * 属性下限/下限的setter方法
	 */
	public void setLower(java.lang.Double lower) {
		this.lower = lower;
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
		
		
		
		
}
