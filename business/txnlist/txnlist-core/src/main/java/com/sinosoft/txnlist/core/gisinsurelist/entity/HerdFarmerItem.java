package com.sinosoft.txnlist.core.gisinsurelist.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**新建entity接收union all查询数据
* @author: 田健
* @date: 2018/3/5 14:58
 * */
@Entity
public class HerdFarmerItem {
    @Id
    private Long rownum;
    /**
     * 属性耳标号/脚环号/耳标号/脚环号
     */
    private String earLabel;
    /**
     * 属性清单编号/清单编号
     */
    private String insureListCode;
    /**
     * 属性标的代码/标的代码
     */
    private String itemCode;
    /**
     * 属性农户代码/农户代码
     */
    private String fCode;
    /**
     * 属性序列号/序列号
     */
    private Integer serialNo;
    /**
     * 属性标的清单编号/标的清单编号
     */
    private String itemListCode;
    /**
     * 属性投保数量/投保数量
     */
    private Double insureCount;
    /** 属性农户姓名/农户姓名 */
    private String fName ;
    /** 属性证件号码/证件号码 */
    private String fIdCard ;
    /** 属性联系手机号码/联系手机号码 */
    private String fPhone ;
    /** 属性开户银行名称/开户银行名称 */
    private String bankName ;
    /** 属性开户银行联行号/开户银行联行号 */
    private String bankNumber ;
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


    public Long getRownum() {
        return rownum;
    }

    public void setRownum(Long rownum) {
        this.rownum = rownum;
    }

    public String getEarLabel() {
        return earLabel;
    }

    public void setEarLabel(String earLabel) {
        this.earLabel = earLabel;
    }

    public String getInsureListCode() {
        return insureListCode;
    }

    public void setInsureListCode(String insureListCode) {
        this.insureListCode = insureListCode;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getfCode() {
        return fCode;
    }

    public void setfCode(String fCode) {
        this.fCode = fCode;
    }

    public Integer getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Integer serialNo) {
        this.serialNo = serialNo;
    }

    public String getItemListCode() {
        return itemListCode;
    }

    public void setItemListCode(String itemListCode) {
        this.itemListCode = itemListCode;
    }

    public Double getInsureCount() {
        return insureCount;
    }

    public void setInsureCount(Double insureCount) {
        this.insureCount = insureCount;
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

    public String getfPhone() {
        return fPhone;
    }

    public void setfPhone(String fPhone) {
        this.fPhone = fPhone;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankNumber() {
        return bankNumber;
    }

    public void setBankNumber(String bankNumber) {
        this.bankNumber = bankNumber;
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
}
