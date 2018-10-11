package com.sinosoft.pms.core.kernel.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;

/**
 * @author codegen@研发中心
 * @mail sucong13146@sinosoft.com.cn
 * @time  2017-09-12 12:28:37.662 
 * 自动生成特约校验规则表主键操作对象
 */
public class PrpDautoClauseRuleKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpDautoClauseRuleKey(){}
	public PrpDautoClauseRuleKey(String comCode,String riskCode,String clauseCode,String groupNo,String serialNo){
		this.comCode = comCode;
		this.riskCode = riskCode;
		this.clauseCode = clauseCode;
		this.groupNo = groupNo;
		this.serialNo = serialNo;
	}
	/** 属性机构代码/机构代码 */
	private String comCode ;
	/** 属性险种代码/险种代码 */
	private String riskCode ;
	/** 属性特约代码/特约代码 */
	private String clauseCode ;
	/** 属性分组号/分组号 */
	private String groupNo ;
	/** 属性顺序号/顺序号 */
	private String serialNo ;
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
	/**
	 * 属性分组号/分组号的getter方法
	 */
	public String getGroupNo() {
    		return groupNo;
	}
	/**
	 * 属性分组号/分组号的setter方法
	 */
	public void setGroupNo(String groupNo) {
		this.groupNo = groupNo;
	} 
	/**
	 * 属性顺序号/顺序号的getter方法
	 */
	public String getSerialNo() {
    		return serialNo;
	}
	/**
	 * 属性顺序号/顺序号的setter方法
	 */
	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	} 
}