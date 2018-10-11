package com.sinosoft.txnlist.core.plantinginsurancelist.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;

import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time 2017-10-30 07:53:53.940
 * 养殖险保单清单最新数据表1实体操作对象
 */
@Entity
@Table(name = "HerdPolicyList")
@IdClass(HerdPolicyListKey.class)
public class HerdPolicyList extends BaseEntityImpl {

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
    @Column(name = "earlAbel")
    private String earlAbel;
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
     * 属性litterArea/litterArea
     */
    @Column(name = "litterArea")
    private String litterArea;
    /**
     * 属性areaNumber/areaNumber
     */
    @Column(name = "areaNumber")
    private Double areaNumber;
    /**
     * 属性畜龄/畜龄
     */
    @Column(name = "animalAge")
    private Double animalAge;

    /** 标的代码 */
    @Column(name = "itemCode")
    private String itemCode;

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getInusreListCode() {
        return inusreListCode;
    }

    public void setInusreListCode(String inusreListCode) {
        this.inusreListCode = inusreListCode;
    }

    /**
     * 属性耳标号/耳标号的getter方法
     */
    public String getEarlAbel() {
        return earlAbel;
    }

    /**
     * 属性耳标号/耳标号的setter方法
     */
    public void setEarlAbel(String earlAbel) {
        this.earlAbel = earlAbel;
    }

    /**
     * 属性险别序号/险别序号的getter方法
     */
    public String getKindCode() {
        return kindCode;
    }

    /**
     * 属性险别序号/险别序号的setter方法
     */
    public void setKindCode(String kindCode) {
        this.kindCode = kindCode;
    }

    /**
     * 属性排序序号/排序序号的getter方法
     */
    public String getIndexCode() {
        return indexCode;
    }

    /**
     * 属性排序序号/排序序号的setter方法
     */
    public void setIndexCode(String indexCode) {
        this.indexCode = indexCode;
    }


    public String getfCode() {
        return fCode;
    }

    public void setfCode(String fCode) {
        this.fCode = fCode;
    }

    public String getfIdCard() {
        return fIdCard;
    }

    public void setfIdCard(String fIdCard) {
        this.fIdCard = fIdCard;
    }

    /**
     * 属性养殖品种/养殖品种的getter方法
     */
    public String getSpecies() {
        return species;
    }

    /**
     * 属性养殖品种/养殖品种的setter方法
     */
    public void setSpecies(String species) {
        this.species = species;
    }

    /**
     * 属性养殖方式/养殖方式的getter方法
     */
    public String getBreedingKind() {
        return breedingKind;
    }

    /**
     * 属性养殖方式/养殖方式的setter方法
     */
    public void setBreedingKind(String breedingKind) {
        this.breedingKind = breedingKind;
    }

    /**
     * 属性开户银行/开户银行的getter方法
     */
    public String getBank() {
        return bank;
    }

    /**
     * 属性开户银行/开户银行的setter方法
     */
    public void setBank(String bank) {
        this.bank = bank;
    }

    /**
     * 属性银行卡帐号/银行卡帐号的getter方法
     */
    public String getBankCard() {
        return bankCard;
    }

    /**
     * 属性银行卡帐号/银行卡帐号的setter方法
     */
    public void setBankCard(String bankCard) {
        this.bankCard = bankCard;
    }

    /**
     * 属性投保数量/投保数量的getter方法
     */
    public Integer getInsureNumber() {
        return insureNumber;
    }

    /**
     * 属性投保数量/投保数量的setter方法
     */
    public void setInsureNumber(Integer insureNumber) {
        this.insureNumber = insureNumber;
    }

    /**
     * 属性单位保额/单位保额的getter方法
     */
    public Double getAmount() {
        return amount;
    }

    /**
     * 属性单位保额/单位保额的setter方法
     */
    public void setAmount(Double amount) {
        this.amount = amount;
    }

    /**
     * 属性费率/费率的getter方法
     */
    public Double getRate() {
        return rate;
    }

    /**
     * 属性费率/费率的setter方法
     */
    public void setRate(Double rate) {
        this.rate = rate;
    }


    /**
     * 属性短期费率/短期费率的getter方法
     */
    public Double getShortRate() {
        return shortRate;
    }

    /**
     * 属性短期费率/短期费率的setter方法
     */
    public void setShortRate(Double shortRate) {
        this.shortRate = shortRate;
    }

    /**
     * 属性总保额/总保额的getter方法
     */
    public Double getSumAmount() {
        return sumAmount;
    }

    /**
     * 属性总保额/总保额的setter方法
     */
    public void setSumAmount(Double sumAmount) {
        this.sumAmount = sumAmount;
    }

    /**
     * 属性总保费/总保费的getter方法
     */
    public Double getSumPremium() {
        return sumPremium;
    }

    /**
     * 属性总保费/总保费的setter方法
     */
    public void setSumPremium(Double sumPremium) {
        this.sumPremium = sumPremium;
    }

    /**
     * 属性保险起期/保险起期的getter方法
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * 属性保险起期/保险起期的setter方法
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * 属性保险止期/保险止期的getter方法
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * 属性保险止期/保险止期的setter方法
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * 属性主险标志（Y是、N否）/主险标志（Y是、N否）的getter方法
     */
    public String getCalculateFlag() {
        return calculateFlag;
    }

