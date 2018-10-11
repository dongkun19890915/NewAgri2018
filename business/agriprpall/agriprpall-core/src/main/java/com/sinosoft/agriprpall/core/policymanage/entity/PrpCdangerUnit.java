package com.sinosoft.agriprpall.core.policymanage.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-04 09:53:57.649 
 * 保单的危险单位划分表实体操作对象
 */
@Entity
@Table(name = "PrpCdangerUnit")
@IdClass(PrpCdangerUnitKey.class)
public class PrpCdangerUnit extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性保单号码 /保单号码  */
	@Id
	@Column(name = "policyNo")
	private String policyNo ;/** 属性危险单位序号 /危险单位序号  */
	@Id
	@Column(name = "dangerNo")
	private java.lang.Integer dangerNo ;	

	/** 属性险种代码/险种代码 */
	@Column(name = "riskCode")
	private String riskCode ;

	/** 属性危险单位信息描述/危险单位信息描述 */
	@Column(name = "dangerDesc")
	private String dangerDesc ;
	/** 属性危险单位地址信息/危险单位地址信息 */
	@Column(name = "addressName")
	private String addressName ;
	/** 属性风险等级/风险等级 */
	@Column(name = "riskLevel")
	private String riskLevel ;
	/** 属性风险等级描述/风险等级描述 */
	@Column(name = "riskLevelDesc")
	private String riskLevelDesc ;
	/** 属性标的类型/标的类型 */
	@Column(name = "itemKind")
	private String itemKind ;
	/** 属性标的类型描述/标的类型描述 */
	@Column(name = "itemKindDesc")
	private String itemKindDesc ;
	/** 属性币别/币别 */
	@Column(name = "currency")
	private String currency ;
	/** 属性保额/保额 */
	@Column(name = "amount")
	private java.lang.Double amount ;
	/** 属性保费/保费 */
	@Column(name = "premium")
	private java.lang.Double premium ;
	/** 属性中间成本/中间成本 */
	@Column(name = "disFee")
	private java.lang.Double disFee ;
	/** 属性占比/占比 */
	@Column(name = "dangerShare")
	private java.lang.Double dangerShare ;
	/** 属性retCurrency/retCurrency */
	@Column(name = "retCurrency")
	private String retCurrency ;
	/** 属性自留额/自留额 */
	@Column(name = "retentionValue")
	private java.lang.Double retentionValue ;
	/** 属性备注(临分方式下，在分保条、临分出险通知书打印时带出此部分描述)/备注(临分方式下，在分保条、临分出险通知书打印时带出此部分描述) */
	@Column(name = "remarks")
	private String remarks ;
	/** 属性标志字段/标志字段 */
	@Column(name = "flag")
	private String flag ;
	/** 属性endorseTimes/endorseTimes */
	@Column(name = "endorseTimes")
	private java.lang.Integer endorseTimes ;
	/** 属性speCurrency/speCurrency */
	@Column(name = "speCurrency")
	private String speCurrency ;
	/** 属性speRate/speRate */
	@Column(name = "speRate")
	private java.lang.Double speRate ;
	/** 属性speValue/speValue */
	@Column(name = "speValue")
	private java.lang.Double speValue ;
	/** 属性groupFlag/groupFlag */
	@Column(name = "groupFlag")
	private String groupFlag ;
	/** 属性reinsureFlag/reinsureFlag */
	@Column(name = "reinsureFlag")
	private String reinsureFlag ;
	/** 属性riskClassDesc/riskClassDesc */
	@Column(name = "riskClassDesc")
	private String riskClassDesc ;
	/** 属性business/business */
	@Column(name = "business")
	private String business ;
	/** 属性businessDesc/businessDesc */
	@Column(name = "businessDesc")
	private String businessDesc ;
	/** 属性险类/险类 */
	@Column(name = "riskClass")
	private String riskClass ;
	/** 属性coinsFlag/coinsFlag */
	@Column(name = "coinsFlag")
	private String coinsFlag ;
	/** 属性shareHolderFlag/shareHolderFlag */
	@Column(name = "shareholderFlag")
	private String shareholderFlag ;
	/** 属性businessFlag/businessFlag */
	@Column(name = "businessFlag")
	private String businessFlag ;
	/** 属性危险单位人数/危险单位人数 */
	@Column(name = "quantity")
	private java.lang.Double quantity ;
	/** 属性每人保额/限额/每人保额/限额 */
	@Column(name = "unitAmount")
	private java.lang.Double unitAmount ;
	/** 属性危险单位限额/危险单位限额 */
	@Column(name = "limitAmount")
	private java.lang.Double limitAmount ;
	/** 属性危险单位方案（意见险）/危险单位方案（意见险） */
	@Column(name = "rationType")
	private String rationType ;
	/** 属性0 不是组合险种危险单位 1 是组合险种危险单位/0 不是组合险种危险单位 1 是组合险种危险单位 */
	@Column(name = "zhFlag")
	private String zhFlag ;
	/** 属性再保虚拟险种代码/再保虚拟险种代码 */
	@Column(name = "dumRiskCode")
	private String dumRiskCode ;
	/** 属性保单合并危险单位标志/保单合并危险单位标志 */
	@Column(name = "unitDangerFlag")
	private String unitDangerFlag ;
	/** 属性溢额特别申报标志;00:不申报,10:建议申报,11:建议申报并临分/溢额特别申报标志;00:不申报,10:建议申报,11:建议申报并临分 */
	@Column(name = "acceptanceFlag")
	private String acceptanceFlag ;
	/** 属性retenTionRate/retenTionRate */
	@Column(name = "retentionRate")
	private java.lang.Double retentionRate ;
	/** 属性retenTionRateFlag/retenTionRateFlag */
	@Column(name = "retentionRateFlag")
	private String retentionRateFlag ;
	/** 属性业务来源PrpDcode.CodeType = 'BusinessNature'/业务来源PrpDcode.CodeType = 'BusinessNature' */
	@Column(name = "businessNature")
	private String businessNature ;
	/** 属性保单业务类型（01：政策性农业险、02：商业性农业险、03：政策性涉农险、04：商业性涉农险、05：非农险）/保单业务类型（01：政策性农业险、02：商业性农业险、03：政策性涉农险、04：商业性涉农险、05：非农险） */
	@Column(name = "policyBizType")
	private String policyBizType ;
	/** 属性投保方式PrpDcode.CodeType = 'PolicyType'/投保方式PrpDcode.CodeType = 'PolicyType' */
	@Column(name = "policyType")
	private String policyType ;
	/** 属性中央政策性/地方政策性/商业性标志PrpDcode.CodeType = 'BusinessType1'/中央政策性/地方政策性/商业性标志PrpDcode.CodeType = 'BusinessType1' */
	@Column(name = "businessType1")
	private String businessType1 ;
	/** 属性农业/涉农/非农标志PrpDcode.CodeType = 'BusinessType0'/农业/涉农/非农标志PrpDcode.CodeType = 'BusinessType0' */
	@Column(name = "businessType")
	private String businessType ;
	/** 属性其它标志字段/其它标志字段 */
	@Column(name = "othFlag")
	private String othFlag ;
	/** 属性归属区域：省 PrpDcode.CodeType = 'BusinessZone'/归属区域：省 PrpDcode.CodeType = 'BusinessZone' */
	@Column(name = "businessProvince")
	private String businessProvince ;
	/** 属性归属区域：地市 PrpDcode.CodeType = 'BusinessZone'/归属区域：地市 PrpDcode.CodeType = 'BusinessZone' */
	@Column(name = "businessTown")
	private String businessTown ;
	/** 属性归属区域：区县 PrpDcode.CodeType = 'BusinessZone'/归属区域：区县 PrpDcode.CodeType = 'BusinessZone' */
	@Column(name = "businessCounty")
	private String businessCounty ;
	/** 属性归属区域：乡镇/归属区域：乡镇 */
	@Column(name = "businessAreaName")
	private String businessAreaName ;
	/** 属性备用字段1/备用字段1 */
	@Column(name = "othValue1")
	private String othValue1 ;
	/** 属性备用字段2/备用字段2 */
	@Column(name = "othValue2")
	private String othValue2 ;
	/** 属性备用字段3/备用字段3 */
	@Column(name = "othValue3")
	private String othValue3 ;
	/** 属性总不含税保费/总不含税保费 */
	@Column(name = "sumNoTaxPremium")
	private java.lang.Double sumNoTaxPremium ;
	/** 属性总税额/总税额 */
	@Column(name = "sumTaxFee")
	private java.lang.Double sumTaxFee ;
	/**
	 * 属性保单号码 /保单号码 的getter方法
	 */
	public String getPolicyNo() {
		return policyNo;
	}
	/**
	 * 属性保单号码 /保单号码 的setter方法
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
	 * 属性危险单位序号 /危险单位序号 的getter方法
	 */
	public java.lang.Integer getDangerNo() {
		return dangerNo;
	}
	/**
	 * 属性危险单位序号 /危险单位序号 的setter方法
	 */
	public void setDangerNo(java.lang.Integer dangerNo) {
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
	 * 属性危险单位地址信息/危险单位地址信息的getter方法
	 */
	public String getAddressName() {
		return addressName;
	}
	/**
	 * 属性危险单位地址信息/危险单位地址信息的setter方法
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
	 * 属性标的类型/标的类型的getter方法
	 */
	public String getItemKind() {
		return itemKind;
	}
	/**
	 * 属性标的类型/标的类型的setter方法
	 */
	public void setItemKind(String itemKind) {
		this.itemKind = itemKind;
	} 	
	/**
	 * 属性标的类型描述/标的类型描述的getter方法
	 */
	public String getItemKindDesc() {
		return itemKindDesc;
	}
	/**
	 * 属性标的类型描述/标的类型描述的setter方法
	 */
	public void setItemKindDesc(String itemKindDesc) {
		this.itemKindDesc = itemKindDesc;
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
	 * 属性保额/保额的getter方法
	 */
	public java.lang.Double getAmount() {
		return amount;
	}
	/**
	 * 属性保额/保额的setter方法
	 */
	public void setAmount(java.lang.Double amount) {
		this.amount = amount;
	} 	
	/**
	 * 属性保费/保费的getter方法
	 */
	public java.lang.Double getPremium() {
		return premium;
	}
	/**
	 * 属性保费/保费的setter方法
	 */
	public void setPremium(java.lang.Double premium) {
		this.premium = premium;
	} 	
	/**
	 * 属性中间成本/中间成本的getter方法
	 */
	public java.lang.Double getDisFee() {
		return disFee;
	}
	/**
	 * 属性中间成本/中间成本的setter方法
	 */
	public void setDisFee(java.lang.Double disFee) {
		this.disFee = disFee;
	} 	
	/**
	 * 属性占比/占比的getter方法
	 */
	public java.lang.Double getDangerShare() {
		return dangerShare;
	}
	/**
	 * 属性占比/占比的setter方法
	 */
	public void setDangerShare(java.lang.Double dangerShare) {
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
	 * 属性自留额/自留额的getter方法
	 */
	public java.lang.Double getRetentionValue() {
		return retentionValue;
	}
	/**
	 * 属性自留额/自留额的setter方法
	 */
	public void setRetentionValue(java.lang.Double retentionValue) {
		this.retentionValue = retentionValue;
	} 	
	/**
	 * 属性备注(临分方式下，在分保条、临分出险通知书打印时带出此部分描述)/备注(临分方式下，在分保条、临分出险通知书打印时带出此部分描述)的getter方法
	 */
	public String getRemarks() {
		return remarks;
	}
	/**
	 * 属性备注(临分方式下，在分保条、临分出险通知书打印时带出此部分描述)/备注(临分方式下，在分保条、临分出险通知书打印时带出此部分描述)的setter方法
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
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
	 * 属性endorseTimes/endorseTimes的getter方法
	 */
	public java.lang.Integer getEndorseTimes() {
		return endorseTimes;
	}
	/**
	 * 属性endorseTimes/endorseTimes的setter方法
	 */
	public void setEndorseTimes(java.lang.Integer endorseTimes) {
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
	public java.lang.Double getSpeRate() {
		return speRate;
	}
	/**
	 * 属性speRate/speRate的setter方法
	 */
	public void setSpeRate(java.lang.Double speRate) {
		this.speRate = speRate;
	} 	
	/**
	 * 属性speValue/speValue的getter方法
	 */
	public java.lang.Double getSpeValue() {
		return speValue;
	}
	/**
	 * 属性speValue/speValue的setter方法
	 */
	public void setSpeValue(java.lang.Double speValue) {
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
	 * 属性险类/险类的getter方法
	 */
	public String getRiskClass() {
		return riskClass;
	}
	/**
	 * 属性险类/险类的setter方法
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
	 * 属性危险单位人数/危险单位人数的getter方法
	 */
	public java.lang.Double getQuantity() {
		return quantity;
	}
	/**
	 * 属性危险单位人数/危险单位人数的setter方法
	 */
	public void setQuantity(java.lang.Double quantity) {
		this.quantity = quantity;
	} 	
	/**
	 * 属性每人保额/限额/每人保额/限额的getter方法
	 */
	public java.lang.Double getUnitAmount() {
		return unitAmount;
	}
	/**
	 * 属性每人保额/限额/每人保额/限额的setter方法
	 */
	public void setUnitAmount(java.lang.Double unitAmount) {
		this.unitAmount = unitAmount;
	} 	
	/**
	 * 属性危险单位限额/危险单位限额的getter方法
	 */
	public java.lang.Double getLimitAmount() {
		return limitAmount;
	}
	/**
	 * 属性危险单位限额/危险单位限额的setter方法
	 */
	public void setLimitAmount(java.lang.Double limitAmount) {
		this.limitAmount = limitAmount;
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
	 * 属性保单合并危险单位标志/保单合并危险单位标志的getter方法
	 */
	public String getUnitDangerFlag() {
		return unitDangerFlag;
	}
	/**
	 * 属性保单合并危险单位标志/保单合并危险单位标志的setter方法
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
	public java.lang.Double getRetentionRate() {
		return retentionRate;
	}
	/**
	 * 属性retenTionRate/retenTionRate的setter方法
	 */
	public void setRetentionRate(java.lang.Double retentionRate) {
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
	public java.lang.Double getSumNoTaxPremium() {
		return sumNoTaxPremium;
	}
	/**
	 * 属性总不含税保费/总不含税保费的setter方法
	 */
	public void setSumNoTaxPremium(java.lang.Double sumNoTaxPremium) {
		this.sumNoTaxPremium = sumNoTaxPremium;
	} 	
	/**
	 * 属性总税额/总税额的getter方法
	 */
	public java.lang.Double getSumTaxFee() {
		return sumTaxFee;
	}
	/**
	 * 属性总税额/总税额的setter方法
	 */
	public void setSumTaxFee(java.lang.Double sumTaxFee) {
		this.sumTaxFee = sumTaxFee;
	} 	
}