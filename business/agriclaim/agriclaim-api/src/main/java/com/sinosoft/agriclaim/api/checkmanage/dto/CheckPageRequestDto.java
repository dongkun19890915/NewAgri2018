package com.sinosoft.agriclaim.api.checkmanage.dto;

import com.sinosoft.framework.dto.BaseRequest;

/**
 * @description: 类功能简述：查勘页面初始化参数接收类
 * @author 安齐崇
 * @date 2017年11月15日下午7:35:53
 */
public class CheckPageRequestDto extends BaseRequest {

	private static final long serialVersionUID = 1L;
	/* 报案号编辑类型是 ADD时必传 */
	private String registNo;
	/* 查看号编辑类型是EDIT,SHOW时必传 */
	private String checkNo;
	/* 编辑类型：ADD 新加初始化，EDIT编辑初始化 SHOW 查询初始化 */
	private String editType;
	/* 工作流编号 ADD 时必传,其它类型不传，下同 */
	private String flowId;
	/* 工作流序号 ADD 时必传 */
	private String logNo;
	/* 模板号 ADD,EDIT 传，下同 */
	private String modelNo;
	/* 节点号 */
	private String nodeNo;
	/* 报案状态 */
	private String status;
	public String getRegistNo() {
		return registNo;
	}
	public void setRegistNo(String registNo) {
		this.registNo = registNo;
	}
	public String getCheckNo() {
		return checkNo;
	}
	public void setCheckNo(String checkNo) {
		this.checkNo = checkNo;
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
