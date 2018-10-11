package com.sinosoft.txnlist.api.gisinsurelist.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/** 保费计算与清单数据交互子表Dto
 * @Author: 田健
 * @Date: 2018/1/17 9:50
 */
public class TxnlistDetailedSubDto extends BaseRequest implements Serializable {
    /** 属性险别序号/险别序号 */
    private String kindCode;
    /** 属性费率/费率 */
    private Double rate ;
    /** 属性短期费率方式/短期费率方式 */
    private String shortRateFlag;
    /** 属性短期费率/短期费率 */
    private Double shortRate;
    /** 属性主险标志（Y是、N否）/主险标志（Y是、N否） */
    private String calculateFlag;
    /** 属性单位保额/单位保额 */
    private Double amount ;
    /** 属性有效标志位：0：无效；2：暂存；1：已提交/有效标志位：0：无效；2：暂存；1：已提交 */
    private String validity ;
    /** 属性险类/险类 */
    private String classCode;
    /** 属性险种/险种 */
    private String riskCode;
    /** 属性总保额/总保额 */
    private Double sumAmount;
    /** 属性总保费/总保费 */
    private Double sumPremium;
    /** 属性农民自缴保费/农民自缴保费 */
    private Double fPremium;
    /** 属性中央财政补贴/中央财政补贴 */
    private Double centralPremium;
    /** 属性省级财政补贴/省级财政补贴 */
    private Double provincePremium;
    /** 属性地市财政补贴/地市财政补贴 */
    private Double cityPremium;
    /** 属性县(区)财政补贴/县(区)财政补贴 */
    private Double townPremium;
    /** 属性其他来源补贴/其他来源补贴 */
    private Double otherPremium;
    /** 属性清单编号/清单编号   */
    private String inusreListCode;
    /**  属性农户代码/农户代码 */
    private String fCode;
    /** 属性标的代码/标的代码 */
    private String itemCode;
    /** 属性排序序号/排序序号 */
    private String indexCode;
    /** 起保日期*/
    private  Date startDate;
    /** 终保日期*/
    private  Date endDate;
    /**
     * 属性耳标号/耳标号
     */
    private String earlAbel;
    /**
     * 属性养殖地点代码/养殖地点代码
     */

    private String breedingAreaCode;
    /**
     * 属性养殖地点名称/养殖地点名称
     */

    private String breedingAreaName;
    /**
     * 属性畜龄/畜龄
     */

    private Double animalAge;
    /**
     * 属性养殖品种/养殖品种
     */

    private String species;
    /**
     * 属性赔付数量/赔付数量
     */

    private Integer settleNumber;
    /**
     * 属性农户姓名/农户姓名
     */

    private String fName;
    /**
     * 属性农户身份证/农户身份证
     */

    private String fIdCard;
    /**
     * 属性联系电话/联系电话
     */

    private String phone;
    /**
     * 属性银行卡帐号/银行卡帐号
     */

    private String bankCard;
    /**
     * 属性开户银行/开户银行
     */

    private String bank;
    /**
     * 属性养殖数量/养殖数量
     */

    private Integer breedingNumber;
    /**
     * 属性投保数量/投保数量
     */

    private Integer insureNumber;
    /**
     * 属性业务号（种植为农户身份证号,养殖为耳标号）/业务号（种植为农户身份证号,养殖为耳标号）
     */
    private String businessNo;
    /** 属性联系手机号码/联系手机号码 */
    private String fPhone ;
    /**直不卡*/
    private String zhiBuKa;
    /** 属性投保总面积/投标总数量/投保总面积/投标总数量 */
    private Double insureArea ;
    public String getKindCode() {
        return kindCode;
    }
    /** 属性养殖方式/养殖方式*/
    private String breedingKind;
    /*行业类别*/
    private String industryCategory;
    /*贷款合同编号*/
    private String loanContractNo;
    /*贷款银行代码*/
    private String loanBankAccount;
    /*贷款金额*/
    private Double loadAmount;
    /*担保人*/
    private String guarantor;
    /*贷款期限*/
    private Date loanPeriod;
    /*贷款用途*/
    private String loanUse;
    private List<GisManFieldListDto> gisManFieldListDtoList;

    public String getIndustryCategory() {
        return industryCategory;
    }

