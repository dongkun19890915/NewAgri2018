package com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;

import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-24 09:50:49.498 
 * 标的子险信息实体操作对象
 */
@Entity
@Table(name = "PrpPitemKindCopy")
@IdClass(PrpPitemKindCopyKey.class)
public class PrpPitemKindCopy extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性批单号码/批单号码 */
	@Id
	@Column(name = "endorseNo")
	private String endorseNo ;/** 属性 险种代码/ 险种代码 */
	@Id
	@Column(name = "itemKindNo")
	private String itemKindNo ;	

	/** 属性 保单号码/ 保单号码 */
	@Column(name = "riskCode")
	private String riskCode ;

	@Column(name = "policyNo")
	private String policyNo;
	/** 属性序号/序号 */
	@Column(name = "familyNo")
	private Integer familyNo ;
	/** 属性分户序号(仅用于集体家财险)/分户序号(仅用于集体家财险) */
	@Column(name = "familyName")
	private String familyName ;
	/** 属性rationType/rationType */
	@Column(name = "rationType")
	private String rationType ;
	/** 属性分户名称(仅用于集体家财险)--** 集装箱体保险时为集装箱编号--** 船舶险时为船名/分户名称(仅用于集体家财险)--** 集装箱体保险时为集装箱编号--** 船舶险时为船名 */
	@Column(name = "kindCode")
	private String kindCode ;
	/** 属性险别代码/险别代码 */
	@Column(name = "kindName")
	private String kindName ;
	/** 属性险别名称/险别名称 */
	@Column(name = "itemNo")
	private Integer itemNo ;
	/** 属性标的序号/标的序号 */
	@Column(name = "itemCode")
	private String itemCode ;
	/** 属性标的项目类别代码 ▲--** 林木种类代码/标的项目类别代码 ▲--** 林木种类代码 */
	@Column(name = "itemDetailName")
	private String itemDetailName ;
	/** 属性标的项目明细名称--** 林木种类名称/标的项目明细名称--** 林木种类名称 */
	@Column(name = "modeCode")
	private String modeCode ;
	/** 属性投保方式代码▲--** 金牛险:--** PrpDration.RationType--** 养殖险: 何价投保--** 车险：玻璃类别/投保方式代码▲--** 金牛险:--** PrpDration.RationType--** 养殖险: 何价投保--** 车险：玻璃类别 */
	@Column(name = "modeName")
	private String modeName ;
	/** 属性投保方式名称--** 金牛险:--** PrpDration.RationName--** 养殖险: 何价投保/投保方式名称--** 金牛险:--** PrpDration.RationName--** 养殖险: 何价投保 */
	@Column(name = "startDate")
	private Date startDate ;
	/** 属性起保日期/起保日期 */
	@Column(name = "startHour")
	private Integer startHour ;
	/** 属性起保小时/起保小时 */
	@Column(name = "endDate")
	private Date endDate ;
	/** 属性终保日期/终保日期 */
	@Column(name = "endHour")
	private Integer endHour ;
	/** 属性 终保小时/ 终保小时 */
	@Column(name = "model")
	private String model ;
	/** 属性 规格型号/ 规格型号 */
	@Column(name = "buyDate")
	private Date buyDate ;
	/** 属性购买日期/购买日期 */
	@Column(name = "addressNo")
	private Integer addressNo ;
	/** 属性地址序号/地址序号 */
	@Column(name = "calculateFlag")
	private String calculateFlag ;
	/** 属性是否计算保额标志(Y/N)/是否计算保额标志(Y/N) */
	@Column(name = "currency")
	private String currency ;
	/** 属性 币别/ 币别 */
	@Column(name = "unitAmount")
	private Double unitAmount ;
	/** 属性单位保险金额（赔偿限额）/单位保险金额（赔偿限额） */
	@Column(name = "quantity")
	private Double quantity ;
	/** 属性 数量(人数/产品数量/户数)--** 牲畜数量(养殖)--** 投保面积(亩)(林木险)/ 数量(人数/产品数量/户数)--** 牲畜数量(养殖)--** 投保面积(亩)(林木险) */
	@Column(name = "unit")
	private String unit ;
	/** 属性 数量单位/ 数量单位 */
	@Column(name = "value")
	private Double value ;
	/** 属性保险价值/保险价值 */
	@Column(name = "amount")
	private Double amount ;
	/** 属性保险金额/赔偿限额/保险金额/赔偿限额 */
	@Column(name = "ratePeriod")
	private Integer ratePeriod ;
	/** 属性适应费率期数/适应费率期数 */
	@Column(name = "rate")
	private Double rate ;
	/** 属性费率/费率 */
	@Column(name = "shortRateFlag")
	private String shortRateFlag ;
	/** 属性 短期费率标志--** (1.月比例/2.日比例--** /3.不计)/ 短期费率标志--** (1.月比例/2.日比例--** /3.不计) */
	@Column(name = "shortRate")
	private Double shortRate ;
	/** 属性 短期费率/ 短期费率 */
	@Column(name = "basePremium")
	private Double basePremium ;
	/** 属性基准保费/基准保费 */
	@Column(name = "benchmarkPremium")
	private Double benchmarkPremium ;
	/** 属性标准保费/标准保费 */
	@Column(name = "discount")
	private Double discount ;
	/** 属性 折扣率/ 折扣率 */
	@Column(name = "adjustRate")
	private Double adjustRate ;
	/** 属性保费调整比率(%)/保费调整比率(%) */
	@Column(name = "premium")
	private Double premium ;
	/** 属性保费/储金/保费/储金 */
	@Column(name = "deductibleRate")
	private Double deductibleRate ;
	/** 属性 免赔率(%)/ 免赔率(%) */
	@Column(name = "deductible")
	private Double deductible ;
	/** 属性免赔额/免赔额 */
	@Column(name = "flag")
	private String flag ;
	/** 属性 标志字段--** [2] 位为主险/附加险标志--** 1:主险 2:附加险 3:其他--** [3]-[4]位等于费率类型--**（RateTypeFlag）/ 标志字段--** [2] 位为主险/附加险标志--** 1:主险 2:附加险 3:其他--** [3]-[4]位等于费率类型--**（RateTypeFlag） */
	@Column(name = "chgQuantity")
	private Double chgQuantity ;
	/** 属性数量变化量/数量变化量 */
	@Column(name = "chgAmount")
	private Double chgAmount ;
	/** 属性 保额变化量/ 保额变化量 */
	@Column(name = "chgPremium")
	private Double chgPremium ;
	/** 属性保费变化量/保费变化量 */
	@Column(name = "regionRate")
	private String regionRate ;
	/** 属性地区费率因子: 0-不浮动, 1-上浮30%/地区费率因子: 0-不浮动, 1-上浮30% */
	@Column(name = "drinkRate")
	private Integer drinkRate ;
	/** 属性饮酒费率因子：饮酒驾驶违法次数/饮酒费率因子：饮酒驾驶违法次数 */
	@Column(name = "drunkRate")
	private Integer drunkRate ;
	/** 属性醉酒费率因子：醉酒驾驶违法次数/醉酒费率因子：醉酒驾驶违法次数 */
	@Column(name = "cattleType")
	private String cattleType ;
	/** 属性肉牛类型（3221肉牛险专用0122附加险借用0123附加险借用:玻璃类型）/肉牛类型（3221肉牛险专用0122附加险借用0123附加险借用:玻璃类型） */
	@Column(name = "unitPersonLimitAmount")
	private Double unitPersonLimitAmount ;
	/** 属性每次事故每人赔偿限额 0122,0123附加险用到/每次事故每人赔偿限额 0122,0123附加险用到 */
	@Column(name = "unitPersonAmount")
	private Double unitPersonAmount ;
	/** 属性每人赔偿限额0123用到/每人赔偿限额0123用到 */
	@Column(name = "unitDayAmountSub")
	private Double unitDayAmountSub ;
	/** 属性日额：每人日额（元）2714,0123用/日额：每人日额（元）2714,0123用 */
	@Column(name = "daySub")
	private Integer daySub ;
	/** 属性天数：2714附加险专用0123附加险借用/天数：2714附加险专用0123附加险借用 */
	@Column(name = "personType")
	private String personType ;
	/** 属性人员类别2606险种用到/人员类别2606险种用到 */
	@Column(name = "triggerPoint")
	private Double triggerPoint ;
	/** 属性起赔点/起赔点 */
	@Column(name = "totalLossRatio")
	private Double totalLossRatio ;
	/** 属性全损损失率/全损损失率 */
	@Column(name = "lawsuitAmount")
	private Double lawsuitAmount ;
	/** 属性诉讼费限额/诉讼费限额 */
	@Column(name = "bedNum")
	private Integer bedNum ;
	/** 属性病床数/病床数 */
	@Column(name = "bedPremium")
	private Double bedPremium ;
	/** 属性每张床位保险费/每张床位保险费 */
	@Column(name = "hospitalPremium")
	private Double hospitalPremium ;
	/** 属性医疗机构保费/医疗机构保费 */
	@Column(name = "kindWorkerNum")
	private Integer kindWorkerNum ;
	/** 属性各类医务人员人数/各类医务人员人数 */
	@Column(name = "kindWorkerPremium")
	private Double kindWorkerPremium ;
	/** 属性各类医务人员每人保费/各类医务人员每人保费 */
	@Column(name = "clinicNum")
	private Integer clinicNum ;
	/** 属性临床手术科室医师人数/临床手术科室医师人数 */
	@Column(name = "clinicPremium")
	private Double clinicPremium ;
	/** 属性临床手术科室医师每人保费/临床手术科室医师每人保费 */
	@Column(name = "nClinicNum")
	private Integer nClinicNum ;
	/** 属性临床非手术科室医师人数/临床非手术科室医师人数 */
	@Column(name = "nClinicPremium")
	private Double nClinicPremium ;
	/** 属性临床非手术科室医师每人保费/临床非手术科室医师每人保费 */
	@Column(name = "roomNum")
	private Integer roomNum ;
	/** 属性医技科室人数/医技科室人数 */
	@Column(name = "roomPremium")
	private Double roomPremium ;
	/** 属性医技科室每人保费/医技科室每人保费 */
	@Column(name = "nurseNum")
	private Integer nurseNum ;
	/** 属性护士人数/护士人数 */
	@Column(name = "nursePremium")
	private Double nursePremium ;
	/** 属性护士每人保费/护士每人保费 */
	@Column(name = "workerPremium")
	private Double workerPremium ;
	/** 属性医务人员保费/医务人员保费 */
	@Column(name = "workerNum")
	private Integer workerNum ;
	/** 属性医务人员人数/医务人员人数 */
	@Column(name = "quantityNewBorn")
	private Double quantityNewborn ;
	/** 属性大病医疗保险新生儿数量/大病医疗保险新生儿数量 */
	@Column(name = "chargeNewBornFlag")
	private String chargeNewbornFlag ;
	/** 属性单位保费变化量/单位保费变化量 */
	@Column(name = "unitPremium")
	private Double unitPremium ;
	/** 属性单位保费/单位保费 */
	@Column(name = "chgUnitPremium")
	private Double chgUnitPremium ;
	/** 属性住院病人手术人次/住院病人手术人次 */
	@Column(name = "operationNum")
	private Integer operationNum ;
	/** 属性住院病人手术人次基准保险费/住院病人手术人次基准保险费 */
	@Column(name = "operationPremium")
	private Double operationPremium ;
	/** 属性医疗机构类别系数/医疗机构类别系数 */
	@Column(name = "medicalRate")
	private Double medicalRate ;
	/** 属性岗位系数/岗位系数 */
	@Column(name = "postRate")
	private Double postRate ;
	/** 属性绝对免赔额/绝对免赔额 */
	@Column(name = "deductibleValue")
	private Double deductibleValue ;
	/** 属性绝对免赔额费率折扣系数/绝对免赔额费率折扣系数 */
	@Column(name = "deductibleDiscount")
	private Double deductibleDiscount ;
	/** 属性分摊M险的实缴保费值/分摊M险的实缴保费值 */
	@Column(name = "kindBenchmarkPremiumm")
	private Double kindBenchmarkPremiumm ;
	/** 属性分摊M险的基准保费值/分摊M险的基准保费值 */
	@Column(name = "kindPremiumm")
	private Double kindPremiumm ;
	/** 属性乘客责任限额/乘客责任限额 */
	@Column(name = "guestAmount")
	private Double guestAmount ;
	/** 属性驾驶人责任限额/驾驶人责任限额 */
	@Column(name = "driverAmount")
	private Double driverAmount ;
	/** 属性第三者责任限额/第三者责任限额 */
	@Column(name = "thirdPeopleAmount")
	private Double thirdPeopleAmount ;
	/** 属性是否特殊材质玻璃/是否特殊材质玻璃 */
	@Column(name = "isSpecGlass")
	private String isSpecGlass ;
	/** 属性安定基金比率/安定基金比率 */
	@Column(name = "stabilityFundRate")
	private Double stabilityFundRate ;
	/** 属性存储率/存储率 */
	@Column(name = "storageRate")
	private Double storageRate ;
	/** 属性structureNo/structureNo */
	@Column(name = "structureNo")
	private Integer structureNo ;
	/** 属性优惠业务费变化量/优惠业务费变化量 */
	@Column(name = "chgDiscountCharge")
	private Double chgDiscountCharge ;
	/** 属性调整后纯保费变化量/调整后纯保费变化量 */
	@Column(name = "chgLastPurePremium")
	private Double chgLastPurePremium ;
	/** 属性业务费变化量/业务费变化量 */
	@Column(name = "chgManageCharge")
	private Double chgManageCharge ;
	/** 属性折合打印币别总保费变化量/折合打印币别总保费变化量 */
	@Column(name = "chgPremium2")
	private Double chgPremium2 ;
	/** 属性chg保险费CNY/chg保险费CNY */
	@Column(name = "chgPremiumCNY")
	private Double chgPremiumCNY ;
	/** 属性基本纯保费变化量/基本纯保费变化量 */
	@Column(name = "chgPurePremium")
	private Double chgPurePremium ;
	/** 属性特别补偿基金变化量/特别补偿基金变化量 */
	@Column(name = "chgReliefFund")
	private Double chgReliefFund ;
	/** 属性健全费变化量/健全费变化量 */
	@Column(name = "chgSpecialCharge")
	private Double chgSpecialCharge ;
	/** 属性安定基金变化量/安定基金变化量 */
	@Column(name = "chgStabilityFund")
	private Double chgStabilityFund ;
	/** 属性商品代码/商品代码 */
	@Column(name = "clauseCode")
	private String clauseCode ;
	/** 属性签单币种/签单币种 */
	@Column(name = "currency2")
	private String currency2 ;
	/** 属性自负额单位类别代码/自负额单位类别代码 */
	@Column(name = "deductibleType")
	private String deductibleType ;
	/** 属性优惠业务费/优惠业务费 */
	@Column(name = "discountCharge")
	private Double discountCharge ;
	/** 属性endorType/endorType */
	@Column(name = "endorType")
	private String endorType ;
	/** 属性原币和打印币别兑换率/原币和打印币别兑换率 */
	@Column(name = "exchangeRate2")
	private Double exchangeRate2 ;
	/** 属性签单币种与本位币种的兑换率/签单币种与本位币种的兑换率 */
	@Column(name = "exchangeRateCNY")
	private Double exchangeRateCNY ;
	/** 属性被保险人价值类型/被保险人价值类型 */
	@Column(name = "insuredValueType")
	private String insuredValueType ;
	/** 属性被保险人价值类型名称/被保险人价值类型名称 */
	@Column(name = "insuredValueTypeName")
	private String insuredValueTypeName ;
	/** 属性调整后纯保费/调整后纯保费 */
	@Column(name = "lastPurePremium")
	private Double lastPurePremium ;
	/** 属性lowerRate/lowerRate */
	@Column(name = "lowerRate")
	private String lowerRate ;
	/** 属性业务费/业务费 */
	@Column(name = "manageCharge")
	private Double manageCharge ;
	/** 属性车队录入折扣率/车队录入折扣率 */
	@Column(name = "motorRate")
	private Double motorRate ;
	/** 属性新终止日期/新终止日期 */
	@Column(name = "newEndDate")
	private Date newEndDate ;
	/** 属性新开始日期/新开始日期 */
	@Column(name = "newStartDate")
	private Date newStartDate ;
	/** 属性批改前折合打印币别总保费/批改前折合打印币别总保费 */
	@Column(name = "premium2")
	private Double premium2 ;
	/** 属性保险费CNY/保险费CNY */
	@Column(name = "premiumCNY")
	private Double premiumCny ;
	/** 属性商品代码1/商品代码1 */
	@Column(name = "productCode")
	private String productCode ;
	/** 属性利益比例/利益比例 */
	@Column(name = "profitScale")
	private Double profitScale ;
	/** 属性基本纯保费/基本纯保费 */
	@Column(name = "purePremium")
	private Double purePremium ;
	/** 属性规章制度/规章制度 */
	@Column(name = "rateType")
	private String rateType ;
	/** 属性费率实施年月/费率实施年月 */
	@Column(name = "rateValidDate")
	private String rateValidDate ;
	/** 属性特别补偿基金/特别补偿基金 */
	@Column(name = "reliefFund")
	private Double reliefFund ;
	/** 属性特别补偿基金比率/特别补偿基金比率 */
	@Column(name = "reliefFundRate")
	private Double reliefFundRate ;
	/** 属性备查文案号/备查文案号 */
	@Column(name = "replyNo")
	private String replyNo ;
	/** 属性健全费/健全费 */
	@Column(name = "specialCharge")
	private Double specialCharge ;
	/** 属性安定基金/安定基金 */
	@Column(name = "stabilityFund")
	private Double stabilityFund ;
	/** 属性costPrem/costPrem */
	@Column(name = "costPrem")
	private Integer costPrem ;
	/** 属性costDiscount/costDiscount */
	@Column(name = "costDiscount")
	private Integer costDiscount ;
	/** 属性recommenDiscount/recommenDiscount */
	@Column(name = "recommenDiscount")
	private Integer recommenDiscount ;
	/** 属性expDiscount/expDiscount */
	@Column(name = "expDiscount")
	private Integer expDiscount ;
	/** 属性uwritingDiscount/uwritingDiscount */
	@Column(name = "uwritingDiscount")
	private Integer uwritingDiscount ;
	/** 属性修改人/修改人 */
	@Column(name = "update_by")
	private String update_By ;
	/** 属性修改时间/修改时间 */
	@Column(name = "update_date")
	private Date update_Date ;
	/** 属性不含税保费/不含税保费 */
	@Column(name = "noTaxPremium")
	private Double noTaxPremium ;
	/** 属性应/免税标识，1-应税，2-免税/应/免税标识，1-应税，2-免税 */
	@Column(name = "taxFlag")
	private String taxFlag ;
	/** 属性税率/税率 */
	@Column(name = "taxRate")
	private Double taxRate ;
	/** 属性税额/税额 */
	@Column(name = "taxFee")
	private Double taxFee ;
	/** 属性不含税保费变化量/不含税保费变化量 */
	@Column(name = "chgNoTaxPremium")
	private Double chgNoTaxPremium ;
	/** 属性税额变化量/税额变化量 */
	@Column(name = "chgTaxFee")
	private Double chgTaxFee ;
	/** 属性保费计算方式/保费计算方式 */
	@Column(name = "premiumCalMethod")
	private String premiumCalMethod ;
	/** 属性林木用途/林木用途 */
	@Column(name = "forestUse")
	private String forestUse ;
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
	 * 属性 保单号码/ 保单号码的getter方法
	 */
	public String getRiskCode() {
		return riskCode;
	}
	/**
	 * 属性 保单号码/ 保单号码的setter方法
	 */
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}
	/**
	 * 属性 险种代码/ 险种代码的getter方法
	 */
	public String getItemKindNo() {
		return itemKindNo;
	}
	/**
	 * 属性 险种代码/ 险种代码的setter方法
	 */
	public void setItemKindNo(String itemKindNo) {
		this.itemKindNo = itemKindNo;
	}
	/**
	 * 属性序号/序号的getter方法
	 */
	public Integer getFamilyNo() {
		return familyNo;
	}
	/**
	 * 属性序号/序号的setter方法
	 */
	public void setFamilyNo(Integer familyNo) {
		this.familyNo = familyNo;
	}
	/**
	 * 属性分户序号(仅用于集体家财险)/分户序号(仅用于集体家财险)的getter方法
	 */
	public String getFamilyName() {
		return familyName;
	}
	/**
	 * 属性分户序号(仅用于集体家财险)/分户序号(仅用于集体家财险)的setter方法
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
	 * 属性分户名称(仅用于集体家财险)--** 集装箱体保险时为集装箱编号--** 船舶险时为船名/分户名称(仅用于集体家财险)--** 集装箱体保险时为集装箱编号--** 船舶险时为船名的getter方法
	 */
	public String getKindCode() {
		return kindCode;
	}
	/**
	 * 属性分户名称(仅用于集体家财险)--** 集装箱体保险时为集装箱编号--** 船舶险时为船名/分户名称(仅用于集体家财险)--** 集装箱体保险时为集装箱编号--** 船舶险时为船名的setter方法
	 */
	public void setKindCode(String kindCode) {
		this.kindCode = kindCode;
	}
	/**
	 * 属性险别代码/险别代码的getter方法
	 */
	public String getKindName() {
		return kindName;
	}
	/**
	 * 属性险别代码/险别代码的setter方法
	 */
	public void setKindName(String kindName) {
		this.kindName = kindName;
	}
	/**
	 * 属性险别名称/险别名称的getter方法
	 */
	public Integer getItemNo() {
		return itemNo;
	}
	/**
	 * 属性险别名称/险别名称的setter方法
	 */
	public void setItemNo(Integer itemNo) {
		this.itemNo = itemNo;
	}
	/**
	 * 属性标的序号/标的序号的getter方法
	 */
	public String getItemCode() {
		return itemCode;
	}
	/**
	 * 属性标的序号/标的序号的setter方法
	 */
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	/**
	 * 属性标的项目类别代码 ▲--** 林木种类代码/标的项目类别代码 ▲--** 林木种类代码的getter方法
	 */
	public String getItemDetailName() {
		return itemDetailName;
	}
	/**
	 * 属性标的项目类别代码 ▲--** 林木种类代码/标的项目类别代码 ▲--** 林木种类代码的setter方法
	 */
	public void setItemDetailName(String itemDetailName) {
		this.itemDetailName = itemDetailName;
	}
	/**
	 * 属性标的项目明细名称--** 林木种类名称/标的项目明细名称--** 林木种类名称的getter方法
	 */
	public String getModeCode() {
		return modeCode;
	}
	/**
	 * 属性标的项目明细名称--** 林木种类名称/标的项目明细名称--** 林木种类名称的setter方法
	 */
	public void setModeCode(String modeCode) {
		this.modeCode = modeCode;
	}
	/**
	 * 属性投保方式代码▲--** 金牛险:--** PrpDration.RationType--** 养殖险: 何价投保--** 车险：玻璃类别/投保方式代码▲--** 金牛险:--** PrpDration.RationType--** 养殖险: 何价投保--** 车险：玻璃类别的getter方法
	 */
	public String getModeName() {
		return modeName;
	}
	/**
	 * 属性投保方式代码▲--** 金牛险:--** PrpDration.RationType--** 养殖险: 何价投保--** 车险：玻璃类别/投保方式代码▲--** 金牛险:--** PrpDration.RationType--** 养殖险: 何价投保--** 车险：玻璃类别的setter方法
	 */
	public void setModeName(String modeName) {
		this.modeName = modeName;
	}

	/**
	 * 属性单位保费变化量/单位保费变化量的getter方法
	 */
	public Double getUnitPremium() {
		return unitPremium;
	}
	/**
	 * 属性单位保费变化量/单位保费变化量的setter方法
	 */
	public void setUnitPremium(Double unitPremium) {
		this.unitPremium = unitPremium;
	}
	/**
	 * 属性单位保费/单位保费的getter方法
	 */
	public Double getChgUnitPremium() {
		return chgUnitPremium;
	}
	/**
	 * 属性单位保费/单位保费的setter方法
	 */
	public void setChgUnitPremium(Double chgUnitPremium) {
		this.chgUnitPremium = chgUnitPremium;
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
	 * 属性绝对免赔额/绝对免赔额的getter方法
	 */
	public Double getDeductibleValue() {
		return deductibleValue;
	}
	/**
	 * 属性绝对免赔额/绝对免赔额的setter方法
	 */
	public void setDeductibleValue(Double deductibleValue) {
		this.deductibleValue = deductibleValue;
	}
	/**
	 * 属性绝对免赔额费率折扣系数/绝对免赔额费率折扣系数的getter方法
	 */
	public Double getDeductibleDiscount() {
		return deductibleDiscount;
	}
	/**
	 * 属性绝对免赔额费率折扣系数/绝对免赔额费率折扣系数的setter方法
	 */
	public void setDeductibleDiscount(Double deductibleDiscount) {
		this.deductibleDiscount = deductibleDiscount;
	}

	/**
	 * 属性分摊M险的基准保费值/分摊M险的基准保费值的getter方法
	 */
	public Double getKindPremiumm() {
		return kindPremiumm;
	}
	/**
	 * 属性分摊M险的基准保费值/分摊M险的基准保费值的setter方法
	 */
	public void setKindPremiumm(Double kindPremiumm) {
		this.kindPremiumm = kindPremiumm;
	}
	/**
	 * 属性乘客责任限额/乘客责任限额的getter方法
	 */
	public Double getGuestAmount() {
		return guestAmount;
	}
	/**
	 * 属性乘客责任限额/乘客责任限额的setter方法
	 */
	public void setGuestAmount(Double guestAmount) {
		this.guestAmount = guestAmount;
	}
	/**
	 * 属性驾驶人责任限额/驾驶人责任限额的getter方法
	 */
	public Double getDriverAmount() {
		return driverAmount;
	}
	/**
	 * 属性驾驶人责任限额/驾驶人责任限额的setter方法
	 */
	public void setDriverAmount(Double driverAmount) {
		this.driverAmount = driverAmount;
	}
	/**
	 * 属性第三者责任限额/第三者责任限额的getter方法
	 */
	public Double getThirdPeopleAmount() {
		return thirdPeopleAmount;
	}
	/**
	 * 属性第三者责任限额/第三者责任限额的setter方法
	 */
	public void setThirdPeopleAmount(Double thirdPeopleAmount) {
		this.thirdPeopleAmount = thirdPeopleAmount;
	}
	/**
	 * 属性是否特殊材质玻璃/是否特殊材质玻璃的getter方法
	 */
	public String getIsSpecGlass() {
		return isSpecGlass;
	}
	/**
	 * 属性是否特殊材质玻璃/是否特殊材质玻璃的setter方法
	 */
	public void setIsSpecGlass(String isSpecGlass) {
		this.isSpecGlass = isSpecGlass;
	}
	/**
	 * 属性安定基金比率/安定基金比率的getter方法
	 */
	public Double getStabilityFundRate() {
		return stabilityFundRate;
	}
	/**
	 * 属性安定基金比率/安定基金比率的setter方法
	 */
	public void setStabilityFundRate(Double stabilityFundRate) {
		this.stabilityFundRate = stabilityFundRate;
	}
	/**
	 * 属性存储率/存储率的getter方法
	 */
	public Double getStorageRate() {
		return storageRate;
	}
	/**
	 * 属性存储率/存储率的setter方法
	 */
	public void setStorageRate(Double storageRate) {
		this.storageRate = storageRate;
	}
	/**
	 * 属性structureNo/structureNo的getter方法
	 */
	public Integer getStructureNo() {
		return structureNo;
	}
	/**
	 * 属性structureNo/structureNo的setter方法
	 */
	public void setStructureNo(Integer structureNo) {
		this.structureNo = structureNo;
	}
	/**
	 * 属性优惠业务费变化量/优惠业务费变化量的getter方法
	 */
	public Double getChgDiscountCharge() {
		return chgDiscountCharge;
	}
	/**
	 * 属性优惠业务费变化量/优惠业务费变化量的setter方法
	 */
	public void setChgDiscountCharge(Double chgDiscountCharge) {
		this.chgDiscountCharge = chgDiscountCharge;
	}
	/**
	 * 属性调整后纯保费变化量/调整后纯保费变化量的getter方法
	 */
	public Double getChgLastPurePremium() {
		return chgLastPurePremium;
	}
	/**
	 * 属性调整后纯保费变化量/调整后纯保费变化量的setter方法
	 */
	public void setChgLastPurePremium(Double chgLastPurePremium) {
		this.chgLastPurePremium = chgLastPurePremium;
	}
	/**
	 * 属性业务费变化量/业务费变化量的getter方法
	 */
	public Double getChgManageCharge() {
		return chgManageCharge;
	}
	/**
	 * 属性业务费变化量/业务费变化量的setter方法
	 */
	public void setChgManageCharge(Double chgManageCharge) {
		this.chgManageCharge = chgManageCharge;
	}
	/**
	 * 属性折合打印币别总保费变化量/折合打印币别总保费变化量的getter方法
	 */
	public Double getChgPremium2() {
		return chgPremium2;
	}
	/**
	 * 属性折合打印币别总保费变化量/折合打印币别总保费变化量的setter方法
	 */
	public void setChgPremium2(Double chgPremium2) {
		this.chgPremium2 = chgPremium2;
	}

	/**
	 * 属性基本纯保费变化量/基本纯保费变化量的getter方法
	 */
	public Double getChgPurePremium() {
		return chgPurePremium;
	}
	/**
	 * 属性基本纯保费变化量/基本纯保费变化量的setter方法
	 */
	public void setChgPurePremium(Double chgPurePremium) {
		this.chgPurePremium = chgPurePremium;
	}
	/**
	 * 属性特别补偿基金变化量/特别补偿基金变化量的getter方法
	 */
	public Double getChgReliefFund() {
		return chgReliefFund;
	}
	/**
	 * 属性特别补偿基金变化量/特别补偿基金变化量的setter方法
	 */
	public void setChgReliefFund(Double chgReliefFund) {
		this.chgReliefFund = chgReliefFund;
	}
	/**
	 * 属性健全费变化量/健全费变化量的getter方法
	 */
	public Double getChgSpecialCharge() {
		return chgSpecialCharge;
	}
	/**
	 * 属性健全费变化量/健全费变化量的setter方法
	 */
	public void setChgSpecialCharge(Double chgSpecialCharge) {
		this.chgSpecialCharge = chgSpecialCharge;
	}
	/**
	 * 属性安定基金变化量/安定基金变化量的getter方法
	 */
	public Double getChgStabilityFund() {
		return chgStabilityFund;
	}
	/**
	 * 属性安定基金变化量/安定基金变化量的setter方法
	 */
	public void setChgStabilityFund(Double chgStabilityFund) {
		this.chgStabilityFund = chgStabilityFund;
	}
	/**
	 * 属性商品代码/商品代码的getter方法
	 */
	public String getClauseCode() {
		return clauseCode;
	}
	/**
	 * 属性商品代码/商品代码的setter方法
	 */
	public void setClauseCode(String clauseCode) {
		this.clauseCode = clauseCode;
	}
	/**
	 * 属性签单币种/签单币种的getter方法
	 */
	public String getCurrency2() {
		return currency2;
	}
	/**
	 * 属性签单币种/签单币种的setter方法
	 */
	public void setCurrency2(String currency2) {
		this.currency2 = currency2;
	}
	/**
	 * 属性自负额单位类别代码/自负额单位类别代码的getter方法
	 */
	public String getDeductibleType() {
		return deductibleType;
	}
	/**
	 * 属性自负额单位类别代码/自负额单位类别代码的setter方法
	 */
	public void setDeductibleType(String deductibleType) {
		this.deductibleType = deductibleType;
	}
	/**
	 * 属性优惠业务费/优惠业务费的getter方法
	 */
	public Double getDiscountCharge() {
		return discountCharge;
	}
	/**
	 * 属性优惠业务费/优惠业务费的setter方法
	 */
	public void setDiscountCharge(Double discountCharge) {
		this.discountCharge = discountCharge;
	}
	/**
	 * 属性endorType/endorType的getter方法
	 */
	public String getEndorType() {
		return endorType;
	}
	/**
	 * 属性endorType/endorType的setter方法
	 */
	public void setEndorType(String endorType) {
		this.endorType = endorType;
	}
	/**
	 * 属性原币和打印币别兑换率/原币和打印币别兑换率的getter方法
	 */
	public Double getExchangeRate2() {
		return exchangeRate2;
	}
	/**
	 * 属性原币和打印币别兑换率/原币和打印币别兑换率的setter方法
	 */
	public void setExchangeRate2(Double exchangeRate2) {
		this.exchangeRate2 = exchangeRate2;
	}

	/**
	 * 属性被保险人价值类型/被保险人价值类型的getter方法
	 */
	public String getInsuredValueType() {
		return insuredValueType;
	}
	/**
	 * 属性被保险人价值类型/被保险人价值类型的setter方法
	 */
	public void setInsuredValueType(String insuredValueType) {
		this.insuredValueType = insuredValueType;
	}
	/**
	 * 属性被保险人价值类型名称/被保险人价值类型名称的getter方法
	 */
	public String getInsuredValueTypeName() {
		return insuredValueTypeName;
	}
	/**
	 * 属性被保险人价值类型名称/被保险人价值类型名称的setter方法
	 */
	public void setInsuredValueTypeName(String insuredValueTypeName) {
		this.insuredValueTypeName = insuredValueTypeName;
	}
	/**
	 * 属性调整后纯保费/调整后纯保费的getter方法
	 */
	public Double getLastPurePremium() {
		return lastPurePremium;
	}
	/**
	 * 属性调整后纯保费/调整后纯保费的setter方法
	 */
	public void setLastPurePremium(Double lastPurePremium) {
		this.lastPurePremium = lastPurePremium;
	}
	/**
	 * 属性lowerRate/lowerRate的getter方法
	 */
	public String getLowerRate() {
		return lowerRate;
	}
	/**
	 * 属性lowerRate/lowerRate的setter方法
	 */
	public void setLowerRate(String lowerRate) {
		this.lowerRate = lowerRate;
	}
	/**
	 * 属性业务费/业务费的getter方法
	 */
	public Double getManageCharge() {
		return manageCharge;
	}
	/**
	 * 属性业务费/业务费的setter方法
	 */
	public void setManageCharge(Double manageCharge) {
		this.manageCharge = manageCharge;
	}
	/**
	 * 属性车队录入折扣率/车队录入折扣率的getter方法
	 */
	public Double getMotorRate() {
		return motorRate;
	}
	/**
	 * 属性车队录入折扣率/车队录入折扣率的setter方法
	 */
	public void setMotorRate(Double motorRate) {
		this.motorRate = motorRate;
	}

	public Date getNewEndDate() {
		return newEndDate;
	}

	public void setNewEndDate(Date newEndDate) {
		this.newEndDate = newEndDate;
	}

	/**
	 * 属性新开始日期/新开始日期的getter方法
	 */
	public Date getNewStartDate() {
		return newStartDate;
	}
	/**
	 * 属性新开始日期/新开始日期的setter方法
	 */
	public void setNewStartDate(Date newStartDate) {
		this.newStartDate = newStartDate;
	}
	/**
	 * 属性批改前折合打印币别总保费/批改前折合打印币别总保费的getter方法
	 */
	public Double getPremium2() {
		return premium2;
	}
	/**
	 * 属性批改前折合打印币别总保费/批改前折合打印币别总保费的setter方法
	 */
	public void setPremium2(Double premium2) {
		this.premium2 = premium2;
	}

	/**
	 * 属性商品代码1/商品代码1的getter方法
	 */
	public String getProductCode() {
		return productCode;
	}
	/**
	 * 属性商品代码1/商品代码1的setter方法
	 */
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	/**
	 * 属性利益比例/利益比例的getter方法
	 */
	public Double getProfitScale() {
		return profitScale;
	}
	/**
	 * 属性利益比例/利益比例的setter方法
	 */
	public void setProfitScale(Double profitScale) {
		this.profitScale = profitScale;
	}
	/**
	 * 属性基本纯保费/基本纯保费的getter方法
	 */
	public Double getPurePremium() {
		return purePremium;
	}
	/**
	 * 属性基本纯保费/基本纯保费的setter方法
	 */
	public void setPurePremium(Double purePremium) {
		this.purePremium = purePremium;
	}
	/**
	 * 属性规章制度/规章制度的getter方法
	 */
	public String getRateType() {
		return rateType;
	}
	/**
	 * 属性规章制度/规章制度的setter方法
	 */
	public void setRateType(String rateType) {
		this.rateType = rateType;
	}
	/**
	 * 属性费率实施年月/费率实施年月的getter方法
	 */
	public String getRateValidDate() {
		return rateValidDate;
	}
	/**
	 * 属性费率实施年月/费率实施年月的setter方法
	 */
	public void setRateValidDate(String rateValidDate) {
		this.rateValidDate = rateValidDate;
	}
	/**
	 * 属性特别补偿基金/特别补偿基金的getter方法
	 */
	public Double getReliefFund() {
		return reliefFund;
	}
	/**
	 * 属性特别补偿基金/特别补偿基金的setter方法
	 */
	public void setReliefFund(Double reliefFund) {
		this.reliefFund = reliefFund;
	}
	/**
	 * 属性特别补偿基金比率/特别补偿基金比率的getter方法
	 */
	public Double getReliefFundRate() {
		return reliefFundRate;
	}
	/**
	 * 属性特别补偿基金比率/特别补偿基金比率的setter方法
	 */
	public void setReliefFundRate(Double reliefFundRate) {
		this.reliefFundRate = reliefFundRate;
	}
	/**
	 * 属性备查文案号/备查文案号的getter方法
	 */
	public String getReplyNo() {
		return replyNo;
	}
	/**
	 * 属性备查文案号/备查文案号的setter方法
	 */
	public void setReplyNo(String replyNo) {
		this.replyNo = replyNo;
	}
	/**
	 * 属性健全费/健全费的getter方法
	 */
	public Double getSpecialCharge() {
		return specialCharge;
	}
	/**
	 * 属性健全费/健全费的setter方法
	 */
	public void setSpecialCharge(Double specialCharge) {
		this.specialCharge = specialCharge;
	}
	/**
	 * 属性安定基金/安定基金的getter方法
	 */
	public Double getStabilityFund() {
		return stabilityFund;
	}
	/**
	 * 属性安定基金/安定基金的setter方法
	 */
	public void setStabilityFund(Double stabilityFund) {
		this.stabilityFund = stabilityFund;
	}
	/**
	 * 属性costPrem/costPrem的getter方法
	 */
	public Integer getCostPrem() {
		return costPrem;
	}
	/**
	 * 属性costPrem/costPrem的setter方法
	 */
	public void setCostPrem(Integer costPrem) {
		this.costPrem = costPrem;
	}
	/**
	 * 属性costDiscount/costDiscount的getter方法
	 */
	public Integer getCostDiscount() {
		return costDiscount;
	}
	/**
	 * 属性costDiscount/costDiscount的setter方法
	 */
	public void setCostDiscount(Integer costDiscount) {
		this.costDiscount = costDiscount;
	}
	/**
	 * 属性recommenDiscount/recommenDiscount的getter方法
	 */
	public Integer getRecommenDiscount() {
		return recommenDiscount;
	}
	/**
	 * 属性recommenDiscount/recommenDiscount的setter方法
	 */
	public void setRecommenDiscount(Integer recommenDiscount) {
		this.recommenDiscount = recommenDiscount;
	}
	/**
	 * 属性expDiscount/expDiscount的getter方法
	 */
	public Integer getExpDiscount() {
		return expDiscount;
	}
	/**
	 * 属性expDiscount/expDiscount的setter方法
	 */
	public void setExpDiscount(Integer expDiscount) {
		this.expDiscount = expDiscount;
	}

	public Double getBenchmarkPremium() {
		return benchmarkPremium;
	}

	public void setBenchmarkPremium(Double benchmarkPremium) {
		this.benchmarkPremium = benchmarkPremium;
	}

	public Double getTotalLossRatio() {
		return totalLossRatio;
	}

	public void setTotalLossRatio(Double totalLossRatio) {
		this.totalLossRatio = totalLossRatio;
	}

	public Double getLawsuitAmount() {
		return lawsuitAmount;
	}

	public void setLawsuitAmount(Double lawsuitAmount) {
		this.lawsuitAmount = lawsuitAmount;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Integer getStartHour() {
		return startHour;
	}

	public void setStartHour(Integer startHour) {
		this.startHour = startHour;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Integer getEndHour() {
		return endHour;
	}

	public void setEndHour(Integer endHour) {
		this.endHour = endHour;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Date getBuyDate() {
		return buyDate;
	}

	public void setBuyDate(Date buyDate) {
		this.buyDate = buyDate;
	}

	public Integer getAddressNo() {
		return addressNo;
	}

	public void setAddressNo(Integer addressNo) {
		this.addressNo = addressNo;
	}

	public String getCalculateFlag() {
		return calculateFlag;
	}

	public void setCalculateFlag(String calculateFlag) {
		this.calculateFlag = calculateFlag;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Double getUnitAmount() {
		return unitAmount;
	}

	public void setUnitAmount(Double unitAmount) {
		this.unitAmount = unitAmount;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Integer getRatePeriod() {
		return ratePeriod;
	}

	public void setRatePeriod(Integer ratePeriod) {
		this.ratePeriod = ratePeriod;
	}

	public Double getRate() {
		return rate;
	}

	public void setRate(Double rate) {
		this.rate = rate;
	}

	public String getShortRateFlag() {
		return shortRateFlag;
	}

	public void setShortRateFlag(String shortRateFlag) {
		this.shortRateFlag = shortRateFlag;
	}

	public Double getShortRate() {
		return shortRate;
	}

	public void setShortRate(Double shortRate) {
		this.shortRate = shortRate;
	}

	public Double getBasePremium() {
		return basePremium;
	}

	public void setBasePremium(Double basePremium) {
		this.basePremium = basePremium;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public Double getAdjustRate() {
		return adjustRate;
	}

	public void setAdjustRate(Double adjustRate) {
		this.adjustRate = adjustRate;
	}

	public Double getPremium() {
		return premium;
	}

	public void setPremium(Double premium) {
		this.premium = premium;
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

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public Double getChgQuantity() {
		return chgQuantity;
	}

	public void setChgQuantity(Double chgQuantity) {
		this.chgQuantity = chgQuantity;
	}

	public Double getChgAmount() {
		return chgAmount;
	}

	public void setChgAmount(Double chgAmount) {
		this.chgAmount = chgAmount;
	}

	public Double getChgPremium() {
		return chgPremium;
	}

	public void setChgPremium(Double chgPremium) {
		this.chgPremium = chgPremium;
	}

	public String getRegionRate() {
		return regionRate;
	}

	public void setRegionRate(String regionRate) {
		this.regionRate = regionRate;
	}

	public Integer getDrinkRate() {
		return drinkRate;
	}

	public void setDrinkRate(Integer drinkRate) {
		this.drinkRate = drinkRate;
	}

	public Integer getDrunkRate() {
		return drunkRate;
	}

	public void setDrunkRate(Integer drunkRate) {
		this.drunkRate = drunkRate;
	}

	public String getCattleType() {
		return cattleType;
	}

	public void setCattleType(String cattleType) {
		this.cattleType = cattleType;
	}

	public Double getUnitPersonLimitAmount() {
		return unitPersonLimitAmount;
	}

	public void setUnitPersonLimitAmount(Double unitPersonLimitAmount) {
		this.unitPersonLimitAmount = unitPersonLimitAmount;
	}

	public Double getUnitPersonAmount() {
		return unitPersonAmount;
	}

	public void setUnitPersonAmount(Double unitPersonAmount) {
		this.unitPersonAmount = unitPersonAmount;
	}

	public Double getUnitDayAmountSub() {
		return unitDayAmountSub;
	}

	public void setUnitDayAmountSub(Double unitDayAmountSub) {
		this.unitDayAmountSub = unitDayAmountSub;
	}

	public Integer getDaySub() {
		return daySub;
	}

	public void setDaySub(Integer daySub) {
		this.daySub = daySub;
	}

	public String getPersonType() {
		return personType;
	}

	public void setPersonType(String personType) {
		this.personType = personType;
	}

	public Double getTriggerPoint() {
		return triggerPoint;
	}

	public void setTriggerPoint(Double triggerPoint) {
		this.triggerPoint = triggerPoint;
	}

	public Integer getBedNum() {
		return bedNum;
	}

	public void setBedNum(Integer bedNum) {
		this.bedNum = bedNum;
	}

	public Double getBedPremium() {
		return bedPremium;
	}

	public void setBedPremium(Double bedPremium) {
		this.bedPremium = bedPremium;
	}

	public Double getHospitalPremium() {
		return hospitalPremium;
	}

	public void setHospitalPremium(Double hospitalPremium) {
		this.hospitalPremium = hospitalPremium;
	}

	public Integer getKindWorkerNum() {
		return kindWorkerNum;
	}

	public void setKindWorkerNum(Integer kindWorkerNum) {
		this.kindWorkerNum = kindWorkerNum;
	}

	public Double getKindWorkerPremium() {
		return kindWorkerPremium;
	}

	public void setKindWorkerPremium(Double kindWorkerPremium) {
		this.kindWorkerPremium = kindWorkerPremium;
	}

	public Integer getClinicNum() {
		return clinicNum;
	}

	public void setClinicNum(Integer clinicNum) {
		this.clinicNum = clinicNum;
	}

	public Double getClinicPremium() {
		return clinicPremium;
	}

	public void setClinicPremium(Double clinicPremium) {
		this.clinicPremium = clinicPremium;
	}

	public Integer getnClinicNum() {
		return nClinicNum;
	}

	public void setnClinicNum(Integer nClinicNum) {
		this.nClinicNum = nClinicNum;
	}

	public Double getnClinicPremium() {
		return nClinicPremium;
	}

	public void setnClinicPremium(Double nClinicPremium) {
		this.nClinicPremium = nClinicPremium;
	}

	public Integer getRoomNum() {
		return roomNum;
	}

	public void setRoomNum(Integer roomNum) {
		this.roomNum = roomNum;
	}

	public Double getRoomPremium() {
		return roomPremium;
	}

	public void setRoomPremium(Double roomPremium) {
		this.roomPremium = roomPremium;
	}

	public Integer getNurseNum() {
		return nurseNum;
	}

	public void setNurseNum(Integer nurseNum) {
		this.nurseNum = nurseNum;
	}

	public Double getNursePremium() {
		return nursePremium;
	}

	public void setNursePremium(Double nursePremium) {
		this.nursePremium = nursePremium;
	}

	public Double getWorkerPremium() {
		return workerPremium;
	}

	public void setWorkerPremium(Double workerPremium) {
		this.workerPremium = workerPremium;
	}

	public Integer getWorkerNum() {
		return workerNum;
	}

	public void setWorkerNum(Integer workerNum) {
		this.workerNum = workerNum;
	}

	public Double getQuantityNewborn() {
		return quantityNewborn;
	}

	public void setQuantityNewborn(Double quantityNewborn) {
		this.quantityNewborn = quantityNewborn;
	}

	public String getChargeNewbornFlag() {
		return chargeNewbornFlag;
	}

	public void setChargeNewbornFlag(String chargeNewbornFlag) {
		this.chargeNewbornFlag = chargeNewbornFlag;
	}

	public Double getPremiumCny() {
		return premiumCny;
	}

	public void setPremiumCny(Double premiumCny) {
		this.premiumCny = premiumCny;
	}

	public Double getKindBenchmarkPremiumm() {
		return kindBenchmarkPremiumm;
	}

	public void setKindBenchmarkPremiumm(Double kindBenchmarkPremiumm) {
		this.kindBenchmarkPremiumm = kindBenchmarkPremiumm;
	}

	public Double getChgPremiumCNY() {
		return chgPremiumCNY;
	}

	public void setChgPremiumCNY(Double chgPremiumCNY) {
		this.chgPremiumCNY = chgPremiumCNY;
	}

	public Double getExchangeRateCNY() {
		return exchangeRateCNY;
	}

	public void setExchangeRateCNY(Double exchangeRateCNY) {
		this.exchangeRateCNY = exchangeRateCNY;
	}


	public Integer getUwritingDiscount() {
		return uwritingDiscount;
	}

	public void setUwritingDiscount(Integer uwritingDiscount) {
		this.uwritingDiscount = uwritingDiscount;
	}

	public String getUpdate_By() {
		return update_By;
	}

	public void setUpdate_By(String update_By) {
		this.update_By = update_By;
	}

	public Date getUpdate_Date() {
		return update_Date;
	}

	public void setUpdate_Date(Date update_Date) {
		this.update_Date = update_Date;
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

	public String getPolicyNo() {
		return policyNo;
	}

	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}
}