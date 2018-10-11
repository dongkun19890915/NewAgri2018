package com.sinosoft.agriprpall.api.endorsemanage.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;
import java.util.Date;

public class PrpPitemKindCopyDto extends BaseRequest implements Serializable{
    private static final long serialVersionUID = 1L;
    /** 属性批单号码/批单号码 */

    private String endorseNo ;/** 属性 险种代码/ 险种代码 */
    private String policyNo;



    private Integer itemKindNo ;

    /** 属性 保单号码/ 保单号码 */

    private String riskCode ;

    /** 属性序号/序号 */
    private Integer familyNo ;
    /** 属性分户序号(仅用于集体家财险)/分户序号(仅用于集体家财险) */
    private String familyName ;
    /** 属性rationType/rationType */
    private String rationType ;
    /** 属性分户名称(仅用于集体家财险)--** 集装箱体保险时为集装箱编号--** 船舶险时为船名/分户名称(仅用于集体家财险)--** 集装箱体保险时为集装箱编号--** 船舶险时为船名 */
    private String kindCode ;
    /** 属性险别代码/险别代码 */
    private String kindName ;
    /** 属性险别名称/险别名称 */
    private Integer itemNo ;
    /** 属性标的序号/标的序号 */
    private String itemCode ;
    /** 属性标的项目类别代码 ▲--** 林木种类代码/标的项目类别代码 ▲--** 林木种类代码 */
    private String itemDetailName ;
    /** 属性标的项目明细名称--** 林木种类名称/标的项目明细名称--** 林木种类名称 */
    private String modeCode ;
    /** 属性投保方式代码▲--** 金牛险:--** PrpDration.RationType--** 养殖险: 何价投保--** 车险：玻璃类别/投保方式代码▲--** 金牛险:--** PrpDration.RationType--** 养殖险: 何价投保--** 车险：玻璃类别 */
    private String modeName ;
    /** 属性投保方式名称--** 金牛险:--** PrpDration.RationName--** 养殖险: 何价投保/投保方式名称--** 金牛险:--** PrpDration.RationName--** 养殖险: 何价投保 */
    private Date startDate ;
    /** 属性起保日期/起保日期 */
    private Integer startHour ;
    /** 属性起保小时/起保小时 */
    private Date endDate ;
    /** 属性终保日期/终保日期 */
    private Integer endHour ;
    /** 属性 终保小时/ 终保小时 */
    private String model ;
    /** 属性 规格型号/ 规格型号 */
    private Date buyDate ;
    /** 属性购买日期/购买日期 */
    private Integer addressNo ;
    /** 属性地址序号/地址序号 */
    private String calculateFlag ;
    /** 属性是否计算保额标志(Y/N)/是否计算保额标志(Y/N) */
    private String currency ;
    /** 属性 币别/ 币别 */
    private Double unitAmount ;
    /** 属性单位保险金额（赔偿限额）/单位保险金额（赔偿限额） */
    private Double quantity ;
    /** 属性 数量(人数/产品数量/户数)--** 牲畜数量(养殖)--** 投保面积(亩)(林木险)/ 数量(人数/产品数量/户数)--** 牲畜数量(养殖)--** 投保面积(亩)(林木险) */
    private String unit ;
    /** 属性 数量单位/ 数量单位 */
    private Double value ;
    /** 属性保险价值/保险价值 */
    private Double amount ;
    /** 属性保险金额/赔偿限额/保险金额/赔偿限额 */
    private Integer ratePeriod ;
    /** 属性适应费率期数/适应费率期数 */
    private Double rate ;
    /** 属性费率/费率 */
    private String shortRateFlag ;
    /** 属性 短期费率标志--** (1.月比例/2.日比例--** /3.不计)/ 短期费率标志--** (1.月比例/2.日比例--** /3.不计) */
    private Double shortRate ;
    /** 属性 短期费率/ 短期费率 */
    private Double basePremium ;
    /** 属性基准保费/基准保费 */
    private Double benchmarkPremium ;
    /** 属性标准保费/标准保费 */
    private Double discount ;
    /** 属性 折扣率/ 折扣率 */
    private Double adjustRate ;
    /** 属性保费调整比率(%)/保费调整比率(%) */
    private Double premium ;
    /** 属性保费/储金/保费/储金 */
    private Double deductibleRate ;
    /** 属性 免赔率(%)/ 免赔率(%) */
    private Double deductible ;
    /** 属性免赔额/免赔额 */
    private String flag ;
    /** 属性 标志字段--** [2] 位为主险/附加险标志--** 1:主险 2:附加险 3:其他--** [3]-[4]位等于费率类型--**（RateTypeFlag）/ 标志字段--** [2] 位为主险/附加险标志--** 1:主险 2:附加险 3:其他--** [3]-[4]位等于费率类型--**（RateTypeFlag） */
    private Double chgQuantity ;
    /** 属性数量变化量/数量变化量 */
    private Double chgAmount ;
    /** 属性 保额变化量/ 保额变化量 */
    private Double chgPremium ;
    /** 属性保费变化量/保费变化量 */
    private String regionRate ;
    /** 属性地区费率因子: 0-不浮动, 1-上浮30%/地区费率因子: 0-不浮动, 1-上浮30% */
    private Integer drinkRate ;
    /** 属性饮酒费率因子：饮酒驾驶违法次数/饮酒费率因子：饮酒驾驶违法次数 */
    private Integer drunkRate ;
    /** 属性醉酒费率因子：醉酒驾驶违法次数/醉酒费率因子：醉酒驾驶违法次数 */
    private String cattleType ;
    /** 属性肉牛类型（3221肉牛险专用0122附加险借用0123附加险借用:玻璃类型）/肉牛类型（3221肉牛险专用0122附加险借用0123附加险借用:玻璃类型） */
    private Double unitPersonLimitAmount ;
    /** 属性每次事故每人赔偿限额 0122,0123附加险用到/每次事故每人赔偿限额 0122,0123附加险用到 */
    private Double unitPersonAmount ;
    /** 属性每人赔偿限额0123用到/每人赔偿限额0123用到 */
    private Double unitDayAmountSub ;
    /** 属性日额：每人日额（元）2714,0123用/日额：每人日额（元）2714,0123用 */
    private Integer daySub ;
    /** 属性天数：2714附加险专用0123附加险借用/天数：2714附加险专用0123附加险借用 */
    private String personType ;
    /** 属性人员类别2606险种用到/人员类别2606险种用到 */
    private Double triggerPoint ;
    /** 属性起赔点/起赔点 */
    private Double totalLossRatio ;
    /** 属性全损损失率/全损损失率 */
    private Double lawsuitAmount ;
    /** 属性诉讼费限额/诉讼费限额 */
    private Integer bedNum ;
    /** 属性病床数/病床数 */
    private Double bedPremium ;
    /** 属性每张床位保险费/每张床位保险费 */
    private Double hospitalPremium ;
    /** 属性医疗机构保费/医疗机构保费 */
    private Integer kindWorkerNum ;
    /** 属性各类医务人员人数/各类医务人员人数 */
    private Double kindWorkerPremium ;
    /** 属性各类医务人员每人保费/各类医务人员每人保费 */
    private Integer clinicNum ;
    /** 属性临床手术科室医师人数/临床手术科室医师人数 */
    private Double clinicPremium ;
    /** 属性临床手术科室医师每人保费/临床手术科室医师每人保费 */
    private Integer nClinicNum ;
    /** 属性临床非手术科室医师人数/临床非手术科室医师人数 */
    private Double nClinicPremium ;
    /** 属性临床非手术科室医师每人保费/临床非手术科室医师每人保费 */
    private Integer roomNum ;
    /** 属性医技科室人数/医技科室人数 */
    private Double roomPremium ;
    /** 属性医技科室每人保费/医技科室每人保费 */
    private Integer nurseNum ;
    /** 属性护士人数/护士人数 */
    private Double nursePremium ;
    /** 属性护士每人保费/护士每人保费 */
    private Double workerPremium ;
    /** 属性医务人员保费/医务人员保费 */
    private Integer workerNum ;
    /** 属性医务人员人数/医务人员人数 */
    private Double quantityNewborn ;
    /** 属性大病医疗保险新生儿数量/大病医疗保险新生儿数量 */
    private String chargeNewbornFlag ;
    /** 属性单位保费变化量/单位保费变化量 */
    private Double unitPremium ;
    /** 属性单位保费/单位保费 */
    private Double chgUnitPremium ;
    /** 属性住院病人手术人次/住院病人手术人次 */
    private Integer operationNum ;
    /** 属性住院病人手术人次基准保险费/住院病人手术人次基准保险费 */
    private Double operationPremium ;
    /** 属性医疗机构类别系数/医疗机构类别系数 */
    private Double medicalRate ;
    /** 属性岗位系数/岗位系数 */
    private Double postRate ;
    /** 属性绝对免赔额/绝对免赔额 */
    private Double deductibleValue ;
    /** 属性绝对免赔额费率折扣系数/绝对免赔额费率折扣系数 */
    private Double deductibleDiscount ;
    /** 属性分摊M险的实缴保费值/分摊M险的实缴保费值 */
    private Double kindBenchmarkPremiumm ;
    /** 属性分摊M险的基准保费值/分摊M险的基准保费值 */
    private Double kindPremiumm ;
    /** 属性乘客责任限额/乘客责任限额 */
    private Double guestAmount ;
    /** 属性驾驶人责任限额/驾驶人责任限额 */
    private Double driverAmount ;
    /** 属性第三者责任限额/第三者责任限额 */
    private Double thirdPeopleAmount ;
    /** 属性是否特殊材质玻璃/是否特殊材质玻璃 */
    private String isSpecGlass ;
    /** 属性安定基金比率/安定基金比率 */
    private Double stabilityFundRate ;
    /** 属性存储率/存储率 */
    private Double storageRate ;
    /** 属性structureNo/structureNo */
    private Integer structureNo ;
    /** 属性优惠业务费变化量/优惠业务费变化量 */
    private Double chgDiscountCharge ;
    /** 属性调整后纯保费变化量/调整后纯保费变化量 */
    private Double chgLastPurePremium ;
    /** 属性业务费变化量/业务费变化量 */
    private Double chgManageCharge ;
    /** 属性折合打印币别总保费变化量/折合打印币别总保费变化量 */
    private Double chgPremium2 ;
    /** 属性chg保险费CNY/chg保险费CNY */
    private Double chgPremiumCNY ;
    /** 属性基本纯保费变化量/基本纯保费变化量 */
    private Double chgPurePremium ;
    /** 属性特别补偿基金变化量/特别补偿基金变化量 */
    private Double chgReliefFund ;
    /** 属性健全费变化量/健全费变化量 */
    private Double chgSpecialCharge ;
    /** 属性安定基金变化量/安定基金变化量 */
    private Double chgStabilityFund ;
    /** 属性商品代码/商品代码 */
    private String clauseCode ;
    /** 属性签单币种/签单币种 */
    private String currency2 ;
    /** 属性自负额单位类别代码/自负额单位类别代码 */
    private String deductibleType ;
    /** 属性优惠业务费/优惠业务费 */
    private Double discountCharge ;
    /** 属性endorType/endorType */
    private String endorType ;
    /** 属性原币和打印币别兑换率/原币和打印币别兑换率 */
    private Double exchangeRate2 ;
    /** 属性签单币种与本位币种的兑换率/签单币种与本位币种的兑换率 */
    private Double exchangeRateCNY ;
    /** 属性被保险人价值类型/被保险人价值类型 */
    private String insuredValueType ;
    /** 属性被保险人价值类型名称/被保险人价值类型名称 */
    private String insuredValueTypeName ;
    /** 属性调整后纯保费/调整后纯保费 */
    private Double lastPurePremium ;
    /** 属性lowerRate/lowerRate */
    private String lowerRate ;
    /** 属性业务费/业务费 */
    private Double manageCharge ;
    /** 属性车队录入折扣率/车队录入折扣率 */
    private Double motorRate ;
    /** 属性新终止日期/新终止日期 */
    private Date newEndDate ;
    /** 属性新开始日期/新开始日期 */
    private Date newStartDate ;
    /** 属性批改前折合打印币别总保费/批改前折合打印币别总保费 */
    private Double premium2 ;
    /** 属性保险费CNY/保险费CNY */
    private Double premiumCny ;
    /** 属性商品代码1/商品代码1 */
    private String productCode ;
    /** 属性利益比例/利益比例 */
    private Double profitScale ;
    /** 属性基本纯保费/基本纯保费 */
    private Double purePremium ;
    /** 属性规章制度/规章制度 */
    private String rateType ;
    /** 属性费率实施年月/费率实施年月 */
    private String rateValidDate ;
    /** 属性特别补偿基金/特别补偿基金 */
    private Double reliefFund ;
    /** 属性特别补偿基金比率/特别补偿基金比率 */
    private Double reliefFundRate ;
    /** 属性备查文案号/备查文案号 */
    private String replyNo ;
    /** 属性健全费/健全费 */
    private Double specialCharge ;
    /** 属性安定基金/安定基金 */
    private Double stabilityFund ;
    /** 属性costPrem/costPrem */
    private Integer costPrem ;
    /** 属性costDiscount/costDiscount */
    private Integer costDiscount ;
    /** 属性recommenDiscount/recommenDiscount */
    private Integer recommenDiscount ;
    /** 属性expDiscount/expDiscount */
    private Integer expDiscount ;
    /** 属性uwritingDiscount/uwritingDiscount */
    private Integer uwritingDiscount ;
    /** 属性修改人/修改人 */
    private String update_By ;
    /** 属性修改时间/修改时间 */
    private Date update_Date ;
    /** 属性不含税保费/不含税保费 */
    private Double noTaxPremium ;
    /** 属性应/免税标识，1-应税，2-免税/应/免税标识，1-应税，2-免税 */
    private String taxFlag ;
    /** 属性税率/税率 */
    private Double taxRate ;
    /** 属性税额/税额 */
    private Double taxFee ;
    /** 属性不含税保费变化量/不含税保费变化量 */
    private Double chgNoTaxPremium ;
    /** 属性税额变化量/税额变化量 */
    private Double chgTaxFee ;
    /** 属性保费计算方式/保费计算方式 */
    private String premiumCalMethod ;
    /** 属性林木用途/林木用途 */
    private String forestUse ;

