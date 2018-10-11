package com.sinosoft.dms.api.dict.dto;

import java.io.Serializable;
import java.util.Date;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:01:56.447 
 * 通用代码险种对照表Api操作对象
 */
public class PrpDcodeRiskDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性代码类型(见PrpDtype表)/代码类型(见PrpDtype表) */
	private String codeType ;		
	/** 属性业务代码(见PrpDcode)/业务代码(见PrpDcode) */
	private String codeCode ;		
	/** 属性险种代码(见PrpDrisk)/险种代码(见PrpDrisk) */
	private String riskCode ;		
	/** 属性顺序/顺序 */
	private String flag ;		
	/** 属性修改人/修改人 */
	private String update_By ;
	/** 属性修改时间/修改时间 */
	private java.util.Date update_Date ;
	/** 属性createdBy/createdBy */
	private String updateBy ;		
	/** 属性createdTime/createdTime */
	private java.util.Date updateDate ;		
	/**
	 * 属性代码类型(见PrpDtype表)/代码类型(见PrpDtype表)的getter方法
	 */
	public String getCodeType() {
		return codeType;
	}
	/**
	 * 属性代码类型(见PrpDtype表)/代码类型(见PrpDtype表)的setter方法
	 */
	public void setCodeType(String codeType) {
		this.codeType = codeType;
	}	
	/**
	 * 属性业务代码(见PrpDcode)/业务代码(见PrpDcode)的getter方法
	 */
	public String getCodeCode() {
		return codeCode;
	}
	/**
	 * 属性业务代码(见PrpDcode)/业务代码(见PrpDcode)的setter方法
	 */
	public void setCodeCode(String codeCode) {
		this.codeCode = codeCode;
	}	
	/**
	 * 属性险种代码(见PrpDrisk)/险种代码(见PrpDrisk)的getter方法
	 */
	public String getRiskCode() {
		return riskCode;
	}
	/**
	 * 属性险种代码(见PrpDrisk)/险种代码(见PrpDrisk)的setter方法
	 */
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}	
	/**
	 * 属性顺序/顺序的getter方法
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * 属性顺序/顺序的setter方法
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

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
}
