package com.sinosoft.pms.core.productrule.entity;

import com.sinosoft.framework.core.dao.BasePK;

import java.util.Date;
/**
 * @author codegen@研发中心
 * @mail handongwei@sinosoft.com.cn
 * @time  2016-09-18 20:27:00.111 
 * UtiFormula 主键操作类
 */
public class UtiFormulaKey implements BasePK,java.io.Serializable {
	private static final long serialVersionUID = 1L;
	/** 属性RiskCode/ */
	private String riskCode ;
	/** 属性ClauseCode/ */
	private String clauseCode ;
	/** 属性KindCode/ */
	private String kindCode ;
	/** 属性ComCode/ */
	private String comCode ;
	/** 属性CalFormulaType/ */
	private String calFormulaType ;
	/** 属性FormulaType/ */
	private String formulaType ;
	/** 属性FactorCode/ */
	private String factorCode ;
	/**
	 * 属性RiskCode/的getter方法
	 */
	public String getRiskCode() {
		return riskCode;
	}
	/**
	 * 属性RiskCode/的setter方法
	 */
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	} 
	/**
	 * 属性ClauseCode/的getter方法
	 */
	public String getClauseCode() {
		return clauseCode;
	}
	/**
	 * 属性ClauseCode/的setter方法
	 */
	public void setClauseCode(String clauseCode) {
		this.clauseCode = clauseCode;
	} 
	/**
	 * 属性KindCode/的getter方法
	 */
	public String getKindCode() {
		return kindCode;
	}
	/**
	 * 属性KindCode/的setter方法
	 */
	public void setKindCode(String kindCode) {
		this.kindCode = kindCode;
	} 
	/**
	 * 属性ComCode/的getter方法
	 */
	public String getComCode() {
		return comCode;
	}
	/**
	 * 属性ComCode/的setter方法
	 */
	public void setComCode(String comCode) {
		this.comCode = comCode;
	} 
	/**
	 * 属性CalFormulaType/的getter方法
	 */
	public String getCalFormulaType() {
		return calFormulaType;
	}
	/**
	 * 属性CalFormulaType/的setter方法
	 */
	public void setCalFormulaType(String calFormulaType) {
		this.calFormulaType = calFormulaType;
	} 
	/**
	 * 属性FormulaType/的getter方法
	 */
	public String getFormulaType() {
		return formulaType;
	}
	/**
	 * 属性FormulaType/的setter方法
	 */
	public void setFormulaType(String formulaType) {
		this.formulaType = formulaType;
	} 
	/**
	 * 属性FactorCode/的getter方法
	 */
	public String getFactorCode() {
		return factorCode;
	}
	/**
	 * 属性FactorCode/的setter方法
	 */
	public void setFactorCode(String factorCode) {
		this.factorCode = factorCode;
	} 
}