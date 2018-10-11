package com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;

import javax.persistence.Column;

/**
 * @author codegen@研发中心
 * @mail codegen@sinosoft.com.cn
 * @time  2017-10-21 06:56:49.866 
 * 保险关系人表主键操作对象
 */
public class PrpPinsuredCopyKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpPinsuredCopyKey(){}
	public PrpPinsuredCopyKey(String endorseNo,Integer serialNo){
		this.endorseNo = endorseNo;
		this.serialNo = serialNo;
	}
	/** 属性批单号码/批单号码 */
	@Column(name = "endorseNo")
	private String endorseNo ;
	/** 属性序号/序号 */
	@Column(name = "serialNo")
	private Integer serialNo ;
	/**
	 * 属性批单号码/批单号码的getter方法
	 */
	public String getEndorseNo() {
    		return endorseNo;
	}
	/**
	 * 属性批单号码/批单号码的setter方法
	 */
	public void setEndorseNo(String endorseNo) {
		this.endorseNo = endorseNo;
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
}