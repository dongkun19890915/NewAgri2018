package com.sinosoft.txnlist.api.insuremainlist.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time 2018-04-16 10:32:04.893
 * 草莓组合险连带被保险人表3Api操作对象
 */
public class CMPManFieldListDto extends BaseRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 属性清单号/清单号
     */
    private String insureListCode;
    /**
     * 属性农户代码/农户代码
     */
    private String fCode;
    /**
     * 属性标的代码/标的代码
     */
    private String itemCode;
    /**
     * 属性连带被保险人证件号码/连带被保险人证件号码
     */
    private String idCard;
    /**
     * 属性险别代码/险别代码
     */
    private String kindCode;
    /**
     * 属性连带被保险人证件类型/连带被保险人证件类型
     */
    private String idType;
    /**
     * 属性连带被保险人姓名/连带被保险人姓名
     */
    private String name;
    /**
     * 属性连带被保险人性别/连带被保险人性别
     */
    private String sex;
    /**
     * 属性连带被保险人与农户关系/连带被保险人与农户关系
     */
    private String relation;
    /**
     * 属性行业类别/行业类别
     */
    private String industryCategory;
    /**
     * 属性总保额/总保额
     */
    private Double sumAmount;
    /**
     * 属性总保费/总保费
     */
    private Double sumPremium;
    /**
     * 属性费率/费率
     */
    private Double rate;
    /**
     * 属性农民自缴保费/农民自缴保费
     */
    private Double fPremium;
    /**
     * 属性中央财政补贴/中央财政补贴
     */
    private Double centralPremium;
    /**
     * 属性省级财政补贴/省级财政补贴
     */
    private Double provincePremium;
    /**
     * 属性地市财政补贴/地市财政补贴
     */
    private Double cityPremium;
    /**
     * 属性县(区)财政补贴/县(区)财政补贴
     */
    private Double townPremium;
    /**
     * 属性其他来源补贴/其他来源补贴
     */
    private Double otherPremium;
    /**
     * 属性总保额变化量/总保额变化量
     */
    private String chgSumAmount;
    /**
     * 属性总保费变化量/总保费变化量
     */
    private String chgSumPremium;
    /**
     * 属性费率变化量/费率变化量
     */
    private String chgRate;
    /**
     * 属性农民自缴保费变化量/农民自缴保费变化量
     */
    private Double chgfPremium;
    /**
     * 属性中央财政补贴变化量/中央财政补贴变化量
     */
    private Double chgCentralPremium;
    /**
     * 属性省级财政补贴变化量/省级财政补贴变化量
     */
    private Double chgProvincePremium;
    /**
     * 属性地市财政补贴变化量/地市财政补贴变化量
     */
    private Double chgCityPremium;
    /**
     * 属性县(区)财政补贴变化量/县(区)财政补贴变化量
     */
    private Double chgTownPremium;
    /**
     * 属性其他来源补贴变化量/其他来源补贴变化量
     */
    private Double chgOtherPremium;

    public String getInsureListCode() {
        return insureListCode;
    }

    public void setInsureListCode(String insureListCode) {
        this.insureListCode = insureListCode;
    }

    public String getfCode() {
        return fCode;
    }

    public void setfCode(String fCode) {
        this.fCode = fCode;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getKindCode() {
        return kindCode;
    }

    public void setKindCode(String kindCode) {
        this.kindCode = kindCode;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getIndustryCategory() {
        return industryCategory;
    }

    public void setIndustryCategory(String industryCategory) {
        this.industryCategory = industryCategory;
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

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
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

    public String getChgSumAmount() {
        return chgSumAmount;
    }

    public void setChgSumAmount(String chgSumAmount) {
        this.chgSumAmount = chgSumAmount;
    }

    public String getChgSumPremium() {
        return chgSumPremium;
    }

    public void setChgSumPremium(String chgSumPremium) {
        this.chgSumPremium = chgSumPremium;
    }

    public String getChgRate() {
        return chgRate;
    }

    public void setChgRate(String chgRate) {
        this.chgRate = chgRate;
    }

    public Double getChgfPremium() {
        return chgfPremium;
    }

    public void setChgfPremium(Double chgfPremium) {
        this.chgfPremium = chgfPremium;
    }

    public Double getChgCentralPremium() {
        return chgCentralPremium;
    }

    public void setChgCentralPremium(Double chgCentralPremium) {
        this.chgCentralPremium = chgCentralPremium;
    }

    public Double getChgProvincePremium() {
        return chgProvincePremium;
    }

    public void setChgProvincePremium(Double chgProvincePremium) {
        this.chgProvincePremium = chgProvincePremium;
    }

    public Double getChgCityPremium() {
        return chgCityPremium;
    }

    public void setChgCityPremium(Double chgCityPremium) {
        this.chgCityPremium = chgCityPremium;
    }

    public Double getChgTownPremium() {
        return chgTownPremium;
    }

    public void setChgTownPremium(Double chgTownPremium) {
        this.chgTownPremium = chgTownPremium;
    }

    public Double getChgOtherPremium() {
        return chgOtherPremium;
    }

    public void setChgOtherPremium(Double chgOtherPremium) {
        this.chgOtherPremium = chgOtherPremium;
    }
}
