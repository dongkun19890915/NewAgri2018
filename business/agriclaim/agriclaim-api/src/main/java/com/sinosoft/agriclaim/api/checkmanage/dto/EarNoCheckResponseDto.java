package com.sinosoft.agriclaim.api.checkmanage.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
import com.sinosoft.txnlist.api.insuremainlist.dto.InsureMainListDto;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.HerdPolicyListDto;

public class EarNoCheckResponseDto extends BaseRequest implements Serializable {

    private static final long serialVersionUID = 1L;
    private HerdPolicyListDto herdPolicyListDto;
    private InsureMainListDto insureMainListDto;
    private String inusrelistcode;
    public HerdPolicyListDto getHerdPolicyListDto() {
        return herdPolicyListDto;
    }
    public void setHerdPolicyListDto(HerdPolicyListDto herdPolicyListDto) {
        this.herdPolicyListDto = herdPolicyListDto;
    }
    public InsureMainListDto getInsureMainListDto() {
        return insureMainListDto;
    }
    public void setInsureMainListDto(InsureMainListDto insureMainListDto) {
        this.insureMainListDto = insureMainListDto;
    }
    public String getInusrelistcode() {
        return inusrelistcode;
    }
    public void setInusrelistcode(String inusrelistcode) {
        this.inusrelistcode = inusrelistcode;
    }
    
}
