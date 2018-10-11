package com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;

import javax.persistence.Column;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-24 03:06:48.016 
 * 农业附加险信息表主键操作对象
 */
public class PrpCPitemKindAgriKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpCPitemKindAgriKey(){}
	public PrpCPitemKindAgriKey(String policyNo,Integer itemKindNo,String kindCode,Integer times){
		this.policyNo = policyNo;
		this.itemKindNo = itemKindNo;
		this.kindCode = kindCode;
		this.times = times;
	}
	/** 属性policyNo/policyNo */
	@Column(name = "policyNo")
	private String policyNo ;
	/** 属性itemKindNo/itemKindNo */
	@Column(name = "itemKindNo")
	private Integer itemKindNo ;
	/** 属性kindCode/kindCode */
	@Column(name = "kindCode")
	private String kindCode ;
	/** 属性茬次/茬次 */
	@Column(name = "times")
	private Integer times ;
	/**
	 * 属性policyNo/policyNo的getter方法
	 */
	public String getPolicyNo() {
    		return policyNo;
	}
	/**
	 * 属性policyNo/policyNo的setter方法
	 */
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	} 
	/**
	 * 属性itemKindNo/itemKindNo的getter方法
	 */
	public Integer getItemKindNo() {
    		return itemKindNo;
	}
	/**
	 * 属性itemKindNo/itemKindNo的setter方法
	 */
	public void setItemKindNo(Integer itemKindNo) {
		this.itemKindNo = itemKindNo;
	} 
	/**
	 * 属性kindCode/kindCode的getter方法
	 */
	public String getKindCode() {
    		return kindCode;
	}
	/**
	 * 属性kindCode/kindCode的setter方法
	 */
	public void setKindCode(String kindCode) {
		this.kindCode = kindCode;
	} 
	/**
	 * 属性茬次/茬次的getter方法
	 */
	public Integer getTimes() {
    		return times;
	}
	/**
	 * 属性茬次/茬次的setter方法
	 */
	public void setTimes(Integer times) {
		this.times = times;
	} 
}