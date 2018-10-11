package com.sinosoft.agriclaim.core.registmanage.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:45:22.527 
 * 报案文字表主键操作对象
 */
public class PrpLRegistTextKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpLRegistTextKey(){}
	public PrpLRegistTextKey(String registNo,String textType,java.lang.Integer lineNo){
		this.registNo = registNo;
		this.textType = textType;
		this.lineNo = lineNo;
	}
	/** 属性报案号/报案号 */
	@Column(name = "registNo")
	private String registNo ;
	/** 属性文本类型/文本类型 */
	@Column(name = "textType")
	private String textType ;
	/** 属性行号/行号 */
	@Column(name = "lineNo")
	private java.lang.Integer lineNo ;
	/**
	 * 属性报案号/报案号的getter方法
	 */
	public String getRegistNo() {
    		return registNo;
	}
	/**
	 * 属性报案号/报案号的setter方法
	 */
	public void setRegistNo(String registNo) {
		this.registNo = registNo;
	} 
	/**
	 * 属性文本类型/文本类型的getter方法
	 */
	public String getTextType() {
    		return textType;
	}
	/**
	 * 属性文本类型/文本类型的setter方法
	 */
	public void setTextType(String textType) {
		this.textType = textType;
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