package com.sinosoft.agriclaim.api.checkmanage.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-17 08:28:31.346 
 * 定核损主表Api操作对象
 */
public class PrpLverifyLossDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性报案号码/报案号码 */
	private String registNo ;		
	/** 属性立案号码/立案号码 */
	private String claimNo ;		
	/** 属性险种代码/险种代码 */
	private String riskCode ;		
	/** 属性保单号码/保单号码 */
	private String policyNo ;		
	/** 属性标的序号/标的序号 */
	private String lossItemCode ;		
	/** 属性车牌号码/车牌号码 */
	private String lossItemName ;		
	/** 属性是否为本保单车辆/是否为本保单车辆 */
	private String insureCarFlag ;		
	/** 属性被保险人/被保险人 */
	private String insuredName ;		
	/** 属性号牌号码/号牌号码 */
	private String licenseNo ;		
	/** 属性号牌底色代码/号牌底色代码 */
	private String licenseColorCode ;		
	/** 属性号牌种类代码/号牌种类代码 */
	private String carKindCode ;		
	/** 属性币别代码/币别代码 */
	private String currency ;		
	/** 属性定损总金额/定损总金额 */
	private java.lang.Double sumPRedEfloss ;		
	/** 属性核损总金额/核损总金额 */
	private java.lang.Double sumdefloss ;		
	/** 属性出单机构/出单机构 */
	private String makeCom ;		
	/** 属性业务归属机构代码/业务归属机构代码 */
	private String comCode ;		
	/** 属性定损人代码/定损人代码 */
	private String handlerCode ;		
	/** 属性定损人（名称）/定损人（名称） */
	private String handlerName ;		
	/** 属性定损结束日期/定损结束日期 */
	private java.util.Date defLossDate ;		
	/** 属性核损人代码/核损人代码 */
	private String underWriteCode ;		
	/** 属性核损人名称/核损人名称 */
	private String underWriteName ;		
	/** 属性最终核损完成日期/最终核损完成日期 */
	private java.util.Date underWriteEndDate ;		
	/** 属性是否经过核损标志/是否经过核损标志 */
	private String underWriteFlag ;		
	/** 属性备注/备注 */
	private String remark ;		
	/** 属性备注(核损) /备注(核损)  */
	private String verifyRemark ;		
	/** 属性标志字段/标志字段 */
	private String flag ;		
	/** 属性回勘意见/回勘意见 */
	private String backCheckRemark ;		
	/** 属性人伤核损回退的原因/人伤核损回退的原因 */
	private String veriwReturnReason ;		
	/** 属性核损意见/核损意见 */
	private String verifyOpinion ;		
	/** 属性初次定损金额/初次定损金额 */
	private java.lang.Double firstdefloss ;		
	/** 属性偏差定损金额/偏差定损金额 */
	private java.lang.Double warpdefloss ;		
	/** 属性核价人代码/核价人代码 */
	private String verpapprOverCode ;		
	/** 属性核价时间/核价时间 */
	private java.util.Date verpdAte ;		
	/** 属性核价意见/核价意见 */
	private String verPopInIOn ;		
	/** 属性备注(核价) /备注(核价)  */
	private String verpRemark ;		
	/** 属性理算退回标记/理算退回标记 */
	private String compensateFlag ;		
	/** 属性理算退回原因/理算退回原因 */
	private String compensatEopinIOn ;		
	/** 属性理算退回时间/理算退回时间 */
	private java.util.Date comPenSAtEBackDate ;		
	/** 属性理算退回的操作人/理算退回的操作人 */
	private String comPenSAtEApproveRcode ;		
	/** 属性赔付数量/赔付数量 */
	private java.lang.Double lossEsnumBer ;		
	/** 属性赔付数量计量单位/赔付数量计量单位 */
	private String lossESunItCode ;		
	/** 属性出险户次/出险户次 */
	private java.lang.Double damageInsured ;		
	/** 属性受灾面积/受灾面积 */
	private java.lang.Double disasterArea ;		
	/** 属性受灾面积计量单位/受灾面积计量单位 */
	private String disasterUnit ;		
	/** 属性成灾面积/成灾面积 */
	private java.lang.Double affectEDarea ;		
	/** 属性成灾面积计量单位/成灾面积计量单位 */
	private String affectedunit ;		
	/** 属性绝产面积/绝产面积 */
	private java.lang.Double noProductionArea ;		
	/** 属性绝产面积计量单位/绝产面积计量单位 */
	private String noProductionUnit ;		
	/** 属性死亡数量/死亡数量 */
	private java.lang.Double deathQuantity ;		
	/** 属性死亡数量计量单位/死亡数量计量单位 */
	private String deathUnit ;		
	/** 属性扑杀数量/扑杀数量 */
	private java.lang.Double killQuantity ;		
	/** 属性扑杀数量计量单位/扑杀数量计量单位 */
	private String killUnit ;		
	/** 属性农业/涉农/非农/农业/涉农/非农 */
	private String businessType ;		
	/** 属性中央政策性/地方政策性/商业性/中央政策性/地方政策性/商业性 */
	private String businessType1 ;		
	/** 属性是否需要发起复勘 0 不需要 1 需要/是否需要发起复勘 0 不需要 1 需要 */
	private String reCheckFlag ;		
	/** 属性补充说明/补充说明 */
	private String reCheckRemark ;		
	/**
	 * 属性报案号码/报案号码的getter方法
	 */
	public String getRegistNo() {
		return registNo;
	}
	/**
	 * 属性报案号码/报案号码的setter方法
	 */
	public void setRegistNo(String registNo) {
		this.registNo = registNo;
	}	
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
	 * 属性标的序号/标的序号的getter方法
	 */
	public String getLossItemCode() {
		return lossItemCode;
	}
	/**
	 * 属性标的序号/标的序号的setter方法
	 */
	public void setLossItemCode(String lossItemCode) {
		this.lossItemCode = lossItemCode;
	}	
	/**
	 * 属性车牌号码/车牌号码的getter方法
	 */
	public String getLossItemName() {
		return lossItemName;
	}
	/**
	 * 属性车牌号码/车牌号码的setter方法
	 */
	public void setLossItemName(String lossItemName) {
		this.lossItemName = lossItemName;
	}	
	/**
	 * 属性是否为本保单车辆/是否为本保单车辆的getter方法
	 */
	public String getInsureCarFlag() {
		return insureCarFlag;
	}
	/**
	 * 属性是否为本保单车辆/是否为本保单车辆的setter方法
	 */
	public void setInsureCarFlag(String insureCarFlag) {
		this.insureCarFlag = insureCarFlag;
	}	
	/**
	 * 属性被保险人/被保险人的getter方法
	 */
	public String getInsuredName() {
		return insuredName;
	}
	/**
	 * 属性被保险人/被保险人的setter方法
	 */
	public void setInsuredName(String insuredName) {
		this.insuredName = insuredName;
	}	
	/**
	 * 属性号牌号码/号牌号码的getter方法
	 */
	public String getLicenseNo() {
		return licenseNo;
	}
	/**
	 * 属性号牌号码/号牌号码的setter方法
	 */
	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}	
	/**
	 * 属性号牌底色代码/号牌底色代码的getter方法
	 */
	public String getLicenseColorCode() {
		return licenseColorCode;
	}
	/**
	 * 属性号牌底色代码/号牌底色代码的setter方法
	 */
	public void setLicenseColorCode(String licenseColorCode) {
		this.licenseColorCode = licenseColorCode;
	}	
	/**
	 * 属性号牌种类代码/号牌种类代码的getter方法
	 */
	public String getCarKindCode() {
		return carKindCode;
	}
	/**
	 * 属性号牌种类代码/号牌种类代码的setter方法
	 */
	public void setCarKindCode(String carKindCode) {
		this.carKindCode = carKindCode;
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
	 * 属性定损总金额/定损总金额的getter方法
	 */
	public java.lang.Double getSumPRedEfloss() {
		return sumPRedEfloss;
	}
	/**
	 * 属性定损总金额/定损总金额的setter方法
	 */
	public void setSumPRedEfloss(java.lang.Double sumPRedEfloss) {
		this.sumPRedEfloss = sumPRedEfloss;
	}	
	/**
	 * 属性核损总金额/核损总金额的getter方法
	 */
	public java.lang.Double getSumdefloss() {
		return sumdefloss;
	}
	/**
	 * 属性核损总金额/核损总金额的setter方法
	 */
	public void setSumdefloss(java.lang.Double sumdefloss) {
		this.sumdefloss = sumdefloss;
	}	
	/**
	 * 属性出单机构/出单机构的getter方法
	 */
	public String getMakeCom() {
		return makeCom;
	}
	/**
	 * 属性出单机构/出单机构的setter方法
	 */
	public void setMakeCom(String makeCom) {
		this.makeCom = makeCom;
	}	
	/**
	 * 属性业务归属机构代码/业务归属机构代码的getter方法
	 */
	public String getComCode() {
		return comCode;
	}
	/**
	 * 属性业务归属机构代码/业务归属机构代码的setter方法
	 */
	public void setComCode(String comCode) {
		this.comCode = comCode;
	}	
	/**
	 * 属性定损人代码/定损人代码的getter方法
	 */
	public String getHandlerCode() {
		return handlerCode;
	}
	/**
	 * 属性定损人代码/定损人代码的setter方法
	 */
	public void setHandlerCode(String handlerCode) {
		this.handlerCode = handlerCode;
	}	
	/**
	 * 属性定损人（名称）/定损人（名称）的getter方法
	 */
	public String getHandlerName() {
		return handlerName;
	}
	/**
	 * 属性定损人（名称）/定损人（名称）的setter方法
	 */
	public void setHandlerName(String handlerName) {
		this.handlerName = handlerName;
	}	
	/**
	 * 属性定损结束日期/定损结束日期的getter方法
	 */
	public java.util.Date getDefLossDate() {
		return defLossDate;
	}
	/**
	 * 属性定损结束日期/定损结束日期的setter方法
	 */
	public void setDefLossDate(java.util.Date defLossDate) {
		this.defLossDate = defLossDate;
	}	
	/**
	 * 属性核损人代码/核损人代码的getter方法
	 */
	public String getUnderWriteCode() {
		return underWriteCode;
	}
	/**
	 * 属性核损人代码/核损人代码的setter方法
	 */
	public void setUnderWriteCode(String underWriteCode) {
		this.underWriteCode = underWriteCode;
	}	
	/**
	 * 属性核损人名称/核损人名称的getter方法
	 */
	public String getUnderWriteName() {
		return underWriteName;
	}
	/**
	 * 属性核损人名称/核损人名称的setter方法
	 */
	public void setUnderWriteName(String underWriteName) {
		this.underWriteName = underWriteName;
	}	
	/**
	 * 属性最终核损完成日期/最终核损完成日期的getter方法
	 */
	public java.util.Date getUnderWriteEndDate() {
		return underWriteEndDate;
	}
	/**
	 * 属性最终核损完成日期/最终核损完成日期的setter方法
	 */
	public void setUnderWriteEndDate(java.util.Date underWriteEndDate) {
		this.underWriteEndDate = underWriteEndDate;
	}	
	/**
	 * 属性是否经过核损标志/是否经过核损标志的getter方法
	 */
	public String getUnderWriteFlag() {
		return underWriteFlag;
	}
	/**
	 * 属性是否经过核损标志/是否经过核损标志的setter方法
	 */
	public void setUnderWriteFlag(String underWriteFlag) {
		this.underWriteFlag = underWriteFlag;
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
	 * 属性备注(核损) /备注(核损) 的getter方法
	 */
	public String getVerifyRemark() {
		return verifyRemark;
	}
	/**
	 * 属性备注(核损) /备注(核损) 的setter方法
	 */
	public void setVerifyRemark(String verifyRemark) {
		this.verifyRemark = verifyRemark;
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
	 * 属性回勘意见/回勘意见的getter方法
	 */
	public String getBackCheckRemark() {
		return backCheckRemark;
	}
	/**
	 * 属性回勘意见/回勘意见的setter方法
	 */
	public void setBackCheckRemark(String backCheckRemark) {
		this.backCheckRemark = backCheckRemark;
	}	
	/**
	 * 属性人伤核损回退的原因/人伤核损回退的原因的getter方法
	 */
	public String getVeriwReturnReason() {
		return veriwReturnReason;
	}
	/**
	 * 属性人伤核损回退的原因/人伤核损回退的原因的setter方法
	 */
	public void setVeriwReturnReason(String veriwReturnReason) {
		this.veriwReturnReason = veriwReturnReason;
	}	
	/**
	 * 属性核损意见/核损意见的getter方法
	 */
	public String getVerifyOpinion() {
		return verifyOpinion;
	}
	/**
	 * 属性核损意见/核损意见的setter方法
	 */
	public void setVerifyOpinion(String verifyOpinion) {
		this.verifyOpinion = verifyOpinion;
	}	
	/**
	 * 属性初次定损金额/初次定损金额的getter方法
	 */
	public java.lang.Double getFirstdefloss() {
		return firstdefloss;
	}
	/**
	 * 属性初次定损金额/初次定损金额的setter方法
	 */
	public void setFirstdefloss(java.lang.Double firstdefloss) {
		this.firstdefloss = firstdefloss;
	}	
	/**
	 * 属性偏差定损金额/偏差定损金额的getter方法
	 */
	public java.lang.Double getWarpdefloss() {
		return warpdefloss;
	}
	/**
	 * 属性偏差定损金额/偏差定损金额的setter方法
	 */
	public void setWarpdefloss(java.lang.Double warpdefloss) {
		this.warpdefloss = warpdefloss;
	}	
	/**
	 * 属性核价人代码/核价人代码的getter方法
	 */
	public String getVerpapprOverCode() {
		return verpapprOverCode;
	}
	/**
	 * 属性核价人代码/核价人代码的setter方法
	 */
	public void setVerpapprOverCode(String verpapprOverCode) {
		this.verpapprOverCode = verpapprOverCode;
	}	
	/**
	 * 属性核价时间/核价时间的getter方法
	 */
	public java.util.Date getVerpdAte() {
		return verpdAte;
	}
	/**
	 * 属性核价时间/核价时间的setter方法
	 */
	public void setVerpdAte(java.util.Date verpdAte) {
		this.verpdAte = verpdAte;
	}	
	/**
	 * 属性核价意见/核价意见的getter方法
	 */
	public String getVerPopInIOn() {
		return verPopInIOn;
	}
	/**
	 * 属性核价意见/核价意见的setter方法
	 */
	public void setVerPopInIOn(String verPopInIOn) {
		this.verPopInIOn = verPopInIOn;
	}	
	/**
	 * 属性备注(核价) /备注(核价) 的getter方法
	 */
	public String getVerpRemark() {
		return verpRemark;
	}
	/**
	 * 属性备注(核价) /备注(核价) 的setter方法
	 */
	public void setVerpRemark(String verpRemark) {
		this.verpRemark = verpRemark;
	}	
	/**
	 * 属性理算退回标记/理算退回标记的getter方法
	 */
	public String getCompensateFlag() {
		return compensateFlag;
	}
	/**
	 * 属性理算退回标记/理算退回标记的setter方法
	 */
	public void setCompensateFlag(String compensateFlag) {
		this.compensateFlag = compensateFlag;
	}	
	/**
	 * 属性理算退回原因/理算退回原因的getter方法
	 */
	public String getCompensatEopinIOn() {
		return compensatEopinIOn;
	}
	/**
	 * 属性理算退回原因/理算退回原因的setter方法
	 */
	public void setCompensatEopinIOn(String compensatEopinIOn) {
		this.compensatEopinIOn = compensatEopinIOn;
	}	
	/**
	 * 属性理算退回时间/理算退回时间的getter方法
	 */
	public java.util.Date getComPenSAtEBackDate() {
		return comPenSAtEBackDate;
	}
	/**
	 * 属性理算退回时间/理算退回时间的setter方法
	 */
	public void setComPenSAtEBackDate(java.util.Date comPenSAtEBackDate) {
		this.comPenSAtEBackDate = comPenSAtEBackDate;
	}	
	/**
	 * 属性理算退回的操作人/理算退回的操作人的getter方法
	 */
	public String getComPenSAtEApproveRcode() {
		return comPenSAtEApproveRcode;
	}
	/**
	 * 属性理算退回的操作人/理算退回的操作人的setter方法
	 */
	public void setComPenSAtEApproveRcode(String comPenSAtEApproveRcode) {
		this.comPenSAtEApproveRcode = comPenSAtEApproveRcode;
	}	
	/**
	 * 属性赔付数量/赔付数量的getter方法
	 */
	public java.lang.Double getLossEsnumBer() {
		return lossEsnumBer;
	}
	/**
	 * 属性赔付数量/赔付数量的setter方法
	 */
	public void setLossEsnumBer(java.lang.Double lossEsnumBer) {
		this.lossEsnumBer = lossEsnumBer;
	}	
	/**
	 * 属性赔付数量计量单位/赔付数量计量单位的getter方法
	 */
	public String getLossESunItCode() {
		return lossESunItCode;
	}
	/**
	 * 属性赔付数量计量单位/赔付数量计量单位的setter方法
	 */
	public void setLossESunItCode(String lossESunItCode) {
		this.lossESunItCode = lossESunItCode;
	}	
	/**
	 * 属性出险户次/出险户次的getter方法
	 */
	public java.lang.Double getDamageInsured() {
		return damageInsured;
	}
	/**
	 * 属性出险户次/出险户次的setter方法
	 */
	public void setDamageInsured(java.lang.Double damageInsured) {
		this.damageInsured = damageInsured;
	}	
	/**
	 * 属性受灾面积/受灾面积的getter方法
	 */
	public java.lang.Double getDisasterArea() {
		return disasterArea;
	}
	/**
	 * 属性受灾面积/受灾面积的setter方法
	 */
	public void setDisasterArea(java.lang.Double disasterArea) {
		this.disasterArea = disasterArea;
	}	
	/**
	 * 属性受灾面积计量单位/受灾面积计量单位的getter方法
	 */
	public String getDisasterUnit() {
		return disasterUnit;
	}
	/**
	 * 属性受灾面积计量单位/受灾面积计量单位的setter方法
	 */
	public void setDisasterUnit(String disasterUnit) {
		this.disasterUnit = disasterUnit;
	}	
	/**
	 * 属性成灾面积/成灾面积的getter方法
	 */
	public java.lang.Double getAffectEDarea() {
		return affectEDarea;
	}
	/**
	 * 属性成灾面积/成灾面积的setter方法
	 */
	public void setAffectEDarea(java.lang.Double affectEDarea) {
		this.affectEDarea = affectEDarea;
	}	
	/**
	 * 属性成灾面积计量单位/成灾面积计量单位的getter方法
	 */
	public String getAffectedunit() {
		return affectedunit;
	}
	/**
	 * 属性成灾面积计量单位/成灾面积计量单位的setter方法
	 */
	public void setAffectedunit(String affectedunit) {
		this.affectedunit = affectedunit;
	}	
	/**
	 * 属性绝产面积/绝产面积的getter方法
	 */
	public java.lang.Double getNoProductionArea() {
		return noProductionArea;
	}
	/**
	 * 属性绝产面积/绝产面积的setter方法
	 */
	public void setNoProductionArea(java.lang.Double noProductionArea) {
		this.noProductionArea = noProductionArea;
	}	
	/**
	 * 属性绝产面积计量单位/绝产面积计量单位的getter方法
	 */
	public String getNoProductionUnit() {
		return noProductionUnit;
	}
	/**
	 * 属性绝产面积计量单位/绝产面积计量单位的setter方法
	 */
	public void setNoProductionUnit(String noProductionUnit) {
		this.noProductionUnit = noProductionUnit;
	}	
	/**
	 * 属性死亡数量/死亡数量的getter方法
	 */
	public java.lang.Double getDeathQuantity() {
		return deathQuantity;
	}
	/**
	 * 属性死亡数量/死亡数量的setter方法
	 */
	public void setDeathQuantity(java.lang.Double deathQuantity) {
		this.deathQuantity = deathQuantity;
	}	
	/**
	 * 属性死亡数量计量单位/死亡数量计量单位的getter方法
	 */
	public String getDeathUnit() {
		return deathUnit;
	}
	/**
	 * 属性死亡数量计量单位/死亡数量计量单位的setter方法
	 */
	public void setDeathUnit(String deathUnit) {
		this.deathUnit = deathUnit;
	}	
	/**
	 * 属性扑杀数量/扑杀数量的getter方法
	 */
	public java.lang.Double getKillQuantity() {
		return killQuantity;
	}
	/**
	 * 属性扑杀数量/扑杀数量的setter方法
	 */
	public void setKillQuantity(java.lang.Double killQuantity) {
		this.killQuantity = killQuantity;
	}	
	/**
	 * 属性扑杀数量计量单位/扑杀数量计量单位的getter方法
	 */
	public String getKillUnit() {
		return killUnit;
	}
	/**
	 * 属性扑杀数量计量单位/扑杀数量计量单位的setter方法
	 */
	public void setKillUnit(String killUnit) {
		this.killUnit = killUnit;
	}	
	/**
	 * 属性农业/涉农/非农/农业/涉农/非农的getter方法
	 */
	public String getBusinessType() {
		return businessType;
	}
	/**
	 * 属性农业/涉农/非农/农业/涉农/非农的setter方法
	 */
	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}	
	/**
	 * 属性中央政策性/地方政策性/商业性/中央政策性/地方政策性/商业性的getter方法
	 */
	public String getBusinessType1() {
		return businessType1;
	}
	/**
	 * 属性中央政策性/地方政策性/商业性/中央政策性/地方政策性/商业性的setter方法
	 */
	public void setBusinessType1(String businessType1) {
		this.businessType1 = businessType1;
	}	
	/**
	 * 属性是否需要发起复勘 0 不需要 1 需要/是否需要发起复勘 0 不需要 1 需要的getter方法
	 */
	public String getReCheckFlag() {
		return reCheckFlag;
	}
	/**
	 * 属性是否需要发起复勘 0 不需要 1 需要/是否需要发起复勘 0 不需要 1 需要的setter方法
	 */
	public void setReCheckFlag(String reCheckFlag) {
		this.reCheckFlag = reCheckFlag;
	}	
	/**
	 * 属性补充说明/补充说明的getter方法
	 */
	public String getReCheckRemark() {
		return reCheckRemark;
	}
	/**
	 * 属性补充说明/补充说明的setter方法
	 */
	public void setReCheckRemark(String reCheckRemark) {
		this.reCheckRemark = reCheckRemark;
	}	
}
