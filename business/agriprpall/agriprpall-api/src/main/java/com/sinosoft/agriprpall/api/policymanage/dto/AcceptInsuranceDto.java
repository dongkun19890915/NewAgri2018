package com.sinosoft.agriprpall.api.policymanage.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;

/**承保分户清单dto
* @Author: 田健
* @Date: 2018/4/11 11:31
*/
public class AcceptInsuranceDto extends BaseRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    //投保单号
    private String proposalNo;
    //保单号
    private String policyNo;
    //农户代码
    private String fCode;
    //农户姓名
    private String fName;
    //身份证号码
    private String fIdCard;
    //银行卡号
    private String zhiBuKa;
    //联系电话
    private String phone;
    //险别
    private String kindCode;
    //标的
    private String itemCode;
    //总保额
    private String sumAmount;
    //总保费
    private String sumPremium;
    //有效保额
    private String effAmount;
    //自缴保费
    private String fPremium;
    //中央财政补贴
    private String centralPremium;
    //省级财政补贴
    private String provincePremium;
    //地市财政补贴
    private String cityPremium;
    //区(县)财政
    private String townPremium;
    //其他来源补贴
    private String otherPremium;
    //粮补面积
    private String atArea;
    //土地来源
    private String fieldSource;
    //备注
    private String remark;
    //投保面积
    private String InsureArea;
    //饲养地点
    private String breedingAreaName;
   //饲养品种
    private String species;
    //饲养方式（规模/散养）
    private String breedingKind;
    //耳标号
    private String earlAbel;
    public String getProposalNo() {
        return proposalNo;
    }

    public void setProposalNo(String proposalNo) {
        this.proposalNo = proposalNo;
    }

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
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

    public String getfIdCard() {        return fIdCard;    }

    public void setfIdCard(String fIdCard) {        this.fIdCard = fIdCard;    }

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

    public String getSumAmount() {
        return sumAmount;
    }

    public void setSumAmount(String sumAmount) {
        this.sumAmount = sumAmount;
    }

    public String getSumPremium() {
        return sumPremium;
    }

    public void setSumPremium(String sumPremium) {
        this.sumPremium = sumPremium;
    }

    public String getEffAmount() {
        return effAmount;
    }

    public void setEffAmount(String effAmount) {
        this.effAmount = effAmount;
    }

    public String getfPremium() {
        return fPremium;
    }

    public void setfPremium(String fPremium) {
        this.fPremium = fPremium;
    }

    public String getCentralPremium() {
        return centralPremium;
    }

    public void setCentralPremium(String centralPremium) {
        this.centralPremium = centralPremium;
    }

    public String getProvincePremium() {
        return provincePremium;
    }

    public void setProvincePremium(String provincePremium) {
        this.provincePremium = provincePremium;
    }

    public String getCityPremium() {
        return cityPremium;
    }

    public void setCityPremium(String cityPremium) {
        this.cityPremium = cityPremium;
    }

    public String getTownPremium() {
        return townPremium;
    }

    public void setTownPremium(String townPremium) {
        this.townPremium = townPremium;
    }

    public String getOtherPremium() {
        return otherPremium;
    }

    public void setOtherPremium(String otherPremium) {
        this.otherPremium = otherPremium;
    }

    public String getAtArea() {
        return atArea;
    }

    public void setAtArea(String atArea) {
        this.atArea = atArea;
    }

    public String getFieldSource() {
        return fieldSource;
    }

    public void setFieldSource(String fieldSource) {
        this.fieldSource = fieldSource;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getInsureArea() {
        return InsureArea;
    }

    public void setInsureArea(String insureArea) {
        InsureArea = insureArea;
    }

    public String getBreedingAreaName() {        return breedingAreaName;    }

    public void setBreedingAreaName(String breedingAreaName) {        this.breedingAreaName = breedingAreaName;    }

    public String getSpecies() {        return species;    }

    public void setSpecies(String species) {        this.species = species;    }

    public String getBreedingKind() {        return breedingKind;    }

    public void setBreedingKind(String breedingKind) {        this.breedingKind = breedingKind;    }

    public String getEarlAbel() {        return earlAbel;    }

    public void setEarlAbel(String earlAbel) {        this.earlAbel = earlAbel;    }
}
