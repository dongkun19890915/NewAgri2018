package com.sinosoft.agriclaim.api.prepaymanage.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;

/***（特殊赔案提交双核组装xml参数dto）
 * @Author: 王心洋
 * @Date: 2018/2/27
 */
public class PrepaySubmitUndwrtXMLDto  extends BaseRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    private String lFlowId;
    private int lLogNo;
    private String modelType;
    private String certiType;
    private String businessNo;
    private String riskCode;
    private String classCode;
    private String comCode;
    private String handlerCode;
    private String makecom;
    private String userCode;
    private String handler1Code;
    private String contractNo;
    private String flag;

    public String getlFlowId() {
        return lFlowId;
    }

    public void setlFlowId(String lFlowId) {
        this.lFlowId = lFlowId;
    }

    public int getlLogNo() {
        return lLogNo;
    }

    public void setlLogNo(int lLogNo) {
        this.lLogNo = lLogNo;
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

    public String getHandlerCode() {
        return handlerCode;
    }

    public void setHandlerCode(String handlerCode) {
        this.handlerCode = handlerCode;
    }

    public String getHandler1Code() {
        return handler1Code;
    }

    public void setHandler1Code(String handler1Code) {
        this.handler1Code = handler1Code;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}
