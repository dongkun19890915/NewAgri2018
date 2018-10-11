package com.sinosoft.agriclaim.core.docmanage.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:41:23.407 
 * 单证收集表主键操作对象
 */
public class PrpLCertifyCollectKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpLCertifyCollectKey(){}
	public PrpLCertifyCollectKey(String businessNo,String lossItemCode){
		this.businessNo = businessNo;
		this.lossItemCode = lossItemCode;
	}
	/** 属性业务号码/业务号码 */
	@Column(name = "businessNo")
	private String businessNo ;
	/** 属性标的代码/标的代码 */
	@Column(name = "lossItemCode")
	private String lossItemCode ;
	/**
	 * 属性业务号码/业务号码的getter方法
	 */
	public String getBusinessNo() {
    		return businessNo;
	}
	/**
	 * 属性业务号码/业务号码的setter方法
	 */
	public void setBusinessNo(String businessNo) {
		this.businessNo = businessNo;
	} 
	/**
	 * 属性标的代码/标的代码的getter方法
	 */
	public String getLossItemCode() {
    		return lossItemCode;
	}
	/**
	 * 属性标的代码/标的代码的setter方法
	 */
	public void setLossItemCode(String lossItemCode) {
		this.lossItemCode = lossItemCode;
	} 
}