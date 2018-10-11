package com.sinosoft.txnlist.core.plantinginsurancelist.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;

import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time 2017-12-08 01:17:24.831
 * HerdcEndorChgDetail实体操作对象
 */
@Entity
@Table(name = "HerdcEndorChgDetail")
@IdClass(HerdcEndorChgDetailKey.class)
public class HerdcEndorChgDetail extends BaseEntityImpl {

    private static final long serialVersionUID = 1L;
    /**
     * 属性inusreListCode/inusreListCode
     */
    @Id
    @Column(name = "inusreListCode")
    private String inusreListCode;
    /**
     * 属性earLabel/earLabel
     */
    @Id
    @Column(name = "earLabel")
    private String earLabel;
    /**
     * 属性kindCode/kindCode
     */
    @Id
    @Column(name = "kindCode")
    private String kindCode;
    /**
     * 属性fCode/fCode
     */
    @Id
    @Column(name = "fCode")
    private String fCode;


    /**
     * 属性indexCode/indexCode
     */
    @Column(name = "indexCode")
    private String indexCode;

    /**
     * 属性fName/fName
     */
    @Column(name = "fName")
    private String fName;
    /**
     * 属性fIdCard/fIdCard
     */
    @Column(name = "fIdCard")
    private String fIdCard;
    /**
     * 属性breedingAreaCode/breedingAreaCode
     */
    @Column(name = "breedingAreaCode")
    private String breedingAreaCode;
    /**
     * 属性species/species
     */
    @Column(name = "species")
    private String species;
    /**
     * 属性breedingKind/breedingKind
     */
    @Column(name = "breedingKind")
    private String breedingKind;
    /**
     * 属性bank/bank
     */
    @Column(name = "bank")
    private String bank;
    /**
     * 属性bankCard/bankCard
     */
    @Column(name = "bankCard")
    private String bankCard;
    /**
     * 属性insureNumber/insureNumber
     */
    @Column(name = "insureNumber")
    private Integer insureNumber;
    /**
     * 属性amount/amount
     */
    @Column(name = "amount")
    private Double amount;
    /**
     * 属性rate/rate
     */
    @Column(name = "rate")
    private Double rate;
    /**
     * 属性shortRateFlag/shortRateFlag
     */
    @Column(name = "shortRateFlag")
    private String shortRateFlag;
    /**
     * 属性shortRate/shortRate
     */
    @Column(name = "shortRate")
    private Double shortRate;
    /**
     * 属性sumAmount/sumAmount
     */
    @Column(name = "sumAmount")
    private Double sumAmount;
    /**
     * 属性sumPremium/sumPremium
     */
    @Column(name = "sumPremium")
    private Double sumPremium;
    /**
     * 属性startDate/startDate
     */
    @Column(name = "startDate")
    private Date startDate;
    /**
     * 属性endDate/endDate
     */
    @Column(name = "endDate")
    private Date endDate;
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
    private Date opTime;
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
     * 属性breedingNumber/breedingNumber
     */
    @Column(name = "breedingNumber")
    private Integer breedingNumber;
    /**
     * 属性breedingAreaName/breedingAreaName
     */
    @Column(name = "breedingAreaName")
    private String breedingAreaName;
    /**
     * 属性startTime/startTime
     */
    @Column(name = "startTime")
    private String startTime;
    /**
     * 属性endTime/endTime
     */
    @Column(name = "endTime")
    private String endTime;
    /**
     * 属性phone/phone
     */
    @Column(name = "phone")
    private String phone;
    /**
     * 属性settleNumber/settleNumber
     */
    @Column(name = "settleNumber")
    private Integer settleNumber;
    /**
     * 属性insurePremium/insurePremium
     */
    @Column(name = "insurePremium")
    private Double insurePremium;
    /**
     * 属性areaNumber/areaNumber
     */
    @Column(name = "areaNumber")
    private Double areaNumber;
    /**
     * 属性litterArea/litterArea
     */
    @Column(name = "litterArea")
    private String litterArea;
    /**
     * 属性aniMalage/aniMalage
     */
    @Column(name = "animalAge")
    private Double animalAge;

    /**
     * 标的代码
     */
    @Column(name = "itemCode")
    private String itemCode;

    /**
     * 属性中央财政补贴/中央财政补贴
     */
    @Column(name = "centralPremium")
    private Double centralPremium;
    /**
     * 属性省级财政补贴/省级财政补贴
     */
    @Column(name = "provincePremium")
    private Double provincePremium;
    /**
     * 属性地市财政补贴/地市财政补贴
     */
    @Column(name = "cityPremium")
    private Double cityPremium;
    /**
     * 属性县(区)财政补贴/县(区)财政补贴
     */
    @Column(name = "townPremium")
    private Double townPremium;
    /**
     * 属性其他来源补贴/其他来源补贴
     */
    @Column(name = "otherPremium")
    private Double otherPremium;
    /**
     * 属性农民自缴保费/农民自缴保费
     */
    @Column(name = "fPremium")
    private Double fPremium;

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    /**
     * 属性inusreListCode/inusreListCode的getter方法
     */
    public String getInusreListCode() {
        return inusreListCode;
    }

