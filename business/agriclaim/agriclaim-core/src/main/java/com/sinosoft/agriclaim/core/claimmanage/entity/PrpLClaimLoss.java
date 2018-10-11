package com.sinosoft.agriclaim.core.claimmanage.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:39:53.061 
 * 立案险别估损金额表实体操作对象
 */
@Entity
@Table(name = "PrpLClaimLoss")
@IdClass(PrpLClaimLossKey.class)
public class PrpLClaimLoss extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性立案号/立案号 */
	@Id
	@Column(name = "claimNo")
	private String claimNo ;/** 属性序号/序号 */
	@Id
	@Column(name = "serialNo")
	private java.lang.Integer serialNo ;	

	/** 属性险种/险种 */
	@Column(name = "riskCode")
	private String riskCode ;

	/** 属性标的子险序号/标的子险序号 */
	@Column(name = "itemKindNo")
	private java.lang.Integer itemKindNo ;
	/** 属性险别代码/险别代码 */
	@Column(name = "kindCode")
	private String kindCode ;
	/** 属性保单标的项目代码/保单标的项目代码 */
	@Column(name = "itemCode")
	private String itemCode ;
	/** 属性币别/币别 */
	@Column(name = "currency")
	private String currency ;
	/** 属性估损金额/估损金额 */
	@Column(name = "sumClaim")
	private java.lang.Double sumClaim ;
	/** 属性输入日期/输入日期 */
	@Column(name = "inputDate")
	private java.util.Date inputDate ;
	/** 属性备注/备注 */
	@Column(name = "remarkFlag")
	private String remarkFlag ;
	/** 属性标志字段/标志字段 */
	@Column(name = "flag")
	private String flag ;
	/** 属性要能分别出赔款还是直接理赔费用/要能分别出赔款还是直接理赔费用 */
	@Column(name = "lossFeeType")
	private String lossFeeType ;
	/** 属性险别损失/险别损失 */
	@Column(name = "kindLoss")
	private java.lang.Double kindLoss ;
	/** 属性残值/残值 */
	@Column(name = "kindRest")
	private java.lang.Double kindRest ;
	/** 属性绝对免赔率/绝对免赔率 */
	@Column(name = "deductibleRate")
	private java.lang.Double deductibleRate ;
	/** 属性绝对免赔额/绝对免赔额 */
	@Column(name = "deductible")
	private java.lang.Double deductible ;
	/** 属性事故责任免赔率/事故责任免赔率 */
	@Column(name = "acciDeductibleRate")
	private java.lang.Double acciDeductibleRate ;
	/** 属性费用类型/费用类型 */
	@Column(name = "feeCategory")
	private String feeCategory ;
	/** 属性标的项目明细名称/标的项目明细名称 */
	@Column(name = "itemDetailName")
	private String itemDetailName ;
	/** 属性理赔总报告/理赔总报告 */
	@Column(name = "reportSumClaim")
	private java.lang.Double reportSumClaim ;
	/** 属性分户序号/分户序号 */
	@Column(name = "familyNo")
	private java.lang.Integer familyNo ;
	/** 属性分户名称/分户名称 */
	@Column(name = "familyName")
	private String familyName ;
	/** 属性车牌号码/车牌号码 */
	@Column(name = "licenseNo")
	private String licenseNo ;
	/** 属性伤者姓名/伤者姓名 */
	@Column(name = "personName")
	private String personName ;
	/** 属性本车交强险赔偿/本车交强险赔偿 */
	@Column(name = "localComplePay")
	private java.lang.Double localComplePay ;
	/** 属性定损/核损金额/定损/核损金额 */
	@Column(name = "defLoss")
	private java.lang.Double defLoss ;
	/** 属性预估金额/预估金额 */
	@Column(name = "predictionLoss")
	private java.lang.Double predictionLoss ;
	/** 属性互碰自赔金额/互碰自赔金额 */
	@Column(name = "paySelfFee")
	private java.lang.Double paySelfFee ;
	/** 属性无责代赔金额/无责代赔金额 */
	@Column(name = "payfee")
	private java.lang.Double payfee ;
	/** 属性标的序号/标的序号 */
	@Column(name = "lossitemCode")
	private String lossitemCode ;
	/** 属性组合保险分户编号/组合保险分户编号 */
	@Column(name = "familyNozh")
	private String familyNozh ;
	/** 属性次数/次数 */
	@Column(name = "times")
	private java.lang.Integer times ;
	/** 属性修改人/修改人 */
	@Column(name = "update_By")
	private String updateBy ;
	/** 属性修改时间/修改时间 */
	@Column(name = "update_Date")
	private java.util.Date updateDate ;
	/** 属性赔案号码/赔案号码 */
	@Column(name = "claimNumber")
	private String claimNumber ;
	/**
	 * 属性立案号/立案号的getter方法
	 */
	public String getClaimNo() {
		return claimNo;
	}
	/**
	 * 属性立案号/立案号的setter方法
	 */
	public void setClaimNo(String claimNo) {
		this.claimNo = claimNo;
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
	 * 属性标的子险序号/标的子险序号的getter方法
	 */
	public java.lang.Integer getItemKindNo() {
		return itemKindNo;
	}
	/**
	 * 属性标的子险序号/标的子险序号的setter方法
	 */
	public void setItemKindNo(java.lang.Integer itemKindNo) {
		this.itemKindNo = itemKindNo;
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
	 * 属性保单标的项目代码/保单标的项目代码的getter方法
	 */
	public String getItemCode() {
		return itemCode;
	}
	/**
	 * 属性保单标的项目代码/保单标的项目代码的setter方法
	 */
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
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
	 * 属性估损金额/估损金额的getter方法
	 */
	public java.lang.Double getSumClaim() {
		return sumClaim;
	}
	/**
	 * 属性估损金额/估损金额的setter方法
	 */
	public void setSumClaim(java.lang.Double sumClaim) {
		this.sumClaim = sumClaim;
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
	 * 属性备注/备注的getter方法
	 */
	public String getRemarkFlag() {
		return remarkFlag;
	}
	/**
	 * 属性备注/备注的setter方法
	 */
	public void setRemarkFlag(String remarkFlag) {
		this.remarkFlag = remarkFlag;
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
	 * 属性要能分别出赔款还是直接理赔费用/要能分别出赔款还是直接理赔费用的getter方法
	 */
	public String getLossFeeType() {
		return lossFeeType;
	}
	/**
	 * 属性要能分别出赔款还是直接理赔费用/要能分别出赔款还是直接理赔费用的setter方法
	 */
	public void setLossFeeType(String lossFeeType) {
		this.lossFeeType = lossFeeType;
	} 	
	/**
	 * 属性险别损失/险别损失的getter方法
	 */
	public java.lang.Double getKindLoss() {
		return kindLoss;
	}
	/**
	 * 属性险别损失/险别损失的setter方法
	 */
	public void setKindLoss(java.lang.Double kindLoss) {
		this.kindLoss = kindLoss;
	} 	
	/**
	 * 属性残值/残值的getter方法
	 */
	public java.lang.Double getKindRest() {
		return kindRest;
	}
	/**
	 * 属性残值/残值的setter方法
	 */
	public void setKindRest(java.lang.Double kindRest) {
		this.kindRest = kindRest;
	} 	
	/**
	 * 属性绝对免赔率/绝对免赔率的getter方法
	 */
	public java.lang.Double getDeductibleRate() {
		return deductibleRate;
	}
	/**
	 * 属性绝对免赔率/绝对免赔率的setter方法
	 */
	public void setDeductibleRate(java.lang.Double deductibleRate) {
		this.deductibleRate = deductibleRate;
	} 	
	/**
	 * 属性绝对免赔额/绝对免赔额的getter方法
	 */
	public java.lang.Double getDeductible() {
		return deductible;
	}
	/**
	 * 属性绝对免赔额/绝对免赔额的setter方法
	 */
	public void setDeductible(java.lang.Double deductible) {
		this.deductible = deductible;
	} 	
	/**
	 * 属性事故责任免赔率/事故责任免赔率的getter方法
	 */
	public java.lang.Double getAcciDeductibleRate() {
		return acciDeductibleRate;
	}
	/**
	 * 属性事故责任免赔率/事故责任免赔率的setter方法
	 */
	public void setAcciDeductibleRate(java.lang.Double acciDeductibleRate) {
		this.acciDeductibleRate = acciDeductibleRate;
	} 	
	/**
	 * 属性费用类型/费用类型的getter方法
	 */
	public String getFeeCategory() {
		return feeCategory;
	}
	/**
	 * 属性费用类型/费用类型的setter方法
	 */
	public void setFeeCategory(String feeCategory) {
		this.feeCategory = feeCategory;
	} 	
	/**
	 * 属性标的项目明细名称/标的项目明细名称的getter方法
	 */
	public String getItemDetailName() {
		return itemDetailName;
	}
	/**
	 * 属性标的项目明细名称/标的项目明细名称的setter方法
	 */
	public void setItemDetailName(String itemDetailName) {
		this.itemDetailName = itemDetailName;
	} 	
	/**
	 * 属性理赔总报告/理赔总报告的getter方法
	 */
	public java.lang.Double getReportSumClaim() {
		return reportSumClaim;
	}
	/**
	 * 属性理赔总报告/理赔总报告的setter方法
	 */
	public void setReportSumClaim(java.lang.Double reportSumClaim) {
		this.reportSumClaim = reportSumClaim;
	} 	
	/**
	 * 属性分户序号/分户序号的getter方法
	 */
	public java.lang.Integer getFamilyNo() {
		return familyNo;
	}
	/**
	 * 属性分户序号/分户序号的setter方法
	 */
	public void setFamilyNo(java.lang.Integer familyNo) {
		this.familyNo = familyNo;
	} 	
	/**
	 * 属性分户名称/分户名称的getter方法
	 */
	public String getFamilyName() {
		return familyName;
	}
	/**
	 * 属性分户名称/分户名称的setter方法
	 */
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	} 	
	/**
	 * 属性车牌号码/车牌号码的getter方法
	 */
	public String getLicenseNo() {
		return licenseNo;
	}
	/**
	 * 属性车牌号码/车牌号码的setter方法
	 */
	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	} 	
	/**
	 * 属性伤者姓名/伤者姓名的getter方法
	 */
	public String getPersonName() {
		return personName;
	}
	/**
	 * 属性伤者姓名/伤者姓名的setter方法
	 */
	public void setPersonName(String personName) {
		this.personName = personName;
	} 	
	/**
	 * 属性本车交强险赔偿/本车交强险赔偿的getter方法
	 */
	public java.lang.Double getLocalComplePay() {
		return localComplePay;
	}
	/**
	 * 属性本车交强险赔偿/本车交强险赔偿的setter方法
	 */
	public void setLocalComplePay(java.lang.Double localComplePay) {
		this.localComplePay = localComplePay;
	} 	
	/**
	 * 属性定损/核损金额/定损/核损金额的getter方法
	 */
	public java.lang.Double getDefLoss() {
		return defLoss;
	}
	/**
	 * 属性定损/核损金额/定损/核损金额的setter方法
	 */
	public void setDefLoss(java.lang.Double defLoss) {
		this.defLoss = defLoss;
	} 	
	/**
	 * 属性预估金额/预估金额的getter方法
	 */
	public java.lang.Double getPredictionLoss() {
		return predictionLoss;
	}
	/**
	 * 属性预估金额/预估金额的setter方法
	 */
	public void setPredictionLoss(java.lang.Double predictionLoss) {
		this.predictionLoss = predictionLoss;
	} 	
	/**
	 * 属性互碰自赔金额/互碰自赔金额的getter方法
	 */
	public java.lang.Double getPaySelfFee() {
		return paySelfFee;
	}
	/**
	 * 属性互碰自赔金额/互碰自赔金额的setter方法
	 */
	public void setPaySelfFee(java.lang.Double paySelfFee) {
		this.paySelfFee = paySelfFee;
	} 	
	/**
	 * 属性无责代赔金额/无责代赔金额的getter方法
	 */
	public java.lang.Double getPayfee() {
		return payfee;
	}
	/**
	 * 属性无责代赔金额/无责代赔金额的setter方法
	 */
	public void setPayfee(java.lang.Double payfee) {
		this.payfee = payfee;
	} 	
	/**
	 * 属性标的序号/标的序号的getter方法
	 */
	public String getLossitemCode() {
		return lossitemCode;
	}
	/**
	 * 属性标的序号/标的序号的setter方法
	 */
	public void setLossitemCode(String lossitemCode) {
		this.lossitemCode = lossitemCode;
	} 	
	/**
	 * 属性组合保险分户编号/组合保险分户编号的getter方法
	 */
	public String getFamilyNozh() {
		return familyNozh;
	}
	/**
	 * 属性组合保险分户编号/组合保险分户编号的setter方法
	 */
	public void setFamilyNozh(String familyNozh) {
		this.familyNozh = familyNozh;
	} 	
	/**
	 * 属性次数/次数的getter方法
	 */
	public java.lang.Integer getTimes() {
		return times;
	}
	/**
	 * 属性次数/次数的setter方法
	 */
	public void setTimes(java.lang.Integer times) {
		this.times = times;
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
	/**
	 * 属性赔案号码/赔案号码的getter方法
	 */
	public String getClaimNumber() {
		return claimNumber;
	}
	/**
	 * 属性赔案号码/赔案号码的setter方法
	 */
	public void setClaimNumber(String claimNumber) {
		this.claimNumber = claimNumber;
	} 	
}