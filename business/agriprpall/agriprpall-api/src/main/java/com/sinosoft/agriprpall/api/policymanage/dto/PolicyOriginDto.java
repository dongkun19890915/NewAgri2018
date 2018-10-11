package com.sinosoft.agriprpall.api.policymanage.dto;

import java.util.List;

/**
 * 原始保单大对象
 * @author: 钱浩
 * @date: 2017/11/23 下午 17:26
 */
public class PolicyOriginDto  {
    private  PrpCmainOriginDto prpCmainOriginDto;
    private List<PrpCitemKindOriginDto> prpCitemKindOriginDtoList;
    private List<PrpCfeeOriginDto> prpCfeeOriginDtoList;
    private  List<PrpCcoinsDetailOriginDto> prpCcoinsDetailOriginDtoList;
    private  List<PrpCcoinsOriginDto> prpCcoinsOriginDtoList;
    private PrpCexpenseOriginDto prpCexpenseOriginDto;

    public PrpCmainOriginDto getPrpCmainOriginDto() {
        return prpCmainOriginDto;
    }

    public void setPrpCmainOriginDto(PrpCmainOriginDto prpCmainOriginDto) {
        this.prpCmainOriginDto = prpCmainOriginDto;
    }

    public List<PrpCitemKindOriginDto> getPrpCitemKindOriginDtoList() {
        return prpCitemKindOriginDtoList;
    }

    public void setPrpCitemKindOriginDtoList(List<PrpCitemKindOriginDto> prpCitemKindOriginDtoList) {
        this.prpCitemKindOriginDtoList = prpCitemKindOriginDtoList;
    }

    public List<PrpCfeeOriginDto> getPrpCfeeOriginDtoList() {
        return prpCfeeOriginDtoList;
    }

    public void setPrpCfeeOriginDtoList(List<PrpCfeeOriginDto> prpCfeeOriginDtoList) {
        this.prpCfeeOriginDtoList = prpCfeeOriginDtoList;
    }

    public List<PrpCcoinsDetailOriginDto> getPrpCcoinsDetailOriginDtoList() {
        return prpCcoinsDetailOriginDtoList;
    }

    public void setPrpCcoinsDetailOriginDtoList(List<PrpCcoinsDetailOriginDto> prpCcoinsDetailOriginDtoList) {
        this.prpCcoinsDetailOriginDtoList = prpCcoinsDetailOriginDtoList;
    }

    public List<PrpCcoinsOriginDto> getPrpCcoinsOriginDtoList() {
        return prpCcoinsOriginDtoList;
    }

    public void setPrpCcoinsOriginDtoList(List<PrpCcoinsOriginDto> prpCcoinsOriginDtoList) {
        this.prpCcoinsOriginDtoList = prpCcoinsOriginDtoList;
    }

    public PrpCexpenseOriginDto getPrpCexpenseOriginDto() {
        return prpCexpenseOriginDto;
    }

    public void setPrpCexpenseOriginDto(PrpCexpenseOriginDto prpCexpenseOriginDto) {
        this.prpCexpenseOriginDto = prpCexpenseOriginDto;
    }
}