    /**
     * 属性inusreListCode/inusreListCode的setter方法
     */
    public void setInusreListCode(String inusreListCode) {
        this.inusreListCode = inusreListCode;
    }

    /**
     * 属性earLabel/earLabel的getter方法
     */
    public String getEarLabel() {
        return earLabel;
    }

    /**
     * 属性earLabel/earLabel的setter方法
     */
    public void setEarLabel(String earLabel) {
        this.earLabel = earLabel;
    }

    /**
     * 属性kindCode/kindCode的getter方法
     */
    public String getKindCode() {
        return kindCode;
    }

    /**
     * 属性kindCode/kindCode的setter方法
     */
    public void setKindCode(String kindCode) {
        this.kindCode = kindCode;
    }

    /**
     * 属性indexCode/indexCode的getter方法
     */
    public String getIndexCode() {
        return indexCode;
    }

    /**
     * 属性indexCode/indexCode的setter方法
     */
    public void setIndexCode(String indexCode) {
        this.indexCode = indexCode;
    }

    /**
     * 属性fCode/fCode的getter方法
     */
    public String getFCode() {
        return fCode;
    }

    /**
     * 属性fCode/fCode的setter方法
     */
    public void setFCode(String fCode) {
        this.fCode = fCode;
    }

    /**
     * 属性fName/fName的getter方法
     */
    public String getFName() {
        return fName;
    }

    /**
     * 属性fName/fName的setter方法
     */
    public void setFName(String fName) {
        this.fName = fName;
    }

    /**
     * 属性fIdCard/fIdCard的getter方法
     */
    public String getFIdCard() {
        return fIdCard;
    }

    /**
     * 属性fIdCard/fIdCard的setter方法
     */
    public void setFIdCard(String fIdCard) {
        this.fIdCard = fIdCard;
    }

    /**
     * 属性breedingAreaCode/breedingAreaCode的getter方法
     */
    public String getBreedingAreaCode() {
        return breedingAreaCode;
    }

    /**
     * 属性breedingAreaCode/breedingAreaCode的setter方法
     */
    public void setBreedingAreaCode(String breedingAreaCode) {
        this.breedingAreaCode = breedingAreaCode;
    }

    /**
     * 属性species/species的getter方法
     */
    public String getSpecies() {
        return species;
    }

    /**
     * 属性species/species的setter方法
     */
    public void setSpecies(String species) {
        this.species = species;
    }

    /**
     * 属性breedingKind/breedingKind的getter方法
     */
    public String getBreedingKind() {
        return breedingKind;
    }

    /**
     * 属性breedingKind/breedingKind的setter方法
     */
    public void setBreedingKind(String breedingKind) {
        this.breedingKind = breedingKind;
    }

    /**
     * 属性bank/bank的getter方法
     */
    public String getBank() {
        return bank;
    }

    /**
     * 属性bank/bank的setter方法
     */
    public void setBank(String bank) {
        this.bank = bank;
    }

    /**
     * 属性bankCard/bankCard的getter方法
     */
    public String getBankCard() {
        return bankCard;
    }

    /**
     * 属性bankCard/bankCard的setter方法
     */
    public void setBankCard(String bankCard) {
        this.bankCard = bankCard;
    }

    /**
     * 属性insureNumber/insureNumber的getter方法
     */
    public Integer getInsureNumber() {
        return insureNumber;
    }

    /**
     * 属性insureNumber/insureNumber的setter方法
     */
    public void setInsureNumber(Integer insureNumber) {
        this.insureNumber = insureNumber;
    }

    /**
     * 属性amount/amount的getter方法
     */
    public Double getAmount() {
        return amount;
    }

    /**
     * 属性amount/amount的setter方法
     */
    public void setAmount(Double amount) {
        this.amount = amount;
    }

    /**
     * 属性rate/rate的getter方法
     */
    public Double getRate() {
        return rate;
    }

    /**
     * 属性rate/rate的setter方法
     */
    public void setRate(Double rate) {
        this.rate = rate;
    }

    /**
     * 属性shortRateFlag/shortRateFlag的getter方法
     */
    public String getShortRateFlag() {
        return shortRateFlag;
    }

    /**
     * 属性shortRateFlag/shortRateFlag的setter方法
     */
    public void setShortRateFlag(String shortRateFlag) {
        this.shortRateFlag = shortRateFlag;
    }

