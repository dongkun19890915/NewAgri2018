package com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;

import javax.persistence.Column;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-24 09:50:49.498 
 * 批改信息表1主键操作对象
 */
public class PrpPheadKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpPheadKey(){}
	public PrpPheadKey(String endorseNo){
		this.endorseNo = endorseNo;
	}
	/** 属性批单号码/批单号码 */
	@Column(name = "endorseNo")
	private String endorseNo ;
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
}