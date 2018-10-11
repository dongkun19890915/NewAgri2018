package com.sinosoft.pms.core.kernel.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-04 10:42:46.546 
 * 条款代码表实体操作对象
 */
@Entity
@Table(name = "PrpDclause")
@IdClass(PrpDclauseKey.class)
public class PrpDclause extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性条款代码/条款代码 */
	@Id
	@Column(name = "clauseCode")
	private String clauseCode ;/** 属性行号/行号 */
	@Id
	@Column(name = "lineNo")
	private java.lang.Integer lineNo ;	

	/** 属性条款名称/条款名称 */
	@Column(name = "clauseName")
	private String clauseName ;
	/** 属性语种(C/E/…)/语种(C/E/…) */
	@Column(name = "language")
	private String language ;
	/** 属性标题标志：1标题 0内容/标题标志：1标题 0内容 */
	@Column(name = "titleFlag")
	private String titleFlag ;

	/** 属性条款内容/条款内容 */
	@Column(name = "context")
	private String context ;
	/** 属性新条款代码/新条款代码 */
	@Column(name = "newClauseCode")
	private String newClauseCode ;
	/** 属性效力状态(0失效/1有效)/效力状态(0失效/1有效) */
	@Column(name = "validStatus")
	private String validStatus ;
	/** 属性标志字段/标志字段 */
	@Column(name = "flag")
	private String flag ;
	/** 属性适用条件/适用条件 */
	@Column(name = "condition")
	private String condition ;
	/** 属性配置类型/配置类型 */
	@Column(name = "configFlag")
	private String configFlag ;
	/** 属性特约类型/特约类型 */
	@Column(name = "clauseType")
	private String clauseType ;
	/** 属性特约属性/特约属性 */
	@Column(name = "clauseProperty")
	private String clauseProperty ;
	/** 属性制定依据/制定依据 */
	@Column(name = "clauseDBased")
	private String clauseDBased ;
	/** 属性修改人/修改人 */
	@Column(name = "update_By")
	private String update_By ;
	/** 属性修改时间/修改时间 */
	@Column(name = "update_Date")
	private java.util.Date update_Date ;
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
	 * 属性条款名称/条款名称的getter方法
	 */
	public String getClauseName() {
		return clauseName;
	}
	/**
	 * 属性条款名称/条款名称的setter方法
	 */
	public void setClauseName(String clauseName) {
		this.clauseName = clauseName;
	} 	
	/**
	 * 属性语种(C/E/…)/语种(C/E/…)的getter方法
	 */
	public String getLanguage() {
		return language;
	}
	/**
	 * 属性语种(C/E/…)/语种(C/E/…)的setter方法
	 */
	public void setLanguage(String language) {
		this.language = language;
	} 	
	/**
	 * 属性标题标志：1标题 0内容/标题标志：1标题 0内容的getter方法
	 */
	public String getTitleFlag() {
		return titleFlag;
	}
	/**
	 * 属性标题标志：1标题 0内容/标题标志：1标题 0内容的setter方法
	 */
	public void setTitleFlag(String titleFlag) {
		this.titleFlag = titleFlag;
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
	 * 属性条款内容/条款内容的getter方法
	 */
	public String getContext() {
		return context;
	}
	/**
	 * 属性条款内容/条款内容的setter方法
	 */
	public void setContext(String context) {
		this.context = context;
	} 	
	/**
	 * 属性新条款代码/新条款代码的getter方法
	 */
	public String getNewClauseCode() {
		return newClauseCode;
	}
	/**
	 * 属性新条款代码/新条款代码的setter方法
	 */
	public void setNewClauseCode(String newClauseCode) {
		this.newClauseCode = newClauseCode;
	} 	
	/**
	 * 属性效力状态(0失效/1有效)/效力状态(0失效/1有效)的getter方法
	 */
	public String getValidStatus() {
		return validStatus;
	}
	/**
	 * 属性效力状态(0失效/1有效)/效力状态(0失效/1有效)的setter方法
	 */
	public void setValidStatus(String validStatus) {
		this.validStatus = validStatus;
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
	 * 属性适用条件/适用条件的getter方法
	 */
	public String getCondition() {
		return condition;
	}
	/**
	 * 属性适用条件/适用条件的setter方法
	 */
	public void setCondition(String condition) {
		this.condition = condition;
	} 	
	/**
	 * 属性配置类型/配置类型的getter方法
	 */
	public String getConfigFlag() {
		return configFlag;
	}
	/**
	 * 属性配置类型/配置类型的setter方法
	 */
	public void setConfigFlag(String configFlag) {
		this.configFlag = configFlag;
	} 	
	/**
	 * 属性特约类型/特约类型的getter方法
	 */
	public String getClauseType() {
		return clauseType;
	}
	/**
	 * 属性特约类型/特约类型的setter方法
	 */
	public void setClauseType(String clauseType) {
		this.clauseType = clauseType;
	} 	
	/**
	 * 属性特约属性/特约属性的getter方法
	 */
	public String getClauseProperty() {
		return clauseProperty;
	}
	/**
	 * 属性特约属性/特约属性的setter方法
	 */
	public void setClauseProperty(String clauseProperty) {
		this.clauseProperty = clauseProperty;
	} 	
	/**
	 * 属性制定依据/制定依据的getter方法
	 */
	public String getClauseDBased() {
		return clauseDBased;
	}
	/**
	 * 属性制定依据/制定依据的setter方法
	 */
	public void setClauseDBased(String clauseDBased) {
		this.clauseDBased = clauseDBased;
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