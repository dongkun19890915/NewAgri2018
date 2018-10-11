package com.sinosoft.agriprpall.core.proposalmanage.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-24 01:57:51.087 
 * 税表主键操作对象
 */
public class PrpTexpenseKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpTexpenseKey(){}
	public PrpTexpenseKey(String proposalNo){
		this.proposalNo = proposalNo;
	}
	/** 属性投保单号 /投保单号  */
	@Column(name = "proposalNo")
	private String proposalNo ;
	/**
	 * 属性投保单号 /投保单号 的getter方法
	 */
	public String getProposalNo() {
    		return proposalNo;
	}
	/**
	 * 属性投保单号 /投保单号 的setter方法
	 */
	public void setProposalNo(String proposalNo) {
		this.proposalNo = proposalNo;
	} 
}