package com.sinosoft.agriprpall.core.proposalmanage.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-24 01:57:51.087 
 * 共保方收费计划表主键操作对象
 */
public class PrpTplanCoinsKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpTplanCoinsKey(){}
	public PrpTplanCoinsKey(String proposalNo,String coinsCode,Integer serialNo,String payReason){
		this.proposalNo = proposalNo;
		this.coinsCode = coinsCode;
		this.serialNo = serialNo;
		this.payReason = payReason;
	}
	/** 属性投保单号码/投保单号码 */
	@Column(name = "proposalNo")
	private String proposalNo ;
	/** 属性共保人代码/共保人代码 */
	@Column(name = "coinsCode")
	private String coinsCode ;
	/** 属性交费次数序号/交费次数序号 */
	@Column(name = "serialNo")
	private Integer serialNo ;
	/** 属性交费原因（同收付费系统定义）/交费原因（同收付费系统定义） */
	@Column(name = "payReason")
	private String payReason ;
	/**
	 * 属性投保单号码/投保单号码的getter方法
	 */
	public String getProposalNo() {
    		return proposalNo;
	}
	/**
	 * 属性投保单号码/投保单号码的setter方法
	 */
	public void setProposalNo(String proposalNo) {
		this.proposalNo = proposalNo;
	} 
	/**
	 * 属性共保人代码/共保人代码的getter方法
	 */
	public String getCoinsCode() {
    		return coinsCode;
	}
	/**
	 * 属性共保人代码/共保人代码的setter方法
	 */
	public void setCoinsCode(String coinsCode) {
		this.coinsCode = coinsCode;
	} 
	/**
	 * 属性交费次数序号/交费次数序号的getter方法
	 */
	public Integer getSerialNo() {
    		return serialNo;
	}
	/**
	 * 属性交费次数序号/交费次数序号的setter方法
	 */
	public void setSerialNo(Integer serialNo) {
		this.serialNo = serialNo;
	} 
	/**
	 * 属性交费原因（同收付费系统定义）/交费原因（同收付费系统定义）的getter方法
	 */
	public String getPayReason() {
    		return payReason;
	}
	/**
	 * 属性交费原因（同收付费系统定义）/交费原因（同收付费系统定义）的setter方法
	 */
	public void setPayReason(String payReason) {
		this.payReason = payReason;
	} 
}