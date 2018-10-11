package com.sinosoft.dms.api.dict.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-13 07:26:32.841 
 * 模板特别约定表Api操作对象
 */
public class PrpModelEngageDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性模板号码/模板号码 */
	private String modelCode ;		
	/** 属性序号/序号 */
	private Integer serialNo ;
	/** 属性行序号/行序号 */
	private Integer lineNo ;
	/** 属性条款编码 /条款编码  */
	private String clauseCode ;		
	/** 属性条款文字描述/条款文字描述 */
	private String clauses ;		
	/** 属性titleFlag/titleFlag */
	private String titleFlag ;		
	/** 属性标志字段/标志字段 */
	private String flag ;		
	/** 属性clauseName/clauseName */
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
}