    public String getEndorseNo() {
        return endorseNo;
    }

    public void setEndorseNo(String endorseNo) {
        this.endorseNo = endorseNo;
    }

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
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

    public Double getBenchmarkPremium() {
        return benchmarkPremium;
    }

    public void setBenchmarkPremium(Double benchmarkPremium) {
        this.benchmarkPremium = benchmarkPremium;
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

    public Double getChgUnitPremium() {
        return chgUnitPremium;
    }

    public void setChgUnitPremium(Double chgUnitPremium) {
        this.chgUnitPremium = chgUnitPremium;
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

    public Double getKindBenchmarkPremiumm() {
        return kindBenchmarkPremiumm;
    }

    public void setKindBenchmarkPremiumm(Double kindBenchmarkPremiumm) {
        this.kindBenchmarkPremiumm = kindBenchmarkPremiumm;
    }

    public Double getKindPremiumm() {
        return kindPremiumm;
    }

    public void setKindPremiumm(Double kindPremiumm) {
        this.kindPremiumm = kindPremiumm;
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

    public Double getThirdPeopleAmount() {
        return thirdPeopleAmount;
    }

    public void setThirdPeopleAmount(Double thirdPeopleAmount) {
        this.thirdPeopleAmount = thirdPeopleAmount;
    }

    public String getIsSpecGlass() {
        return isSpecGlass;
    }

    public void setIsSpecGlass(String isSpecGlass) {
        this.isSpecGlass = isSpecGlass;
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

    public Double getChgDiscountCharge() {
        return chgDiscountCharge;
    }

    public void setChgDiscountCharge(Double chgDiscountCharge) {
        this.chgDiscountCharge = chgDiscountCharge;
    }

    public Double getChgLastPurePremium() {
        return chgLastPurePremium;
    }

    public void setChgLastPurePremium(Double chgLastPurePremium) {
        this.chgLastPurePremium = chgLastPurePremium;
    }

    public Double getChgManageCharge() {
        return chgManageCharge;
    }

    public void setChgManageCharge(Double chgManageCharge) {
        this.chgManageCharge = chgManageCharge;
    }

    public Double getChgPremium2() {
        return chgPremium2;
    }

    public void setChgPremium2(Double chgPremium2) {
        this.chgPremium2 = chgPremium2;
    }

    public Double getChgPremiumCNY() {
        return chgPremiumCNY;
    }

    public void setChgPremiumCNY(Double chgPremiumCNY) {
        this.chgPremiumCNY = chgPremiumCNY;
    }

    public Double getChgPurePremium() {
        return chgPurePremium;
    }

    public void setChgPurePremium(Double chgPurePremium) {
        this.chgPurePremium = chgPurePremium;
    }

    public Double getChgReliefFund() {
        return chgReliefFund;
    }

    public void setChgReliefFund(Double chgReliefFund) {
        this.chgReliefFund = chgReliefFund;
    }

    public Double getChgSpecialCharge() {
        return chgSpecialCharge;
    }

    public void setChgSpecialCharge(Double chgSpecialCharge) {
        this.chgSpecialCharge = chgSpecialCharge;
    }

    public Double getChgStabilityFund() {
        return chgStabilityFund;
    }

    public void setChgStabilityFund(Double chgStabilityFund) {
        this.chgStabilityFund = chgStabilityFund;
    }

    public String getClauseCode() {
        return clauseCode;
    }

    public void setClauseCode(String clauseCode) {
        this.clauseCode = clauseCode;
    }

    public String getCurrency2() {
        return currency2;
    }

    public void setCurrency2(String currency2) {
        this.currency2 = currency2;
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

    public String getEndorType() {
        return endorType;
    }

    public void setEndorType(String endorType) {
        this.endorType = endorType;
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

    public Double getPremium2() {
        return premium2;
    }

    public void setPremium2(Double premium2) {
        this.premium2 = premium2;
    }

    public Double getPremiumCny() {
        return premiumCny;
    }

    public void setPremiumCny(Double premiumCny) {
        this.premiumCny = premiumCny;
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

    public Double getChgNoTaxPremium() {
        return chgNoTaxPremium;
    }

    public void setChgNoTaxPremium(Double chgNoTaxPremium) {
        this.chgNoTaxPremium = chgNoTaxPremium;
    }

    public Double getChgTaxFee() {
        return chgTaxFee;
    }

    public void setChgTaxFee(Double chgTaxFee) {
        this.chgTaxFee = chgTaxFee;
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
