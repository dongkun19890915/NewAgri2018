package com.sinosoft.agriprpall.core.proposalmanage.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-24 01:57:51.087 
 * 贷款保险保单信息表主键操作对象
 */
public class PrpTmainLoanKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpTmainLoanKey(){}
	public PrpTmainLoanKey(String proposalNo){
		this.proposalNo = proposalNo;
	}
	/** 属性投保单号码/投保单号码 */
	@Column(name = "proposalNo")
	private String proposalNo ;
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
}