package com.sinosoft.agriclaim.core.workflowmanage.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:47:03.090 
 * 工作流明细信息包表主键操作对象
 */
public class SwfPackageKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public SwfPackageKey(){}
	public SwfPackageKey(String packageId,java.lang.Integer detailNo){
		this.packageId = packageId;
		this.detailNo = detailNo;
	}
	/** 属性明细信息包ID/明细信息包ID */
	@Column(name = "packageId")
	private String packageId ;
	/** 属性明细序号/明细序号 */
	@Column(name = "detailNo")
	private java.lang.Integer detailNo ;
	/**
	 * 属性明细信息包ID/明细信息包ID的getter方法
	 */
	public String getPackageId() {
    		return packageId;
	}
	/**
	 * 属性明细信息包ID/明细信息包ID的setter方法
	 */
	public void setPackageId(String packageId) {
		this.packageId = packageId;
	} 
	/**
	 * 属性明细序号/明细序号的getter方法
	 */
	public java.lang.Integer getDetailNo() {
    		return detailNo;
	}
	/**
	 * 属性明细序号/明细序号的setter方法
	 */
	public void setDetailNo(java.lang.Integer detailNo) {
		this.detailNo = detailNo;
	} 
}