package com.sinosoft.agriclaim.core.prepaymanage.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:44:02.119 
 * 预赔文字表主键操作对象
 */
public class PrpLPtextKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpLPtextKey(){}
	public PrpLPtextKey(String preCompensateNo,java.lang.Double lineNo){
		this.preCompensateNo = preCompensateNo;
		this.lineNo = lineNo;
	}
	/** 属性预赔登记号/预赔登记号 */
	@Column(name = "preCompensateNo")
	private String preCompensateNo ;
	/** 属性行号/行号 */
	@Column(name = "lineNo")
	private java.lang.Double lineNo ;
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
}