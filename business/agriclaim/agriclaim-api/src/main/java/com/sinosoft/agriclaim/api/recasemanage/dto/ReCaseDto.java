package com.sinosoft.agriclaim.api.recasemanage.dto;

import com.sinosoft.framework.dto.BasePageableRequest;
import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;

/**@description 重开赔案接收前端数据,数据传输类
* @Author: 王志文
* @Date: 2017/11/6 14:10
*/
public class ReCaseDto extends BasePageableRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    /** 保单号 */
    private String policyNo;
    /** 报案号 */
    private String registNo;
    /** 立案号 */
    private String claimNo;
    /** 被保险人名称 */
    private String insuredName;
    /** 案件状态 审核通过: 1; 审核回退: 3; 待审核: 9; 放弃重开: 6  */
    private String undwrtFlag;
    /** 流入时间下限  flowInTime为流入时间 */
    private String flowInTimeDown;
    /** 流入时间上限 */
    private String flowInTimeUp;
    /** 险种大类 */
    private String riskClaimType;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
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

    public String getInsuredName() {
        return insuredName;
    }

    public void setInsuredName(String insuredName) {
        this.insuredName = insuredName;
    }

    public String getUndwrtFlag() {
        return undwrtFlag;
    }

    public void setUndwrtFlag(String undwrtFlag) {
        this.undwrtFlag = undwrtFlag;
    }

    public String getFlowInTimeDown() {
        return flowInTimeDown;
    }

    public void setFlowInTimeDown(String flowInTimeDown) {
        this.flowInTimeDown = flowInTimeDown;
    }

    public String getFlowInTimeUp() {
        return flowInTimeUp;
    }

    public void setFlowInTimeUp(String flowInTimeup) {
        this.flowInTimeUp = flowInTimeup;
    }

    public String getRiskClaimType() {
        return riskClaimType;
    }

    public void setRiskClaimType(String riskClaimType) {
        this.riskClaimType = riskClaimType;
    }

}
