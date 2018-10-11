package com.sinosoft.txnlist.core.plantinginsurancelist.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;

import javax.persistence.*;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time 2017-11-18 08:36:26.740
 * nyxcpendorchgdetail实体操作对象
 */
@Entity
@Table(name = "nyxCpEndorChgDetail")
@IdClass(NyxCpEndorChgDetailKey.class)
public class NyxCpEndorChgDetail extends BaseEntityImpl {

    private static final long serialVersionUID = 1L;
    /**
     * 属性投保清单编号（key）/投保清单编号（key）
     */
    @Id
    @Column(name = "inusreListCode")
    private String inusreListCode;
    /**
     * 属性业务号（种植为农户身份证号,养殖为耳标号）/业务号（种植为农户身份证号,养殖为耳标号）
     */
    @Id
    @Column(name = "businessNo")
    private String businessNo;
    /**
     * 属性险别序号（key）/险别序号（key）
     */
    @Id
    @Column(name = "kindCode")
    private String kindCode;
    /**
     * 属性标的代码（key）/标的代码（key）
     */
    @Id
    @Column(name = "itemCode")
    private String itemCode;


    /**
     * 属性排序序号/排序序号
     */
    @Column(name = "indexcode")
    private String indexcode;
    /**
     * 属性农户代码（key）/农户代码（key）
     */
    @Column(name = "fCode")
    private String fCode;
    /**
     * 属性fIdCard/fIdCard
     */
    @Column(name = "fIdCard")
    private String fIdCard;
    /**
     * 属性农户姓名/农户姓名
     */
    @Column(name = "fName")
    private String fName;
    /**
     * 属性直补卡号/银行卡号/直补卡号/银行卡号
     */
    @Column(name = "zhiBuKa")
    private String zhiBuKa;
    /**
     * 属性联系电话号码/联系电话号码
     */
    @Column(name = "phone")
    private String phone;
    /**
     * 属性开户银行/开户银行
     */
    @Column(name = "bank")
    private String bank;
    /**
     * 属性银行卡号/银行卡号
     */
    @Column(name = "bankCard")
    private String bankCard;
    /**
     * 属性insurenumber/insurenumber
     */
    @Column(name = "insureNumber")
    private java.lang.Integer insureNumber;
    /**
     * 属性breedingareacode/breedingareacode
     */
    @Column(name = "breedingAreaCode")
    private String breedingAreaCode;
    /**
     * 属性species/species
     */
    @Column(name = "species")
    private String species;
    /**
     * 属性breedingkind/breedingkind
     */
    @Column(name = "breedingKind")
    private String breedingKind;
    /**
     * 属性breedingnumber/breedingnumber
     */
    @Column(name = "breedingNumber")
    private java.lang.Integer breedingNumber;
    /**
     * 属性breedingareaname/breedingareaname
     */
    @Column(name = "breedingAreaName")
    private String breedingAreaName;
    /**
     * 属性settlenumber/settlenumber
     */
    @Column(name = "settleNumber")
    private java.lang.Integer settleNumber;
    /**
     * 属性险类/险类
     */
    @Column(name = "classCode")
    private String classCode;
    /**
     * 属性险种/险种
     */
    @Column(name = "riskCode")
    private String riskCode;
    /**
     * 属性种植区域代码/种植区域代码
     */
    @Column(name = "fareaCode")
    private String fareaCode;
    /**
     * 属性自定义种植面积/自定义种植面积
     */
    @Column(name = "taxArea")
    private java.lang.Double taxArea;
    /**
     * 属性投保面积/投保面积
     */
    @Column(name = "insureArea")
    private java.lang.Double insureArea;
    /**
     * 属性单位保额/单位保额
     */
    @Column(name = "amount")
    private java.lang.Double amount;
    /**
     * 属性费率/费率
     */
    @Column(name = "rate")
    private java.lang.Double rate;
    /**
     * 属性短期费率方式/短期费率方式
     */
    @Column(name = "shortRateFlag")
    private String shortRateFlag;
    /**
     * 属性短期费率/短期费率
     */
    @Column(name = "shortRate")
    private java.lang.Double shortRate;
    /**
     * 属性总保额/总保额
     */
    @Column(name = "sumAmount")
    private java.lang.Double sumAmount;
    /**
     * 属性总保费/总保费
     */
    @Column(name = "sumPremium")
    private java.lang.Double sumPremium;
    /**
     * 属性保险起期/保险起期
     */
    @Column(name = "startDate")
    private java.util.Date startDate;
    /**
     * 属性保险止期/保险止期
     */
    @Column(name = "endDate")
    private java.util.Date endDate;
    /**
     * 属性starttime/starttime
     */
    @Column(name = "startTime")
    private String startTime;
    /**
     * 属性endtime/endtime
     */
    @Column(name = "endTime")
    private String endTime;
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
    private java.util.Date opTime;
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
     * 属性农民自缴保费/农民自缴保费
     */
    @Column(name = "fPremium")
    private java.lang.Double fPremium;
    /**
     * 属性组别/组别
     */
    @Column(name = "teamName")
    private String teamName;
    /**
     * 属性中央财政补贴/中央财政补贴
     */
    @Column(name = "centralPremium")
    private java.lang.Double centralPremium;
    /**
     * 属性省级财政补贴/省级财政补贴
     */
    @Column(name = "provincePremium")
    private java.lang.Double provincePremium;
    /**
     * 属性地市财政补贴/地市财政补贴
     */
    @Column(name = "cityPremium")
    private java.lang.Double cityPremium;
    /**
     * 属性县(区)财政补贴/县(区)财政补贴
     */
    @Column(name = "townPremium")
    private java.lang.Double townPremium;
    /**
     * 属性其他来源补贴/其他来源补贴
     */
    @Column(name = "otherPremium")
    private java.lang.Double otherPremium;
    /**
     * 属性areanumber/areanumber
     */
    @Column(name = "areaNumber")
    private java.lang.Double areaNumber;
    /**
     * 属性土地来源/土地来源
     */
    @Column(name = "fieldSource")
    private String fieldSource;
    /**
     * 属性小地名/小地名
     */
    @Column(name = "litterArea")
    private String litterArea;
    /**
     * 属性坐落地点/坐落地点
     */
    @Column(name = "atArea")
    private String atArea;
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
     * 属性林权证号/林权证号
     */
    @Column(name = "warrant")
    private String warrant;
    /**
     * 属性备用字段1/备用字段1
     */
    @Column(name = "temp1")
    private String temp1;
    /**
     * 属性备用字段2/备用字段2
     */
    @Column(name = "temp2")
    private String temp2;
    /**
     * 属性备用字段3/备用字段3
     */
    @Column(name = "temp3")
    private String temp3;
    /**
     * 属性备用字段4/备用字段4
     */
    @Column(name = "temp4")
    private String temp4;
    /**
     * 属性备用字段5/备用字段5
     */
    @Column(name = "temp5")
    private String temp5;

