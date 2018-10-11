package com.sinosoft.agriclaim.core.compensatemanage.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:40:44.225 
 * 赔款计算文字表主键操作对象
 */
public class PrpLCTextKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpLCTextKey(){}
	public PrpLCTextKey(String compensateNo,String textType,java.lang.Integer lineNo){
		this.compensateNo = compensateNo;
		this.textType = textType;
		this.lineNo = lineNo;
	}
	/** 属性赔款计算书号/赔款计算书号 */
	@Column(name = "compensateNo")
	private String compensateNo ;
	/** 属性文字说明类型/文字说明类型 */
	@Column(name = "textType")
	private String textType ;
	/** 属性行号/行号 */
	@Column(name = "lineNo")
	private java.lang.Integer lineNo ;
	/**
	 * 属性赔款计算书号/赔款计算书号的getter方法
	 */
	public String getCompensateNo() {
    		return compensateNo;
	}
	/**
	 * 属性赔款计算书号/赔款计算书号的setter方法
	 */
	public void setCompensateNo(String compensateNo) {
		this.compensateNo = compensateNo;
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