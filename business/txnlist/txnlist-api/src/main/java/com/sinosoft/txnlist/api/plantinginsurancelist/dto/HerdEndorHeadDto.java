package com.sinosoft.txnlist.api.plantinginsurancelist.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-18 08:36:26.740 
 * 批改头表Api操作对象
 */
public class HerdEndorHeadDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性投保清单编号/投保清单编号 */
	private String inusreListCode ;		
	/** 属性批单号码/批单号码 */
	private String endorseNo ;		
	/** 属性保单号码/保单号码 */
	private String policyNo ;		
	/** 属性险种/险种 */
	private String riskCode ;		
	/** 属性清单标志（未提交、已提交）/清单标志（未提交、已提交） */
	private String listFlag ;		
	/** 属性批单类型（正常批单、冲减保额批单）/批单类型（正常批单、冲减保额批单） */
	private String endorFlag ;
	/** 属性是否删除标志/是否删除标志 */
	private String isDeleteFlag;
	/**
	 * 属性投保清单编号/投保清单编号的getter方法
	 */
	public String getInusreListCode() {
		return inusreListCode;
	}
	/**
	 * 属性投保清单编号/投保清单编号的setter方法
	 */
	public void setInusreListCode(String inusreListCode) {
		this.inusreListCode = inusreListCode;
	}	
	/**
	 * 属性批单号码/批单号码的getter方法
	 */
	public String getEndorseNo() {
		return endorseNo;
	}
	/**
	 * 属性批单号码/批单号码的setter方法
	 */
	public void setEndorseNo(String endorseNo) {
		this.endorseNo = endorseNo;
	}	
	/**
	 * 属性保单号码/保单号码的getter方法
	 */
	public String getPolicyNo() {
		return policyNo;
	}
	/**
	 * 属性保单号码/保单号码的setter方法
	 */
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}	
	/**
	 * 属性险种/险种的getter方法
	 */
	public String getRiskCode() {
		return riskCode;
	}
	/**
	 * 属性险种/险种的setter方法
	 */
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}	
	/**
	 * 属性清单标志（未提交、已提交）/清单标志（未提交、已提交）的getter方法
	 */
	public String getListFlag() {
		return listFlag;
	}
	/**
	 * 属性清单标志（未提交、已提交）/清单标志（未提交、已提交）的setter方法
	 */
	public void setListFlag(String listFlag) {
		this.listFlag = listFlag;
	}	
	/**
	 * 属性批单类型（正常批单、冲减保额批单）/批单类型（正常批单、冲减保额批单）的getter方法
	 */
	public String getEndorFlag() {
		return endorFlag;
	}
	/**
	 * 属性批单类型（正常批单、冲减保额批单）/批单类型（正常批单、冲减保额批单）的setter方法
	 */
	public void setEndorFlag(String endorFlag) {
		this.endorFlag = endorFlag;
	}

	public String getIsDeleteFlag() {
		return isDeleteFlag;
	}

	public void setIsDeleteFlag(String isDeleteFlag) {
		this.isDeleteFlag = isDeleteFlag;
	}
}
