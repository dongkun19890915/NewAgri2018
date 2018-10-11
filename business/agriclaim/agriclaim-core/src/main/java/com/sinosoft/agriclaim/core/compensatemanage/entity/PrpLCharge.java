package com.sinosoft.agriclaim.core.compensatemanage.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:40:44.225 
 * 赔款费用信息表实体操作对象
 */
@Entity
@Table(name = "PrpLCharge")
@IdClass(PrpLChargeKey.class)
public class PrpLCharge extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性赔款计算书号/赔款计算书号 */
	@Id
	@Column(name = "compensateNo")
	private String compensateNo ;/** 属性序号/序号 */
	@Id
	@Column(name = "serialNo")
	private java.lang.Integer serialNo ;	

	/** 属性险种/险种 */
	@Column(name = "riskCode")
	private String riskCode ;
	/** 属性保单号/保单号 */
	@Column(name = "policyNo")
	private String policyNo ;

	/** 属性险别代码/险别代码 */
	@Column(name = "kindCode")
	private String kindCode ;
	/** 属性费用类别代码/费用类别代码 */
	@Column(name = "chargeCode")
	private String chargeCode ;
	/** 属性费用名称/费用名称 */
	@Column(name = "chargeName")
	private String chargeName ;
	/** 属性币别代码/币别代码 */
	@Column(name = "currency")
	private String currency ;
	/** 属性费用金额/费用金额 */
	@Column(name = "chargeAmount")
	private java.lang.Double chargeAmount ;
	/** 属性计入赔款金额/计入赔款金额 */
	@Column(name = "sumRealPay")
	private java.lang.Double sumRealPay ;
	/** 属性标志字段/标志字段 */
	@Column(name = "flag")
	private String flag ;
	/** 属性录入时间/录入时间 */
	@Column(name = "inputDate")
	private java.util.Date inputDate ;
	/** 属性费用信息标志/费用信息标志 */
	@Column(name = "changeFlag")
	private String changeFlag ;
	/** 属性费用信息报告/费用信息报告 */
	@Column(name = "chargeReport")
	private java.lang.Double chargeReport ;
	/** 属性支付对象类型/支付对象类型 */
	@Column(name = "payObjectType")
	private String payObjectType ;
	/** 属性支付对象代码/支付对象代码 */
	@Column(name = "payObjectCode")
	private String payObjectCode ;
	/** 属性支付对象姓名/支付对象姓名 */
	@Column(name = "payObjectName")
	private String payObjectName ;
	/** 属性保单标的序号/保单标的序号 */
	@Column(name = "itemKindNo")
	private java.lang.Integer itemKindNo ;
	/** 属性预支付数量/预支付数量 */
	@Column(name = "prechargeAmount")
	private java.lang.Integer prechargeAmount ;
	/** 属性检查代码/检查代码 */
	@Column(name = "checkDeptCode")
	private String checkDeptCode ;
	/** 属性检查姓名/检查姓名 */
	@Column(name = "checkDeptName")
	private String checkDeptName ;
	/** 属性本次费用/本次费用 */
	@Column(name = "thisAmount")
	private java.lang.Double thisAmount ;
	/** 属性修改人/修改人 */
	@Column(name = "update_By")
	private String updateBy ;
	/** 属性修改日期/修改日期 */
	@Column(name = "update_Date")
	private java.util.Date updateDate ;
	/**
	 * 属性赔款计算书号/赔款计算书号的getter方法
	 */
	public String getCompensateNo() {
		return compensateNo;
	}
	/**
	 * 属性赔款计算书号/赔款计算书号的setter方法
	 */
	public void setCompensateNo(String compensateNo) {
		this.compensateNo = compensateNo;
	} 	
	/**
	 * 属性险种/险种的getter方法
	 */
	public String getRiskCode() {
		return riskCode;
	}
	/**
	 * 属性险种/险种的setter方法
	 */
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	} 	
	/**
	 * 属性保单号/保单号的getter方法
	 */
	public String getPolicyNo() {
		return policyNo;
	}
	/**
	 * 属性保单号/保单号的setter方法
	 */
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	} 	
	/**
	 * 属性序号/序号的getter方法
	 */
	public java.lang.Integer getSerialNo() {
		return serialNo;
	}
	/**
	 * 属性序号/序号的setter方法
	 */
	public void setSerialNo(java.lang.Integer serialNo) {
		this.serialNo = serialNo;
	} 	
	/**
	 * 属性险别代码/险别代码的getter方法
	 */
	public String getKindCode() {
		return kindCode;
	}
	/**
	 * 属性险别代码/险别代码的setter方法
	 */
	public void setKindCode(String kindCode) {
		this.kindCode = kindCode;
	} 	
	/**
	 * 属性费用类别代码/费用类别代码的getter方法
	 */
	public String getChargeCode() {
		return chargeCode;
	}
	/**
	 * 属性费用类别代码/费用类别代码的setter方法
	 */
	public void setChargeCode(String chargeCode) {
		this.chargeCode = chargeCode;
	} 	
	/**
	 * 属性费用名称/费用名称的getter方法
	 */
	public String getChargeName() {
		return chargeName;
	}
	/**
	 * 属性费用名称/费用名称的setter方法
	 */
	public void setChargeName(String chargeName) {
		this.chargeName = chargeName;
	} 	
	/**
	 * 属性币别代码/币别代码的getter方法
	 */
	public String getCurrency() {
		return currency;
	}
	/**
	 * 属性币别代码/币别代码的setter方法
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	} 	
	/**
	 * 属性费用金额/费用金额的getter方法
	 */
	public java.lang.Double getChargeAmount() {
		return chargeAmount;
	}
	/**
	 * 属性费用金额/费用金额的setter方法
	 */
	public void setChargeAmount(java.lang.Double chargeAmount) {
		this.chargeAmount = chargeAmount;
	} 	
	/**
	 * 属性计入赔款金额/计入赔款金额的getter方法
	 */
	public java.lang.Double getSumRealPay() {
		return sumRealPay;
	}
	/**
	 * 属性计入赔款金额/计入赔款金额的setter方法
	 */
	public void setSumRealPay(java.lang.Double sumRealPay) {
		this.sumRealPay = sumRealPay;
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
	 * 属性录入时间/录入时间的getter方法
	 */
	public java.util.Date getInputDate() {
		return inputDate;
	}
	/**
	 * 属性录入时间/录入时间的setter方法
	 */
	public void setInputDate(java.util.Date inputDate) {
		this.inputDate = inputDate;
	} 	
	/**
	 * 属性费用信息标志/费用信息标志的getter方法
	 */
	public String getChangeFlag() {
		return changeFlag;
	}
	/**
	 * 属性费用信息标志/费用信息标志的setter方法
	 */
	public void setChangeFlag(String changeFlag) {
		this.changeFlag = changeFlag;
	} 	
	/**
	 * 属性费用信息报告/费用信息报告的getter方法
	 */
	public java.lang.Double getChargeReport() {
		return chargeReport;
	}
	/**
	 * 属性费用信息报告/费用信息报告的setter方法
	 */
	public void setChargeReport(java.lang.Double chargeReport) {
		this.chargeReport = chargeReport;
	} 	
	/**
	 * 属性支付对象类型/支付对象类型的getter方法
	 */
	public String getPayObjectType() {
		return payObjectType;
	}
	/**
	 * 属性支付对象类型/支付对象类型的setter方法
	 */
	public void setPayObjectType(String payObjectType) {
		this.payObjectType = payObjectType;
	} 	
	/**
	 * 属性支付对象代码/支付对象代码的getter方法
	 */
	public String getPayObjectCode() {
		return payObjectCode;
	}
	/**
	 * 属性支付对象代码/支付对象代码的setter方法
	 */
	public void setPayObjectCode(String payObjectCode) {
		this.payObjectCode = payObjectCode;
	} 	
	/**
	 * 属性支付对象姓名/支付对象姓名的getter方法
	 */
	public String getPayObjectName() {
		return payObjectName;
	}
	/**
	 * 属性支付对象姓名/支付对象姓名的setter方法
	 */
	public void setPayObjectName(String payObjectName) {
		this.payObjectName = payObjectName;
	} 	
	/**
	 * 属性保单标的序号/保单标的序号的getter方法
	 */
	public java.lang.Integer getItemKindNo() {
		return itemKindNo;
	}
	/**
	 * 属性保单标的序号/保单标的序号的setter方法
	 */
	public void setItemKindNo(java.lang.Integer itemKindNo) {
		this.itemKindNo = itemKindNo;
	} 	
	/**
	 * 属性预支付数量/预支付数量的getter方法
	 */
	public java.lang.Integer getPrechargeAmount() {
		return prechargeAmount;
	}
	/**
	 * 属性预支付数量/预支付数量的setter方法
	 */
	public void setPrechargeAmount(java.lang.Integer prechargeAmount) {
		this.prechargeAmount = prechargeAmount;
	} 	
	/**
	 * 属性检查代码/检查代码的getter方法
	 */
	public String getCheckDeptCode() {
		return checkDeptCode;
	}
	/**
	 * 属性检查代码/检查代码的setter方法
	 */
	public void setCheckDeptCode(String checkDeptCode) {
		this.checkDeptCode = checkDeptCode;
	} 	
	/**
	 * 属性检查姓名/检查姓名的getter方法
	 */
	public String getCheckDeptName() {
		return checkDeptName;
	}
	/**
	 * 属性检查姓名/检查姓名的setter方法
	 */
	public void setCheckDeptName(String checkDeptName) {
		this.checkDeptName = checkDeptName;
	} 	
	/**
	 * 属性本次费用/本次费用的getter方法
	 */
	public java.lang.Double getThisAmount() {
		return thisAmount;
	}
	/**
	 * 属性本次费用/本次费用的setter方法
	 */
	public void setThisAmount(java.lang.Double thisAmount) {
		this.thisAmount = thisAmount;
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