package com.sinosoft.agriprpall.core.proposalmanage.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;

import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-18 03:10:49.566 
 * 标的子险信息实体操作对象
 */
@Entity
@Table(name = "PrpTitemKind")
@IdClass(PrpTitemKindKey.class)
public class PrpTitemKind extends BaseEntityImpl {

	private static final long serialVersionUID = 1L;
	/**
	 * 属性投保单号码/投保单号码
	 */
	@Id
	@Column(name = "proposalNo")
	private String proposalNo;
	/**
	 * 属性序号/序号
	 */
	@Id
	@Column(name = "itemKindNo")
	private Integer itemKindNo;

	/**
	 * 属性险种代码/险种代码
	 */
	@Column(name = "riskCode")
	private String riskCode;

	/**
	 * 属性分户序号(仅用于集体家财险)/分户序号(仅用于集体家财险)
	 */
	@Column(name = "familyNo")
	private Integer familyNo;
	/**
	 * 属性分户名称(仅用于集体家财险)--**集装箱体保险时为集装箱编号--** 船舶险时为船名/分户名称(仅用于集体家财险)--**集装箱体保险时为集装箱编号--** 船舶险时为船名
	 */
	@Column(name = "familyName")
	private String familyName;
	/**
	 * 属性rationType/rationType
	 */
	@Column(name = "rationType")
	private String rationType;
	/**
	 * 属性险别代码/险别代码
	 */
	@Column(name = "kindCode")
	private String kindCode;
	/**
	 * 属性险别名称/险别名称
	 */
	@Column(name = "kindName")
	private String kindName;
	/**
	 * 属性标的序号/标的序号
	 */
	@Column(name = "itemNo")
	private Integer itemNo;
	/**
	 * 属性标的项目类别代码/标的项目类别代码
	 */
	@Column(name = "itemCode")
	private String itemCode;
	/**
	 * 属性标的项目明细名称/标的项目明细名称
	 */
	@Column(name = "itemDetailName")
	private String itemDetailName;
	/**
	 * 属性投保方式代码/投保方式代码
	 */
	@Column(name = "modeCode")
	private String modeCode;
	/**
	 * 属性投保方式名称/投保方式名称
	 */
	@Column(name = "modeName")
	private String modeName;
	/**
	 * 属性起保日期/起保日期
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "startDate")
	private Date startDate;
	/**
	 * 属性起保小时/起保小时
	 */
	@Column(name = "startHour")
	private Integer startHour;
	/**
	 * 属性终保日期/终保日期
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "endDate")
	private Date endDate;
	/**
	 * 属性终保小时/终保小时
	 */
	@Column(name = "endHour")
	private Integer endHour;
	/**
	 * 属性规格型号/规格型号
	 */
	@Column(name = "model")
	private String model;
	/**
	 * 属性购买日期/购买日期
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "buyDate")
	private Date buyDate;
	/**
	 * 属性地址序号/地址序号
	 */
	@Column(name = "addressNo")
	private Integer addressNo;
	/**
	 * 属性是否计算保额标志(Y/N)/是否计算保额标志(Y/N)
	 */
	@Column(name = "calculateFlag")
	private String calculateFlag;
	/**
	 * 属性币别 /币别
	 */
	@Column(name = "currency")
	private String currency;
	/**
	 * 属性单位保险金额（赔偿限额）/单位保险金额（赔偿限额）
	 */
	@Column(name = "unitAmount")
	private Double unitAmount;
	/**
	 * 属性数量(人数/产品数量/户数)/数量(人数/产品数量/户数)
	 */
	@Column(name = "quantity")
	private Double quantity;
	/**
	 * 属性数量单位/数量单位
	 */
	@Column(name = "unit")
	private String unit;
	/**
	 * 属性保险价值/保险价值
	 */
	@Column(name = "value")
	private Double value;
	/**
	 * 属性保险金额/赔偿限额/保险金额/赔偿限额
	 */
	@Column(name = "amount")
	private Double amount;
	/**
	 * 属性适应费率期数/适应费率期数
	 */
	@Column(name = "ratePeriod")
	private Integer ratePeriod;
	/**
	 * 属性费率/费率
	 */
	@Column(name = "rate")
	private Double rate;
	/**
	 * 属性短期费率标志/短期费率标志
	 */
	@Column(name = "shortRateFlag")
	private String shortRateFlag;
	/**
	 * 属性短期费率/短期费率
	 */
	@Column(name = "shortRate")
	private Double shortRate;
	/**
	 * 属性基准保费/基准保费
	 */
	@Column(name = "basePremium")
	private Double basePremium;
	/**
	 * 属性折扣率/折扣率 benchmark基准
	 */
	@Column(name = "benchmarkPremium")
	private Double benchmarkPremium;
	/**
	 * 属性保费调整比率(%)/保费调整比率(%)
	 */
	@Column(name = "discount")
	private Double discount;
	/**
	 * 属性保费/储金/保费/储金
	 */
	@Column(name = "adjustRate")
	private Double adjustRate;
	/**
	 * 属性premium/premium
	 */
	@Column(name = "premium")
	private Double premium;
	/**
	 * 属性免赔率(%)/免赔率(%) deductible 可剔除的
	 */
	@Column(name = "deductibleRate")
	private Double deductibleRate;
	/**
	 * 属性免赔额/免赔额
	 */
	@Column(name = "deductible")
	private Double deductible;
	/**
	 * 属性标志字段--**[2] 位为主险/附加险志--** 1:主险 2:附加险 3:其他--**[3]-[4]位等于费率类型--**（RateTypeFlag）--**[5]位为不计免赔标志--**[6]法定三者标志（1）--**[7]是否虚拟标的，1是，0或者其他表示不是/标志字段--**[2] 位为主险/附加险志--** 1:主险 2:附加险 3:其他--**[3]-[4]位等于费率类型--**（RateTypeFlag）--**[5]位为不计免赔标志--**[6]法定三者标志（1）--**[7]是否虚拟标的，1是，0或者其他表示不是
	 */
	@Column(name = "flag")
	private String flag;
	/**
	 * 属性地区费率因子: 0-不浮动, 1-上浮30%/地区费率因子: 0-不浮动, 1-上浮30%
	 */
	@Column(name = "regionRate")
	private String regionRate = "0";
	/**
	 * 属性饮酒费率因子：饮酒驾驶违法次数/饮酒费率因子：饮酒驾驶违法次数
	 */
	@Column(name = "drinkRate")
	private Integer drinkRate = 0;
	/**
	 * 属性醉酒费率因子：醉酒驾驶违法次数/醉酒费率因子：醉酒驾驶违法次数
	 */
	@Column(name = "drunkRate")
	private Integer drunkRate = 0;
	/**
	 * 属性肉牛类型（3221肉牛险专用0122附加险借用0123附加险借用:玻璃类型）/肉牛类型（3221肉牛险专用0122附加险借用0123附加险借用:玻璃类型）
	 */
	@Column(name = "cattleType")
	private String cattleType;
	/**
	 * 属性每次事故每人赔偿限额 0122,0123附加险用到/每次事故每人赔偿限额 0122,0123附加险用到
	 */
	@Column(name = "unitPersonLimitAmount")
	private Double unitPersonLimitAmount;
	/**
	 * 属性每人赔偿限额0123用到/每人赔偿限额0123用到
	 */
	@Column(name = "unitPersonAmount")
	private Double unitPersonAmount;
	/**
	 * 属性日额：每人日额（元）2714,0123用/日额：每人日额（元）2714,0123用
	 */
	@Column(name = "unitDayAmountSub")
	private Double unitDayAmountSub;
	/**
	 * 属性天数：2714附加险专用0123附加险借用/天数：2714附加险专用0123附加险借用
	 */
	@Column(name = "daySub")
	private Integer daySub;
	/**
	 * 属性人员类别2606险种用到/人员类别2606险种用到
	 */
	@Column(name = "personType")
	private String personType;
	/**
	 * 属性起赔点/起赔点
	 */
	@Column(name = "triggerPoint")
	private Double triggerPoint;
	/**
	 * 属性全损损失率/全损损失率
	 */
	@Column(name = "totalLossRatio")
	private Double totalLossRatio;
	/**
	 * 属性诉讼费限额/诉讼费限额
	 */
	@Column(name = "lawsuitAmount")
	private Double lawsuitAmount;
	/**
	 * 属性病床数/病床数
	 */
	@Column(name = "bedNum")
	private Integer bedNum;
	/**
	 * 属性每张床位保险费/每张床位保险费
	 */
	@Column(name = "bedPremium")
	private Double bedPremium;
	/**
	 * 属性医疗机构保费/医疗机构保费
	 */
	@Column(name = "hospitalPremium")
	private Double hospitalPremium;
	/**
	 * 属性各类医务人员人数/各类医务人员人数
	 */
	@Column(name = "kindWorkerNum")
	private Integer kindWorkerNum;
	/**
	 * 属性各类医务人员每人保费/各类医务人员每人保费
	 */
	@Column(name = "kindWorkerPremium")
	private Double kindWorkerPremium;
	/**
	 * 属性临床手术科室医师人数/临床手术科室医师人数
	 */
	@Column(name = "clinicNum")
	private Integer clinicNum;
	/**
	 * 属性临床手术科室医师每人保费/临床手术科室医师每人保费
	 */
	@Column(name = "clinicPremium")
	private Double clinicPremium;
	/**
	 * 属性临床非手术科室医师人数/临床非手术科室医师人数
	 */
	@Column(name = "nClinicNum")
	private Integer nClinicNum;
	/**
	 * 属性临床非手术科室医师每人保费/临床非手术科室医师每人保费
	 */
	@Column(name = "nClinicPremium")
	private Double nClinicPremium;
	/**
	 * 属性医技科室人数/医技科室人数
	 */
	@Column(name = "roomNum")
	private Integer roomNum;
	/**
	 * 属性医技科室每人保费/医技科室每人保费
	 */
	@Column(name = "roomPremium")
	private Double roomPremium;
	/**
	 * 属性护士人数/护士人数
	 */
	@Column(name = "nurseNum")
	private Integer nurseNum;
	/**
	 * 属性护士每人保费/护士每人保费
	 */
	@Column(name = "nursePremium")
	private Double nursePremium;
	/**
	 * 属性医务人员保费/医务人员保费
	 */
	@Column(name = "workerPremium")
	private Double workerPremium;
	/**
	 * 属性医务人员人数/医务人员人数
	 */
	@Column(name = "workerNum")
	private Integer workerNum;
	/**
	 * 属性大病医疗保险新生儿数量/大病医疗保险新生儿数量
	 */
	@Column(name = "quantityNewborn")
	private Double quantityNewborn;
	/**
	 * 属性大病医疗保险新生儿是否收费标志/大病医疗保险新生儿是否收费标志
	 */
	@Column(name = "chargeNewbornFlag")
	private String chargeNewbornFlag;
	/**
	 * 属性单位保费/单位保费
	 */
	@Column(name = "unitPremium")
	private Double unitPremium;
	/**
	 * 属性住院病人手术人次/住院病人手术人次
	 */
	@Column(name = "operationNum")
	private Integer operationNum;
	/**
	 * 属性住院病人手术人次基准保险费/住院病人手术人次基准保险费
	 */
	@Column(name = "operationPremium")
	private Double operationPremium;
	/**
	 * 属性医疗机构类别系数/医疗机构类别系数
	 */
	@Column(name = "medicalRate")
	private Double medicalRate;
	/**
	 * 属性岗位系数/岗位系数
	 */
	@Column(name = "postRate")
	private Double postRate;
	/**
	 * 属性绝对免赔额/绝对免赔额
	 */
	@Column(name = "deductibleValue")
	private Double deductibleValue;
	/**
	 * 属性绝对免赔额费率折扣系数/绝对免赔额费率折扣系数
	 */
	@Column(name = "deductibleDiscount")
	private Double deductibleDiscount;
	/**
	 * 属性分摊M险的实缴保费值/分摊M险的实缴保费值
	 */
	@Column(name = "kindBenchmarkPremiumm")
	private Double kindBenchmarkPremiumm;
	/**
	 * 属性第三者责任限额/第三者责任限额
	 */
	@Column(name = "thirdPeopleAmount")
	private Double thirdPeopleAmount;
	/**
	 * 属性乘客责任限额/乘客责任限额
	 */
	@Column(name = "guestAmount")
	private Double guestAmount;
	/**
	 * 属性驾驶人责任限额/驾驶人责任限额
	 */
	@Column(name = "driverAmount")
	private Double driverAmount;
	/**
	 * 属性是否特殊材质玻璃/是否特殊材质玻璃
	 */
	@Column(name = "isSpecGlass")
	private String isSpecGlass;
	/**
	 * 属性beneFitrate/beneFitrate
	 */
	@Column(name = "benefitRate")
	private Double benefitRate;
	/**
	 * 属性商品代码/商品代码
	 */
	@Column(name = "clauseCode")
	private String clauseCode;
	/**
	 * 属性comPensationDays/comPensationDays
	 */
	@Column(name = "compensationDays")
	private String compensationDays;
	/**
	 * 属性签单币种/签单币种
	 */
	@Column(name = "currency2")
	private String currency2;
	/**
	 * 属性deductibleDesc/deductibleDesc
	 */
	@Column(name = "deductibleDesc")
	private String deductibleDesc;
	/**
	 * 属性自负额单位类别代码/自负额单位类别代码
	 */
	@Column(name = "deductibleType")
	private String deductibleType;
	/**
	 * 属性优惠业务费/优惠业务费
	 */
	@Column(name = "discountCharge")
	private Double discountCharge;
	/**
	 * 属性第二兑换率/第二兑换率
	 */
	@Column(name = "exchangeRate2")
	private Double exchangeRate2;
	/**
	 * 属性签单币种与本位币种的兑换率/签单币种与本位币种的兑换率
	 */
	@Column(name = "exchangeRateCNY")
	private Double exchangeRateCNY;
	/**
	 * 属性insuredValueType/insuredValueType
	 */
	@Column(name = "insuredValueType")
	private String insuredValueType;
	/**
	 * 属性insuredValueTypeName/insuredValueTypeName
	 */
	@Column(name = "insuredValueTypeName")
	private String insuredValueTypeName;
	/**
	 * 属性分摊M险的基准保费值/分摊M险的基准保费值
	 */
	@Column(name = "kindPremiumm")
	private Double kindPremiumm;
	/**
	 * 属性调整后纯保费/调整后纯保费
	 */
	@Column(name = "lastPurePremium")
	private Double lastPurePremium;
	/**
	 * 属性lowerRate/lowerRate
	 */
	@Column(name = "lowerRate")
	private String lowerRate;
	/**
	 * 属性业务费/业务费
	 */
	@Column(name = "manageCharge")
	private Double manageCharge;
	/**
	 * 属性录入折扣率/录入折扣率
	 */
	@Column(name = "motorRate")
	private Double motorRate;
	/**
	 * 属性newEndDate/newEndDate
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "newEndDate")
	private Date newEndDate;
	/**
	 * 属性newStartDate/newStartDate
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "newStartDate")
	private Date newStartDate;
	/**
	 * 属性paymentRate/paymentRate
	 */
	@Column(name = "paymentRate")
	private Double paymentRate;
	/**
	 * 属性第二保费/第二保费
	 */
	@Column(name = "premium2")
	private Double premium2;
	/**
	 * 属性premiumCny/premiumCny
	 */
	@Column(name = "premiumCNY")
	private Double premiumCNY;
	/**
	 * 属性商品代码1/商品代码1
	 */
	@Column(name = "productCode")
	private String productCode;
	/**
	 * 属性profitscale/profitscale
	 */
	@Column(name = "profitScale")
	private Double profitScale;
	/**
	 * 属性基本纯保费/基本纯保费
	 */
	@Column(name = "purePremium")
	private Double purePremium;
	/**
	 * 属性rate1/rate1
	 */
	@Column(name = "rate1")
	private Double rate1;
	/**
	 * 属性规章制度/规章制度
	 */
	@Column(name = "rateType")
	private String rateType;
	/**
	 * 属性费率实施年月/费率实施年月
	 */
	@Column(name = "rateValidDate")
	private String rateValidDate;
	/**
	 * 属性特别补偿基金/特别补偿基金
	 */
	@Column(name = "reliefFund")
	private Double reliefFund;
	/**
	 * 属性特别补偿基金比率/特别补偿基金比率
	 */
	@Column(name = "reliefFundRate")
	private Double reliefFundRate;
	/**
	 * 属性备查文案号/备查文案号
	 */
	@Column(name = "replyNo")
	private String replyNo;
	/**
	 * 属性健全费/健全费
	 */
	@Column(name = "specialCharge")
	private Double specialCharge;
	/**
	 * 属性安定基金/安定基金
	 */
	@Column(name = "stabilityFund")
	private Double stabilityFund;
	/**
	 * 属性安定基金比率/安定基金比率
	 */
	@Column(name = "stabilityFundRate")
	private Double stabilityFundRate;
	/**
	 * 属性storageRate/storageRate
	 */
	@Column(name = "storageRate")
	private Double storageRate;
	/**
	 * 属性structureNo/structureNo
	 */
	@Column(name = "structureNo")
	private Integer structureNo;
	/**
	 * 属性costPrem/costPrem
	 */
	@Column(name = "costPrem")
	private Integer costPrem;
	/**
	 * 属性costDiscount/costDiscount
	 */
	@Column(name = "costDiscount")
	private Integer costDiscount;
	/**
	 * 属性recommenDiscount/recommenDiscount
	 */
	@Column(name = "recommenDiscount")
	private Integer recommenDiscount;
	/**
	 * 属性expDiscount/expDiscount
	 */
	@Column(name = "expDiscount")
	private Integer expDiscount;
	/**
	 * 属性uwritingDiscount/uwritingDiscount
	 */
	@Column(name = "uwritingDiscount")
	private Integer uwritingDiscount;
	/**
	 * 属性不含税保费/不含税保费
	 */
	@Column(name = "noTaxPremium")
	private Double noTaxPremium;
	/**
	 * 属性应/免税标识，1-应税，2-免税/应/免税标识，1-应税，2-免税
	 */
	@Column(name = "taxFlag")
	private String taxFlag;
	/**
	 * 属性税率/税率
	 */
	@Column(name = "taxRate")
	private Double taxRate;
	/**
	 * 属性税额/税额
	 */
	@Column(name = "taxFee")
	private Double taxFee;
	/**
	 * 属性保费计算方式/保费计算方式
	 */
	@Column(name = "premiumCalMethod")
	private String premiumCalMethod;
	/**
	 * 属性林木用途/林木用途
	 */
	@Column(name = "forestUse")
	private String forestUse;

