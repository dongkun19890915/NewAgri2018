package com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;

import javax.persistence.Column;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-24 09:50:49.498 
 * 共保信息表主键操作对象
 */
public class PrpPcoinsCopyKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpPcoinsCopyKey(){}
	public PrpPcoinsCopyKey(String endorseNo, Integer serialNo){
		this.endorseNo = endorseNo;
		this.serialNo = serialNo;
	}
	/** 属性endorseNo/endorseNo */
	@Column(name = "endorseNo")
	private String endorseNo ;
	/** 属性serialNo/serialNo */
	@Column(name = "serialNo")
	private Integer serialNo ;
	/**
	 * 属性endorseNo/endorseNo的getter方法
	 */
	public String getEndorseNo() {
    		return endorseNo;
	}
	/**
	 * 属性endorseNo/endorseNo的setter方法
	 */
	public void setEndorseNo(String endorseNo) {
		this.endorseNo = endorseNo;
	}
	/**
	 * 属性serialNo/serialNo的getter方法
	 */
	public Integer getSerialNo() {
    		return serialNo;
	}
	/**
	 * 属性serialNo/serialNo的setter方法
	 */
	public void setSerialNo(Integer serialNo) {
		this.serialNo = serialNo;
	} 
}