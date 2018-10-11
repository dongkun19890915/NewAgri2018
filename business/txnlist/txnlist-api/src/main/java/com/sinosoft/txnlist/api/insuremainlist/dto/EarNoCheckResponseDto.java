package com.sinosoft.txnlist.api.insuremainlist.dto;

import com.sinosoft.framework.dto.BaseRequest;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.HerdPolicyListDto;

import java.io.Serializable;
import java.util.List;

public class EarNoCheckResponseDto extends BaseRequest implements Serializable {

    private static final long serialVersionUID = 1L;
    private List<InsureMainListDto> insureMainListDtoList;
    private List<HerdPolicyListDto> herdPolicyListDtoList;
    private List<HerdPolicyListDto> herdEndorsePolicyListDtoList;
    public List<InsureMainListDto> getInsureMainListDtoList() {
        return insureMainListDtoList;
    }
    public void setInsureMainListDtoList(List<InsureMainListDto> insureMainListDtoList) {
        this.insureMainListDtoList = insureMainListDtoList;
    }
    public List<HerdPolicyListDto> getHerdPolicyListDtoList() {
        return herdPolicyListDtoList;
    }
    public void setHerdPolicyListDtoList(List<HerdPolicyListDto> herdPolicyListDtoList) {
        this.herdPolicyListDtoList = herdPolicyListDtoList;
    }
    public List<HerdPolicyListDto> getHerdEndorsePolicyListDtoList() {
        return herdEndorsePolicyListDtoList;
    }
    public void setHerdEndorsePolicyListDtoList(List<HerdPolicyListDto> herdEndorsePolicyListDtoList) {
        this.herdEndorsePolicyListDtoList = herdEndorsePolicyListDtoList;
    }
    
}
