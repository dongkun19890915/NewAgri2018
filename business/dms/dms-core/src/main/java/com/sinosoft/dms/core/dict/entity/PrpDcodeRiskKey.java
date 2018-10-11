package com.sinosoft.dms.core.dict.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:01:56.447 
 * 通用代码险种对照表主键操作对象
 */
public class PrpDcodeRiskKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpDcodeRiskKey(){}
	public PrpDcodeRiskKey(String codeType,String codeCode,String riskCode){
		this.codeType = codeType;
		this.codeCode = codeCode;
		this.riskCode = riskCode;
	}
	/** 属性代码类型(见PrpDtype表)/代码类型(见PrpDtype表) */
	@Column(name = "codeType")
	private String codeType ;
	/** 属性业务代码(见PrpDcode)/业务代码(见PrpDcode) */
	@Column(name = "codeCode")
	private String codeCode ;
	/** 属性险种代码(见PrpDrisk)/险种代码(见PrpDrisk) */
	@Column(name = "riskCode")
	private String riskCode ;
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
}