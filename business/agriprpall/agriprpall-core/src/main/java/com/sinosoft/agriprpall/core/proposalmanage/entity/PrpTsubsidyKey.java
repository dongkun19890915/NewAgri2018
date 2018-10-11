package com.sinosoft.agriprpall.core.proposalmanage.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;

import javax.persistence.Column;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-18 03:10:49.566 
 * 政府补贴信息主键操作对象
 */
public class PrpTsubsidyKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpTsubsidyKey(){}
	public PrpTsubsidyKey(String proposalNo,String subsidyCode,String subsidyType){
		this.proposalNo = proposalNo;
		this.subsidyCode = subsidyCode;
		this.subsidyType = subsidyType;
	}
	/** 属性投保单号/投保单号 */
	@Column(name = "proposalNo")
	private String proposalNo ;
	/** 属性补贴类型/补贴类型 */
	@Column(name = "subsidyCode")
	private String subsidyCode ;
	/** 属性补贴方式/补贴方式 */
	@Column(name = "subsidyType")
	private String subsidyType ;
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
	 * 属性补贴类型/补贴类型的getter方法
	 */
	public String getSubsidyCode() {
    		return subsidyCode;
	}
	/**
	 * 属性补贴类型/补贴类型的setter方法
	 */
	public void setSubsidyCode(String subsidyCode) {
		this.subsidyCode = subsidyCode;
	} 
	/**
	 * 属性补贴方式/补贴方式的getter方法
	 */
	public String getSubsidyType() {
    		return subsidyType;
	}
	/**
	 * 属性补贴方式/补贴方式的setter方法
	 */
	public void setSubsidyType(String subsidyType) {
		this.subsidyType = subsidyType;
	} 
}