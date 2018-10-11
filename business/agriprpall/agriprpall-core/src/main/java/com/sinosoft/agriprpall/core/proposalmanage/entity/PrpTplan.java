package com.sinosoft.agriprpall.core.proposalmanage.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;

import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-18 03:10:49.566 
 * 收费计划表实体操作对象
 */
@Entity
@Table(name = "PrpTplan")
@IdClass(PrpTplanKey.class)
public class PrpTplan extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性投保单号码/投保单号码 */
	@Id
	@Column(name = "proposalNo")
	private String proposalNo ;/** 属性交费次数序号/交费次数序号 */
	@Id
	@Column(name = "serialNo")
	private Integer serialNo ;

	/** 属性批单号码/批单号码 */
	@Column(name = "endorseNo")
	private String endorseNo ;

	/** 属性交费期次/交费期次 */
	@Column(name = "payNo")
	private Integer payNo ;
	/** 属性交费原因/交费原因 */
	@Column(name = "payReason")
	private String payReason ;
	/** 属性计划交费截止日期/计划交费截止日期 */
	@Temporal(TemporalType.DATE)
	@Column(name = "planDate")
	private Date planDate ;
	/** 属性币别/币别 */
	@Column(name = "currency")
	private String currency ;
	/** 属性应交费金额/应交费金额 */
	@Column(name = "planFee")
	private Double planFee ;
	/** 属性拖欠金额/拖欠金额 delinquent 拖欠债务的 */
	@Column(name = "delinquentFee")
	private Double delinquentFee ;
	/** 属性标志字段/标志字段 */
	@Column(name = "flag")
	private String flag ;
	/** 属性planstartFate/planstartFate */
	@Temporal(TemporalType.DATE)
	@Column(name = "planstartDate")
	private Date planStartDate ;
	/** 属性planRate/planRate */
	@Column(name = "planRate")
	private Double planRate ;
	/** 属性签单币种/签单币种 */
	@Column(name = "currency2")
	private String currency2 ;
	/** 属性签单币种与本位币种的兑换率/签单币种与本位币种的兑换率 */
	@Column(name = "exchangeRateCNY")
	private Double exchangeRateCNY ;
	/** 属性签单币种下的费用/签单币种下的费用 */
	@Column(name = "planFee2")
	private Double planFee2 ;
	/** 属性总不含税保费/总不含税保费 */
	@Column(name = "noTaxPremium")
	private Double noTaxPremium ;
	/** 属性总税额/总税额 */
	@Column(name = "taxFee")
	private Double taxFee ;
	/**
	 * 属性投保单号码/投保单号码的getter方法
	 */
	public String getProposalNo() {
		return proposalNo;
	}
	/**
	 * 属性投保单号码/投保单号码的setter方法
	 */
	public void setProposalNo(String proposalNo) {
		this.proposalNo = proposalNo;
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
	 * 属性交费次数序号/交费次数序号的getter方法
	 */
	public Integer getSerialNo() {
		return serialNo;
	}
	/**
	 * 属性交费次数序号/交费次数序号的setter方法
	 */
	public void setSerialNo(Integer serialNo) {
		this.serialNo = serialNo;
	} 	
	/**
	 * 属性交费期次/交费期次的getter方法
	 */
	public Integer getPayNo() {
		return payNo;
	}
	/**
	 * 属性交费期次/交费期次的setter方法
	 */
	public void setPayNo(Integer payNo) {
		this.payNo = payNo;
	} 	
	/**
	 * 属性交费原因/交费原因的getter方法
	 */
	public String getPayReason() {
		return payReason;
	}
	/**
	 * 属性交费原因/交费原因的setter方法
	 */
	public void setPayReason(String payReason) {
		this.payReason = payReason;
	} 	
	/**
	 * 属性计划交费截止日期/计划交费截止日期的getter方法
	 */
	public Date getPlanDate() {
		return planDate;
	}
	/**
	 * 属性计划交费截止日期/计划交费截止日期的setter方法
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
	 * 属性应交费金额/应交费金额的getter方法
	 */
	public Double getPlanFee() {
		return planFee;
	}
	/**
	 * 属性应交费金额/应交费金额的setter方法
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
	 * 属性planstartFate/planstartDate的getter方法
	 */
	public Date getPlanStartDate() {
		return planStartDate;
	}
	/**
	 * 属性planstartFate/planstartDate的setter方法
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
	 * 属性签单币种/签单币种的getter方法
	 */
	public String getCurrency2() {
		return currency2;
	}
	/**
	 * 属性签单币种/签单币种的setter方法
	 */
	public void setCurrency2(String currency2) {
		this.currency2 = currency2;
	}

	public Double getExchangeRateCNY() {
		return exchangeRateCNY;
	}

	public void setExchangeRateCNY(Double exchangeRateCNY) {
		this.exchangeRateCNY = exchangeRateCNY;
	}

	/**
	 * 属性签单币种下的费用/签单币种下的费用的getter方法
	 */
	public Double getPlanFee2() {
		return planFee2;
	}
	/**
	 * 属性签单币种下的费用/签单币种下的费用的setter方法
	 */
	public void setPlanFee2(Double planFee2) {
		this.planFee2 = planFee2;
	} 	
	/**
	 * 属性总不含税保费/总不含税保费的getter方法
	 */
	public Double getNoTaxPremium() {
		return noTaxPremium;
	}
	/**
	 * 属性总不含税保费/总不含税保费的setter方法
	 */
	public void setNoTaxPremium(Double noTaxPremium) {
		this.noTaxPremium = noTaxPremium;
	} 	
	/**
	 * 属性总税额/总税额的getter方法
	 */
	public Double getTaxFee() {
		return taxFee;
	}
	/**
	 * 属性总税额/总税额的setter方法
	 */
	public void setTaxFee(Double taxFee) {
		this.taxFee = taxFee;
	} 	
}