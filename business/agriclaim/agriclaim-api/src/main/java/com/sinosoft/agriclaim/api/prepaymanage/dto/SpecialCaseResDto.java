package com.sinosoft.agriclaim.api.prepaymanage.dto;
import java.util.List;

import com.sinosoft.agriclaim.api.claimmanage.dto.PrpLClaimDto;
import com.sinosoft.agriclaim.api.workflowmanage.dto.SwfLogDto;
public class SpecialCaseResDto {
	/*险种编码*/
	private String riskCode;
	/*工作流id*/
	private String flowId;
	/*工作流编号*/
	private String logNo;
	/*用户编码*/
	private String userCode;
	/*用户名*/
	private String userName;
	/*机构编码*/
	private String comCode;
	/*节点类型*/
	private String nodeType;
	/*立案号*/
	private String businessNo;
	/*流入时间*/
	private String flowInTime;
	/*保单号*/
	private String policyNo;
	/*报案号*/
	private String registNo;
	/*节点状态*/
	private String nodeStatus;
	
	public String getNodeStatus() {
		return nodeStatus;
	}
	public void setNodeStatus(String nodeStatus) {
		this.nodeStatus = nodeStatus;
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
	public String getFlowInTime() {
		return flowInTime;
	}
	public void setFlowInTime(String flowInTime) {
		this.flowInTime = flowInTime;
	}
	private List<PrpLClaimDto> prpLClaimDtoList;
	private List<SwfLogDto> swfLogDtoList;
	
	public List<SwfLogDto> getSwfLogDtoList() {
		return swfLogDtoList;
	}
	public void setSwfLogDtoList(List<SwfLogDto> swfLogDtoList) {
		this.swfLogDtoList = swfLogDtoList;
	}
	public List<PrpLClaimDto> getPrpLClaimDtoList() {
		return prpLClaimDtoList;
	}
	public void setPrpLClaimDtoList(List<PrpLClaimDto> prpLClaimDtoList) {
		this.prpLClaimDtoList = prpLClaimDtoList;
	}
	public String getBusinessNo() {
		return businessNo;
	}
	public void setBusinessNo(String businessNo) {
		this.businessNo = businessNo;
	}
	public String getNodeType() {
		return nodeType;
	}
	public void setNodeType(String nodeType) {
		this.nodeType = nodeType;
	}
	public String getRiskCode() {
		return riskCode;
	}
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}
	
	public String getFlowId() {
		return flowId;
	}
	public void setFlowId(String flowId) {
		this.flowId = flowId;
	}
	public String getLogNo() {
		return logNo;
	}
	public void setLogNo(String logNo) {
		this.logNo = logNo;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getComCode() {
		return comCode;
	}
	public void setComCode(String comCode) {
		this.comCode = comCode;
	}
}
