package com.sinosoft.ims.core.auth.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:11:08.689 
 * UtiUwUserCondition实体操作对象
 */
@Entity
@Table(name = "UtiUwUserCondition")
@IdClass(UtiUwUserConditionKey.class)
public class UtiUwUserCondition extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性comCode/comCode */
	@Id
	@Column(name = "comCode")
	private String comCode ;/** 属性modelNo/modelNo */
	@Id
	@Column(name = "modelNo")
	private java.lang.Integer modelNo ;/** 属性nodeNo/nodeNo */
	@Id
	@Column(name = "nodeNo")
	private java.lang.Integer nodeNo ;/** 属性riskCode/riskCode */
	@Id
	@Column(name = "riskCode")
	private String riskCode ;/** 属性uwType/uwType */
	@Id
	@Column(name = "uwType")
	private String uwType ;/** 属性factorCode/factorCode */
	@Id
	@Column(name = "factorCode")
	private String factorCode ;/** 属性factorValueNo/factorValueNo */
	@Id
	@Column(name = "factorValueNo")
	private java.lang.Integer factorValueNo ;/** 属性userCode/userCode */
	@Id
	@Column(name = "userCode")
	private String userCode ;	



	/** 属性riskCategoryCode/riskCategoryCode */
	@Column(name = "riskCategoryCode")
	private String riskCategoryCode ;


	/** 属性classCode/classCode */
	@Column(name = "classCode")
	private String classCode ;


	/** 属性factorValue/factorValue */
	@Column(name = "factorValue")
	private String factorValue ;
	/** 属性remark/remark */
	@Column(name = "remark")
	private String remark ;
	/** 属性createTime/createTime */
	@Column(name = "createTime")
	private String createTime ;
	/** 属性validStatus/validStatus */
	@Column(name = "validStatus")
	private String validStatus ;

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
	 * 属性uwType/uwType的getter方法
	 */
	public String getUwType() {
		return uwType;
	}
	/**
	 * 属性uwType/uwType的setter方法
	 */
	public void setUwType(String uwType) {
		this.uwType = uwType;
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
	 * 属性factorCode/factorCode的getter方法
	 */
	public String getFactorCode() {
		return factorCode;
	}
	/**
	 * 属性factorCode/factorCode的setter方法
	 */
	public void setFactorCode(String factorCode) {
		this.factorCode = factorCode;
	} 	
	/**
	 * 属性factorValueNo/factorValueNo的getter方法
	 */
	public java.lang.Integer getFactorValueNo() {
		return factorValueNo;
	}
	/**
	 * 属性factorValueNo/factorValueNo的setter方法
	 */
	public void setFactorValueNo(java.lang.Integer factorValueNo) {
		this.factorValueNo = factorValueNo;
	} 	
	/**
	 * 属性factorValue/factorValue的getter方法
	 */
	public String getFactorValue() {
		return factorValue;
	}
	/**
	 * 属性factorValue/factorValue的setter方法
	 */
	public void setFactorValue(String factorValue) {
		this.factorValue = factorValue;
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
	 * 属性createTime/createTime的getter方法
	 */
	public String getCreateTime() {
		return createTime;
	}
	/**
	 * 属性createTime/createTime的setter方法
	 */
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
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
	 * 属性userCode/userCode的getter方法
	 */
	public String getUserCode() {
		return userCode;
	}
	/**
	 * 属性userCode/userCode的setter方法
	 */
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	} 	
}