package com.sinosoft.txnlist.core.plantinginsurancelist.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
*清单屁啊该持久化接口
* @Author: 陈道洋
* @Date: 2017/11/17 10:32
*/
public class PlantingEndorHeadKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PlantingEndorHeadKey(){}
	public PlantingEndorHeadKey(String endorseNo){
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