    /**
     * 属性shortRate/shortRate的getter方法
     */
    public Double getShortRate() {
        return shortRate;
    }

    /**
     * 属性shortRate/shortRate的setter方法
     */
    public void setShortRate(Double shortRate) {
        this.shortRate = shortRate;
    }

    /**
     * 属性sumAmount/sumAmount的getter方法
     */
    public Double getSumAmount() {
        return sumAmount;
    }

    /**
     * 属性sumAmount/sumAmount的setter方法
     */
    public void setSumAmount(Double sumAmount) {
        this.sumAmount = sumAmount;
    }

    /**
     * 属性sumPremium/sumPremium的getter方法
     */
    public Double getSumPremium() {
        return sumPremium;
    }

    /**
     * 属性sumPremium/sumPremium的setter方法
     */
    public void setSumPremium(Double sumPremium) {
        this.sumPremium = sumPremium;
    }

    /**
     * 属性startDate/startDate的getter方法
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * 属性startDate/startDate的setter方法
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * 属性endDate/endDate的getter方法
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * 属性endDate/endDate的setter方法
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * 属性calculateFlag/calculateFlag的getter方法
     */
    public String getCalculateFlag() {
        return calculateFlag;
    }

    /**
     * 属性calculateFlag/calculateFlag的setter方法
     */
    public void setCalculateFlag(String calculateFlag) {
        this.calculateFlag = calculateFlag;
    }

    /**
     * 属性opCode/opCode的getter方法
     */
    public String getOpCode() {
        return opCode;
    }

    /**
     * 属性opCode/opCode的setter方法
     */
    public void setOpCode(String opCode) {
        this.opCode = opCode;
    }

    /**
     * 属性opTime/opTime的getter方法
     */
    public Date getOpTime() {
        return opTime;
    }

    /**
     * 属性opTime/opTime的setter方法
     */
    public void setOpTime(Date opTime) {
        this.opTime = opTime;
    }

    /**
     * 属性validity/validity的getter方法
     */
    public String getValidity() {
        return validity;
    }

    /**
     * 属性validity/validity的setter方法
     */
    public void setValidity(String validity) {
        this.validity = validity;
    }

    /**
     * 属性remark/remark的getter方法
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 属性remark/remark的setter方法
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 属性breedingNumber/breedingNumber的getter方法
     */
    public Integer getBreedingNumber() {
        return breedingNumber;
    }

    /**
     * 属性breedingNumber/breedingNumber的setter方法
     */
    public void setBreedingNumber(Integer breedingNumber) {
        this.breedingNumber = breedingNumber;
    }

    /**
     * 属性breedingAreaName/breedingAreaName的getter方法
     */
    public String getBreedingAreaName() {
        return breedingAreaName;
    }

    /**
     * 属性breedingAreaName/breedingAreaName的setter方法
     */
    public void setBreedingAreaName(String breedingAreaName) {
        this.breedingAreaName = breedingAreaName;
    }

    /**
     * 属性startTime/startTime的getter方法
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * 属性startTime/startTime的setter方法
     */
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    /**
     * 属性endTime/endTime的getter方法
     */
    public String getEndTime() {
        return endTime;
    }

    /**
     * 属性endTime/endTime的setter方法
     */
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    /**
     * 属性phone/phone的getter方法
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 属性phone/phone的setter方法
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 属性settleNumber/settleNumber的getter方法
     */
    public Integer getSettleNumber() {
        return settleNumber;
    }

    /**
     * 属性settleNumber/settleNumber的setter方法
     */
    public void setSettleNumber(Integer settleNumber) {
        this.settleNumber = settleNumber;
    }

    /**
     * 属性insurePremium/insurePremium的getter方法
     */
    public Double getInsurePremium() {
        return insurePremium;
    }

    /**
     * 属性insurePremium/insurePremium的setter方法
     */
    public void setInsurePremium(Double insurePremium) {
        this.insurePremium = insurePremium;
    }

    /**
     * 属性areaNumber/areaNumber的getter方法
     */
    public Double getAreaNumber() {
        return areaNumber;
    }

    /**
     * 属性areaNumber/areaNumber的setter方法
     */
    public void setAreaNumber(Double areaNumber) {
        this.areaNumber = areaNumber;
    }

    /**
     * 属性litterArea/litterArea的getter方法
     */
    public String getLitterArea() {
        return litterArea;
    }

    /**
     * 属性litterArea/litterArea的setter方法
     */
    public void setLitterArea(String litterArea) {
        this.litterArea = litterArea;
    }

    public Double getAnimalAge() {
        return animalAge;
    }

    public void setAnimalAge(Double animalAge) {
        this.animalAge = animalAge;
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

    public Double getfPremium() {
        return fPremium;
    }

    public void setfPremium(Double fPremium) {
        this.fPremium = fPremium;
    }
}