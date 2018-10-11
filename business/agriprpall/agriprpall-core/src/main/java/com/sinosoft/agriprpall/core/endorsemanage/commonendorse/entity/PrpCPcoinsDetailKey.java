package com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;

import javax.persistence.Column;

/**
 * @author codegen@研发中心
 * @mail codegen@sinosoft.com.cn
 * @time  2017-10-21 08:59:58.361
 * PrpCCoinsDetail主键操作对象
 */
public class PrpCPcoinsDetailKey extends BasePKImpl{
    private static final long serialVersionUID = 1L;
    public PrpCPcoinsDetailKey(){}
    public PrpCPcoinsDetailKey(String policyNo, Integer serialNo, String currency){
        this.policyNo = policyNo;
        this.serialNo = serialNo;
        this.currency = currency;
    }
    /** 属性保单号/ 保单号 */
    @Column(name = "policyNo")
    private String policyNo ;
    /** 属性序列号/序列号 */
    @Column(name = "serialNo")
    private Integer serialNo ;
    /** 属性币别/币别 */
    @Column(name = "currency")
    private String currency ;
    /**
     * 属性保单号/保单号的getter方法
     */
    public String getPolicyNo() {
        return policyNo;
    }
    /**
     * 属性保单号/保单号的setter方法
     */
    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }
    /**
     * 属性序列号/序列号的getter方法
     */
    public Integer getSerialNo() {
        return serialNo;
    }
    /**
     * 属性序列号/序列号的setter方法
     */
    public void setSerialNo(Integer serialNo) {
        this.serialNo = serialNo;
    }
    /**
     * 属性币别/币别的getter方法
     */
    public String getCurrency() {
        return currency;
    }
    /**
     * 属性币别/币别的setter方法
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }
}