	public String getProposalNo() {
		return proposalNo;
	}

	public void setProposalNo(String proposalNo) {
		this.proposalNo = proposalNo;
	}

	public Integer getItemKindNo() {
		return itemKindNo;
	}

	public void setItemKindNo(Integer itemKindNo) {
		this.itemKindNo = itemKindNo;
	}

	public String getRiskCode() {
		return riskCode;
	}

	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}

	public Integer getFamilyNo() {
		return familyNo;
	}

	public void setFamilyNo(Integer familyNo) {
		this.familyNo = familyNo;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public String getRationType() {
		return rationType;
	}

	public void setRationType(String rationType) {
		this.rationType = rationType;
	}

	public String getKindCode() {
		return kindCode;
	}

	public void setKindCode(String kindCode) {
		this.kindCode = kindCode;
	}

	public String getKindName() {
		return kindName;
	}

	public void setKindName(String kindName) {
		this.kindName = kindName;
	}

	public Integer getItemNo() {
		return itemNo;
	}

	public void setItemNo(Integer itemNo) {
		this.itemNo = itemNo;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getItemDetailName() {
		return itemDetailName;
	}

	public void setItemDetailName(String itemDetailName) {
		this.itemDetailName = itemDetailName;
	}

	public String getModeCode() {
		return modeCode;
	}

	public void setModeCode(String modeCode) {
		this.modeCode = modeCode;
	}

	public String getModeName() {
		return modeName;
	}

	public void setModeName(String modeName) {
		this.modeName = modeName;
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

	public Double getUnitPremium() {
		return unitPremium;
	}

	public void setUnitPremium(Double unitPremium) {
		this.unitPremium = unitPremium;
	}

	public Integer getOperationNum() {
		return operationNum;
	}

	public void setOperationNum(Integer operationNum) {
		this.operationNum = operationNum;
	}

	public Double getOperationPremium() {
		return operationPremium;
	}

	public void setOperationPremium(Double operationPremium) {
		this.operationPremium = operationPremium;
	}

	public Double getMedicalRate() {
		return medicalRate;
	}

	public void setMedicalRate(Double medicalRate) {
		this.medicalRate = medicalRate;
	}

	public Double getPostRate() {
		return postRate;
	}

	public void setPostRate(Double postRate) {
		this.postRate = postRate;
	}

	public Double getDeductibleValue() {
		return deductibleValue;
	}

	public void setDeductibleValue(Double deductibleValue) {
		this.deductibleValue = deductibleValue;
	}

	public Double getDeductibleDiscount() {
		return deductibleDiscount;
	}

	public void setDeductibleDiscount(Double deductibleDiscount) {
		this.deductibleDiscount = deductibleDiscount;
	}

	public Double getBenchmarkPremium() {
		return benchmarkPremium;
	}

	public void setBenchmarkPremium(Double benchmarkPremium) {
		this.benchmarkPremium = benchmarkPremium;
	}

	public Double getKindBenchmarkPremiumm() {
		return kindBenchmarkPremiumm;
	}

	public void setKindBenchmarkPremiumm(Double kindBenchmarkPremiumm) {
		this.kindBenchmarkPremiumm = kindBenchmarkPremiumm;
	}

	public Integer getUwritingDiscount() {
		return uwritingDiscount;
	}

	public void setUwritingDiscount(Integer uwritingDiscount) {
		this.uwritingDiscount = uwritingDiscount;
	}

	public Double getThirdPeopleAmount() {
		return thirdPeopleAmount;
	}

	public void setThirdPeopleAmount(Double thirdPeopleAmount) {
		this.thirdPeopleAmount = thirdPeopleAmount;
	}

	public Double getGuestAmount() {
		return guestAmount;
	}

	public void setGuestAmount(Double guestAmount) {
		this.guestAmount = guestAmount;
	}

	public Double getDriverAmount() {
		return driverAmount;
	}

	public void setDriverAmount(Double driverAmount) {
		this.driverAmount = driverAmount;
	}

	public String getIsSpecGlass() {
		return isSpecGlass;
	}

	public void setIsSpecGlass(String isSpecGlass) {
		this.isSpecGlass = isSpecGlass;
	}

	public Double getBenefitRate() {
		return benefitRate;
	}

	public void setBenefitRate(Double benefitRate) {
		this.benefitRate = benefitRate;
	}

	public String getClauseCode() {
		return clauseCode;
	}

	public void setClauseCode(String clauseCode) {
		this.clauseCode = clauseCode;
	}

	public String getCompensationDays() {
		return compensationDays;
	}

	public void setCompensationDays(String compensationDays) {
		this.compensationDays = compensationDays;
	}

	public String getCurrency2() {
		return currency2;
	}

	public void setCurrency2(String currency2) {
		this.currency2 = currency2;
	}

	public String getDeductibleDesc() {
		return deductibleDesc;
	}

	public void setDeductibleDesc(String deductibleDesc) {
		this.deductibleDesc = deductibleDesc;
	}

	public String getDeductibleType() {
		return deductibleType;
	}

	public void setDeductibleType(String deductibleType) {
		this.deductibleType = deductibleType;
	}

	public Double getDiscountCharge() {
		return discountCharge;
	}

	public void setDiscountCharge(Double discountCharge) {
		this.discountCharge = discountCharge;
	}

	public Double getExchangeRate2() {
		return exchangeRate2;
	}

	public void setExchangeRate2(Double exchangeRate2) {
		this.exchangeRate2 = exchangeRate2;
	}

	public Double getExchangeRateCNY() {
		return exchangeRateCNY;
	}

	public void setExchangeRateCNY(Double exchangeRateCNY) {
		this.exchangeRateCNY = exchangeRateCNY;
	}

	public String getInsuredValueType() {
		return insuredValueType;
	}

	public void setInsuredValueType(String insuredValueType) {
		this.insuredValueType = insuredValueType;
	}

	public String getInsuredValueTypeName() {
		return insuredValueTypeName;
	}

	public void setInsuredValueTypeName(String insuredValueTypeName) {
		this.insuredValueTypeName = insuredValueTypeName;
	}

	public Double getKindPremiumm() {
		return kindPremiumm;
	}

	public void setKindPremiumm(Double kindPremiumm) {
		this.kindPremiumm = kindPremiumm;
	}

	public Double getLastPurePremium() {
		return lastPurePremium;
	}

	public void setLastPurePremium(Double lastPurePremium) {
		this.lastPurePremium = lastPurePremium;
	}

	public String getLowerRate() {
		return lowerRate;
	}

	public void setLowerRate(String lowerRate) {
		this.lowerRate = lowerRate;
	}

	public Double getManageCharge() {
		return manageCharge;
	}

	public void setManageCharge(Double manageCharge) {
		this.manageCharge = manageCharge;
	}

	public Double getMotorRate() {
		return motorRate;
	}

	public void setMotorRate(Double motorRate) {
		this.motorRate = motorRate;
	}

	public Date getNewEndDate() {
		return newEndDate;
	}

	public void setNewEndDate(Date newEndDate) {
		this.newEndDate = newEndDate;
	}

	public Date getNewStartDate() {
		return newStartDate;
	}

	public void setNewStartDate(Date newStartDate) {
		this.newStartDate = newStartDate;
	}

	public Double getPaymentRate() {
		return paymentRate;
	}

	public void setPaymentRate(Double paymentRate) {
		this.paymentRate = paymentRate;
	}

	public Double getPremium2() {
		return premium2;
	}

	public void setPremium2(Double premium2) {
		this.premium2 = premium2;
	}

	public Double getPremiumCNY() {
		return premiumCNY;
	}

	public void setPremiumCNY(Double premiumCNY) {
		this.premiumCNY = premiumCNY;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public Double getProfitScale() {
		return profitScale;
	}

	public void setProfitScale(Double profitScale) {
		this.profitScale = profitScale;
	}

	public Double getPurePremium() {
		return purePremium;
	}

	public void setPurePremium(Double purePremium) {
		this.purePremium = purePremium;
	}

	public Double getRate1() {
		return rate1;
	}

	public void setRate1(Double rate1) {
		this.rate1 = rate1;
	}

	public String getRateType() {
		return rateType;
	}

	public void setRateType(String rateType) {
		this.rateType = rateType;
	}

	public String getRateValidDate() {
		return rateValidDate;
	}

	public void setRateValidDate(String rateValidDate) {
		this.rateValidDate = rateValidDate;
	}

	public Double getReliefFund() {
		return reliefFund;
	}

	public void setReliefFund(Double reliefFund) {
		this.reliefFund = reliefFund;
	}

	public Double getReliefFundRate() {
		return reliefFundRate;
	}

	public void setReliefFundRate(Double reliefFundRate) {
		this.reliefFundRate = reliefFundRate;
	}

	public String getReplyNo() {
		return replyNo;
	}

	public void setReplyNo(String replyNo) {
		this.replyNo = replyNo;
	}

	public Double getSpecialCharge() {
		return specialCharge;
	}

	public void setSpecialCharge(Double specialCharge) {
		this.specialCharge = specialCharge;
	}

	public Double getStabilityFund() {
		return stabilityFund;
	}

	public void setStabilityFund(Double stabilityFund) {
		this.stabilityFund = stabilityFund;
	}

	public Double getStabilityFundRate() {
		return stabilityFundRate;
	}

	public void setStabilityFundRate(Double stabilityFundRate) {
		this.stabilityFundRate = stabilityFundRate;
	}

	public Double getStorageRate() {
		return storageRate;
	}

	public void setStorageRate(Double storageRate) {
		this.storageRate = storageRate;
	}

	public Integer getStructureNo() {
		return structureNo;
	}

	public void setStructureNo(Integer structureNo) {
		this.structureNo = structureNo;
	}

	public Integer getCostPrem() {
		return costPrem;
	}

	public void setCostPrem(Integer costPrem) {
		this.costPrem = costPrem;
	}

	public Integer getCostDiscount() {
		return costDiscount;
	}

	public void setCostDiscount(Integer costDiscount) {
		this.costDiscount = costDiscount;
	}

	public Integer getRecommenDiscount() {
		return recommenDiscount;
	}

	public void setRecommenDiscount(Integer recommenDiscount) {
		this.recommenDiscount = recommenDiscount;
	}

	public Integer getExpDiscount() {
		return expDiscount;
	}

	public void setExpDiscount(Integer expDiscount) {
		this.expDiscount = expDiscount;
	}



	public Double getNoTaxPremium() {
		return noTaxPremium;
	}

	public void setNoTaxPremium(Double noTaxPremium) {
		this.noTaxPremium = noTaxPremium;
	}

	public String getTaxFlag() {
		return taxFlag;
	}

	public void setTaxFlag(String taxFlag) {
		this.taxFlag = taxFlag;
	}

	public Double getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(Double taxRate) {
		this.taxRate = taxRate;
	}

	public Double getTaxFee() {
		return taxFee;
	}

	public void setTaxFee(Double taxFee) {
		this.taxFee = taxFee;
	}

	public String getPremiumCalMethod() {
		return premiumCalMethod;
	}

	public void setPremiumCalMethod(String premiumCalMethod) {
		this.premiumCalMethod = premiumCalMethod;
	}

	public String getForestUse() {
		return forestUse;
	}

	public void setForestUse(String forestUse) {
		this.forestUse = forestUse;
	}
}