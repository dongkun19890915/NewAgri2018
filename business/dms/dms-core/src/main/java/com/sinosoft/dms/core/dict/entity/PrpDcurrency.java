package com.sinosoft.dms.core.dict.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:01:56.447 
 * 币别代码表实体操作对象
 */
@Entity
@Table(name = "PrpDcurrency")
@IdClass(PrpDcurrencyKey.class)
public class PrpDcurrency extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性币别代码/币别代码 */
	@Id
	@Column(name = "currencyCode")
	private String currencyCode ;	

	/** 属性币别中文名称/币别中文名称 */
	@Column(name = "currencyCName")
	private String currencyCName ;
	/** 属性币别英文名称/币别英文名称 */
	@Column(name = "currencyEName")
	private String currencyEName ;
	/** 属性最新币别代码/最新币别代码 */
	@Column(name = "newCurrencyCode")
	private String newCurrencyCode ;
	/** 属性帐套类型代码/帐套类型代码 */
	@Column(name = "accBookCode")
	private String accBookCode ;
	/** 属性效力状态(0失效/1有效)/效力状态(0失效/1有效) */
	@Column(name = "validStatus")
	private String validStatus ;
	/** 属性标志字段/标志字段 */
	@Column(name = "flag")
	private String flag ;
	/** 属性修改人/修改人 */
	@Column(name = "update_By")
	private String update_By ;
	/** 属性修改时间/修改时间 */
	@Column(name = "update_Date")
	private java.util.Date update_Date ;
	/** 属性updatedate/updatedate */
	@Column(name = "updateDate")
	private java.util.Date updateDate ;
	/** 属性updateby/updateby */
	@Column(name = "updateBy")
	private String updateBy ;
	/**
	 * 属性币别代码/币别代码的getter方法
	 */
	public String getCurrencyCode() {
		return currencyCode;
	}
	/**
	 * 属性币别代码/币别代码的setter方法
	 */
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	} 	
	/**
	 * 属性币别中文名称/币别中文名称的getter方法
	 */
	public String getCurrencyCName() {
		return currencyCName;
	}
	/**
	 * 属性币别中文名称/币别中文名称的setter方法
	 */
	public void setCurrencyCName(String currencyCName) {
		this.currencyCName = currencyCName;
	} 	
	/**
	 * 属性币别英文名称/币别英文名称的getter方法
	 */
	public String getCurrencyEName() {
		return currencyEName;
	}
	/**
	 * 属性币别英文名称/币别英文名称的setter方法
	 */
	public void setCurrencyEName(String currencyEName) {
		this.currencyEName = currencyEName;
	} 	
	/**
	 * 属性最新币别代码/最新币别代码的getter方法
	 */
	public String getNewCurrencyCode() {
		return newCurrencyCode;
	}
	/**
	 * 属性最新币别代码/最新币别代码的setter方法
	 */
	public void setNewCurrencyCode(String newCurrencyCode) {
		this.newCurrencyCode = newCurrencyCode;
	} 	
	/**
	 * 属性帐套类型代码/帐套类型代码的getter方法
	 */
	public String getAccBookCode() {
		return accBookCode;
	}
	/**
	 * 属性帐套类型代码/帐套类型代码的setter方法
	 */
	public void setAccBookCode(String accBookCode) {
		this.accBookCode = accBookCode;
	} 	
	/**
	 * 属性效力状态(0失效/1有效)/效力状态(0失效/1有效)的getter方法
	 */
	public String getValidStatus() {
		return validStatus;
	}
	/**
	 * 属性效力状态(0失效/1有效)/效力状态(0失效/1有效)的setter方法
	 */
	public void setValidStatus(String validStatus) {
		this.validStatus = validStatus;
	} 	
	/**
	 * 属性标志字段/标志字段的getter方法
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * 属性标志字段/标志字段的setter方法
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

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
}