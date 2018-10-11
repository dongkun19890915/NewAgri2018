package com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;

import javax.persistence.Column;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-06 07:49:16.504 
 * 大户田块信息表(P)主键操作对象
 */
public class PrpPfeildKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpPfeildKey(){}
	public PrpPfeildKey(String endorseNo,String feildNo){
		this.endorseNo = endorseNo;
		this.feildNo = feildNo;
	}
	/** 属性批单号/批单号 */
	@Column(name = "endorseNo")
	private String endorseNo ;
	/** 属性田块编码/田块编码 */
	@Column(name = "feildNo")
	private String feildNo ;
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
	 * 属性田块编码/田块编码的getter方法
	 */
	public String getFeildNo() {
    		return feildNo;
	}
	/**
	 * 属性田块编码/田块编码的setter方法
	 */
	public void setFeildNo(String feildNo) {
		this.feildNo = feildNo;
	} 
}