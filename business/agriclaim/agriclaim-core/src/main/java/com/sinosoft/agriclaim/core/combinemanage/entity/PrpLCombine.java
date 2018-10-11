package com.sinosoft.agriclaim.core.combinemanage.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-25 08:10:12.537 
 * 并案关联表实体操作对象
 */
@Entity
@Table(name = "PrpLCombine")
@IdClass(PrpLCombineKey.class)
public class PrpLCombine extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性报案号码/报案号码 */
	@Id
	@Column(name = "registNo")
	private String registNo ;	

	/** 属性保单号码/保单号码 */
	@Column(name = "PolicyNo")
	private String policyNo ;
	/** 属性事故号码/事故号码 */
	@Column(name = "CombineNo")
	private String combineNo ;
	/** 属性修改人/修改人 */
	@Column(name = "Update_By")
	private String updateBy ;
	/** 属性修改日期/修改日期 */
	@Column(name = "Update_Date")
	private java.util.Date updateDate ;
	/**
	 * 属性报案号码/报案号码的getter方法
	 */
	public String getRegistNo() {
		return registNo;
	}
	/**
	 * 属性报案号码/报案号码的setter方法
	 */
	public void setRegistNo(String registNo) {
		this.registNo = registNo;
	} 	
	/**
	 * 属性保单号码/保单号码的getter方法
	 */
	public String getPolicyNo() {
		return policyNo;
	}
	/**
	 * 属性保单号码/保单号码的setter方法
	 */
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	} 	
	/**
	 * 属性事故号码/事故号码的getter方法
	 */
	public String getCombineNo() {
		return combineNo;
	}
	/**
	 * 属性事故号码/事故号码的setter方法
	 */
	public void setCombineNo(String combineNo) {
		this.combineNo = combineNo;
	} 	
	/**
	 * 属性修改人/修改人的getter方法
	 */
	public String getUpdateBy() {
		return updateBy;
	}
	/**
	 * 属性修改人/修改人的setter方法
	 */
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	} 	
	/**
	 * 属性修改日期/修改日期的getter方法
	 */
	public java.util.Date getUpdateDate() {
		return updateDate;
	}
	/**
	 * 属性修改日期/修改日期的setter方法
	 */
	public void setUpdateDate(java.util.Date updateDate) {
		this.updateDate = updateDate;
	} 	
}