    /**
     * 属性主险标志（Y是、N否）/主险标志（Y是、N否）的setter方法
     */
    public void setCalculateFlag(String calculateFlag) {
        this.calculateFlag = calculateFlag;
    }

    /**
     * 属性操作员代码/操作员代码的getter方法
     */
    public String getOpCode() {
        return opCode;
    }

    /**
     * 属性操作员代码/操作员代码的setter方法
     */
    public void setOpCode(String opCode) {
        this.opCode = opCode;
    }

    /**
     * 属性操作时间/操作时间的getter方法
     */
    public Date getOpTime() {
        return opTime;
    }

    /**
     * 属性操作时间/操作时间的setter方法
     */
    public void setOpTime(Date opTime) {
        this.opTime = opTime;
    }

    /**
     * 属性有效标志位：0：无效；2：暂存；1：已提交/有效标志位：0：无效；2：暂存；1：已提交的getter方法
     */
    public String getValidity() {
        return validity;
    }

    /**
     * 属性有效标志位：0：无效；2：暂存；1：已提交/有效标志位：0：无效；2：暂存；1：已提交的setter方法
     */
    public void setValidity(String validity) {
        this.validity = validity;
    }

    /**
     * 属性备注/备注的getter方法
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 属性备注/备注的setter方法
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 属性养殖数量/养殖数量的getter方法
     */
    public Integer getBreedingNumber() {
        return breedingNumber;
    }

    /**
     * 属性养殖数量/养殖数量的setter方法
     */
    public void setBreedingNumber(Integer breedingNumber) {
        this.breedingNumber = breedingNumber;
    }

    /**
     * 属性养殖地点名称/养殖地点名称的getter方法
     */
    public String getBreedingAreaName() {
        return breedingAreaName;
    }

    /**
     * 属性养殖地点名称/养殖地点名称的setter方法
     */
    public void setBreedingAreaName(String breedingAreaName) {
        this.breedingAreaName = breedingAreaName;
    }

    /**
     * 属性开始时间/开始时间的getter方法
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * 属性开始时间/开始时间的setter方法
     */
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    /**
     * 属性终止时间/终止时间的getter方法
     */
    public String getEndTime() {
        return endTime;
    }

    /**
     * 属性终止时间/终止时间的setter方法
     */
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    /**
     * 属性联系电话/联系电话的getter方法
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 属性联系电话/联系电话的setter方法
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 属性赔付数量/赔付数量的getter方法
     */
    public Integer getSettleNumber() {
        return settleNumber;
    }

    /**
     * 属性赔付数量/赔付数量的setter方法
     */
    public void setSettleNumber(Integer settleNumber) {
        this.settleNumber = settleNumber;
    }

    /**
     * 属性农户自缴保费/农户自缴保费的getter方法
     */
    public Double getInsurePremium() {
        return insurePremium;
    }

    /**
     * 属性农户自缴保费/农户自缴保费的setter方法
     */
    public void setInsurePremium(Double insurePremium) {
        this.insurePremium = insurePremium;
    }

    /**
     * 属性中央财政补贴/中央财政补贴的getter方法
     */
    public Double getCentralPremium() {
        return centralPremium;
    }

    /**
     * 属性中央财政补贴/中央财政补贴的setter方法
     */
    public void setCentralPremium(Double centralPremium) {
        this.centralPremium = centralPremium;
    }

    /**
     * 属性省级财政补贴/省级财政补贴的getter方法
     */
    public Double getProvincePremium() {
        return provincePremium;
    }

    /**
     * 属性省级财政补贴/省级财政补贴的setter方法
     */
    public void setProvincePremium(Double provincePremium) {
        this.provincePremium = provincePremium;
    }

    /**
     * 属性地市财政补贴/地市财政补贴的getter方法
     */
    public Double getCityPremium() {
        return cityPremium;
    }

    /**
     * 属性地市财政补贴/地市财政补贴的setter方法
     */
    public void setCityPremium(Double cityPremium) {
        this.cityPremium = cityPremium;
    }

    /**
     * 属性县(区)财政补贴/县(区)财政补贴的getter方法
     */
    public Double getTownPremium() {
        return townPremium;
    }

    /**
     * 属性县(区)财政补贴/县(区)财政补贴的setter方法
     */
    public void setTownPremium(Double townPremium) {
        this.townPremium = townPremium;
    }

    /**
     * 属性其他来源补贴/其他来源补贴的getter方法
     */
    public Double getOtherPremium() {
        return otherPremium;
    }

    /**
     * 属性其他来源补贴/其他来源补贴的setter方法
     */
    public void setOtherPremium(Double otherPremium) {
        this.otherPremium = otherPremium;
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

    public Double getAnimalAge() {        return animalAge;    }

    public void setAnimalAge(Double animalAge) {        this.animalAge = animalAge;    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getBreedingAreaCode() {
        return breedingAreaCode;
    }

    public void setBreedingAreaCode(String breedingAreaCode) {
        this.breedingAreaCode = breedingAreaCode;
    }

    public String getShortRateFlag() {
        return shortRateFlag;
    }

    public void setShortRateFlag(String shortRateFlag) {
        this.shortRateFlag = shortRateFlag;
    }
}