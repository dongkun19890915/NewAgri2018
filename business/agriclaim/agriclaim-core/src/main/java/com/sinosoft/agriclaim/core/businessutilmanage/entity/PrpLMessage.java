package com.sinosoft.agriclaim.core.businessutilmanage.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:35:28.283 
 * 理赔流转讨论留言表实体操作对象
 */
@Entity
@Table(name = "PrpLMessage")
@IdClass(PrpLMessageKey.class)
public class PrpLMessage extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性报案号码/报案号码 */
	@Id
	@Column(name = "registNo")
	private String registNo ;/** 属性序号/序号 */
	@Id
	@Column(name = "serialNo")
	private java.lang.Integer serialNo ;/** 属性行号/行号 */
	@Id
	@Column(name = "lineNo")
	private java.lang.Integer lineNo ;	



	/** 属性立案号码/立案号码 */
	@Column(name = "claimNo")
	private String claimNo ;
	/** 属性险种代码/险种代码 */
	@Column(name = "riskCode")
	private String riskCode ;
	/** 属性保单号码/保单号码 */
	@Column(name = "policyNo")
	private String policyNo ;
	/** 属性节点种类/节点种类 */
	@Column(name = "nodeType")
	private String nodeType ;
	/** 属性计算机输单日期/计算机输单日期 */
	@Column(name = "inputDate")
	private java.util.Date inputDate ;
	/** 属性操作员代码/操作员代码 */
	@Column(name = "operatorCode")
	private String operatorCode ;
	/** 属性操作员名称/操作员名称 */
	@Column(name = "operatorName")
	private String operatorName ;
	/** 属性内容/内容 */
	@Column(name = "context")
	private String context ;
	/** 属性标志字段/标志字段 */
	@Column(name = "flag")
	private String flag ;




	/**
	 * 属性报案号码/报案号码的getter方法
	 */
	public String getRegistNo() {
		return registNo;
	}
	/**
	 * 属性报案号码/报案号码的setter方法
	 */
	public void setRegistNo(String registNo) {
		this.registNo = registNo;
	} 	
	/**
	 * 属性序号/序号的getter方法
	 */
	public java.lang.Integer getSerialNo() {
		return serialNo;
	}
	/**
	 * 属性序号/序号的setter方法
	 */
	public void setSerialNo(java.lang.Integer serialNo) {
		this.serialNo = serialNo;
	} 	
	/**
	 * 属性行号/行号的getter方法
	 */
	public java.lang.Integer getLineNo() {
		return lineNo;
	}
	/**
	 * 属性行号/行号的setter方法
	 */
	public void setLineNo(java.lang.Integer lineNo) {
		this.lineNo = lineNo;
	} 	
	/**
	 * 属性立案号码/立案号码的getter方法
	 */
	public String getClaimNo() {
		return claimNo;
	}
	/**
	 * 属性立案号码/立案号码的setter方法
	 */
	public void setClaimNo(String claimNo) {
		this.claimNo = claimNo;
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
	 * 属性节点种类/节点种类的getter方法
	 */
	public String getNodeType() {
		return nodeType;
	}
	/**
	 * 属性节点种类/节点种类的setter方法
	 */
	public void setNodeType(String nodeType) {
		this.nodeType = nodeType;
	} 	
	/**
	 * 属性计算机输单日期/计算机输单日期的getter方法
	 */
	public java.util.Date getInputDate() {
		return inputDate;
	}
	/**
	 * 属性计算机输单日期/计算机输单日期的setter方法
	 */
	public void setInputDate(java.util.Date inputDate) {
		this.inputDate = inputDate;
	} 	
	/**
	 * 属性操作员代码/操作员代码的getter方法
	 */
	public String getOperatorCode() {
		return operatorCode;
	}
	/**
	 * 属性操作员代码/操作员代码的setter方法
	 */
	public void setOperatorCode(String operatorCode) {
		this.operatorCode = operatorCode;
	} 	
	/**
	 * 属性操作员名称/操作员名称的getter方法
	 */
	public String getOperatorName() {
		return operatorName;
	}
	/**
	 * 属性操作员名称/操作员名称的setter方法
	 */
	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	} 	
	/**
	 * 属性内容/内容的getter方法
	 */
	public String getContext() {
		return context;
	}
	/**
	 * 属性内容/内容的setter方法
	 */
	public void setContext(String context) {
		this.context = context;
	} 	
	/**
	 * 属性标志字段/标志字段的getter方法
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * 属性标志字段/标志字段的setter方法
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	} 	
		
		
		
		
}