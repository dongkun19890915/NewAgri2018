package com.sinosoft.dms.api.dict.dto;

import java.util.List;

/** 单个codeType返回对象 或请求对象
* @Author: 田健
* @Date: 2017/11/20 20:34
*/
public class PrpDcodeListDto {
    /** prpDcode集合*/
    private List<PrpDcodeDto> prpDcodeDtoList;
    /** 代码类型*/
    private String codeType;
    /**险种代码 */
    private String riskCode;
    /**贫困标识 */
    private int hpFlag;

    public List<PrpDcodeDto> getPrpDcodeDtoList() {
        return prpDcodeDtoList;
    }

    public void setPrpDcodeDtoList(List<PrpDcodeDto> prpDcodeDtoList) {
        this.prpDcodeDtoList = prpDcodeDtoList;
    }

    public String getCodeType() {
        return codeType;
    }


    public void setCodeType(String codeType) {
        this.codeType = codeType;
    }

    public String getRiskCode() {
        return riskCode;
    }

    public void setRiskCode(String riskCode) {
        this.riskCode = riskCode;
    }

    public int getHpFlag() {        return hpFlag;    }

    public void setHpFlag(int hpFlag) {        this.hpFlag = hpFlag;    }
}
