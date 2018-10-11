package com.sinosoft.dms.core.model.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;

import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-13 11:42:08.278 
 * 模板特别约定表实体操作对象
 */
@Entity
@Table(name = "PrpModelEngageSub")
@IdClass(PrpModelEngageSubKey.class)
public class PrpModelEngageSub extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性模板号码/模板号码 */
	@Id
	@Column(name = "modelCode")
	private String modelCode ;
	/** 属性序号/序号 */
	@Id
	@Column(name = "serialNo")
	private Integer serialNo ;
	/** 属性行序号/行序号 */
	@Id
	@Column(name = "lineNo")
	private Integer lineNo ;

	/** 险种代码  */
	@Column(name = "riskCode")
	private String riskCode;
	/** 属性条款编码 /条款编码  */
	@Column(name = "clauseCode")
	private String clauseCode ;
	/** 属性条款文字描述/条款文字描述 */
	@Column(name = "clauses")
	private String clauses ;
	/** 属性titleFlag/titleFlag */
	@Column(name = "titleFlag")
	private String titleFlag ;
	/** 属性标志字段/标志字段 */
	@Column(name = "flag")
	private String flag ;
	/** 属性clauseName/clauseName */
	@Column(name = "clauseName")
	private String clauseName ;
	/**
	 * 属性模板号码/模板号码的getter方法
	 */
	public String getModelCode() {
		return modelCode;
	}
	/**
	 * 属性模板号码/模板号码的setter方法
	 */
	public void setModelCode(String modelCode) {
		this.modelCode = modelCode;
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
	/**
	 * 属性行序号/行序号的getter方法
	 */
	public Integer getLineNo() {
		return lineNo;
	}
	/**
	 * 属性行序号/行序号的setter方法
	 */
	public void setLineNo(Integer lineNo) {
		this.lineNo = lineNo;
	} 	
	/**
	 * 属性条款编码 /条款编码 的getter方法
	 */
	public String getClauseCode() {
		return clauseCode;
	}
	/**
	 * 属性条款编码 /条款编码 的setter方法
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

	public String getRiskCode() {
		return riskCode;
	}

	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}
}