package com.sinosoft.dms.core.carshiptax.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;

/**
 * @author codegen@研发中心
 * @mail sucong13146@sinosoft.com.cn
 * @time  2017-08-25 08:49:27.222
 * 税率表主键操作对象
 */
public class PrpDtaxRateKey extends BasePKImpl{
    private static final long serialVersionUID = 1L;
    public PrpDtaxRateKey(){}
    public PrpDtaxRateKey(String comCode,java.lang.Integer taxPeriod,java.lang.Integer serialNo,String taxItemCode){
        this.comCode = comCode;
        this.taxPeriod = taxPeriod;
        this.serialNo = serialNo;
        this.taxItemCode = taxItemCode;
    }
    /** 属性机构代码/机构代码 */
    private String comCode ;
    /** 属性税目税额期次/税目税额期次 */
    private java.lang.Integer taxPeriod ;
    /** 属性序号/序号 */
    private java.lang.Integer serialNo ;
    /** 属性税目代码/税目代码 */
    private String taxItemCode ;
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
}