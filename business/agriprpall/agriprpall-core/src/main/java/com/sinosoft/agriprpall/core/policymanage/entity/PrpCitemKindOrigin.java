package com.sinosoft.agriprpall.core.policymanage.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:01:20.710 
 * 原始保单标的子险表实体操作对象
 */
@Entity
@Table(name = "PrpCitemKindOrigin")
@IdClass(PrpCitemKindOriginKey.class)
public class PrpCitemKindOrigin extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性保单号码/保单号码 */
	@Id
	@Column(name = "policyNo")
	private String policyNo ;/** 属性序号/序号 */
	@Id
	@Column(name = "itemKindNo")
	private java.lang.Integer itemKindNo ;	

	/** 属性险种代码 /险种代码  */
	@Column(name = "riskCode")
	private String riskCode ;

	/** 属性分户序号/分户序号 */
	@Column(name = "familyNo")
	private java.lang.Integer familyNo ;
	/** 属性分户名称（集装箱体保险时为集装箱编号）/分户名称（集装箱体保险时为集装箱编号） */
	@Column(name = "familyName")
	private String familyName ;
	/** 属性rationType/rationType */
	@Column(name = "rationType")
	private String rationType ;
	/** 属性险别代码 /险别代码  */
	@Column(name = "kindCode")
	private String kindCode ;
	/** 属性险别名称/险别名称 */
	@Column(name = "kindName")
	private String kindName ;
	/** 属性标的序号       /标的序号        */
	@Column(name = "itemNo")
	private java.lang.Integer itemNo ;
	/** 属性标的项目类别代码 /标的项目类别代码  */
	@Column(name = "itemCode")
	private String itemCode ;
	/** 属性标的项目明细名称/标的项目明细名称 */
	@Column(name = "itemDetailName")
	private String itemDetailName ;
	/** 属性投保方式代码/投保方式代码 */
	@Column(name = "modeCode")
	private String modeCode ;
	/** 属性投保方式名称/投保方式名称 */
	@Column(name = "modeName")
	private String modeName ;
	/** 属性起保日期/起保日期 */
	@Column(name = "startDate")
	private java.util.Date startDate ;
	/** 属性起保小时/起保小时 */
	@Column(name = "startHour")
	private java.lang.Integer startHour ;
	/** 属性终保日起/终保日起 */
	@Column(name = "endDate")
	private java.util.Date endDate ;
	/** 属性终报小时/终报小时 */
	@Column(name = "endHour")
	private java.lang.Integer endHour ;
	/** 属性规格型号/规格型号 */
	@Column(name = "model")
	private String model ;
	/** 属性购买日起/购买日起 */
	@Column(name = "buyDate")
	private java.util.Date buyDate ;
	/** 属性地址序号/地址序号 */
	@Column(name = "addressNo")
	private java.lang.Integer addressNo ;
	/** 属性是否计算保额标志(Y/N)/是否计算保额标志(Y/N) */
	@Column(name = "calculateFlag")
	private String calculateFlag ;
	/** 属性币别 /币别  */
	@Column(name = "currency")
	private String currency ;
	/** 属性单位保险金额/单位保险金额 */
	@Column(name = "unitAmount")
	private java.lang.Double unitAmount ;
	/** 属性数量/数量 */
	@Column(name = "quantity")
	private java.lang.Double quantity ;
	/** 属性数量单位/数量单位 */
	@Column(name = "unit")
	private String unit ;
	/** 属性保险价值/保险价值 */
	@Column(name = "value")
	private java.lang.Double value ;
	/** 属性保险金额/保险金额 */
	@Column(name = "amount")
	private java.lang.Double amount ;
	/** 属性适应费率期数/适应费率期数 */
	@Column(name = "ratePeriod")
	private java.lang.Integer ratePeriod ;
	/** 属性费率/费率 */
	@Column(name = "rate")
	private java.lang.Double rate ;
	/** 属性短期费率标志(1.月比例/2.日比例)/短期费率标志(1.月比例/2.日比例) */
	@Column(name = "shortRateFlag")
	private String shortRateFlag ;
	/** 属性短期费率       /短期费率        */
	@Column(name = "shortRate")
	private java.lang.Double shortRate ;
	/** 属性基准保费/基准保费 */
	@Column(name = "basePremium")
	private java.lang.Double basePremium ;
	/** 属性标准保费/标准保费 */
	@Column(name = "benchmarkPremium")
	private java.lang.Double benchmarkPremium ;
	/** 属性折扣率/折扣率 */
	@Column(name = "discount")
	private java.lang.Double discount ;
	/** 属性保费调整比率(%)/保费调整比率(%) */
	@Column(name = "adjustRate")
	private java.lang.Double adjustRate ;
	/** 属性保费/储金/保费/储金 */
	@Column(name = "premium")
	private java.lang.Double premium ;
	/** 属性免赔率/免赔率 */
	@Column(name = "deductibleRate")
	private java.lang.Double deductibleRate ;
	/** 属性免赔额/免赔额 */
	@Column(name = "deductible")
	private java.lang.Double deductible ;
	/** 属性标志字段/标志字段 */
	@Column(name = "flag")
	private String flag ;
	/** 属性地区费率因子: 0-不浮动, 1-上浮30%/地区费率因子: 0-不浮动, 1-上浮30% */
	@Column(name = "regionRate")
	private String regionRate ;
	/** 属性饮酒费率因子：饮酒驾驶违法次数/饮酒费率因子：饮酒驾驶违法次数 */
	@Column(name = "drinkRate")
	private java.lang.Integer drinkRate ;
	/** 属性醉酒费率因子：醉酒驾驶违法次数/醉酒费率因子：醉酒驾驶违法次数 */
	@Column(name = "drunkRate")
	private java.lang.Integer drunkRate ;
	/** 属性肉牛类型（3221肉牛险专用0122附加险借用0123附加险借用:玻璃类型）/肉牛类型（3221肉牛险专用0122附加险借用0123附加险借用:玻璃类型） */
	@Column(name = "cattleType")
	private String cattleType ;
	/** 属性每次事故每人赔偿限额 0122,0123附加险用到/每次事故每人赔偿限额 0122,0123附加险用到 */
	@Column(name = "unitPersonLimitAmount")
	private java.lang.Double unitPersonLimitAmount ;
	/** 属性每人赔偿限额0123用到/每人赔偿限额0123用到 */
	@Column(name = "unitPersonAmount")
	private java.lang.Double unitPersonAmount ;
	/** 属性日额：每人日额（元）2714,0123用/日额：每人日额（元）2714,0123用 */
	@Column(name = "unitDayAmountSub")
	private java.lang.Double unitDayAmountSub ;
	/** 属性天数：2714附加险专用0123附加险借用/天数：2714附加险专用0123附加险借用 */
	@Column(name = "daySub")
	private java.lang.Integer daySub ;
	/** 属性人员类别2606险种用到/人员类别2606险种用到 */
	@Column(name = "personType")
	private String personType ;
	/** 属性起赔点/起赔点 */
	@Column(name = "triggerPoint")
	private java.lang.Double triggerPoint ;
	/** 属性全损损失率/全损损失率 */
	@Column(name = "totalLossRatio")
	private java.lang.Double totalLossRatio ;
	/** 属性诉讼费限额/诉讼费限额 */
	@Column(name = "lawsuitAmount")
	private java.lang.Double lawsuitAmount ;
	/** 属性病床数/病床数 */
	@Column(name = "bedNum")
	private java.lang.Integer bedNum ;
	/** 属性每张床位保险费/每张床位保险费 */
	@Column(name = "bedPremium")
	private java.lang.Double bedPremium ;
	/** 属性医疗机构保费/医疗机构保费 */
	@Column(name = "hospitalPremium")
	private java.lang.Double hospitalPremium ;
	/** 属性各类医务人员人数/各类医务人员人数 */
	@Column(name = "kindWorkerNum")
	private java.lang.Integer kindWorkerNum ;
	/** 属性各类医务人员每人保费/各类医务人员每人保费 */
	@Column(name = "kindWorkerPremium")
	private java.lang.Double kindWorkerPremium ;
	/** 属性临床手术科室医师人数/临床手术科室医师人数 */
	@Column(name = "clinicNum")
	private java.lang.Integer clinicNum ;
	/** 属性临床手术科室医师每人保费/临床手术科室医师每人保费 */
	@Column(name = "clinicPremium")
	private java.lang.Double clinicPremium ;
	/** 属性临床非手术科室医师人数/临床非手术科室医师人数 */
	@Column(name = "nClinicNum")
	private java.lang.Integer nClinicNum ;
	/** 属性临床非手术科室医师每人保费/临床非手术科室医师每人保费 */
	@Column(name = "nClinicPremium")
	private java.lang.Double nClinicPremium ;
	/** 属性医技科室人数/医技科室人数 */
	@Column(name = "roomNum")
	private java.lang.Integer roomNum ;
	/** 属性医技科室每人保费/医技科室每人保费 */
	@Column(name = "roomPremium")
	private java.lang.Double roomPremium ;
	/** 属性护士人数/护士人数 */
	@Column(name = "nurseNum")
	private java.lang.Integer nurseNum ;
	/** 属性护士每人保费/护士每人保费 */
	@Column(name = "nursePremium")
	private java.lang.Double nursePremium ;
	/** 属性医务人员保费/医务人员保费 */
	@Column(name = "workerPremium")
	private java.lang.Double workerPremium ;
	/** 属性医务人员人数/医务人员人数 */
	@Column(name = "workerNum")
	private java.lang.Integer workerNum ;
	/** 属性unitPremium/unitPremium */
	@Column(name = "unitPremium")
	private java.lang.Double unitPremium ;
	/** 属性住院病人手术人次/住院病人手术人次 */
	@Column(name = "operationNum")
	private java.lang.Integer operationNum ;
	/** 属性住院病人手术人次基准保险费/住院病人手术人次基准保险费 */
	@Column(name = "operationPremium")
	private java.lang.Double operationPremium ;
	/** 属性医疗机构类别系数/医疗机构类别系数 */
	@Column(name = "medicalRate")
	private java.lang.Double medicalRate ;
	/** 属性岗位系数/岗位系数 */
	@Column(name = "postRate")
	private java.lang.Double postRate ;
	/** 属性currency3/currency3 */
	@Column(name = "currency2")
	private String currency2 ;
	/** 属性exChangeRate3/exChangeRate3 */
	@Column(name = "exchangeRate2")
	private java.lang.Double exchangeRate2 ;
	/** 属性exChangeRateCny/exChangeRateCny */
	@Column(name = "exchangeRateCNY")
	private java.lang.Double exchangeRateCNY ;
	/** 属性insuredValueType/insuredValueType */
	@Column(name = "insuredValueType")
	private String insuredValueType ;
	/** 属性insuredValueTypeName/insuredValueTypeName */
	@Column(name = "insuredValueTypeName")
	private String insuredValueTypeName ;
	/** 属性newEndDate/newEndDate */
	@Column(name = "newEndDate")
	private java.util.Date newEndDate ;
	/** 属性newStartDate/newStartDate */
	@Column(name = "newStartDate")
	private java.util.Date newStartDate ;
	/** 属性premium3/premium3 */
	@Column(name = "premium2")
	private java.lang.Double premium2 ;
	/** 属性premiumCny/premiumCny */
	@Column(name = "premiumCNY")
	private java.lang.Double premiumCNY ;
	/** 属性修改人/修改人 */
	@Column(name = "update_By")
	private String updateBy ;
	/** 属性修改时间/修改时间 */
	@Column(name = "update_Date")
	private java.util.Date updateDate ;
	/** 属性不含税保费/不含税保费 */
	@Column(name = "noTaxPremium")
	private java.lang.Double noTaxPremium ;
	/** 属性应/免税标识，1-应税，2-免税/应/免税标识，1-应税，2-免税 */
	@Column(name = "taxFlag")
	private String taxFlag ;
	/** 属性税率/税率 */
	@Column(name = "taxRate")
	private java.lang.Double taxRate ;
	/** 属性税额/税额 */
	@Column(name = "taxFee")
	private java.lang.Double taxFee ;
	/** 属性保费计算方式/保费计算方式 */
	@Column(name = "premiumCalMethod")
	private String premiumCalMethod ;
	/** 属性林木用途/林木用途 */
	@Column(name = "forestUse")
	private String forestUse ;
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
	 * 属性险种代码 /险种代码 的getter方法
	 */
	public String getRiskCode() {
		return riskCode;
	}
	/**
	 * 属性险种代码 /险种代码 的setter方法
	 */
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	} 	
	/**
	 * 属性序号/序号的getter方法
	 */
	public java.lang.Integer getItemKindNo() {
		return itemKindNo;
	}
	/**
	 * 属性序号/序号的setter方法
	 */
	public void setItemKindNo(java.lang.Integer itemKindNo) {
		this.itemKindNo = itemKindNo;
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
	 * 属性分户名称（集装箱体保险时为集装箱编号）/分户名称（集装箱体保险时为集装箱编号）的getter方法
	 */
	public String getFamilyName() {
		return familyName;
	}
	/**
	 * 属性分户名称（集装箱体保险时为集装箱编号）/分户名称（集装箱体保险时为集装箱编号）的setter方法
	 */
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	} 	
	/**
	 * 属性rationType/rationType的getter方法
	 */
	public String getRationType() {
		return rationType;
	}
	/**
	 * 属性rationType/rationType的setter方法
	 */
	public void setRationType(String rationType) {
		this.rationType = rationType;
	} 	
	/**
	 * 属性险别代码 /险别代码 的getter方法
	 */
	public String getKindCode() {
		return kindCode;
	}
	/**
	 * 属性险别代码 /险别代码 的setter方法
	 */
	public void setKindCode(String kindCode) {
		this.kindCode = kindCode;
	} 	
	/**
	 * 属性险别名称/险别名称的getter方法
	 */
	public String getKindName() {
		return kindName;
	}
	/**
	 * 属性险别名称/险别名称的setter方法
	 */
	public void setKindName(String kindName) {
		this.kindName = kindName;
	} 	
	/**
	 * 属性标的序号       /标的序号       的getter方法
	 */
	public java.lang.Integer getItemNo() {
		return itemNo;
	}
	/**
	 * 属性标的序号       /标的序号       的setter方法
	 */
	public void setItemNo(java.lang.Integer itemNo) {
		this.itemNo = itemNo;
	} 	
	/**
	 * 属性标的项目类别代码 /标的项目类别代码 的getter方法
	 */
	public String getItemCode() {
		return itemCode;
	}
	/**
	 * 属性标的项目类别代码 /标的项目类别代码 的setter方法
	 */
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
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
	 * 属性投保方式代码/投保方式代码的getter方法
	 */
	public String getModeCode() {
		return modeCode;
	}
	/**
	 * 属性投保方式代码/投保方式代码的setter方法
	 */
	public void setModeCode(String modeCode) {
		this.modeCode = modeCode;
	} 	
	/**
	 * 属性投保方式名称/投保方式名称的getter方法
	 */
	public String getModeName() {
		return modeName;
	}
	/**
	 * 属性投保方式名称/投保方式名称的setter方法
	 */
	public void setModeName(String modeName) {
		this.modeName = modeName;
	} 	
	/**
	 * 属性起保日期/起保日期的getter方法
	 */
	public java.util.Date getStartDate() {
		return startDate;
	}
	/**
	 * 属性起保日期/起保日期的setter方法
	 */
	public void setStartDate(java.util.Date startDate) {
		this.startDate = startDate;
	} 	
	/**
	 * 属性起保小时/起保小时的getter方法
	 */
	public java.lang.Integer getStartHour() {
		return startHour;
	}
	/**
	 * 属性起保小时/起保小时的setter方法
	 */
	public void setStartHour(java.lang.Integer startHour) {
		this.startHour = startHour;
	} 	
	/**
	 * 属性终保日起/终保日起的getter方法
	 */
	public java.util.Date getEndDate() {
		return endDate;
	}
	/**
	 * 属性终保日起/终保日起的setter方法
	 */
	public void setEndDate(java.util.Date endDate) {
		this.endDate = endDate;
	} 	
	/**
	 * 属性终报小时/终报小时的getter方法
	 */
	public java.lang.Integer getEndHour() {
		return endHour;
	}
	/**
	 * 属性终报小时/终报小时的setter方法
	 */
	public void setEndHour(java.lang.Integer endHour) {
		this.endHour = endHour;
	} 	
	/**
	 * 属性规格型号/规格型号的getter方法
	 */
	public String getModel() {
		return model;
	}
	/**
	 * 属性规格型号/规格型号的setter方法
	 */
	public void setModel(String model) {
		this.model = model;
	} 	
	/**
	 * 属性购买日起/购买日起的getter方法
	 */
	public java.util.Date getBuyDate() {
		return buyDate;
	}
	/**
	 * 属性购买日起/购买日起的setter方法
	 */
	public void setBuyDate(java.util.Date buyDate) {
		this.buyDate = buyDate;
	} 	
	/**
	 * 属性地址序号/地址序号的getter方法
	 */
	public java.lang.Integer getAddressNo() {
		return addressNo;
	}
	/**
	 * 属性地址序号/地址序号的setter方法
	 */
	public void setAddressNo(java.lang.Integer addressNo) {
		this.addressNo = addressNo;
	} 	
	/**
	 * 属性是否计算保额标志(Y/N)/是否计算保额标志(Y/N)的getter方法
	 */
	public String getCalculateFlag() {
		return calculateFlag;
	}
	/**
	 * 属性是否计算保额标志(Y/N)/是否计算保额标志(Y/N)的setter方法
	 */
	public void setCalculateFlag(String calculateFlag) {
		this.calculateFlag = calculateFlag;
	} 	
	/**
	 * 属性币别 /币别 的getter方法
	 */
	public String getCurrency() {
		return currency;
	}
	/**
	 * 属性币别 /币别 的setter方法
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	} 	
	/**
	 * 属性单位保险金额/单位保险金额的getter方法
	 */
	public java.lang.Double getUnitAmount() {
		return unitAmount;
	}
	/**
	 * 属性单位保险金额/单位保险金额的setter方法
	 */
	public void setUnitAmount(java.lang.Double unitAmount) {
		this.unitAmount = unitAmount;
	} 	
	/**
	 * 属性数量/数量的getter方法
	 */
	public java.lang.Double getQuantity() {
		return quantity;
	}
	/**
	 * 属性数量/数量的setter方法
	 */
	public void setQuantity(java.lang.Double quantity) {
		this.quantity = quantity;
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
	 * 属性保险价值/保险价值的getter方法
	 */
	public java.lang.Double getValue() {
		return value;
	}
	/**
	 * 属性保险价值/保险价值的setter方法
	 */
	public void setValue(java.lang.Double value) {
		this.value = value;
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
	 * 属性适应费率期数/适应费率期数的getter方法
	 */
	public java.lang.Integer getRatePeriod() {
		return ratePeriod;
	}
	/**
	 * 属性适应费率期数/适应费率期数的setter方法
	 */
	public void setRatePeriod(java.lang.Integer ratePeriod) {
		this.ratePeriod = ratePeriod;
	} 	
	/**
	 * 属性费率/费率的getter方法
	 */
	public java.lang.Double getRate() {
		return rate;
	}
	/**
	 * 属性费率/费率的setter方法
	 */
	public void setRate(java.lang.Double rate) {
		this.rate = rate;
	} 	
	/**
	 * 属性短期费率标志(1.月比例/2.日比例)/短期费率标志(1.月比例/2.日比例)的getter方法
	 */
	public String getShortRateFlag() {
		return shortRateFlag;
	}
	/**
	 * 属性短期费率标志(1.月比例/2.日比例)/短期费率标志(1.月比例/2.日比例)的setter方法
	 */
	public void setShortRateFlag(String shortRateFlag) {
		this.shortRateFlag = shortRateFlag;
	} 	
	/**
	 * 属性短期费率       /短期费率       的getter方法
	 */
	public java.lang.Double getShortRate() {
		return shortRate;
	}
	/**
	 * 属性短期费率       /短期费率       的setter方法
	 */
	public void setShortRate(java.lang.Double shortRate) {
		this.shortRate = shortRate;
	} 	
	/**
	 * 属性基准保费/基准保费的getter方法
	 */
	public java.lang.Double getBasePremium() {
		return basePremium;
	}
	/**
	 * 属性基准保费/基准保费的setter方法
	 */
	public void setBasePremium(java.lang.Double basePremium) {
		this.basePremium = basePremium;
	} 	
	/**
	 * 属性标准保费/标准保费的getter方法
	 */
	public java.lang.Double getBenchmarkPremium() {
		return benchmarkPremium;
	}
	/**
	 * 属性标准保费/标准保费的setter方法
	 */
	public void setBenchmarkPremium(java.lang.Double benchmarkPremium) {
		this.benchmarkPremium = benchmarkPremium;
	} 	
	/**
	 * 属性折扣率/折扣率的getter方法
	 */
	public java.lang.Double getDiscount() {
		return discount;
	}
	/**
	 * 属性折扣率/折扣率的setter方法
	 */
	public void setDiscount(java.lang.Double discount) {
		this.discount = discount;
	} 	
	/**
	 * 属性保费调整比率(%)/保费调整比率(%)的getter方法
	 */
	public java.lang.Double getAdjustRate() {
		return adjustRate;
	}
	/**
	 * 属性保费调整比率(%)/保费调整比率(%)的setter方法
	 */
	public void setAdjustRate(java.lang.Double adjustRate) {
		this.adjustRate = adjustRate;
	} 	
	/**
	 * 属性保费/储金/保费/储金的getter方法
	 */
	public java.lang.Double getPremium() {
		return premium;
	}
	/**
	 * 属性保费/储金/保费/储金的setter方法
	 */
	public void setPremium(java.lang.Double premium) {
		this.premium = premium;
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
	 * 属性地区费率因子: 0-不浮动, 1-上浮30%/地区费率因子: 0-不浮动, 1-上浮30%的getter方法
	 */
	public String getRegionRate() {
		return regionRate;
	}
	/**
	 * 属性地区费率因子: 0-不浮动, 1-上浮30%/地区费率因子: 0-不浮动, 1-上浮30%的setter方法
	 */
	public void setRegionRate(String regionRate) {
		this.regionRate = regionRate;
	} 	
	/**
	 * 属性饮酒费率因子：饮酒驾驶违法次数/饮酒费率因子：饮酒驾驶违法次数的getter方法
	 */
	public java.lang.Integer getDrinkRate() {
		return drinkRate;
	}
	/**
	 * 属性饮酒费率因子：饮酒驾驶违法次数/饮酒费率因子：饮酒驾驶违法次数的setter方法
	 */
	public void setDrinkRate(java.lang.Integer drinkRate) {
		this.drinkRate = drinkRate;
	} 	
	/**
	 * 属性醉酒费率因子：醉酒驾驶违法次数/醉酒费率因子：醉酒驾驶违法次数的getter方法
	 */
	public java.lang.Integer getDrunkRate() {
		return drunkRate;
	}
	/**
	 * 属性醉酒费率因子：醉酒驾驶违法次数/醉酒费率因子：醉酒驾驶违法次数的setter方法
	 */
	public void setDrunkRate(java.lang.Integer drunkRate) {
		this.drunkRate = drunkRate;
	} 	
	/**
	 * 属性肉牛类型（3221肉牛险专用0122附加险借用0123附加险借用:玻璃类型）/肉牛类型（3221肉牛险专用0122附加险借用0123附加险借用:玻璃类型）的getter方法
	 */
	public String getCattleType() {
		return cattleType;
	}
	/**
	 * 属性肉牛类型（3221肉牛险专用0122附加险借用0123附加险借用:玻璃类型）/肉牛类型（3221肉牛险专用0122附加险借用0123附加险借用:玻璃类型）的setter方法
	 */
	public void setCattleType(String cattleType) {
		this.cattleType = cattleType;
	} 	
	/**
	 * 属性每次事故每人赔偿限额 0122,0123附加险用到/每次事故每人赔偿限额 0122,0123附加险用到的getter方法
	 */
	public java.lang.Double getUnitPersonLimitAmount() {
		return unitPersonLimitAmount;
	}
	/**
	 * 属性每次事故每人赔偿限额 0122,0123附加险用到/每次事故每人赔偿限额 0122,0123附加险用到的setter方法
	 */
	public void setUnitPersonLimitAmount(java.lang.Double unitPersonLimitAmount) {
		this.unitPersonLimitAmount = unitPersonLimitAmount;
	} 	
	/**
	 * 属性每人赔偿限额0123用到/每人赔偿限额0123用到的getter方法
	 */
	public java.lang.Double getUnitPersonAmount() {
		return unitPersonAmount;
	}
	/**
	 * 属性每人赔偿限额0123用到/每人赔偿限额0123用到的setter方法
	 */
	public void setUnitPersonAmount(java.lang.Double unitPersonAmount) {
		this.unitPersonAmount = unitPersonAmount;
	} 	
	/**
	 * 属性日额：每人日额（元）2714,0123用/日额：每人日额（元）2714,0123用的getter方法
	 */
	public java.lang.Double getUnitDayAmountSub() {
		return unitDayAmountSub;
	}
	/**
	 * 属性日额：每人日额（元）2714,0123用/日额：每人日额（元）2714,0123用的setter方法
	 */
	public void setUnitDayAmountSub(java.lang.Double unitDayAmountSub) {
		this.unitDayAmountSub = unitDayAmountSub;
	} 	
	/**
	 * 属性天数：2714附加险专用0123附加险借用/天数：2714附加险专用0123附加险借用的getter方法
	 */
	public java.lang.Integer getDaySub() {
		return daySub;
	}
	/**
	 * 属性天数：2714附加险专用0123附加险借用/天数：2714附加险专用0123附加险借用的setter方法
	 */
	public void setDaySub(java.lang.Integer daySub) {
		this.daySub = daySub;
	} 	
	/**
	 * 属性人员类别2606险种用到/人员类别2606险种用到的getter方法
	 */
	public String getPersonType() {
		return personType;
	}
	/**
	 * 属性人员类别2606险种用到/人员类别2606险种用到的setter方法
	 */
	public void setPersonType(String personType) {
		this.personType = personType;
	} 	
	/**
	 * 属性起赔点/起赔点的getter方法
	 */
	public java.lang.Double getTriggerPoint() {
		return triggerPoint;
	}
	/**
	 * 属性起赔点/起赔点的setter方法
	 */
	public void setTriggerPoint(java.lang.Double triggerPoint) {
		this.triggerPoint = triggerPoint;
	} 	
	/**
	 * 属性全损损失率/全损损失率的getter方法
	 */
	public java.lang.Double getTotalLossRatio() {
		return totalLossRatio;
	}
	/**
	 * 属性全损损失率/全损损失率的setter方法
	 */
	public void setTotalLossRatio(java.lang.Double totalLossRatio) {
		this.totalLossRatio = totalLossRatio;
	} 	
	/**
	 * 属性诉讼费限额/诉讼费限额的getter方法
	 */
	public java.lang.Double getLawsuitAmount() {
		return lawsuitAmount;
	}
	/**
	 * 属性诉讼费限额/诉讼费限额的setter方法
	 */
	public void setLawsuitAmount(java.lang.Double lawsuitAmount) {
		this.lawsuitAmount = lawsuitAmount;
	} 	
	/**
	 * 属性病床数/病床数的getter方法
	 */
	public java.lang.Integer getBedNum() {
		return bedNum;
	}
	/**
	 * 属性病床数/病床数的setter方法
	 */
	public void setBedNum(java.lang.Integer bedNum) {
		this.bedNum = bedNum;
	} 	
	/**
	 * 属性每张床位保险费/每张床位保险费的getter方法
	 */
	public java.lang.Double getBedPremium() {
		return bedPremium;
	}
	/**
	 * 属性每张床位保险费/每张床位保险费的setter方法
	 */
	public void setBedPremium(java.lang.Double bedPremium) {
		this.bedPremium = bedPremium;
	} 	
	/**
	 * 属性医疗机构保费/医疗机构保费的getter方法
	 */
	public java.lang.Double getHospitalPremium() {
		return hospitalPremium;
	}
	/**
	 * 属性医疗机构保费/医疗机构保费的setter方法
	 */
	public void setHospitalPremium(java.lang.Double hospitalPremium) {
		this.hospitalPremium = hospitalPremium;
	} 	
	/**
	 * 属性各类医务人员人数/各类医务人员人数的getter方法
	 */
	public java.lang.Integer getKindWorkerNum() {
		return kindWorkerNum;
	}
	/**
	 * 属性各类医务人员人数/各类医务人员人数的setter方法
	 */
	public void setKindWorkerNum(java.lang.Integer kindWorkerNum) {
		this.kindWorkerNum = kindWorkerNum;
	} 	
	/**
	 * 属性各类医务人员每人保费/各类医务人员每人保费的getter方法
	 */
	public java.lang.Double getKindWorkerPremium() {
		return kindWorkerPremium;
	}
	/**
	 * 属性各类医务人员每人保费/各类医务人员每人保费的setter方法
	 */
	public void setKindWorkerPremium(java.lang.Double kindWorkerPremium) {
		this.kindWorkerPremium = kindWorkerPremium;
	} 	
	/**
	 * 属性临床手术科室医师人数/临床手术科室医师人数的getter方法
	 */
	public java.lang.Integer getClinicNum() {
		return clinicNum;
	}
	/**
	 * 属性临床手术科室医师人数/临床手术科室医师人数的setter方法
	 */
	public void setClinicNum(java.lang.Integer clinicNum) {
		this.clinicNum = clinicNum;
	} 	
	/**
	 * 属性临床手术科室医师每人保费/临床手术科室医师每人保费的getter方法
	 */
	public java.lang.Double getClinicPremium() {
		return clinicPremium;
	}
	/**
	 * 属性临床手术科室医师每人保费/临床手术科室医师每人保费的setter方法
	 */
	public void setClinicPremium(java.lang.Double clinicPremium) {
		this.clinicPremium = clinicPremium;
	} 	
	/**
	 * 属性临床非手术科室医师人数/临床非手术科室医师人数的getter方法
	 */
	public java.lang.Integer getNClinicNum() {
		return nClinicNum;
	}
	/**
	 * 属性临床非手术科室医师人数/临床非手术科室医师人数的setter方法
	 */
	public void setNClinicNum(java.lang.Integer nClinicNum) {
		this.nClinicNum = nClinicNum;
	} 	
	/**
	 * 属性临床非手术科室医师每人保费/临床非手术科室医师每人保费的getter方法
	 */
	public java.lang.Double getNClinicPremium() {
		return nClinicPremium;
	}
	/**
	 * 属性临床非手术科室医师每人保费/临床非手术科室医师每人保费的setter方法
	 */
	public void setNClinicPremium(java.lang.Double nClinicPremium) {
		this.nClinicPremium = nClinicPremium;
	} 	
	/**
	 * 属性医技科室人数/医技科室人数的getter方法
	 */
	public java.lang.Integer getRoomNum() {
		return roomNum;
	}
	/**
	 * 属性医技科室人数/医技科室人数的setter方法
	 */
	public void setRoomNum(java.lang.Integer roomNum) {
		this.roomNum = roomNum;
	} 	
	/**
	 * 属性医技科室每人保费/医技科室每人保费的getter方法
	 */
	public java.lang.Double getRoomPremium() {
		return roomPremium;
	}
	/**
	 * 属性医技科室每人保费/医技科室每人保费的setter方法
	 */
	public void setRoomPremium(java.lang.Double roomPremium) {
		this.roomPremium = roomPremium;
	} 	
	/**
	 * 属性护士人数/护士人数的getter方法
	 */
	public java.lang.Integer getNurseNum() {
		return nurseNum;
	}
	/**
	 * 属性护士人数/护士人数的setter方法
	 */
	public void setNurseNum(java.lang.Integer nurseNum) {
		this.nurseNum = nurseNum;
	} 	
	/**
	 * 属性护士每人保费/护士每人保费的getter方法
	 */
	public java.lang.Double getNursePremium() {
		return nursePremium;
	}
	/**
	 * 属性护士每人保费/护士每人保费的setter方法
	 */
	public void setNursePremium(java.lang.Double nursePremium) {
		this.nursePremium = nursePremium;
	} 	
	/**
	 * 属性医务人员保费/医务人员保费的getter方法
	 */
	public java.lang.Double getWorkerPremium() {
		return workerPremium;
	}
	/**
	 * 属性医务人员保费/医务人员保费的setter方法
	 */
	public void setWorkerPremium(java.lang.Double workerPremium) {
		this.workerPremium = workerPremium;
	} 	
	/**
	 * 属性医务人员人数/医务人员人数的getter方法
	 */
	public java.lang.Integer getWorkerNum() {
		return workerNum;
	}
	/**
	 * 属性医务人员人数/医务人员人数的setter方法
	 */
	public void setWorkerNum(java.lang.Integer workerNum) {
		this.workerNum = workerNum;
	} 	
	/**
	 * 属性unitPremium/unitPremium的getter方法
	 */
	public java.lang.Double getUnitPremium() {
		return unitPremium;
	}
	/**
	 * 属性unitPremium/unitPremium的setter方法
	 */
	public void setUnitPremium(java.lang.Double unitPremium) {
		this.unitPremium = unitPremium;
	} 	
	/**
	 * 属性住院病人手术人次/住院病人手术人次的getter方法
	 */
	public java.lang.Integer getOperationNum() {
		return operationNum;
	}
	/**
	 * 属性住院病人手术人次/住院病人手术人次的setter方法
	 */
	public void setOperationNum(java.lang.Integer operationNum) {
		this.operationNum = operationNum;
	} 	
	/**
	 * 属性住院病人手术人次基准保险费/住院病人手术人次基准保险费的getter方法
	 */
	public java.lang.Double getOperationPremium() {
		return operationPremium;
	}
	/**
	 * 属性住院病人手术人次基准保险费/住院病人手术人次基准保险费的setter方法
	 */
	public void setOperationPremium(java.lang.Double operationPremium) {
		this.operationPremium = operationPremium;
	} 	
	/**
	 * 属性医疗机构类别系数/医疗机构类别系数的getter方法
	 */
	public java.lang.Double getMedicalRate() {
		return medicalRate;
	}
	/**
	 * 属性医疗机构类别系数/医疗机构类别系数的setter方法
	 */
	public void setMedicalRate(java.lang.Double medicalRate) {
		this.medicalRate = medicalRate;
	} 	
	/**
	 * 属性岗位系数/岗位系数的getter方法
	 */
	public java.lang.Double getPostRate() {
		return postRate;
	}
	/**
	 * 属性岗位系数/岗位系数的setter方法
	 */
	public void setPostRate(java.lang.Double postRate) {
		this.postRate = postRate;
	} 	
	/**
	 * 属性currency3/currency3的getter方法
	 */
	public String getCurrency2() {
		return currency2;
	}
	/**
	 * 属性currency3/currency3的setter方法
	 */
	public void setCurrency2(String currency2) {
		this.currency2 = currency2;
	} 	
	/**
	 * 属性exChangeRate3/exChangeRate3的getter方法
	 */
	public java.lang.Double getExchangeRate2() {
		return exchangeRate2;
	}
	/**
	 * 属性exChangeRate3/exChangeRate3的setter方法
	 */
	public void setExchangeRate2(java.lang.Double exchangeRate2) {
		this.exchangeRate2 = exchangeRate2;
	} 	
	/**
	 * 属性exChangeRateCny/exChangeRateCny的getter方法
	 */
	public java.lang.Double getExchangeRateCNY() {
		return exchangeRateCNY;
	}
	/**
	 * 属性exChangeRateCny/exChangeRateCny的setter方法
	 */
	public void setExchangeRateCNY(java.lang.Double exchangeRateCNY) {
		this.exchangeRateCNY = exchangeRateCNY;
	} 	
	/**
	 * 属性insuredValueType/insuredValueType的getter方法
	 */
	public String getInsuredValueType() {
		return insuredValueType;
	}
	/**
	 * 属性insuredValueType/insuredValueType的setter方法
	 */
	public void setInsuredValueType(String insuredValueType) {
		this.insuredValueType = insuredValueType;
	} 	
	/**
	 * 属性insuredValueTypeName/insuredValueTypeName的getter方法
	 */
	public String getInsuredValueTypeName() {
		return insuredValueTypeName;
	}
	/**
	 * 属性insuredValueTypeName/insuredValueTypeName的setter方法
	 */
	public void setInsuredValueTypeName(String insuredValueTypeName) {
		this.insuredValueTypeName = insuredValueTypeName;
	} 	
	/**
	 * 属性newEndDate/newEndDate的getter方法
	 */
	public java.util.Date getNewEndDate() {
		return newEndDate;
	}
	/**
	 * 属性newEndDate/newEndDate的setter方法
	 */
	public void setNewEndDate(java.util.Date newEndDate) {
		this.newEndDate = newEndDate;
	} 	
	/**
	 * 属性newStartDate/newStartDate的getter方法
	 */
	public java.util.Date getNewStartDate() {
		return newStartDate;
	}
	/**
	 * 属性newStartDate/newStartDate的setter方法
	 */
	public void setNewStartDate(java.util.Date newStartDate) {
		this.newStartDate = newStartDate;
	} 	
	/**
	 * 属性premium3/premium3的getter方法
	 */
	public java.lang.Double getPremium2() {
		return premium2;
	}
	/**
	 * 属性premium3/premium3的setter方法
	 */
	public void setPremium2(java.lang.Double premium2) {
		this.premium2 = premium2;
	} 	
	/**
	 * 属性premiumCny/premiumCny的getter方法
	 */
	public java.lang.Double getPremiumCNY() {
		return premiumCNY;
	}
	/**
	 * 属性premiumCny/premiumCny的setter方法
	 */
	public void setPremiumCNY(java.lang.Double premiumCNY) {
		this.premiumCNY = premiumCNY;
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
	 * 属性不含税保费/不含税保费的getter方法
	 */
	public java.lang.Double getNoTaxPremium() {
		return noTaxPremium;
	}
	/**
	 * 属性不含税保费/不含税保费的setter方法
	 */
	public void setNoTaxPremium(java.lang.Double noTaxPremium) {
		this.noTaxPremium = noTaxPremium;
	} 	
	/**
	 * 属性应/免税标识，1-应税，2-免税/应/免税标识，1-应税，2-免税的getter方法
	 */
	public String getTaxFlag() {
		return taxFlag;
	}
	/**
	 * 属性应/免税标识，1-应税，2-免税/应/免税标识，1-应税，2-免税的setter方法
	 */
	public void setTaxFlag(String taxFlag) {
		this.taxFlag = taxFlag;
	} 	
	/**
	 * 属性税率/税率的getter方法
	 */
	public java.lang.Double getTaxRate() {
		return taxRate;
	}
	/**
	 * 属性税率/税率的setter方法
	 */
	public void setTaxRate(java.lang.Double taxRate) {
		this.taxRate = taxRate;
	} 	
	/**
	 * 属性税额/税额的getter方法
	 */
	public java.lang.Double getTaxFee() {
		return taxFee;
	}
	/**
	 * 属性税额/税额的setter方法
	 */
	public void setTaxFee(java.lang.Double taxFee) {
		this.taxFee = taxFee;
	} 	
	/**
	 * 属性保费计算方式/保费计算方式的getter方法
	 */
	public String getPremiumCalMethod() {
		return premiumCalMethod;
	}
	/**
	 * 属性保费计算方式/保费计算方式的setter方法
	 */
	public void setPremiumCalMethod(String premiumCalMethod) {
		this.premiumCalMethod = premiumCalMethod;
	} 	
	/**
	 * 属性林木用途/林木用途的getter方法
	 */
	public String getForestUse() {
		return forestUse;
	}
	/**
	 * 属性林木用途/林木用途的setter方法
	 */
	public void setForestUse(String forestUse) {
		this.forestUse = forestUse;
	} 	
}