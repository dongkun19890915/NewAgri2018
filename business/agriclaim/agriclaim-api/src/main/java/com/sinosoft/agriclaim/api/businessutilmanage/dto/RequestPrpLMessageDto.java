package com.sinosoft.agriclaim.api.businessutilmanage.dto;

import java.util.Date;
/**
*（查看理赔沟通信息的请求Dto）
* @Author: 董坤
* @Date: 2017/11/15 19:55
*/
public class RequestPrpLMessageDto {
    private static final long serialVersionUID = 1L;
    /** 属性报案号码/报案号码 */
    private String registNo ;
    /** 属性立案号码/立案号码 */
    private String claimNo ;
    /** 属性保单号码/保单号码 */
    private String policyNo ;
    /** 属性险种代码/险种代码 */
    private String riskCode ;
    /** 属性节点种类/节点种类 */
    private String nodeType ;
    /** 属性节点种类/节点种类名称 */
    private String nodeTypeName ;
    /** 属性计算机输单日期/计算机输单日期 */
    private java.util.Date inputDate ;
    /** 属性操作员代码/操作员代码 */
    private String operatorCode ;
    /** 属性操作员名称/操作员名称 */
    private String operatorName ;

    public String getNodeTypeName() {
        return nodeTypeName;
    }

    public void setNodeTypeName(String nodeTypeName) {
        this.nodeTypeName = nodeTypeName;
    }

    public String getRegistNo() {
        return registNo;
    }

    public void setRegistNo(String registNo) {
        this.registNo = registNo;
    }

    public String getClaimNo() {
        return claimNo;
    }

    public void setClaimNo(String claimNo) {
        this.claimNo = claimNo;
    }

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }

    public String getRiskCode() {
        return riskCode;
    }

    public void setRiskCode(String riskCode) {
        this.riskCode = riskCode;
    }

    public String getNodeType() {
        return nodeType;
    }

    public void setNodeType(String nodeType) {
        this.nodeType = nodeType;
    }

    public Date getInputDate() {
        return inputDate;
    }

    public void setInputDate(Date inputDate) {
        this.inputDate = inputDate;
    }

    public String getOperatorCode() {
        return operatorCode;
    }

    public void setOperatorCode(String operatorCode) {
        this.operatorCode = operatorCode;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }
}
