package com.sinosoft.agriclaim.core.endcasemanage.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:42:04.174 
 * 赔案号表主键操作对象
 */
public class PrpLCaseNoKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpLCaseNoKey(){}
	public PrpLCaseNoKey(String certiNo,String certiType,String caseNo){
		this.certiNo = certiNo;
		this.certiType = certiType;
		this.caseNo = caseNo;
	}
	/** 属性单证号/单证号 */
	@Column(name = "certiNo")
	private String certiNo ;
	/** 属性单证类型/单证类型 */
	@Column(name = "certiType")
	private String certiType ;
	/** 属性结案号/结案号 */
	@Column(name = "caseNo")
	private String caseNo ;
	/**
	 * 属性单证号/单证号的getter方法
	 */
	public String getCertiNo() {
    		return certiNo;
	}
	/**
	 * 属性单证号/单证号的setter方法
	 */
	public void setCertiNo(String certiNo) {
		this.certiNo = certiNo;
	} 
	/**
	 * 属性单证类型/单证类型的getter方法
	 */
	public String getCertiType() {
    		return certiType;
	}
	/**
	 * 属性单证类型/单证类型的setter方法
	 */
	public void setCertiType(String certiType) {
		this.certiType = certiType;
	} 
	/**
	 * 属性结案号/结案号的getter方法
	 */
	public String getCaseNo() {
    		return caseNo;
	}
	/**
	 * 属性结案号/结案号的setter方法
	 */
	public void setCaseNo(String caseNo) {
		this.caseNo = caseNo;
	} 
}