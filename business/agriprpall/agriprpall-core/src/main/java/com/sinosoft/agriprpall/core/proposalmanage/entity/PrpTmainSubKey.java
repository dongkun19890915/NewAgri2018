package com.sinosoft.agriprpall.core.proposalmanage.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-24 01:57:51.087 
 * 投保单隶属表主键操作对象
 */
public class PrpTmainSubKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpTmainSubKey(){}
	public PrpTmainSubKey(String proposalNo,String mainPolicyNo){
		this.proposalNo = proposalNo;
		this.mainPolicyNo = mainPolicyNo;
	}
	/** 属性投保单号码/投保单号码 */
	@Column(name = "proposalNo")
	private String proposalNo ;
	/** 属性主保单号码/主保单号码 */
	@Column(name = "mainPolicyNo")
	private String mainPolicyNo ;
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
	 * 属性主保单号码/主保单号码的getter方法
	 */
	public String getMainPolicyNo() {
    		return mainPolicyNo;
	}
	/**
	 * 属性主保单号码/主保单号码的setter方法
	 */
	public void setMainPolicyNo(String mainPolicyNo) {
		this.mainPolicyNo = mainPolicyNo;
	} 
}