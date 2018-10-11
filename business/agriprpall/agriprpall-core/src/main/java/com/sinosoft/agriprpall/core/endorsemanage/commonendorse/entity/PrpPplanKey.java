package com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;

import javax.persistence.Column;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-24 09:50:49.498 
 * 收费计划表主键操作对象
 */
public class PrpPplanKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpPplanKey(){}
	public PrpPplanKey(String endorseNo, Integer serialNo){
		this.endorseNo = endorseNo;
		this.serialNo = serialNo;
	}
	/** 属性本次批单号码/本次批单号码 */
	@Column(name = "endorseNo")
	private String endorseNo ;
	/** 属性--** 交费次数序号/--** 交费次数序号 */
	@Column(name = "serialNo")
	private Integer serialNo ;
	/**
	 * 属性本次批单号码/本次批单号码的getter方法
	 */
	public String getEndorseNo() {
    		return endorseNo;
	}
	/**
	 * 属性本次批单号码/本次批单号码的setter方法
	 */
	public void setEndorseNo(String endorseNo) {
		this.endorseNo = endorseNo;
	}
	/**
	 * 属性--** 交费次数序号/--** 交费次数序号的getter方法
	 */
	public Integer getSerialNo() {
    		return serialNo;
	}
	/**
	 * 属性--** 交费次数序号/--** 交费次数序号的setter方法
	 */
	public void setSerialNo(Integer serialNo) {
		this.serialNo = serialNo;
	} 
}