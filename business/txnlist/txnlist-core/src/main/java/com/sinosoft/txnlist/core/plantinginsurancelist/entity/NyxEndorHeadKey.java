package com.sinosoft.txnlist.core.plantinginsurancelist.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-18 08:36:26.740 
 * nyxendorhead主键操作对象
 */
public class NyxEndorHeadKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public NyxEndorHeadKey(){}
	public NyxEndorHeadKey(String endorseNo){
		this.endorseNo = endorseNo;
	}
	/** 属性批单号/批单号 */
	@Column(name = "endorseNo")
	private String endorseNo ;
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
}