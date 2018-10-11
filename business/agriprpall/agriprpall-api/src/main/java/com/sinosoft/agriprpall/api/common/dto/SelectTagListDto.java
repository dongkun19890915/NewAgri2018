package com.sinosoft.agriprpall.api.common.dto;

import java.io.Serializable;

/**公共封装请求参数DTO，查询时会根据codeType的不同查询不同的信息，如codeType=“ComCode”是查询归属机构
* @Author: 田健
* @Date: 2017/12/12 10:45
*/
public class SelectTagListDto implements Serializable {
    /** 业务类型*/
    private String codeType ;
    /**英文代码 */
    private String codeCode ;
    /**机构中文名*/
    private String codeCName;
    /**当前险种*/
    private String riskCode ;
    /**用户输入机构代码*/
    private String comCode;
    /**用户代码*/
    private String userCode;
    /**上级代码*/
    private String upperCode;
   /**查询代码还是名称*/
    private String methodCode;
    /**备用字段1，可以复用*/
    private String reserve1;
    /** 备用字段2，可以复用*/
    private String reserve2;
    /** 备用字段3，可以复用*/
    private String reserve3;


    public String getCodeType() {
        return codeType;
    }

    public void setCodeType(String codeType) {
        this.codeType = codeType;
    }

    public String getCodeCode() {
        return codeCode;
    }

    public void setCodeCode(String codeCode) {
        this.codeCode = codeCode;
    }

    public String getUpperCode() {
        return upperCode;
    }

    public void setUpperCode(String upperCode) {
        this.upperCode = upperCode;
    }

    public String getRiskCode() {
        return riskCode;
    }

    public void setRiskCode(String riskCode) {
        this.riskCode = riskCode;
    }

    public String getCodeCName() {
        return codeCName;
    }

    public void setCodeCName(String codeCName) {
        this.codeCName = codeCName;
    }

    public String getComCode() {
        return comCode;
    }

    public void setComCode(String comCode) {
        this.comCode = comCode;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getMethodCode() {
        return methodCode;
    }

    public void setMethodCode(String methodCode) {
        this.methodCode = methodCode;
    }

    public String getReserve1() {
        return reserve1;
    }

    public void setReserve1(String reserve1) {
        this.reserve1 = reserve1;
    }

    public String getReserve2() {
        return reserve2;
    }

    public void setReserve2(String reserve2) {
        this.reserve2 = reserve2;
    }

    public String getReserve3() {
        return reserve3;
    }

    public void setReserve3(String reserve3) {
        this.reserve3 = reserve3;
    }
}
