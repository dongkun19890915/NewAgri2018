package com.sinosoft.agriclaim.core.businessutilmanage.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:35:28.283 
 * 理赔扩展系统表主键操作对象
 */
public class PrpLextKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpLextKey(){}
	public PrpLextKey(String certiNo,String certiType){
		this.certiNo = certiNo;
		this.certiType = certiType;
	}
	/** 属性单号/单号 */
	@Column(name = "certiNo")
	private String certiNo ;
	/** 属性单号类型/单号类型 */
	@Column(name = "certiType")
	private String certiType ;
	/**
	 * 属性单号/单号的getter方法
	 */
	public String getCertiNo() {
    		return certiNo;
	}
	/**
	 * 属性单号/单号的setter方法
	 */
	public void setCertiNo(String certiNo) {
		this.certiNo = certiNo;
	} 
	/**
	 * 属性单号类型/单号类型的getter方法
	 */
	public String getCertiType() {
    		return certiType;
	}
	/**
	 * 属性单号类型/单号类型的setter方法
	 */
	public void setCertiType(String certiType) {
		this.certiType = certiType;
	} 
}