package com.sinosoft.ims.core.kernel.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:10:12.703 
 * PrpDagreeDetail主键操作对象
 */
public class PrpDagreeDetailKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpDagreeDetailKey(){}
	public PrpDagreeDetailKey(String agreementNo,String riskCode){
		this.agreementNo = agreementNo;
		this.riskCode = riskCode;
	}
	/** 属性agreementNo/agreementNo */
	@Column(name = "agreementNo")
	private String agreementNo ;
	/** 属性riskCode/riskCode */
	@Column(name = "riskCode")
	private String riskCode ;
	/**
	 * 属性agreementNo/agreementNo的getter方法
	 */
	public String getAgreementNo() {
    		return agreementNo;
	}
	/**
	 * 属性agreementNo/agreementNo的setter方法
	 */
	public void setAgreementNo(String agreementNo) {
		this.agreementNo = agreementNo;
	} 
	/**
	 * 属性riskCode/riskCode的getter方法
	 */
	public String getRiskCode() {
    		return riskCode;
	}
	/**
	 * 属性riskCode/riskCode的setter方法
	 */
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	} 
}