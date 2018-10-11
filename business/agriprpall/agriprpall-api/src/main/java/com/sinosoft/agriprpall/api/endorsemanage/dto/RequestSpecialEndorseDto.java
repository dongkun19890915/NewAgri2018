package com.sinosoft.agriprpall.api.endorsemanage.dto;

import com.sinosoft.agriprpall.api.policymanage.dto.PrpCitemKindDto;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCsubsidyDto;
import com.sinosoft.agriprpall.api.policymanage.dto.ResponseQueryPolicyListInfoDto;

import java.util.List;

public class RequestSpecialEndorseDto {

    private List<BLEndorseDto> blEndorseDtoList;
    private EndorseConditionDto endorseConditionDto;

    private List<PrpCsubsidyDto> prpCsubsidyDtoListNew;
    private List<PrpCitemKindDto> prpCitemKindDtoListNew;
    private List<ResponseQueryPolicyListInfoDto> responseQueryPolicyListInfoDtoList;
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<BLEndorseDto> getBlEndorseDtoList() {
        return blEndorseDtoList;
    }

    public void setBlEndorseDtoList(List<BLEndorseDto> blEndorseDtoList) {
        this.blEndorseDtoList = blEndorseDtoList;
    }

    public List<PrpCsubsidyDto> getPrpCsubsidyDtoListNew() {
        return prpCsubsidyDtoListNew;
    }

    public void setPrpCsubsidyDtoListNew(List<PrpCsubsidyDto> prpCsubsidyDtoListNew) {
        this.prpCsubsidyDtoListNew = prpCsubsidyDtoListNew;
    }

    public List<PrpCitemKindDto> getPrpCitemKindDtoListNew() {
        return prpCitemKindDtoListNew;
    }

    public void setPrpCitemKindDtoListNew(List<PrpCitemKindDto> prpCitemKindDtoListNew) {
        this.prpCitemKindDtoListNew = prpCitemKindDtoListNew;
    }

    public EndorseConditionDto getEndorseConditionDto() {
        return endorseConditionDto;
    }

    public void setEndorseConditionDto(EndorseConditionDto endorseConditionDto) {
        this.endorseConditionDto = endorseConditionDto;
    }

    public List<ResponseQueryPolicyListInfoDto> getResponseQueryPolicyListInfoDtoList() {
        return responseQueryPolicyListInfoDtoList;
    }

    public void setResponseQueryPolicyListInfoDtoList(List<ResponseQueryPolicyListInfoDto> responseQueryPolicyListInfoDtoList) {
        this.responseQueryPolicyListInfoDtoList = responseQueryPolicyListInfoDtoList;
    }
}
