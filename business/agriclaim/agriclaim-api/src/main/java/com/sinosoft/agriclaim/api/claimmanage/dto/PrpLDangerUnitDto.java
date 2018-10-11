package com.sinosoft.agriclaim.api.claimmanage.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2018-04-11 07:01:52.256 
 * 危险单位表Api操作对象
 */
public class PrpLDangerUnitDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性业务号/业务号 */
	private String certiNo ;		
	/** 属性certiType/certiType */
	private String certiType ;		
	/** 属性立案号/立案号 */
	private String claimNo ;		
	/** 属性保单号/保单号 */
	private String policyNo ;		
	/** 属性repolicyNo/repolicyNo */
	private String repolicyNo ;		
	/** 属性险种代码/险种代码 */
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
	/** 属性币别代码/币别代码 */
	private String currency ;		
	/** 属性sumLoss/sumLoss */
	private Double sumLoss ;
	/** 属性sumPaid/sumPaid */
	private Double sumPaid ;
	/** 属性sumFee/sumFee */
	private Double sumFee ;
	/** 属性sumNoPaid/sumNoPaid */
	private Double sumNoPaid ;
	/** 属性dangerShare/dangerShare */
	private Double dangerShare ;
	/** 属性retCurrency/retCurrency */
	private String retCurrency ;		
	/** 属性retentionValue/retentionValue */
	private Double retentionValue ;
	/** 属性备注/备注 */
	private String remarks ;		
	/** 属性标志位/标志位 */
	private String flag ;		
	/** 属性speCurrency/speCurrency */
	private String speCurrency ;		
	/** 属性speRate/speRate */
	private Double speRate ;
	/** 属性speValue/speValue */
	private Double speValue ;
	/** 属性groupFlag/groupFlag */
	private String groupFlag ;		
	/** 属性reinsureFlag/reinsureFlag */
	private String reinsureFlag ;		
	/** 属性共保标志/共保标志 */
	private String coinsFlag ;		
	/** 属性shareHolderFlag/shareHolderFlag */
	private String shareHolderFlag ;		
	/** 属性businessFlag/businessFlag */
	private String businessFlag ;		
	/** 属性出险日期/出险日期 */
	private java.util.Date damageDate ;		
	/** 属性立案日期/立案日期 */
	private java.util.Date claimDate ;		
	/** 属性结案标志/结案标志 */
	private String endcaseFlag ;		
	/** 属性出险原因代码/出险原因代码 */
	private String damageCode ;		
	/** 属性damageReason/damageReason */
	private String damageReason ;		
	/** 属性itemName/itemName */
	private String itemName ;		
	/** 属性makeComCode/makeComCode */
	private String makeComCode ;		
	/** 属性createrCode/createrCode */
	private String createrCode ;		
	/** 属性createDate/createDate */
	private java.util.Date createDate ;		
	/** 属性估损增加次数/估损增加次数 */
	private Integer claimAddTimes ;
	/** 属性溢额特别申报标志/溢额特别申报标志 */
	private String acceptanceFlag ;		
	/** 属性businessNature/businessNature */
	private String businessNature ;		
	/** 属性保单业务类型/保单业务类型 */
	private String policyBizType ;		
	/** 属性投保方式/投保方式 */
	private String policyType ;		
	/** 属性中央政策性/地方政策性/商业性标志/中央政策性/地方政策性/商业性标志 */
	private String businessType1 ;		
	/** 属性农业/涉农/非农标志/农业/涉农/非农标志 */
	private String businessType ;		
	/** 属性其它标志字段/其它标志字段 */
	private String othFlag ;		
	/** 属性归属区域：省/归属区域：省 */
	private String businessProvince ;		
	/** 属性归属区域：地市/归属区域：地市 */
	private String businessTown ;		
	/** 属性归属区域：区县/归属区域：区县 */
	private String businessCounty ;		
	/** 属性归属区域：乡镇/归属区域：乡镇 */
	private String businessAreaName ;		
	/** 属性备用字段1/备用字段1 */
	private String othValue1 ;		
	/** 属性备用字段2/备用字段2 */
	private String othValue2 ;		
	/** 属性备用字段3/备用字段3 */
	private String othValue3 ;		
	/** 属性cashLossFlag/cashLossFlag */
	private String cashLossFlag ;		
	/** 属性largeLossFlag/largeLossFlag */
	private String largeLossFlag ;		
	/**
	 * 属性业务号/业务号的getter方法
	 */
	public String getCertiNo() {
		return certiNo;
	}
	/**
	 * 属性业务号/业务号的setter方法
	 */
	public void setCertiNo(String certiNo) {
		this.certiNo = certiNo;
	}	
	/**
	 * 属性certiType/certiType的getter方法
	 */
	public String getCertiType() {
		return certiType;
	}
	/**
	 * 属性certiType/certiType的setter方法
	 */
	public void setCertiType(String certiType) {
		this.certiType = certiType;
	}	
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
	 * 属性repolicyNo/repolicyNo的getter方法
	 */
	public String getRepolicyNo() {
		return repolicyNo;
	}
	/**
	 * 属性repolicyNo/repolicyNo的setter方法
	 */
	public void setRepolicyNo(String repolicyNo) {
		this.repolicyNo = repolicyNo;
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
	 * 属性sumLoss/sumLoss的getter方法
	 */
	public Double getSumLoss() {
		return sumLoss;
	}
	/**
	 * 属性sumLoss/sumLoss的setter方法
	 */
	public void setSumLoss(Double sumLoss) {
		this.sumLoss = sumLoss;
	}	
	/**
	 * 属性sumPaid/sumPaid的getter方法
	 */
	public Double getSumPaid() {
		return sumPaid;
	}
	/**
	 * 属性sumPaid/sumPaid的setter方法
	 */
	public void setSumPaid(Double sumPaid) {
		this.sumPaid = sumPaid;
	}	
	/**
	 * 属性sumFee/sumFee的getter方法
	 */
	public Double getSumFee() {
		return sumFee;
	}
	/**
	 * 属性sumFee/sumFee的setter方法
	 */
	public void setSumFee(Double sumFee) {
		this.sumFee = sumFee;
	}	
	/**
	 * 属性sumNoPaid/sumNoPaid的getter方法
	 */
	public Double getSumNoPaid() {
		return sumNoPaid;
	}
	/**
	 * 属性sumNoPaid/sumNoPaid的setter方法
	 */
	public void setSumNoPaid(Double sumNoPaid) {
		this.sumNoPaid = sumNoPaid;
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
	 * 属性retCurrency/retCurrency的getter方法
	 */
	public String getRetCurrency() {
		return retCurrency;
	}
	/**
	 * 属性retCurrency/retCurrency的setter方法
	 */
	public void setRetCurrency(String retCurrency) {
		this.retCurrency = retCurrency;
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
	 * 属性备注/备注的getter方法
	 */
	public String getRemarks() {
		return remarks;
	}
	/**
	 * 属性备注/备注的setter方法
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}	
	/**
	 * 属性标志位/标志位的getter方法
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * 属性标志位/标志位的setter方法
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}	
	/**
	 * 属性speCurrency/speCurrency的getter方法
	 */
	public String getSpeCurrency() {
		return speCurrency;
	}
	/**
	 * 属性speCurrency/speCurrency的setter方法
	 */
	public void setSpeCurrency(String speCurrency) {
		this.speCurrency = speCurrency;
	}	
	/**
	 * 属性speRate/speRate的getter方法
	 */
	public Double getSpeRate() {
		return speRate;
	}
	/**
	 * 属性speRate/speRate的setter方法
	 */
	public void setSpeRate(Double speRate) {
		this.speRate = speRate;
	}	
	/**
	 * 属性speValue/speValue的getter方法
	 */
	public Double getSpeValue() {
		return speValue;
	}
	/**
	 * 属性speValue/speValue的setter方法
	 */
	public void setSpeValue(Double speValue) {
		this.speValue = speValue;
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
	 * 属性reinsureFlag/reinsureFlag的getter方法
	 */
	public String getReinsureFlag() {
		return reinsureFlag;
	}
	/**
	 * 属性reinsureFlag/reinsureFlag的setter方法
	 */
	public void setReinsureFlag(String reinsureFlag) {
		this.reinsureFlag = reinsureFlag;
	}	
	/**
	 * 属性共保标志/共保标志的getter方法
	 */
	public String getCoinsFlag() {
		return coinsFlag;
	}
	/**
	 * 属性共保标志/共保标志的setter方法
	 */
	public void setCoinsFlag(String coinsFlag) {
		this.coinsFlag = coinsFlag;
	}	
	/**
	 * 属性shareHolderFlag/shareHolderFlag的getter方法
	 */
	public String getShareHolderFlag() {
		return shareHolderFlag;
	}
	/**
	 * 属性shareHolderFlag/shareHolderFlag的setter方法
	 */
	public void setShareHolderFlag(String shareHolderFlag) {
		this.shareHolderFlag = shareHolderFlag;
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
	 * 属性出险日期/出险日期的getter方法
	 */
	public java.util.Date getDamageDate() {
		return damageDate;
	}
	/**
	 * 属性出险日期/出险日期的setter方法
	 */
	public void setDamageDate(java.util.Date damageDate) {
		this.damageDate = damageDate;
	}	
	/**
	 * 属性立案日期/立案日期的getter方法
	 */
	public java.util.Date getClaimDate() {
		return claimDate;
	}
	/**
	 * 属性立案日期/立案日期的setter方法
	 */
	public void setClaimDate(java.util.Date claimDate) {
		this.claimDate = claimDate;
	}	
	/**
	 * 属性结案标志/结案标志的getter方法
	 */
	public String getEndcaseFlag() {
		return endcaseFlag;
	}
	/**
	 * 属性结案标志/结案标志的setter方法
	 */
	public void setEndcaseFlag(String endcaseFlag) {
		this.endcaseFlag = endcaseFlag;
	}	
	/**
	 * 属性出险原因代码/出险原因代码的getter方法
	 */
	public String getDamageCode() {
		return damageCode;
	}
	/**
	 * 属性出险原因代码/出险原因代码的setter方法
	 */
	public void setDamageCode(String damageCode) {
		this.damageCode = damageCode;
	}	
	/**
	 * 属性damageReason/damageReason的getter方法
	 */
	public String getDamageReason() {
		return damageReason;
	}
	/**
	 * 属性damageReason/damageReason的setter方法
	 */
	public void setDamageReason(String damageReason) {
		this.damageReason = damageReason;
	}	
	/**
	 * 属性itemName/itemName的getter方法
	 */
	public String getItemName() {
		return itemName;
	}
	/**
	 * 属性itemName/itemName的setter方法
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}	
	/**
	 * 属性makeComCode/makeComCode的getter方法
	 */
	public String getMakeComCode() {
		return makeComCode;
	}
	/**
	 * 属性makeComCode/makeComCode的setter方法
	 */
	public void setMakeComCode(String makeComCode) {
		this.makeComCode = makeComCode;
	}	
	/**
	 * 属性createrCode/createrCode的getter方法
	 */
	public String getCreaterCode() {
		return createrCode;
	}
	/**
	 * 属性createrCode/createrCode的setter方法
	 */
	public void setCreaterCode(String createrCode) {
		this.createrCode = createrCode;
	}	
	/**
	 * 属性createDate/createDate的getter方法
	 */
	public java.util.Date getCreateDate() {
		return createDate;
	}
	/**
	 * 属性createDate/createDate的setter方法
	 */
	public void setCreateDate(java.util.Date createDate) {
		this.createDate = createDate;
	}	
	/**
	 * 属性估损增加次数/估损增加次数的getter方法
	 */
	public Integer getClaimAddTimes() {
		return claimAddTimes;
	}
	/**
	 * 属性估损增加次数/估损增加次数的setter方法
	 */
	public void setClaimAddTimes(Integer claimAddTimes) {
		this.claimAddTimes = claimAddTimes;
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
	 * 属性businessNature/businessNature的getter方法
	 */
	public String getBusinessNature() {
		return businessNature;
	}
	/**
	 * 属性businessNature/businessNature的setter方法
	 */
	public void setBusinessNature(String businessNature) {
		this.businessNature = businessNature;
	}	
	/**
	 * 属性保单业务类型/保单业务类型的getter方法
	 */
	public String getPolicyBizType() {
		return policyBizType;
	}
	/**
	 * 属性保单业务类型/保单业务类型的setter方法
	 */
	public void setPolicyBizType(String policyBizType) {
		this.policyBizType = policyBizType;
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
	 * 属性中央政策性/地方政策性/商业性标志/中央政策性/地方政策性/商业性标志的getter方法
	 */
	public String getBusinessType1() {
		return businessType1;
	}
	/**
	 * 属性中央政策性/地方政策性/商业性标志/中央政策性/地方政策性/商业性标志的setter方法
	 */
	public void setBusinessType1(String businessType1) {
		this.businessType1 = businessType1;
	}	
	/**
	 * 属性农业/涉农/非农标志/农业/涉农/非农标志的getter方法
	 */
	public String getBusinessType() {
		return businessType;
	}
	/**
	 * 属性农业/涉农/非农标志/农业/涉农/非农标志的setter方法
	 */
	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}	
	/**
	 * 属性其它标志字段/其它标志字段的getter方法
	 */
	public String getOthFlag() {
		return othFlag;
	}
	/**
	 * 属性其它标志字段/其它标志字段的setter方法
	 */
	public void setOthFlag(String othFlag) {
		this.othFlag = othFlag;
	}	
	/**
	 * 属性归属区域：省/归属区域：省的getter方法
	 */
	public String getBusinessProvince() {
		return businessProvince;
	}
	/**
	 * 属性归属区域：省/归属区域：省的setter方法
	 */
	public void setBusinessProvince(String businessProvince) {
		this.businessProvince = businessProvince;
	}	
	/**
	 * 属性归属区域：地市/归属区域：地市的getter方法
	 */
	public String getBusinessTown() {
		return businessTown;
	}
	/**
	 * 属性归属区域：地市/归属区域：地市的setter方法
	 */
	public void setBusinessTown(String businessTown) {
		this.businessTown = businessTown;
	}	
	/**
	 * 属性归属区域：区县/归属区域：区县的getter方法
	 */
	public String getBusinessCounty() {
		return businessCounty;
	}
	/**
	 * 属性归属区域：区县/归属区域：区县的setter方法
	 */
	public void setBusinessCounty(String businessCounty) {
		this.businessCounty = businessCounty;
	}	
	/**
	 * 属性归属区域：乡镇/归属区域：乡镇的getter方法
	 */
	public String getBusinessAreaName() {
		return businessAreaName;
	}
	/**
	 * 属性归属区域：乡镇/归属区域：乡镇的setter方法
	 */
	public void setBusinessAreaName(String businessAreaName) {
		this.businessAreaName = businessAreaName;
	}	
	/**
	 * 属性备用字段1/备用字段1的getter方法
	 */
	public String getOthValue1() {
		return othValue1;
	}
	/**
	 * 属性备用字段1/备用字段1的setter方法
	 */
	public void setOthValue1(String othValue1) {
		this.othValue1 = othValue1;
	}	
	/**
	 * 属性备用字段2/备用字段2的getter方法
	 */
	public String getOthValue2() {
		return othValue2;
	}
	/**
	 * 属性备用字段2/备用字段2的setter方法
	 */
	public void setOthValue2(String othValue2) {
		this.othValue2 = othValue2;
	}	
	/**
	 * 属性备用字段3/备用字段3的getter方法
	 */
	public String getOthValue3() {
		return othValue3;
	}
	/**
	 * 属性备用字段3/备用字段3的setter方法
	 */
	public void setOthValue3(String othValue3) {
		this.othValue3 = othValue3;
	}	
	/**
	 * 属性cashLossFlag/cashLossFlag的getter方法
	 */
	public String getCashLossFlag() {
		return cashLossFlag;
	}
	/**
	 * 属性cashLossFlag/cashLossFlag的setter方法
	 */
	public void setCashLossFlag(String cashLossFlag) {
		this.cashLossFlag = cashLossFlag;
	}	
	/**
	 * 属性largeLossFlag/largeLossFlag的getter方法
	 */
	public String getLargeLossFlag() {
		return largeLossFlag;
	}
	/**
	 * 属性largeLossFlag/largeLossFlag的setter方法
	 */
	public void setLargeLossFlag(String largeLossFlag) {
		this.largeLossFlag = largeLossFlag;
	}	
}
