package com.sinosoft.agriprpall.core.policymanage.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:01:20.710 
 * 原始保单标的子险表主键操作对象
 */
public class PrpCitemKindOriginKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpCitemKindOriginKey(){}
	public PrpCitemKindOriginKey(String policyNo,java.lang.Integer itemKindNo){
		this.policyNo = policyNo;
		this.itemKindNo = itemKindNo;
	}
	/** 属性保单号码/保单号码 */
	@Column(name = "policyNo")
	private String policyNo ;
	/** 属性序号/序号 */
	@Column(name = "itemKindNo")
	private java.lang.Integer itemKindNo ;
	/**
	 * 属性保单号码/保单号码的getter方法
	 */
	public String getPolicyNo() {
    		return policyNo;
	}
	/**
	 * 属性保单号码/保单号码的setter方法
	 */
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	} 
	/**
	 * 属性序号/序号的getter方法
	 */
	public java.lang.Integer getItemKindNo() {
    		return itemKindNo;
	}
	/**
	 * 属性序号/序号的setter方法
	 */
	public void setItemKindNo(java.lang.Integer itemKindNo) {
		this.itemKindNo = itemKindNo;
	} 
}