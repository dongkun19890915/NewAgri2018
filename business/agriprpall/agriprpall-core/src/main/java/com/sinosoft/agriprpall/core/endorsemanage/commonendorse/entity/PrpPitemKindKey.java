package com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;

import javax.persistence.Column;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-24 09:50:49.498 
 * 标的子险信息主键操作对象
 */
public class PrpPitemKindKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpPitemKindKey(){}
	public PrpPitemKindKey(String endorseNo, String itemKindNo){
		this.endorseNo = endorseNo;
		this.itemKindNo = itemKindNo;
	}
	/** 属性批单号码/批单号码 */
	@Column(name = "endorseNo")
	private String endorseNo ;
	/** 属性 险种代码/ 险种代码 */
	@Column(name = "itemKindNo")
	private String itemKindNo ;
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
	 * 属性 险种代码/ 险种代码的getter方法
	 */
	public String getItemKindNo() {
    		return itemKindNo;
	}
	/**
	 * 属性 险种代码/ 险种代码的setter方法
	 */
	public void setItemKindNo(String itemKindNo) {
		this.itemKindNo = itemKindNo;
	} 
}