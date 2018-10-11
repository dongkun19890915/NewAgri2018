package com.sinosoft.agriclaim.api.registmanage.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:45:22.527 
 * 报案文字表Api操作对象
 */
public class PrpLRegistTextDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性报案号/报案号 */
	private String registNo ;		
	/** 属性文本类型/文本类型 */
	private String textType ;		
	/** 属性行号/行号 */
	private java.lang.Integer lineNo ;		
	/** 属性内容/内容 */
	private String context ;		
	/** 属性标志位/标志位 */
	private String flag ;		
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
	/**
	 * 属性内容/内容的getter方法
	 */
	public String getContext() {
		return context;
	}
	/**
	 * 属性内容/内容的setter方法
	 */
	public void setContext(String context) {
		this.context = context;
	}	
	/**
	 * 属性标志位/标志位的getter方法
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * 属性标志位/标志位的setter方法
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}	
}
