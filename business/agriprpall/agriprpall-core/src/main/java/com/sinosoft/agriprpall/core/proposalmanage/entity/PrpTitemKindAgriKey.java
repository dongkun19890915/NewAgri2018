package com.sinosoft.agriprpall.core.proposalmanage.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;

import javax.persistence.Column;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-18 03:10:49.566 
 * 农险标的信息表主键操作对象
 */
public class PrpTitemKindAgriKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpTitemKindAgriKey(){}
	public PrpTitemKindAgriKey(String proposalNo,Integer itemKindNo,String kindCode,Integer times){
		this.proposalNo = proposalNo;
		this.itemKindNo = itemKindNo;
		this.kindCode = kindCode;
		this.times = times;
	}
	/** 属性投保单/投保单 */
	@Column(name = "proposalNo")
	private String proposalNo ;
	/** 属性标的序号/标的序号 */
	@Column(name = "itemKindNo")
	private Integer itemKindNo ;
	/** 属性险别/险别 */
	@Column(name = "kindCode")
	private String kindCode ;
	/** 属性茬次/茬次 */
	@Column(name = "times")
	private Integer times ;
	/**
	 * 属性投保单/投保单的getter方法
	 */
	public String getProposalNo() {
    		return proposalNo;
	}
	/**
	 * 属性投保单/投保单的setter方法
	 */
	public void setProposalNo(String proposalNo) {
		this.proposalNo = proposalNo;
	} 
	/**
	 * 属性标的序号/标的序号的getter方法
	 */
	public Integer getItemKindNo() {
    		return itemKindNo;
	}
	/**
	 * 属性标的序号/标的序号的setter方法
	 */
	public void setItemKindNo(Integer itemKindNo) {
		this.itemKindNo = itemKindNo;
	} 
	/**
	 * 属性险别/险别的getter方法
	 */
	public String getKindCode() {
    		return kindCode;
	}
	/**
	 * 属性险别/险别的setter方法
	 */
	public void setKindCode(String kindCode) {
		this.kindCode = kindCode;
	} 
	/**
	 * 属性茬次/茬次的getter方法
	 */
	public Integer getTimes() {
    		return times;
	}
	/**
	 * 属性茬次/茬次的setter方法
	 */
	public void setTimes(Integer times) {
		this.times = times;
	} 
}