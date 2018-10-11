package com.sinosoft.pms.api.kernel.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-04 10:42:46.546 
 * 标的项目代码表Api操作对象
 */
public class PrpDitemAgriDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性险种代码/险种代码 */
	private String riskCode ;
	/** 属性标的项目代码/标的项目代码 */
	private String itemCode ;
	/** 属性标的项目中文名称/标的项目中文名称 */
	private String itemCName ;
	/** 属性标的项目英文名称/标的项目英文名称 */
	private String itemEName ;
	/** 属性标的项目类别标志 (Y特约/N非特约)/标的项目类别标志 (Y特约/N非特约) */
	private String itemFlag ;
	/** 属性新的标的项目类别代码/新的标的项目类别代码 */
	private String newItemCode ;
	/** 属性效力状态(0失效/1有效)/效力状态(0失效/1有效) */
	private String validStatus ;
	/** 属性标志字段/标志字段 */
	private String flag ;
	/** 属性修改人/修改人 */
	private String update_By ;
	/** 属性修改时间/修改时间 */
	private Date update_Date ;
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
	 * 属性标的项目代码/标的项目代码的getter方法
	 */
	public String getItemCode() {
		return itemCode;
	}
	/**
	 * 属性标的项目代码/标的项目代码的setter方法
	 */
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}	
	/**
	 * 属性标的项目中文名称/标的项目中文名称的getter方法
	 */
	public String getItemCName() {
		return itemCName;
	}
	/**
	 * 属性标的项目中文名称/标的项目中文名称的setter方法
	 */
	public void setItemCName(String itemCName) {
		this.itemCName = itemCName;
	}	
	/**
	 * 属性标的项目英文名称/标的项目英文名称的getter方法
	 */
	public String getItemEName() {
		return itemEName;
	}
	/**
	 * 属性标的项目英文名称/标的项目英文名称的setter方法
	 */
	public void setItemEName(String itemEName) {
		this.itemEName = itemEName;
	}	
	/**
	 * 属性标的项目类别标志 (Y特约/N非特约)/标的项目类别标志 (Y特约/N非特约)的getter方法
	 */
	public String getItemFlag() {
		return itemFlag;
	}
	/**
	 * 属性标的项目类别标志 (Y特约/N非特约)/标的项目类别标志 (Y特约/N非特约)的setter方法
	 */
	public void setItemFlag(String itemFlag) {
		this.itemFlag = itemFlag;
	}	
	/**
	 * 属性新的标的项目类别代码/新的标的项目类别代码的getter方法
	 */
	public String getNewItemCode() {
		return newItemCode;
	}
	/**
	 * 属性新的标的项目类别代码/新的标的项目类别代码的setter方法
	 */
	public void setNewItemCode(String newItemCode) {
		this.newItemCode = newItemCode;
	}	
	/**
	 * 属性效力状态(0失效/1有效)/效力状态(0失效/1有效)的getter方法
	 */
	public String getValidStatus() {
		return validStatus;
	}
	/**
	 * 属性效力状态(0失效/1有效)/效力状态(0失效/1有效)的setter方法
	 */
	public void setValidStatus(String validStatus) {
		this.validStatus = validStatus;
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

	public String getUpdate_By() {
		return update_By;
	}

	public void setUpdate_By(String update_By) {
		this.update_By = update_By;
	}

	public Date getUpdate_Date() {
		return update_Date;
	}

	public void setUpdate_Date(Date update_Date) {
		this.update_Date = update_Date;
	}
}
