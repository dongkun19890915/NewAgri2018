package com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;

import javax.persistence.Column;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-24 03:06:48.016 
 * 标的子险信息主键操作对象
 */
public class PrpCPitemKindKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpCPitemKindKey(){}
	public PrpCPitemKindKey(String policyNo, Integer itemKindNo){
		this.policyNo = policyNo;
		this.itemKindNo = itemKindNo;
	}
	/** 属性保单号码/保单号码 */
	@Column(name = "policyNo")
	private String policyNo ;
	/** 属性序号/序号 */
	@Column(name = "itemKindNo")
	private Integer itemKindNo ;
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
	public Integer getItemKindNo() {
    		return itemKindNo;
	}
	/**
	 * 属性序号/序号的setter方法
	 */
	public void setItemKindNo(Integer itemKindNo) {
		this.itemKindNo = itemKindNo;
	} 
}