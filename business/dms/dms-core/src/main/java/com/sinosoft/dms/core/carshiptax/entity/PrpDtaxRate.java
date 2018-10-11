package com.sinosoft.dms.core.carshiptax.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;

import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail sucong13146@sinosoft.com.cn
 * @time  2017-08-25 08:49:27.222
 * 税率表实体操作对象
 */
@Entity
@Table(name = "PrpDtaxRate")
@IdClass(PrpDtaxRateKey.class)
public class PrpDtaxRate extends BaseEntityImpl{

    private static final long serialVersionUID = 1L;
    /** 属性机构代码/机构代码 */
    @Id
    @Column(name = "comCode")
    private String comCode ;/** 属性税目税额期次/税目税额期次 */
    @Id
    @Column(name = "taxPeriod")
    private java.lang.Integer taxPeriod ;/** 属性序号/序号 */
    @Id
    @Column(name = "serialNo")
    private java.lang.Integer serialNo ;/** 属性税目代码/税目代码 */
    @Id
    @Column(name = "taxItemCode")
    private String taxItemCode ;



    /** 属性生效日期/生效日期 */
    private java.util.Date validDate ;
    /** 属性行政区划代码/行政区划代码 */
    private String areaCode ;
    /** 属性税务机构代码/税务机构代码 */
    private String taxComCode ;

