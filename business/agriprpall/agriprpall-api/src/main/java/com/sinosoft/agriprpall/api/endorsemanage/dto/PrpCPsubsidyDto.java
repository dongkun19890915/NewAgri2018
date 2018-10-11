package com.sinosoft.agriprpall.api.endorsemanage.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-24 03:06:48.016 
 * 政府补贴表Api操作对象
 */
public class PrpCPsubsidyDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性保单号/保单号 */
	private String policyNo ;		
	/** 属性投保单号/投保单号 */
	private String proposalNo ;		
	/** 属性合同号/合同号 */
	private String contractNo ;		
	/** 属性险种代码/险种代码 */
	private String riskCode ;		
	/** 属性险类代码/险类代码 */
	private String classCode ;		
	/** 属性机构代码/机构代码 */
	private String comCode ;		
	/** 属性币别信息/币别信息 */
	private String currency ;		
	/** 属性benchmarkPremium/benchmarkPremium */
	private Double benchmarkPremium ;
	/** 属性subsidyCode/subsidyCode */
	private String subsidyCode ;		
	/** 属性subsidyName/subsidyName */
	private String subsidyName ;		
	/** 属性subsidyType/subsidyType */
	private String subsidyType ;		
	/** 属性subsidyTypeName/subsidyTypeName */
	private String subsidyTypeName ;		
	/** 属性subsidyDepartment/subsidyDepartment */
	private String subsidyDepartment ;		
	/** 属性subsidyRate/subsidyRate */
	private Double subsidyRate ;
	/** 属性subsidyPremium/subsidyPremium */
	private Double subsidyPremium ;
	/** 属性operationFlag/operationFlag */
	private String operationFlag ;		
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
	 * 属性合同号/合同号的getter方法
	 */
	public String getContractNo() {
		return contractNo;
	}
	/**
	 * 属性合同号/合同号的setter方法
	 */
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
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
	 * 属性币别信息/币别信息的getter方法
	 */
	public String getCurrency() {
		return currency;
	}
	/**
	 * 属性币别信息/币别信息的setter方法
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}	
	/**
	 * 属性benchmarkPremium/benchmarkPremium的getter方法
	 */
	public Double getBenchmarkPremium() {
		return benchmarkPremium;
	}
	/**
	 * 属性benchmarkPremium/benchmarkPremium的setter方法
	 */
	public void setBenchmarkPremium(Double benchmarkPremium) {
		this.benchmarkPremium = benchmarkPremium;
	}	
	/**
	 * 属性subsidyCode/subsidyCode的getter方法
	 */
	public String getSubsidyCode() {
		return subsidyCode;
	}
	/**
	 * 属性subsidyCode/subsidyCode的setter方法
	 */
	public void setSubsidyCode(String subsidyCode) {
		this.subsidyCode = subsidyCode;
	}	
	/**
	 * 属性subsidyName/subsidyName的getter方法
	 */
	public String getSubsidyName() {
		return subsidyName;
	}
	/**
	 * 属性subsidyName/subsidyName的setter方法
	 */
	public void setSubsidyName(String subsidyName) {
		this.subsidyName = subsidyName;
	}	
	/**
	 * 属性subsidyType/subsidyType的getter方法
	 */
	public String getSubsidyType() {
		return subsidyType;
	}
	/**
	 * 属性subsidyType/subsidyType的setter方法
	 */
	public void setSubsidyType(String subsidyType) {
		this.subsidyType = subsidyType;
	}	
	/**
	 * 属性subsidyTypeName/subsidyTypeName的getter方法
	 */
	public String getSubsidyTypeName() {
		return subsidyTypeName;
	}
	/**
	 * 属性subsidyTypeName/subsidyTypeName的setter方法
	 */
	public void setSubsidyTypeName(String subsidyTypeName) {
		this.subsidyTypeName = subsidyTypeName;
	}	
	/**
	 * 属性subsidyDepartment/subsidyDepartment的getter方法
	 */
	public String getSubsidyDepartment() {
		return subsidyDepartment;
	}
	/**
	 * 属性subsidyDepartment/subsidyDepartment的setter方法
	 */
	public void setSubsidyDepartment(String subsidyDepartment) {
		this.subsidyDepartment = subsidyDepartment;
	}	
	/**
	 * 属性subsidyRate/subsidyRate的getter方法
	 */
	public Double getSubsidyRate() {
		return subsidyRate;
	}
	/**
	 * 属性subsidyRate/subsidyRate的setter方法
	 */
	public void setSubsidyRate(Double subsidyRate) {
		this.subsidyRate = subsidyRate;
	}	
	/**
	 * 属性subsidyPremium/subsidyPremium的getter方法
	 */
	public Double getSubsidyPremium() {
		return subsidyPremium;
	}
	/**
	 * 属性subsidyPremium/subsidyPremium的setter方法
	 */
	public void setSubsidyPremium(Double subsidyPremium) {
		this.subsidyPremium = subsidyPremium;
	}	
	/**
	 * 属性operationFlag/operationFlag的getter方法
	 */
	public String getOperationFlag() {
		return operationFlag;
	}
	/**
	 * 属性operationFlag/operationFlag的setter方法
	 */
	public void setOperationFlag(String operationFlag) {
		this.operationFlag = operationFlag;
	}	
}
