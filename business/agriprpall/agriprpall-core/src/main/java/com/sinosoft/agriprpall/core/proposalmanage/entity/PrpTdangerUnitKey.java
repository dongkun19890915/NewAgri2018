package com.sinosoft.agriprpall.core.proposalmanage.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-04 09:41:15.792 
 * PrpTdangerUnit主键操作对象
 */
public class PrpTdangerUnitKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpTdangerUnitKey(){}
	public PrpTdangerUnitKey(String proposalNo,java.lang.Integer dangerNo){
		this.proposalNo = proposalNo;
		this.dangerNo = dangerNo;
	}
	/** 属性投保单号/投保单号 */
	@Column(name = "proposalNo")
	private String proposalNo ;
	/** 属性危险单位序号/危险单位序号 */
	@Column(name = "dangerNo")
	private java.lang.Integer dangerNo ;
	/**
	 * 属性投保单号/投保单号的getter方法
	 */
	public String getProposalNo() {
    		return proposalNo;
	}
	/**
	 * 属性投保单号/投保单号的setter方法
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
}