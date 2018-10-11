package com.sinosoft.agriclaim.api.prepaymanage.dto;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @description: 类功能简述：特殊赔案页面初始化接收入参的dto
 * @author 安齐崇
 * @date 2017年12月7日下午1:48:13
 *
 */
public class PrepayPageReqDto extends BaseRequest {
	
	private static final long serialVersionUID = 1L;
	/** 编辑类型,可以选择ADD,EDIT,SHOW*/
	private String editType;
	/** 立案号*/
	private String claimNo;
	/** 特殊赔案号*/
	private String prepayNo;
	/** 工作流号*/
	private String flowID;
	/** 工作流序号*/
	private String logNo;
	/** 模板号*/
	private String modelNo;
	/** 节点号*/
	private String nodeNo;
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
	public String getPrepayNo() {
		return prepayNo;
	}
	public void setPrepayNo(String prepayNo) {
		this.prepayNo = prepayNo;
	}
	public String getFlowID() {
		return flowID;
	}
	public void setFlowID(String flowID) {
		this.flowID = flowID;
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
}
