package com.sinosoft.pms.core.kernel.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-09-15 06:11:49.790 
 * 自动生成特约主表主键操作对象
 */
public class PrpDautoClauseKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpDautoClauseKey(){}
	public PrpDautoClauseKey(String comCode,String riskCode,String clauseCode){
		this.comCode = comCode;
		this.riskCode = riskCode;
		this.clauseCode = clauseCode;
	}
	/** 属性机构代码/机构代码 */
	private String comCode ;
	/** 属性险种代码/险种代码 */
	private String riskCode ;
	/** 属性特约代码/特约代码 */
	private String clauseCode ;
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
	 * 属性特约代码/特约代码的getter方法
	 */
	public String getClauseCode() {
    		return clauseCode;
	}
	/**
	 * 属性特约代码/特约代码的setter方法
	 */
	public void setClauseCode(String clauseCode) {
		this.clauseCode = clauseCode;
	} 
}