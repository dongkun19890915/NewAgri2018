package com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;

import javax.persistence.Column;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-06 01:44:37.955 
 * 批改文字信息表主键操作对象
 */
public class PrpPtextKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpPtextKey(){}
	public PrpPtextKey(String endorseNo,String policyNo,Integer lineNo){
		this.endorseNo = endorseNo;
		this.policyNo = policyNo;
		this.lineNo = lineNo;
	}
	/** 属性批单号次/批单号次 */
	@Column(name = "endorseNo")
	private String endorseNo ;
	/** 属性保险单号次/保险单号次 */
	@Column(name = "policyNo")
	private String policyNo ;
	/** 属性批文的行号/批文的行号 */
	@Column(name = "lineNo")
	private Integer lineNo ;
	/**
	 * 属性批单号次/批单号次的getter方法
	 */
	public String getEndorseNo() {
    		return endorseNo;
	}
	/**
	 * 属性批单号次/批单号次的setter方法
	 */
	public void setEndorseNo(String endorseNo) {
		this.endorseNo = endorseNo;
	}
	/**
	 * 属性保险单号次/保险单号次的getter方法
	 */
	public String getPolicyNo() {
    		return policyNo;
	}
	/**
	 * 属性保险单号次/保险单号次的setter方法
	 */
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}
	/**
	 * 属性批文的行号/批文的行号的getter方法
	 */
	public Integer getLineNo() {
    		return lineNo;
	}
	/**
	 * 属性批文的行号/批文的行号的setter方法
	 */
	public void setLineNo(Integer lineNo) {
		this.lineNo = lineNo;
	} 
}