    public void setIndustryCategory(String industryCategory) {
        this.industryCategory = industryCategory;
    }

    public String getLoanContractNo() {
        return loanContractNo;
    }

    public void setLoanContractNo(String loanContractNo) {
        this.loanContractNo = loanContractNo;
    }

    public String getLoanBankAccount() {
        return loanBankAccount;
    }

    public void setLoanBankAccount(String loanBankAccount) {
        this.loanBankAccount = loanBankAccount;
    }

    public Double getLoadAmount() {
        return loadAmount;
    }

    public void setLoadAmount(Double loadAmount) {
        this.loadAmount = loadAmount;
    }

    public String getGuarantor() {
        return guarantor;
    }

    public void setGuarantor(String guarantor) {
        this.guarantor = guarantor;
    }

    public Date getLoanPeriod() {
        return loanPeriod;
    }

    public void setLoanPeriod(Date loanPeriod) {
        this.loanPeriod = loanPeriod;
    }

    public String getLoanUse() {
        return loanUse;
    }

    public void setLoanUse(String loanUse) {
        this.loanUse = loanUse;
    }

    public List<GisManFieldListDto> getGisManFieldListDtoList() {
        return gisManFieldListDtoList;
    }

    public void setGisManFieldListDtoList(List<GisManFieldListDto> gisManFieldListDtoList) {
        this.gisManFieldListDtoList = gisManFieldListDtoList;
    }

    public void setKindCode(String kindCode) {
        this.kindCode = kindCode;
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

    public String getCalculateFlag() {
        return calculateFlag;
    }

    public void setCalculateFlag(String calculateFlag) {
        this.calculateFlag = calculateFlag;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getValidity() {
        return validity;
    }

    public void setValidity(String validity) {
        this.validity = validity;
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

    public String getInusreListCode() {
        return inusreListCode;
    }

    public void setInusreListCode(String inusreListCode) {
        this.inusreListCode = inusreListCode;
    }

    public String getfCode() {        return fCode;    }

    public void setfCode(String fCode) {        this.fCode = fCode;    }

    public String getItemCode() {        return itemCode;    }

    public void setItemCode(String itemCode) {        this.itemCode = itemCode;    }

    public String getIndexCode() {        return indexCode;    }

    public void setIndexCode(String indexCode) {        this.indexCode = indexCode;    }

    public Date getStartDate() {        return startDate;    }

    public void setStartDate(Date startDate) {        this.startDate = startDate;    }

    public Date getEndDate() {        return endDate;    }

    public void setEndDate(Date endDate) {        this.endDate = endDate;    }

    public String getEarlAbel() {
        return earlAbel;
    }

    public void setEarlAbel(String earlAbel) {
        this.earlAbel = earlAbel;
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

    public Double getAnimalAge() {        return animalAge;    }
    public void setAnimalAge(Double animalAge) {        this.animalAge = animalAge;    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public Integer getSettleNumber() {
        return settleNumber;
    }

    public void setSettleNumber(Integer settleNumber) {
        this.settleNumber = settleNumber;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBankCard() {
        return bankCard;
    }

    public void setBankCard(String bankCard) {
        this.bankCard = bankCard;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public Integer getBreedingNumber() {
        return breedingNumber;
    }

    public void setBreedingNumber(Integer breedingNumber) {
        this.breedingNumber = breedingNumber;
    }

    public Integer getInsureNumber() {
        return insureNumber;
    }

    public void setInsureNumber(Integer insureNumber) {
        this.insureNumber = insureNumber;
    }

    public String getBusinessNo() {        return businessNo;    }

    public void setBusinessNo(String businessNo) {        this.businessNo = businessNo;    }

    public String getfPhone() {
        return fPhone;
    }

    public void setfPhone(String fPhone) {
        this.fPhone = fPhone;
    }

    public String getZhiBuKa() {
        return zhiBuKa;
    }

    public void setZhiBuKa(String zhiBuKa) {
        this.zhiBuKa = zhiBuKa;
    }

    public Double getInsureArea() {
        return insureArea;
    }

    public void setInsureArea(Double insureArea) {
        this.insureArea = insureArea;
    }

    public String getBreedingKind() {        return breedingKind;    }

    public void setBreedingKind(String breedingKind) {        this.breedingKind = breedingKind;    }
}
