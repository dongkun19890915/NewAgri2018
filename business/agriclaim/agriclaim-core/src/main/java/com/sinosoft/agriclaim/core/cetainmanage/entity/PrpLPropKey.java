package com.sinosoft.agriclaim.core.cetainmanage.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:36:28.690 
 * 财产核定损明细清单表主键操作对象
 */
public class PrpLPropKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpLPropKey(){}
	public PrpLPropKey(java.lang.Integer serialNo,String registNo,String lossItemCode){
		this.serialNo = serialNo;
		this.registNo = registNo;
		this.lossItemCode = lossItemCode;
	}
	/** 属性序号/序号 */
	@Column(name = "serialNo")
	private java.lang.Integer serialNo ;
	/** 属性报案号/报案号 */
	@Column(name = "registNo")
	private String registNo ;
	/** 属性损失项目类别/损失项目类别 */
	@Column(name = "lossItemCode")
	private String lossItemCode ;
	/**
	 * 属性序号/序号的getter方法
	 */
	public java.lang.Integer getSerialNo() {
    		return serialNo;
	}
	/**
	 * 属性序号/序号的setter方法
	 */
	public void setSerialNo(java.lang.Integer serialNo) {
		this.serialNo = serialNo;
	} 
	/**
	 * 属性报案号/报案号的getter方法
	 */
	public String getRegistNo() {
    		return registNo;
	}
	/**
	 * 属性报案号/报案号的setter方法
	 */
	public void setRegistNo(String registNo) {
		this.registNo = registNo;
	} 
	/**
	 * 属性损失项目类别/损失项目类别的getter方法
	 */
	public String getLossItemCode() {
    		return lossItemCode;
	}
	/**
	 * 属性损失项目类别/损失项目类别的setter方法
	 */
	public void setLossItemCode(String lossItemCode) {
		this.lossItemCode = lossItemCode;
	} 
}