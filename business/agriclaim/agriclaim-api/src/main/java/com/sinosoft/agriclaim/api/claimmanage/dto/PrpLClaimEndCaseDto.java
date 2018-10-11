package com.sinosoft.agriclaim.api.claimmanage.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
*（结案登记页面展示元素Dto）
* @Author: 董坤
* @Date: 2017/11/11 11:16
*/

public class PrpLClaimEndCaseDto {
    private static final long serialVersionUID = 1L;
    /** 属性立案号码/立案号码 */
    private String claimNo ;
    /** 属性理赔类型/理赔类型 */
    private String lFlag ;
    /** 属性赔案号/赔案号 */
    private String caseNo ;
    /** 属性险类代码/险类代码 */
    private String classCode ;
    /** 属性险种代码/险种代码 */
    private String riskCode ;
    /** 属性报案号码/报案号码 */
    private String registNo ;
    /** 属性保单号码/保单号码 */
    private String policyNo ;
    /** 属性业务性质/业务性质 */
    private String businessNature ;
    /** 属性语种/语种 */
    private String language ;
    /** 属性保单类型/保单类型 */
    private String policyType ;
    /** 属性被保险人代码/被保险人代码 */
    private String insuredCode ;
    /** 属性被保险人名称/被保险人名称 */
    private String insuredName ;
    /** 属性起保日期/起保日期 */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date startDate ;
    /** 属性起保小时/起保小时 */
    private java.lang.Integer startHour ;
    /** 属性终保日期/终保日期 */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date endDate ;
    /** 属性终保小时/终保小时 */
    private java.lang.Integer endHour ;
    /** 属性币别代码/币别代码 */
    private String currency ;
    /** 属性总保额/总保额 */
    private java.lang.Double sumAmount ;
    /** 属性总数量/总数量 */
    private java.lang.Integer sumPremium ;
    /** 属性出险日期起/出险日期起 */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date damageStartDate ;
    /** 属性出险开始小时/出险开始小时 */
    private String damageStartHour ;
    /** 属性出险日期止/出险日期止 */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date damageEndDate ;
    /** 属性出险终止小时/出险终止小时 */
    private String damageEndHour ;
    /** 属性出险原因代码/出险原因代码 */
    private String damageCode ;
    /** 属性出险原因说明/出险原因说明 */
    private String damageName ;
    /** 属性事故类型代码/事故类型代码 */
    private String damageTypeCode ;
    /** 属性事故类型说明/事故类型说明 */
    private String damageTypeName ;
    /** 属性出险区域代码/出险区域代码 */
    private String damageAreaCode ;
    /** 属性出险区域名称/出险区域名称 */
    private String damageAreaName ;
    /** 属性出险地点分类代码/出险地点分类代码 */
    private String damageAddressType ;
    /** 属性出险地代码/出险地代码 */
    private String addressCode ;
    /** 属性出险地点/出险地点 */
    private String damageAddress ;
    /** 属性受损标的/受损标的 */
    private String lossName ;
    /** 属性受损标的数量/出险分户数/受损标的数量/出险分户数 */
    private java.lang.Integer lossQuantity ;
    /** 属性出险险别/出险险别 */
    private String damageKind ;
    /** 属性立案日期/立案日期 */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date claimDate ;
    /** 属性赔偿责任代码/赔偿责任代码 */
    private String indemnityDuty ;
    /** 属性责任比例/责任比例 */
    private java.lang.Double indemnityDutyRate ;
    /** 属性免赔率/免赔率 */
    private java.lang.Double deductibleRate ;
    /** 属性保险损失金额(同保单币别)/保险损失金额(同保单币别) */
    private java.lang.Double sumClaim ;
    /** 属性总核定损金额(同保单币别)/总核定损金额(同保单币别) */
    private java.lang.Double sumDefLoss ;
    /** 属性总赔付金额(同保单币别)/总赔付金额(同保单币别) */
    private java.lang.Double sumPaid ;
    /** 属性总追偿金额(同保单币别)/总追偿金额(同保单币别) */
    private java.lang.Double sumReplevy ;
    /** 属性备注/备注 */
    private String remark ;
    /** 属性案件性质/案件性质 */
    private String caseType ;
    /** 属性理赔登记机构代码/理赔登记机构代码 */
    private String makeCom ;
    /** 属性业务归属机构代码/业务归属机构代码 */
    private String comCode ;
    /** 属性代理人代码/代理人代码 */
    private String agentCode ;
    /** 属性经办人代码/经办人代码 */
    private String handlerCode ;
    /** 属性归属业务员代码/归属业务员代码 */
    private String handler1Code ;
    /** 属性统计年月/统计年月 */
    private String statisticsYM ;
    /** 属性操作员代码/操作员代码 */
    private String operatorCode ;
    /** 属性计算机输单日期/计算机输单日期 */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date inputDate ;
    /** 属性结案日期/结案日期 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date endCaseDate ;
    /** 属性结案员代码/结案员代码 */
    private String endCaserCode ;
    /** 属性注销/拒赔日期/注销/拒赔日期 */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date cancelDate ;
    /** 属性注销/拒赔原因1/注销/拒赔原因1 */
    private String cancelReason ;
    /** 属性注销/拒赔人代码/注销/拒赔人代码 */
    private String dealerCode ;
    /** 属性是否为逃逸案/是否为逃逸案 */
    private String escapeFlag ;
    /** 属性标志字段/标志字段 */
    private String flag ;
    /** 属性暂无/暂无 */
    private String replevyFlag ;
    /** 属性第三方公司标志/第三方公司标志 */
    private String thirdComFlag ;
    /** 属性是否自动结案 [0]不是[1]是/是否自动结案 [0]不是[1]是 */
    private String endCaseFlag ;
    /** 属性计算书责任比例/计算书责任比例 */
    private java.lang.Double cIndemnityDutyRate ;
    /** 属性出险地点邮政编码/出险地点邮政编码 */
    private String damageAreaPostCode ;
    /** 属性巨灾一级代码/巨灾一级代码 */
    private String catastropheCode1 ;
    /** 属性巨灾一级名称/巨灾一级名称 */
    private String catastropheName1 ;
    /** 属性巨灾二级代码/巨灾二级代码 */
    private String catastropheCode2 ;
    /** 属性巨灾二级名称/巨灾二级名称 */
    private String catastropheName2 ;
    /** 属性立案类型/立案类型 */
    private String claimType ;
    /** 属性赔付数量/赔付数量 */
    private java.lang.Double lossesNumber ;
    /** 属性赔付数量计量单位/赔付数量计量单位 */
    private String lossesUnitCode ;
    /** 属性出险户次/出险户次 */
    private java.lang.Double damageInsured ;
    /** 属性受灾面积/受灾面积 */
    private java.lang.Double disasterArea ;
    /** 属性受灾面积计量单位/受灾面积计量单位 */
    private String disasterUnit ;
    /** 属性成灾面积/成灾面积 */
    private java.lang.Double affectedArea ;
    /** 属性成灾面积计量单位/成灾面积计量单位 */
    private String affectedUnit ;
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
    /** 属性医疗类型：对应PrpDcode表的CodeType＝''MedicalType'' 健康险统计专用/医疗类型：对应PrpDcode表的CodeType＝''MedicalType'' 健康险统计专用 */
    private String medicalType ;
    /** 属性0－直接业务，1－分入业务/0－直接业务，1－分入业务 */
    private String businessFlag ;
    /** 属性其他标志（对应prpcmain表中的otherFlag）/其他标志（对应prpcmain表中的otherFlag） */
    private String otherFlag ;
    /** 属性核损估损通过标志/核损估损通过标志 */
    private String claimLossFlag ;
    /** 属性案均估损/案均估损 */
    private String avgFlag ;
    /** 属性15天延迟估损/15天延迟估损 */
    private String fifteenFlag ;
    /** 属性30天延迟估损/30天延迟估损 */
    private String thirtyFlag ;
    /** 属性注销/拒赔原因/注销/拒赔原因 */
    private String cancelReasonExplan ;
    /** 属性自动立案标示/自动立案标示 */
    private String autoFlag ;
    /** 属性立案时间(精确)/立案时间(精确) */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date claimTime ;
    /** 属性修改人/修改人 */
    private String upDateBy ;
    /** 属性修改日期/修改日期 */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private java.util.Date upDateDate ;
    /** 险种名称 */
    private String riskName ;
    /** 投保人名称 */
    private String appliName ;
    /** 业务归属部门 */
    private String comName ;
    /** 归属业务员 */
    private String handler1Name ;
    /** 经办人 */
    private String handlerName ;
    /** 理赔部门 */
    private String makeComName ;
    /** 操作员 */
    private String operatorName ;
    /** 结案员 */
    private String endCaserName ;
    /** 注销人 */
    private String dealerName ;
    /** 结案报告 */
    private String context ;

