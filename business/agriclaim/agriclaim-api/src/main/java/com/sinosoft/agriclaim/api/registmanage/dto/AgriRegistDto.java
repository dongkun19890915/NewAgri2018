package com.sinosoft.agriclaim.api.registmanage.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.util.List;

public class AgriRegistDto extends BaseRequest{

    /**险种名称 */
    private String riskCode;

    /**保单号码 */
    private String policyNo;

    /**出险时间:天 */
    private String damageStartDate;

    /**出险小时 */
    private String damageStartHour;

    /**出险分钟 */
    private String damageStartMinute;

    /**出险原因代码 */
    private String damageCode;

    /**出险原因 */
    private String damageName;

    /**详细出险原因 */
    private List<String> damageMessage;

    /**报案人 */
    private String reportorName;

    /**报案时间 */
    private String reportDate;

    /**报案小时:到分钟 */
    private String reportHour;

    /**报案方式 */
    private String reportType;

    /**联系人 */
    private String linkerName;

    /**联系电话 */
    private String phoneNumber;

    /**赔付数量 */
    private Double lossesNumber;

    /**赔付单位(11亩，13头) */
    private String lossesUnitCode;

    /**出险地邮政编码 */
    private String addressCode;

    /**出险地点 */
    private String damageAddress;

    /**币别 */
    private String estiCurrency;

    /**报损金额 默认0 */
    private Double estimateLoss;

    /**受损标的 */
    private String lossName;

    /**事故者信息 */
    private AcciPersonDto[] acciPersonDtoList;

    /**接报案员代码 */
    private String operatorCode;

    /**接报案员姓名 */
    private String operatorName;

    /**理赔登记部门代码 */
    private String makeCom;

    /**理赔登记部门 */
    private String makeComName;

    /**出险摘要 */
    private String Remark;

    /**巨灾一级代码 */
    private String textContext;

    /**巨灾一级代码 */
    private String catastropheCode1;

    /**巨灾一级名称 */
    private String catastropheName1;

    /**巨灾二级代码 */
    private String catastropheCode2;

    /**巨灾二级名称 */
    private String catastropheName2;

    /**耳标号清单
     养殖险专用 */
    private Object[] earNoList;

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

    public List<String> getDamageMessage() {
        return damageMessage;
    }

    public void setDamageMessage(List<String> damageMessage) {
        this.damageMessage = damageMessage;
    }

    public String getReportorName() {
        return reportorName;
    }

    public void setReportorName(String reportorName) {
        this.reportorName = reportorName;
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

    public Double getEstimateLoss() {
        return estimateLoss;
    }

    public void setEstimateLoss(Double estimateLoss) {
        this.estimateLoss = estimateLoss;
    }

    public String getLossName() {
        return lossName;
    }

    public void setLossName(String lossName) {
        this.lossName = lossName;
    }

    public AcciPersonDto[] getAcciPersonDtoList() {
        return acciPersonDtoList;
    }

    public void setAcciPersonDtoList(AcciPersonDto[] acciPersonDtoList) {
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

    public Object[] getEarNoList() {
        return earNoList;
    }

    public void setEarNoList(Object[] earNoList) {
        this.earNoList = earNoList;
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
}
