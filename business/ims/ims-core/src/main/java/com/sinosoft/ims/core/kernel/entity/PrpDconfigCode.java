package com.sinosoft.ims.core.kernel.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;

import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:10:12.703 
 * 开关配置表实体操作对象
 */
@Entity
@Table(name = "PrpDconfigCodeAgri")
@IdClass(PrpDconfigCodeKey.class)
public class PrpDconfigCode extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性id/id */
	@Id
	@Column(name = "id")
	private java.util.Date id ;	
	/** 属性period/period */
	@Column(name = "period")
	private String period ;
	/** 属性comCode/comCode */
	@Column(name = "comCode")
	private String comCode ;
	/** 属性riskCode/riskCode */
	@Column(name = "riskCode")
	private String riskCode ;
	/** 属性funType/funType */
	@Column(name = "funType")
	private String funType ;
	/** 属性recordType/recordType */
	@Column(name = "recordType")
	private String recordType ;
	/** 属性funName/funName */
	@Column(name = "funName")
	private String funName ;
	/** 属性startUsingDate/startUsingDate */
	@Column(name = "startUsingDate")
	private java.util.Date startUsingDate ;
	/** 属性extendChar1/extendChar1 */
	@Column(name = "extendChar1")
	private String extendChar1 ;
	/** 属性validStatus/validStatus */
	@Column(name = "validStatus")
	private String validStatus ;
	/** 属性flag/flag */
	@Column(name = "flag")
	private String flag ;
	/** 属性修改人/修改人 */
	@Column(name = "update_By")
	private String update_By ;
	/** 属性修改日期/修改日期 */
	@Column(name = "update_Date")
	private java.util.Date update_Date ;

	/**
	 * 属性period/period的getter方法
	 */
	public String getPeriod() {
		return period;
	}
	/**
	 * 属性period/period的setter方法
	 */
	public void setPeriod(String period) {
		this.period = period;
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
	 * 属性funType/funType的getter方法
	 */
	public String getFunType() {
		return funType;
	}
	/**
	 * 属性funType/funType的setter方法
	 */
	public void setFunType(String funType) {
		this.funType = funType;
	} 	
	/**
	 * 属性recordType/recordType的getter方法
	 */
	public String getRecordType() {
		return recordType;
	}
	/**
	 * 属性recordType/recordType的setter方法
	 */
	public void setRecordType(String recordType) {
		this.recordType = recordType;
	} 	
	/**
	 * 属性funName/funName的getter方法
	 */
	public String getFunName() {
		return funName;
	}
	/**
	 * 属性funName/funName的setter方法
	 */
	public void setFunName(String funName) {
		this.funName = funName;
	} 	
	/**
	 * 属性startUsingDate/startUsingDate的getter方法
	 */
	public java.util.Date getStartUsingDate() {
		return startUsingDate;
	}
	/**
	 * 属性startUsingDate/startUsingDate的setter方法
	 */
	public void setStartUsingDate(java.util.Date startUsingDate) {
		this.startUsingDate = startUsingDate;
	} 	
	/**
	 * 属性extendChar1/extendChar1的getter方法
	 */
	public String getExtendChar1() {
		return extendChar1;
	}
	/**
	 * 属性extendChar1/extendChar1的setter方法
	 */
	public void setExtendChar1(String extendChar1) {
		this.extendChar1 = extendChar1;
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
	 * 属性flag/flag的getter方法
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * 属性flag/flag的setter方法
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getUpdate_By() {
		return update_By;
	}

	public void setUpdate_By(String update_By) {
		this.update_By = update_By;
	}

	public Date getUpdate_Date() {
		return update_Date;
	}

	public void setUpdate_Date(Date update_Date) {
		this.update_Date = update_Date;
	}

	/**
	 * 属性id/id的getter方法
	 */
	public java.util.Date getId() {
		return id;
	}
	/**
	 * 属性id/id的setter方法
	 */
	public void setId(java.util.Date id) {
		this.id = id;
	} 	
}