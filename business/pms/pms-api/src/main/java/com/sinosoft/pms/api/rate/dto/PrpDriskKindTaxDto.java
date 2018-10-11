package com.sinosoft.pms.api.rate.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-08-29 07:14:25.063 
 * 险种险别增值税基础税率配置表Api操作对象
 */
public class PrpDriskKindTaxDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性自增长序列/自增长序列 */
	private java.lang.Integer uuid ;
	/** 属性机构代码/机构代码 */
	private String comCode ;
	/** 属性险类代码/险类代码 */
	private String classCode ;
	/** 属性险种代码/险种代码 */
	private String riskCode ;
	/** 属性条款代码/条款代码 */
	private String kindCode ;
	/** 属性免/应税标识，1-应税（默认），2-免税/免/应税标识，1-应税（默认），2-免税 */
	private String taxFlag ;
	/** 属性税率/税率 */
	private java.lang.Double taxRate ;
	/** 属性税率类型 1、保费税率；2、退保手续费税率；3、共保出单费税率；4、投资金退保手续费；9、手续费税率 如果传""则默认为1、保费税率/税率类型 1、保费税率；2、退保手续费税率；3、共保出单费税率；4、投资金退保手续费；9、手续费税率 如果传""则默认为1、保费税率 */
	private String taxRateType ;
	/** 属性有效状态:0-无效，1-有效/有效状态:0-无效，1-有效 */
	private String validStatus ;
	/** 属性生效日期：YYYY-MM-DD/生效日期：YYYY-MM-DD */
	@JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
	private java.util.Date validDate ;
	/**
	 * 属性自增长序列/自增长序列的getter方法
	 */
	public java.lang.Integer getUuid() {
		return uuid;
	}
	/**
	 * 属性自增长序列/自增长序列的setter方法
	 */
	public void setUuid(java.lang.Integer uuid) {
		this.uuid = uuid;
	}
	/**
	 * 属性机构代码/机构代码的getter方法
	 */
	public String getComCode() {
		return comCode;
	}
	/**
	 * 属性机构代码/机构代码的setter方法
	 */
	public void setComCode(String comCode) {
		this.comCode = comCode;
	}
	/**
	 * 属性险类代码/险类代码的getter方法
	 */
	public String getClassCode() {
		return classCode;
	}
	/**
	 * 属性险类代码/险类代码的setter方法
	 */
	public void setClassCode(String classCode) {
		this.classCode = classCode;
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
	 * 属性条款代码/条款代码的getter方法
	 */
	public String getKindCode() {
		return kindCode;
	}
	/**
	 * 属性条款代码/条款代码的setter方法
	 */
	public void setKindCode(String kindCode) {
		this.kindCode = kindCode;
	}
	/**
	 * 属性免/应税标识，1-应税（默认），2-免税/免/应税标识，1-应税（默认），2-免税的getter方法
	 */
	public String getTaxFlag() {
		return taxFlag;
	}
	/**
	 * 属性免/应税标识，1-应税（默认），2-免税/免/应税标识，1-应税（默认），2-免税的setter方法
	 */
	public void setTaxFlag(String taxFlag) {
		this.taxFlag = taxFlag;
	}
	/**
	 * 属性税率/税率的getter方法
	 */
	public java.lang.Double getTaxRate() {
		return taxRate;
	}
	/**
	 * 属性税率/税率的setter方法
	 */
	public void setTaxRate(java.lang.Double taxRate) {
		this.taxRate = taxRate;
	}
	/**
	 * 属性税率类型 1、保费税率；2、退保手续费税率；3、共保出单费税率；4、投资金退保手续费；9、手续费税率 如果传""则默认为1、保费税率/税率类型 1、保费税率；2、退保手续费税率；3、共保出单费税率；4、投资金退保手续费；9、手续费税率 如果传""则默认为1、保费税率的getter方法
	 */
	public String getTaxRateType() {
		return taxRateType;
	}
	/**
	 * 属性税率类型 1、保费税率；2、退保手续费税率；3、共保出单费税率；4、投资金退保手续费；9、手续费税率 如果传""则默认为1、保费税率/税率类型 1、保费税率；2、退保手续费税率；3、共保出单费税率；4、投资金退保手续费；9、手续费税率 如果传""则默认为1、保费税率的setter方法
	 */
	public void setTaxRateType(String taxRateType) {
		this.taxRateType = taxRateType;
	}
	/**
	 * 属性有效状态:0-无效，1-有效/有效状态:0-无效，1-有效的getter方法
	 */
	public String getValidStatus() {
		return validStatus;
	}
	/**
	 * 属性有效状态:0-无效，1-有效/有效状态:0-无效，1-有效的setter方法
	 */
	public void setValidStatus(String validStatus) {
		this.validStatus = validStatus;
	}
	/**
	 * 属性生效日期：YYYY-MM-DD/生效日期：YYYY-MM-DD的getter方法
	 */
	public java.util.Date getValidDate() {
		return validDate;
	}
	/**
	 * 属性生效日期：YYYY-MM-DD/生效日期：YYYY-MM-DD的setter方法
	 */
	public void setValidDate(java.util.Date validDate) {
		this.validDate = validDate;
	}

}
