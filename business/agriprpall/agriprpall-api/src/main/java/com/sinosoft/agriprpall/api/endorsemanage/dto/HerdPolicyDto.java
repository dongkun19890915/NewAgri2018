package com.sinosoft.agriprpall.api.endorsemanage.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;

public class HerdPolicyDto extends BaseRequest implements Serializable{
    private static final long serialVersionUID = 1L;

    //属性InusreListCode
    private String InusreListCode = "";
    //属性EarLabel
    private String EarLabel = "";
    //属性KindCode
    private String KindCode = "";
    //属性IndexCode
    private String IndexCode = "";
    //属性FCode
    private String FCode = "";
    //属性FName
    private String FName = "";
    //属性FIdCard
    private String FIdCard = "";
    //属性BreedingAreaCode
    private String BreedingAreaCode = "";
    //属性Species
    private String Species = "";
    //属性Bank
    private String Bank = "";
    //属性BankCard
    private String BankCard = "";
    //属性InsureNumber
    private String InsureNumber = "";
    //属性Amount
    private String Amount = "";
    //属性Rate
    private String Rate = "";
    //属性ShortRateFlag
    private String ShortRateFlag = "";
    //属性ShortRate
    private String ShortRate = "";
    //属性SumAmount
    private String SumAmount = "";
    //属性SumPremium
    private String SumPremium = "";
    //属性StartDate
    private String StartDate = "";
    //属性EndDate
    private String EndDate = "";
    //属性CalculateFlag
    private String CalculateFlag = "";
    //属性OpCode
    private String OpCode = "";
    //属性OpTime
    private String OpTime = "";
    //属性Validity
    private String Validity = "";
    //属性Remark
    private String Remark = "";
    //属性BreedingNumber
    private String BreedingNumber = "";
    //属性BreedingAreaName
    private String BreedingAreaName = "";
    //属性StartTime
    private String StartTime = "";
    //属性EndTime
    private String EndTime = "";
    //属性Phone
    private String Phone = "";
    //属性SettleNumber
    private String SettleNumber = "";
    //属性Flag
    private String Flag="";
    //属性InsurePremium
    private String InsurePremium="";
    //属性CENTRALPREMIUM
    private String CentralPremium = "";
    //属性PROVINCEPREMIUM
    private String ProvincePremium = "";
    //属性CITYPREMIUM
    private String CityPremium = "";
    //属性TOWNPREMIUM
    private String TownPremium = "";
    //属性OTHERPREMIUM
    private String OtherPremium = "";
    //属性Breedingkind
    private String Breedingkind = "";

    private String AreaNumber = "";

    private String LitterArea = "";

    private String animalAge = "";

    public String getInusreListCode() {
        return InusreListCode;
    }

    public void setInusreListCode(String inusreListCode) {
        InusreListCode = inusreListCode;
    }

    public String getEarLabel() {
        return EarLabel;
    }

    public void setEarLabel(String earLabel) {
        EarLabel = earLabel;
    }

    public String getKindCode() {
        return KindCode;
    }

    public void setKindCode(String kindCode) {
        KindCode = kindCode;
    }

    public String getIndexCode() {
        return IndexCode;
    }

    public void setIndexCode(String indexCode) {
        IndexCode = indexCode;
    }

    public String getFCode() {
        return FCode;
    }

    public void setFCode(String FCode) {
        this.FCode = FCode;
    }

    public String getFName() {
        return FName;
    }

    public void setFName(String FName) {
        this.FName = FName;
    }

    public String getFIdCard() {
        return FIdCard;
    }

    public void setFIdCard(String FIdCard) {
        this.FIdCard = FIdCard;
    }

    public String getBreedingAreaCode() {
        return BreedingAreaCode;
    }

    public void setBreedingAreaCode(String breedingAreaCode) {
        BreedingAreaCode = breedingAreaCode;
    }

    public String getSpecies() {
        return Species;
    }

    public void setSpecies(String species) {
        Species = species;
    }

    public String getBank() {
        return Bank;
    }

    public void setBank(String bank) {
        Bank = bank;
    }

    public String getBankCard() {
        return BankCard;
    }

    public void setBankCard(String bankCard) {
        BankCard = bankCard;
    }

    public String getInsureNumber() {
        return InsureNumber;
    }

