package com.sinosoft.pms.core.kernel.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-04 10:42:46.546 
 * PrpDkindItem实体操作对象
 */
@Entity
@Table(name = "PrpDkindItemAgri")
@IdClass(PrpDkindItemKey.class)
public class PrpDkindItem extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性riskCode/riskCode */
	@Id
	@Column(name = "riskCode")
	private String riskCode ;/** 属性kindCode/kindCode */
	@Id
	@Column(name = "kindCode")
	private String kindCode ;/** 属性itemCode/itemCode */
	@Id
	@Column(name = "itemCode")
	private String itemCode ;	



	/** 属性flag/flag */
	@Column(name = "flag")
	private String flag ;
	/** 属性修改人/修改人 */
	@Column(name = "update_By")
	private String update_By ;
	/** 属性修改时间/修改时间 */
	@Column(name = "update_Date")
	private java.util.Date update_Date ;
	/** 主茬次标识 */
	@Column(name = "mainTimes")
	private String mainTimes ;
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
	 * 属性kindCode/kindCode的getter方法
	 */
	public String getKindCode() {
		return kindCode;
	}
	/**
	 * 属性kindCode/kindCode的setter方法
	 */
	public void setKindCode(String kindCode) {
		this.kindCode = kindCode;
	} 	
	/**
	 * 属性itemCode/itemCode的getter方法
	 */
	public String getItemCode() {
		return itemCode;
	}
	/**
	 * 属性itemCode/itemCode的setter方法
	 */
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
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

	public String getMainTimes() {
		return mainTimes;
	}

	public void setMainTimes(String mainTimes) {
		this.mainTimes = mainTimes;
	}
}