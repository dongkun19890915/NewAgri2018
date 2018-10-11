package com.sinosoft.agriprpall.core.proposalmanage.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-24 01:57:51.087 
 * 大户田块信息主键操作对象
 */
public class PrpTfeildKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpTfeildKey(){}
	public PrpTfeildKey(String proposalNo,String feildNo){
		this.proposalNo = proposalNo;
		this.feildNo = feildNo;
	}
	/** 属性投保单/投保单 */
	@Column(name = "proposalNo")
	private String proposalNo ;
	/** 属性田块编码/田块编码 */
	@Column(name = "feildNo")
	private String feildNo ;
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
	 * 属性田块编码/田块编码的getter方法
	 */
	public String getFeildNo() {
    		return feildNo;
	}
	/**
	 * 属性田块编码/田块编码的setter方法
	 */
	public void setFeildNo(String feildNo) {
		this.feildNo = feildNo;
	} 
}