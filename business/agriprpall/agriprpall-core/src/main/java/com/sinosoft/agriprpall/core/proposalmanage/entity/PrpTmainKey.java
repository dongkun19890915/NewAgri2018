package com.sinosoft.agriprpall.core.proposalmanage.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;

import javax.persistence.Column;

/**
* @Description: 投保单基本信息表主键操作对象
* @Author: 何伟东
* @Date: 2017/10/15 11:17
*/
public class PrpTmainKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpTmainKey(){}
	public PrpTmainKey(String proposalNo ){
		this.proposalNo  = proposalNo ;
	}
	/** 属性投保单号码/投保单号码 */
	@Column(name = "proposalNo ")
	private String proposalNo  ;
	/**
	 * 属性投保单号码/投保单号码的getter方法
	 */
	public String getProposalNo () {
    		return proposalNo ;
	}
	/**
	 * 属性投保单号码/投保单号码的setter方法
	 */
	public void setProposalNo (String proposalNo ) {
		this.proposalNo  = proposalNo ;
	} 
}