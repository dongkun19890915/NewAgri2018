package com.sinosoft.agriclaim.api.prepaymanage.dto;
/**
 * @description: 类功能简述：申请特殊赔案入参dto
 * @author 安齐崇
 * @date 2017年12月16日下午6:15:01
 *
 */
public class SpecialCaseReqDto {
	/*险种编码*/
	private String riskCode;
	/*立案号*/
	private String businessNo;
	/*编辑类型*/
	private String editType;
	/*工作流id*/
	private String flowId;
	/*工作流编号*/
	private String logNo;
	/*节点类型*/
	private String nodeType;
	/*节点状态*/
	private String nodeStatus;
	
	public String getNodeStatus() {
		return nodeStatus;
	}
	public void setNodeStatus(String nodeStatus) {
		this.nodeStatus = nodeStatus;
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
	public String getEditType() {
		return editType;
	}
	public void setEditType(String editType) {
		this.editType = editType;
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
	
   
}
