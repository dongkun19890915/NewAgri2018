package com.sinosoft.agriprpall.core.policymanage.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;

import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail codegen@sinosoft.com.cn
 * @time 2017-10-22 07:54:48.524
 * 农险保单标的子险信息表主键操作对象
 */
public class PrpCitemKindAgriKey extends BasePKImpl {
    private static final long serialVersionUID = 1L;

    public PrpCitemKindAgriKey() {
    }

    public PrpCitemKindAgriKey(String policyNo, Integer itemKindNo, String kindCode, Integer times) {
        this.policyNo = policyNo;
        this.itemKindNo = itemKindNo;
        this.kindCode = kindCode;
        this.times = times;
    }

    /**
     * 属性保单号/保单号
     */
    @Column(name = "policyNo")
    private String policyNo;
    /**
     * 属性标的序号/标的序号
     */
    @Column(name = "itemKindNo")
    private Integer itemKindNo;
    /**
     * 属性险别/险别
     */
    @Column(name = "kindCode")
    private String kindCode;
    /**
     * 属性茬次/茬次
     */
    @Column(name = "times")
    private Integer times;

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
     * 属性标的序号/标的序号的getter方法
     */
    public Integer getItemKindNo() {
        return itemKindNo;
    }

    /**
     * 属性标的序号/标的序号的setter方法
     */
    public void setItemKindNo(Integer itemKindNo) {
        this.itemKindNo = itemKindNo;
    }

    /**
     * 属性险别/险别的getter方法
     */
    public String getKindCode() {
        return kindCode;
    }

    /**
     * 属性险别/险别的setter方法
     */
    public void setKindCode(String kindCode) {
        this.kindCode = kindCode;
    }

    /**
     * 属性茬次/茬次的getter方法
     */
    public Integer getTimes() {
        return times;
    }

    /**
     * 属性茬次/茬次的setter方法
     */
    public void setTimes(Integer times) {
        this.times = times;
    }
}