package com.sinosoft.agriclaim.core.checkmanage.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:38:49.324 
 * 调查文本信息表主键操作对象
 */
public class PrpLAcciCheckTextKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpLAcciCheckTextKey(){}
	public PrpLAcciCheckTextKey(String checkNo,String textType,java.lang.Integer lineNo){
		this.checkNo = checkNo;
		this.textType = textType;
		this.lineNo = lineNo;
	}
	/** 属性查勘序号/查勘序号 */
	@Column(name = "checkNo")
	private String checkNo ;
	/** 属性文本类型/文本类型 */
	@Column(name = "textType")
	private String textType ;
	/** 属性行号/行号 */
	@Column(name = "lineNo")
	private java.lang.Integer lineNo ;
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
}