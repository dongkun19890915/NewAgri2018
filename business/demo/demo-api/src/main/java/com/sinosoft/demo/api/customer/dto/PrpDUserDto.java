package com.sinosoft.demo.api.customer.dto;

import java.util.List;

public class PrpDUserDto {
    private String userCode;
    private List<PrpDcompanyDto> prpDcompanyDtoList;
    private PrpDcompanyDto prpDcompanyDto;

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public List<PrpDcompanyDto> getPrpDcompanyDtoList() {
        return prpDcompanyDtoList;
    }

    public void setPrpDcompanyDtoList(List<PrpDcompanyDto> prpDcompanyDtoList) {
        this.prpDcompanyDtoList = prpDcompanyDtoList;
    }

    public PrpDcompanyDto getPrpDcompanyDto() {
        return prpDcompanyDto;
    }

    public void setPrpDcompanyDto(PrpDcompanyDto prpDcompanyDto) {
        this.prpDcompanyDto = prpDcompanyDto;
    }
}
