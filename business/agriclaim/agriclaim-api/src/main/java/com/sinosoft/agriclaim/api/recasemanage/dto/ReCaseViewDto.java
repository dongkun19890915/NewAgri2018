package com.sinosoft.agriclaim.api.recasemanage.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;

/***（重开赔案接收前端数据,数据传输类）
* @Author: 王志文
* @Date: 2017/12/6 9:00
*/
public class ReCaseViewDto extends BaseRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    /** 报案号 */
    private String registNo;
    /** 保单号 */
    private String policyNo;
    /** 立案号 */
    private String claimNo;
    /** 险种名称 */
    private String riskCName;
    /** 被保险人 */
    private String insuredName;
    /** 流入时间 */
    private String flowInTime;
    /** 案件状态 */
    private String caseType;
    /** 处理人员 */
    private String handlerName;
    /** 节点状态 */
    private String nodeStatus;
    /** 当前节点名称 */
    private String nodeName;
    //查询计算书号和重开赔案原因
    /** 重开赔案次数 */
    private int serialNo;
    /** 赔款计算书号 */
    private String compensateNo;
    /** 重开赔案原因 */
    private String reCaseReason;
    /** 审核意见 */
    private String undwrtOpinion;

    private String endCaseDate;
    /** 无参构造 */
    public ReCaseViewDto(){}

    public ReCaseViewDto(String compensateNo,String reCaseReason){
        this.compensateNo = compensateNo;
        this.reCaseReason = reCaseReason;
    }

    public ReCaseViewDto(String registNo,String policyNo,String claimNo,String riskCName,String insuredName,
                         String flowInTime,String caseType,String handlerName,String nodeNo){
        this.registNo = registNo;
        this.policyNo = policyNo;
        this.claimNo = claimNo;
        this.riskCName = riskCName;
        this.insuredName = insuredName;
        this.flowInTime = flowInTime;
        this.caseType = caseType;
        this.handlerName = handlerName;
    }
    public ReCaseViewDto(String registNo,String policyNo,String claimNo,String riskCName,String insuredName,
                         String flowInTime,String caseType,String handlerName,String nodeStatus,String nodeName){
        this.registNo = registNo;
        this.policyNo = policyNo;
        this.claimNo = claimNo;
        this.riskCName = riskCName;
        this.insuredName = insuredName;
        this.flowInTime = flowInTime;
        this.caseType = caseType;
        this.handlerName = handlerName;
        this.nodeStatus = nodeStatus;
        this.nodeName = nodeName;
    }

    public String getEndCaseDate() {
        return endCaseDate;
    }

    public void setEndCaseDate(String endCaseDate) {
        this.endCaseDate = endCaseDate;
    }

    public String getRegistNo() {
        return registNo;
    }

    public void setRegistNo(String registNo) {
        this.registNo = registNo;
    }

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }

    public String getClaimNo() {
        return claimNo;
    }

    public void setClaimNo(String claimNo) {
        this.claimNo = claimNo;
    }

    public String getRiskCName() {
        return riskCName;
    }

    public void setRiskCName(String riskCName) {
        this.riskCName = riskCName;
    }

    public String getInsuredName() {
        return insuredName;
    }

    public void setInsuredName(String insuredName) {
        this.insuredName = insuredName;
    }

    public String getFlowInTime() {
        return flowInTime;
    }

    public void setFlowInTime(String flowInTime) {
        this.flowInTime = flowInTime;
    }

    public String getCaseType() {
        return caseType;
    }

    public void setCaseType(String caseType) {
        this.caseType = caseType;
    }

    public String getHandlerName() {
        return handlerName;
    }

    public void setHandlerName(String handlerName) {
        this.handlerName = handlerName;
    }

    public String getNodeStatus() {
        return nodeStatus;
    }

    public void setNodeStatus(String nodeStatus) {
        this.nodeStatus = nodeStatus;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public String getCompensateNo() {
        return compensateNo;
    }

    public void setCompensateNo(String compensateNo) {
        this.compensateNo = compensateNo;
    }

    public String getReCaseReason() {
        return reCaseReason;
    }

    public void setReCaseReason(String reCaseReason) {
        this.reCaseReason = reCaseReason;
    }

    public int getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(int serialNo) {
        this.serialNo = serialNo;
    }

    public String getUndwrtOpinion() {
        return undwrtOpinion;
    }

    public void setUndwrtOpinion(String undwrtOpinion) {
        this.undwrtOpinion = undwrtOpinion;
    }
}
