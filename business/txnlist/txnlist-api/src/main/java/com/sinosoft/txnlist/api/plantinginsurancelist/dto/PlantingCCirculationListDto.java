package com.sinosoft.txnlist.api.plantinginsurancelist.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time 2017-10-30 07:53:53.940
 * 投保明细最新数据表1实体操作对象
 */
public class PlantingCCirculationListDto extends BaseRequest implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 属性投保清单编号（key）/投保清单编号（key）
     */
    private String inusreListCode;
    /**
     * 属性农户代码（key）/农户代码（key）
     */
    private String fCode;
    /**
     * 属性险别序号（key）/险别序号（key）
     */
    private String kindCode;


    /**
     * 属性排序序号/排序序号
     */

    private String indexCode;
    /**
     * 属性联系电话号码/联系电话号码
     */

    private String phone;
    /**
     * 属性开户银行/开户银行
     */

    private String bank;
    /**
     * 属性直补卡号/银行卡号/直补卡号/银行卡号
     */

    private String zhiBuKa;
    /**
     * 属性农户姓名/农户姓名
     */

    private String fName;
    /**
     * 属性农户身份证/农户身份证
     */

    private String fIdcard;
    /**
     * 属性险类/险类
     */

    private String classCode;
    /**
     * 属性险种/险种
     */

    private String riskCode;
    /**
     * 属性种植区域代码/种植区域代码
     */

    private String fAreaCode;
    /**
     * 属性自定义种植面积/自定义种植面积
     */

    private Double taxArea;
    /**
     * 属性投保面积/投保面积
     */

    private Double insureArea;
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
     * 属性操作员代码/操作员代码
     */

    private String opCode;
    /**
     * 属性操作时间/操作时间
     */

    private Date opTime;
    /**
     * 属性有效标志位：0：无效；2：暂存；1：已提交/有效标志位：0：无效；2：暂存；1：已提交
     */

    private String validity;
    /**
     * 属性备注/备注
     */

    private String remark;
    /**
     * 属性农民自缴保费/农民自缴保费
     */

    private Double fPremium;
    /**
     * 属性组别/组别
     */

    private String teamName;
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
     * 属性土地来源/土地来源
     */

    private String fieldSource;

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

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getfIdcard() {
        return fIdcard;
    }

    public void setfIdcard(String fIdcard) {
        this.fIdcard = fIdcard;
    }

    public String getfAreaCode() {
        return fAreaCode;
    }

    public void setfAreaCode(String fAreaCode) {
        this.fAreaCode = fAreaCode;
    }

    public String getShortRateFlag() {
        return shortRateFlag;
    }

    public void setShortRateFlag(String shortRateFlag) {
        this.shortRateFlag = shortRateFlag;
    }

    public Double getfPremium() {
        return fPremium;
    }

    public void setfPremium(Double fPremium) {
        this.fPremium = fPremium;
    }

    /**
     * 属性险别序号（key）/险别序号（key）的getter方法
     */
    public String getKindCode() {
        return kindCode;
    }

    /**
     * 属性险别序号（key）/险别序号（key）的setter方法
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

    /**
     * 属性联系电话号码/联系电话号码的getter方法
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 属性联系电话号码/联系电话号码的setter方法
     */
    public void setPhone(String phone) {
        this.phone = phone;
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
     * 属性直补卡号/银行卡号/直补卡号/银行卡号的getter方法
     */
    public String getZhiBuKa() {
        return zhiBuKa;
    }

    /**
     * 属性直补卡号/银行卡号/直补卡号/银行卡号的setter方法
     */
    public void setZhiBuKa(String zhiBuKa) {
        this.zhiBuKa = zhiBuKa;
    }


    /**
     * 属性险类/险类的getter方法
     */
    public String getClassCode() {
        return classCode;
    }

    /**
     * 属性险类/险类的setter方法
     */
    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }

    /**
     * 属性险种/险种的getter方法
     */
    public String getRiskCode() {
        return riskCode;
    }

    /**
     * 属性险种/险种的setter方法
     */
    public void setRiskCode(String riskCode) {
        this.riskCode = riskCode;
    }


    /**
     * 属性自定义种植面积/自定义种植面积的getter方法
     */
    public Double getTaxArea() {
        return taxArea;
    }

    /**
     * 属性自定义种植面积/自定义种植面积的setter方法
     */
    public void setTaxArea(Double taxArea) {
        this.taxArea = taxArea;
    }

    /**
     * 属性投保面积/投保面积的getter方法
     */
    public Double getInsureArea() {
        return insureArea;
    }

    /**
     * 属性投保面积/投保面积的setter方法
     */
    public void setInsureArea(Double insureArea) {
        this.insureArea = insureArea;
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
     * 属性农民自缴保费/农民自缴保费的getter方法
     */
    public Double getFPremium() {
        return fPremium;
    }

    /**
     * 属性农民自缴保费/农民自缴保费的setter方法
     */
    public void setFPremium(Double fPremium) {
        this.fPremium = fPremium;
    }

    /**
     * 属性组别/组别的getter方法
     */
    public String getTeamName() {
        return teamName;
    }

    /**
     * 属性组别/组别的setter方法
     */
    public void setTeamName(String teamName) {
        this.teamName = teamName;
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
     * 属性土地来源/土地来源的getter方法
     */
    public String getFieldSource() {
        return fieldSource;
    }

    /**
     * 属性土地来源/土地来源的setter方法
     */
    public void setFieldSource(String fieldSource) {
        this.fieldSource = fieldSource;
    }
}