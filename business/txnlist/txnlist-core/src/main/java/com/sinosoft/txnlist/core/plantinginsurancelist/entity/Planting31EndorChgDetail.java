package com.sinosoft.txnlist.core.plantinginsurancelist.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;

import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time 2017-11-18 08:36:26.740
 * planting31endorchgdetail实体操作对象
 */
@Entity
@Table(name = "planting31EndorChgDetail")
@IdClass(Planting31EndorChgDetailKey.class)
public class Planting31EndorChgDetail extends BaseEntityImpl {

    private static final long serialVersionUID = 1L;
    /**
     * 属性inusreListCode/inusreListCode
     */
    @Id
    @Column(name = "inusreListCode")
    private String inusreListCode;
    /**
     * 属性endorseNo/endorseNo
     */
    @Id
    @Column(name = "endorseNo")
    private String endorseNo;
    /**
     * 属性kindCode/kindCode
     */
    @Id
    @Column(name = "kindCode")
    private String kindCode;
    /**
     * 属性itemCode/itemCode
     */
    @Id
    @Column(name = "itemCode")
    private String itemCode;
    /**
     * 属性fIdCard/fIdCard
     */
    @Id
    @Column(name = "fIdCard")
    private String fIdCard;


    /**
     * 属性fCode/fCode
     */
    @Column(name = "fCode")
    private String fCode;


    /**
     * 属性indexCode/indexCode
     */
    @Column(name = "indexCode")
    private String indexCode;
    /**
     * 属性phone/phone
     */
    @Column(name = "phone")
    private String phone;
    /**
     * 属性bank/bank
     */
    @Column(name = "bank")
    private String bank;
    /**
     * 属性zhiBuKa/zhiBuKa
     */
    @Column(name = "zhiBuKa")
    private String zhiBuKa;
    /**
     * 属性fName/fName
     */
    @Column(name = "fName")
    private String fName;

    /**
     * 属性classCode/classCode
     */
    @Column(name = "classCode")
    private String classCode;
    /**
     * 属性riskCode/riskCode
     */
    @Column(name = "riskCode")
    private String riskCode;
    /**
     * 属性fareaCode/fareaCode
     */
    @Column(name = "fareaCode")
    private String fareaCode;
    /**
     * 属性taxArea/taxArea
     */
    @Column(name = "taxArea")
    private java.lang.Double taxArea;
    /**
     * 属性insureArea/insureArea
     */
    @Column(name = "insureArea")
    private java.lang.Double insureArea;
    /**
     * 属性amount/amount
     */
    @Column(name = "amount")
    private java.lang.Double amount;
    /**
     * 属性rate/rate
     */
    @Column(name = "rate")
    private java.lang.Double rate;
    /**
     * 属性shortRateFlag/shortRateFlag
     */
    @Column(name = "shortRateFlag")
    private String shortRateFlag;
    /**
     * 属性shortRate/shortRate
     */
    @Column(name = "shortRate")
    private java.lang.Double shortRate;
    /**
     * 属性sumAmount/sumAmount
     */
    @Column(name = "sumAmount")
    private java.lang.Double sumAmount;
    /**
     * 属性sumPremium/sumPremium
     */
    @Column(name = "sumPremium")
    private java.lang.Double sumPremium;
    /**
     * 属性startDate/startDate
     */
    @Column(name = "startDate")
    private java.util.Date startDate;
    /**
     * 属性endDate/endDate
     */
    @Column(name = "endDate")
    private java.util.Date endDate;
    /**
     * 属性calculateFlag/calculateFlag
     */
    @Column(name = "calculateFlag")
    private String calculateFlag;
    /**
     * 属性opCode/opCode
     */
    @Column(name = "opCode")
    private String opCode;
    /**
     * 属性opTime/opTime
     */
    @Column(name = "opTime")
    private java.util.Date opTime;
    /**
     * 属性validity/validity
     */
    @Column(name = "validity")
    private String validity;
    /**
     * 属性remark/remark
     */
    @Column(name = "remark")
    private String remark;
    /**
     * 属性fPremium/fPremium
     */
    @Column(name = "fPremium")
    private java.lang.Double fPremium;
    /**
     * 属性teamName/teamName
     */
    @Column(name = "teamName")
    private String teamName;
    /**
     * 属性centralPremium/centralPremium
     */
    @Column(name = "centralPremium")
    private java.lang.Double centralPremium;
    /**
     * 属性provincePremium/provincePremium
     */
    @Column(name = "provincePremium")
    private java.lang.Double provincePremium;
    /**
     * 属性cityPremium/cityPremium
     */
    @Column(name = "cityPremium")
    private java.lang.Double cityPremium;
    /**
     * 属性townPremium/townPremium
     */
    @Column(name = "townPremium")
    private java.lang.Double townPremium;
    /**
     * 属性otherPremium/otherPremium
     */
    @Column(name = "otherPremium")
    private java.lang.Double otherPremium;
    /**
     * 属性chgInsureArea/chgInsureArea
     */
    @Column(name = "chgInsureArea")
    private java.lang.Double chgInsureArea;
    /**
     * 属性chgSumAmount/chgSumAmount
     */
    @Column(name = "chgSumAmount")
    private java.lang.Double chgSumAmount;
    /**
     * 属性chgSumPremium/chgSumPremium
     */
    @Column(name = "chgSumPremium")
    private java.lang.Double chgSumPremium;
    /**
     * 属性fieldSource/fieldSource
     */
    @Column(name = "fieldSource")
    private String fieldSource;
    /**
     * 属性flag/flag
     */
    @Column(name = "flag")
    private String flag;
    /**
     * 属性mulchdate/mulchdate
     */
    @Column(name = "mulchDate")
    private String mulchDate;
    /**
     * 属性mulchtype/mulchtype
     */
    @Column(name = "mulchType")
    private String mulchType;

