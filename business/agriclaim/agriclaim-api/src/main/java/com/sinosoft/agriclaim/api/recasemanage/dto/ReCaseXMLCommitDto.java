package com.sinosoft.agriclaim.api.recasemanage.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;

/***
 *  @description  重开赔案提交双核系统传输数据Dto
* @Author: 王志文
* @Date: 2017/11/7 9:27
*/
public class ReCaseXMLCommitDto extends BaseRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    private String lFlowID;
    private Integer lLogNo;
    /** 属性modelType */
    private String modelType;
    /** 属性单号类型 */
    private String certiType;
    /** 属性业务号 */
    private String businessNo;
    /** 属性险种代码 */
    private String riskCode;
    /** 属性险类 */
    private String classCode;
    /** 属性公司代码 */
    private String comCode;
    /** 出单机构 */
    private String makeCom;
    /** 用户代码 */
    private String userCode;
    /** 处理人代码 */
    private String handlerCode;
    /** 处理人1代码 */
    private String handler1Code;
    /** 合同号 */
    private String contractNo;

    public String getlFlowID() {
        return lFlowID;
    }

    public void setlFlowID(String lFlowID) {
        this.lFlowID = lFlowID;
    }

    public Integer getlLogNo() {
        return lLogNo;
    }

    public void setlLogNo(Integer lLogNo) {
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
        return makeCom;
    }

    public void setMakecom(String makeCom) {
        this.makeCom = makeCom;
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
}
