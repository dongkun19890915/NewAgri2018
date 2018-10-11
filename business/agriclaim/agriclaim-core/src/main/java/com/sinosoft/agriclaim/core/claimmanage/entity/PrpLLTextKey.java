package com.sinosoft.agriclaim.core.claimmanage.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:39:53.061 
 * 立案文字表主键操作对象
 */
public class PrpLLTextKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpLLTextKey(){}
	public PrpLLTextKey(String claimNo,String textType,java.lang.Integer lineNo){
		this.claimNo = claimNo;
		this.textType = textType;
		this.lineNo = lineNo;
	}
	/** 属性立案号码/立案号码 */
	@Column(name = "claimNo")
	private String claimNo ;
	/** 属性文字说明类型/文字说明类型 */
	@Column(name = "textType")
	private String textType ;
	/** 属性行号/行号 */
	@Column(name = "lineNo")
	private java.lang.Integer lineNo ;
	/**
	 * 属性立案号码/立案号码的getter方法
	 */
	public String getClaimNo() {
    		return claimNo;
	}
	/**
	 * 属性立案号码/立案号码的setter方法
	 */
	public void setClaimNo(String claimNo) {
		this.claimNo = claimNo;
	} 
	/**
	 * 属性文字说明类型/文字说明类型的getter方法
	 */
	public String getTextType() {
    		return textType;
	}
	/**
	 * 属性文字说明类型/文字说明类型的setter方法
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