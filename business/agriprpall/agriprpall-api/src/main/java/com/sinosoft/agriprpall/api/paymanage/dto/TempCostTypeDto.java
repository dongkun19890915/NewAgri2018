package com.sinosoft.agriprpall.api.paymanage.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;

/**
 * 费用类型对应收付原因的临时表Dto
 *
 * @date: 2018/2/12 15:08
 * @author: 何伟东
 */
public class TempCostTypeDto extends BaseRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 费用类型
     */
    private String costType;

    /**
     * 收付原因
     */
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
