package com.sinosoft.agriclaim.api.compensatemanage.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;

/***（理算书提交双核组装xml参数dto）
* @Author: 王志文
* @Date: 2018/1/15 15:57
*/
public class CompensateSubmitUndwrtXMLDto  extends BaseRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    private String lFlowID;
    private String lLogNo;
    /** 属性模板类型/模板类型 */
    private String modelType;
    /** 属性业务类型/业务类型 */
    private String certiType;
    /** 属性业务号（）赔款计算书号码/业务号（）赔款计算书号码 */
    private String businessNo;
    /** 属性险种类型/险种类型 */
    private String riskCode;
    /** 属性险类代码/险类代码 */
    private String classCode;
    /** 属性归属机构/归属机构 */
    private String comCode;
    /** 属性出单机构/出单机构 */
    private String makecom;
    /** 属性处理人员代码/处理人员代码 */
    private String userCode;
    /** 属性经办人代码/经办人代码 */
    private String handlerCode;
    /** 属性归属业务员代码/归属业务员代码 */
    private String handler1Code;
    /** 属性合同号（）/合同号（） */
    private String contractNo;
    /** 属性报案号/报案号 */
    private String registNo;
    /** 属性备用标识字段/备用标识字段 */
    private String flag;
    /** 属性证件类型/证件类型 */
    private String IdentifyType;
    /** 属性证件号码/证件号码 */
    private String IdentifyNumber;
    /** 属性立案号码/立案号码 */
    private String ClaimNo;
    /** 属性被保人代码/被保人代码 */
    private String InsuredCode;
    /** 属性被保人名称/被保人名称 */
    private String InsuredName;
    /** 属性保单名称/保单名称 */
    private String PolicyNo;
    /** 属性主保单号/主保单号 */
    private String MainPolicyNo;
    /** 系统标识 */
    private String systemCode;

    public String getlFlowID() {
        return lFlowID;
    }

    public void setlFlowID(String lFlowID) {
        this.lFlowID = lFlowID;
    }

    public String getlLogNo() {
        return lLogNo;
    }

    public void setlLogNo(String lLogNo) {
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

    public String getRegistNo() {
        return registNo;
    }

    public void setRegistNo(String registNo) {
        this.registNo = registNo;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getIdentifyType() {
        return IdentifyType;
    }

    public void setIdentifyType(String identifyType) {
        IdentifyType = identifyType;
    }

    public String getIdentifyNumber() {
        return IdentifyNumber;
    }

    public void setIdentifyNumber(String identifyNumber) {
        IdentifyNumber = identifyNumber;
    }

    public String getClaimNo() {
        return ClaimNo;
    }

    public void setClaimNo(String claimNo) {
        ClaimNo = claimNo;
    }

    public String getInsuredCode() {
        return InsuredCode;
    }

    public void setInsuredCode(String insuredCode) {
        InsuredCode = insuredCode;
    }

    public String getInsuredName() {
        return InsuredName;
    }

    public void setInsuredName(String insuredName) {
        InsuredName = insuredName;
    }

    public String getPolicyNo() {
        return PolicyNo;
    }

    public void setPolicyNo(String policyNo) {
        PolicyNo = policyNo;
    }

    public String getMainPolicyNo() {
        return MainPolicyNo;
    }

    public String getSystemCode() {
        return systemCode;
    }

    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }

    public void setMainPolicyNo(String mainPolicyNo) {
        MainPolicyNo = mainPolicyNo;
    }
    public CompensateSubmitUndwrtXMLDto(){}
    public CompensateSubmitUndwrtXMLDto(String lFlowID, String lLogNo, String modelType, String certiType, String businessNo,
                                  String riskCode, String classCode, String comCode, String makecom, String userCode, String handlerCode,
                                  String handler1Code, String contractNo, String registNo, String flag, String identifyType,
                                  String identifyNumber, String claimNo, String insuredCode, String insuredName, String policyNo,
                                  String mainPolicyNo,String systemCode) {
        super();
        this.lFlowID = lFlowID;
        this.lLogNo = lLogNo;
        this.modelType = modelType;
        this.certiType = certiType;
        this.businessNo = businessNo;
        this.riskCode = riskCode;
        this.classCode = classCode;
        this.comCode = comCode;
        this.makecom = makecom;
        this.userCode = userCode;
        this.handlerCode = handlerCode;
        this.handler1Code = handler1Code;
        this.contractNo = contractNo;
        this.registNo = registNo;
        this.flag = flag;
        IdentifyType = identifyType;
        IdentifyNumber = identifyNumber;
        ClaimNo = claimNo;
        InsuredCode = insuredCode;
        InsuredName = insuredName;
        PolicyNo = policyNo;
        MainPolicyNo = mainPolicyNo;
        this.systemCode = systemCode;
    }
}
