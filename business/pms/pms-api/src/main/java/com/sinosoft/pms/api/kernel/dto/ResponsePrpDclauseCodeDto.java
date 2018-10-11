package com.sinosoft.pms.api.kernel.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;
import java.util.Date;

public class ResponsePrpDclauseCodeDto extends BaseRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    /** 属性条款代码/条款代码 */
    private String clauseCode ;
    /** 属性条款名称/条款名称 */
    private String clauseName ;
    /** 属性操作人/操作人 */
    private String operatorName ;
    /** 属性创建日期/创建日期 */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private java.util.Date createDate ;
    /** 属性条款状态/条款状态 */
    private String validStatus ;
    /**年份*/
    private String createYear;
    /** 属性备注/备注 */
    private String remark ;
    /** 属性险种代码/险种代码 */
    private String riskCode ;
    /** 属性有效起期/有效起期 */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private java.util.Date startDate ;
    /** 属性有效止期/有效止期 */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private java.util.Date endDate ;
    /** 属性政策性标识/政策性标识 */
    private String businessType ;

    /**有效状态0-无效，1-有效*/
    private String validStatus1;

    /**保存状态0-暂存，1-保存*/
    private String flag;

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getValidStatus1() {
        return validStatus1;
    }

    public void setValidStatus1(String validStatus1) {
        this.validStatus1 = validStatus1;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public String getCreateYear() {
        return createYear;
    }

    public void setCreateYear(String createYear) {
        this.createYear = createYear;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRiskCode() {
        return riskCode;
    }

    public void setRiskCode(String riskCode) {
        this.riskCode = riskCode;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getClauseCode() {
        return clauseCode;
    }

    public void setClauseCode(String clauseCode) {
        this.clauseCode = clauseCode;
    }

    public String getClauseName() {
        return clauseName;
    }

    public void setClauseName(String clauseName) {
        this.clauseName = clauseName;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getValidStatus() {
        return validStatus;
    }

    public void setValidStatus(String validStatus) {
        this.validStatus = validStatus;
    }

    public Date getCreateDate() {

        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
