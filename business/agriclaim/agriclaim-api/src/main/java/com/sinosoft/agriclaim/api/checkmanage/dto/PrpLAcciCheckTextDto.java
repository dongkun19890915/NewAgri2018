package com.sinosoft.agriclaim.api.checkmanage.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:38:49.324 
 * 调查文本信息表Api操作对象
 */
public class PrpLAcciCheckTextDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性查勘序号/查勘序号 */
	private String checkNo ;		
	/** 属性文本类型/文本类型 */
	private String textType ;		
	/** 属性行号/行号 */
	private java.lang.Integer lineNo ;		
	/** 属性查勘文本/查勘文本 */
	private String context ;		
	/** 属性标志/标志 */
	private String flag ;		
	/**
	 * 属性查勘序号/查勘序号的getter方法
	 */
	public String getCheckNo() {
		return checkNo;
	}
	/**
	 * 属性查勘序号/查勘序号的setter方法
	 */
	public void setCheckNo(String checkNo) {
		this.checkNo = checkNo;
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
	 * 属性查勘文本/查勘文本的getter方法
	 */
	public String getContext() {
		return context;
	}
	/**
	 * 属性查勘文本/查勘文本的setter方法
	 */
	public void setContext(String context) {
		this.context = context;
	}	
	/**
	 * 属性标志/标志的getter方法
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * 属性标志/标志的setter方法
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}	
}
