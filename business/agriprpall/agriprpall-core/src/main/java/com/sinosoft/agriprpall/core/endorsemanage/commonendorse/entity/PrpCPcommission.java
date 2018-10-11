package com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;

import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-04 10:00:38.844 
 * 手续费表实体操作对象
 */
@Entity
@Table(name = "PrpCPcommission")
@IdClass(PrpCPcommissionKey.class)
public class PrpCPcommission extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性保单号/保单号 */
	@Id
	@Column(name = "policyNo")
	private String policyNo ;/** 属性险种代码/险种代码 */
	@Id
	@Column(name = "riskCode")
	private String riskCode ;	

	/** 属性agreementNo/agreementNo */
	@Column(name = "agreementNo")
	private String agreementNo ;
	/** 属性customerGroupCode/customerGroupCode */
	@Column(name = "customerGroupCode")
	private String customerGroupCode ;
	/** 属性费用类型/费用类型 */
	@Column(name = "costType")
	private String costType ;

	/** 属性总保费/总保费 */
	@Column(name = "sumPremium")
	private Double sumPremium ;
	/** 属性费用比例/费用比例 */
	@Column(name = "costRate")
	private Double costRate ;
	/** 属性费用默认上限/费用默认上限 */
	@Column(name = "costRateUpper")
	private Double costRateUpper ;
	/** 属性是否调整/是否调整 */
	@Column(name = "adjustFlag")
	private String adjustFlag ;
	/** 属性是否可超上限/是否可超上限 */
	@Column(name = "upperFlag")
	private String upperFlag ;
	/** 属性核保辅助绝对上限/核保辅助绝对上限 */
	@Column(name = "auditRate")
	private Double auditRate ;
	/** 属性超上限人工核保/超上限人工核保 */
	@Column(name = "auditFlag")
	private String auditFlag ;
	/** 属性共保份额/共保份额 */
	@Column(name = "coinsRate")
	private Double coinsRate ;
	/** 属性分保扣除/分保扣除 */
	@Column(name = "coinsDeduct")
	private String coinsDeduct ;
	/** 属性币别/币别 */
	@Column(name = "currency")
	private String currency ;
	/** 属性费用金额/费用金额 */
	@Column(name = "costFee")
	private Double costFee ;
	/** 属性销管费用金额--佣金上限/销管费用金额--佣金上限 */
	@Column(name = "configCode")
	private String configCode ;
	/** 属性费用拆分方案代码/费用拆分方案代码 */
	@Column(name = "amortizeFlag")
	private String amortizeFlag ;
	/** 属性clauseKindFlag/clauseKindFlag */
	@Column(name = "clauseKindFlag")
	private String clauseKindFlag ;
	/** 属性备注/备注 */
	@Column(name = "remark")
	private String remark ;
	/** 属性标志/标志 */
	@Column(name = "flag")
	private String flag ;
	/** 属性insertTimeForHis/insertTimeForHis */
	@Column(name = "insertTimeForHis")
	private Date insertTimeForHis ;
	/** 属性operateTimeForHis/operateTimeForHis */
	@Column(name = "operateTimeForHis")
	private Date operateTimeForHis ;
	/** 属性planCode/planCode */
	@Column(name = "planCode")
	private String planCode ;
	/** 属性投保单号/投保单号 */
	@Column(name = "proposalNo")
	private String proposalNo ;
	/** 属性costFeeOrg/costFeeOrg */
	@Column(name = "costFeeOrg")
	private Double costFeeOrg ;
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
	 * 属性agreementNo/agreementNo的getter方法
	 */
	public String getAgreementNo() {
		return agreementNo;
	}
	/**
	 * 属性agreementNo/agreementNo的setter方法
	 */
	public void setAgreementNo(String agreementNo) {
		this.agreementNo = agreementNo;
	} 	
	/**
	 * 属性customerGroupCode/customerGroupCode的getter方法
	 */
	public String getCustomerGroupCode() {
		return customerGroupCode;
	}
	/**
	 * 属性customerGroupCode/customerGroupCode的setter方法
	 */
	public void setCustomerGroupCode(String customerGroupCode) {
		this.customerGroupCode = customerGroupCode;
	} 	
	/**
	 * 属性费用类型/费用类型的getter方法
	 */
	public String getCostType() {
		return costType;
	}
	/**
	 * 属性费用类型/费用类型的setter方法
	 */
	public void setCostType(String costType) {
		this.costType = costType;
	} 	
	/**
	 * 属性险种代码/险种代码的getter方法
	 */
	public String getRiskCode() {
		return riskCode;
	}
	/**
	 * 属性险种代码/险种代码的setter方法
	 */
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	} 	
	/**
	 * 属性总保费/总保费的getter方法
	 */
	public Double getSumPremium() {
		return sumPremium;
	}
	/**
	 * 属性总保费/总保费的setter方法
	 */
	public void setSumPremium(Double sumPremium) {
		this.sumPremium = sumPremium;
	} 	
	/**
	 * 属性费用比例/费用比例的getter方法
	 */
	public Double getCostRate() {
		return costRate;
	}
	/**
	 * 属性费用比例/费用比例的setter方法
	 */
	public void setCostRate(Double costRate) {
		this.costRate = costRate;
	} 	
	/**
	 * 属性费用默认上限/费用默认上限的getter方法
	 */
	public Double getCostRateUpper() {
		return costRateUpper;
	}
	/**
	 * 属性费用默认上限/费用默认上限的setter方法
	 */
	public void setCostRateUpper(Double costRateUpper) {
		this.costRateUpper = costRateUpper;
	} 	
	/**
	 * 属性是否调整/是否调整的getter方法
	 */
	public String getAdjustFlag() {
		return adjustFlag;
	}
	/**
	 * 属性是否调整/是否调整的setter方法
	 */
	public void setAdjustFlag(String adjustFlag) {
		this.adjustFlag = adjustFlag;
	} 	
	/**
	 * 属性是否可超上限/是否可超上限的getter方法
	 */
	public String getUpperFlag() {
		return upperFlag;
	}
	/**
	 * 属性是否可超上限/是否可超上限的setter方法
	 */
	public void setUpperFlag(String upperFlag) {
		this.upperFlag = upperFlag;
	} 	
	/**
	 * 属性核保辅助绝对上限/核保辅助绝对上限的getter方法
	 */
	public Double getAuditRate() {
		return auditRate;
	}
	/**
	 * 属性核保辅助绝对上限/核保辅助绝对上限的setter方法
	 */
	public void setAuditRate(Double auditRate) {
		this.auditRate = auditRate;
	} 	
	/**
	 * 属性超上限人工核保/超上限人工核保的getter方法
	 */
	public String getAuditFlag() {
		return auditFlag;
	}
	/**
	 * 属性超上限人工核保/超上限人工核保的setter方法
	 */
	public void setAuditFlag(String auditFlag) {
		this.auditFlag = auditFlag;
	} 	
	/**
	 * 属性共保份额/共保份额的getter方法
	 */
	public Double getCoinsRate() {
		return coinsRate;
	}
	/**
	 * 属性共保份额/共保份额的setter方法
	 */
	public void setCoinsRate(Double coinsRate) {
		this.coinsRate = coinsRate;
	} 	
	/**
	 * 属性分保扣除/分保扣除的getter方法
	 */
	public String getCoinsDeduct() {
		return coinsDeduct;
	}
	/**
	 * 属性分保扣除/分保扣除的setter方法
	 */
	public void setCoinsDeduct(String coinsDeduct) {
		this.coinsDeduct = coinsDeduct;
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
	 * 属性费用金额/费用金额的getter方法
	 */
	public Double getCostFee() {
		return costFee;
	}
	/**
	 * 属性费用金额/费用金额的setter方法
	 */
	public void setCostFee(Double costFee) {
		this.costFee = costFee;
	} 	
	/**
	 * 属性销管费用金额--佣金上限/销管费用金额--佣金上限的getter方法
	 */
	public String getConfigCode() {
		return configCode;
	}
	/**
	 * 属性销管费用金额--佣金上限/销管费用金额--佣金上限的setter方法
	 */
	public void setConfigCode(String configCode) {
		this.configCode = configCode;
	} 	
	/**
	 * 属性费用拆分方案代码/费用拆分方案代码的getter方法
	 */
	public String getAmortizeFlag() {
		return amortizeFlag;
	}
	/**
	 * 属性费用拆分方案代码/费用拆分方案代码的setter方法
	 */
	public void setAmortizeFlag(String amortizeFlag) {
		this.amortizeFlag = amortizeFlag;
	} 	
	/**
	 * 属性clauseKindFlag/clauseKindFlag的getter方法
	 */
	public String getClauseKindFlag() {
		return clauseKindFlag;
	}
	/**
	 * 属性clauseKindFlag/clauseKindFlag的setter方法
	 */
	public void setClauseKindFlag(String clauseKindFlag) {
		this.clauseKindFlag = clauseKindFlag;
	} 	
	/**
	 * 属性备注/备注的getter方法
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * 属性备注/备注的setter方法
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	} 	
	/**
	 * 属性标志/标志的getter方法
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * 属性标志/标志的setter方法
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	} 	
	/**
	 * 属性insertTimeForHis/insertTimeForHis的getter方法
	 */
	public Date getInsertTimeForHis() {
		return insertTimeForHis;
	}
	/**
	 * 属性insertTimeForHis/insertTimeForHis的setter方法
	 */
	public void setInsertTimeForHis(Date insertTimeForHis) {
		this.insertTimeForHis = insertTimeForHis;
	} 	
	/**
	 * 属性operateTimeForHis/operateTimeForHis的getter方法
	 */
	public Date getOperateTimeForHis() {
		return operateTimeForHis;
	}
	/**
	 * 属性operateTimeForHis/operateTimeForHis的setter方法
	 */
	public void setOperateTimeForHis(Date operateTimeForHis) {
		this.operateTimeForHis = operateTimeForHis;
	} 	
	/**
	 * 属性planCode/planCode的getter方法
	 */
	public String getPlanCode() {
		return planCode;
	}
	/**
	 * 属性planCode/planCode的setter方法
	 */
	public void setPlanCode(String planCode) {
		this.planCode = planCode;
	} 	
	/**
	 * 属性投保单号/投保单号的getter方法
	 */
	public String getProposalNo() {
		return proposalNo;
	}
	/**
	 * 属性投保单号/投保单号的setter方法
	 */
	public void setProposalNo(String proposalNo) {
		this.proposalNo = proposalNo;
	} 	
	/**
	 * 属性costFeeOrg/costFeeOrg的getter方法
	 */
	public Double getCostFeeOrg() {
		return costFeeOrg;
	}
	/**
	 * 属性costFeeOrg/costFeeOrg的setter方法
	 */
	public void setCostFeeOrg(Double costFeeOrg) {
		this.costFeeOrg = costFeeOrg;
	} 	
}