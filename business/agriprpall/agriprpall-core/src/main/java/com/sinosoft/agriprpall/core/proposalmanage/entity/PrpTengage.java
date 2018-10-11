package com.sinosoft.agriprpall.core.proposalmanage.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;

import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail yanghang@sinosoft.com.cn
 * @time  2017-10-19 06:31:19.937 
 * 特别约定表实体操作对象
 */
@Entity
@Table(name = "PrpTengage")
@IdClass(PrpTengageKey.class)
public class PrpTengage extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性投保单号码/投保单号码 */
	@Id
	@Column(name = "proposalNo")
	private String proposalNo ;/** 属性序号/序号 */
	@Id
	@Column(name = "serialNo")
	private Integer serialNo ;/** 属性行序号/行序号 */
	@Id
	@Column(name = "lineNo")
	private Integer lineNo ;

	/** 属性险种代码/险种代码 */
	@Column(name = "riskCode")
	private String riskCode ;


	/** 属性条款编码/条款编码 */
	@Column(name = "clauseCode")
	private String clauseCode ;
	/** 属性条款文字描述/条款文字描述 */
	@Column(name = "clauses")
	private String clauses ;
	/** 属性titleFlag/titleFlag */
	@Column(name = "titleFlag")
	private String titleFlag ;
	/** 属性flag/flag */
	@Column(name = "flag")
	private String flag ;
	/** 属性clauseName/clauseName */
	@Column(name = "clauseName")
	private String clauseName ;
	/**
	 * 属性投保单号码/投保单号码的getter方法
	 */
	public String getProposalNo() {
		return proposalNo;
	}
	/**
	 * 属性投保单号码/投保单号码的setter方法
	 */
	public void setProposalNo(String proposalNo) {
		this.proposalNo = proposalNo;
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
	 * 属性序号/序号的getter方法
	 */
	public Integer getSerialNo() {
		return serialNo;
	}
	/**
	 * 属性序号/序号的setter方法
	 */
	public void setSerialNo(Integer serialNo) {
		this.serialNo = serialNo;
	}

	public Integer getLineNo() {
		return lineNo;
	}

	public void setLineNo(Integer lineNo) {
		this.lineNo = lineNo;
	}

	/**
	 * 属性条款编码/条款编码的getter方法
	 */
	public String getClauseCode() {
		return clauseCode;
	}
	/**
	 * 属性条款编码/条款编码的setter方法
	 */
	public void setClauseCode(String clauseCode) {
		this.clauseCode = clauseCode;
	} 	
	/**
	 * 属性条款文字描述/条款文字描述的getter方法
	 */
	public String getClauses() {
		return clauses;
	}
	/**
	 * 属性条款文字描述/条款文字描述的setter方法
	 */
	public void setClauses(String clauses) {
		this.clauses = clauses;
	} 	
	/**
	 * 属性titleFlag/titleFlag的getter方法
	 */
	public String getTitleFlag() {
		return titleFlag;
	}
	/**
	 * 属性titleFlag/titleFlag的setter方法
	 */
	public void setTitleFlag(String titleFlag) {
		this.titleFlag = titleFlag;
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
	/**
	 * 属性clauseName/clauseName的getter方法
	 */
	public String getClauseName() {
		return clauseName;
	}
	/**
	 * 属性clauseName/clauseName的setter方法
	 */
	public void setClauseName(String clauseName) {
		this.clauseName = clauseName;
	} 	
}