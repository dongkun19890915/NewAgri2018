package com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;

import javax.persistence.Column;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-06 07:43:02.892 
 * 收费计划表主键操作对象
 */
public class PrpPplanCoinsCopyKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpPplanCoinsCopyKey(){}
	public PrpPplanCoinsCopyKey(String endorseNo,Integer serialNo,String coinsCode,String payReason){
		this.endorseNo = endorseNo;
		this.serialNo = serialNo;
		this.coinsCode = coinsCode;
		this.payReason = payReason;
	}
	/** 属性批单号码/批单号码 */
	@Column(name = "endorseNo")
	private String endorseNo ;
	/** 属性序号/序号 */
	@Column(name = "serialNo")
	private Integer serialNo ;
	/** 属性coinsCode/coinsCode */
	@Column(name = "coinsCode")
	private String coinsCode ;
	/** 属性缴费原因/缴费原因 */
	@Column(name = "payReason")
	private String payReason ;
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
	/**
	 * 属性coinsCode/coinsCode的getter方法
	 */
	public String getCoinsCode() {
    		return coinsCode;
	}
	/**
	 * 属性coinsCode/coinsCode的setter方法
	 */
	public void setCoinsCode(String coinsCode) {
		this.coinsCode = coinsCode;
	} 
	/**
	 * 属性缴费原因/缴费原因的getter方法
	 */
	public String getPayReason() {
    		return payReason;
	}
	/**
	 * 属性缴费原因/缴费原因的setter方法
	 */
	public void setPayReason(String payReason) {
		this.payReason = payReason;
	} 
}