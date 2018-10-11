package com.sinosoft.agriclaim.core.docmanage.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:41:23.407 
 * 索赔单证信息表主键操作对象
 */
public class PrpLDocKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpLDocKey(){}
	public PrpLDocKey(String claimNo,String docCode){
		this.claimNo = claimNo;
		this.docCode = docCode;
	}
	/** 属性立案号码/立案号码 */
	@Column(name = "claimNo")
	private String claimNo ;
	/** 属性单证代码/单证代码 */
	@Column(name = "docCode")
	private String docCode ;
	/**
	 * 属性立案号码/立案号码的getter方法
	 */
	public String getClaimNo() {
    		return claimNo;
	}
	/**
	 * 属性立案号码/立案号码的setter方法
	 */
	public void setClaimNo(String claimNo) {
		this.claimNo = claimNo;
	} 
	/**
	 * 属性单证代码/单证代码的getter方法
	 */
	public String getDocCode() {
    		return docCode;
	}
	/**
	 * 属性单证代码/单证代码的setter方法
	 */
	public void setDocCode(String docCode) {
		this.docCode = docCode;
	} 
}