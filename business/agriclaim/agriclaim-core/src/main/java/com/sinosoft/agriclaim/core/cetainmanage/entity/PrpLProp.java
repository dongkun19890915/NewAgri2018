package com.sinosoft.agriclaim.core.cetainmanage.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:36:28.690 
 * 财产核定损明细清单表实体操作对象
 */
@Entity
@Table(name = "PrpLProp")
@IdClass(PrpLPropKey.class)
public class PrpLProp extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性序号/序号 */
	@Id
	@Column(name = "serialNo")
	private java.lang.Integer serialNo ;/** 属性报案号/报案号 */
	@Id
	@Column(name = "registNo")
	private String registNo ;/** 属性损失项目类别/损失项目类别 */
	@Id
	@Column(name = "lossItemCode")
	private String lossItemCode ;	
	/** 属性立案号/立案号 */
	@Column(name = "claimNo")
	private String claimNo ;
	/** 属性险种/险种 */
	@Column(name = "riskCode")
	private String riskCode ;
	/** 属性保单号/保单号 */
	@Column(name = "policyNo")
	private String policyNo ;


	/** 属性保单标的子险序号/保单标的子险序号 */
	@Column(name = "itemKindNo")
	private java.lang.Integer itemKindNo ;
	/** 属性分户序号(仅用于集体家财险)/分户序号(仅用于集体家财险) */
	@Column(name = "familyNo")
	private java.lang.Integer familyNo ;
	/** 属性分户名称(仅用于集体家财险)/分户名称(仅用于集体家财险) */
	@Column(name = "familyName")
	private String familyName ;
	/** 属性险别代码/险别代码 */
	@Column(name = "kindCode")
	private String kindCode ;
	/** 属性保单标的项目代码/保单标的项目代码 */
	@Column(name = "itemCode")
	private String itemCode ;

	/** 属性损失项目名称/损失项目名称 */
	@Column(name = "lossItemName")
	private String lossItemName ;
	/** 属性各种费用代码/各种费用代码 */
	@Column(name = "feeTypeCode")
	private String feeTypeCode ;
	/** 属性费用名称/费用名称 */
	@Column(name = "feeTypeName")
	private String feeTypeName ;
	/** 属性币别/币别 */
	@Column(name = "currency")
	private String currency ;
	/** 属性单价/单价 */
	@Column(name = "unitPrice")
	private java.lang.Double unitPrice ;
	/** 属性受损标的数量/受损标的数量 */
	@Column(name = "lossQuantity")
	private java.lang.Double lossQuantity ;
	/** 属性数量单位/数量单位 */
	@Column(name = "unit")
	private String unit ;
	/** 属性购买日期/购买日期 */
	@Column(name = "buyDate")
	private java.util.Date buyDate ;
	/** 属性总折旧率/总折旧率 */
	@Column(name = "depreRate")
	private java.lang.Double depreRate ;
	/** 属性受损金额/受损金额 */
	@Column(name = "sumLoss")
	private java.lang.Double sumLoss ;
	/** 属性剔除金额/剔除金额 */
	@Column(name = "sumReject")
	private java.lang.Double sumReject ;
	/** 属性剔除原因/剔除原因 */
	@Column(name = "rejectReason")
	private String rejectReason ;
	/** 属性赔偿比例/赔偿比例 */
	@Column(name = "lossrate")
	private java.lang.Double lossrate ;
	/** 属性核定损金额/核定损金额 */
	@Column(name = "sumdefLoss")
	private java.lang.Double sumdefLoss ;
	/** 属性备注/备注 */
	@Column(name = "remark")
	private String remark ;
	/** 属性标志字段/标志字段 */
	@Column(name = "flag")
	private String flag ;
	/** 属性单价(核损）/单价(核损） */
	@Column(name = "veriUnitPrice")
	private java.lang.Double veriUnitPrice ;
	/** 属性受损标的数量(核损）/受损标的数量(核损） */
	@Column(name = "veriLossQuantity")
	private java.lang.Double veriLossQuantity ;
	/** 属性数量单位(核损）/数量单位(核损） */
	@Column(name = "veriUnit")
	private String veriUnit ;
	/** 属性总折旧率(核损）/总折旧率(核损） */
	@Column(name = "veriDeprerate")
	private java.lang.Double veriDeprerate ;
	/** 属性受损金额(核损）/受损金额(核损） */
	@Column(name = "veriSumLoss")
	private java.lang.Double veriSumLoss ;
	/** 属性剔除金额(核损）/剔除金额(核损） */
	@Column(name = "veriSumReject")
	private java.lang.Double veriSumReject ;
	/** 属性剔除原因(核损）/剔除原因(核损） */
	@Column(name = "verirejectReason")
	private String verirejectReason ;
	/** 属性赔偿比例(核损）/赔偿比例(核损） */
	@Column(name = "veriLossRate")
	private java.lang.Double veriLossRate ;
	/** 属性核定损金额(核损）/核定损金额(核损） */
	@Column(name = "veriSumdefLoss")
	private java.lang.Double veriSumdefLoss ;
	/** 属性备注(核损）/备注(核损） */
	@Column(name = "verireMark")
	private String verireMark ;
	/** 属性原有换件标记/原有换件标记 */
	@Column(name = "compensateBackFlag")
	private String compensateBackFlag ;
	/** 属性首次上报价/首次上报价 */
	@Column(name = "firstPrice")
	private java.lang.Double firstPrice ;
	/** 属性新增时间/新增时间 */
	@Column(name = "newDate")
	private String newDate ;
	/** 属性未更换/未更换 */
	@Column(name = "disreplace")
	private String disreplace ;
	/** 属性已回收/已回收 */
	@Column(name = "recover")
	private String recover ;
	/** 属性规格型号/规格型号 */
	@Column(name = "modelNo")
	private String modelNo ;
	/** 属性车牌号码/车牌号码 */
	@Column(name = "licenseNo")
	private String licenseNo ;
	/** 属性是否核损通过/是否核损通过 */
	@Column(name = "endFlag")
	private String endFlag ;
	/** 属性是否需要复堪/是否需要复堪 */
	@Column(name = "reviewFlag")
	private String reviewFlag ;
	/** 属性核减金额/核减金额 */
	@Column(name = "veriLoss")
	private java.lang.Double veriLoss ;
	/** 属性复审问题类型/复审问题类型 */
	@Column(name = "problemsType")
	private String problemsType ;
	/** 属性偏差金额/偏差金额 */
	@Column(name = "deviationMoney")
	private java.lang.Double deviationMoney ;
	/** 属性核损复审问题类型/核损复审问题类型 */
	@Column(name = "verifProblemsType")
	private String verifProblemsType ;
	/** 属性核损偏差金额/核损偏差金额 */
	@Column(name = "verifDeviationMoney")
	private java.lang.Double verifDeviationMoney ;
	/** 属性首次上报程度/首次上报程度 */
	@Column(name = "firstQuantity")
	private java.lang.Double firstQuantity ;
	/** 属性首次上报比率/首次上报比率 */
	@Column(name = "firstDepreRate")
	private java.lang.Double firstDepreRate ;
	/** 属性本地价格/本地价格 */
	@Column(name = "localPrice")
	private java.lang.Double localPrice ;
	/** 属性首次上报标志/首次上报标志 */
	@Column(name = "firstFlag")
	private String firstFlag ;
	/** 属性不替换标志/不替换标志 */
	@Column(name = "disreplaceFlag")
	private String disreplaceFlag ;
	/** 属性修改人/修改人 */
	@Column(name = "update_By")
	private String updateBy ;
	/** 属性修改时间/修改时间 */
	@Column(name = "update_Date")
	private java.util.Date updateDate ;
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
	 * 属性报案号/报案号的getter方法
	 */
	public String getRegistNo() {
		return registNo;
	}
	/**
	 * 属性报案号/报案号的setter方法
	 */
	public void setRegistNo(String registNo) {
		this.registNo = registNo;
	} 	
	/**
	 * 属性保单标的子险序号/保单标的子险序号的getter方法
	 */
	public java.lang.Integer getItemKindNo() {
		return itemKindNo;
	}
	/**
	 * 属性保单标的子险序号/保单标的子险序号的setter方法
	 */
	public void setItemKindNo(java.lang.Integer itemKindNo) {
		this.itemKindNo = itemKindNo;
	} 	
	/**
	 * 属性分户序号(仅用于集体家财险)/分户序号(仅用于集体家财险)的getter方法
	 */
	public java.lang.Integer getFamilyNo() {
		return familyNo;
	}
	/**
	 * 属性分户序号(仅用于集体家财险)/分户序号(仅用于集体家财险)的setter方法
	 */
	public void setFamilyNo(java.lang.Integer familyNo) {
		this.familyNo = familyNo;
	} 	
	/**
	 * 属性分户名称(仅用于集体家财险)/分户名称(仅用于集体家财险)的getter方法
	 */
	public String getFamilyName() {
		return familyName;
	}
	/**
	 * 属性分户名称(仅用于集体家财险)/分户名称(仅用于集体家财险)的setter方法
	 */
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
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
	 * 属性损失项目类别/损失项目类别的getter方法
	 */
	public String getLossItemCode() {
		return lossItemCode;
	}
	/**
	 * 属性损失项目类别/损失项目类别的setter方法
	 */
	public void setLossItemCode(String lossItemCode) {
		this.lossItemCode = lossItemCode;
	} 	
	/**
	 * 属性损失项目名称/损失项目名称的getter方法
	 */
	public String getLossItemName() {
		return lossItemName;
	}
	/**
	 * 属性损失项目名称/损失项目名称的setter方法
	 */
	public void setLossItemName(String lossItemName) {
		this.lossItemName = lossItemName;
	} 	
	/**
	 * 属性各种费用代码/各种费用代码的getter方法
	 */
	public String getFeeTypeCode() {
		return feeTypeCode;
	}
	/**
	 * 属性各种费用代码/各种费用代码的setter方法
	 */
	public void setFeeTypeCode(String feeTypeCode) {
		this.feeTypeCode = feeTypeCode;
	} 	
	/**
	 * 属性费用名称/费用名称的getter方法
	 */
	public String getFeeTypeName() {
		return feeTypeName;
	}
	/**
	 * 属性费用名称/费用名称的setter方法
	 */
	public void setFeeTypeName(String feeTypeName) {
		this.feeTypeName = feeTypeName;
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
	 * 属性剔除金额/剔除金额的getter方法
	 */
	public java.lang.Double getSumReject() {
		return sumReject;
	}
	/**
	 * 属性剔除金额/剔除金额的setter方法
	 */
	public void setSumReject(java.lang.Double sumReject) {
		this.sumReject = sumReject;
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
	 * 属性赔偿比例/赔偿比例的getter方法
	 */
	public java.lang.Double getLossrate() {
		return lossrate;
	}
	/**
	 * 属性赔偿比例/赔偿比例的setter方法
	 */
	public void setLossrate(java.lang.Double lossrate) {
		this.lossrate = lossrate;
	} 	
	/**
	 * 属性核定损金额/核定损金额的getter方法
	 */
	public java.lang.Double getSumdefLoss() {
		return sumdefLoss;
	}
	/**
	 * 属性核定损金额/核定损金额的setter方法
	 */
	public void setSumdefLoss(java.lang.Double sumdefLoss) {
		this.sumdefLoss = sumdefLoss;
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
	 * 属性单价(核损）/单价(核损）的getter方法
	 */
	public java.lang.Double getVeriUnitPrice() {
		return veriUnitPrice;
	}
	/**
	 * 属性单价(核损）/单价(核损）的setter方法
	 */
	public void setVeriUnitPrice(java.lang.Double veriUnitPrice) {
		this.veriUnitPrice = veriUnitPrice;
	} 	
	/**
	 * 属性受损标的数量(核损）/受损标的数量(核损）的getter方法
	 */
	public java.lang.Double getVeriLossQuantity() {
		return veriLossQuantity;
	}
	/**
	 * 属性受损标的数量(核损）/受损标的数量(核损）的setter方法
	 */
	public void setVeriLossQuantity(java.lang.Double veriLossQuantity) {
		this.veriLossQuantity = veriLossQuantity;
	} 	
	/**
	 * 属性数量单位(核损）/数量单位(核损）的getter方法
	 */
	public String getVeriUnit() {
		return veriUnit;
	}
	/**
	 * 属性数量单位(核损）/数量单位(核损）的setter方法
	 */
	public void setVeriUnit(String veriUnit) {
		this.veriUnit = veriUnit;
	} 	
	/**
	 * 属性总折旧率(核损）/总折旧率(核损）的getter方法
	 */
	public java.lang.Double getVeriDeprerate() {
		return veriDeprerate;
	}
	/**
	 * 属性总折旧率(核损）/总折旧率(核损）的setter方法
	 */
	public void setVeriDeprerate(java.lang.Double veriDeprerate) {
		this.veriDeprerate = veriDeprerate;
	} 	
	/**
	 * 属性受损金额(核损）/受损金额(核损）的getter方法
	 */
	public java.lang.Double getVeriSumLoss() {
		return veriSumLoss;
	}
	/**
	 * 属性受损金额(核损）/受损金额(核损）的setter方法
	 */
	public void setVeriSumLoss(java.lang.Double veriSumLoss) {
		this.veriSumLoss = veriSumLoss;
	} 	
	/**
	 * 属性剔除金额(核损）/剔除金额(核损）的getter方法
	 */
	public java.lang.Double getVeriSumReject() {
		return veriSumReject;
	}
	/**
	 * 属性剔除金额(核损）/剔除金额(核损）的setter方法
	 */
	public void setVeriSumReject(java.lang.Double veriSumReject) {
		this.veriSumReject = veriSumReject;
	} 	
	/**
	 * 属性剔除原因(核损）/剔除原因(核损）的getter方法
	 */
	public String getVerirejectReason() {
		return verirejectReason;
	}
	/**
	 * 属性剔除原因(核损）/剔除原因(核损）的setter方法
	 */
	public void setVerirejectReason(String verirejectReason) {
		this.verirejectReason = verirejectReason;
	} 	
	/**
	 * 属性赔偿比例(核损）/赔偿比例(核损）的getter方法
	 */
	public java.lang.Double getVeriLossRate() {
		return veriLossRate;
	}
	/**
	 * 属性赔偿比例(核损）/赔偿比例(核损）的setter方法
	 */
	public void setVeriLossRate(java.lang.Double veriLossRate) {
		this.veriLossRate = veriLossRate;
	} 	
	/**
	 * 属性核定损金额(核损）/核定损金额(核损）的getter方法
	 */
	public java.lang.Double getVeriSumdefLoss() {
		return veriSumdefLoss;
	}
	/**
	 * 属性核定损金额(核损）/核定损金额(核损）的setter方法
	 */
	public void setVeriSumdefLoss(java.lang.Double veriSumdefLoss) {
		this.veriSumdefLoss = veriSumdefLoss;
	} 	
	/**
	 * 属性备注(核损）/备注(核损）的getter方法
	 */
	public String getVerireMark() {
		return verireMark;
	}
	/**
	 * 属性备注(核损）/备注(核损）的setter方法
	 */
	public void setVerireMark(String verireMark) {
		this.verireMark = verireMark;
	} 	
	/**
	 * 属性原有换件标记/原有换件标记的getter方法
	 */
	public String getCompensateBackFlag() {
		return compensateBackFlag;
	}
	/**
	 * 属性原有换件标记/原有换件标记的setter方法
	 */
	public void setCompensateBackFlag(String compensateBackFlag) {
		this.compensateBackFlag = compensateBackFlag;
	} 	
	/**
	 * 属性首次上报价/首次上报价的getter方法
	 */
	public java.lang.Double getFirstPrice() {
		return firstPrice;
	}
	/**
	 * 属性首次上报价/首次上报价的setter方法
	 */
	public void setFirstPrice(java.lang.Double firstPrice) {
		this.firstPrice = firstPrice;
	} 	
	/**
	 * 属性新增时间/新增时间的getter方法
	 */
	public String getNewDate() {
		return newDate;
	}
	/**
	 * 属性新增时间/新增时间的setter方法
	 */
	public void setNewDate(String newDate) {
		this.newDate = newDate;
	} 	
	/**
	 * 属性未更换/未更换的getter方法
	 */
	public String getDisreplace() {
		return disreplace;
	}
	/**
	 * 属性未更换/未更换的setter方法
	 */
	public void setDisreplace(String disreplace) {
		this.disreplace = disreplace;
	} 	
	/**
	 * 属性已回收/已回收的getter方法
	 */
	public String getRecover() {
		return recover;
	}
	/**
	 * 属性已回收/已回收的setter方法
	 */
	public void setRecover(String recover) {
		this.recover = recover;
	} 	
	/**
	 * 属性规格型号/规格型号的getter方法
	 */
	public String getModelNo() {
		return modelNo;
	}
	/**
	 * 属性规格型号/规格型号的setter方法
	 */
	public void setModelNo(String modelNo) {
		this.modelNo = modelNo;
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
	 * 属性是否核损通过/是否核损通过的getter方法
	 */
	public String getEndFlag() {
		return endFlag;
	}
	/**
	 * 属性是否核损通过/是否核损通过的setter方法
	 */
	public void setEndFlag(String endFlag) {
		this.endFlag = endFlag;
	} 	
	/**
	 * 属性是否需要复堪/是否需要复堪的getter方法
	 */
	public String getReviewFlag() {
		return reviewFlag;
	}
	/**
	 * 属性是否需要复堪/是否需要复堪的setter方法
	 */
	public void setReviewFlag(String reviewFlag) {
		this.reviewFlag = reviewFlag;
	} 	
	/**
	 * 属性核减金额/核减金额的getter方法
	 */
	public java.lang.Double getVeriLoss() {
		return veriLoss;
	}
	/**
	 * 属性核减金额/核减金额的setter方法
	 */
	public void setVeriLoss(java.lang.Double veriLoss) {
		this.veriLoss = veriLoss;
	} 	
	/**
	 * 属性复审问题类型/复审问题类型的getter方法
	 */
	public String getProblemsType() {
		return problemsType;
	}
	/**
	 * 属性复审问题类型/复审问题类型的setter方法
	 */
	public void setProblemsType(String problemsType) {
		this.problemsType = problemsType;
	} 	
	/**
	 * 属性偏差金额/偏差金额的getter方法
	 */
	public java.lang.Double getDeviationMoney() {
		return deviationMoney;
	}
	/**
	 * 属性偏差金额/偏差金额的setter方法
	 */
	public void setDeviationMoney(java.lang.Double deviationMoney) {
		this.deviationMoney = deviationMoney;
	} 	
	/**
	 * 属性核损复审问题类型/核损复审问题类型的getter方法
	 */
	public String getVerifProblemsType() {
		return verifProblemsType;
	}
	/**
	 * 属性核损复审问题类型/核损复审问题类型的setter方法
	 */
	public void setVerifProblemsType(String verifProblemsType) {
		this.verifProblemsType = verifProblemsType;
	} 	
	/**
	 * 属性核损偏差金额/核损偏差金额的getter方法
	 */
	public java.lang.Double getVerifDeviationMoney() {
		return verifDeviationMoney;
	}
	/**
	 * 属性核损偏差金额/核损偏差金额的setter方法
	 */
	public void setVerifDeviationMoney(java.lang.Double verifDeviationMoney) {
		this.verifDeviationMoney = verifDeviationMoney;
	} 	
	/**
	 * 属性首次上报程度/首次上报程度的getter方法
	 */
	public java.lang.Double getFirstQuantity() {
		return firstQuantity;
	}
	/**
	 * 属性首次上报程度/首次上报程度的setter方法
	 */
	public void setFirstQuantity(java.lang.Double firstQuantity) {
		this.firstQuantity = firstQuantity;
	} 	
	/**
	 * 属性首次上报比率/首次上报比率的getter方法
	 */
	public java.lang.Double getFirstDepreRate() {
		return firstDepreRate;
	}
	/**
	 * 属性首次上报比率/首次上报比率的setter方法
	 */
	public void setFirstDepreRate(java.lang.Double firstDepreRate) {
		this.firstDepreRate = firstDepreRate;
	} 	
	/**
	 * 属性本地价格/本地价格的getter方法
	 */
	public java.lang.Double getLocalPrice() {
		return localPrice;
	}
	/**
	 * 属性本地价格/本地价格的setter方法
	 */
	public void setLocalPrice(java.lang.Double localPrice) {
		this.localPrice = localPrice;
	} 	
	/**
	 * 属性首次上报标志/首次上报标志的getter方法
	 */
	public String getFirstFlag() {
		return firstFlag;
	}
	/**
	 * 属性首次上报标志/首次上报标志的setter方法
	 */
	public void setFirstFlag(String firstFlag) {
		this.firstFlag = firstFlag;
	} 	
	/**
	 * 属性不替换标志/不替换标志的getter方法
	 */
	public String getDisreplaceFlag() {
		return disreplaceFlag;
	}
	/**
	 * 属性不替换标志/不替换标志的setter方法
	 */
	public void setDisreplaceFlag(String disreplaceFlag) {
		this.disreplaceFlag = disreplaceFlag;
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