    /**
     * 自缴保费变化量
     */
    @Column(name = "chgFPremium")
    private Double chgFPremium;
    /**
     * 中央财政补贴变化量
     */
    @Column(name = "chgCentralPremium")
    private Double chgCentralPremium;
    /**
     * 省级财政补贴变化量
     */
    @Column(name = "chgProvincePremium")
    private Double chgProvincePremium;
    /**
     * 地市财政补贴变化量
     */
    @Column(name = "chgCityPremium")
    private Double chgCityPremium;
    /**
     * 区（县）财政变化量
     */
    @Column(name = "chgTownPremium")
    private Double chgTownPremium;
    /**
     * 其他来源补贴变化量
     */
    @Column(name = "chgOtherPremium")
    private Double chgOtherPremium;

    public String getInusreListCode() {
        return inusreListCode;
    }

    public void setInusreListCode(String inusreListCode) {
        this.inusreListCode = inusreListCode;
    }

    public String getEndorseNo() {
        return endorseNo;
    }

    public void setEndorseNo(String endorseNo) {
        this.endorseNo = endorseNo;
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

    public String getfIdCard() {
        return fIdCard;
    }

    public void setfIdCard(String fIdCard) {
        this.fIdCard = fIdCard;
    }

    public String getfCode() {
        return fCode;
    }

    public void setfCode(String fCode) {
        this.fCode = fCode;
    }

    public String getIndexCode() {
        return indexCode;
    }

    public void setIndexCode(String indexCode) {
        this.indexCode = indexCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getZhiBuKa() {
        return zhiBuKa;
    }

    public void setZhiBuKa(String zhiBuKa) {
        this.zhiBuKa = zhiBuKa;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
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

    public String getFareaCode() {
        return fareaCode;
    }

    public void setFareaCode(String fareaCode) {
        this.fareaCode = fareaCode;
    }

    public Double getTaxArea() {
        return taxArea;
    }

    public void setTaxArea(Double taxArea) {
        this.taxArea = taxArea;
    }

    public Double getInsureArea() {
        return insureArea;
    }

    public void setInsureArea(Double insureArea) {
        this.insureArea = insureArea;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getCalculateFlag() {
        return calculateFlag;
    }

    public void setCalculateFlag(String calculateFlag) {
        this.calculateFlag = calculateFlag;
    }

    public String getOpCode() {
        return opCode;
    }

    public void setOpCode(String opCode) {
        this.opCode = opCode;
    }

    public Date getOpTime() {
        return opTime;
    }

    public void setOpTime(Date opTime) {
        this.opTime = opTime;
    }

    public String getValidity() {
        return validity;
    }

    public void setValidity(String validity) {
        this.validity = validity;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Double getfPremium() {
        return fPremium;
    }

    public void setfPremium(Double fPremium) {
        this.fPremium = fPremium;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
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

    public Double getChgInsureArea() {
        return chgInsureArea;
    }

    public void setChgInsureArea(Double chgInsureArea) {
        this.chgInsureArea = chgInsureArea;
    }

    public Double getChgSumAmount() {
        return chgSumAmount;
    }

    public void setChgSumAmount(Double chgSumAmount) {
        this.chgSumAmount = chgSumAmount;
    }

    public Double getChgSumPremium() {
        return chgSumPremium;
    }

    public void setChgSumPremium(Double chgSumPremium) {
        this.chgSumPremium = chgSumPremium;
    }

    public String getFieldSource() {
        return fieldSource;
    }

    public void setFieldSource(String fieldSource) {
        this.fieldSource = fieldSource;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getMulchDate() {
        return mulchDate;
    }

    public void setMulchDate(String mulchDate) {
        this.mulchDate = mulchDate;
    }

    public String getMulchType() {
        return mulchType;
    }

    public void setMulchType(String mulchType) {
        this.mulchType = mulchType;
    }

    public Double getChgFPremium() {
        return chgFPremium;
    }

    public void setChgFPremium(Double chgFPremium) {
        this.chgFPremium = chgFPremium;
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