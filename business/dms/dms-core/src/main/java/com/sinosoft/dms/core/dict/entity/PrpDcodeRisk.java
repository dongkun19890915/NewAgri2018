package com.sinosoft.dms.core.dict.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;

import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:01:56.447 
 * 通用代码险种对照表实体操作对象
 */
@Entity
@Table(name = "PrpDcodeRiskAgri")
@IdClass(PrpDcodeRiskKey.class)
public class PrpDcodeRisk extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性代码类型(见PrpDtype表)/代码类型(见PrpDtype表) */
	@Id
	@Column(name = "codeType")
	private String codeType ;/** 属性业务代码(见PrpDcode)/业务代码(见PrpDcode) */
	@Id
	@Column(name = "codeCode")
	private String codeCode ;/** 属性险种代码(见PrpDrisk)/险种代码(见PrpDrisk) */
	@Id
	@Column(name = "riskCode")
	private String riskCode ;	



	/** 属性顺序/顺序 */
	@Column(name = "flag")
	private String flag ;
	/** 属性修改人/修改人 */
	@Column(name = "update_By")
	private String update_By ;
	/** 属性修改时间/修改时间 */
	@Column(name = "update_Date")
	private java.util.Date update_Date ;
	/** 属性createdBy/createdBy */
	@Column(name = "updateBy")
	private String updateBy ;
	/** 属性createdTime/createdTime */
	@Column(name = "updateDate")
	private java.util.Date updateDate ;
	/**
	 * 属性代码类型(见PrpDtype表)/代码类型(见PrpDtype表)的getter方法
	 */
	public String getCodeType() {
		return codeType;
	}
	/**
	 * 属性代码类型(见PrpDtype表)/代码类型(见PrpDtype表)的setter方法
	 */
	public void setCodeType(String codeType) {
		this.codeType = codeType;
	} 	
	/**
	 * 属性业务代码(见PrpDcode)/业务代码(见PrpDcode)的getter方法
	 */
	public String getCodeCode() {
		return codeCode;
	}
	/**
	 * 属性业务代码(见PrpDcode)/业务代码(见PrpDcode)的setter方法
	 */
	public void setCodeCode(String codeCode) {
		this.codeCode = codeCode;
	} 	
	/**
	 * 属性险种代码(见PrpDrisk)/险种代码(见PrpDrisk)的getter方法
	 */
	public String getRiskCode() {
		return riskCode;
	}
	/**
	 * 属性险种代码(见PrpDrisk)/险种代码(见PrpDrisk)的setter方法
	 */
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	} 	
	/**
	 * 属性顺序/顺序的getter方法
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * 属性顺序/顺序的setter方法
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

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
}