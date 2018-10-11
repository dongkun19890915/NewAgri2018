package com.sinosoft.ims.core.auth.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:10:12.703 
 * UtiCodeTransfer实体操作对象
 */
@Entity
@Table(name = "UtiCodeTransfer")
@IdClass(UtiCodeTransferKey.class)
public class UtiCodeTransfer extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性configCode/configCode */
	@Id
	@Column(name = "configCode")
	private String configCode ;	

	/** 属性outerCode/outerCode */
	@Column(name = "outerCode")
	private String outerCode ;
	/** 属性innerCode/innerCode */
	@Column(name = "innerCode")
	private String innerCode ;
	/** 属性codeType/codeType */
	@Column(name = "codeType")
	private String codeType ;
	/** 属性validStatus/validStatus */
	@Column(name = "validStatus")
	private String validStatus ;
	/** 属性riskType/riskType */
	@Column(name = "riskType")
	private String riskType ;
	/**
	 * 属性configCode/configCode的getter方法
	 */
	public String getConfigCode() {
		return configCode;
	}
	/**
	 * 属性configCode/configCode的setter方法
	 */
	public void setConfigCode(String configCode) {
		this.configCode = configCode;
	} 	
	/**
	 * 属性outerCode/outerCode的getter方法
	 */
	public String getOuterCode() {
		return outerCode;
	}
	/**
	 * 属性outerCode/outerCode的setter方法
	 */
	public void setOuterCode(String outerCode) {
		this.outerCode = outerCode;
	} 	
	/**
	 * 属性innerCode/innerCode的getter方法
	 */
	public String getInnerCode() {
		return innerCode;
	}
	/**
	 * 属性innerCode/innerCode的setter方法
	 */
	public void setInnerCode(String innerCode) {
		this.innerCode = innerCode;
	} 	
	/**
	 * 属性codeType/codeType的getter方法
	 */
	public String getCodeType() {
		return codeType;
	}
	/**
	 * 属性codeType/codeType的setter方法
	 */
	public void setCodeType(String codeType) {
		this.codeType = codeType;
	} 	
	/**
	 * 属性validStatus/validStatus的getter方法
	 */
	public String getValidStatus() {
		return validStatus;
	}
	/**
	 * 属性validStatus/validStatus的setter方法
	 */
	public void setValidStatus(String validStatus) {
		this.validStatus = validStatus;
	} 	
	/**
	 * 属性riskType/riskType的getter方法
	 */
	public String getRiskType() {
		return riskType;
	}
	/**
	 * 属性riskType/riskType的setter方法
	 */
	public void setRiskType(String riskType) {
		this.riskType = riskType;
	} 	
}