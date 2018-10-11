package com.sinosoft.agriprpall.api.undwrtsubmit.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-18 03:18:29.180 
 * prpTdangerUnitApi操作对象
 */
public class PrpTdangerUnitDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性proposalNo/proposalNo */
	private String proposalNo ;		
	/** 属性riskCode/riskCode */
	private String riskCode ;		
	/** 属性dangerNo/dangerNo */
	private Integer dangerNo ;
	/** 属性dangerDesc/dangerDesc */
	private String dangerDesc ;		
	/** 属性addressName/addressName */
	private String addressName ;		
	/** 属性riskLevel/riskLevel */
	private String riskLevel ;		
	/** 属性riskLevelDesc/riskLevelDesc */
	private String riskLevelDesc ;		
	/** 属性itemKind/itemKind */
	private String itemKind ;		
	/** 属性itemKindDesc/itemKindDesc */
	private String itemKindDesc ;		
	/** 属性currency/currency */
	private String currency ;		
	/** 属性amount/amount */
	private Double amount ;
	/** 属性premium/premium */
	private Double premium ;
	/** 属性disfee/disfee */
	private Double disfee ;
	/** 属性dangerShare/dangerShare */
	private Double dangerShare ;
	/** 属性retcurrency/retcurrency */
	private String retcurrency ;		
	/** 属性retentionValue/retentionValue */
	private Double retentionValue ;
	/** 属性remarks/remarks */
	private String remarks ;		
	/** 属性flag/flag */
	private String flag ;		
	/** 属性endorseTimes/endorseTimes */
	private Integer endorseTimes ;
	/** 属性specurrency/specurrency */
	private String specurrency ;		
	/** 属性sperate/sperate */
	private Double sperate ;
	/** 属性spevalue/spevalue */
	private Double spevalue ;
	/** 属性groupFlag/groupFlag */
	private String groupFlag ;		
	/** 属性riskClassDesc/riskClassDesc */
	private String riskClassDesc ;		
	/** 属性business/business */
	private String business ;		
	/** 属性businessDesc/businessDesc */
	private String businessDesc ;		
	/** 属性riskClass/riskClass */
	private String riskClass ;		
	/** 属性coinsFlag/coinsFlag */
	private String coinsFlag ;		
	/** 属性shareholderFlag/shareholderFlag */
	private String shareholderFlag ;		
	/** 属性businessFlag/businessFlag */
	private String businessFlag ;		
	/** 属性危险单位人数/危险单位人数 */
	private Double quantity ;
	/** 属性每人保额/限额/每人保额/限额 */
	private Double unitAmount ;
	/** 属性危险单位限额/危险单位限额 */
	private Double limitAmount ;
	/** 属性危险单位方案/危险单位方案 */
	private String rationType ;		
	/** 属性组合险种危险单位/组合险种危险单位 */
	private String zhFlag ;
	/** 属性再保虚拟险种代码/再保虚拟险种代码 */
	private String dumriskCode ;		
	/** 属性危险单位/危险单位 */
	private String unitdangerFlag ;		
	/** 属性溢额特别申报标志/溢额特别申报标志 */
	private String acceptanceFlag ;		
	/** 属性retentionrate/retentionrate */
	private Double retentionrate ;
	/** 属性retentionrateFlag/retentionrateFlag */
	private String retentionrateFlag ;		
	/** 属性业务来源/业务来源 */
	private String businessNature ;		
	/** 属性保单业务类型/保单业务类型 */
	private String policybizType ;		
	/** 属性投保方式/投保方式 */
	private String policyType ;		
	/** 属性政策性/政策性 */
	private String businessType1 ;		
	/** 属性涉农/非农标志/涉农/非农标志 */
	private String businessType ;		
	/** 属性 其它标志字段/ 其它标志字段 */
	private String othFlag ;		
	/** 属性归属区域1/归属区域1 */
	private String businessprovince ;		
	/** 属性归属区域2/归属区域2 */
	private String businesstown ;		
	/** 属性归属区域3/归属区域3 */
	private String businessCounty ;		
	/** 属性归属区域4/归属区域4 */
	private String businessAreaName ;		
	/** 属性备用字段1/备用字段1 */
	private String othvalue1 ;		
	/** 属性备用字段2/备用字段2 */
	private String othvalue2 ;		
	/** 属性备用字段3/备用字段3 */
	private String othvalue3 ;		
	/** 属性总不含税保费/总不含税保费 */
	private Double sumNoTaxPremium ;
	/** 属性总税额/总税额 */
	private Double sumtaxFee ;
	/**
	 * 属性proposalNo/proposalNo的getter方法
	 */
	public String getProposalNo() {
		return proposalNo;
	}
	/**
	 * 属性proposalNo/proposalNo的setter方法
	 */
	public void setProposalNo(String proposalNo) {
		this.proposalNo = proposalNo;
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
	 * 属性dangerNo/dangerNo的getter方法
	 */
	public Integer getDangerNo() {
		return dangerNo;
	}
	/**
	 * 属性dangerNo/dangerNo的setter方法
	 */
	public void setDangerNo(Integer dangerNo) {
		this.dangerNo = dangerNo;
	}	
	/**
	 * 属性dangerDesc/dangerDesc的getter方法
	 */
	public String getDangerDesc() {
		return dangerDesc;
	}
	/**
	 * 属性dangerDesc/dangerDesc的setter方法
	 */
	public void setDangerDesc(String dangerDesc) {
		this.dangerDesc = dangerDesc;
	}	
	/**
	 * 属性addressName/addressName的getter方法
	 */
	public String getAddressName() {
		return addressName;
	}
	/**
	 * 属性addressName/addressName的setter方法
	 */
	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}	
	/**
	 * 属性riskLevel/riskLevel的getter方法
	 */
	public String getRiskLevel() {
		return riskLevel;
	}
	/**
	 * 属性riskLevel/riskLevel的setter方法
	 */
	public void setRiskLevel(String riskLevel) {
		this.riskLevel = riskLevel;
	}	
	/**
	 * 属性riskLevelDesc/riskLevelDesc的getter方法
	 */
	public String getRiskLevelDesc() {
		return riskLevelDesc;
	}
	/**
	 * 属性riskLevelDesc/riskLevelDesc的setter方法
	 */
	public void setRiskLevelDesc(String riskLevelDesc) {
		this.riskLevelDesc = riskLevelDesc;
	}	
	/**
	 * 属性itemKind/itemKind的getter方法
	 */
	public String getItemKind() {
		return itemKind;
	}
	/**
	 * 属性itemKind/itemKind的setter方法
	 */
	public void setItemKind(String itemKind) {
		this.itemKind = itemKind;
	}	
	/**
	 * 属性itemKindDesc/itemKindDesc的getter方法
	 */
	public String getItemKindDesc() {
		return itemKindDesc;
	}
	/**
	 * 属性itemKindDesc/itemKindDesc的setter方法
	 */
	public void setItemKindDesc(String itemKindDesc) {
		this.itemKindDesc = itemKindDesc;
	}	
	/**
	 * 属性currency/currency的getter方法
	 */
	public String getCurrency() {
		return currency;
	}
	/**
	 * 属性currency/currency的setter方法
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}	
	/**
	 * 属性amount/amount的getter方法
	 */
	public Double getAmount() {
		return amount;
	}
	/**
	 * 属性amount/amount的setter方法
	 */
	public void setAmount(Double amount) {
		this.amount = amount;
	}	
	/**
	 * 属性premium/premium的getter方法
	 */
	public Double getPremium() {
		return premium;
	}
	/**
	 * 属性premium/premium的setter方法
	 */
	public void setPremium(Double premium) {
		this.premium = premium;
	}	
	/**
	 * 属性disfee/disfee的getter方法
	 */
	public Double getDisfee() {
		return disfee;
	}
	/**
	 * 属性disfee/disfee的setter方法
	 */
	public void setDisfee(Double disfee) {
		this.disfee = disfee;
	}	
	/**
	 * 属性dangerShare/dangerShare的getter方法
	 */
	public Double getDangerShare() {
		return dangerShare;
	}
	/**
	 * 属性dangerShare/dangerShare的setter方法
	 */
	public void setDangerShare(Double dangerShare) {
		this.dangerShare = dangerShare;
	}	
	/**
	 * 属性retcurrency/retcurrency的getter方法
	 */
	public String getRetcurrency() {
		return retcurrency;
	}
	/**
	 * 属性retcurrency/retcurrency的setter方法
	 */
	public void setRetcurrency(String retcurrency) {
		this.retcurrency = retcurrency;
	}	
	/**
	 * 属性retentionValue/retentionValue的getter方法
	 */
	public Double getRetentionValue() {
		return retentionValue;
	}
	/**
	 * 属性retentionValue/retentionValue的setter方法
	 */
	public void setRetentionValue(Double retentionValue) {
		this.retentionValue = retentionValue;
	}	
	/**
	 * 属性remarks/remarks的getter方法
	 */
	public String getRemarks() {
		return remarks;
	}
	/**
	 * 属性remarks/remarks的setter方法
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
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
	/**
	 * 属性endorseTimes/endorseTimes的getter方法
	 */
	public Integer getEndorseTimes() {
		return endorseTimes;
	}
	/**
	 * 属性endorseTimes/endorseTimes的setter方法
	 */
	public void setEndorseTimes(Integer endorseTimes) {
		this.endorseTimes = endorseTimes;
	}	
	/**
	 * 属性specurrency/specurrency的getter方法
	 */
	public String getSpecurrency() {
		return specurrency;
	}
	/**
	 * 属性specurrency/specurrency的setter方法
	 */
	public void setSpecurrency(String specurrency) {
		this.specurrency = specurrency;
	}	
	/**
	 * 属性sperate/sperate的getter方法
	 */
	public Double getSperate() {
		return sperate;
	}
	/**
	 * 属性sperate/sperate的setter方法
	 */
	public void setSperate(Double sperate) {
		this.sperate = sperate;
	}	
	/**
	 * 属性spevalue/spevalue的getter方法
	 */
	public Double getSpevalue() {
		return spevalue;
	}
	/**
	 * 属性spevalue/spevalue的setter方法
	 */
	public void setSpevalue(Double spevalue) {
		this.spevalue = spevalue;
	}	
	/**
	 * 属性groupFlag/groupFlag的getter方法
	 */
	public String getGroupFlag() {
		return groupFlag;
	}
	/**
	 * 属性groupFlag/groupFlag的setter方法
	 */
	public void setGroupFlag(String groupFlag) {
		this.groupFlag = groupFlag;
	}	
	/**
	 * 属性riskClassDesc/riskClassDesc的getter方法
	 */
	public String getRiskClassDesc() {
		return riskClassDesc;
	}
	/**
	 * 属性riskClassDesc/riskClassDesc的setter方法
	 */
	public void setRiskClassDesc(String riskClassDesc) {
		this.riskClassDesc = riskClassDesc;
	}	
	/**
	 * 属性business/business的getter方法
	 */
	public String getBusiness() {
		return business;
	}
	/**
	 * 属性business/business的setter方法
	 */
	public void setBusiness(String business) {
		this.business = business;
	}	
	/**
	 * 属性businessDesc/businessDesc的getter方法
	 */
	public String getBusinessDesc() {
		return businessDesc;
	}
	/**
	 * 属性businessDesc/businessDesc的setter方法
	 */
	public void setBusinessDesc(String businessDesc) {
		this.businessDesc = businessDesc;
	}	
	/**
	 * 属性riskClass/riskClass的getter方法
	 */
	public String getRiskClass() {
		return riskClass;
	}
	/**
	 * 属性riskClass/riskClass的setter方法
	 */
	public void setRiskClass(String riskClass) {
		this.riskClass = riskClass;
	}	
	/**
	 * 属性coinsFlag/coinsFlag的getter方法
	 */
	public String getCoinsFlag() {
		return coinsFlag;
	}
	/**
	 * 属性coinsFlag/coinsFlag的setter方法
	 */
	public void setCoinsFlag(String coinsFlag) {
		this.coinsFlag = coinsFlag;
	}	
	/**
	 * 属性shareholderFlag/shareholderFlag的getter方法
	 */
	public String getShareholderFlag() {
		return shareholderFlag;
	}
	/**
	 * 属性shareholderFlag/shareholderFlag的setter方法
	 */
	public void setShareholderFlag(String shareholderFlag) {
		this.shareholderFlag = shareholderFlag;
	}	
	/**
	 * 属性businessFlag/businessFlag的getter方法
	 */
	public String getBusinessFlag() {
		return businessFlag;
	}
	/**
	 * 属性businessFlag/businessFlag的setter方法
	 */
	public void setBusinessFlag(String businessFlag) {
		this.businessFlag = businessFlag;
	}	
	/**
	 * 属性危险单位人数/危险单位人数的getter方法
	 */
	public Double getQuantity() {
		return quantity;
	}
	/**
	 * 属性危险单位人数/危险单位人数的setter方法
	 */
	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}	
	/**
	 * 属性每人保额/限额/每人保额/限额的getter方法
	 */
	public Double getUnitAmount() {
		return unitAmount;
	}
	/**
	 * 属性每人保额/限额/每人保额/限额的setter方法
	 */
	public void setUnitAmount(Double unitAmount) {
		this.unitAmount = unitAmount;
	}	
	/**
	 * 属性危险单位限额/危险单位限额的getter方法
	 */
	public Double getLimitAmount() {
		return limitAmount;
	}
	/**
	 * 属性危险单位限额/危险单位限额的setter方法
	 */
	public void setLimitAmount(Double limitAmount) {
		this.limitAmount = limitAmount;
	}	
	/**
	 * 属性危险单位方案/危险单位方案的getter方法
	 */
	public String getRationType() {
		return rationType;
	}
	/**
	 * 属性危险单位方案/危险单位方案的setter方法
	 */
	public void setRationType(String rationType) {
		this.rationType = rationType;
	}	
	/**
	 * 属性组合险种危险单位/组合险种危险单位的getter方法
	 */
	public String getZhFlag() {
		return zhFlag;
	}
	/**
	 * 属性组合险种危险单位/组合险种危险单位的setter方法
	 */
	public void setZhFlag(String zhFlag) {
		this.zhFlag = zhFlag;
	}	
	/**
	 * 属性再保虚拟险种代码/再保虚拟险种代码的getter方法
	 */
	public String getDumriskCode() {
		return dumriskCode;
	}
	/**
	 * 属性再保虚拟险种代码/再保虚拟险种代码的setter方法
	 */
	public void setDumriskCode(String dumriskCode) {
		this.dumriskCode = dumriskCode;
	}	
	/**
	 * 属性危险单位/危险单位的getter方法
	 */
	public String getUnitdangerFlag() {
		return unitdangerFlag;
	}
	/**
	 * 属性危险单位/危险单位的setter方法
	 */
	public void setUnitdangerFlag(String unitdangerFlag) {
		this.unitdangerFlag = unitdangerFlag;
	}	
	/**
	 * 属性溢额特别申报标志/溢额特别申报标志的getter方法
	 */
	public String getAcceptanceFlag() {
		return acceptanceFlag;
	}
	/**
	 * 属性溢额特别申报标志/溢额特别申报标志的setter方法
	 */
	public void setAcceptanceFlag(String acceptanceFlag) {
		this.acceptanceFlag = acceptanceFlag;
	}	
	/**
	 * 属性retentionrate/retentionrate的getter方法
	 */
	public Double getRetentionrate() {
		return retentionrate;
	}
	/**
	 * 属性retentionrate/retentionrate的setter方法
	 */
	public void setRetentionrate(Double retentionrate) {
		this.retentionrate = retentionrate;
	}	
	/**
	 * 属性retentionrateFlag/retentionrateFlag的getter方法
	 */
	public String getRetentionrateFlag() {
		return retentionrateFlag;
	}
	/**
	 * 属性retentionrateFlag/retentionrateFlag的setter方法
	 */
	public void setRetentionrateFlag(String retentionrateFlag) {
		this.retentionrateFlag = retentionrateFlag;
	}	
	/**
	 * 属性业务来源/业务来源的getter方法
	 */
	public String getBusinessNature() {
		return businessNature;
	}
	/**
	 * 属性业务来源/业务来源的setter方法
	 */
	public void setBusinessNature(String businessNature) {
		this.businessNature = businessNature;
	}	
	/**
	 * 属性保单业务类型/保单业务类型的getter方法
	 */
	public String getPolicybizType() {
		return policybizType;
	}
	/**
	 * 属性保单业务类型/保单业务类型的setter方法
	 */
	public void setPolicybizType(String policybizType) {
		this.policybizType = policybizType;
	}	
	/**
	 * 属性投保方式/投保方式的getter方法
	 */
	public String getPolicyType() {
		return policyType;
	}
	/**
	 * 属性投保方式/投保方式的setter方法
	 */
	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}	
	/**
	 * 属性政策性/政策性的getter方法
	 */
	public String getBusinessType1() {
		return businessType1;
	}
	/**
	 * 属性政策性/政策性的setter方法
	 */
	public void setBusinessType1(String businessType1) {
		this.businessType1 = businessType1;
	}	
	/**
	 * 属性涉农/非农标志/涉农/非农标志的getter方法
	 */
	public String getBusinessType() {
		return businessType;
	}
	/**
	 * 属性涉农/非农标志/涉农/非农标志的setter方法
	 */
	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}	
	/**
	 * 属性 其它标志字段/ 其它标志字段的getter方法
	 */
	public String getOthFlag() {
		return othFlag;
	}
	/**
	 * 属性 其它标志字段/ 其它标志字段的setter方法
	 */
	public void setOthFlag(String othFlag) {
		this.othFlag = othFlag;
	}	
	/**
	 * 属性归属区域1/归属区域1的getter方法
	 */
	public String getBusinessprovince() {
		return businessprovince;
	}
	/**
	 * 属性归属区域1/归属区域1的setter方法
	 */
	public void setBusinessprovince(String businessprovince) {
		this.businessprovince = businessprovince;
	}	
	/**
	 * 属性归属区域2/归属区域2的getter方法
	 */
	public String getBusinesstown() {
		return businesstown;
	}
	/**
	 * 属性归属区域2/归属区域2的setter方法
	 */
	public void setBusinesstown(String businesstown) {
		this.businesstown = businesstown;
	}	
	/**
	 * 属性归属区域3/归属区域3的getter方法
	 */
	public String getBusinessCounty() {
		return businessCounty;
	}
	/**
	 * 属性归属区域3/归属区域3的setter方法
	 */
	public void setBusinessCounty(String businessCounty) {
		this.businessCounty = businessCounty;
	}	
	/**
	 * 属性归属区域4/归属区域4的getter方法
	 */
	public String getBusinessAreaName() {
		return businessAreaName;
	}
	/**
	 * 属性归属区域4/归属区域4的setter方法
	 */
	public void setBusinessAreaName(String businessAreaName) {
		this.businessAreaName = businessAreaName;
	}	
	/**
	 * 属性备用字段1/备用字段1的getter方法
	 */
	public String getOthvalue1() {
		return othvalue1;
	}
	/**
	 * 属性备用字段1/备用字段1的setter方法
	 */
	public void setOthvalue1(String othvalue1) {
		this.othvalue1 = othvalue1;
	}	
	/**
	 * 属性备用字段2/备用字段2的getter方法
	 */
	public String getOthvalue2() {
		return othvalue2;
	}
	/**
	 * 属性备用字段2/备用字段2的setter方法
	 */
	public void setOthvalue2(String othvalue2) {
		this.othvalue2 = othvalue2;
	}	
	/**
	 * 属性备用字段3/备用字段3的getter方法
	 */
	public String getOthvalue3() {
		return othvalue3;
	}
	/**
	 * 属性备用字段3/备用字段3的setter方法
	 */
	public void setOthvalue3(String othvalue3) {
		this.othvalue3 = othvalue3;
	}	
	/**
	 * 属性总不含税保费/总不含税保费的getter方法
	 */
	public Double getSumNoTaxPremium() {
		return sumNoTaxPremium;
	}
	/**
	 * 属性总不含税保费/总不含税保费的setter方法
	 */
	public void setSumNoTaxPremium(Double sumNoTaxPremium) {
		this.sumNoTaxPremium = sumNoTaxPremium;
	}	
	/**
	 * 属性总税额/总税额的getter方法
	 */
	public Double getSumtaxFee() {
		return sumtaxFee;
	}
	/**
	 * 属性总税额/总税额的setter方法
	 */
	public void setSumtaxFee(Double sumtaxFee) {
		this.sumtaxFee = sumtaxFee;
	}	
}
