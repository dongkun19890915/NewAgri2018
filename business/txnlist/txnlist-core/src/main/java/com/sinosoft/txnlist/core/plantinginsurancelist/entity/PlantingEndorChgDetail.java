package com.sinosoft.txnlist.core.plantinginsurancelist.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;

import javax.persistence.*;
import java.util.Date;

/**
 * 清单批改持久化接口
 *
 * @Author: 陈道洋
 * @Date: 2017/11/17 10:30
 */
@Entity
@Table(name = "plantingEndorChgDetail")
@IdClass(PlantingEndorChgDetailKey.class)
public class PlantingEndorChgDetail extends BaseEntityImpl {

    private static final long serialVersionUID = 1L;
    /**
     * 属性投保清单编号（key）/投保清单编号（key）
     */
    @Id
    @Column(name = "inusreListCode")
    private String inusreListCode;
    /**
     * 属性批单号/批单号
     */
    @Id
    @Column(name = "endorseNo")
    private String endorseNo;
    /**
     * 属性农户代码（key）/农户代码（key）
     */
    @Id
    @Column(name = "fCode")
    private String fCode;
    /**
     * 属性险别序号（key）/险别序号（key）
     */
    @Id
    @Column(name = "kindCode")
    private String kindCode;

    /**
     * 属性排序序号/排序序号
     */
    @Column(name = "indexCode")
    private String indexCode;
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
     * 属性直补卡号/银行卡号/直补卡号/银行卡号
     */
    @Column(name = "zhiBuKa")
    private String zhiBuKa;
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
    @Column(name = "fAreaCode")
    private String fAreaCode;
    /**
     * 属性自定义种植面积/自定义种植面积
     */
    @Column(name = "taxArea")
    private Double taxArea;
    /**
     * 属性投保面积/投保面积
     */
    @Column(name = "insureArea")
    private Double insureArea;
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
     * 属性农民自缴保费/农民自缴保费
     */
    @Column(name = "fPremium")
    private Double fPremium;
    /**
     * 属性组别/组别
     */
    @Column(name = "teamName")
    private String teamName;
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
     * 属性投保面积变化量/投保面积变化量
     */
    @Column(name = "chgInsureArea")
    private Double chgInsureArea;
    /**
     * 属性保额变化量/保额变化量
     */
    @Column(name = "chgSumAmount")
    private Double chgSumAmount;
    /**
     * 属性保费变化量/保费变化量
     */
    @Column(name = "chgSumPremium")
    private Double chgSumPremium;
    /**
     * 属性土地来源/土地来源
     */
    @Column(name = "fieldSource")
    private String fieldSource;
    /**
     * 属性修改标志位/修改标志位
     */
    @Column(name = "flag")
    private String flag;
    /**
     * 属性林权证号/林权证号
     */
    @Column(name = "warrant")
    private String warrant;
    /**
     * 属性坐落地点/坐落地点
     */
    @Column(name = "atArea")
    private String atArea;
    /**
     * 属性小地名/小地名
     */
    @Column(name = "littleAreaName")
    private String littleAreaName;
    /**
     * 属性实有林地/实有林地
     */
    @Column(name = "woodLandArea")
    private Double woodLandArea;
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

    /**
     * 属性标的代码
     */
    @Column(name = "itemCode")
    private String itemCode;

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

    public String getfIdCard() {
        return fIdCard;
    }

    public void setfIdCard(String fIdCard) {
        this.fIdCard = fIdCard;
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

    public String getfAreaCode() {
        return fAreaCode;
    }

    public void setfAreaCode(String fAreaCode) {
        this.fAreaCode = fAreaCode;
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

    public String getWarrant() {
        return warrant;
    }

    public void setWarrant(String warrant) {
        this.warrant = warrant;
    }

    public String getAtArea() {
        return atArea;
    }

    public void setAtArea(String atArea) {
        this.atArea = atArea;
    }

    public String getLittleAreaName() {
        return littleAreaName;
    }

    public void setLittleAreaName(String littleAreaName) {
        this.littleAreaName = littleAreaName;
    }

    public Double getWoodLandArea() {
        return woodLandArea;
    }

    public void setWoodLandArea(Double woodLandArea) {
        this.woodLandArea = woodLandArea;
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

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }
}