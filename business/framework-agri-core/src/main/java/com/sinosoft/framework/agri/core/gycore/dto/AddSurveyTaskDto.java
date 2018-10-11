package com.sinosoft.framework.agri.core.gycore.dto;

/**
 * description:
 *
 * @outhor wq
 * @create 2018-04-02 14:08
 */
public class AddSurveyTaskDto {
    //报案号码
    private String registNo;
    //险种代码
    private String riskCode;
    //险种名称
    private String riskName;
    //保单号码
    private String policyNo;
    //出险时间：天
    private String damageStartDate;
    //出险小时
    private String damageStartHour;
    //出险分钟
    private String damageStartMinute;
    //出险原因代码
    private String damageCode;
    //出险原因
    private String damageName;
    //详细出险原因
    private String damageMessage;
    //报案人
    private String reportorName;
    //报案时间
    private String reportDate;
    //报案小时:到分钟
    private String reportHour;
    //报案方式
    private String reportType;
    //联系人
    private String linkerName;
    //联系电话
    private String phoneNumber;
    //出险地邮政编码
    private String addressCode;
    //出险地点
    private String damageAddress;
    //币别
    private String estiCurrency;
    //报损金额 默认0
    private String estimateLoss;
    //受损标的
    private String lossName;
    //事故者信息
    private String acciPersonDtoList;
    //接报案员代码
    private String operatorCode;
    //接报案员姓名
    private String operatorName;
    //理赔登记部门代码
    private String makeCom;
    //理赔登记部门
    private String makeComName;
    //备注
    private String Remark;
    //出险摘要
    private String textContext;
    //巨灾一级代码
    private String catastropheCode1;
    //巨灾名称
    private String catastropheName1;
    //巨灾二级代码
    private String catastropheCode2;
    //巨灾名称
    private String catastropheName2;
    //关联的预投保清单号（金禾
    private String insuranceListCode;
    //报案处理人代码
    private String opUserCode;
    //报案处理人姓名
    private String opUserName;
    //被调度人代码
    private String adjustUserCode;
    //被调度人姓名
    private String adjustUserName;

    public String getRegistNo() {
        return registNo;
    }

    public void setRegistNo(String registNo) {
        this.registNo = registNo;
    }

    public String getRiskCode() {
        return riskCode;
    }

    public void setRiskCode(String riskCode) {
        this.riskCode = riskCode;
    }

    public String getRiskName() {
        return riskName;
    }

    public void setRiskName(String riskName) {
        this.riskName = riskName;
    }

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }

    public String getDamageStartDate() {
        return damageStartDate;
    }

    public void setDamageStartDate(String damageStartDate) {
        this.damageStartDate = damageStartDate;
    }

    public String getDamageStartHour() {
        return damageStartHour;
    }

    public void setDamageStartHour(String damageStartHour) {
        this.damageStartHour = damageStartHour;
    }

    public String getDamageStartMinute() {
        return damageStartMinute;
    }

    public void setDamageStartMinute(String damageStartMinute) {
        this.damageStartMinute = damageStartMinute;
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

    public String getDamageMessage() {
        return damageMessage;
    }

    public void setDamageMessage(String damageMessage) {
        this.damageMessage = damageMessage;
    }

    public String getReportorName() {
        return reportorName;
    }

    public void setReportorName(String reportorName) {
        this.reportorName = reportorName;
    }

    public String getReportDate() {
        return reportDate;
    }

    public void setReportDate(String reportDate) {
        this.reportDate = reportDate;
    }

    public String getReportHour() {
        return reportHour;
    }

    public void setReportHour(String reportHour) {
        this.reportHour = reportHour;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public String getLinkerName() {
        return linkerName;
    }

    public void setLinkerName(String linkerName) {
        this.linkerName = linkerName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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

    public String getEstiCurrency() {
        return estiCurrency;
    }

    public void setEstiCurrency(String estiCurrency) {
        this.estiCurrency = estiCurrency;
    }

    public String getEstimateLoss() {
        return estimateLoss;
    }

    public void setEstimateLoss(String estimateLoss) {
        this.estimateLoss = estimateLoss;
    }

    public String getLossName() {
        return lossName;
    }

    public void setLossName(String lossName) {
        this.lossName = lossName;
    }

    public String getAcciPersonDtoList() {
        return acciPersonDtoList;
    }

    public void setAcciPersonDtoList(String acciPersonDtoList) {
        this.acciPersonDtoList = acciPersonDtoList;
    }

    public String getOperatorCode() {
        return operatorCode;
    }

    public void setOperatorCode(String operatorCode) {
        this.operatorCode = operatorCode;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getMakeCom() {
        return makeCom;
    }

    public void setMakeCom(String makeCom) {
        this.makeCom = makeCom;
    }

    public String getMakeComName() {
        return makeComName;
    }

    public void setMakeComName(String makeComName) {
        this.makeComName = makeComName;
    }

    public String getRemark() {
        return Remark;
    }

    public void setRemark(String remark) {
        Remark = remark;
    }

    public String getTextContext() {
        return textContext;
    }

    public void setTextContext(String textContext) {
        this.textContext = textContext;
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

    public String getInsuranceListCode() {
        return insuranceListCode;
    }

    public void setInsuranceListCode(String insuranceListCode) {
        this.insuranceListCode = insuranceListCode;
    }

    public String getOpUserCode() {
        return opUserCode;
    }

    public void setOpUserCode(String opUserCode) {
        this.opUserCode = opUserCode;
    }

    public String getOpUserName() {
        return opUserName;
    }

    public void setOpUserName(String opUserName) {
        this.opUserName = opUserName;
    }

    public String getAdjustUserCode() {
        return adjustUserCode;
    }

    public void setAdjustUserCode(String adjustUserCode) {
        this.adjustUserCode = adjustUserCode;
    }

    public String getAdjustUserName() {
        return adjustUserName;
    }

    public void setAdjustUserName(String adjustUserName) {
        this.adjustUserName = adjustUserName;
    }


//    //报案号码（我方调用报案接口传递的报案号）
//    private String registNo;
//
//    //流程编号
//    private String flowId;
//
//    //序号
//    private String logNo;
//
//    //预投保单号码
//    private String insuranceListCode;
//
//    //发起人用户名
//    private String createUserCode;
//
//    //发起人姓名
//    private String createUserName;
//
//    public String getRegistNo() {
//        return registNo;
//    }
//
//    public void setRegistNo(String registNo) {
//        this.registNo = registNo;
//    }
//
//    public String getFlowId() {
//        return flowId;
//    }
//
//    public void setFlowId(String flowId) {
//        this.flowId = flowId;
//    }
//
//    public String getLogNo() {
//        return logNo;
//    }
//
//    public void setLogNo(String logNo) {
//        this.logNo = logNo;
//    }
//
//    public String getInsuranceListCode() {
//        return insuranceListCode;
//    }
//
//    public void setInsuranceListCode(String insuranceListCode) {
//        this.insuranceListCode = insuranceListCode;
//    }
//
//    public String getCreateUserCode() {
//        return createUserCode;
//    }
//
//    public void setCreateUserCode(String createUserCode) {
//        this.createUserCode = createUserCode;
//    }
//
//    public String getCreateUserName() {
//        return createUserName;
//    }
//
//    public void setCreateUserName(String createUserName) {
//        this.createUserName = createUserName;
//    }
}
