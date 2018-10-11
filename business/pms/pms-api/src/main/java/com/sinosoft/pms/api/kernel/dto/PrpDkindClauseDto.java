package com.sinosoft.pms.api.kernel.dto;

import java.io.Serializable;
import java.util.Date;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-04 10:42:46.546 
 * PrpDkindClauseApi操作对象
 */
public class PrpDkindClauseDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性险种代码/险种代码 */
	private String riskCode ;		
	/** 属性条款类型1 收费/2 不收费/3 附加险条款/4 主险条款/条款类型1 收费/2 不收费/3 附加险条款/4 主险条款 */
	private String clauseFlag ;		
	/** 属性险别代码/险别代码 */
	private String kindCode ;		
	/** 属性语言/语言 */
	private String language ;		
	/** 属性条款代码/条款代码 */
	private String clauseCode ;		
	/** 属性flag/flag */
	private String flag ;		
	/** 属性修改人/修改人 */
	private String update_By ;
	/** 属性修改时间/修改时间 */
	private java.util.Date update_Date ;
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
	/**
	 * 属性flag/flag的getter方法
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * 属性flag/flag的setter方法
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getUpdate_By() {
		return update_By;
	}

	public void setUpdate_By(String update_By) {
		this.update_By = update_By;
	}

	public Date getUpdate_Date() {
		return update_Date;
	}

	public void setUpdate_Date(Date update_Date) {
		this.update_Date = update_Date;
	}
}
