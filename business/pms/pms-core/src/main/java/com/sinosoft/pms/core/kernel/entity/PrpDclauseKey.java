package com.sinosoft.pms.core.kernel.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-04 10:42:46.546 
 * 条款代码表主键操作对象
 */
public class PrpDclauseKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpDclauseKey(){}
	public PrpDclauseKey(String clauseCode,java.lang.Integer lineNo){
		this.clauseCode = clauseCode;
		this.lineNo = lineNo;
	}
	/** 属性条款代码/条款代码 */
	@Column(name = "clauseCode")
	private String clauseCode ;
	/** 属性行号/行号 */
	@Column(name = "lineNo")
	private java.lang.Integer lineNo ;
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
}