package com.sinosoft.agriprpall.core.proposalmanage.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;

import javax.persistence.Column;

/**
 * @author codegen@研发中心
 * @mail yanghang@sinosoft.com.cn
 * @time  2017-10-19 06:31:19.937 
 * 特别约定表主键操作对象
 */
public class PrpTengageKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpTengageKey(){}
	public PrpTengageKey(String proposalNo,Integer serialNo,Integer lineNo){
		this.proposalNo = proposalNo;
		this.serialNo = serialNo;
		this.lineNo = lineNo;
	}
	/** 属性投保单号码/投保单号码 */
	@Column(name = "proposalNo")
	private String proposalNo ;
	/** 属性序号/序号 */
	@Column(name = "serialNo")
	private Integer serialNo ;
	/** 属性行序号/行序号 */
	@Column(name = "lineNo")
	private Integer lineNo ;
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

	public Integer getLineNo() {
		return lineNo;
	}

	public void setLineNo(Integer lineNo) {
		this.lineNo = lineNo;
	}
}