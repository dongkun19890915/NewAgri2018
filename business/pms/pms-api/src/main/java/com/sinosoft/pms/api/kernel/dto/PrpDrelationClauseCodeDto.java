package com.sinosoft.pms.api.kernel.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-12-18 02:37:33.970 
 * 条款与保险责任关联表Api操作对象
 */
public class PrpDrelationClauseCodeDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性条款代码/条款代码 */
	private String clauseCode ;		
	/** 属性保险责任代码/保险责任代码 */
	private String insuranceCode ;		
	/** 属性备用标识/备用标识 */
	private String flag ;		
	/** 属性条款状态,0-无效；1-有效/条款状态,0-无效；1-有效 */
	private String validStatus ;
	//保险责任内容
	private String insuranceText;
	//保险责任名称
	private String insuranceName;

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
	 * 属性保险责任代码/保险责任代码的getter方法
	 */
	public String getInsuranceCode() {
		return insuranceCode;
	}
	/**
	 * 属性保险责任代码/保险责任代码的setter方法
	 */
	public void setInsuranceCode(String insuranceCode) {
		this.insuranceCode = insuranceCode;
	}	
	/**
	 * 属性备用标识/备用标识的getter方法
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * 属性备用标识/备用标识的setter方法
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}	
	/**
	 * 属性条款状态,0-无效；1-有效/条款状态,0-无效；1-有效的getter方法
	 */
	public String getValidStatus() {
		return validStatus;
	}
	/**
	 * 属性条款状态,0-无效；1-有效/条款状态,0-无效；1-有效的setter方法
	 */
	public void setValidStatus(String validStatus) {
		this.validStatus = validStatus;
	}

	public String getInsuranceText() {
		return insuranceText;
	}

	public void setInsuranceText(String insuranceText) {
		this.insuranceText = insuranceText;
	}

	public String getInsuranceName() {
		return insuranceName;
	}

	public void setInsuranceName(String insuranceName) {
		this.insuranceName = insuranceName;
	}
}
