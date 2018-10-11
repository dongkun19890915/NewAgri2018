package com.sinosoft.agriprpall.core.process.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2018-04-03 09:46:55.365 
 * 承保流程节点数据临时表主键操作对象
 */
public class PrpStepFlowTempKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpStepFlowTempKey(){}
	public PrpStepFlowTempKey(String UUID,String proposalNo){
		this.UUID = UUID;
		this.proposalNo = proposalNo;
	}
	/** 属性UUID/UUID */
	@Column(name = "UUID")
	private String UUID ;
	/** 属性投保单号/投保单号 */
	@Column(name = "proposalNo")
	private String proposalNo ;
	/**
	 * 属性UUID/UUID的getter方法
	 */
	public String getUUID() {
    		return UUID;
	}
	/**
	 * 属性UUID/UUID的setter方法
	 */
	public void setUUID(String UUID) {
		this.UUID = UUID;
	} 
	/**
	 * 属性投保单号/投保单号的getter方法
	 */
	public String getProposalNo() {
    		return proposalNo;
	}
	/**
	 * 属性投保单号/投保单号的setter方法
	 */
	public void setProposalNo(String proposalNo) {
		this.proposalNo = proposalNo;
	} 
}