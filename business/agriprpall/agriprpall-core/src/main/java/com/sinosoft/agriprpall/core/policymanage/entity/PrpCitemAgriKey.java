package com.sinosoft.agriprpall.core.policymanage.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-26 00:32:45.064 
 * PrpCitemAgri主键操作对象
 */
public class PrpCitemAgriKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpCitemAgriKey(){}
	public PrpCitemAgriKey(String policyNo,Integer itemNo){
		this.policyNo = policyNo;
		this.itemNo = itemNo;
	}
	/** 属性保单号/保单号 */
	@Column(name = "policyNo")
	private String policyNo ;
	/** 属性标号/标号 */
	@Column(name = "itemNo")
	private Integer itemNo ;
	/**
	 * 属性保单号/保单号的getter方法
	 */
	public String getPolicyNo() {
    		return policyNo;
	}
	/**
	 * 属性保单号/保单号的setter方法
	 */
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	} 
	/**
	 * 属性标号/标号的getter方法
	 */
	public Integer getItemNo() {
    		return itemNo;
	}
	/**
	 * 属性标号/标号的setter方法
	 */
	public void setItemNo(Integer itemNo) {
		this.itemNo = itemNo;
	} 
}