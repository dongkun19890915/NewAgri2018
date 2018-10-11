package com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;

import javax.persistence.Column;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-28 07:51:01.225 
 * 共保细节表主键操作对象
 */
public class PrpPcoinsDetailCopyKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpPcoinsDetailCopyKey(){}
	public PrpPcoinsDetailCopyKey(String endorseNo,Integer serialNo,String currency){
		this.endorseNo = endorseNo;
		this.serialNo = serialNo;
		this.currency = currency;
	}
	/** 属性批单号/批单号 */
	@Column(name = "endorseNo")
	private String endorseNo ;
	/** 属性序号/序号 */
	@Column(name = "serialNo")
	private Integer serialNo ;
	/** 属性币别信息/币别信息 */
	@Column(name = "currency")
	private String currency ;
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
	/**
	 * 属性币别信息/币别信息的getter方法
	 */
	public String getCurrency() {
    		return currency;
	}
	/**
	 * 属性币别信息/币别信息的setter方法
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	} 
}