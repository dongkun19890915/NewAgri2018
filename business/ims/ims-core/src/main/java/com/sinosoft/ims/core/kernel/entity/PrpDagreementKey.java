package com.sinosoft.ims.core.kernel.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:10:12.703 
 * 代理协议表主键操作对象
 */
public class PrpDagreementKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpDagreementKey(){}
	public PrpDagreementKey(String agreementNo){
		this.agreementNo = agreementNo;
	}
	/** 属性协议代码/协议代码 */
	@Column(name = "agreementNo")
	private String agreementNo ;
	/**
	 * 属性协议代码/协议代码的getter方法
	 */
	public String getAgreementNo() {
    		return agreementNo;
	}
	/**
	 * 属性协议代码/协议代码的setter方法
	 */
	public void setAgreementNo(String agreementNo) {
		this.agreementNo = agreementNo;
	} 
}