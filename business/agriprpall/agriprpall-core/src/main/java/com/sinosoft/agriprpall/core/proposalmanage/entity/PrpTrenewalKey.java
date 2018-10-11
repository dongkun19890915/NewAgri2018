package com.sinosoft.agriprpall.core.proposalmanage.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail codegen@sinosoft.com.cn
 * @time  2017-10-22 07:33:55.391 
 * PrpTrenewal主键操作对象
 */
public class PrpTrenewalKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpTrenewalKey(){}
	public PrpTrenewalKey(String proposalNo){
		this.proposalNo = proposalNo;
	}
	/** 属性proposalNo/proposalNo */
	@Column(name = "proposalNo")
	private String proposalNo ;
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
}