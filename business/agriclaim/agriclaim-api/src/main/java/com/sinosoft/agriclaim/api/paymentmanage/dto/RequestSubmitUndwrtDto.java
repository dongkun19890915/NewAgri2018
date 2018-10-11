package com.sinosoft.agriclaim.api.paymentmanage.dto;

import java.io.Serializable;
/**
 * 支付录入提交至双核审核dto
 * @Author: 孙朋飞
 * @Date: 2018/1/12 16:40
 */
public class RequestSubmitUndwrtDto implements Serializable {
    private String lflowID;//理赔工作流号码
    private String llogNo;//理赔工作流节点号码
    private String modelType;//模板类型 11:核保模板/22:核赔模板
    private String certiType;//业务类型 T/P/E/C/Y
    private String businessNo;//业务号
    private String riskCode;//险种代码
    private String classCode;//险类代码
    private String comCode;//业务归属
    private String handlerCode;//经办人代码
    private String makecom;//出单部门
    private String userCode;//系统操作人员
    private String handler1Code;//业务归属人代码

    public String getLflowID() {
        return lflowID;
    }

    public void setLflowID(String lflowID) {
        this.lflowID = lflowID;
    }

    public String getLlogNo() {
        return llogNo;
    }

    public void setLlogNo(String llogNo) {
        this.llogNo = llogNo;
    }

    public String getModelType() {
        return modelType;
    }

    public void setModelType(String modelType) {
        this.modelType = modelType;
    }

    public String getCertiType() {
        return certiType;
    }

    public void setCertiType(String certiType) {
        this.certiType = certiType;
    }

    public String getBusinessNo() {
        return businessNo;
    }

    public void setBusinessNo(String businessNo) {
        this.businessNo = businessNo;
    }

    public String getRiskCode() {
        return riskCode;
    }

    public void setRiskCode(String riskCode) {
        this.riskCode = riskCode;
    }

    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }

    public String getComCode() {
        return comCode;
    }

    public void setComCode(String comCode) {
        this.comCode = comCode;
    }

    public String getHandlerCode() {
        return handlerCode;
    }

    public void setHandlerCode(String handlerCode) {
        this.handlerCode = handlerCode;
    }

    public String getMakecom() {
        return makecom;
    }

    public void setMakecom(String makecom) {
        this.makecom = makecom;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getHandler1Code() {
        return handler1Code;
    }

    public void setHandler1Code(String handler1Code) {
        this.handler1Code = handler1Code;
    }
}
