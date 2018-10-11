package com.sinosoft.agriclaim.api.combinemanage.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;

public class ComClaimQueryOutDto extends BaseRequest implements Serializable{
	private static final long SerialVersionUID = 1L;
	
	/** 报案号 */
	private String registNo;
	/** 保单号码*/
	private String policyNo;
	/** 险种 */
	private String riskCode;
	/** 被保险人 */
	private String insuredName;
	/** 出险标的代码 */
	private String lossCode;
	/** 出险标的 名称*/
	private String lossName;
	/** 流入时间 */
	private String flowInTime;
	/** 案件状态 */
	private String nodeStatus;
	/** 处理人员代码 */
	private String handlerCode;
	/** 处理人员 名称*/
	private String handlerName;
	/** 流程编号*/
	private String swfLogFlowID;
	/** 序号*/
	private String swfLogLogNo;
	/** 并案号*/
	private String combineNo;
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
	public String getRiskCode() {
		return riskCode;
	}
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}
	public String getInsuredName() {
		return insuredName;
	}
	public void setInsuredName(String insuredName) {
		this.insuredName = insuredName;
	}
	public String getLossCode() {
		return lossCode;
	}
	public void setLossCode(String lossCode) {
		this.lossCode = lossCode;
	}
	public String getLossName() {
		return lossName;
	}
	public void setLossName(String lossName) {
		this.lossName = lossName;
	}
	public String getFlowInTime() {
		return flowInTime;
	}
	public void setFlowInTime(String flowInTime) {
		this.flowInTime = flowInTime;
	}
	public String getNodeStatus() {
		return nodeStatus;
	}
	public void setNodeStatus(String nodeStatus) {
		this.nodeStatus = nodeStatus;
	}
	public String getHandlerCode() {
		return handlerCode;
	}
	public void setHandlerCode(String handlerCode) {
		this.handlerCode = handlerCode;
	}
	public String getHandlerName() {
		return handlerName;
	}
	public void setHandlerName(String handlerName) {
		this.handlerName = handlerName;
	}
	public String getCombineNo() {
		return combineNo;
	}
	public void setCombineNo(String combineNo) {
		this.combineNo = combineNo;
	}
	public String getSwfLogFlowID() {
		return swfLogFlowID;
	}
	public void setSwfLogFlowID(String swfLogFlowID) {
		this.swfLogFlowID = swfLogFlowID;
	}
	public String getSwfLogLogNo() {
		return swfLogLogNo;
	}
	public void setSwfLogLogNo(String swfLogLogNo) {
		this.swfLogLogNo = swfLogLogNo;
	}
	
}
