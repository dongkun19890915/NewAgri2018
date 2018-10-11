package com.sinosoft.agriprpall.core.paymanage.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;

import javax.persistence.Column;

/**
 * 费用类型对应收付原因的临时表
 *
 * @date: 2018/2/12 15:08
 * @author: 何伟东
 */
public class TempCostTypeKey extends BasePKImpl {
    private static final long serialVersionUID = 1L;

    public TempCostTypeKey() {
    }

    public TempCostTypeKey(String costType, String payReason) {
        this.costType = costType;
        this.payReason = payReason;
    }

    /**
     * 费用类型
     */
    @Column(name = "costType")
    private String costType;

    /**
     * 收付原因
     */
    @Column(name = "payReason")
    private String payReason;

    public String getCostType() {
        return costType;
    }

    public void setCostType(String costType) {
        this.costType = costType;
    }

    public String getPayReason() {
        return payReason;
    }

    public void setPayReason(String payReason) {
        this.payReason = payReason;
    }
}