package com.sinosoft.agriclaim.api.claimmanage.dto;
/**
 * @description: 类功能简述：立案页面初始化参数接收对象
 * @author 安齐崇
 * @date 2017年11月21日下午2:41:11
 */
public class ClaimPageInitReqDto {
	/*报案登记页面初始化编辑类型ADD,新增，EDIT编辑，SHOW展示*/
	private String editType;
	/*报案号*/
	private String registNo;
	/*赔案号*/
	private String claimNo;
	/*工作流程编号*/
	private String flowId;
	/*工作流程序号*/
	private String logNo;
	/*模板编号*/
	private String modelNo;
	/*节点编号*/
	private String nodeNo;
	/*立案状态*/
	private String status;
	
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
	public String getModelNo() {
		return modelNo;
	}
	public void setModelNo(String modelNo) {
		this.modelNo = modelNo;
	}
	public String getNodeNo() {
		return nodeNo;
	}
	public void setNodeNo(String nodeNo) {
		this.nodeNo = nodeNo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getEditType() {
		return editType;
	}
	public void setEditType(String editType) {
		this.editType = editType;
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
	
}
