package com.sinosoft.agriprpall.core.policymanage.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-30 01:22:46.932 
 * 分户/虚拟分户信息主键操作对象
 */
public class PrpCvirturlItemKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpCvirturlItemKey(){}
	public PrpCvirturlItemKey(Integer itemKindNo,String virturlFlag,String proposalNo){
		this.itemKindNo = itemKindNo;
		this.virturlFlag = virturlFlag;
		this.proposalNo = proposalNo;
	}
	/** 属性序号/序号 */
	@Column(name = "ItemKindNo")
	private Integer itemKindNo ;
	/** 属性虚拟分户标志/虚拟分户标志 */
	@Column(name = "VirturlFlag")
	private String virturlFlag ;
	/** 属性投保单号码/投保单号码 */
	@Column(name = "ProposalNo")
	private String proposalNo ;
	/**
	 * 属性序号/序号的getter方法
	 */
	public Integer getItemKindNo() {
    		return itemKindNo;
	}
	/**
	 * 属性序号/序号的setter方法
	 */
	public void setItemKindNo(Integer itemKindNo) {
		this.itemKindNo = itemKindNo;
	} 
	/**
	 * 属性虚拟分户标志/虚拟分户标志的getter方法
	 */
	public String getVirturlFlag() {
    		return virturlFlag;
	}
	/**
	 * 属性虚拟分户标志/虚拟分户标志的setter方法
	 */
	public void setVirturlFlag(String virturlFlag) {
		this.virturlFlag = virturlFlag;
	} 
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