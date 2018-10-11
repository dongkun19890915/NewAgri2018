package com.sinosoft.ims.api.kernel.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:10:12.703 
 * 临分权限控制表Api操作对象
 */
public class PrpDfacConfigDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性comCode/comCode */
	private String comCode ;		
	/** 属性modelNo/modelNo */
	private java.lang.Integer modelNo ;		
	/** 属性nodeNo/nodeNo */
	private java.lang.Integer nodeNo ;		
	/** 属性riskCode/riskCode */
	private String riskCode ;		
	/** 属性classCode/classCode */
	private String classCode ;		
	/** 属性uwtype/uwtype */
	private String uwType ;		
	/** 属性riskCategoryCode/riskCategoryCode */
	private String riskCategoryCode ;		
	/** 属性validStatus/validStatus */
	private String validStatus ;		
	/** 属性1-临分，2-特别申报/1-临分，2-特别申报 */
	private String facType ;		
	/** 属性remark/remark */
	private String remark ;		
	/** 属性id/id */
	private String id ;		
	/**
	 * 属性comCode/comCode的getter方法
	 */
	public String getComCode() {
		return comCode;
	}
	/**
	 * 属性comCode/comCode的setter方法
	 */
	public void setComCode(String comCode) {
		this.comCode = comCode;
	}	
	/**
	 * 属性modelNo/modelNo的getter方法
	 */
	public java.lang.Integer getModelNo() {
		return modelNo;
	}
	/**
	 * 属性modelNo/modelNo的setter方法
	 */
	public void setModelNo(java.lang.Integer modelNo) {
		this.modelNo = modelNo;
	}	
	/**
	 * 属性nodeNo/nodeNo的getter方法
	 */
	public java.lang.Integer getNodeNo() {
		return nodeNo;
	}
	/**
	 * 属性nodeNo/nodeNo的setter方法
	 */
	public void setNodeNo(java.lang.Integer nodeNo) {
		this.nodeNo = nodeNo;
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
	/**
	 * 属性classCode/classCode的getter方法
	 */
	public String getClassCode() {
		return classCode;
	}
	/**
	 * 属性classCode/classCode的setter方法
	 */
	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}	
	/**
	 * 属性uwtype/uwtype的getter方法
	 */
	public String getUwType() {
		return uwType;
	}
	/**
	 * 属性uwtype/uwtype的setter方法
	 */
	public void setUwType(String uwType) {
		this.uwType = uwType;
	}	
	/**
	 * 属性riskCategoryCode/riskCategoryCode的getter方法
	 */
	public String getRiskCategoryCode() {
		return riskCategoryCode;
	}
	/**
	 * 属性riskCategoryCode/riskCategoryCode的setter方法
	 */
	public void setRiskCategoryCode(String riskCategoryCode) {
		this.riskCategoryCode = riskCategoryCode;
	}	
	/**
	 * 属性validStatus/validStatus的getter方法
	 */
	public String getValidStatus() {
		return validStatus;
	}
	/**
	 * 属性validStatus/validStatus的setter方法
	 */
	public void setValidStatus(String validStatus) {
		this.validStatus = validStatus;
	}	
	/**
	 * 属性1-临分，2-特别申报/1-临分，2-特别申报的getter方法
	 */
	public String getFacType() {
		return facType;
	}
	/**
	 * 属性1-临分，2-特别申报/1-临分，2-特别申报的setter方法
	 */
	public void setFacType(String facType) {
		this.facType = facType;
	}	
	/**
	 * 属性remark/remark的getter方法
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * 属性remark/remark的setter方法
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}	
	/**
	 * 属性id/id的getter方法
	 */
	public String getId() {
		return id;
	}
	/**
	 * 属性id/id的setter方法
	 */
	public void setId(String id) {
		this.id = id;
	}	
}
