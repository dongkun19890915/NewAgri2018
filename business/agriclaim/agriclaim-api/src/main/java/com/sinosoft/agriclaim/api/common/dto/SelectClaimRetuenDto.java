package com.sinosoft.agriclaim.api.common.dto;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/**
 * 公共区域返参
 * @Author: 孙朋飞
 * @Date: 2018/1/18 15:40
 */
public class SelectClaimRetuenDto implements Serializable{
    private String codeType;
    private List<SelectClaimCodeDto> codeData = new ArrayList<>();

    public String getCodeType() {
        return codeType;
    }

    public void setCodeType(String codeType) {
        this.codeType = codeType;
    }

    public List<SelectClaimCodeDto> getCodeData() {
        return codeData;
    }

    public void setCodeData(List<SelectClaimCodeDto> codeData) {
        this.codeData = codeData;
    }
}
