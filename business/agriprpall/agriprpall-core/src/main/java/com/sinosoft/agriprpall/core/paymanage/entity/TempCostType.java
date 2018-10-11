package com.sinosoft.agriprpall.core.paymanage.entity;

import com.sinosoft.framework.core.dao.BaseEntity;
import com.sinosoft.framework.core.dao.BaseEntityImpl;

import javax.persistence.*;

/**
 * 费用类型对应收付原因的临时表
 *
 * @date: 2018/2/12 15:08
 * @author: 何伟东
 */
@Entity
@Table(name = "Temp_CostType")
@IdClass(TempCostTypeKey.class)
public class TempCostType {

    private static final long serialVersionUID = 1L;
    /**
     * 费用类型
     */
    @Id
    @Column(name = "costType")
    private String costType;

    /**
     * 收付原因
     */
    @Id
    @Column(name = "payReason")
    private String payReason;

    public TempCostType() {
    }

    public TempCostType(String costType, String payReason) {
        this.costType = costType;
        this.payReason = payReason;
    }

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