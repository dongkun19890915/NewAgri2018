package com.sinosoft.pms.api.kernel.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-09-15 09:19:57.041 
 * 条款标的表Api操作对象
 */
public class PrpDclauseItemDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性条款代码/条款代码 */
	private String clauseCode ;		
	/** 属性标的代码/标的代码 */
	private String itemCode ;		
	/** 属性旧标的代码/旧标的代码 */
	private String oldItemCode ;		
	/** 属性标的中文名称/标的中文名称 */
	private String itemCName ;		
	/** 属性标的英文名称/标的英文名称 */
	private String itemEName ;		
	/** 属性上级标的代码/上级标的代码 */
	private String upperItemCode ;		
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
	 * 属性旧标的代码/旧标的代码的getter方法
	 */
	public String getOldItemCode() {
		return oldItemCode;
	}
	/**
	 * 属性旧标的代码/旧标的代码的setter方法
	 */
	public void setOldItemCode(String oldItemCode) {
		this.oldItemCode = oldItemCode;
	}	
	/**
	 * 属性标的中文名称/标的中文名称的getter方法
	 */
	public String getItemCName() {
		return itemCName;
	}
	/**
	 * 属性标的中文名称/标的中文名称的setter方法
	 */
	public void setItemCName(String itemCName) {
		this.itemCName = itemCName;
	}	
	/**
	 * 属性标的英文名称/标的英文名称的getter方法
	 */
	public String getItemEName() {
		return itemEName;
	}
	/**
	 * 属性标的英文名称/标的英文名称的setter方法
	 */
	public void setItemEName(String itemEName) {
		this.itemEName = itemEName;
	}	
	/**
	 * 属性上级标的代码/上级标的代码的getter方法
	 */
	public String getUpperItemCode() {
		return upperItemCode;
	}
	/**
	 * 属性上级标的代码/上级标的代码的setter方法
	 */
	public void setUpperItemCode(String upperItemCode) {
		this.upperItemCode = upperItemCode;
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
