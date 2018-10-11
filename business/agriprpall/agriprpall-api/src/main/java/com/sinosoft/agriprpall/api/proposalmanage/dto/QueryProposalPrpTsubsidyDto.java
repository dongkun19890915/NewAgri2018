package com.sinosoft.agriprpall.api.proposalmanage.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-18 13:10:01.639 
 * 补贴信息Api操作对象
 */
public class QueryProposalPrpTsubsidyDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性补贴类型/补贴类型 */
	private String subsidyCode ;		
	/** 属性补贴方式/补贴方式 */
	private String subsidyType ;		
	/** 属性补贴单位/补贴单位 */
	private String subsidyDepartment ;		
	/** 属性补贴比例/补贴比例 */
	private Double subsidyRate ;
	/** 属性补贴金额/补贴金额 */
	private Double subsidyPremium ;
	/**
	 * 属性补贴类型/补贴类型的getter方法
	 */
	public String getSubsidyCode() {
		return subsidyCode;
	}
	/**
	 * 属性补贴类型/补贴类型的setter方法
	 */
	public void setSubsidyCode(String subsidyCode) {
		this.subsidyCode = subsidyCode;
	}	
	/**
	 * 属性补贴方式/补贴方式的getter方法
	 */
	public String getSubsidyType() {
		return subsidyType;
	}
	/**
	 * 属性补贴方式/补贴方式的setter方法
	 */
	public void setSubsidyType(String subsidyType) {
		this.subsidyType = subsidyType;
	}	
	/**
	 * 属性补贴单位/补贴单位的getter方法
	 */
	public String getSubsidyDepartment() {
		return subsidyDepartment;
	}
	/**
	 * 属性补贴单位/补贴单位的setter方法
	 */
	public void setSubsidyDepartment(String subsidyDepartment) {
		this.subsidyDepartment = subsidyDepartment;
	}	
	/**
	 * 属性补贴比例/补贴比例的getter方法
	 */
	public Double getSubsidyRate() {
		return subsidyRate;
	}
	/**
	 * 属性补贴比例/补贴比例的setter方法
	 */
	public void setSubsidyRate(Double subsidyRate) {
		this.subsidyRate = subsidyRate;
	}	
	/**
	 * 属性补贴金额/补贴金额的getter方法
	 */
	public Double getSubsidyPremium() {
		return subsidyPremium;
	}
	/**
	 * 属性补贴金额/补贴金额的setter方法
	 */
	public void setSubsidyPremium(Double subsidyPremium) {
		this.subsidyPremium = subsidyPremium;
	}	
}
