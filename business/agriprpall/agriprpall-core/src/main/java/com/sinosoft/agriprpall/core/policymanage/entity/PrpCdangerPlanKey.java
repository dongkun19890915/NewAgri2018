package com.sinosoft.agriprpall.core.policymanage.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-04 09:53:57.649 
 * 保单危险单位交付计划表主键操作对象
 */
public class PrpCdangerPlanKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpCdangerPlanKey(){}
	public PrpCdangerPlanKey(String proposalNo,java.lang.Integer dangerNo,java.lang.Integer serialNo){
		this.proposalNo = proposalNo;
		this.dangerNo = dangerNo;
		this.serialNo = serialNo;
	}
	/** 属性保单号码/保单号码 */
	@Column(name = "proposalNo")
	private String proposalNo ;
	/** 属性危险单位序号/危险单位序号 */
	@Column(name = "dangerNo")
	private java.lang.Integer dangerNo ;
	/** 属性交费次序号/交费次序号 */
	@Column(name = "serialNo")
	private java.lang.Integer serialNo ;
	/**
	 * 属性保单号码/保单号码的getter方法
	 */
	public String getProposalNo() {
    		return proposalNo;
	}
	/**
	 * 属性保单号码/保单号码的setter方法
	 */
	public void setProposalNo(String proposalNo) {
		this.proposalNo = proposalNo;
	} 
	/**
	 * 属性危险单位序号/危险单位序号的getter方法
	 */
	public java.lang.Integer getDangerNo() {
    		return dangerNo;
	}
	/**
	 * 属性危险单位序号/危险单位序号的setter方法
	 */
	public void setDangerNo(java.lang.Integer dangerNo) {
		this.dangerNo = dangerNo;
	} 
	/**
	 * 属性交费次序号/交费次序号的getter方法
	 */
	public java.lang.Integer getSerialNo() {
    		return serialNo;
	}
	/**
	 * 属性交费次序号/交费次序号的setter方法
	 */
	public void setSerialNo(java.lang.Integer serialNo) {
		this.serialNo = serialNo;
	} 
}