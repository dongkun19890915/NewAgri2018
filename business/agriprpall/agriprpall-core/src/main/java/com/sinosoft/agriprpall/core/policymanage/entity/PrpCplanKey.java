package com.sinosoft.agriprpall.core.policymanage.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;

import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time 2017-10-11 08:44:57.118
 * 收费计划表主键操作对象
 */
public class PrpCplanKey extends BasePKImpl {
    private static final long serialVersionUID = 1L;

    public PrpCplanKey() {
    }

    public PrpCplanKey(String policyNo, Integer serialNo) {
        this.policyNo = policyNo;
        this.serialNo = serialNo;
    }

    /**
     * 属性保单号码 /保单号码
     */
    @Column(name = "policyNo")
    private String policyNo;
    /**
     * 属性交费次数序号/交费次数序号
     */
    @Column(name = "serialNo")
    private Integer serialNo;

    /**
     * 属性保单号码 /保单号码 的getter方法
     */
    public String getPolicyNo() {
        return policyNo;
    }

    /**
     * 属性保单号码 /保单号码 的setter方法
     */
    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }

    /**
     * 属性交费次数序号/交费次数序号的getter方法
     */
    public Integer getSerialNo() {
        return serialNo;
    }

    /**
     * 属性交费次数序号/交费次数序号的setter方法
     */
    public void setSerialNo(Integer serialNo) {
        this.serialNo = serialNo;
    }
}