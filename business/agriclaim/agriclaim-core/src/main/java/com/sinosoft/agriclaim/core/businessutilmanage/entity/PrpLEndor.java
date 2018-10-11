package com.sinosoft.agriclaim.core.businessutilmanage.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:35:28.283 
 * 理赔冲减保额表实体操作对象
 */
@Entity
@Table(name = "PrpLEndor")
@IdClass(PrpLEndorKey.class)
public class PrpLEndor extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性赔款计算书号码/赔款计算书号码 */
	@Id
	@Column(name = "compensateNo")
	private String compensateNo ;/** 属性保单号码/保单号码 */
	@Id
	@Column(name = "policyNo")
	private String policyNo ;/** 属性批单类型/批单类型 */
	@Id
	@Column(name = "endorType")
	private String endorType ;	
	/** 属性立案号码/立案号码 */
	@Column(name = "claimNo")
	private String claimNo ;


	/** 属性保险单标的子险序号/保险单标的子险序号 */
	@Column(name = "itemkindNo")
	private java.lang.Double itemkindNo ;
	/** 属性标的项目类别/标的项目类别 */
	@Column(name = "itemCode")
	private String itemCode ;
	/** 属性标的项目名称/标的项目名称 */
	@Column(name = "itemName")
	private String itemName ;
	/** 属性险别代码 /险别代码  */
	@Column(name = "kindCode")
	private String kindCode ;
	/** 属性险别名称/险别名称 */
	@Column(name = "kindName")
	private String kindName ;
	/** 属性币别（保单标的币别）/币别（保单标的币别） */
	@Column(name = "currency")
	private String currency ;
	/** 属性冲减保额/赔款金额/冲减保额/赔款金额 */
	@Column(name = "endorAmount")
	private java.lang.Double endorAmount ;
	/** 属性输入日期/输入日期 */
	@Column(name = "inputDate")
	private java.util.Date inputDate ;
	/** 属性标志字段/标志字段 */
	@Column(name = "flag")
	private String flag ;
	/** 属性批单号码/批单号码 */
	@Column(name = "endorseNo")
	private String endorseNo ;

	/** 属性属性（endorGrossQuantity）/属性（endorGrossQuantity） */
	@Column(name = "endorGrossQuantity")
	private java.lang.Double endorGrossQuantity ;
	/** 属性修改人/修改人 */
	@Column(name = "update_By")
	private String updateBy ;
	/** 属性修改时间/修改时间 */
	@Column(name = "update_Date")
	private java.util.Date updateDate ;
	/**
	 * 属性立案号码/立案号码的getter方法
	 */
	public String getClaimNo() {
		return claimNo;
	}
	/**
	 * 属性立案号码/立案号码的setter方法
	 */
	public void setClaimNo(String claimNo) {
		this.claimNo = claimNo;
	} 	
	/**
	 * 属性赔款计算书号码/赔款计算书号码的getter方法
	 */
	public String getCompensateNo() {
		return compensateNo;
	}
	/**
	 * 属性赔款计算书号码/赔款计算书号码的setter方法
	 */
	public void setCompensateNo(String compensateNo) {
		this.compensateNo = compensateNo;
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
	 * 属性保险单标的子险序号/保险单标的子险序号的getter方法
	 */
	public java.lang.Double getItemkindNo() {
		return itemkindNo;
	}
	/**
	 * 属性保险单标的子险序号/保险单标的子险序号的setter方法
	 */
	public void setItemkindNo(java.lang.Double itemkindNo) {
		this.itemkindNo = itemkindNo;
	} 	
	/**
	 * 属性标的项目类别/标的项目类别的getter方法
	 */
	public String getItemCode() {
		return itemCode;
	}
	/**
	 * 属性标的项目类别/标的项目类别的setter方法
	 */
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	} 	
	/**
	 * 属性标的项目名称/标的项目名称的getter方法
	 */
	public String getItemName() {
		return itemName;
	}
	/**
	 * 属性标的项目名称/标的项目名称的setter方法
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	} 	
	/**
	 * 属性险别代码 /险别代码 的getter方法
	 */
	public String getKindCode() {
		return kindCode;
	}
	/**
	 * 属性险别代码 /险别代码 的setter方法
	 */
	public void setKindCode(String kindCode) {
		this.kindCode = kindCode;
	} 	
	/**
	 * 属性险别名称/险别名称的getter方法
	 */
	public String getKindName() {
		return kindName;
	}
	/**
	 * 属性险别名称/险别名称的setter方法
	 */
	public void setKindName(String kindName) {
		this.kindName = kindName;
	} 	
	/**
	 * 属性币别（保单标的币别）/币别（保单标的币别）的getter方法
	 */
	public String getCurrency() {
		return currency;
	}
	/**
	 * 属性币别（保单标的币别）/币别（保单标的币别）的setter方法
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	} 	
	/**
	 * 属性冲减保额/赔款金额/冲减保额/赔款金额的getter方法
	 */
	public java.lang.Double getEndorAmount() {
		return endorAmount;
	}
	/**
	 * 属性冲减保额/赔款金额/冲减保额/赔款金额的setter方法
	 */
	public void setEndorAmount(java.lang.Double endorAmount) {
		this.endorAmount = endorAmount;
	} 	
	/**
	 * 属性输入日期/输入日期的getter方法
	 */
	public java.util.Date getInputDate() {
		return inputDate;
	}
	/**
	 * 属性输入日期/输入日期的setter方法
	 */
	public void setInputDate(java.util.Date inputDate) {
		this.inputDate = inputDate;
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
	/**
	 * 属性批单号码/批单号码的getter方法
	 */
	public String getEndorseNo() {
		return endorseNo;
	}
	/**
	 * 属性批单号码/批单号码的setter方法
	 */
	public void setEndorseNo(String endorseNo) {
		this.endorseNo = endorseNo;
	} 	
	/**
	 * 属性批单类型/批单类型的getter方法
	 */
	public String getEndorType() {
		return endorType;
	}
	/**
	 * 属性批单类型/批单类型的setter方法
	 */
	public void setEndorType(String endorType) {
		this.endorType = endorType;
	} 	
	/**
	 * 属性属性（endorGrossQuantity）/属性（endorGrossQuantity）的getter方法
	 */
	public java.lang.Double getEndorGrossQuantity() {
		return endorGrossQuantity;
	}
	/**
	 * 属性属性（endorGrossQuantity）/属性（endorGrossQuantity）的setter方法
	 */
	public void setEndorGrossQuantity(java.lang.Double endorGrossQuantity) {
		this.endorGrossQuantity = endorGrossQuantity;
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
	 * 属性修改时间/修改时间的getter方法
	 */
	public java.util.Date getUpdateDate() {
		return updateDate;
	}
	/**
	 * 属性修改时间/修改时间的setter方法
	 */
	public void setUpdateDate(java.util.Date updateDate) {
		this.updateDate = updateDate;
	} 	
}