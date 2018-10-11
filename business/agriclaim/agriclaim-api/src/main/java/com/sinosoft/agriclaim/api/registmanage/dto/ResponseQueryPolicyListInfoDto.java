package com.sinosoft.agriclaim.api.registmanage.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;

/**
* @Description: 投保单查询列表信息responseDtoApi操作对象
* @Author: 何伟东
* @Date: 2017/10/15 11:19
*/
public class ResponseQueryPolicyListInfoDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性投保单号/投保单号 */
	private String policyNo ;			
	/** 属性被保险人名称/被保险人名称 */
	private String insuredName ;			
	/** 属性保险起期/保险起期 */
	private String startDate ;		
	/** 属性保险止期/保险止期 */
	private String endDate ;		
	/** 属性险种名称/险种名称 */
	private String riskName ;		
	/** 属性险种代码/险种代码*/
	private String riskCode ;	
	/**
	 * 属性投保单号/投保单号的getter方法
	 */
	public String getPolicyNo() {
		return policyNo;
	}
	/**
	 * 属性投保单号/投保单号的setter方法
	 */
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}
	/**
	 * 属性被保险人名称/被保险人名称的getter方法
	 */
	public String getInsuredName() {
		return insuredName;
	}
	/**
	 * 属性被保险人名称/被保险人名称的setter方法
	 */
	public void setInsuredName(String insuredName) {
		this.insuredName = insuredName;
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
	 * 属性保险起期/保险起期的getter方法
	 */
	public String getStartDate() {
		return startDate;
	}
	/**
	 * 属性保险止期/保险止期的setter方法
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	/**
	 * 属性保险止期/保险止期的getter方法
	 */
	public String getEndDate() {
		return endDate;
	}
	/**
	 * 属性被保险人名称/被保险人名称的setter方法
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	/**
	 * 属性险种名称/险种名称的setter方法
	 */
	public String getRiskName() {
		return riskName;
	}
	/**
	 * 属性险种名称/险种名称的setter方法
	 */
	public void setRiskName(String riskName) {
		this.riskName = riskName;
	}	


}
