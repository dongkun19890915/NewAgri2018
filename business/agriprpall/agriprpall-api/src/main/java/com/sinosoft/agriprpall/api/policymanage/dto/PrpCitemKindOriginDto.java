package com.sinosoft.agriprpall.api.policymanage.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-30 08:02:24.074 
 * 原始保单标的子险表Api操作对象
 */
public class PrpCitemKindOriginDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性保单号码/保单号码 */
	private String policyNo ;		
	/** 属性险种代码 /险种代码  */
	private String riskCode ;		
	/** 属性序号/序号 */
	private Integer itemkindNo ;
	/** 属性分户序号/分户序号 */
	private Integer familyNo ;
	/** 属性分户名称（集装箱体保险时为集装箱编号）/分户名称（集装箱体保险时为集装箱编号） */
	private String familyName ;		
	/** 属性rationType/rationType */
	private String rationType ;		
	/** 属性险别代码 /险别代码  */
	private String kindCode ;		
	/** 属性险别名称/险别名称 */
	private String kindName ;		
	/** 属性标的序号       /标的序号        */
	private Integer itemNo ;
	/** 属性标的项目类别代码 /标的项目类别代码  */
	private String itemCode ;		
	/** 属性标的项目明细名称/标的项目明细名称 */
	private String itemDetailName ;		
	/** 属性投保方式代码/投保方式代码 */
	private String modeCode ;		
	/** 属性投保方式名称/投保方式名称 */
	private String modeName ;		
	/** 属性起保日期/起保日期 */
	private java.util.Date startDate ;		
	/** 属性起保小时/起保小时 */
	private Integer startHour ;
	/** 属性终保日起/终保日起 */
	private java.util.Date endDate ;		
	/** 属性终报小时/终报小时 */
	private Integer endHour ;
	/** 属性规格型号/规格型号 */
	private String model ;		
	/** 属性购买日起/购买日起 */
	private java.util.Date buyDate ;		
	/** 属性地址序号/地址序号 */
	private Integer addressNo ;
	/** 属性是否计算保额标志(Y/N)/是否计算保额标志(Y/N) */
	private String calculateFlag ;		
	/** 属性币别 /币别  */
	private String currency ;		
	/** 属性单位保险金额/单位保险金额 */
	private Double unitamount ;
	/** 属性数量/数量 */
	private Double quantity ;
	/** 属性数量单位/数量单位 */
	private String unit ;		
	/** 属性保险价值/保险价值 */
	private Double value ;
	/** 属性保险金额/保险金额 */
	private Double amount ;
	/** 属性适应费率期数/适应费率期数 */
	private Integer rateperiod ;
	/** 属性费率/费率 */
	private Double rate ;
	/** 属性短期费率标志(1.月比例/2.日比例)/短期费率标志(1.月比例/2.日比例) */
	private String shortRateFlag ;		
	/** 属性短期费率       /短期费率        */
	private Double shortRate ;
	/** 属性基准保费/基准保费 */
	private Double basePremium ;
	/** 属性标准保费/标准保费 */
	private Double benchmarkPremium ;
	/** 属性折扣率/折扣率 */
	private Double discount ;
	/** 属性保费调整比率(%)/保费调整比率(%) */
	private Double adjustRate ;
	/** 属性保费/储金/保费/储金 */
	private Double premium ;
	/** 属性免赔率/免赔率 */
	private Double deductibleRate ;
	/** 属性免赔额/免赔额 */
	private Double deductible ;
	/** 属性标志字段/标志字段 */
	private String flag ;		
	/** 属性地区费率因子: 0-不浮动, 1-上浮30%/地区费率因子: 0-不浮动, 1-上浮30% */
	private String regionRate ;		
	/** 属性饮酒费率因子：饮酒驾驶违法次数/饮酒费率因子：饮酒驾驶违法次数 */
	private Integer drinkRate ;
	/** 属性醉酒费率因子：醉酒驾驶违法次数/醉酒费率因子：醉酒驾驶违法次数 */
	private Integer drunkRate ;
	/** 属性肉牛类型/肉牛类型 */
	private String cattleType ;		
	/** 属性每次事故每人赔偿限额/每次事故每人赔偿限额 */
	private Double unitPersonLimitAmount ;
	/** 属性每人赔偿限额0123用到/每人赔偿限额0123用到 */
	private Double unitPersonAmount ;
	/** 属性日额：每人日额（元）2714,0123用/日额：每人日额（元）2714,0123用 */
	private Double unitDayAmountSub ;
	/** 属性天数：2714附加险专用0123附加险借用/天数：2714附加险专用0123附加险借用 */
	private Integer daySub ;
	/** 属性人员类别2606险种用到/人员类别2606险种用到 */
	private String personType ;		
	/** 属性起赔点/起赔点 */
	private Double triggerPoint ;
	/** 属性全损损失率/全损损失率 */
	private Double totalLossRatio ;
	/** 属性诉讼费限额/诉讼费限额 */
	private Double lawSuitAmount ;
	/** 属性病床数/病床数 */
	private Integer bedNum ;
	/** 属性每张床位保险费/每张床位保险费 */
	private Double bedPremium ;
	/** 属性医疗机构保费/医疗机构保费 */
	private Double hospitalPremium ;
	/** 属性各类医务人员人数/各类医务人员人数 */
	private Integer kindWorkerNum ;
	/** 属性各类医务人员每人保费/各类医务人员每人保费 */
	private Double kindWorkerPremium ;
	/** 属性临床手术科室医师人数/临床手术科室医师人数 */
	private Integer clinicNum ;
	/** 属性临床手术科室医师每人保费/临床手术科室医师每人保费 */
	private Double clinicPremium ;
	/** 属性临床非手术科室医师人数/临床非手术科室医师人数 */
	private Integer nclinicNum ;
	/** 属性临床非手术科室医师每人保费/临床非手术科室医师每人保费 */
	private Double nclinicPremium ;
	/** 属性医技科室人数/医技科室人数 */
	private Integer roomNum ;
	/** 属性医技科室每人保费/医技科室每人保费 */
	private Double roomPremium ;
	/** 属性护士人数/护士人数 */
	private Integer nurseNum ;
	/** 属性护士每人保费/护士每人保费 */
	private Double nursePremium ;
	/** 属性医务人员保费/医务人员保费 */
	private Double workerPremium ;
	/** 属性医务人员人数/医务人员人数 */
	private Integer workerNum ;
	/** 属性unitPremium/unitPremium */
	private Double unitPremium ;
	/** 属性住院病人手术人次/住院病人手术人次 */
	private Integer operationNum ;
	/** 属性住院病人手术人次基准保险费/住院病人手术人次基准保险费 */
	private Double operationPremium ;
	/** 属性医疗机构类别系数/医疗机构类别系数 */
	private Double medicalRate ;
	/** 属性岗位系数/岗位系数 */
	private Double postRate ;
	/** 属性currency2/currency2 */
	private String currency2 ;		
	/** 属性exchangeRate2/exchangeRate2 */
	private Double exchangeRate2 ;
	/** 属性exchangeRateCNY/exchangeRateCNY */
	private Double exchangeRateCNY ;
	/** 属性insuredValueType/insuredValueType */
	private String insuredValueType ;		
	/** 属性insuredValueTypeName/insuredValueTypeName */
	private String insuredValueTypeName ;		
	/** 属性newEndDate/newEndDate */
	private java.util.Date newEndDate ;		
	/** 属性newStartDate/newStartDate */
	private java.util.Date newStartDate ;		
	/** 属性premium2/premium2 */
	private Double premium2 ;
	/** 属性premiumCNY/premiumCNY */
	private Double premiumCNY ;
	/** 属性修改人/修改人 */
	private String updateBy ;		
	/** 属性修改时间/修改时间 */
	private java.util.Date updateDate ;		
	/** 属性不含税保费/不含税保费 */
	private Double noTaxPremium ;
	/** 属性应/免税标识，1-应税，2-免税/应/免税标识，1-应税，2-免税 */
	private String taxFlag ;		
	/** 属性税率/税率 */
	private Double taxRate ;
	/** 属性税额/税额 */
	private Double taxFee ;
	/** 属性premiumcalMethod/premiumcalMethod */
	private String premiumcalMethod ;		
	/** 属性forestUse/forestUse */
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
	public Integer getItemkindNo() {
		return itemkindNo;
	}
	/**
	 * 属性序号/序号的setter方法
	 */
	public void setItemkindNo(Integer itemkindNo) {
		this.itemkindNo = itemkindNo;
	}	
	/**
	 * 属性分户序号/分户序号的getter方法
	 */
	public Integer getFamilyNo() {
		return familyNo;
	}
	/**
	 * 属性分户序号/分户序号的setter方法
	 */
	public void setFamilyNo(Integer familyNo) {
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
	public Integer getItemNo() {
		return itemNo;
	}
	/**
	 * 属性标的序号       /标的序号       的setter方法
	 */
	public void setItemNo(Integer itemNo) {
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
	public Integer getStartHour() {
		return startHour;
	}
	/**
	 * 属性起保小时/起保小时的setter方法
	 */
	public void setStartHour(Integer startHour) {
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
	public Integer getEndHour() {
		return endHour;
	}
	/**
	 * 属性终报小时/终报小时的setter方法
	 */
	public void setEndHour(Integer endHour) {
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
	public Integer getAddressNo() {
		return addressNo;
	}
	/**
	 * 属性地址序号/地址序号的setter方法
	 */
	public void setAddressNo(Integer addressNo) {
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
	public Double getUnitamount() {
		return unitamount;
	}
	/**
	 * 属性单位保险金额/单位保险金额的setter方法
	 */
	public void setUnitamount(Double unitamount) {
		this.unitamount = unitamount;
	}	
	/**
	 * 属性数量/数量的getter方法
	 */
	public Double getQuantity() {
		return quantity;
	}
	/**
	 * 属性数量/数量的setter方法
	 */
	public void setQuantity(Double quantity) {
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
	public Double getValue() {
		return value;
	}
	/**
	 * 属性保险价值/保险价值的setter方法
	 */
	public void setValue(Double value) {
		this.value = value;
	}	
	/**
	 * 属性保险金额/保险金额的getter方法
	 */
	public Double getAmount() {
		return amount;
	}
	/**
	 * 属性保险金额/保险金额的setter方法
	 */
	public void setAmount(Double amount) {
		this.amount = amount;
	}	
	/**
	 * 属性适应费率期数/适应费率期数的getter方法
	 */
	public Integer getRateperiod() {
		return rateperiod;
	}
	/**
	 * 属性适应费率期数/适应费率期数的setter方法
	 */
	public void setRateperiod(Integer rateperiod) {
		this.rateperiod = rateperiod;
	}	
	/**
	 * 属性费率/费率的getter方法
	 */
	public Double getRate() {
		return rate;
	}
	/**
	 * 属性费率/费率的setter方法
	 */
	public void setRate(Double rate) {
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
	public Double getShortRate() {
		return shortRate;
	}
	/**
	 * 属性短期费率       /短期费率       的setter方法
	 */
	public void setShortRate(Double shortRate) {
		this.shortRate = shortRate;
	}	
	/**
	 * 属性基准保费/基准保费的getter方法
	 */
	public Double getBasePremium() {
		return basePremium;
	}
	/**
	 * 属性基准保费/基准保费的setter方法
	 */
	public void setBasePremium(Double basePremium) {
		this.basePremium = basePremium;
	}	
	/**
	 * 属性标准保费/标准保费的getter方法
	 */
	public Double getBenchmarkPremium() {
		return benchmarkPremium;
	}
	/**
	 * 属性标准保费/标准保费的setter方法
	 */
	public void setBenchmarkPremium(Double benchmarkPremium) {
		this.benchmarkPremium = benchmarkPremium;
	}	
	/**
	 * 属性折扣率/折扣率的getter方法
	 */
	public Double getDiscount() {
		return discount;
	}
	/**
	 * 属性折扣率/折扣率的setter方法
	 */
	public void setDiscount(Double discount) {
		this.discount = discount;
	}	
	/**
	 * 属性保费调整比率(%)/保费调整比率(%)的getter方法
	 */
	public Double getAdjustRate() {
		return adjustRate;
	}
	/**
	 * 属性保费调整比率(%)/保费调整比率(%)的setter方法
	 */
	public void setAdjustRate(Double adjustRate) {
		this.adjustRate = adjustRate;
	}	
	/**
	 * 属性保费/储金/保费/储金的getter方法
	 */
	public Double getPremium() {
		return premium;
	}
	/**
	 * 属性保费/储金/保费/储金的setter方法
	 */
	public void setPremium(Double premium) {
		this.premium = premium;
	}	
	/**
	 * 属性免赔率/免赔率的getter方法
	 */
	public Double getDeductibleRate() {
		return deductibleRate;
	}
	/**
	 * 属性免赔率/免赔率的setter方法
	 */
	public void setDeductibleRate(Double deductibleRate) {
		this.deductibleRate = deductibleRate;
	}	
	/**
	 * 属性免赔额/免赔额的getter方法
	 */
	public Double getDeductible() {
		return deductible;
	}
	/**
	 * 属性免赔额/免赔额的setter方法
	 */
	public void setDeductible(Double deductible) {
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
	public Integer getDrinkRate() {
		return drinkRate;
	}
	/**
	 * 属性饮酒费率因子：饮酒驾驶违法次数/饮酒费率因子：饮酒驾驶违法次数的setter方法
	 */
	public void setDrinkRate(Integer drinkRate) {
		this.drinkRate = drinkRate;
	}	
	/**
	 * 属性醉酒费率因子：醉酒驾驶违法次数/醉酒费率因子：醉酒驾驶违法次数的getter方法
	 */
	public Integer getDrunkRate() {
		return drunkRate;
	}
	/**
	 * 属性醉酒费率因子：醉酒驾驶违法次数/醉酒费率因子：醉酒驾驶违法次数的setter方法
	 */
	public void setDrunkRate(Integer drunkRate) {
		this.drunkRate = drunkRate;
	}	
	/**
	 * 属性肉牛类型/肉牛类型的getter方法
	 */
	public String getCattleType() {
		return cattleType;
	}
	/**
	 * 属性肉牛类型/肉牛类型的setter方法
	 */
	public void setCattleType(String cattleType) {
		this.cattleType = cattleType;
	}	
	/**
	 * 属性每次事故每人赔偿限额/每次事故每人赔偿限额的getter方法
	 */
	public Double getUnitPersonLimitAmount() {
		return unitPersonLimitAmount;
	}
	/**
	 * 属性每次事故每人赔偿限额/每次事故每人赔偿限额的setter方法
	 */
	public void setUnitPersonLimitAmount(Double unitPersonLimitAmount) {
		this.unitPersonLimitAmount = unitPersonLimitAmount;
	}	
	/**
	 * 属性每人赔偿限额0123用到/每人赔偿限额0123用到的getter方法
	 */
	public Double getUnitPersonAmount() {
		return unitPersonAmount;
	}
	/**
	 * 属性每人赔偿限额0123用到/每人赔偿限额0123用到的setter方法
	 */
	public void setUnitPersonAmount(Double unitPersonAmount) {
		this.unitPersonAmount = unitPersonAmount;
	}	
	/**
	 * 属性日额：每人日额（元）2714,0123用/日额：每人日额（元）2714,0123用的getter方法
	 */
	public Double getUnitDayAmountSub() {
		return unitDayAmountSub;
	}
	/**
	 * 属性日额：每人日额（元）2714,0123用/日额：每人日额（元）2714,0123用的setter方法
	 */
	public void setUnitDayAmountSub(Double unitDayAmountSub) {
		this.unitDayAmountSub = unitDayAmountSub;
	}	
	/**
	 * 属性天数：2714附加险专用0123附加险借用/天数：2714附加险专用0123附加险借用的getter方法
	 */
	public Integer getDaySub() {
		return daySub;
	}
	/**
	 * 属性天数：2714附加险专用0123附加险借用/天数：2714附加险专用0123附加险借用的setter方法
	 */
	public void setDaySub(Integer daySub) {
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
	public Double getTriggerPoint() {
		return triggerPoint;
	}
	/**
	 * 属性起赔点/起赔点的setter方法
	 */
	public void setTriggerPoint(Double triggerPoint) {
		this.triggerPoint = triggerPoint;
	}	
	/**
	 * 属性全损损失率/全损损失率的getter方法
	 */
	public Double getTotalLossRatio() {
		return totalLossRatio;
	}
	/**
	 * 属性全损损失率/全损损失率的setter方法
	 */
	public void setTotalLossRatio(Double totalLossRatio) {
		this.totalLossRatio = totalLossRatio;
	}	
	/**
	 * 属性诉讼费限额/诉讼费限额的getter方法
	 */
	public Double getLawSuitAmount() {
		return lawSuitAmount;
	}
	/**
	 * 属性诉讼费限额/诉讼费限额的setter方法
	 */
	public void setLawSuitAmount(Double lawSuitAmount) {
		this.lawSuitAmount = lawSuitAmount;
	}	
	/**
	 * 属性病床数/病床数的getter方法
	 */
	public Integer getBedNum() {
		return bedNum;
	}
	/**
	 * 属性病床数/病床数的setter方法
	 */
	public void setBedNum(Integer bedNum) {
		this.bedNum = bedNum;
	}	
	/**
	 * 属性每张床位保险费/每张床位保险费的getter方法
	 */
	public Double getBedPremium() {
		return bedPremium;
	}
	/**
	 * 属性每张床位保险费/每张床位保险费的setter方法
	 */
	public void setBedPremium(Double bedPremium) {
		this.bedPremium = bedPremium;
	}	
	/**
	 * 属性医疗机构保费/医疗机构保费的getter方法
	 */
	public Double getHospitalPremium() {
		return hospitalPremium;
	}
	/**
	 * 属性医疗机构保费/医疗机构保费的setter方法
	 */
	public void setHospitalPremium(Double hospitalPremium) {
		this.hospitalPremium = hospitalPremium;
	}	
	/**
	 * 属性各类医务人员人数/各类医务人员人数的getter方法
	 */
	public Integer getKindWorkerNum() {
		return kindWorkerNum;
	}
	/**
	 * 属性各类医务人员人数/各类医务人员人数的setter方法
	 */
	public void setKindWorkerNum(Integer kindWorkerNum) {
		this.kindWorkerNum = kindWorkerNum;
	}	
	/**
	 * 属性各类医务人员每人保费/各类医务人员每人保费的getter方法
	 */
	public Double getKindWorkerPremium() {
		return kindWorkerPremium;
	}
	/**
	 * 属性各类医务人员每人保费/各类医务人员每人保费的setter方法
	 */
	public void setKindWorkerPremium(Double kindWorkerPremium) {
		this.kindWorkerPremium = kindWorkerPremium;
	}	
	/**
	 * 属性临床手术科室医师人数/临床手术科室医师人数的getter方法
	 */
	public Integer getClinicNum() {
		return clinicNum;
	}
	/**
	 * 属性临床手术科室医师人数/临床手术科室医师人数的setter方法
	 */
	public void setClinicNum(Integer clinicNum) {
		this.clinicNum = clinicNum;
	}	
	/**
	 * 属性临床手术科室医师每人保费/临床手术科室医师每人保费的getter方法
	 */
	public Double getClinicPremium() {
		return clinicPremium;
	}
	/**
	 * 属性临床手术科室医师每人保费/临床手术科室医师每人保费的setter方法
	 */
	public void setClinicPremium(Double clinicPremium) {
		this.clinicPremium = clinicPremium;
	}	
	/**
	 * 属性临床非手术科室医师人数/临床非手术科室医师人数的getter方法
	 */
	public Integer getNclinicNum() {
		return nclinicNum;
	}
	/**
	 * 属性临床非手术科室医师人数/临床非手术科室医师人数的setter方法
	 */
	public void setNclinicNum(Integer nclinicNum) {
		this.nclinicNum = nclinicNum;
	}	
	/**
	 * 属性临床非手术科室医师每人保费/临床非手术科室医师每人保费的getter方法
	 */
	public Double getNclinicPremium() {
		return nclinicPremium;
	}
	/**
	 * 属性临床非手术科室医师每人保费/临床非手术科室医师每人保费的setter方法
	 */
	public void setNclinicPremium(Double nclinicPremium) {
		this.nclinicPremium = nclinicPremium;
	}	
	/**
	 * 属性医技科室人数/医技科室人数的getter方法
	 */
	public Integer getRoomNum() {
		return roomNum;
	}
	/**
	 * 属性医技科室人数/医技科室人数的setter方法
	 */
	public void setRoomNum(Integer roomNum) {
		this.roomNum = roomNum;
	}	
	/**
	 * 属性医技科室每人保费/医技科室每人保费的getter方法
	 */
	public Double getRoomPremium() {
		return roomPremium;
	}
	/**
	 * 属性医技科室每人保费/医技科室每人保费的setter方法
	 */
	public void setRoomPremium(Double roomPremium) {
		this.roomPremium = roomPremium;
	}	
	/**
	 * 属性护士人数/护士人数的getter方法
	 */
	public Integer getNurseNum() {
		return nurseNum;
	}
	/**
	 * 属性护士人数/护士人数的setter方法
	 */
	public void setNurseNum(Integer nurseNum) {
		this.nurseNum = nurseNum;
	}	
	/**
	 * 属性护士每人保费/护士每人保费的getter方法
	 */
	public Double getNursePremium() {
		return nursePremium;
	}
	/**
	 * 属性护士每人保费/护士每人保费的setter方法
	 */
	public void setNursePremium(Double nursePremium) {
		this.nursePremium = nursePremium;
	}	
	/**
	 * 属性医务人员保费/医务人员保费的getter方法
	 */
	public Double getWorkerPremium() {
		return workerPremium;
	}
	/**
	 * 属性医务人员保费/医务人员保费的setter方法
	 */
	public void setWorkerPremium(Double workerPremium) {
		this.workerPremium = workerPremium;
	}	
	/**
	 * 属性医务人员人数/医务人员人数的getter方法
	 */
	public Integer getWorkerNum() {
		return workerNum;
	}
	/**
	 * 属性医务人员人数/医务人员人数的setter方法
	 */
	public void setWorkerNum(Integer workerNum) {
		this.workerNum = workerNum;
	}	
	/**
	 * 属性unitPremium/unitPremium的getter方法
	 */
	public Double getUnitPremium() {
		return unitPremium;
	}
	/**
	 * 属性unitPremium/unitPremium的setter方法
	 */
	public void setUnitPremium(Double unitPremium) {
		this.unitPremium = unitPremium;
	}	
	/**
	 * 属性住院病人手术人次/住院病人手术人次的getter方法
	 */
	public Integer getOperationNum() {
		return operationNum;
	}
	/**
	 * 属性住院病人手术人次/住院病人手术人次的setter方法
	 */
	public void setOperationNum(Integer operationNum) {
		this.operationNum = operationNum;
	}	
	/**
	 * 属性住院病人手术人次基准保险费/住院病人手术人次基准保险费的getter方法
	 */
	public Double getOperationPremium() {
		return operationPremium;
	}
	/**
	 * 属性住院病人手术人次基准保险费/住院病人手术人次基准保险费的setter方法
	 */
	public void setOperationPremium(Double operationPremium) {
		this.operationPremium = operationPremium;
	}	
	/**
	 * 属性医疗机构类别系数/医疗机构类别系数的getter方法
	 */
	public Double getMedicalRate() {
		return medicalRate;
	}
	/**
	 * 属性医疗机构类别系数/医疗机构类别系数的setter方法
	 */
	public void setMedicalRate(Double medicalRate) {
		this.medicalRate = medicalRate;
	}	
	/**
	 * 属性岗位系数/岗位系数的getter方法
	 */
	public Double getPostRate() {
		return postRate;
	}
	/**
	 * 属性岗位系数/岗位系数的setter方法
	 */
	public void setPostRate(Double postRate) {
		this.postRate = postRate;
	}	
	/**
	 * 属性currency2/currency2的getter方法
	 */
	public String getCurrency2() {
		return currency2;
	}
	/**
	 * 属性currency2/currency2的setter方法
	 */
	public void setCurrency2(String currency2) {
		this.currency2 = currency2;
	}	
	/**
	 * 属性exchangeRate2/exchangeRate2的getter方法
	 */
	public Double getExchangeRate2() {
		return exchangeRate2;
	}
	/**
	 * 属性exchangeRate2/exchangeRate2的setter方法
	 */
	public void setExchangeRate2(Double exchangeRate2) {
		this.exchangeRate2 = exchangeRate2;
	}	
	/**
	 * 属性exchangeRateCNY/exchangeRateCNY的getter方法
	 */
	public Double getExchangeRateCNY() {
		return exchangeRateCNY;
	}
	/**
	 * 属性exchangeRateCNY/exchangeRateCNY的setter方法
	 */
	public void setExchangeRateCNY(Double exchangeRateCNY) {
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
	 * 属性premium2/premium2的getter方法
	 */
	public Double getPremium2() {
		return premium2;
	}
	/**
	 * 属性premium2/premium2的setter方法
	 */
	public void setPremium2(Double premium2) {
		this.premium2 = premium2;
	}	
	/**
	 * 属性premiumCNY/premiumCNY的getter方法
	 */
	public Double getPremiumCNY() {
		return premiumCNY;
	}
	/**
	 * 属性premiumCNY/premiumCNY的setter方法
	 */
	public void setPremiumCNY(Double premiumCNY) {
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
	public Double getNoTaxPremium() {
		return noTaxPremium;
	}
	/**
	 * 属性不含税保费/不含税保费的setter方法
	 */
	public void setNoTaxPremium(Double noTaxPremium) {
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
	public Double getTaxRate() {
		return taxRate;
	}
	/**
	 * 属性税率/税率的setter方法
	 */
	public void setTaxRate(Double taxRate) {
		this.taxRate = taxRate;
	}	
	/**
	 * 属性税额/税额的getter方法
	 */
	public Double getTaxFee() {
		return taxFee;
	}
	/**
	 * 属性税额/税额的setter方法
	 */
	public void setTaxFee(Double taxFee) {
		this.taxFee = taxFee;
	}	
	/**
	 * 属性premiumcalMethod/premiumcalMethod的getter方法
	 */
	public String getPremiumcalMethod() {
		return premiumcalMethod;
	}
	/**
	 * 属性premiumcalMethod/premiumcalMethod的setter方法
	 */
	public void setPremiumcalMethod(String premiumcalMethod) {
		this.premiumcalMethod = premiumcalMethod;
	}	
	/**
	 * 属性forestUse/forestUse的getter方法
	 */
	public String getForestUse() {
		return forestUse;
	}
	/**
	 * 属性forestUse/forestUse的setter方法
	 */
	public void setForestUse(String forestUse) {
		this.forestUse = forestUse;
	}	
}
