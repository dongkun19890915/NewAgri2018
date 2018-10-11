package com.sinosoft.pms.core.kernel.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-04 10:42:46.546 
 * PrpDriskClauseKind主键操作对象
 */
public class PrpDriskClauseKindKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpDriskClauseKindKey(){}
	public PrpDriskClauseKindKey(String riskCode,java.lang.Integer riskKcSerialNo,String clauseCode){
		this.riskCode = riskCode;
		this.riskKcSerialNo = riskKcSerialNo;
		this.clauseCode = clauseCode;
	}
	/** 属性riskCode/riskCode */
	@Column(name = "riskCode")
	private String riskCode ;
	/** 属性riskkcserialNo/riskkcserialNo */
	@Column(name = "riskKcSerialNo")
	private java.lang.Integer riskKcSerialNo ;
	/** 属性clauseCode/clauseCode */
	@Column(name = "clauseCode")
	private String clauseCode ;
	/**
	 * 属性riskCode/riskCode的getter方法
	 */
	public String getRiskCode() {
    		return riskCode;
	}
	/**
	 * 属性riskCode/riskCode的setter方法
	 */
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	} 
	/**
	 * 属性riskkcserialNo/riskkcserialNo的getter方法
	 */
	public java.lang.Integer getRiskKcSerialNo() {
    		return riskKcSerialNo;
	}
	/**
	 * 属性riskkcserialNo/riskkcserialNo的setter方法
	 */
	public void setRiskKcSerialNo(java.lang.Integer riskKcSerialNo) {
		this.riskKcSerialNo = riskKcSerialNo;
	} 
	/**
	 * 属性clauseCode/clauseCode的getter方法
	 */
	public String getClauseCode() {
    		return clauseCode;
	}
	/**
	 * 属性clauseCode/clauseCode的setter方法
	 */
	public void setClauseCode(String clauseCode) {
		this.clauseCode = clauseCode;
	} 
}