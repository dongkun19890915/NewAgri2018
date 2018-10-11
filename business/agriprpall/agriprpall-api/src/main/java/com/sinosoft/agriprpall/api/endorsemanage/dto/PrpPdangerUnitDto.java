package com.sinosoft.agriprpall.api.endorsemanage.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-04 10:07:09.217 
 * 批单的危险单位划分表Api操作对象
 */
public class PrpPdangerUnitDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性批单号码/批单号码 */
	private String endorseNo ;		
	/** 属性保单号码/保单号码 */
	private String policyNo ;		
	/** 属性险种代码/险种代码 */
	private String riskCode ;		
	/** 属性危险单位序号/危险单位序号 */
	private Integer dangerNo ;
	/** 属性危险单位信息描述/危险单位信息描述 */
	private String dangerDesc ;		
	/** 属性addressName/addressName */
	private String addressName ;		
	/** 属性风险等级/风险等级 */
	private String riskLevel ;		
	/** 属性风险等级描述/风险等级描述 */
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
	private Double disFee ;
	/** 属性chgAmount/chgAmount */
	private Double chgAmount ;
	/** 属性chgPremium/chgPremium */
	private Double chgPremium ;
	/** 属性chgdisfee/chgdisfee */
	private Double chgDisFee ;
	/** 属性dangerShare/dangerShare */
	private Double dangerShare ;
	/** 属性retCurrency/retCurrency */
	private String retCurrency ;		
	/** 属性retEntionValue/retEntionValue */
	private Double retentionValue ;
	/** 属性remarks/remarks */
	private String remarks ;		
	/** 属性flag/flag */
	private String flag ;		
	/** 属性endorseTimes/endorseTimes */
	private Integer endorseTimes ;
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
	/** 属性shareHolderFlag/shareHolderFlag */
	private String shareholderFlag ;		
	/** 属性businessFlag/businessFlag */
	private String businessFlag ;		
	/** 属性每人保额/限额/每人保额/限额 */
	private Double unitAmount ;
	/** 属性危险单位限额/危险单位限额 */
	private Double limitAmount ;
	/** 属性危险单位限额变化量/危险单位限额变化量 */
	private Double chgLimitAmount ;
	/** 属性危险单位人数/危险单位人数 */
	private Double quantity ;
	/** 属性危险单位人数变化量/危险单位人数变化量 */
	private Double chgQuantity ;
	/** 属性危险单位方案（意见险）/危险单位方案（意见险） */
	private String rationType ;		
	/** 属性0 不是组合险种危险单位 1 是组合险种危险单位/0 不是组合险种危险单位 1 是组合险种危险单位 */
	private String zhFlag ;		
	/** 属性再保虚拟险种代码/再保虚拟险种代码 */
	private String dumRiskCode ;		
	/** 属性保单合并危险单位标志:[1]1--合并危险单位,0--正常危险单位;[2]1--已入账,0--未入账/保单合并危险单位标志:[1]1--合并危险单位,0--正常危险单位;[2]1--已入账,0--未入账 */
	private String unitDangerFlag ;		
	/** 属性溢额特别申报标志;00:不申报,10:建议申报,11:建议申报并临分/溢额特别申报标志;00:不申报,10:建议申报,11:建议申报并临分 */
	private String acceptanceFlag ;		
	/** 属性retenTionRate/retenTionRate */
	private Double retentionRate ;
	/** 属性retenTionRateFlag/retenTionRateFlag */
	private String retentionRateFlag ;		
	/** 属性业务来源PrpDcode.CodeType = 'BusinessNature'/业务来源PrpDcode.CodeType = 'BusinessNature' */
	private String businessNature ;		
	/** 属性保单业务类型（01：政策性农业险、02：商业性农业险、03：政策性涉农险、04：商业性涉农险、05：非农险）/保单业务类型（01：政策性农业险、02：商业性农业险、03：政策性涉农险、04：商业性涉农险、05：非农险） */
	private String policyBizType ;		
	/** 属性投保方式PrpDcode.CodeType = 'PolicyType'/投保方式PrpDcode.CodeType = 'PolicyType' */
	private String policyType ;		
	/** 属性中央政策性/地方政策性/商业性标志PrpDcode.CodeType = 'BusinessType1'/中央政策性/地方政策性/商业性标志PrpDcode.CodeType = 'BusinessType1' */
	private String businessType1 ;		
	/** 属性农业/涉农/非农标志PrpDcode.CodeType = 'BusinessType0'/农业/涉农/非农标志PrpDcode.CodeType = 'BusinessType0' */
	private String businessType ;		
	/** 属性其它标志字段/其它标志字段 */
	private String othFlag ;		
	/** 属性归属区域：省 PrpDcode.CodeType = 'BusinessZone'/归属区域：省 PrpDcode.CodeType = 'BusinessZone' */
	private String businessProvince ;		
	/** 属性归属区域：地市 PrpDcode.CodeType = 'BusinessZone'/归属区域：地市 PrpDcode.CodeType = 'BusinessZone' */
	private String businessTown ;		
	/** 属性归属区域：区县 PrpDcode.CodeType = 'BusinessZone'/归属区域：区县 PrpDcode.CodeType = 'BusinessZone' */
	private String businessCounty ;		
	/** 属性归属区域：乡镇/归属区域：乡镇 */
	private String businessAreaName ;		
	/** 属性备用字段1/备用字段1 */
	private String othValue1 ;		
	/** 属性备用字段2/备用字段2 */
	private String othValue2 ;		
	/** 属性备用字段3/备用字段3 */
	private String othValue3 ;		
	/** 属性总不含税保费/总不含税保费 */
	private Double sumNoTaxPremium ;
	/** 属性总税额/总税额 */
	private Double sumTaxFee ;
	/** 属性不含税保费变化量/不含税保费变化量 */
	private Double chgNoTaxPremium ;
	/** 属性税额变化量/税额变化量 */
	private Double chgTaxFee ;
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
	 * 属性危险单位序号/危险单位序号的getter方法
	 */
	public Integer getDangerNo() {
		return dangerNo;
	}
	/**
	 * 属性危险单位序号/危险单位序号的setter方法
	 */
	public void setDangerNo(Integer dangerNo) {
		this.dangerNo = dangerNo;
	}	
	/**
	 * 属性危险单位信息描述/危险单位信息描述的getter方法
	 */
	public String getDangerDesc() {
		return dangerDesc;
	}
	/**
	 * 属性危险单位信息描述/危险单位信息描述的setter方法
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
	 * 属性风险等级/风险等级的getter方法
	 */
	public String getRiskLevel() {
		return riskLevel;
	}
	/**
	 * 属性风险等级/风险等级的setter方法
	 */
	public void setRiskLevel(String riskLevel) {
		this.riskLevel = riskLevel;
	}	
	/**
	 * 属性风险等级描述/风险等级描述的getter方法
	 */
	public String getRiskLevelDesc() {
		return riskLevelDesc;
	}
	/**
	 * 属性风险等级描述/风险等级描述的setter方法
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
	public Double getDisFee() {
		return disFee;
	}
	/**
	 * 属性disfee/disfee的setter方法
	 */
	public void setDisFee(Double disFee) {
		this.disFee = disFee;
	}	
	/**
	 * 属性chgAmount/chgAmount的getter方法
	 */
	public Double getChgAmount() {
		return chgAmount;
	}
	/**
	 * 属性chgAmount/chgAmount的setter方法
	 */
	public void setChgAmount(Double chgAmount) {
		this.chgAmount = chgAmount;
	}	
	/**
	 * 属性chgPremium/chgPremium的getter方法
	 */
	public Double getChgPremium() {
		return chgPremium;
	}
	/**
	 * 属性chgPremium/chgPremium的setter方法
	 */
	public void setChgPremium(Double chgPremium) {
		this.chgPremium = chgPremium;
	}	
	/**
	 * 属性chgdisfee/chgdisfee的getter方法
	 */
	public Double getChgDisFee() {
		return chgDisFee;
	}
	/**
	 * 属性chgdisfee/chgdisfee的setter方法
	 */
	public void setChgDisFee(Double chgDisFee) {
		this.chgDisFee = chgDisFee;
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
	 * 属性retEntionValue/retEntionValue的getter方法
	 */
	public Double getRetentionValue() {
		return retentionValue;
	}
	/**
	 * 属性retEntionValue/retEntionValue的setter方法
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
	 * 属性shareHolderFlag/shareHolderFlag的getter方法
	 */
	public String getShareholderFlag() {
		return shareholderFlag;
	}
	/**
	 * 属性shareHolderFlag/shareHolderFlag的setter方法
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
	 * 属性危险单位限额变化量/危险单位限额变化量的getter方法
	 */
	public Double getChgLimitAmount() {
		return chgLimitAmount;
	}
	/**
	 * 属性危险单位限额变化量/危险单位限额变化量的setter方法
	 */
	public void setChgLimitAmount(Double chgLimitAmount) {
		this.chgLimitAmount = chgLimitAmount;
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
	 * 属性危险单位人数变化量/危险单位人数变化量的getter方法
	 */
	public Double getChgQuantity() {
		return chgQuantity;
	}
	/**
	 * 属性危险单位人数变化量/危险单位人数变化量的setter方法
	 */
	public void setChgQuantity(Double chgQuantity) {
		this.chgQuantity = chgQuantity;
	}	
	/**
	 * 属性危险单位方案（意见险）/危险单位方案（意见险）的getter方法
	 */
	public String getRationType() {
		return rationType;
	}
	/**
	 * 属性危险单位方案（意见险）/危险单位方案（意见险）的setter方法
	 */
	public void setRationType(String rationType) {
		this.rationType = rationType;
	}	
	/**
	 * 属性0 不是组合险种危险单位 1 是组合险种危险单位/0 不是组合险种危险单位 1 是组合险种危险单位的getter方法
	 */
	public String getZhFlag() {
		return zhFlag;
	}
	/**
	 * 属性0 不是组合险种危险单位 1 是组合险种危险单位/0 不是组合险种危险单位 1 是组合险种危险单位的setter方法
	 */
	public void setZhFlag(String zhFlag) {
		this.zhFlag = zhFlag;
	}	
	/**
	 * 属性再保虚拟险种代码/再保虚拟险种代码的getter方法
	 */
	public String getDumRiskCode() {
		return dumRiskCode;
	}
	/**
	 * 属性再保虚拟险种代码/再保虚拟险种代码的setter方法
	 */
	public void setDumRiskCode(String dumRiskCode) {
		this.dumRiskCode = dumRiskCode;
	}	
	/**
	 * 属性保单合并危险单位标志:[1]1--合并危险单位,0--正常危险单位;[2]1--已入账,0--未入账/保单合并危险单位标志:[1]1--合并危险单位,0--正常危险单位;[2]1--已入账,0--未入账的getter方法
	 */
	public String getUnitDangerFlag() {
		return unitDangerFlag;
	}
	/**
	 * 属性保单合并危险单位标志:[1]1--合并危险单位,0--正常危险单位;[2]1--已入账,0--未入账/保单合并危险单位标志:[1]1--合并危险单位,0--正常危险单位;[2]1--已入账,0--未入账的setter方法
	 */
	public void setUnitDangerFlag(String unitDangerFlag) {
		this.unitDangerFlag = unitDangerFlag;
	}	
	/**
	 * 属性溢额特别申报标志;00:不申报,10:建议申报,11:建议申报并临分/溢额特别申报标志;00:不申报,10:建议申报,11:建议申报并临分的getter方法
	 */
	public String getAcceptanceFlag() {
		return acceptanceFlag;
	}
	/**
	 * 属性溢额特别申报标志;00:不申报,10:建议申报,11:建议申报并临分/溢额特别申报标志;00:不申报,10:建议申报,11:建议申报并临分的setter方法
	 */
	public void setAcceptanceFlag(String acceptanceFlag) {
		this.acceptanceFlag = acceptanceFlag;
	}	
	/**
	 * 属性retenTionRate/retenTionRate的getter方法
	 */
	public Double getRetentionRate() {
		return retentionRate;
	}
	/**
	 * 属性retenTionRate/retenTionRate的setter方法
	 */
	public void setRetentionRate(Double retentionRate) {
		this.retentionRate = retentionRate;
	}	
	/**
	 * 属性retenTionRateFlag/retenTionRateFlag的getter方法
	 */
	public String getRetentionRateFlag() {
		return retentionRateFlag;
	}
	/**
	 * 属性retenTionRateFlag/retenTionRateFlag的setter方法
	 */
	public void setRetentionRateFlag(String retentionRateFlag) {
		this.retentionRateFlag = retentionRateFlag;
	}	
	/**
	 * 属性业务来源PrpDcode.CodeType = 'BusinessNature'/业务来源PrpDcode.CodeType = 'BusinessNature'的getter方法
	 */
	public String getBusinessNature() {
		return businessNature;
	}
	/**
	 * 属性业务来源PrpDcode.CodeType = 'BusinessNature'/业务来源PrpDcode.CodeType = 'BusinessNature'的setter方法
	 */
	public void setBusinessNature(String businessNature) {
		this.businessNature = businessNature;
	}	
	/**
	 * 属性保单业务类型（01：政策性农业险、02：商业性农业险、03：政策性涉农险、04：商业性涉农险、05：非农险）/保单业务类型（01：政策性农业险、02：商业性农业险、03：政策性涉农险、04：商业性涉农险、05：非农险）的getter方法
	 */
	public String getPolicyBizType() {
		return policyBizType;
	}
	/**
	 * 属性保单业务类型（01：政策性农业险、02：商业性农业险、03：政策性涉农险、04：商业性涉农险、05：非农险）/保单业务类型（01：政策性农业险、02：商业性农业险、03：政策性涉农险、04：商业性涉农险、05：非农险）的setter方法
	 */
	public void setPolicyBizType(String policyBizType) {
		this.policyBizType = policyBizType;
	}	
	/**
	 * 属性投保方式PrpDcode.CodeType = 'PolicyType'/投保方式PrpDcode.CodeType = 'PolicyType'的getter方法
	 */
	public String getPolicyType() {
		return policyType;
	}
	/**
	 * 属性投保方式PrpDcode.CodeType = 'PolicyType'/投保方式PrpDcode.CodeType = 'PolicyType'的setter方法
	 */
	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}	
	/**
	 * 属性中央政策性/地方政策性/商业性标志PrpDcode.CodeType = 'BusinessType1'/中央政策性/地方政策性/商业性标志PrpDcode.CodeType = 'BusinessType1'的getter方法
	 */
	public String getBusinessType1() {
		return businessType1;
	}
	/**
	 * 属性中央政策性/地方政策性/商业性标志PrpDcode.CodeType = 'BusinessType1'/中央政策性/地方政策性/商业性标志PrpDcode.CodeType = 'BusinessType1'的setter方法
	 */
	public void setBusinessType1(String businessType1) {
		this.businessType1 = businessType1;
	}	
	/**
	 * 属性农业/涉农/非农标志PrpDcode.CodeType = 'BusinessType0'/农业/涉农/非农标志PrpDcode.CodeType = 'BusinessType0'的getter方法
	 */
	public String getBusinessType() {
		return businessType;
	}
	/**
	 * 属性农业/涉农/非农标志PrpDcode.CodeType = 'BusinessType0'/农业/涉农/非农标志PrpDcode.CodeType = 'BusinessType0'的setter方法
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
	 * 属性归属区域：省 PrpDcode.CodeType = 'BusinessZone'/归属区域：省 PrpDcode.CodeType = 'BusinessZone'的getter方法
	 */
	public String getBusinessProvince() {
		return businessProvince;
	}
	/**
	 * 属性归属区域：省 PrpDcode.CodeType = 'BusinessZone'/归属区域：省 PrpDcode.CodeType = 'BusinessZone'的setter方法
	 */
	public void setBusinessProvince(String businessProvince) {
		this.businessProvince = businessProvince;
	}	
	/**
	 * 属性归属区域：地市 PrpDcode.CodeType = 'BusinessZone'/归属区域：地市 PrpDcode.CodeType = 'BusinessZone'的getter方法
	 */
	public String getBusinessTown() {
		return businessTown;
	}
	/**
	 * 属性归属区域：地市 PrpDcode.CodeType = 'BusinessZone'/归属区域：地市 PrpDcode.CodeType = 'BusinessZone'的setter方法
	 */
	public void setBusinessTown(String businessTown) {
		this.businessTown = businessTown;
	}	
	/**
	 * 属性归属区域：区县 PrpDcode.CodeType = 'BusinessZone'/归属区域：区县 PrpDcode.CodeType = 'BusinessZone'的getter方法
	 */
	public String getBusinessCounty() {
		return businessCounty;
	}
	/**
	 * 属性归属区域：区县 PrpDcode.CodeType = 'BusinessZone'/归属区域：区县 PrpDcode.CodeType = 'BusinessZone'的setter方法
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
	public Double getSumTaxFee() {
		return sumTaxFee;
	}
	/**
	 * 属性总税额/总税额的setter方法
	 */
	public void setSumTaxFee(Double sumTaxFee) {
		this.sumTaxFee = sumTaxFee;
	}	
	/**
	 * 属性不含税保费变化量/不含税保费变化量的getter方法
	 */
	public Double getChgNoTaxPremium() {
		return chgNoTaxPremium;
	}
	/**
	 * 属性不含税保费变化量/不含税保费变化量的setter方法
	 */
	public void setChgNoTaxPremium(Double chgNoTaxPremium) {
		this.chgNoTaxPremium = chgNoTaxPremium;
	}	
	/**
	 * 属性税额变化量/税额变化量的getter方法
	 */
	public Double getChgTaxFee() {
		return chgTaxFee;
	}
	/**
	 * 属性税额变化量/税额变化量的setter方法
	 */
	public void setChgTaxFee(Double chgTaxFee) {
		this.chgTaxFee = chgTaxFee;
	}	
}
