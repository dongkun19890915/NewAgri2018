package com.sinosoft.agriclaim.core.docmanage.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;

import javax.persistence.Column;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-10 02:44:49.773 
 * 索赔指引表主键操作对象
 */
public class PrplCertifyDirectKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrplCertifyDirectKey(){}
	public PrplCertifyDirectKey(String registNo,Integer serialNo,String lossItemCode){
		this.registNo = registNo;
		this.serialNo = serialNo;
		this.lossItemCode = lossItemCode;
	}
	/** 属性报案号码/报案号码 */
	@Column(name = "registNo")
	private String registNo ;
	/** 属性序号/序号 */
	@Column(name = "serialNo")
	private Integer serialNo ;
	/** 属性标的代码/标的代码 */
	@Column(name = "lossItemCode")
	private String lossItemCode ;
	/**
	 * 属性报案号码/报案号码的getter方法
	 */
	public String getRegistNo() {
    		return registNo;
	}
	/**
	 * 属性报案号码/报案号码的setter方法
	 */
	public void setRegistNo(String registNo) {
		this.registNo = registNo;
	}
	/**
	 * 属性序号/序号的getter方法
	 */
	public Integer getSerialNo() {
    		return serialNo;
	}
	/**
	 * 属性序号/序号的setter方法
	 */
	public void setSerialNo(Integer serialNo) {
		this.serialNo = serialNo;
	} 
	/**
	 * 属性标的代码/标的代码的getter方法
	 */
	public String getLossItemCode() {
    		return lossItemCode;
	}
	/**
	 * 属性标的代码/标的代码的setter方法
	 */
	public void setLossItemCode(String lossItemCode) {
		this.lossItemCode = lossItemCode;
	} 
}