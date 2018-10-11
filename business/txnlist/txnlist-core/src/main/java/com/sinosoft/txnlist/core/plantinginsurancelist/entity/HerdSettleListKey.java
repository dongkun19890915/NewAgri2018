package com.sinosoft.txnlist.core.plantinginsurancelist.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-18 08:36:26.740 
 * 养殖险理赔明细表主键操作对象
 */
public class HerdSettleListKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public HerdSettleListKey(){}
	public HerdSettleListKey(String settleListCode,String earLabel,String fCode,String kindCode,java.lang.Integer serialNo){
		this.settleListCode = settleListCode;
		this.earLabel = earLabel;
		this.fCode = fCode;
		this.kindCode = kindCode;
		this.serialNo = serialNo;
	}
	/** 属性理赔清单号，以4开头/理赔清单号，以4开头 */
	@Column(name = "settleListCode")
	private String settleListCode ;
	/** 属性耳标号/耳标号 */
	@Column(name = "earLabel")
	private String earLabel ;
	/** 属性农户代码/农户代码 */
	@Column(name = "fCode")
	private String fCode ;
	/** 属性险别序号/险别序号 */
	@Column(name = "kindCode")
	private String kindCode ;
	/** 属性序号(支持两条理赔数据)/序号(支持两条理赔数据) */
	@Column(name = "serialNo")
	private java.lang.Integer serialNo ;
	/**
	 * 属性理赔清单号，以4开头/理赔清单号，以4开头的getter方法
	 */
	public String getSettleListCode() {
    		return settleListCode;
	}
	/**
	 * 属性理赔清单号，以4开头/理赔清单号，以4开头的setter方法
	 */
	public void setSettleListCode(String settleListCode) {
		this.settleListCode = settleListCode;
	} 
	/**
	 * 属性耳标号/耳标号的getter方法
	 */
	public String getEarLabel() {
    		return earLabel;
	}
	/**
	 * 属性耳标号/耳标号的setter方法
	 */
	public void setEarLabel(String earLabel) {
		this.earLabel = earLabel;
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
	 * 属性序号(支持两条理赔数据)/序号(支持两条理赔数据)的getter方法
	 */
	public java.lang.Integer getSerialNo() {
    		return serialNo;
	}
	/**
	 * 属性序号(支持两条理赔数据)/序号(支持两条理赔数据)的setter方法
	 */
	public void setSerialNo(java.lang.Integer serialNo) {
		this.serialNo = serialNo;
	} 
}