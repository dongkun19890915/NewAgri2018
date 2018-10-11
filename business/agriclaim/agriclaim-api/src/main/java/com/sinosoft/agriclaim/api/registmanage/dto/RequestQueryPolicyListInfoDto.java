package com.sinosoft.agriclaim.api.registmanage.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BasePageableRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-11 09:09:58.263 
 * 保单信息主表Api操作对象
 */
public class RequestQueryPolicyListInfoDto extends BasePageableRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性保单号码/保单号码 */
	private String policyNo ;	
	/** 属性险种代码 /险种大类: */               
	private String riskType;
	/** 属性被保人名称/被保人名称 */
	private String insuredName ;			
	/** 属性被保人代码/被保人代码 */
	private String identifyNumber ;			
	/** 属性险种代码 /耳标号  */               
	private String earLabel ;		
	/** 属性险种代码 /农户姓名：(种植险专用)  */               
	private String fName;		
	/** 属性起保日期 /起保日期  */
	private String startDate;
	private String startEndDate;
	/** 属性终保日期/终保日期 */
	private String endDate;
	private String endEndDate;

	public String getStartEndDate() {
		return startEndDate;
	}

	public void setStartEndDate(String startEndDate) {
		this.startEndDate = startEndDate;
	}

	public String getEndEndDate() {
		return endEndDate;
	}

	public void setEndEndDate(String endEndDate) {
		this.endEndDate = endEndDate;
	}

	public String getPolicyNo() {
		return policyNo;
	}
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}
	public String getRiskType() {
		return riskType;
	}
	public void setRiskType(String riskType) {
		this.riskType = riskType;
	}
	public String getInsuredName() {
		return insuredName;
	}
	public void setInsuredName(String insuredName) {
		this.insuredName = insuredName;
	}
	public String getIdentifyNumber() {
		return identifyNumber;
	}
	public void setIdentifyNumber(String identifyNumber) {
		this.identifyNumber = identifyNumber;
	}
	public String getEarLabel() {
		return earLabel;
	}
	public void setEarLabel(String earLabel) {
		this.earLabel = earLabel;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}		
	
}
