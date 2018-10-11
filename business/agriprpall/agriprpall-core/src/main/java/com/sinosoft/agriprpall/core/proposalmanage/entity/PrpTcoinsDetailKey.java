package com.sinosoft.agriprpall.core.proposalmanage.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;

import javax.persistence.Column;

/**
 * @author codegen@研发中心
 * @mail codegen@sinosoft.com.cn
 * @time  2017-10-21 05:54:45.680 
 * 共保明细信息表主键操作对象
 */
public class PrpTcoinsDetailKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpTcoinsDetailKey(){}
	public PrpTcoinsDetailKey(String proposalNo,Integer serialNo,String currency){
		this.proposalNo = proposalNo;
		this.serialNo = serialNo;
		this.currency = currency;
	}
	/** 属性proposalNo/proposalNo */
	@Column(name = "proposalNo")
	private String proposalNo ;
	/** 属性serialNo/serialNo */
	@Column(name = "serialNo")
	private Integer serialNo ;
	/** 属性currency/currency */
	@Column(name = "currency")
	private String currency ;
	/**
	 * 属性proposalNo/proposalNo的getter方法
	 */
	public String getProposalNo() {
    		return proposalNo;
	}
	/**
	 * 属性proposalNo/proposalNo的setter方法
	 */
	public void setProposalNo(String proposalNo) {
		this.proposalNo = proposalNo;
	} 
	/**
	 * 属性serialNo/serialNo的getter方法
	 */
	public Integer getSerialNo() {
    		return serialNo;
	}
	/**
	 * 属性serialNo/serialNo的setter方法
	 */
	public void setSerialNo(Integer serialNo) {
		this.serialNo = serialNo;
	} 
	/**
	 * 属性currency/currency的getter方法
	 */
	public String getCurrency() {
    		return currency;
	}
	/**
	 * 属性currency/currency的setter方法
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	} 
}