    public void setInsureNumber(String insureNumber) {
        InsureNumber = insureNumber;
    }

    public String getAmount() {
        return Amount;
    }

    public void setAmount(String amount) {
        Amount = amount;
    }

    public String getRate() {
        return Rate;
    }

    public void setRate(String rate) {
        Rate = rate;
    }

    public String getShortRateFlag() {
        return ShortRateFlag;
    }

    public void setShortRateFlag(String shortRateFlag) {
        ShortRateFlag = shortRateFlag;
    }

    public String getShortRate() {
        return ShortRate;
    }

    public void setShortRate(String shortRate) {
        ShortRate = shortRate;
    }

    public String getSumAmount() {
        return SumAmount;
    }

    public void setSumAmount(String sumAmount) {
        SumAmount = sumAmount;
    }

    public String getSumPremium() {
        return SumPremium;
    }

    public void setSumPremium(String sumPremium) {
        SumPremium = sumPremium;
    }

    public String getStartDate() {
        return StartDate;
    }

    public void setStartDate(String startDate) {
        StartDate = startDate;
    }

    public String getEndDate() {
        return EndDate;
    }

    public void setEndDate(String endDate) {
        EndDate = endDate;
    }

    public String getCalculateFlag() {
        return CalculateFlag;
    }

    public void setCalculateFlag(String calculateFlag) {
        CalculateFlag = calculateFlag;
    }

    public String getOpCode() {
        return OpCode;
    }

    public void setOpCode(String opCode) {
        OpCode = opCode;
    }

    public String getOpTime() {
        return OpTime;
    }

    public void setOpTime(String opTime) {
        OpTime = opTime;
    }

    public String getValidity() {
        return Validity;
    }

    public void setValidity(String validity) {
        Validity = validity;
    }

    public String getRemark() {
        return Remark;
    }

    public void setRemark(String remark) {
        Remark = remark;
    }

    public String getBreedingNumber() {
        return BreedingNumber;
    }

    public void setBreedingNumber(String breedingNumber) {
        BreedingNumber = breedingNumber;
    }

    public String getBreedingAreaName() {
        return BreedingAreaName;
    }

    public void setBreedingAreaName(String breedingAreaName) {
        BreedingAreaName = breedingAreaName;
    }

    public String getStartTime() {
        return StartTime;
    }

    public void setStartTime(String startTime) {
        StartTime = startTime;
    }

    public String getEndTime() {
        return EndTime;
    }

    public void setEndTime(String endTime) {
        EndTime = endTime;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getSettleNumber() {
        return SettleNumber;
    }

    public void setSettleNumber(String settleNumber) {
        SettleNumber = settleNumber;
    }

    public String getFlag() {
        return Flag;
    }

    public void setFlag(String flag) {
        Flag = flag;
    }

    public String getInsurePremium() {
        return InsurePremium;
    }

    public void setInsurePremium(String insurePremium) {
        InsurePremium = insurePremium;
    }

    public String getCentralPremium() {
        return CentralPremium;
    }

    public void setCentralPremium(String centralPremium) {
        CentralPremium = centralPremium;
    }

    public String getProvincePremium() {
        return ProvincePremium;
    }

    public void setProvincePremium(String provincePremium) {
        ProvincePremium = provincePremium;
    }

    public String getCityPremium() {
        return CityPremium;
    }

    public void setCityPremium(String cityPremium) {
        CityPremium = cityPremium;
    }

    public String getTownPremium() {
        return TownPremium;
    }

    public void setTownPremium(String townPremium) {
        TownPremium = townPremium;
    }

    public String getOtherPremium() {
        return OtherPremium;
    }

    public void setOtherPremium(String otherPremium) {
        OtherPremium = otherPremium;
    }

    public String getBreedingkind() {
        return Breedingkind;
    }

    public void setBreedingkind(String breedingkind) {
        Breedingkind = breedingkind;
    }

    public String getAreaNumber() {
        return AreaNumber;
    }

    public void setAreaNumber(String areaNumber) {
        AreaNumber = areaNumber;
    }

    public String getLitterArea() {
        return LitterArea;
    }

    public void setLitterArea(String litterArea) {
        LitterArea = litterArea;
    }

    public String getAnimalAge() {        return animalAge;    }

    public void setAnimalAge(String animalAge) {        this.animalAge = animalAge;    }
}
