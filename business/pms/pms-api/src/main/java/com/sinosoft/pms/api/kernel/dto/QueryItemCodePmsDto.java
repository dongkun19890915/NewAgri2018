package com.sinosoft.pms.api.kernel.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class QueryItemCodePmsDto extends BaseRequest implements Serializable {
    private String riskCode;
    private List<String> kindCodeList=new ArrayList<>();
    private List<String> itemCodeList = new ArrayList<>();

    public String getRiskCode() {
        return riskCode;
    }

    public void setRiskCode(String riskCode) {
        this.riskCode = riskCode;
    }

    public List<String> getKindCodeList() {
        return kindCodeList;
    }

    public void setKindCodeList(List<String> kindCodeList) {
        this.kindCodeList = kindCodeList;
    }

    public List<String> getItemCodeList() {
        return itemCodeList;
    }

    public void setItemCodeList(List<String> itemCodeList) {
        this.itemCodeList = itemCodeList;
    }
}
