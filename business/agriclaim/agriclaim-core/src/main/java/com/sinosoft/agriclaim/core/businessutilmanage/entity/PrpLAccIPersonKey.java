package com.sinosoft.agriclaim.core.businessutilmanage.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:35:28.283 
 * 索赔申请人信息表主键操作对象
 */
public class PrpLAccIPersonKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpLAccIPersonKey(){}
	public PrpLAccIPersonKey(String certiNo,String certiType,java.lang.Integer serialNo){
		this.certiNo = certiNo;
		this.certiType = certiType;
		this.serialNo = serialNo;
	}
	/** 属性业务号/业务号 */
	@Column(name = "certiNo")
	private String certiNo ;
	/** 属性业务类型/业务类型 */
	@Column(name = "certiType")
	private String certiType ;
	/** 属性序号/序号 */
	@Column(name = "serialNo")
	private java.lang.Integer serialNo ;
	/**
	 * 属性业务号/业务号的getter方法
	 */
	public String getCertiNo() {
    		return certiNo;
	}
	/**
	 * 属性业务号/业务号的setter方法
	 */
	public void setCertiNo(String certiNo) {
		this.certiNo = certiNo;
	} 
	/**
	 * 属性业务类型/业务类型的getter方法
	 */
	public String getCertiType() {
    		return certiType;
	}
	/**
	 * 属性业务类型/业务类型的setter方法
	 */
	public void setCertiType(String certiType) {
		this.certiType = certiType;
	} 
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
}