    /** 属性税目名称/税目名称 */
    private String taxItemName ;
    /** 属性税目明细代码/税目明细代码 */
    private String taxDetailItemCode ;
    /** 属性税目明细名称/税目明细名称 */
    private String taxDetailItemName ;
    /** 属性计税标准/计税标准 */
    private String baseTaxation ;
    /** 属性计税单位值（吨位或座位）/计税单位值（吨位或座位） */
    private java.lang.Double taxUnit ;
    /** 属性计税单位值上限/计税单位值上限 */
    private java.lang.Double taxUnitUpper ;
    /** 属性计税单位值下限/计税单位值下限 */
    private java.lang.Double taxUnitLower ;
    /** 属性整备质量/整备质量 */
    private java.lang.Double completeKerbMass ;
    /** 属性车牌种类/车牌种类 */
    private String licenseType ;
    /** 属性车辆种类代码/车辆种类代码 */
    private String carKindCode ;
    /** 属性计税年度/计税年度 */
    private String taxYear ;
    /** 属性减免比例/减免比例 */
    private java.lang.Double freeRate ;
    /** 属性税率代码/税率代码 */
    private String rateRatio ;
    /** 属性年单位税额/年单位税额 */
    private java.lang.Double taxDue ;
    /** 属性年单位税额上限/年单位税额上限 */
    private java.lang.Double taxDueUpper ;
    /** 属性年单位税额下限/年单位税额下限 */
    private java.lang.Double taxDueLower ;
    /** 属性效力状态/效力状态 */
    private String validStatus ;
    /** 属性备注/备注 */
    private String remark ;
    /** 属性标志字段/标志字段 */
    private String flag ;
    /** 属性扩展字段1（字符）/扩展字段1（字符） */
    private String extendChar1 ;
    /** 属性扩展字段2（字符）/扩展字段2（字符） */
    private String extendChar2 ;
    /** 属性扩展字段1（数字）/扩展字段1（数字） */
    private java.lang.Double extendNum1 ;
    /** 属性扩展字段2（数字）/扩展字段2（数字） */
    private java.lang.Double extendNum2 ;
    /**
     * 属性机构代码/机构代码的getter方法
     */
    public String getComCode() {
        return comCode;
    }
    /**
     * 属性机构代码/机构代码的setter方法
     */
    public void setComCode(String comCode) {
        this.comCode = comCode;
    }
    /**
     * 属性税目税额期次/税目税额期次的getter方法
     */
    public java.lang.Integer getTaxPeriod() {
        return taxPeriod;
    }
    /**
     * 属性税目税额期次/税目税额期次的setter方法
     */
    public void setTaxPeriod(java.lang.Integer taxPeriod) {
        this.taxPeriod = taxPeriod;
    }
    /**
     * 属性序号/序号的getter方法
     */
    public java.lang.Integer getSerialNo() {
        return serialNo;
    }
    /**
     * 属性序号/序号的setter方法
     */
    public void setSerialNo(java.lang.Integer serialNo) {
        this.serialNo = serialNo;
    }
    /**
     * 属性生效日期/生效日期的getter方法
     */
    public java.util.Date getValidDate() {
        return validDate;
    }
    /**
     * 属性生效日期/生效日期的setter方法
     */
    public void setValidDate(java.util.Date validDate) {
        this.validDate = validDate;
    }
    /**
     * 属性行政区划代码/行政区划代码的getter方法
     */
    public String getAreaCode() {
        return areaCode;
    }
    /**
     * 属性行政区划代码/行政区划代码的setter方法
     */
    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }
    /**
     * 属性税务机构代码/税务机构代码的getter方法
     */
    public String getTaxComCode() {
        return taxComCode;
    }
    /**
     * 属性税务机构代码/税务机构代码的setter方法
     */
    public void setTaxComCode(String taxComCode) {
        this.taxComCode = taxComCode;
    }
    /**
     * 属性税目代码/税目代码的getter方法
     */
    public String getTaxItemCode() {
        return taxItemCode;
    }
    /**
     * 属性税目代码/税目代码的setter方法
     */
    public void setTaxItemCode(String taxItemCode) {
        this.taxItemCode = taxItemCode;
    }
    /**
     * 属性税目名称/税目名称的getter方法
     */
    public String getTaxItemName() {
        return taxItemName;
    }
    /**
     * 属性税目名称/税目名称的setter方法
     */
    public void setTaxItemName(String taxItemName) {
        this.taxItemName = taxItemName;
    }
    /**
     * 属性税目明细代码/税目明细代码的getter方法
     */
    public String getTaxDetailItemCode() {
        return taxDetailItemCode;
    }
    /**
     * 属性税目明细代码/税目明细代码的setter方法
     */
    public void setTaxDetailItemCode(String taxDetailItemCode) {
        this.taxDetailItemCode = taxDetailItemCode;
    }
    /**
     * 属性税目明细名称/税目明细名称的getter方法
     */
    public String getTaxDetailItemName() {
        return taxDetailItemName;
    }
    /**
     * 属性税目明细名称/税目明细名称的setter方法
     */
    public void setTaxDetailItemName(String taxDetailItemName) {
        this.taxDetailItemName = taxDetailItemName;
    }
    /**
     * 属性计税标准/计税标准的getter方法
     */
    public String getBaseTaxation() {
        return baseTaxation;
    }
    /**
     * 属性计税标准/计税标准的setter方法
     */
    public void setBaseTaxation(String baseTaxation) {
        this.baseTaxation = baseTaxation;
    }
    /**
     * 属性计税单位值（吨位或座位）/计税单位值（吨位或座位）的getter方法
     */
    public java.lang.Double getTaxUnit() {
        return taxUnit;
    }
    /**
     * 属性计税单位值（吨位或座位）/计税单位值（吨位或座位）的setter方法
     */
    public void setTaxUnit(java.lang.Double taxUnit) {
        this.taxUnit = taxUnit;
    }
    /**
     * 属性计税单位值上限/计税单位值上限的getter方法
     */
    public java.lang.Double getTaxUnitUpper() {
        return taxUnitUpper;
    }
    /**
     * 属性计税单位值上限/计税单位值上限的setter方法
     */
    public void setTaxUnitUpper(java.lang.Double taxUnitUpper) {
        this.taxUnitUpper = taxUnitUpper;
    }
    /**
     * 属性计税单位值下限/计税单位值下限的getter方法
     */
    public java.lang.Double getTaxUnitLower() {
        return taxUnitLower;
    }
    /**
     * 属性计税单位值下限/计税单位值下限的setter方法
     */
    public void setTaxUnitLower(java.lang.Double taxUnitLower) {
        this.taxUnitLower = taxUnitLower;
    }
    /**
     * 属性整备质量/整备质量的getter方法
     */
    public java.lang.Double getCompleteKerbMass() {
        return completeKerbMass;
    }
    /**
     * 属性整备质量/整备质量的setter方法
     */
    public void setCompleteKerbMass(java.lang.Double completeKerbMass) {
        this.completeKerbMass = completeKerbMass;
    }
    /**
     * 属性车牌种类/车牌种类的getter方法
     */
    public String getLicenseType() {
        return licenseType;
    }
    /**
     * 属性车牌种类/车牌种类的setter方法
     */
    public void setLicenseType(String licenseType) {
        this.licenseType = licenseType;
    }
    /**
     * 属性车辆种类代码/车辆种类代码的getter方法
     */
    public String getCarKindCode() {
        return carKindCode;
    }
    /**
     * 属性车辆种类代码/车辆种类代码的setter方法
     */
    public void setCarKindCode(String carKindCode) {
        this.carKindCode = carKindCode;
    }
    /**
     * 属性计税年度/计税年度的getter方法
     */
    public String getTaxYear() {
        return taxYear;
    }
    /**
     * 属性计税年度/计税年度的setter方法
     */
    public void setTaxYear(String taxYear) {
        this.taxYear = taxYear;
    }
    /**
     * 属性减免比例/减免比例的getter方法
     */
    public java.lang.Double getFreeRate() {
        return freeRate;
    }
    /**
     * 属性减免比例/减免比例的setter方法
     */
    public void setFreeRate(java.lang.Double freeRate) {
        this.freeRate = freeRate;
    }
    /**
     * 属性税率代码/税率代码的getter方法
     */
    public String getRateRatio() {
        return rateRatio;
    }
    /**
     * 属性税率代码/税率代码的setter方法
     */
    public void setRateRatio(String rateRatio) {
        this.rateRatio = rateRatio;
    }
    /**
     * 属性年单位税额/年单位税额的getter方法
     */
    public java.lang.Double getTaxDue() {
        return taxDue;
    }
    /**
     * 属性年单位税额/年单位税额的setter方法
     */
    public void setTaxDue(java.lang.Double taxDue) {
        this.taxDue = taxDue;
    }
    /**
     * 属性年单位税额上限/年单位税额上限的getter方法
     */
    public java.lang.Double getTaxDueUpper() {
        return taxDueUpper;
    }
    /**
     * 属性年单位税额上限/年单位税额上限的setter方法
     */
    public void setTaxDueUpper(java.lang.Double taxDueUpper) {
        this.taxDueUpper = taxDueUpper;
    }
    /**
     * 属性年单位税额下限/年单位税额下限的getter方法
     */
    public java.lang.Double getTaxDueLower() {
        return taxDueLower;
    }
    /**
     * 属性年单位税额下限/年单位税额下限的setter方法
     */
    public void setTaxDueLower(java.lang.Double taxDueLower) {
        this.taxDueLower = taxDueLower;
    }
    /**
     * 属性效力状态/效力状态的getter方法
     */
    public String getValidStatus() {
        return validStatus;
    }
    /**
     * 属性效力状态/效力状态的setter方法
     */
    public void setValidStatus(String validStatus) {
        this.validStatus = validStatus;
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
     * 属性标志字段/标志字段的getter方法
     */
    public String getFlag() {
        return flag;
    }
    /**
     * 属性标志字段/标志字段的setter方法
     */
    public void setFlag(String flag) {
        this.flag = flag;
    }
    /**
     * 属性扩展字段1（字符）/扩展字段1（字符）的getter方法
     */
    public String getExtendChar1() {
        return extendChar1;
    }
    /**
     * 属性扩展字段1（字符）/扩展字段1（字符）的setter方法
     */
    public void setExtendChar1(String extendChar1) {
        this.extendChar1 = extendChar1;
    }
    /**
     * 属性扩展字段2（字符）/扩展字段2（字符）的getter方法
     */
    public String getExtendChar2() {
        return extendChar2;
    }
    /**
     * 属性扩展字段2（字符）/扩展字段2（字符）的setter方法
     */
    public void setExtendChar2(String extendChar2) {
        this.extendChar2 = extendChar2;
    }
    /**
     * 属性扩展字段1（数字）/扩展字段1（数字）的getter方法
     */
    public java.lang.Double getExtendNum1() {
        return extendNum1;
    }
    /**
     * 属性扩展字段1（数字）/扩展字段1（数字）的setter方法
     */
    public void setExtendNum1(java.lang.Double extendNum1) {
        this.extendNum1 = extendNum1;
    }
    /**
     * 属性扩展字段2（数字）/扩展字段2（数字）的getter方法
     */
    public java.lang.Double getExtendNum2() {
        return extendNum2;
    }
    /**
     * 属性扩展字段2（数字）/扩展字段2（数字）的setter方法
     */
    public void setExtendNum2(java.lang.Double extendNum2) {
        this.extendNum2 = extendNum2;
    }
}
