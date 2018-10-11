package com.sinosoft.pms.core.kernel.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-04 10:42:46.546 
 * PrpDkindClause实体操作对象
 */
@Entity
@Table(name = "PrpDkindClause")
@IdClass(PrpDkindClauseKey.class)
public class PrpDkindClause extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性险种代码/险种代码 */
	@Id
	@Column(name = "riskCode")
	private String riskCode ;/** 属性条款类型1 收费/2 不收费/3 附加险条款/4 主险条款/条款类型1 收费/2 不收费/3 附加险条款/4 主险条款 */
	@Id
	@Column(name = "clauseFlag")
	private String clauseFlag ;/** 属性险别代码/险别代码 */
	@Id
	@Column(name = "kindCode")
	private String kindCode ;/** 属性语言/语言 */
	@Id
	@Column(name = "language")
	private String language ;/** 属性条款代码/条款代码 */
	@Id
	@Column(name = "clauseCode")
	private String clauseCode ;	





	/** 属性flag/flag */
	@Column(name = "flag")
	private String flag ;
	/** 属性修改人/修改人 */
	@Column(name = "update_By")
	private String update_By ;
	/** 属性修改时间/修改时间 */
	@Column(name = "update_Date")
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