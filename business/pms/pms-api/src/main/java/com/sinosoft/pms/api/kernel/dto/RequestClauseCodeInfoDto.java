package com.sinosoft.pms.api.kernel.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;
import java.util.List;

public class RequestClauseCodeInfoDto extends BaseRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    /*条款配置主表Dto*/
    private PrpDclauseCodeDto prpDclauseCodeDto;
    /*条款机构配置表Dto*/
    private List<PrpDclauseCodeComDto> prpDclauseCodeComDtoList;
    /*条款险别配置表Dto*/
    private List<PrpDclauseCodeKindDto> prpDclauseCodeKindDtoList;
    /*条款与保险责任关系表*/
    private List<PrpDrelationClauseCodeDto> prpDrelationClauseCodeDtoList;
    /*1-主险，2-附加险*/
    private List<String> insuranceList;
//    /*是否计入保额（Y/N）*/
//    private List<String> isFlagList;
//    /* 标的名称*/
//    private List<String> itemName;

//    public List<String> getItemName() {
//        return itemName;
//    }
//
//    public void setItemName(List<String> itemName) {
//        this.itemName = itemName;
//    }

    public List<String> getInsuranceList() {
        return insuranceList;
    }

    public void setInsuranceList(List<String> insuranceList) {
        this.insuranceList = insuranceList;
    }

//    public List<String> getIsFlagList() {
//        return isFlagList;
//    }
//
//    public void setIsFlagList(List<String> isFlagList) {
//        this.isFlagList = isFlagList;
//    }

    public PrpDclauseCodeDto getPrpDclauseCodeDto() {
        return prpDclauseCodeDto;
    }

    public void setPrpDclauseCodeDto(PrpDclauseCodeDto prpDclauseCodeDto) {
        this.prpDclauseCodeDto = prpDclauseCodeDto;
    }

    public List<PrpDclauseCodeComDto> getPrpDclauseCodeComDtoList() {
        return prpDclauseCodeComDtoList;
    }

    public void setPrpDclauseCodeComDtoList(List<PrpDclauseCodeComDto> prpDclauseCodeComDtoList) {
        this.prpDclauseCodeComDtoList = prpDclauseCodeComDtoList;
    }

    public List<PrpDclauseCodeKindDto> getPrpDclauseCodeKindDtoList() {
        return prpDclauseCodeKindDtoList;
    }

    public void setPrpDclauseCodeKindDtoList(List<PrpDclauseCodeKindDto> prpDclauseCodeKindDtoList) {
        this.prpDclauseCodeKindDtoList = prpDclauseCodeKindDtoList;
    }

    public List<PrpDrelationClauseCodeDto> getPrpDrelationClauseCodeDtoList() {
        return prpDrelationClauseCodeDtoList;
    }

    public void setPrpDrelationClauseCodeDtoList(List<PrpDrelationClauseCodeDto> prpDrelationClauseCodeDtoList) {
        this.prpDrelationClauseCodeDtoList = prpDrelationClauseCodeDtoList;
    }
}
