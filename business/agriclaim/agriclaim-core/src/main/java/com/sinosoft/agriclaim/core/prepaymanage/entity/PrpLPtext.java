package com.sinosoft.agriclaim.core.prepaymanage.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:44:02.119 
 * 预赔文字表实体操作对象
 */
@Entity
@Table(name = "PrpLPtext")
@IdClass(PrpLPtextKey.class)
public class PrpLPtext extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性预赔登记号/预赔登记号 */
	@Id
	@Column(name = "preCompensateNo")
	private String preCompensateNo ;/** 属性行号/行号 */
	@Id
	@Column(name = "lineNo")
	private java.lang.Double lineNo ;	


	/** 属性文字说明/文字说明 */
	@Column(name = "context")
	private String context ;
	/** 属性标志字段/标志字段 */
	@Column(name = "flag")
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