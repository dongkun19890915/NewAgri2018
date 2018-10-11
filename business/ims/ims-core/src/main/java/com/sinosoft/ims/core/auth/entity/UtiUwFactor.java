package com.sinosoft.ims.core.auth.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:11:08.689 
 * UtiUwFactor实体操作对象
 */
@Entity
@Table(name = "UtiUwFactor")
@IdClass(UtiUwFactorKey.class)
public class UtiUwFactor extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性uwType/uwType */
	@Id
	@Column(name = "uwType")
	private String uwType ;/** 属性factorCode/factorCode */
	@Id
	@Column(name = "factorCode")
	private String factorCode ;/** 属性classCode/classCode */
	@Id
	@Column(name = "classCode")
	private String classCode ;	



	/** 属性riskCategoryCode/riskCategoryCode */
	@Column(name = "riskCategoryCode")
	private String riskCategoryCode ;
	/** 属性factorName/factorName */
	@Column(name = "factorName")
	private String factorName ;
	/** 属性factorAttr/factorAttr */
	@Column(name = "factorAttr")
	private String factorAttr ;
	/** 属性multiSelectFlag/multiSelectFlag */
	@Column(name = "multiSelectFlag")
	private String multiSelectFlag ;
	/** 属性isCodeFlag/isCodeFlag */
	@Column(name = "isCodeFlag")
	private String isCodeFlag ;
	/** 属性remark/remark */
	@Column(name = "remark")
	private String remark ;
	/** 属性validStatus/validStatus */
	@Column(name = "validStatus")
	private String validStatus ;
	/** 属性exampleValue/exampleValue */
	@Column(name = "exampleValue")
	private String exampleValue ;
	/** 属性valueDesc/valueDesc */
	@Column(name = "valueDesc")
	private String valueDesc ;
	/** 属性operator/operator */
	@Column(name = "operator")
	private String operator ;
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
	 * 属性factorName/factorName的getter方法
	 */
	public String getFactorName() {
		return factorName;
	}
	/**
	 * 属性factorName/factorName的setter方法
	 */
	public void setFactorName(String factorName) {
		this.factorName = factorName;
	} 	
	/**
	 * 属性factorAttr/factorAttr的getter方法
	 */
	public String getFactorAttr() {
		return factorAttr;
	}
	/**
	 * 属性factorAttr/factorAttr的setter方法
	 */
	public void setFactorAttr(String factorAttr) {
		this.factorAttr = factorAttr;
	} 	
	/**
	 * 属性multiSelectFlag/multiSelectFlag的getter方法
	 */
	public String getMultiSelectFlag() {
		return multiSelectFlag;
	}
	/**
	 * 属性multiSelectFlag/multiSelectFlag的setter方法
	 */
	public void setMultiSelectFlag(String multiSelectFlag) {
		this.multiSelectFlag = multiSelectFlag;
	} 	
	/**
	 * 属性isCodeFlag/isCodeFlag的getter方法
	 */
	public String getIsCodeFlag() {
		return isCodeFlag;
	}
	/**
	 * 属性isCodeFlag/isCodeFlag的setter方法
	 */
	public void setIsCodeFlag(String isCodeFlag) {
		this.isCodeFlag = isCodeFlag;
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
	 * 属性exampleValue/exampleValue的getter方法
	 */
	public String getExampleValue() {
		return exampleValue;
	}
	/**
	 * 属性exampleValue/exampleValue的setter方法
	 */
	public void setExampleValue(String exampleValue) {
		this.exampleValue = exampleValue;
	} 	
	/**
	 * 属性valueDesc/valueDesc的getter方法
	 */
	public String getValueDesc() {
		return valueDesc;
	}
	/**
	 * 属性valueDesc/valueDesc的setter方法
	 */
	public void setValueDesc(String valueDesc) {
		this.valueDesc = valueDesc;
	} 	
	/**
	 * 属性operator/operator的getter方法
	 */
	public String getOperator() {
		return operator;
	}
	/**
	 * 属性operator/operator的setter方法
	 */
	public void setOperator(String operator) {
		this.operator = operator;
	} 	
}