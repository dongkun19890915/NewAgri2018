package com.sinosoft.agriprpall.core.proposalmanage.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;

import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-18 03:10:49.566 
 * 政府补贴信息实体操作对象
 */
@Entity
@Table(name = "PrpTsubsidy")
@IdClass(PrpTsubsidyKey.class)
public class PrpTsubsidy extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性投保单号/投保单号 */
	@Id
	@Column(name = "proposalNo")
	private String proposalNo ;/** 属性补贴类型/补贴类型 */
	@Id
	@Column(name = "subsidyCode")
	private String subsidyCode ;/** 属性补贴方式/补贴方式 subsidy补贴 */
	@Id
	@Column(name = "subsidyType")
	private String subsidyType ;	

	/** 属性合同号/合同号 */
	@Column(name = "contractNo")
	private String contractNo ;
	/** 属性险种代码/险种代码 */
	@Column(name = "riskCode")
	private String riskCode ;
	/** 属性险类代码/险类代码 */
	@Column(name = "classCode")
	private String classCode ;
	/** 属性归属机构代码/归属机构代码 */
	@Column(name = "comCode")
	private String comCode ;
	/** 属性币别/币别 */
	@Column(name = "currency")
	private String currency ;
	/** 属性benchMarkPremium/benchMarkPremium benchmark 基准*/
	@Column(name = "benchmarkPremium")
	private Double benchmarkPremium ;

	/** 属性补贴名称/补贴名称 */
	@Column(name = "subsidyName")
	private String subsidyName ;

	/** 属性补贴方式名称/补贴方式名称 */
	@Column(name = "subsidyTypeName")
	private String subsidyTypeName ;
	/** 属性补贴单位/补贴单位 */
	@Column(name = "subsidyDepartment")
	private String subsidyDepartment ;
	/** 属性补贴比例/补贴比例 */
	@Column(name = "subsidyRate")
	private Double subsidyRate ;
	/** 属性补贴金额/补贴金额 */
	@Column(name = "subsidyPremium")
	private Double subsidyPremium ;
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
	 * 属性归属机构代码/归属机构代码的getter方法
	 */
	public String getComCode() {
		return comCode;
	}
	/**
	 * 属性归属机构代码/归属机构代码的setter方法
	 */
	public void setComCode(String comCode) {
		this.comCode = comCode;
	} 	
	/**
	 * 属性币别/币别的getter方法
	 */
	public String getCurrency() {
		return currency;
	}
	/**
	 * 属性币别/币别的setter方法
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Double getBenchmarkPremium() {
		return benchmarkPremium;
	}

	public void setBenchmarkPremium(Double benchmarkPremium) {
		this.benchmarkPremium = benchmarkPremium;
	}

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
	 * 属性补贴名称/补贴名称的getter方法
	 */
	public String getSubsidyName() {
		return subsidyName;
	}
	/**
	 * 属性补贴名称/补贴名称的setter方法
	 */
	public void setSubsidyName(String subsidyName) {
		this.subsidyName = subsidyName;
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
	 * 属性补贴方式名称/补贴方式名称的getter方法
	 */
	public String getSubsidyTypeName() {
		return subsidyTypeName;
	}
	/**
	 * 属性补贴方式名称/补贴方式名称的setter方法
	 */
	public void setSubsidyTypeName(String subsidyTypeName) {
		this.subsidyTypeName = subsidyTypeName;
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