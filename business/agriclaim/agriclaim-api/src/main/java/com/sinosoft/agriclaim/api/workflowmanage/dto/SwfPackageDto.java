package com.sinosoft.agriclaim.api.workflowmanage.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:47:03.090 
 * 工作流明细信息包表Api操作对象
 */
public class SwfPackageDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性明细信息包ID/明细信息包ID */
	private String packageId ;		
	/** 属性明细序号/明细序号 */
	private java.lang.Integer detailNo ;		
	/** 属性明细文本/明细文本 */
	private String detailContent ;		
	/** 属性标志/标志 */
	private String flag ;		
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
	/**
	 * 属性明细文本/明细文本的getter方法
	 */
	public String getDetailContent() {
		return detailContent;
	}
	/**
	 * 属性明细文本/明细文本的setter方法
	 */
	public void setDetailContent(String detailContent) {
		this.detailContent = detailContent;
	}	
	/**
	 * 属性标志/标志的getter方法
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * 属性标志/标志的setter方法
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}	
}