    private String compensateNo;

    public String getCompensateNo() {
        return compensateNo;
    }

    public void setCompensateNo(String compensateNo) {
        this.compensateNo = compensateNo;
    }

    public String getClaimNo() {
        return claimNo;
    }

    public void setClaimNo(String claimNo) {
        this.claimNo = claimNo;
    }

    public String getlFlag() {
        return lFlag;
    }

    public void setlFlag(String lFlag) {
        this.lFlag = lFlag;
    }

    public String getCaseNo() {
        return caseNo;
    }

    public void setCaseNo(String caseNo) {
        this.caseNo = caseNo;
    }

    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }

    public String getRiskCode() {
        return riskCode;
    }

    public void setRiskCode(String riskCode) {
        this.riskCode = riskCode;
    }

    public String getRegistNo() {
        return registNo;
    }

    public void setRegistNo(String registNo) {
        this.registNo = registNo;
    }

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }

    public String getBusinessNature() {
        return businessNature;
    }

    public void setBusinessNature(String businessNature) {
        this.businessNature = businessNature;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getPolicyType() {
        return policyType;
    }

    public void setPolicyType(String policyType) {
        this.policyType = policyType;
    }

    public String getInsuredCode() {
        return insuredCode;
    }

    public void setInsuredCode(String insuredCode) {
        this.insuredCode = insuredCode;
    }

    public String getInsuredName() {
        return insuredName;
    }

    public void setInsuredName(String insuredName) {
        this.insuredName = insuredName;
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

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Double getSumAmount() {
        return sumAmount;
    }

    public void setSumAmount(Double sumAmount) {
        this.sumAmount = sumAmount;
    }

    public Integer getSumPremium() {
        return sumPremium;
    }

    public void setSumPremium(Integer sumPremium) {
        this.sumPremium = sumPremium;
    }

    public Date getDamageStartDate() {
        return damageStartDate;
    }

    public void setDamageStartDate(Date damageStartDate) {
        this.damageStartDate = damageStartDate;
    }

    public String getDamageStartHour() {
        return damageStartHour;
    }

    public void setDamageStartHour(String damageStartHour) {
        this.damageStartHour = damageStartHour;
    }

    public Date getDamageEndDate() {
        return damageEndDate;
    }

    public void setDamageEndDate(Date damageEndDate) {
        this.damageEndDate = damageEndDate;
    }

    public String getDamageEndHour() {
        return damageEndHour;
    }

    public void setDamageEndHour(String damageEndHour) {
        this.damageEndHour = damageEndHour;
    }

    public String getDamageCode() {
        return damageCode;
    }

    public void setDamageCode(String damageCode) {
        this.damageCode = damageCode;
    }

    public String getDamageName() {
        return damageName;
    }

    public void setDamageName(String damageName) {
        this.damageName = damageName;
    }

    public String getDamageTypeCode() {
        return damageTypeCode;
    }

    public void setDamageTypeCode(String damageTypeCode) {
        this.damageTypeCode = damageTypeCode;
    }

    public String getDamageTypeName() {
        return damageTypeName;
    }

    public void setDamageTypeName(String damageTypeName) {
        this.damageTypeName = damageTypeName;
    }

    public String getDamageAreaCode() {
        return damageAreaCode;
    }

    public void setDamageAreaCode(String damageAreaCode) {
        this.damageAreaCode = damageAreaCode;
    }

    public String getDamageAreaName() {
        return damageAreaName;
    }

    public void setDamageAreaName(String damageAreaName) {
        this.damageAreaName = damageAreaName;
    }

    public String getDamageAddressType() {
        return damageAddressType;
    }

    public void setDamageAddressType(String damageAddressType) {
        this.damageAddressType = damageAddressType;
    }

    public String getAddressCode() {
        return addressCode;
    }

    public void setAddressCode(String addressCode) {
        this.addressCode = addressCode;
    }

    public String getDamageAddress() {
        return damageAddress;
    }

    public void setDamageAddress(String damageAddress) {
        this.damageAddress = damageAddress;
    }

    public String getLossName() {
        return lossName;
    }

    public void setLossName(String lossName) {
        this.lossName = lossName;
    }

    public Integer getLossQuantity() {
        return lossQuantity;
    }

    public void setLossQuantity(Integer lossQuantity) {
        this.lossQuantity = lossQuantity;
    }

    public String getDamageKind() {
        return damageKind;
    }

    public void setDamageKind(String damageKind) {
        this.damageKind = damageKind;
    }

    public Date getClaimDate() {
        return claimDate;
    }

    public void setClaimDate(Date claimDate) {
        this.claimDate = claimDate;
    }

    public String getIndemnityDuty() {
        return indemnityDuty;
    }

    public void setIndemnityDuty(String indemnityDuty) {
        this.indemnityDuty = indemnityDuty;
    }

    public Double getIndemnityDutyRate() {
        return indemnityDutyRate;
    }

    public void setIndemnityDutyRate(Double indemnityDutyRate) {
        this.indemnityDutyRate = indemnityDutyRate;
    }

    public Double getDeductibleRate() {
        return deductibleRate;
    }

    public void setDeductibleRate(Double deductibleRate) {
        this.deductibleRate = deductibleRate;
    }

    public Double getSumClaim() {
        return sumClaim;
    }

    public void setSumClaim(Double sumClaim) {
        this.sumClaim = sumClaim;
    }

    public Double getSumDefLoss() {
        return sumDefLoss;
    }

    public void setSumDefLoss(Double sumDefLoss) {
        this.sumDefLoss = sumDefLoss;
    }

    public Double getSumPaid() {
        return sumPaid;
    }

    public void setSumPaid(Double sumPaid) {
        this.sumPaid = sumPaid;
    }

    public Double getSumReplevy() {
        return sumReplevy;
    }

    public void setSumReplevy(Double sumReplevy) {
        this.sumReplevy = sumReplevy;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCaseType() {
        return caseType;
    }

    public void setCaseType(String caseType) {
        this.caseType = caseType;
    }

    public String getMakeCom() {
        return makeCom;
    }

    public void setMakeCom(String makeCom) {
        this.makeCom = makeCom;
    }

    public String getComCode() {
        return comCode;
    }

    public void setComCode(String comCode) {
        this.comCode = comCode;
    }

    public String getAgentCode() {
        return agentCode;
    }

    public void setAgentCode(String agentCode) {
        this.agentCode = agentCode;
    }

    public String getHandlerCode() {
        return handlerCode;
    }

    public void setHandlerCode(String handlerCode) {
        this.handlerCode = handlerCode;
    }

    public String getHandler1Code() {
        return handler1Code;
    }

    public void setHandler1Code(String handler1Code) {
        this.handler1Code = handler1Code;
    }

    public String getStatisticsYM() {
        return statisticsYM;
    }

    public void setStatisticsYM(String statisticsYM) {
        this.statisticsYM = statisticsYM;
    }

    public String getOperatorCode() {
        return operatorCode;
    }

    public void setOperatorCode(String operatorCode) {
        this.operatorCode = operatorCode;
    }

    public Date getInputDate() {
        return inputDate;
    }

    public void setInputDate(Date inputDate) {
        this.inputDate = inputDate;
    }

    public Date getEndCaseDate() {
        return endCaseDate;
    }

    public void setEndCaseDate(Date endCaseDate) {
        this.endCaseDate = endCaseDate;
    }

    public String getEndCaserCode() {
        return endCaserCode;
    }

    public void setEndCaserCode(String endCaserCode) {
        this.endCaserCode = endCaserCode;
    }

    public Date getCancelDate() {
        return cancelDate;
    }

    public void setCancelDate(Date cancelDate) {
        this.cancelDate = cancelDate;
    }

    public String getCancelReason() {
        return cancelReason;
    }

    public void setCancelReason(String cancelReason) {
        this.cancelReason = cancelReason;
    }

    public String getDealerCode() {
        return dealerCode;
    }

    public void setDealerCode(String dealerCode) {
        this.dealerCode = dealerCode;
    }

    public String getEscapeFlag() {
        return escapeFlag;
    }

    public void setEscapeFlag(String escapeFlag) {
        this.escapeFlag = escapeFlag;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getReplevyFlag() {
        return replevyFlag;
    }

    public void setReplevyFlag(String replevyFlag) {
        this.replevyFlag = replevyFlag;
    }

    public String getThirdComFlag() {
        return thirdComFlag;
    }

    public void setThirdComFlag(String thirdComFlag) {
        this.thirdComFlag = thirdComFlag;
    }

    public String getEndCaseFlag() {
        return endCaseFlag;
    }

    public void setEndCaseFlag(String endCaseFlag) {
        this.endCaseFlag = endCaseFlag;
    }

    public Double getcIndemnityDutyRate() {
        return cIndemnityDutyRate;
    }

    public void setcIndemnityDutyRate(Double cIndemnityDutyRate) {
        this.cIndemnityDutyRate = cIndemnityDutyRate;
    }

    public String getDamageAreaPostCode() {
        return damageAreaPostCode;
    }

    public void setDamageAreaPostCode(String damageAreaPostCode) {
        this.damageAreaPostCode = damageAreaPostCode;
    }

    public String getCatastropheCode1() {
        return catastropheCode1;
    }

    public void setCatastropheCode1(String catastropheCode1) {
        this.catastropheCode1 = catastropheCode1;
    }

    public String getCatastropheName1() {
        return catastropheName1;
    }

    public void setCatastropheName1(String catastropheName1) {
        this.catastropheName1 = catastropheName1;
    }

    public String getCatastropheCode2() {
        return catastropheCode2;
    }

    public void setCatastropheCode2(String catastropheCode2) {
        this.catastropheCode2 = catastropheCode2;
    }

    public String getCatastropheName2() {
        return catastropheName2;
    }

    public void setCatastropheName2(String catastropheName2) {
        this.catastropheName2 = catastropheName2;
    }

    public String getClaimType() {
        return claimType;
    }

    public void setClaimType(String claimType) {
        this.claimType = claimType;
    }

    public Double getLossesNumber() {
        return lossesNumber;
    }

    public void setLossesNumber(Double lossesNumber) {
        this.lossesNumber = lossesNumber;
    }

    public String getLossesUnitCode() {
        return lossesUnitCode;
    }

    public void setLossesUnitCode(String lossesUnitCode) {
        this.lossesUnitCode = lossesUnitCode;
    }

    public Double getDamageInsured() {
        return damageInsured;
    }

    public void setDamageInsured(Double damageInsured) {
        this.damageInsured = damageInsured;
    }

    public Double getDisasterArea() {
        return disasterArea;
    }

    public void setDisasterArea(Double disasterArea) {
        this.disasterArea = disasterArea;
    }

    public String getDisasterUnit() {
        return disasterUnit;
    }

    public void setDisasterUnit(String disasterUnit) {
        this.disasterUnit = disasterUnit;
    }

    public Double getAffectedArea() {
        return affectedArea;
    }

    public void setAffectedArea(Double affectedArea) {
        this.affectedArea = affectedArea;
    }

    public String getAffectedUnit() {
        return affectedUnit;
    }

    public void setAffectedUnit(String affectedUnit) {
        this.affectedUnit = affectedUnit;
    }

    public Double getNoProductionArea() {
        return noProductionArea;
    }

    public void setNoProductionArea(Double noProductionArea) {
        this.noProductionArea = noProductionArea;
    }

    public String getNoProductionUnit() {
        return noProductionUnit;
    }

    public void setNoProductionUnit(String noProductionUnit) {
        this.noProductionUnit = noProductionUnit;
    }

    public Double getDeathQuantity() {
        return deathQuantity;
    }

    public void setDeathQuantity(Double deathQuantity) {
        this.deathQuantity = deathQuantity;
    }

    public String getDeathUnit() {
        return deathUnit;
    }

    public void setDeathUnit(String deathUnit) {
        this.deathUnit = deathUnit;
    }

    public Double getKillQuantity() {
        return killQuantity;
    }

    public void setKillQuantity(Double killQuantity) {
        this.killQuantity = killQuantity;
    }

    public String getKillUnit() {
        return killUnit;
    }

    public void setKillUnit(String killUnit) {
        this.killUnit = killUnit;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public String getBusinessType1() {
        return businessType1;
    }

    public void setBusinessType1(String businessType1) {
        this.businessType1 = businessType1;
    }

    public String getMedicalType() {
        return medicalType;
    }

    public void setMedicalType(String medicalType) {
        this.medicalType = medicalType;
    }

    public String getBusinessFlag() {
        return businessFlag;
    }

    public void setBusinessFlag(String businessFlag) {
        this.businessFlag = businessFlag;
    }

    public String getOtherFlag() {
        return otherFlag;
    }

    public void setOtherFlag(String otherFlag) {
        this.otherFlag = otherFlag;
    }

    public String getClaimLossFlag() {
        return claimLossFlag;
    }

    public void setClaimLossFlag(String claimLossFlag) {
        this.claimLossFlag = claimLossFlag;
    }

    public String getAvgFlag() {
        return avgFlag;
    }

    public void setAvgFlag(String avgFlag) {
        this.avgFlag = avgFlag;
    }

    public String getFifteenFlag() {
        return fifteenFlag;
    }

    public void setFifteenFlag(String fifteenFlag) {
        this.fifteenFlag = fifteenFlag;
    }

    public String getThirtyFlag() {
        return thirtyFlag;
    }

    public void setThirtyFlag(String thirtyFlag) {
        this.thirtyFlag = thirtyFlag;
    }

    public String getCancelReasonExplan() {
        return cancelReasonExplan;
    }

    public void setCancelReasonExplan(String cancelReasonExplan) {
        this.cancelReasonExplan = cancelReasonExplan;
    }

    public String getAutoFlag() {
        return autoFlag;
    }

    public void setAutoFlag(String autoFlag) {
        this.autoFlag = autoFlag;
    }

    public Date getClaimTime() {
        return claimTime;
    }

    public void setClaimTime(Date claimTime) {
        this.claimTime = claimTime;
    }

    public String getUpDateBy() {
        return upDateBy;
    }

    public void setUpDateBy(String upDateBy) {
        this.upDateBy = upDateBy;
    }

    public Date getUpDateDate() {
        return upDateDate;
    }

    public void setUpDateDate(Date upDateDate) {
        this.upDateDate = upDateDate;
    }

    public String getRiskName() {
        return riskName;
    }

    public void setRiskName(String riskName) {
        this.riskName = riskName;
    }

    public String getAppliName() {
        return appliName;
    }

    public void setAppliName(String appliName) {
        this.appliName = appliName;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public String getHandler1Name() {
        return handler1Name;
    }

    public void setHandler1Name(String handler1Name) {
        this.handler1Name = handler1Name;
    }

    public String getHandlerName() {
        return handlerName;
    }

    public void setHandlerName(String handlerName) {
        this.handlerName = handlerName;
    }

    public String getMakeComName() {
        return makeComName;
    }

    public void setMakeComName(String makeComName) {
        this.makeComName = makeComName;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getEndCaserName() {
        return endCaserName;
    }

    public void setEndCaserName(String endCaserName) {
        this.endCaserName = endCaserName;
    }

    public String getDealerName() {
        return dealerName;
    }

    public void setDealerName(String dealerName) {
        this.dealerName = dealerName;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }
}
