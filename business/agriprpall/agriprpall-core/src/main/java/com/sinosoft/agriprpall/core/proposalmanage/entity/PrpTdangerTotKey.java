package com.sinosoft.agriprpall.core.proposalmanage.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-04 09:41:15.792 
 * PrpTdangerTot主键操作对象
 */
public class PrpTdangerTotKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpTdangerTotKey(){}
	public PrpTdangerTotKey(String proposalNo,java.lang.Integer dangerNo,String sCurrency){
		this.proposalNo = proposalNo;
		this.dangerNo = dangerNo;
		this.sCurrency = sCurrency;
	}
	/** 属性保单号码/保单号码 */
	@Column(name = "proposalNo")
	private String proposalNo ;
	/** 属性危险单位序号/危险单位序号 */
	@Column(name = "dangerNo")
	private java.lang.Integer dangerNo ;
	/** 属性原币/原币 */
	@Column(name = "sCurrency")
	private String sCurrency ;
	/**
	 * 属性保单号码/保单号码的getter方法
	 */
	public String getProposalNo() {
    		return proposalNo;
	}
	/**
	 * 属性保单号码/保单号码的setter方法
	 */
	public void setProposalNo(String proposalNo) {
		this.proposalNo = proposalNo;
	} 
	/**
	 * 属性危险单位序号/危险单位序号的getter方法
	 */
	public java.lang.Integer getDangerNo() {
    		return dangerNo;
	}
	/**
	 * 属性危险单位序号/危险单位序号的setter方法
	 */
	public void setDangerNo(java.lang.Integer dangerNo) {
		this.dangerNo = dangerNo;
	} 
	/**
	 * 属性原币/原币的getter方法
	 */
	public String getSCurrency() {
    		return sCurrency;
	}
	/**
	 * 属性原币/原币的setter方法
	 */
	public void setSCurrency(String sCurrency) {
		this.sCurrency = sCurrency;
	} 
}