    public String getInusreListCode() {
        return inusreListCode;
    }

    public void setInusreListCode(String inusreListCode) {
        this.inusreListCode = inusreListCode;
    }

    public String getBusinessNo() {
        return businessNo;
    }

    public void setBusinessNo(String businessNo) {
        this.businessNo = businessNo;
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

    public String getIndexcode() {
        return indexcode;
    }

    public void setIndexcode(String indexcode) {
        this.indexcode = indexcode;
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

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getZhiBuKa() {
        return zhiBuKa;
    }

    public void setZhiBuKa(String zhiBuKa) {
        this.zhiBuKa = zhiBuKa;
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

    public Integer getSettleNumber() {
        return settleNumber;
    }

    public void setSettleNumber(Integer settleNumber) {
        this.settleNumber = settleNumber;
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

    public String getLitterArea() {
        return litterArea;
    }

    public void setLitterArea(String litterArea) {
        this.litterArea = litterArea;
    }

    public String getAtArea() {
        return atArea;
    }

    public void setAtArea(String atArea) {
        this.atArea = atArea;
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

    public String getWarrant() {
        return warrant;
    }

    public void setWarrant(String warrant) {
        this.warrant = warrant;
    }

    public String getTemp1() {
        return temp1;
    }

    public void setTemp1(String temp1) {
        this.temp1 = temp1;
    }

    public String getTemp2() {
        return temp2;
    }

    public void setTemp2(String temp2) {
        this.temp2 = temp2;
    }

    public String getTemp3() {
        return temp3;
    }

    public void setTemp3(String temp3) {
        this.temp3 = temp3;
    }

    public String getTemp4() {
        return temp4;
    }

    public void setTemp4(String temp4) {
        this.temp4 = temp4;
    }

    public String getTemp5() {
        return temp5;
    }

    public void setTemp5(String temp5) {
        this.temp5 = temp5;
    }
}