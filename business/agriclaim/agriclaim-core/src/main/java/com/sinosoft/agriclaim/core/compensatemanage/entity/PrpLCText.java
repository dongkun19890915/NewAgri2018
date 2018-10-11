package com.sinosoft.agriclaim.core.compensatemanage.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:40:44.225 
 * 赔款计算文字表实体操作对象
 */
@Entity
@Table(name = "PrpLCText")
@IdClass(PrpLCTextKey.class)
public class PrpLCText extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性赔款计算书号/赔款计算书号 */
	@Id
	@Column(name = "compensateNo")
	private String compensateNo ;/** 属性文字说明类型/文字说明类型 */
	@Id
	@Column(name = "textType")
	private String textType ;/** 属性行号/行号 */
	@Id
	@Column(name = "lineNo")
	private java.lang.Integer lineNo ;	



	/** 属性文字说明/文字说明 */
	@Column(name = "context")
	private String context ;
	/** 属性标志字段/标志字段 */
	@Column(name = "flag")
	private String flag ;
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