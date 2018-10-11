package com.sinosoft.agriprpall.api.endorsemanage.dto;

public class EndorsePolicyDto {
   private BLPolicyDto blPolicyDtoNew;
    private BLPolicyDto blPolicyDtoOld;
   private BLEndorseDto blEndorseDto;

    public BLPolicyDto getBlPolicyDtoNew() {
        return blPolicyDtoNew;
    }

    public void setBlPolicyDtoNew(BLPolicyDto blPolicyDtoNew) {
        this.blPolicyDtoNew = blPolicyDtoNew;
    }

    public BLPolicyDto getBlPolicyDtoOld() {
        return blPolicyDtoOld;
    }

    public void setBlPolicyDtoOld(BLPolicyDto blPolicyDtoOld) {
        this.blPolicyDtoOld = blPolicyDtoOld;
    }

    public BLEndorseDto getBlEndorseDto() {
        return blEndorseDto;
    }

    public void setBlEndorseDto(BLEndorseDto blEndorseDto) {
        this.blEndorseDto = blEndorseDto;
    }
}
