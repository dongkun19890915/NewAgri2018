package com.sinosoft.agriprpall.api.endorsemanage.dto;

import com.sinosoft.agriprpall.api.policymanage.dto.ResponseQueryPolicyInfoDto;
import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;

public class PolicyEndorseDto extends BaseRequest implements Serializable{
    private static final long serialVersionUID = 1L;

    private ResponseQueryPolicyInfoDto blPolicyInfoDtoNew;

    private ResponseQueryPolicyInfoDto blPolicyInfoDtoOld;

    private BLEndorseDto blEndorseDto;

    public ResponseQueryPolicyInfoDto getBlPolicyInfoDtoNew() {
        return blPolicyInfoDtoNew;
    }

    public void setBlPolicyInfoDtoNew(ResponseQueryPolicyInfoDto blPolicyInfoDtoNew) {
        this.blPolicyInfoDtoNew = blPolicyInfoDtoNew;
    }

    public ResponseQueryPolicyInfoDto getBlPolicyInfoDtoOld() {
        return blPolicyInfoDtoOld;
    }

    public void setBlPolicyInfoDtoOld(ResponseQueryPolicyInfoDto blPolicyInfoDtoOld) {
        this.blPolicyInfoDtoOld = blPolicyInfoDtoOld;
    }

    public BLEndorseDto getBlEndorseDto() {
        return blEndorseDto;
    }

    public void setBlEndorseDto(BLEndorseDto blEndorseDto) {
        this.blEndorseDto = blEndorseDto;
    }
}
