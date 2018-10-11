package com.sinosoft.agriprpall.api.endorsemanage.dto;

import com.sinosoft.framework.dto.BasePageableRequest;
import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;

public class RequestEndorseListDto extends BasePageableRequest implements Serializable{
    private static final long serialVersionUID = 1L;

    /** 批单号码 */
    private String endorseNo ;
    /** 属性险种代码/险种代码 */
    private String riskCode ;
    /** 保单号码 */
    private String policyNo ;
    /** 批改类型 */
    private String endorType ;
    /** 归属业务员代码 */
    private String handler1Code ;
    /** 操作员代码 */
    private String operatorCode ;
    /** 批改申请人 */
    private String appliName ;
    /** 归属机构代码 */
    private String comCode ;
    /** 批改日期起期 */
    private String endorDateStart ;
    /** 批改日期止期 */
    private String endorDateEnd ;
    /** 生效日期起期 */
    private String validDateStart ;
    /** 生效日期止期 */
    private String validDateEnd ;
    /** 核批标志 */
    private String underwriteFlag ;
    /** 中央政策性/地方政策性/商业性标志 */
    private String businessType1 ;
    /** 属性扶贫险种标志*/
    private String hpFlag;
    /*出单机构*/
    private String MakeCom;
    /** 被保险人名称 */
    private String insuredName ;

    /*用户代码*/
    private String userCode;
    /*用户登录机构代码*/
    private String loginComCode;
    /*用户登录岗位代码*/
    private String loginGradeCodes;
    /*表名*/
    private String tableName;
    /*userCode字段*/
    private String userCodeFields;
    /*comCode字段*/
    private String comCodeFields;

    public String getMakeCom() {
        return MakeCom;
    }

    public void setMakeCom(String makeCom) {
        MakeCom = makeCom;
    }

    public String getInsuredName() {
        return insuredName;
    }

    public void setInsuredName(String insuredName) {
        this.insuredName = insuredName;
    }

    public String getEndorseNo() {
        return endorseNo;
    }

    public void setEndorseNo(String endorseNo) {
        this.endorseNo = endorseNo;
    }

    public String getRiskCode() {
        return riskCode;
    }

    public void setRiskCode(String riskCode) {
        this.riskCode = riskCode;
    }

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }

    public String getEndorType() {
        return endorType;
    }

    public void setEndorType(String endorType) {
        this.endorType = endorType;
    }

    public String getHandler1Code() {
        return handler1Code;
    }

    public void setHandler1Code(String handler1Code) {
        this.handler1Code = handler1Code;
    }

    public String getOperatorCode() {
        return operatorCode;
    }

    public void setOperatorCode(String operatorCode) {
        this.operatorCode = operatorCode;
    }

    public String getAppliName() {
        return appliName;
    }

    public void setAppliName(String appliName) {
        this.appliName = appliName;
    }

    public String getComCode() {
        return comCode;
    }

    public void setComCode(String comCode) {
        this.comCode = comCode;
    }

    public String getEndorDateStart() {
        return endorDateStart;
    }

    public void setEndorDateStart(String endorDateStart) {
        this.endorDateStart = endorDateStart;
    }

    public String getEndorDateEnd() {
        return endorDateEnd;
    }

    public void setEndorDateEnd(String endorDateEnd) {
        this.endorDateEnd = endorDateEnd;
    }

    public String getValidDateStart() {
        return validDateStart;
    }

    public void setValidDateStart(String validDateStart) {
        this.validDateStart = validDateStart;
    }

    public String getValidDateEnd() {
        return validDateEnd;
    }

    public void setValidDateEnd(String validDateEnd) {
        this.validDateEnd = validDateEnd;
    }

    public String getUnderwriteFlag() {
        return underwriteFlag;
    }

    public void setUnderwriteFlag(String underwriteFlag) {
        this.underwriteFlag = underwriteFlag;
    }

    public String getBusinessType1() {
        return businessType1;
    }

    public void setBusinessType1(String businessType1) {
        this.businessType1 = businessType1;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getLoginComCode() {
        return loginComCode;
    }

    public void setLoginComCode(String loginComCode) {
        this.loginComCode = loginComCode;
    }

    public String getLoginGradeCodes() {
        return loginGradeCodes;
    }

    public void setLoginGradeCodes(String loginGradeCodes) {
        this.loginGradeCodes = loginGradeCodes;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getUserCodeFields() {
        return userCodeFields;
    }

    public void setUserCodeFields(String userCodeFields) {
        this.userCodeFields = userCodeFields;
    }

    public String getComCodeFields() {
        return comCodeFields;
    }

    public void setComCodeFields(String comCodeFields) {
        this.comCodeFields = comCodeFields;
    }

    public String getHpFlag() {
        return hpFlag;
    }

    public void setHpFlag(String hpFlag) {
        this.hpFlag = hpFlag;
    }
}
