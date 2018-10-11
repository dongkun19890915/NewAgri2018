package com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;

import javax.persistence.Column;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-04 10:07:09.217 
 * 投保单危险单位划分表主键操作对象
 */
public class PrpPdangerItemKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpPdangerItemKey(){}
	public PrpPdangerItemKey(String endorseNo,Integer dangerNo,Integer serialNo){
		this.endorseNo = endorseNo;
		this.dangerNo = dangerNo;
		this.serialNo = serialNo;
	}
	/** 属性批单号/批单号 */
	@Column(name = "endorseNo")
	private String endorseNo ;
	/** 属性危险单位序号/危险单位序号 */
	@Column(name = "dangerNo")
	private Integer dangerNo ;
	/** 属性序号(自动生成)/序号(自动生成) */
	@Column(name = "serialNo")
	private Integer serialNo ;
	/**
	 * 属性批单号/批单号的getter方法
	 */
	public String getEndorseNo() {
    		return endorseNo;
	}
	/**
	 * 属性批单号/批单号的setter方法
	 */
	public void setEndorseNo(String endorseNo) {
		this.endorseNo = endorseNo;
	} 
	/**
	 * 属性危险单位序号/危险单位序号的getter方法
	 */
	public Integer getDangerNo() {
    		return dangerNo;
	}
	/**
	 * 属性危险单位序号/危险单位序号的setter方法
	 */
	public void setDangerNo(Integer dangerNo) {
		this.dangerNo = dangerNo;
	} 
	/**
	 * 属性序号(自动生成)/序号(自动生成)的getter方法
	 */
	public Integer getSerialNo() {
    		return serialNo;
	}
	/**
	 * 属性序号(自动生成)/序号(自动生成)的setter方法
	 */
	public void setSerialNo(Integer serialNo) {
		this.serialNo = serialNo;
	} 
}