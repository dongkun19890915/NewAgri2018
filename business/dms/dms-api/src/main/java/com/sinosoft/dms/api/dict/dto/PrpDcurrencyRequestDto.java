package com.sinosoft.dms.api.dict.dto;
/**
* @Description: 币别查询请求参数的Dto
* @Author: 宋振振
* @Date: 10:58 2017/11/3
*/
public class PrpDcurrencyRequestDto {
    /**codeMethod：精确like或模糊eq*/
    private String codeMethod;
    /**codeClass：codeCode或codeName*/
    private String codeClass;
    /**codeValue:双击域的输入的值*/
    private String codeValue;

    public String getCodeMethod() {
        return codeMethod;
    }

    public void setCodeMethod(String codeMethod) {
        this.codeMethod = codeMethod;
    }

    public String getCodeClass() {
        return codeClass;
    }

    public void setCodeClass(String codeClass) {
        this.codeClass = codeClass;
    }

    public String getCodeValue() {
        return codeValue;
    }

    public void setCodeValue(String codeValue) {
        this.codeValue = codeValue;
    }
}
