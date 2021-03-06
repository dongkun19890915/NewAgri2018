package com.sinosoft.agriclaim.api.compensatemanage.dto;

import com.sinosoft.framework.core.dao.BaseEntityImpl;

import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:40:44.225 
 * 赔付标的信息表实体操作对象
 */
public class PrpLPersonLossDto extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性赔款计算书号/赔款计算书号 */
	private String compensateNo ;/** 属性赔付标的序号/赔付标的序号 */
	private Integer serialNo ;

	/** 属性险种/险种 */
	private String riskCode ;
	/** 属性保单号/保单号 */
	private String policyNo ;

	/** 属性保单标的子险序号/保单标的子险序号 */
	private Integer personNo ;
	/** 属性分户序号/分户序号 */
	private Integer personName ;
	/** 属性分户名称/分户名称 */
	private String identifyNumber ;
	/** 属性承保险别代码/承保险别代码 */
	private String sex ;
	/** 属性车牌号码/车牌号码 */
	private String age ;
	/** 属性标的项目类别代码/标的项目类别代码 */
	private String itemKindNo ;
	/** 属性受损标的名称/受损标的名称 */
	private String familyNo ;
	/** 属性受损标的地址/受损标的地址 */
	private String familyName ;
	/** 属性费用明细类别代码/费用明细类别代码 */
	private String kindCode ;
	/** 属性费用明细类别/费用明细类别 */
	private String liabCode ;
	/** 属性受损标的数量/受损标的数量 */
	private Double liabName ;
	/** 属性数量单位/数量单位 */
	private String jobCode ;
	/** 属性单价/单价 */
	private Double jobName ;
	/** 属性购买日期/购买日期 */
	private Date liabDetailCode ;
	/** 属性总折旧率/总折旧率 */
	private Double liabDetailName ;
	private Double itemAddress ;
	private String lossQuantity ;
	private String unit ;
	private String unitAmount ;
	/** 属性币别/币别 */
	private String currency ;
	/** 属性保险金额/保险金额 */
	private Double amount ;
	/** 属性标的价值币别/标的价值币别 */
	private String currency1 ;
	/** 属性标的价值/标的价值 */
	private Double itemValue ;
	/** 属性受损金额币别/受损金额币别 */
	private String currency2 ;
	/** 属性受损金额/受损金额 */
	private Double sumLoss ;
	/** 属性剔除金额/残值/损余/剔除金额/残值/损余 */
	private Double sumRest ;
	/** 属性责任比例/责任比例 */
	private Double indemnityDutyRate ;
	/** 属性赔付比例/赔付比例 */
	private Double claimRate ;
	/** 属性免赔额币别/免赔额币别 */
	private String currency3 ;
	/** 属性免赔率/免赔率 */
	private Double deductibleRate ;
	/** 属性免赔额/免赔额 */
	private Double deductible ;
	/** 属性实赔币别/实赔币别 */
	private String currency4 ;
	/** 属性实赔金额/实赔金额 */
	private Double sumrealPay ;
	/** 属性标志字段/标志字段 */
	private String flag ;
	/** 属性剔除原因/剔除原因 */
	private String rejectReason ;
	/** 属性事故责任免赔率/事故责任免赔率 */
	private Double dutyDeductibleRate ;
	private Double injuryGrade ;
	private Double injuryScopeDesc ;
	private Double inHospDate ;
	private Double outHospDate ;
	private Double hospitalDays ;
	private Double hospital ;
	/** 属性驾驶员免赔率/驾驶员免赔率 */
	private Double driverDeductibleRate ;
	private Double maxPaid ;
	private Double hisPaid ;
	/** 属性备注/备注 */
	private String remark ;
	/** 属性协商赔偿比例/协商赔偿比例 */
	private Double arrangeRate ;
	/** 属性核定赔偿/核定赔偿 */
	private Double ratifyPay ;
	private Double feeCategory ;
	/** 属性总核定赔偿/总核定赔偿 */
	private Double sumDefPay ;
	/** 属性交强险赔款金额/交强险赔款金额 */
	private Double cisumRealpay ;
	private Double hospitalCode ;
	private Double diseaseCode ;
	/** 属性索赔金额/索赔金额 */
	private Double claimedAmount ;
	/** 属性其他方交强险赔偿金额/其他方交强险赔偿金额 */
	private Double otherComplRealpay ;
	/** 属性赔偿金额/赔偿金额 */
	private Double sumallRealpay ;
	/** 属性不计免赔金额/不计免赔金额 */
	private Double noDeductibleRealpay ;
	/** 属性上次理算金额/上次理算金额 */
	private Double lastCompFee ;
	/** 属性首次理算金额/首次理算金额 */
	private Double firstCompfee ;
	/** 属性修改人/修改人 */
	private String updateBy ;
	/** 属性修改时间/修改时间 */
	private Date updateDate ;

	public String getCompensateNo() {
		return compensateNo;
	}

	public void setCompensateNo(String compensateNo) {
		this.compensateNo = compensateNo;
	}

	public Integer getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(Integer serialNo) {
		this.serialNo = serialNo;
	}

	public String getRiskCode() {
		return riskCode;
	}

	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}

	public String getPolicyNo() {
		return policyNo;
	}

	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}

	public Integer getPersonNo() {
		return personNo;
	}

	public void setPersonNo(Integer personNo) {
		this.personNo = personNo;
	}

	public Integer getPersonName() {
		return personName;
	}

	public void setPersonName(Integer personName) {
		this.personName = personName;
	}

	public String getIdentifyNumber() {
		return identifyNumber;
	}

	public void setIdentifyNumber(String identifyNumber) {
		this.identifyNumber = identifyNumber;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getItemKindNo() {
		return itemKindNo;
	}

	public void setItemKindNo(String itemKindNo) {
		this.itemKindNo = itemKindNo;
	}

	public String getFamilyNo() {
		return familyNo;
	}

	public void setFamilyNo(String familyNo) {
		this.familyNo = familyNo;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public String getKindCode() {
		return kindCode;
	}

	public void setKindCode(String kindCode) {
		this.kindCode = kindCode;
	}

	public String getLiabCode() {
		return liabCode;
	}

	public void setLiabCode(String liabCode) {
		this.liabCode = liabCode;
	}

	public Double getLiabName() {
		return liabName;
	}

	public void setLiabName(Double liabName) {
		this.liabName = liabName;
	}

	public String getJobCode() {
		return jobCode;
	}

	public void setJobCode(String jobCode) {
		this.jobCode = jobCode;
	}

	public Double getJobName() {
		return jobName;
	}

	public void setJobName(Double jobName) {
		this.jobName = jobName;
	}

	public Date getLiabDetailCode() {
		return liabDetailCode;
	}

	public void setLiabDetailCode(Date liabDetailCode) {
		this.liabDetailCode = liabDetailCode;
	}

	public Double getLiabDetailName() {
		return liabDetailName;
	}

	public void setLiabDetailName(Double liabDetailName) {
		this.liabDetailName = liabDetailName;
	}

	public Double getItemAddress() {
		return itemAddress;
	}

	public void setItemAddress(Double itemAddress) {
		this.itemAddress = itemAddress;
	}

	public String getLossQuantity() {
		return lossQuantity;
	}

	public void setLossQuantity(String lossQuantity) {
		this.lossQuantity = lossQuantity;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getUnitAmount() {
		return unitAmount;
	}

	public void setUnitAmount(String unitAmount) {
		this.unitAmount = unitAmount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getCurrency1() {
		return currency1;
	}

	public void setCurrency1(String currency1) {
		this.currency1 = currency1;
	}

	public Double getItemValue() {
		return itemValue;
	}

	public void setItemValue(Double itemValue) {
		this.itemValue = itemValue;
	}

	public String getCurrency2() {
		return currency2;
	}

	public void setCurrency2(String currency2) {
		this.currency2 = currency2;
	}

	public Double getSumLoss() {
		return sumLoss;
	}

	public void setSumLoss(Double sumLoss) {
		this.sumLoss = sumLoss;
	}

	public Double getSumRest() {
		return sumRest;
	}

	public void setSumRest(Double sumRest) {
		this.sumRest = sumRest;
	}

	public Double getIndemnityDutyRate() {
		return indemnityDutyRate;
	}

	public void setIndemnityDutyRate(Double indemnityDutyRate) {
		this.indemnityDutyRate = indemnityDutyRate;
	}

	public Double getClaimRate() {
		return claimRate;
	}

	public void setClaimRate(Double claimRate) {
		this.claimRate = claimRate;
	}

	public String getCurrency3() {
		return currency3;
	}

	public void setCurrency3(String currency3) {
		this.currency3 = currency3;
	}

	public Double getDeductibleRate() {
		return deductibleRate;
	}

	public void setDeductibleRate(Double deductibleRate) {
		this.deductibleRate = deductibleRate;
	}

	public Double getDeductible() {
		return deductible;
	}

	public void setDeductible(Double deductible) {
		this.deductible = deductible;
	}

	public String getCurrency4() {
		return currency4;
	}

	public void setCurrency4(String currency4) {
		this.currency4 = currency4;
	}

	public Double getSumrealPay() {
		return sumrealPay;
	}

	public void setSumrealPay(Double sumrealPay) {
		this.sumrealPay = sumrealPay;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getRejectReason() {
		return rejectReason;
	}

	public void setRejectReason(String rejectReason) {
		this.rejectReason = rejectReason;
	}

	public Double getDutyDeductibleRate() {
		return dutyDeductibleRate;
	}

	public void setDutyDeductibleRate(Double dutyDeductibleRate) {
		this.dutyDeductibleRate = dutyDeductibleRate;
	}

	public Double getInjuryGrade() {
		return injuryGrade;
	}

	public void setInjuryGrade(Double injuryGrade) {
		this.injuryGrade = injuryGrade;
	}

	public Double getInjuryScopeDesc() {
		return injuryScopeDesc;
	}

	public void setInjuryScopeDesc(Double injuryScopeDesc) {
		this.injuryScopeDesc = injuryScopeDesc;
	}

	public Double getInHospDate() {
		return inHospDate;
	}

	public void setInHospDate(Double inHospDate) {
		this.inHospDate = inHospDate;
	}

	public Double getOutHospDate() {
		return outHospDate;
	}

	public void setOutHospDate(Double outHospDate) {
		this.outHospDate = outHospDate;
	}

	public Double getHospitalDays() {
		return hospitalDays;
	}

	public void setHospitalDays(Double hospitalDays) {
		this.hospitalDays = hospitalDays;
	}

	public Double getHospital() {
		return hospital;
	}

	public void setHospital(Double hospital) {
		this.hospital = hospital;
	}

	public Double getDriverDeductibleRate() {
		return driverDeductibleRate;
	}

	public void setDriverDeductibleRate(Double driverDeductibleRate) {
		this.driverDeductibleRate = driverDeductibleRate;
	}

	public Double getMaxPaid() {
		return maxPaid;
	}

	public void setMaxPaid(Double maxPaid) {
		this.maxPaid = maxPaid;
	}

	public Double getHisPaid() {
		return hisPaid;
	}

	public void setHisPaid(Double hisPaid) {
		this.hisPaid = hisPaid;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Double getArrangeRate() {
		return arrangeRate;
	}

	public void setArrangeRate(Double arrangeRate) {
		this.arrangeRate = arrangeRate;
	}

	public Double getRatifyPay() {
		return ratifyPay;
	}

	public void setRatifyPay(Double ratifyPay) {
		this.ratifyPay = ratifyPay;
	}

	public Double getFeeCategory() {
		return feeCategory;
	}

	public void setFeeCategory(Double feeCategory) {
		this.feeCategory = feeCategory;
	}

	public Double getSumDefPay() {
		return sumDefPay;
	}

	public void setSumDefPay(Double sumDefPay) {
		this.sumDefPay = sumDefPay;
	}

	public Double getCisumRealpay() {
		return cisumRealpay;
	}

	public void setCisumRealpay(Double cisumRealpay) {
		this.cisumRealpay = cisumRealpay;
	}

	public Double getHospitalCode() {
		return hospitalCode;
	}

	public void setHospitalCode(Double hospitalCode) {
		this.hospitalCode = hospitalCode;
	}

	public Double getDiseaseCode() {
		return diseaseCode;
	}

	public void setDiseaseCode(Double diseaseCode) {
		this.diseaseCode = diseaseCode;
	}

	public Double getClaimedAmount() {
		return claimedAmount;
	}

	public void setClaimedAmount(Double claimedAmount) {
		this.claimedAmount = claimedAmount;
	}

	public Double getOtherComplRealpay() {
		return otherComplRealpay;
	}

	public void setOtherComplRealpay(Double otherComplRealpay) {
		this.otherComplRealpay = otherComplRealpay;
	}

	public Double getSumallRealpay() {
		return sumallRealpay;
	}

	public void setSumallRealpay(Double sumallRealpay) {
		this.sumallRealpay = sumallRealpay;
	}

	public Double getNoDeductibleRealpay() {
		return noDeductibleRealpay;
	}

	public void setNoDeductibleRealpay(Double noDeductibleRealpay) {
		this.noDeductibleRealpay = noDeductibleRealpay;
	}

	public Double getLastCompFee() {
		return lastCompFee;
	}

	public void setLastCompFee(Double lastCompFee) {
		this.lastCompFee = lastCompFee;
	}

	public Double getFirstCompfee() {
		return firstCompfee;
	}

	public void setFirstCompfee(Double firstCompfee) {
		this.firstCompfee = firstCompfee;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
}