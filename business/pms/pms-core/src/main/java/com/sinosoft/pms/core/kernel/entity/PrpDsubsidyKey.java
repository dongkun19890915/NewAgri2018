package com.sinosoft.pms.core.kernel.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-04 10:42:46.546 
 * PrpDsubsidy主键操作对象
 */
public class PrpDsubsidyKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpDsubsidyKey(){}
	public PrpDsubsidyKey(String riskCode,String comCode,String subsidyYear,String validStatus,String subsidyCode,String subsidyType){
		this.riskCode = riskCode;
		this.comCode = comCode;
		this.subsidyYear = subsidyYear;
		this.validStatus = validStatus;
		this.subsidyCode = subsidyCode;
		this.subsidyType = subsidyType;
	}
	/** 属性riskCode/riskCode */
	@Column(name = "riskCode")
	private String riskCode ;
	/** 属性comCode/comCode */
	@Column(name = "comCode")
	private String comCode ;
	/** 属性subsidyYear/subsidyYear */
	@Column(name = "subsidyYear")
	private String subsidyYear ;
	/** 属性validStatus/validStatus */
	@Column(name = "validStatus")
	private String validStatus ;
	/** 属性subsidyCode/subsidyCode */
	@Column(name = "subsidyCode")
	private String subsidyCode ;
	/** 属性subsidyType/subsidyType */
	@Column(name = "subsidyType")
	private String subsidyType ;
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
	 * 属性subsidyYear/subsidyYear的getter方法
	 */
	public String getSubsidyYear() {
    		return subsidyYear;
	}
	/**
	 * 属性subsidyYear/subsidyYear的setter方法
	 */
	public void setSubsidyYear(String subsidyYear) {
		this.subsidyYear = subsidyYear;
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
	 * 属性subsidyCode/subsidyCode的getter方法
	 */
	public String getSubsidyCode() {
    		return subsidyCode;
	}
	/**
	 * 属性subsidyCode/subsidyCode的setter方法
	 */
	public void setSubsidyCode(String subsidyCode) {
		this.subsidyCode = subsidyCode;
	} 
	/**
	 * 属性subsidyType/subsidyType的getter方法
	 */
	public String getSubsidyType() {
    		return subsidyType;
	}
	/**
	 * 属性subsidyType/subsidyType的setter方法
	 */
	public void setSubsidyType(String subsidyType) {
		this.subsidyType = subsidyType;
	} 
}