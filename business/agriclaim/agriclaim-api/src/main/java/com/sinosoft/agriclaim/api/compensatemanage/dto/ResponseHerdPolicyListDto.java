package com.sinosoft.agriclaim.api.compensatemanage.dto;
import com.sinosoft.framework.agri.core.excel.annotation.ExportConfig;
import java.io.Serializable;

public class ResponseHerdPolicyListDto implements Serializable {
    /** 序号*/
    @ExportConfig(value = "序号",width = 28)
    private int id;
    /** 投保单号*/
    @ExportConfig(value = "投保单号",width = 67)
    private String inusrelistCode;
    /** 保单号*/
    @ExportConfig(value = "保单号",width = 67)
    private String policyNo;
    /** 农户代码*/
    @ExportConfig(value = "农户代码",width = 67)
    private String fCode;
    /** 农户姓名*/
    @ExportConfig(value = "农户姓名",width = 67)
    private String fName;
    /** 身份证号码*/
    @ExportConfig(value = "身份证号码",width=149)
    private String businessNo;
    /** 银行卡号*/
    @ExportConfig(value = "银行卡号",width = 155)
    private String bank;
    /** 饲养地点*/
    @ExportConfig(value = "饲养地点",width = 64)
    private String breedingAreaName;
    /** 饲养品种*/
    @ExportConfig(value = "饲养品种",width = 75)
    private String species;
    /** 饲养方式*/
    @ExportConfig(value = "饲养方式",width = 134)
    private String breedingKind;
    /** 耳标号*/
    @ExportConfig(value = "耳标号",width = 75)
    private String earLable;
    /** 险别*/
    @ExportConfig(value = "险别")
    private String kindCode;
    /** 标的*/
    @ExportConfig(value = "标的",width=75)
    private String itemCode;
    /** 总保额（元）*/
    @ExportConfig(value = "总保额（元）",width = 116)
    private Double sumAmount;
    /** 总保费*/
    @ExportConfig(value = "总保费（元）",width = 108)
    private Double sumPremium;
    /** 自缴保费（元）*/
    @ExportConfig(value = "自缴保费（元）",width = 125)
    private Double insurepremium;
    /** 中央财政补贴（元）*/
    @ExportConfig(value = "中央财政补贴（元）",width = 104)
    private Double centralPremium;
    /** 省级财政补贴（元）*/
    @ExportConfig(value = "省级财政补贴（元）",width = 62)
    private Double provincePremium;
    /** 地市财政补贴（元）*/
    @ExportConfig(value = "地市财政补贴（元）",width = 64)
    private Double cityPremium;
    /** 区（县）财政（元）*/
    @ExportConfig(value = "区（县）财政（元）",width = 64)
    private Double townPremium;
    /** 其他来源补贴（元）*/
    @ExportConfig(value = "其他来源补贴（元）",width = 64)
    private Double otherPremium;
    /** 备注*/
    @ExportConfig(value = "备注",width = 64)
    private String remark;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInusrelistCode() {
        return inusrelistCode;
    }

    public void setInusrelistCode(String inusrelistCode) {
        this.inusrelistCode = inusrelistCode;
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

    public String getBusinessNo() {
        return businessNo;
    }

    public void setBusinessNo(String businessNo) {
        this.businessNo = businessNo;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getBreedingAreaName() {
        return breedingAreaName;
    }

    public void setBreedingAreaName(String breedingAreaName) {
        this.breedingAreaName = breedingAreaName;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getBreedingKind() {
        return breedingKind;
    }

    public void setBreedingKind(String breedingKind) {
        this.breedingKind = breedingKind;
    }

    public String getEarLable() {
        return earLable;
    }

    public void setEarLable(String earLable) {
        this.earLable = earLable;
    }

    public String getKindCode() {
        return kindCode;
    }

    public void setKindCode(String kindCode) {
        this.kindCode = kindCode;
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

    public Double getInsurepremium() {
        return insurepremium;
    }

    public void setInsurepremium(Double insurepremium) {
        this.insurepremium = insurepremium;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
