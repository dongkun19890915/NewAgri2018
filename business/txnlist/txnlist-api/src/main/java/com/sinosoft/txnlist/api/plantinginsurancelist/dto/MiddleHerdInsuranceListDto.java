package com.sinosoft.txnlist.api.plantinginsurancelist.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time 2017-10-30 07:53:53.940
 * 养殖业投保明细实体操作对象
 */
public class MiddleHerdInsuranceListDto extends BaseRequest implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 属性投保清单编号/投保清单编号
     */
    private String inusreListCode;
    /**
     * 属性农户代码/农户代码
     */
    private String fCode;
    /**
     * 属性险别序号/险别序号
     */
    private String kindCode;


    /**
     * 属性农户姓名/农户姓名
     */

    private String fName;
    /**
     * 属性农户身份证/农户身份证
     */

    private String fIdCard;
    /**
     * 属性养殖数量/养殖数量
     */

    private Integer breedingNumber;
    /**
     * 属性养殖地点代码/养殖地点代码
     */

    private String breedingAreaCode;
    /**
     * 属性养殖地点名称/养殖地点名称
     */

    private String breedingAreaName;
    /**
     * 属性投保数量/投保数量
     */

    private Double insureNumber;
    /**
     * 属性备注/备注
     */

    private String remark;
    /**
     * 属性有效标志位：0：无效；1：有效/有效标志位：0：无效；1：有效
     */

    private String validity;
    /**
     * 属性开始时间/开始时间
     */

    private String startTime;
    /**
     * 属性终止时间/终止时间
     */

    private String endTime;
    /**
     * 属性联系电话/联系电话
     */

    private String phone;
    /**
     * 属性操作员代码/操作员代码
     */

    private String opCode;
    /**
     * 属性操作时间/操作时间
     */

    private Date opTime;
    /**
     * 属性赔付数量/赔付数量
     */

    private Integer settleNumber;
    /**
     * 属性养殖品种/养殖品种
     */

    private String species;
    /**
     * 属性开户银行/开户银行
     */

    private String bank;
    /**
     * 属性银行卡帐号/银行卡帐号
     */

    private String bankCard;

    /**
     * 属性排序序号/排序序号
     */

    private String indexCode;
    /**
     * 属性养殖方式/养殖方式
     */

    private String breedingKind;
    /**
     * 属性单位保额/单位保额
     */

    private Double amount;
    /**
     * 属性费率/费率
     */

    private Double rate;
    /**
     * 属性短期费率方式/短期费率方式
     */

    private String shortRateFlag;
    /**
     * 属性短期费率/短期费率
     */

    private Double shortRate;
    /**
     * 属性总保额/总保额
     */

    private Double sumAmount;
    /**
     * 属性总保费/总保费
     */

    private Double sumPremium;
    /**
     * 属性保险起期/保险起期
     */

    private Date startDate;
    /**
     * 属性保险止期/保险止期
     */

    private Date endDate;
    /**
     * 属性主险标志（Y是、N否）/主险标志（Y是、N否）
     */

    private String calculateFlag;
    /**
     * 属性农户自缴保费/农户自缴保费
     */

    private Double insurePremium;
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
     * 属性areaNumber/areaNumber
     */

    private Double areaNumber;
    /**
     * 属性litterArea/litterArea
     */

    private String litterArea;
    /**
     * 属性畜龄/畜龄
     */

    private Double aniMalage;
    /** 属性标的代码 */
    private String itemCode;

    public String getInusreListCode() {
        return inusreListCode;
    }

    public void setInusreListCode(String inusreListCode) {
        this.inusreListCode = inusreListCode;
    }

    public String getfCode() {
        return fCode;
    }

    public void setfCode(String fCode) {
        this.fCode = fCode;
    }

    public String getKindCode() {
        return kindCode;
    }

    public void setKindCode(String kindCode) {
        this.kindCode = kindCode;
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

    public Integer getBreedingNumber() {
        return breedingNumber;
    }

    public void setBreedingNumber(Integer breedingNumber) {
        this.breedingNumber = breedingNumber;
    }

    public String getBreedingAreaCode() {
        return breedingAreaCode;
    }

    public void setBreedingAreaCode(String breedingAreaCode) {
        this.breedingAreaCode = breedingAreaCode;
    }

    public String getBreedingAreaName() {
        return breedingAreaName;
    }

    public void setBreedingAreaName(String breedingAreaName) {
        this.breedingAreaName = breedingAreaName;
    }

    public Double getInsureNumber() {
        return insureNumber;
    }

    public void setInsureNumber(Double insureNumber) {
        this.insureNumber = insureNumber;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getValidity() {
        return validity;
    }

    public void setValidity(String validity) {
        this.validity = validity;
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

    public Integer getSettleNumber() {
        return settleNumber;
    }

    public void setSettleNumber(Integer settleNumber) {
        this.settleNumber = settleNumber;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
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

    public String getIndexCode() {
        return indexCode;
    }

    public void setIndexCode(String indexCode) {
        this.indexCode = indexCode;
    }

    public String getBreedingKind() {
        return breedingKind;
    }

    public void setBreedingKind(String breedingKind) {
        this.breedingKind = breedingKind;
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

    public Double getInsurePremium() {
        return insurePremium;
    }

    public void setInsurePremium(Double insurePremium) {
        this.insurePremium = insurePremium;
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
}