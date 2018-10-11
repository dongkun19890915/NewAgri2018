package com.sinosoft.agriclaim.api.compensatemanage.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:40:44.225 
 * 赔付标的信息表Api操作对象
 */
public class PrpLLossDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性赔款计算书号/赔款计算书号 */
	private String compensateNo ;		
	/** 属性险种/险种 */
	private String riskCode ;		
	/** 属性保单号/保单号 */
	private String policyNo ;		
	/** 属性赔付标的序号/赔付标的序号 */
	private java.lang.Integer serialNo ;		
	/** 属性保单标的子险序号/保单标的子险序号 */
	private java.lang.Integer itemkindNo ;		
	/** 属性分户序号/分户序号 */
	private java.lang.Integer familyNo ;		
	/** 属性分户名称/分户名称 */
	private String familyName ;		
	/** 属性承保险别代码/承保险别代码 */
	private String kindCode ;		
	/** 属性车牌号码/车牌号码 */
	private String licenseNo ;		
	/** 属性标的项目类别代码/标的项目类别代码 */
	private String itemCode ;		
	/** 属性受损标的名称/受损标的名称 */
	private String lossName ;		
	/** 属性受损标的地址/受损标的地址 */
	private String itemAddress ;		
	/** 属性费用明细类别代码/费用明细类别代码 */
	private String feeTypeCode ;		
	/** 属性费用明细类别/费用明细类别 */
	private String feeTypeName ;		
	/** 属性受损标的数量/受损标的数量 */
	private java.lang.Double lossQuantity ;		
	/** 属性数量单位/数量单位 */
	private String unit ;		
	/** 属性单价/单价 */
	private java.lang.Double unitPrice ;		
	/** 属性购买日期/购买日期 */
	private java.util.Date buyDate ;		
	/** 属性总折旧率/总折旧率 */
	private java.lang.Double depreRate ;		
	/** 属性币别/币别 */
	private String currency ;		
	/** 属性保险金额/保险金额 */
	private java.lang.Double amount ;		
	/** 属性标的价值币别/标的价值币别 */
	private String currency1 ;		
	/** 属性标的价值/标的价值 */
	private java.lang.Double itemValue ;		
	/** 属性受损金额币别/受损金额币别 */
	private String currency2 ;		
	/** 属性受损金额/受损金额 */
	private java.lang.Double sumLoss ;		
	/** 属性剔除金额/残值/损余/剔除金额/残值/损余 */
	private java.lang.Double sumRest ;		
	/** 属性责任比例/责任比例 */
	private java.lang.Double indemnityDutyRate ;		
	/** 属性赔付比例/赔付比例 */
	private java.lang.Double claimRate ;		
	/** 属性免赔额币别/免赔额币别 */
	private String currency3 ;		
	/** 属性免赔率/免赔率 */
	private java.lang.Double deductibleRate ;		
	/** 属性免赔额/免赔额 */
	private java.lang.Double deductible ;		
	/** 属性实赔币别/实赔币别 */
	private String currency4 ;		
	/** 属性实赔金额/实赔金额 */
	private java.lang.Double sumrealPay ;		
	/** 属性标志字段/标志字段 */
	private String flag ;		
	/** 属性剔除原因/剔除原因 */
	private String rejectReason ;		
	/** 属性事故责任免赔率/事故责任免赔率 */
	private java.lang.Double dutyDeductibleRate ;		
	/** 属性驾驶员免赔率/驾驶员免赔率 */
	private java.lang.Double driverDeductibleRate ;		
	/** 属性备注/备注 */
	private String remark ;		
	/** 属性协商赔偿比例/协商赔偿比例 */
	private java.lang.Double arrangeRate ;		
	/** 属性核定赔偿/核定赔偿 */
	private java.lang.Double ratifyPay ;		
	/** 属性总核定赔偿/总核定赔偿 */
	private java.lang.Double sumDefPay ;		
	/** 属性交强险赔款金额/交强险赔款金额 */
	private java.lang.Double cisumRealpay ;		
	/** 属性索赔金额/索赔金额 */
	private java.lang.Double claimedAmount ;		
	/** 属性损失标的序号/损失标的序号 */
	private String lossItemCode ;		
	/** 属性其他方交强险赔偿金额/其他方交强险赔偿金额 */
	private java.lang.Double otherComplRealpay ;		
	/** 属性赔偿金额/赔偿金额 */
	private java.lang.Double sumallRealpay ;		
	/** 属性不计免赔金额/不计免赔金额 */
	private java.lang.Double noDeductibleRealpay ;		
	/** 属性设置区域/设置区域 */
	private java.lang.Double settleArea ;		
	/** 属性损失比率/损失比率 */
	private java.lang.Double lossRate ;		
	/** 属性车辆厂牌型号/车辆厂牌型号 */
	private String brandCode ;		
	/** 属性组合保险分户编号/组合保险分户编号 */
	private String familyNozh ;		
	/** 属性上次理算金额/上次理算金额 */
	private java.lang.Double lastCompFee ;		
	/** 属性首次理算金额/首次理算金额 */
	private java.lang.Double firstCompfee ;		
	/** 属性暂无/暂无 */
	private java.lang.Double coinssumRealPaid ;		
	/** 属性修改人/修改人 */
	private String updateBy ;		
	/** 属性修改时间/修改时间 */
	private java.util.Date updateDate ;		
	/**
	 * 属性赔款计算书号/赔款计算书号的getter方法
	 */
	public String getCompensateNo() {
		return compensateNo;
	}
	/**
	 * 属性赔款计算书号/赔款计算书号的setter方法
	 */
	public void setCompensateNo(String compensateNo) {
		this.compensateNo = compensateNo;
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
	 * 属性赔付标的序号/赔付标的序号的getter方法
	 */
	public java.lang.Integer getSerialNo() {
		return serialNo;
	}
	/**
	 * 属性赔付标的序号/赔付标的序号的setter方法
	 */
	public void setSerialNo(java.lang.Integer serialNo) {
		this.serialNo = serialNo;
	}	
	/**
	 * 属性保单标的子险序号/保单标的子险序号的getter方法
	 */
	public java.lang.Integer getItemkindNo() {
		return itemkindNo;
	}
	/**
	 * 属性保单标的子险序号/保单标的子险序号的setter方法
	 */
	public void setItemkindNo(java.lang.Integer itemkindNo) {
		this.itemkindNo = itemkindNo;
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
	 * 属性承保险别代码/承保险别代码的getter方法
	 */
	public String getKindCode() {
		return kindCode;
	}
	/**
	 * 属性承保险别代码/承保险别代码的setter方法
	 */
	public void setKindCode(String kindCode) {
		this.kindCode = kindCode;
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
	 * 属性标的项目类别代码/标的项目类别代码的getter方法
	 */
	public String getItemCode() {
		return itemCode;
	}
	/**
	 * 属性标的项目类别代码/标的项目类别代码的setter方法
	 */
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}	
	/**
	 * 属性受损标的名称/受损标的名称的getter方法
	 */
	public String getLossName() {
		return lossName;
	}
	/**
	 * 属性受损标的名称/受损标的名称的setter方法
	 */
	public void setLossName(String lossName) {
		this.lossName = lossName;
	}	
	/**
	 * 属性受损标的地址/受损标的地址的getter方法
	 */
	public String getItemAddress() {
		return itemAddress;
	}
	/**
	 * 属性受损标的地址/受损标的地址的setter方法
	 */
	public void setItemAddress(String itemAddress) {
		this.itemAddress = itemAddress;
	}	
	/**
	 * 属性费用明细类别代码/费用明细类别代码的getter方法
	 */
	public String getFeeTypeCode() {
		return feeTypeCode;
	}
	/**
	 * 属性费用明细类别代码/费用明细类别代码的setter方法
	 */
	public void setFeeTypeCode(String feeTypeCode) {
		this.feeTypeCode = feeTypeCode;
	}	
	/**
	 * 属性费用明细类别/费用明细类别的getter方法
	 */
	public String getFeeTypeName() {
		return feeTypeName;
	}
	/**
	 * 属性费用明细类别/费用明细类别的setter方法
	 */
	public void setFeeTypeName(String feeTypeName) {
		this.feeTypeName = feeTypeName;
	}	
	/**
	 * 属性受损标的数量/受损标的数量的getter方法
	 */
	public java.lang.Double getLossQuantity() {
		return lossQuantity;
	}
	/**
	 * 属性受损标的数量/受损标的数量的setter方法
	 */
	public void setLossQuantity(java.lang.Double lossQuantity) {
		this.lossQuantity = lossQuantity;
	}	
	/**
	 * 属性数量单位/数量单位的getter方法
	 */
	public String getUnit() {
		return unit;
	}
	/**
	 * 属性数量单位/数量单位的setter方法
	 */
	public void setUnit(String unit) {
		this.unit = unit;
	}	
	/**
	 * 属性单价/单价的getter方法
	 */
	public java.lang.Double getUnitPrice() {
		return unitPrice;
	}
	/**
	 * 属性单价/单价的setter方法
	 */
	public void setUnitPrice(java.lang.Double unitPrice) {
		this.unitPrice = unitPrice;
	}	
	/**
	 * 属性购买日期/购买日期的getter方法
	 */
	public java.util.Date getBuyDate() {
		return buyDate;
	}
	/**
	 * 属性购买日期/购买日期的setter方法
	 */
	public void setBuyDate(java.util.Date buyDate) {
		this.buyDate = buyDate;
	}	
	/**
	 * 属性总折旧率/总折旧率的getter方法
	 */
	public java.lang.Double getDepreRate() {
		return depreRate;
	}
	/**
	 * 属性总折旧率/总折旧率的setter方法
	 */
	public void setDepreRate(java.lang.Double depreRate) {
		this.depreRate = depreRate;
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
	 * 属性保险金额/保险金额的getter方法
	 */
	public java.lang.Double getAmount() {
		return amount;
	}
	/**
	 * 属性保险金额/保险金额的setter方法
	 */
	public void setAmount(java.lang.Double amount) {
		this.amount = amount;
	}	
	/**
	 * 属性标的价值币别/标的价值币别的getter方法
	 */
	public String getCurrency1() {
		return currency1;
	}
	/**
	 * 属性标的价值币别/标的价值币别的setter方法
	 */
	public void setCurrency1(String currency1) {
		this.currency1 = currency1;
	}	
	/**
	 * 属性标的价值/标的价值的getter方法
	 */
	public java.lang.Double getItemValue() {
		return itemValue;
	}
	/**
	 * 属性标的价值/标的价值的setter方法
	 */
	public void setItemValue(java.lang.Double itemValue) {
		this.itemValue = itemValue;
	}	
	/**
	 * 属性受损金额币别/受损金额币别的getter方法
	 */
	public String getCurrency2() {
		return currency2;
	}
	/**
	 * 属性受损金额币别/受损金额币别的setter方法
	 */
	public void setCurrency2(String currency2) {
		this.currency2 = currency2;
	}	
	/**
	 * 属性受损金额/受损金额的getter方法
	 */
	public java.lang.Double getSumLoss() {
		return sumLoss;
	}
	/**
	 * 属性受损金额/受损金额的setter方法
	 */
	public void setSumLoss(java.lang.Double sumLoss) {
		this.sumLoss = sumLoss;
	}	
	/**
	 * 属性剔除金额/残值/损余/剔除金额/残值/损余的getter方法
	 */
	public java.lang.Double getSumRest() {
		return sumRest;
	}
	/**
	 * 属性剔除金额/残值/损余/剔除金额/残值/损余的setter方法
	 */
	public void setSumRest(java.lang.Double sumRest) {
		this.sumRest = sumRest;
	}	
	/**
	 * 属性责任比例/责任比例的getter方法
	 */
	public java.lang.Double getIndemnityDutyRate() {
		return indemnityDutyRate;
	}
	/**
	 * 属性责任比例/责任比例的setter方法
	 */
	public void setIndemnityDutyRate(java.lang.Double indemnityDutyRate) {
		this.indemnityDutyRate = indemnityDutyRate;
	}	
	/**
	 * 属性赔付比例/赔付比例的getter方法
	 */
	public java.lang.Double getClaimRate() {
		return claimRate;
	}
	/**
	 * 属性赔付比例/赔付比例的setter方法
	 */
	public void setClaimRate(java.lang.Double claimRate) {
		this.claimRate = claimRate;
	}	
	/**
	 * 属性免赔额币别/免赔额币别的getter方法
	 */
	public String getCurrency3() {
		return currency3;
	}
	/**
	 * 属性免赔额币别/免赔额币别的setter方法
	 */
	public void setCurrency3(String currency3) {
		this.currency3 = currency3;
	}	
	/**
	 * 属性免赔率/免赔率的getter方法
	 */
	public java.lang.Double getDeductibleRate() {
		return deductibleRate;
	}
	/**
	 * 属性免赔率/免赔率的setter方法
	 */
	public void setDeductibleRate(java.lang.Double deductibleRate) {
		this.deductibleRate = deductibleRate;
	}	
	/**
	 * 属性免赔额/免赔额的getter方法
	 */
	public java.lang.Double getDeductible() {
		return deductible;
	}
	/**
	 * 属性免赔额/免赔额的setter方法
	 */
	public void setDeductible(java.lang.Double deductible) {
		this.deductible = deductible;
	}	
	/**
	 * 属性实赔币别/实赔币别的getter方法
	 */
	public String getCurrency4() {
		return currency4;
	}
	/**
	 * 属性实赔币别/实赔币别的setter方法
	 */
	public void setCurrency4(String currency4) {
		this.currency4 = currency4;
	}	
	/**
	 * 属性实赔金额/实赔金额的getter方法
	 */
	public java.lang.Double getSumrealPay() {
		return sumrealPay;
	}
	/**
	 * 属性实赔金额/实赔金额的setter方法
	 */
	public void setSumrealPay(java.lang.Double sumrealPay) {
		this.sumrealPay = sumrealPay;
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
	 * 属性剔除原因/剔除原因的getter方法
	 */
	public String getRejectReason() {
		return rejectReason;
	}
	/**
	 * 属性剔除原因/剔除原因的setter方法
	 */
	public void setRejectReason(String rejectReason) {
		this.rejectReason = rejectReason;
	}	
	/**
	 * 属性事故责任免赔率/事故责任免赔率的getter方法
	 */
	public java.lang.Double getDutyDeductibleRate() {
		return dutyDeductibleRate;
	}
	/**
	 * 属性事故责任免赔率/事故责任免赔率的setter方法
	 */
	public void setDutyDeductibleRate(java.lang.Double dutyDeductibleRate) {
		this.dutyDeductibleRate = dutyDeductibleRate;
	}	
	/**
	 * 属性驾驶员免赔率/驾驶员免赔率的getter方法
	 */
	public java.lang.Double getDriverDeductibleRate() {
		return driverDeductibleRate;
	}
	/**
	 * 属性驾驶员免赔率/驾驶员免赔率的setter方法
	 */
	public void setDriverDeductibleRate(java.lang.Double driverDeductibleRate) {
		this.driverDeductibleRate = driverDeductibleRate;
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
	 * 属性协商赔偿比例/协商赔偿比例的getter方法
	 */
	public java.lang.Double getArrangeRate() {
		return arrangeRate;
	}
	/**
	 * 属性协商赔偿比例/协商赔偿比例的setter方法
	 */
	public void setArrangeRate(java.lang.Double arrangeRate) {
		this.arrangeRate = arrangeRate;
	}	
	/**
	 * 属性核定赔偿/核定赔偿的getter方法
	 */
	public java.lang.Double getRatifyPay() {
		return ratifyPay;
	}
	/**
	 * 属性核定赔偿/核定赔偿的setter方法
	 */
	public void setRatifyPay(java.lang.Double ratifyPay) {
		this.ratifyPay = ratifyPay;
	}	
	/**
	 * 属性总核定赔偿/总核定赔偿的getter方法
	 */
	public java.lang.Double getSumDefPay() {
		return sumDefPay;
	}
	/**
	 * 属性总核定赔偿/总核定赔偿的setter方法
	 */
	public void setSumDefPay(java.lang.Double sumDefPay) {
		this.sumDefPay = sumDefPay;
	}	
	/**
	 * 属性交强险赔款金额/交强险赔款金额的getter方法
	 */
	public java.lang.Double getCisumRealpay() {
		return cisumRealpay;
	}
	/**
	 * 属性交强险赔款金额/交强险赔款金额的setter方法
	 */
	public void setCisumRealpay(java.lang.Double cisumRealpay) {
		this.cisumRealpay = cisumRealpay;
	}	
	/**
	 * 属性索赔金额/索赔金额的getter方法
	 */
	public java.lang.Double getClaimedAmount() {
		return claimedAmount;
	}
	/**
	 * 属性索赔金额/索赔金额的setter方法
	 */
	public void setClaimedAmount(java.lang.Double claimedAmount) {
		this.claimedAmount = claimedAmount;
	}	
	/**
	 * 属性损失标的序号/损失标的序号的getter方法
	 */
	public String getLossItemCode() {
		return lossItemCode;
	}
	/**
	 * 属性损失标的序号/损失标的序号的setter方法
	 */
	public void setLossItemCode(String lossItemCode) {
		this.lossItemCode = lossItemCode;
	}	
	/**
	 * 属性其他方交强险赔偿金额/其他方交强险赔偿金额的getter方法
	 */
	public java.lang.Double getOtherComplRealpay() {
		return otherComplRealpay;
	}
	/**
	 * 属性其他方交强险赔偿金额/其他方交强险赔偿金额的setter方法
	 */
	public void setOtherComplRealpay(java.lang.Double otherComplRealpay) {
		this.otherComplRealpay = otherComplRealpay;
	}	
	/**
	 * 属性赔偿金额/赔偿金额的getter方法
	 */
	public java.lang.Double getSumallRealpay() {
		return sumallRealpay;
	}
	/**
	 * 属性赔偿金额/赔偿金额的setter方法
	 */
	public void setSumallRealpay(java.lang.Double sumallRealpay) {
		this.sumallRealpay = sumallRealpay;
	}	
	/**
	 * 属性不计免赔金额/不计免赔金额的getter方法
	 */
	public java.lang.Double getNoDeductibleRealpay() {
		return noDeductibleRealpay;
	}
	/**
	 * 属性不计免赔金额/不计免赔金额的setter方法
	 */
	public void setNoDeductibleRealpay(java.lang.Double noDeductibleRealpay) {
		this.noDeductibleRealpay = noDeductibleRealpay;
	}	
	/**
	 * 属性设置区域/设置区域的getter方法
	 */
	public java.lang.Double getSettleArea() {
		return settleArea;
	}
	/**
	 * 属性设置区域/设置区域的setter方法
	 */
	public void setSettleArea(java.lang.Double settleArea) {
		this.settleArea = settleArea;
	}	
	/**
	 * 属性损失比率/损失比率的getter方法
	 */
	public java.lang.Double getLossRate() {
		return lossRate;
	}
	/**
	 * 属性损失比率/损失比率的setter方法
	 */
	public void setLossRate(java.lang.Double lossRate) {
		this.lossRate = lossRate;
	}	
	/**
	 * 属性车辆厂牌型号/车辆厂牌型号的getter方法
	 */
	public String getBrandCode() {
		return brandCode;
	}
	/**
	 * 属性车辆厂牌型号/车辆厂牌型号的setter方法
	 */
	public void setBrandCode(String brandCode) {
		this.brandCode = brandCode;
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
	 * 属性上次理算金额/上次理算金额的getter方法
	 */
	public java.lang.Double getLastCompFee() {
		return lastCompFee;
	}
	/**
	 * 属性上次理算金额/上次理算金额的setter方法
	 */
	public void setLastCompFee(java.lang.Double lastCompFee) {
		this.lastCompFee = lastCompFee;
	}	
	/**
	 * 属性首次理算金额/首次理算金额的getter方法
	 */
	public java.lang.Double getFirstCompfee() {
		return firstCompfee;
	}
	/**
	 * 属性首次理算金额/首次理算金额的setter方法
	 */
	public void setFirstCompfee(java.lang.Double firstCompfee) {
		this.firstCompfee = firstCompfee;
	}	
	/**
	 * 属性暂无/暂无的getter方法
	 */
	public java.lang.Double getCoinssumRealPaid() {
		return coinssumRealPaid;
	}
	/**
	 * 属性暂无/暂无的setter方法
	 */
	public void setCoinssumRealPaid(java.lang.Double coinssumRealPaid) {
		this.coinssumRealPaid = coinssumRealPaid;
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
}
