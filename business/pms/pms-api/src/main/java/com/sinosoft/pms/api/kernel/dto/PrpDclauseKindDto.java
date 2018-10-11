package com.sinosoft.pms.api.kernel.dto;

import java.io.Serializable;
import java.util.Date;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-04 10:42:46.546 
 * 条款险别关系表Api操作对象
 */
public class PrpDclauseKindDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性险种代码/险种代码 */
	private String riskCode ;		
	/** 属性条款类别/条款类别 */
	private String clauseType ;		
	/** 属性险别代码/险别代码 */
	private String kindCode ;		
	/** 属性关联险别代码/关联险别代码 */
	private String relateKindCode ;		
	/** 属性标志位/标志位 */
	private String flag ;		
	/** 属性修改人/修改人 */
	private String update_By ;
	/** 属性修改时间/修改时间 */
	private java.util.Date update_Date ;
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
	 * 属性条款类别/条款类别的getter方法
	 */
	public String getClauseType() {
		return clauseType;
	}
	/**
	 * 属性条款类别/条款类别的setter方法
	 */
	public void setClauseType(String clauseType) {
		this.clauseType = clauseType;
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
	 * 属性关联险别代码/关联险别代码的getter方法
	 */
	public String getRelateKindCode() {
		return relateKindCode;
	}
	/**
	 * 属性关联险别代码/关联险别代码的setter方法
	 */
	public void setRelateKindCode(String relateKindCode) {
		this.relateKindCode = relateKindCode;
	}	
	/**
	 * 属性标志位/标志位的getter方法
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * 属性标志位/标志位的setter方法
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
