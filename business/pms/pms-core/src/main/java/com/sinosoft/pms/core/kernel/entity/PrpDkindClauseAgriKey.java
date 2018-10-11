package com.sinosoft.pms.core.kernel.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;

import javax.persistence.Column;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-04 10:42:46.546 
 * PrpDkindClause主键操作对象
 */
public class PrpDkindClauseAgriKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpDkindClauseAgriKey(){}
	public PrpDkindClauseAgriKey(String riskCode, String clauseFlag, String kindCode, String language, String clauseCode){
		this.riskCode = riskCode;
		this.clauseFlag = clauseFlag;
		this.kindCode = kindCode;
		this.language = language;
		this.clauseCode = clauseCode;
	}
	/** 属性险种代码/险种代码 */
	@Column(name = "riskCode")
	private String riskCode ;
	/** 属性条款类型1 收费/2 不收费/3 附加险条款/4 主险条款/条款类型1 收费/2 不收费/3 附加险条款/4 主险条款 */
	@Column(name = "clauseFlag")
	private String clauseFlag ;
	/** 属性险别代码/险别代码 */
	@Column(name = "kindCode")
	private String kindCode ;
	/** 属性语言/语言 */
	@Column(name = "language")
	private String language ;
	/** 属性条款代码/条款代码 */
	@Column(name = "clauseCode")
	private String clauseCode ;
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
	 * 属性条款类型1 收费/2 不收费/3 附加险条款/4 主险条款/条款类型1 收费/2 不收费/3 附加险条款/4 主险条款的getter方法
	 */
	public String getClauseFlag() {
    		return clauseFlag;
	}
	/**
	 * 属性条款类型1 收费/2 不收费/3 附加险条款/4 主险条款/条款类型1 收费/2 不收费/3 附加险条款/4 主险条款的setter方法
	 */
	public void setClauseFlag(String clauseFlag) {
		this.clauseFlag = clauseFlag;
	} 
	/**
	 * 属性险别代码/险别代码的getter方法
	 */
	public String getKindCode() {
    		return kindCode;
	}
	/**
	 * 属性险别代码/险别代码的setter方法
	 */
	public void setKindCode(String kindCode) {
		this.kindCode = kindCode;
	} 
	/**
	 * 属性语言/语言的getter方法
	 */
	public String getLanguage() {
    		return language;
	}
	/**
	 * 属性语言/语言的setter方法
	 */
	public void setLanguage(String language) {
		this.language = language;
	} 
	/**
	 * 属性条款代码/条款代码的getter方法
	 */
	public String getClauseCode() {
    		return clauseCode;
	}
	/**
	 * 属性条款代码/条款代码的setter方法
	 */
	public void setClauseCode(String clauseCode) {
		this.clauseCode = clauseCode;
	} 
}