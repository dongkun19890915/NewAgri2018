package com.sinosoft.agriprpall.api.paymanage.dto;

import com.sinosoft.framework.agri.core.excel.annotation.ExportConfig;
import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;

/**
 * 批改后清单表
 *
 * @author: 何伟东
 * @date: 2018/1/11 14:33
 */
public class CPEndorseListToExcelDto extends BaseRequest implements Serializable {

    /**
     * 序号
     */
    @ExportConfig(value = "序号", width = 50)
    private int serialNo;
    /**
     * 批单号
     */
    @ExportConfig(value = "批单号", width = 220)
    private String endorseNo;
    /**
     * 保单号
     */
    @ExportConfig(value = "保单号", width = 200)
    private String policyNo;
    /**
     * 农户代码
     */
    @ExportConfig(value = "农户代码", width = 170)
    private String fCode;
    /**
     * 农户姓名
     */
    @ExportConfig(value = "农户姓名", width = 120)
    private String fName;
    /**
     * 身份证号码
     */
    @ExportConfig(value = "身份证号码", width = 170)
    private String fIdCard;
    /**
     * 银行卡号
     */
    @ExportConfig(value = "银行卡号", width = 160)
    private String bankCard;
    /**
     * 联系电话
     */
    @ExportConfig(value = "联系电话", width = 120)
    private String phone;
    /**
     * 投保面积（亩）
     */
    @ExportConfig(value = "投保面积（亩）")
    private Double insureArea;
    /**
     * 险别名称
     */
    @ExportConfig(value = "险别")
    private String kindName;
    /**
     * 险别代码
     */
    private String kindCode;
    /**
     * 标的名称
     */
    @ExportConfig(value = "标的")
    private String itemName;
    /**
     * 标的代码
     */
    private String itemCode;
    /**
     * 总保额（元）
     */
    @ExportConfig(value = "总保额（元）")
    private Double sumAmount;
    /**
     * 总保费（元）
     */
    @ExportConfig(value = "总保费（元）")
    private Double sumPremium;
    /**
     * 自缴保费（元）
     */
    @ExportConfig(value = "自缴保费（元）")
    private Double fPremium;
    /**
     * 中央财政补贴（元）
     */
    @ExportConfig(value = "中央财政补贴（元）")
    private Double centralPremium;
    /**
     * 省级财政补贴（元）
     */
    @ExportConfig(value = "省级财政补贴（元）")
    private Double provincePremium;
    /**
     * 地市财政补贴（元）
     */
    @ExportConfig(value = "地市财政补贴（元）")
    private Double cityPremium;
    /**
     * 区（县）财政（元）
     */
    @ExportConfig(value = "区（县）财政（元）")
    private Double townPremium;
    /**
     * 其他来源补贴（元）
     */
    @ExportConfig(value = "其他来源补贴（元）")
    private Double otherPremium;
    /**
     * 粮补面积
     */
    @ExportConfig(value = "粮补面积")
    private Double areaNumber;
    /**
     * 土地来源
     */
    @ExportConfig(value = "土地来源")
    private String fieldSource;
    /**
     * 备注
     */
    @ExportConfig(value = "备注")
    private String remark;

    public int getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(int serialNo) {
        this.serialNo = serialNo;
    }

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

    public String getfCode() {
        return fCode;
    }

    public void setfCode(String fCode) {
        this.fCode = fCode;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getfIdCard() {
        return fIdCard;
    }

    public void setfIdCard(String fIdCard) {
        this.fIdCard = fIdCard;
    }

    public String getBankCard() {
        return bankCard;
    }

    public void setBankCard(String bankCard) {
        this.bankCard = bankCard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Double getInsureArea() {
        return insureArea;
    }

    public void setInsureArea(Double insureArea) {
        this.insureArea = insureArea;
    }

    public String getKindName() {
        return kindName;
    }

    public void setKindName(String kindName) {
        this.kindName = kindName;
    }

    public String getKindCode() {
        return kindCode;
    }

    public void setKindCode(String kindCode) {
        this.kindCode = kindCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public Double getSumAmount() {
        return sumAmount;
    }

    public void setSumAmount(Double sumAmount) {
        this.sumAmount = sumAmount;
    }

    public Double getSumPremium() {
        return sumPremium;
    }

    public void setSumPremium(Double sumPremium) {
        this.sumPremium = sumPremium;
    }

    public Double getfPremium() {
        return fPremium;
    }

    public void setfPremium(Double fPremium) {
        this.fPremium = fPremium;
    }

    public Double getCentralPremium() {
        return centralPremium;
    }

    public void setCentralPremium(Double centralPremium) {
        this.centralPremium = centralPremium;
    }

    public Double getProvincePremium() {
        return provincePremium;
    }

    public void setProvincePremium(Double provincePremium) {
        this.provincePremium = provincePremium;
    }

    public Double getCityPremium() {
        return cityPremium;
    }

    public void setCityPremium(Double cityPremium) {
        this.cityPremium = cityPremium;
    }

    public Double getTownPremium() {
        return townPremium;
    }

    public void setTownPremium(Double townPremium) {
        this.townPremium = townPremium;
    }

    public Double getOtherPremium() {
        return otherPremium;
    }

    public void setOtherPremium(Double otherPremium) {
        this.otherPremium = otherPremium;
    }

    public Double getAreaNumber() {
        return areaNumber;
    }

    public void setAreaNumber(Double areaNumber) {
        this.areaNumber = areaNumber;
    }

    public String getFieldSource() {
        return fieldSource;
    }

    public void setFieldSource(String fieldSource) {
        this.fieldSource = fieldSource;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
