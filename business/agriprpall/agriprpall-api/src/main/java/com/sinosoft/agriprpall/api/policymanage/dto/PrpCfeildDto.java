package com.sinosoft.agriprpall.api.policymanage.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sinosoft.agriprpall.api.proposalmanage.dto.PrpTfeildDto;
import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-24 07:46:04.010 
 * 大户田块信息Api操作对象
 */
public class PrpCfeildDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性保单号/保单号 */
	private String policyNo ;		
	/** 属性投保单号/投保单号 */
	private String proposalNo ;		
	/** 属性田块编码/田块编码 */
	private String feildNo ;		
	/** 属性田块名称/田块名称 */
	private String feildName ;		
	/** 属性feildArea/feildArea */
	private Double feildArea ;
	/** 属性大户代码/大户代码 */
	private String richflyCode ;		
	/** 属性大户名称/大户名称 */
	private String richflyCName ;		
	/** 属性操作类型/操作类型 */
	private String operationFlag ="";
	/** 属性修改人/修改人 */
	private String update_By ;
	/** 属性修改时间/修改时间 */
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private java.util.Date update_Date ;
	/**
	 * 属性保单号/保单号的getter方法
	 */
	public String getPolicyNo() {
		return policyNo;
	}
	/**
	 * 属性保单号/保单号的setter方法
	 */
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}	
	/**
	 * 属性投保单号/投保单号的getter方法
	 */
	public String getProposalNo() {
		return proposalNo;
	}
	/**
	 * 属性投保单号/投保单号的setter方法
	 */
	public void setProposalNo(String proposalNo) {
		this.proposalNo = proposalNo;
	}	
	/**
	 * 属性田块编码/田块编码的getter方法
	 */
	public String getFeildNo() {
		return feildNo;
	}
	/**
	 * 属性田块编码/田块编码的setter方法
	 */
	public void setFeildNo(String feildNo) {
		this.feildNo = feildNo;
	}	
	/**
	 * 属性田块名称/田块名称的getter方法
	 */
	public String getFeildName() {
		return feildName;
	}
	/**
	 * 属性田块名称/田块名称的setter方法
	 */
	public void setFeildName(String feildName) {
		this.feildName = feildName;
	}	
	/**
	 * 属性feildArea/feildArea的getter方法
	 */
	public Double getFeildArea() {
		return feildArea;
	}
	/**
	 * 属性feildArea/feildArea的setter方法
	 */
	public void setFeildArea(Double feildArea) {
		this.feildArea = feildArea;
	}	
	/**
	 * 属性大户代码/大户代码的getter方法
	 */
	public String getRichflyCode() {
		return richflyCode;
	}
	/**
	 * 属性大户代码/大户代码的setter方法
	 */
	public void setRichflyCode(String richflyCode) {
		this.richflyCode = richflyCode;
	}	
	/**
	 * 属性大户名称/大户名称的getter方法
	 */
	public String getRichflyCName() {
		return richflyCName;
	}
	/**
	 * 属性大户名称/大户名称的setter方法
	 */
	public void setRichflyCName(String richflyCName) {
		this.richflyCName = richflyCName;
	}	
	/**
	 * 属性操作类型/操作类型的getter方法
	 */
	public String getOperationFlag() {
		return operationFlag;
	}
	/**
	 * 属性操作类型/操作类型的setter方法
	 */
	public void setOperationFlag(String operationFlag) {
		this.operationFlag = operationFlag;
	}	
	/**
	 * 属性修改人/修改人的getter方法
	 */
	public String getUpdate_By() {
		return update_By;
	}
	/**
	 * 属性修改人/修改人的setter方法
	 */
	public void setUpdate_By(String update_By) {
		this.update_By = update_By;
	}	
	/**
	 * 属性修改时间/修改时间的getter方法
	 */
	public java.util.Date getUpdate_Date() {
		return update_Date;
	}
	/**
	 * 属性修改时间/修改时间的setter方法
	 */
	public void setUpdate_Date(java.util.Date update_Date) {
		this.update_Date = update_Date;
	}
}
