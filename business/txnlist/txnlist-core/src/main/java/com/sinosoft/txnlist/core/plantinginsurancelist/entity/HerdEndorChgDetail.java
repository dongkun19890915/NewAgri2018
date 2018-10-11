package com.sinosoft.txnlist.core.plantinginsurancelist.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;

import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time 2017-11-14 07:07:05.012
 * 养殖险保单清单最新数据表实体操作对象
 */
@Entity
@Table(name = "herdEndorChgDetail")
@IdClass(HerdEndorChgDetailKey.class)
public class HerdEndorChgDetail extends BaseEntityImpl {

    private static final long serialVersionUID = 1L;
    /**
     * 属性投保清单编号/投保清单编号
     */
    @Id
    @Column(name = "inusreListCode")
    private String inusreListCode;
    /**
     * 属性耳标号/耳标号
     */
    @Id
    @Column(name = "earLabel")
    private String earLabel;
    /**
     * 属性批单号/批单号
     */
    @Id
    @Column(name = "endorseNo")
    private String endorseNo;
    /**
     * 属性险别序号/险别序号
     */
    @Id
    @Column(name = "kindCode")
    private String kindCode;
    /**
     * 属性农户代码/农户代码
     */
    @Id
    @Column(name = "fCode")
    private String fCode;


    /**
     * 属性排序序号/排序序号
     */
    @Column(name = "indexCode")
    private String indexCode;
    /**
     * 属性农户姓名/农户姓名
     */
    @Column(name = "fName")
    private String fName;
    /**
     * 属性农户身份证/农户身份证
     */
    @Column(name = "fIdCard")
    private String fIdCard;
    /**
     * 属性养殖地点代码/养殖地点代码
     */
    @Column(name = "breedingAreaCode")
    private String breedingAreaCode;
    /**
     * 属性养殖品种/养殖品种
     */
    @Column(name = "species")
    private String species;
    /**
     * 属性养殖方式/养殖方式
     */
    @Column(name = "breedingKind")
    private String breedingKind;
    /**
     * 属性开户银行/开户银行
     */
    @Column(name = "bank")
    private String bank;
    /**
     * 属性银行卡帐号/银行卡帐号
     */
    @Column(name = "bankCard")
    private String bankCard;
    /**
     * 属性投保数量/投保数量
     */
    @Column(name = "insureNumber")
    private Integer insureNumber;
    /**
     * 属性单位保额/单位保额
     */
    @Column(name = "amount")
    private Double amount;
    /**
     * 属性费率/费率
     */
    @Column(name = "rate")
    private Double rate;
    /**
     * 属性短期费率方式/短期费率方式
     */
    @Column(name = "shortRateFlag")
    private String shortRateFlag;
    /**
     * 属性短期费率/短期费率
     */
    @Column(name = "shortRate")
    private Double shortRate;
    /**
     * 属性总保额/总保额
     */
    @Column(name = "sumAmount")
    private Double sumAmount;
    /**
     * 属性总保费/总保费
     */
    @Column(name = "sumPremium")
    private Double sumPremium;
    /**
     * 属性保险起期/保险起期
     */
    @Column(name = "startDate")
    private Date startDate;
    /**
     * 属性保险止期/保险止期
     */
    @Column(name = "endDate")
    private Date endDate;
    /**
     * 属性主险标志（Y是、N否）/主险标志（Y是、N否）
     */
    @Column(name = "calculateFlag")
    private String calculateFlag;
    /**
     * 属性操作员代码/操作员代码
     */
    @Column(name = "opCode")
    private String opCode;
    /**
     * 属性操作时间/操作时间
     */
    @Column(name = "opTime")
    private Date opTime;
    /**
     * 属性有效标志位：0：无效；2：暂存；1：已提交/有效标志位：0：无效；2：暂存；1：已提交
     */
    @Column(name = "validity")
    private String validity;
    /**
     * 属性备注/备注
     */
    @Column(name = "remark")
    private String remark;
    /**
     * 属性养殖数量/养殖数量
     */
    @Column(name = "breedingNumber")
    private Integer breedingNumber;
    /**
     * 属性养殖地点名称/养殖地点名称
     */
    @Column(name = "breedingAreaName")
    private String breedingAreaName;
    /**
     * 属性开始时间/开始时间
     */
    @Column(name = "startTime")
    private String startTime;
    /**
     * 属性终止时间/终止时间
     */
    @Column(name = "endTime")
    private String endTime;
    /**
     * 属性联系电话/联系电话
     */
    @Column(name = "phone")
    private String phone;
    /**
     * 属性赔付数量/赔付数量
     */
    @Column(name = "settleNumber")
    private Integer settleNumber;
    /**
     * 属性农户自缴保费/农户自缴保费
     */
    @Column(name = "insurePremium")
    private Double insurePremium;
    /**
     * 属性修改标志位/修改标志位
     */
    @Column(name = "flag")
    private String flag;
    /**
     * 属性投保数量变化量/投保数量变化量
     */
    @Column(name = "chgInsureNumber")
    private Integer chgInsureNumber;
    /**
     * 属性总保额变化量/总保额变化量
     */
    @Column(name = "chgSumAmount")
    private Double chgSumAmount;
    /**
     * 属性总保费变化量/总保费变化量
     */
    @Column(name = "chgSumPremium")
    private Double chgSumPremium;
    /**
     * 属性areaNumber/areaNumber
     */
    @Column(name = "areaNumber")
    private Double areaNumber;
    /**
     * 属性chgAreaNumber/chgAreaNumber
     */
    @Column(name = "chgAreaNumber")
    private Double chgAreaNumber;
    /**
     * 属性litterArea/litterArea
     */
    @Column(name = "litterArea")
    private String litterArea;
    /**
     * 属性畜龄/畜龄
     */
    @Column(name = "aniMalage")
    private Double aniMalage;
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

