package com.sinosoft.agriclaim.core.compensatemanage.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:40:44.225 
 * 养殖险理赔明细表主键操作对象
 */
public class HerdSettleListKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public HerdSettleListKey(){}
	public HerdSettleListKey(String settlelistCode,String earlabel,String fCode,String kindCode,java.lang.Integer serialNo){
		this.settlelistCode = settlelistCode;
		this.earlabel = earlabel;
		this.fCode = fCode;
		this.kindCode = kindCode;
		this.serialNo = serialNo;
	}
	/** 属性理赔清单号/理赔清单号 */
	@Column(name = "settlelistCode")
	private String settlelistCode ;
	/** 属性耳标号/耳标号 */
	@Column(name = "earlabel")
	private String earlabel ;
	/** 属性农户代码/农户代码 */
	@Column(name = "fCode")
	private String fCode ;
	/** 属性险别序号/险别序号 */
	@Column(name = "kindCode")
	private String kindCode ;
	/** 属性序号/序号 */
	@Column(name = "serialNo")
	private java.lang.Integer serialNo ;
	/**
	 * 属性理赔清单号/理赔清单号的getter方法
	 */
	public String getSettlelistCode() {
    		return settlelistCode;
	}
	/**
	 * 属性理赔清单号/理赔清单号的setter方法
	 */
	public void setSettlelistCode(String settlelistCode) {
		this.settlelistCode = settlelistCode;
	} 
	/**
	 * 属性耳标号/耳标号的getter方法
	 */
	public String getEarlabel() {
    		return earlabel;
	}
	/**
	 * 属性耳标号/耳标号的setter方法
	 */
	public void setEarlabel(String earlabel) {
		this.earlabel = earlabel;
	} 
	/**
	 * 属性农户代码/农户代码的getter方法
	 */
	public String getFCode() {
    		return fCode;
	}
	/**
	 * 属性农户代码/农户代码的setter方法
	 */
	public void setFCode(String fCode) {
		this.fCode = fCode;
	} 
	/**
	 * 属性险别序号/险别序号的getter方法
	 */
	public String getKindCode() {
    		return kindCode;
	}
	/**
	 * 属性险别序号/险别序号的setter方法
	 */
	public void setKindCode(String kindCode) {
		this.kindCode = kindCode;
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