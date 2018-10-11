package com.sinosoft.pms.core.kernel.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-07 03:36:19.515 
 * 条款险别配置表主键操作对象
 */
public class PrpDclauseCodeKindKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpDclauseCodeKindKey(){}
	public PrpDclauseCodeKindKey(String clauseCode,java.lang.Double serialNo,String kindCode){
		this.clauseCode = clauseCode;
		this.serialNo = serialNo;
		this.kindCode = kindCode;
	}
	/** 属性条款代码/条款代码 */
	@Column(name = "ClauseCode")
	private String clauseCode ;
	/** 属性序列号/序列号 */
	@Column(name = "SerialNo")
	private java.lang.Double serialNo ;
	/** 属性险别代码/险别代码 */
	@Column(name = "KindCode")
	private String kindCode ;
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
	 * 属性序列号/序列号的getter方法
	 */
	public java.lang.Double getSerialNo() {
    		return serialNo;
	}
	/**
	 * 属性序列号/序列号的setter方法
	 */
	public void setSerialNo(java.lang.Double serialNo) {
		this.serialNo = serialNo;
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
}