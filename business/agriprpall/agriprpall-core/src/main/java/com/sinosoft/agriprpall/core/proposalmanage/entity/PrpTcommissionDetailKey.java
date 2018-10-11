package com.sinosoft.agriprpall.core.proposalmanage.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-04 09:41:15.792 
 * 手续费细节表主键操作对象
 */
public class PrpTcommissionDetailKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpTcommissionDetailKey(){}
	public PrpTcommissionDetailKey(String proposalNo,java.lang.Integer serialNo){
		this.proposalNo = proposalNo;
		this.serialNo = serialNo;
	}
	/** 属性投保单号/投保单号 */
	@Column(name = "proposalNo")
	private String proposalNo ;
	/** 属性序号/序号 */
	@Column(name = "serialNo")
	private java.lang.Integer serialNo ;
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
	 * 属性序号/序号的getter方法
	 */
	public java.lang.Integer getSerialNo() {
    		return serialNo;
	}
	/**
	 * 属性序号/序号的setter方法
	 */
	public void setSerialNo(java.lang.Integer serialNo) {
		this.serialNo = serialNo;
	} 
}