    public String getEarLabel() {
        return earLabel;
    }

    public void setEarLabel(String earLabel) {
        this.earLabel = earLabel;
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

    public String getBreedingAreaCode() {
        return breedingAreaCode;
    }

    public void setBreedingAreaCode(String breedingAreaCode) {
        this.breedingAreaCode = breedingAreaCode;
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

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getBankCard() {
        return bankCard;
    }

    public void setBankCard(String bankCard) {
        this.bankCard = bankCard;
    }

    public Integer getInsureNumber() {
        return insureNumber;
    }

    public void setInsureNumber(Integer insureNumber) {
        this.insureNumber = insureNumber;
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

    public Integer getBreedingNumber() {
        return breedingNumber;
    }

    public void setBreedingNumber(Integer breedingNumber) {
        this.breedingNumber = breedingNumber;
    }

    public String getBreedingAreaName() {
        return breedingAreaName;
    }

    public void setBreedingAreaName(String breedingAreaName) {
        this.breedingAreaName = breedingAreaName;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getSettleNumber() {
        return settleNumber;
    }

    public void setSettleNumber(Integer settleNumber) {
        this.settleNumber = settleNumber;
    }

    public Double getInsurePremium() {
        return insurePremium;
    }

    public void setInsurePremium(Double insurePremium) {
        this.insurePremium = insurePremium;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public Integer getChgInsureNumber() {
        return chgInsureNumber;
    }

    public void setChgInsureNumber(Integer chgInsureNumber) {
        this.chgInsureNumber = chgInsureNumber;
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

    public Double getAreaNumber() {
        return areaNumber;
    }

    public void setAreaNumber(Double areaNumber) {
        this.areaNumber = areaNumber;
    }

    public Double getChgAreaNumber() {
        return chgAreaNumber;
    }

    public void setChgAreaNumber(Double chgAreaNumber) {
        this.chgAreaNumber = chgAreaNumber;
    }

    public String getLitterArea() {
        return litterArea;
    }

    public void setLitterArea(String litterArea) {
        this.litterArea = litterArea;
    }

    public Double getAniMalage() {
        return aniMalage;
    }

    public void setAniMalage(Double aniMalage) {
        this.aniMalage = aniMalage;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
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