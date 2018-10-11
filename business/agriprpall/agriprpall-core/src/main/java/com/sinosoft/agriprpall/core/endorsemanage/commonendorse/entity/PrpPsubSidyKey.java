package com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;

import javax.persistence.Column;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-24 09:50:49.498 
 * 政府补贴信息表主键操作对象
 */
public class PrpPsubSidyKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpPsubSidyKey(){}
	public PrpPsubSidyKey(String endorseNo,String subsidyCode,String subsidyType){
		this.endorseNo = endorseNo;
		this.subsidyCode = subsidyCode;
		this.subsidyType = subsidyType;
	}
	/** 属性批单号/批单号 */
	@Column(name = "endorseNo")
	private String endorseNo ;
	/** 属性subsidyCode/subsidyCode */
	@Column(name = "subsidyCode")
	private String subsidyCode ;
	/** 属性subsidyType/subsidyType */
	@Column(name = "subsidyType")
	private String subsidyType ;
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
	 * 属性subsidyCode/subsidyCode的getter方法
	 */
	public String getSubsidyCode() {
    		return subsidyCode;
	}
	/**
	 * 属性subsidyCode/subsidyCode的setter方法
	 */
	public void setSubsidyCode(String subsidyCode) {
		this.subsidyCode = subsidyCode;
	} 
	/**
	 * 属性subsidyType/subsidyType的getter方法
	 */
	public String getSubsidyType() {
    		return subsidyType;
	}
	/**
	 * 属性subsidyType/subsidyType的setter方法
	 */
	public void setSubsidyType(String subsidyType) {
		this.subsidyType = subsidyType;
	} 
}