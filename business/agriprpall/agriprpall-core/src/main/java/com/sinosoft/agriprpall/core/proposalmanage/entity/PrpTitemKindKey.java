package com.sinosoft.agriprpall.core.proposalmanage.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;

import javax.persistence.Column;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-18 03:10:49.566 
 * 标的子险信息主键操作对象
 */
public class PrpTitemKindKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpTitemKindKey(){}
	public PrpTitemKindKey(String proposalNo,Integer itemKindNo){
		this.proposalNo = proposalNo;
		this.itemKindNo = itemKindNo;
	}
	/** 属性投保单号码/投保单号码 */
	@Column(name = "proposalNo")
	private String proposalNo ;
	/** 属性序号/序号 */
	@Column(name = "itemKindNo")
	private Integer itemKindNo ;
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

	public Integer getItemKindNo() {
		return itemKindNo;
	}

	public void setItemKindNo(Integer itemKindNo) {
		this.itemKindNo = itemKindNo;
	}
}