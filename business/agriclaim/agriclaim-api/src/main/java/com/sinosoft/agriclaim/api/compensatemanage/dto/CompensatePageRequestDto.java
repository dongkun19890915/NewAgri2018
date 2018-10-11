package com.sinosoft.agriclaim.api.compensatemanage.dto;

import com.sinosoft.framework.dto.BaseRequest;

/**
 * @description: 类功能简述：理算页面初始化入参dto
 * @author 安齐崇
 * @date 2017年11月30日下午4:55:07
 *
 */
public class CompensatePageRequestDto extends BaseRequest{
	
	private static final long serialVersionUID = 1L;
	/*编辑类型ADD,EDIT,SHOW*/
	private String editType;
	/*立案号*/
	private String claimNo;
	/*赔款计算书号*/
	private String compensateNo;
	/*特殊赔案标志，案件性质:0 已注销，1 已拒赔，2 已结案 空值表示未结案*/
	private String caseType;
	/*工作流程编号*/
	private String flowId;
	/*工作流程序号*/
	private String logNo;
	/*模板编号*/
	private String modelNo;
	/*节点编号*/
	private String nodeNo;
	/*理算节点状态*/
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
	public String getEditType() {
		return editType;
	}
	public void setEditType(String editType) {
		this.editType = editType;
	}
	public String getClaimNo() {
		return claimNo;
	}
	public void setClaimNo(String claimNo) {
		this.claimNo = claimNo;
	}
	public String getCompensateNo() {
		return compensateNo;
	}
	public void setCompensateNo(String compensateNo) {
		this.compensateNo = compensateNo;
	}
	public String getCaseType() {
		return caseType;
	}
	public void setCaseType(String caseType) {
		this.caseType = caseType;
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
	
  
}
