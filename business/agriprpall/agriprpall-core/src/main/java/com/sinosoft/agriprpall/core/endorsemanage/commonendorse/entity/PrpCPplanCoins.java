package com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;

import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-06 07:02:50.066 
 * 收费计划表实体操作对象
 */
@Entity
@Table(name = "PrpCPplanCoins")
@IdClass(PrpCPplanCoinsKey.class)
public class PrpCPplanCoins extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性保单号码/保单号码 */
	@Id
	@Column(name = "policyNo")
	private String policyNo ;/** 属性缴费次数序号/缴费次数序号 */
	@Id
	@Column(name = "serialNo")
	private Integer serialNo ;/** 属性缴费原因/缴费原因 */
	@Id
	@Column(name = "payReason")
	private String payReason ;/** 属性coinsCode/coinsCode */
	@Id
	@Column(name = "coinsCode")
	private String coinsCode ;

	/** 属性批单号码/批单号码 */
	@Column(name = "endorseNo")
	private String endorseNo ;

	/** 属性缴费期次/缴费期次 */
	@Column(name = "payNo")
	private Integer payNo ;


	/** 属性缴费计划截止原因/缴费计划截止原因 */
	@Column(name = "planDate")
	private Date planDate ;
	/** 属性币别/币别 */
	@Column(name = "currency")
	private String currency ;
	/** 属性应缴费金额/应缴费金额 */
	@Column(name = "planFee")
	private Double planFee ;
	/** 属性拖欠金额/拖欠金额 */
	@Column(name = "delinquentFee")
	private Double delinquentFee ;
	/** 属性标志字段/标志字段 */
	@Column(name = "flag")
	private String flag ;
	/** 属性planStartDate/planStartDate */
	@Column(name = "planStartDate")
	private Date planStartDate ;
	/** 属性planRate/planRate */
	@Column(name = "planRate")
	private Double planRate ;
	/** 属性不含税保费/不含税保费 */
	@Column(name = "noTaxPremium")
	private Double noTaxPremium ;
	/** 属性税额/税额 */
	@Column(name = "taxFee")
	private Double taxFee ;
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
	 * 属性缴费次数序号/缴费次数序号的getter方法
	 */
	public Integer getSerialNo() {
		return serialNo;
	}
	/**
	 * 属性缴费次数序号/缴费次数序号的setter方法
	 */
	public void setSerialNo(Integer serialNo) {
		this.serialNo = serialNo;
	}
	/**
	 * 属性缴费期次/缴费期次的getter方法
	 */
	public Integer getPayNo() {
		return payNo;
	}
	/**
	 * 属性缴费期次/缴费期次的setter方法
	 */
	public void setPayNo(Integer payNo) {
		this.payNo = payNo;
	}
	/**
	 * 属性缴费原因/缴费原因的getter方法
	 */
	public String getPayReason() {
		return payReason;
	}
	/**
	 * 属性缴费原因/缴费原因的setter方法
	 */
	public void setPayReason(String payReason) {
		this.payReason = payReason;
	}
	/**
	 * 属性coinsCode/coinsCode的getter方法
	 */
	public String getCoinsCode() {
		return coinsCode;
	}
	/**
	 * 属性coinsCode/coinsCode的setter方法
	 */
	public void setCoinsCode(String coinsCode) {
		this.coinsCode = coinsCode;
	}
	/**
	 * 属性缴费计划截止原因/缴费计划截止原因的getter方法
	 */
	public Date getPlanDate() {
		return planDate;
	}
	/**
	 * 属性缴费计划截止原因/缴费计划截止原因的setter方法
	 */
	public void setPlanDate(Date planDate) {
		this.planDate = planDate;
	}
	/**
	 * 属性币别/币别的getter方法
	 */
	public String getCurrency() {
		return currency;
	}
	/**
	 * 属性币别/币别的setter方法
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	/**
	 * 属性应缴费金额/应缴费金额的getter方法
	 */
	public Double getPlanFee() {
		return planFee;
	}
	/**
	 * 属性应缴费金额/应缴费金额的setter方法
	 */
	public void setPlanFee(Double planFee) {
		this.planFee = planFee;
	}
	/**
	 * 属性拖欠金额/拖欠金额的getter方法
	 */
	public Double getDelinquentFee() {
		return delinquentFee;
	}
	/**
	 * 属性拖欠金额/拖欠金额的setter方法
	 */
	public void setDelinquentFee(Double delinquentFee) {
		this.delinquentFee = delinquentFee;
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
	 * 属性planStartDate/planStartDate的getter方法
	 */
	public Date getPlanStartDate() {
		return planStartDate;
	}
	/**
	 * 属性planStartDate/planStartDate的setter方法
	 */
	public void setPlanStartDate(Date planStartDate) {
		this.planStartDate = planStartDate;
	}
	/**
	 * 属性planRate/planRate的getter方法
	 */
	public Double getPlanRate() {
		return planRate;
	}
	/**
	 * 属性planRate/planRate的setter方法
	 */
	public void setPlanRate(Double planRate) {
		this.planRate = planRate;
	}
	/**
	 * 属性不含税保费/不含税保费的getter方法
	 */
	public Double getNoTaxPremium() {
		return noTaxPremium;
	}
	/**
	 * 属性不含税保费/不含税保费的setter方法
	 */
	public void setNoTaxPremium(Double noTaxPremium) {
		this.noTaxPremium = noTaxPremium;
	}
	/**
	 * 属性税额/税额的getter方法
	 */
	public Double getTaxFee() {
		return taxFee;
	}
	/**
	 * 属性税额/税额的setter方法
	 */
	public void setTaxFee(Double taxFee) {
		this.taxFee = taxFee;
	} 	
}