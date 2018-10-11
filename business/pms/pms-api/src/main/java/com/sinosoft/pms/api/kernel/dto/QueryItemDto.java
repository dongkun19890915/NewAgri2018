package com.sinosoft.pms.api.kernel.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;
import java.util.List;


/**
 * *（查询条款的传参）
 * @Author: 田慧
 * @Date: 10:23 10:23
 */
public class QueryItemDto extends BaseRequest implements Serializable {

    //险种代码
    private String riskCode;
    //适用机构
    private List<String> comCodeList;

    public String getRiskCode() {
        return riskCode;
    }

    public void setRiskCode(String riskCode) {
        this.riskCode = riskCode;
    }

    public List<String> getComCodeList() {
        return comCodeList;
    }

    public void setComCodeList(List<String> comCodeList) {
        this.comCodeList = comCodeList;
    }
}
