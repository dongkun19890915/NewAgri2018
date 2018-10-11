package com.sinosoft.agriprpall.api.proposalmanage.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail codegen@sinosoft.com.cn
 * @time  2017-10-22 07:33:55.391 
 * PrpTrenewalApi操作对象
 */
public class PrpTrenewalDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性proposalNo/proposalNo */
	private String proposalNo ;		
	/** 属性oldpolicyNo/oldpolicyNo */
	private String oldPolicyNo ;
	/** 属性flag/flag */
	private String flag ;		
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

	public String getOldPolicyNo() {
		return oldPolicyNo;
	}

	public void setOldPolicyNo(String oldPolicyNo) {
		this.oldPolicyNo = oldPolicyNo;
	}

	/**
	 * 属性flag/flag的getter方法
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * 属性flag/flag的setter方法
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}	
}
