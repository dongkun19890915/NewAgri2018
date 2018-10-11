package com.sinosoft.agriclaim.api.claimmanage.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
import com.sinosoft.ims.api.kernel.dto.UserDto;
/**
 * @description 申请注销／拒赔提交对象
 * @author 马俊玲
 * @Date 2017/11/6 14:08 
 */
public class ClaimCancleSubmitDto extends BaseRequest implements Serializable {

    private static final long serialVersionUID = 1L;
    //业务号（立案号）
    private String businessNo;
    //工作流ID
    private String swfLogFlowID;
    //工作流LogNo
    private int swfLogLogNo;
    // 注销／拒赔类型 0
    private String submitType;
    // 注销／拒赔说明
    private String prpLclaimContext;
    // 注销原因
    private String prpCancel;
    //0:不属于保险责任
    private String prpExclusions;
    // 编辑类型 ADD
    private String editType;
    // 赔案号
    private String prpLclaimCancelClaimNo;
    // 报案号
    private String registNo;
    // 节点类型
    private String nodeType;
    // 申请类型
    private String caseType;
    //状态
    private String status;
    //防止重复提交字段
    private long lastAccessedTime;
    //防止重复提交字段
    private long oldCancelAccessedTime;
    //注销／拒赔原因代码
    private String cancelReason;
    //注销／拒赔原因名称
    private String cancelReasonName;
    //立案对象
    private PrpLClaimDto prpLclaimDto;
    
    public String getBusinessNo() {
        return businessNo;
    }
    public void setBusinessNo(String businessNo) {
        this.businessNo = businessNo;
    }
    public String getSwfLogFlowID() {
        return swfLogFlowID;
    }
    public void setSwfLogFlowID(String swfLogFlowID) {
        this.swfLogFlowID = swfLogFlowID;
    }
    public int getSwfLogLogNo() {
        return swfLogLogNo;
    }
    public void setSwfLogLogNo(int swfLogLogNo) {
        this.swfLogLogNo = swfLogLogNo;
    }
    public String getSubmitType() {
        return submitType;
    }
    public void setSubmitType(String submitType) {
        this.submitType = submitType;
    }
    public String getPrpLclaimContext() {
        return prpLclaimContext;
    }
    public void setPrpLclaimContext(String prpLclaimContext) {
        this.prpLclaimContext = prpLclaimContext;
    }
    public String getPrpCancel() {
        return prpCancel;
    }
    public void setPrpCancel(String prpCancel) {
        this.prpCancel = prpCancel;
    }
    public String getPrpExclusions() {
        return prpExclusions;
    }
    public void setPrpExclusions(String prpExclusions) {
        this.prpExclusions = prpExclusions;
    }
    public String getEditType() {
        return editType;
    }
    public void setEditType(String editType) {
        this.editType = editType;
    }
    public String getPrpLclaimCancelClaimNo() {
        return prpLclaimCancelClaimNo;
    }
    public void setPrpLclaimCancelClaimNo(String prpLclaimCancelClaimNo) {
        this.prpLclaimCancelClaimNo = prpLclaimCancelClaimNo;
    }
    public String getRegistNo() {
        return registNo;
    }
    public void setRegistNo(String registNo) {
        this.registNo = registNo;
    }
    public String getNodeType() {
        return nodeType;
    }
    public void setNodeType(String nodeType) {
        this.nodeType = nodeType;
    }
    public String getCaseType() {
        return caseType;
    }
    public void setCaseType(String caseType) {
        this.caseType = caseType;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public long getLastAccessedTime() {
        return lastAccessedTime;
    }
    public void setLastAccessedTime(long lastAccessedTime) {
       this. lastAccessedTime = lastAccessedTime;
    }
    public long getOldCancelAccessedTime() {
        return oldCancelAccessedTime;
    }
    public void setOldCancelAccessedTime(long oldCancelAccessedTime) {
        this.oldCancelAccessedTime = oldCancelAccessedTime;
    }
    public String getCancelReason() {
        return cancelReason;
    }
    public void setCancelReason(String cancelReason) {
        this.cancelReason = cancelReason;
    }
    public String getCancelReasonName() {
        return cancelReasonName;
    }
    public void setCancelReasonName(String cancelReasonName) {
        this.cancelReasonName = cancelReasonName;
    }
    public PrpLClaimDto getPrpLclaimDto() {
        return prpLclaimDto;
    }
    public void setPrpLclaimDto(PrpLClaimDto prpLclaimDto) {
        this.prpLclaimDto = prpLclaimDto;
    }
    
   
}
