package com.sinosoft.agriclaim.api.prepaymanage.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:44:02.119 
 * 预赔文字表Api操作对象
 */
public class PrpLPtextDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性预赔登记号/预赔登记号 */
	private String preCompensateNo ;		
	/** 属性行号/行号 */
	private java.lang.Double lineNo ;		
	/** 属性文字说明/文字说明 */
	private String context ;		
	/** 属性标志字段/标志字段 */
	private String flag ;		
	/**
	 * 属性预赔登记号/预赔登记号的getter方法
	 */
	public String getPreCompensateNo() {
		return preCompensateNo;
	}
	/**
	 * 属性预赔登记号/预赔登记号的setter方法
	 */
	public void setPreCompensateNo(String preCompensateNo) {
		this.preCompensateNo = preCompensateNo;
	}	
	/**
	 * 属性行号/行号的getter方法
	 */
	public java.lang.Double getLineNo() {
		return lineNo;
	}
	/**
	 * 属性行号/行号的setter方法
	 */
	public void setLineNo(java.lang.Double lineNo) {
		this.lineNo = lineNo;
	}	
	/**
	 * 属性文字说明/文字说明的getter方法
	 */
	public String getContext() {
		return context;
	}
	/**
	 * 属性文字说明/文字说明的setter方法
	 */
	public void setContext(String context) {
		this.context = context;
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
}
