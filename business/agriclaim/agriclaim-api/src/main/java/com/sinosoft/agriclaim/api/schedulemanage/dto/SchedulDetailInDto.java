package com.sinosoft.agriclaim.api.schedulemanage.dto;

/**
 * @description 调度初始化入参对象
 * @author 马俊玲
 * @date 2017年10月19日 下午3:55:50
 */
public class SchedulDetailInDto {
	
	//工作流编号
	private String swfLogFlowID;
	//工作流logNo
	private String swfLogLogNo;
    //编辑类型
	private String editType;
	//险种代码
	private String riskCode;
	//报案号
	private String registNo;
	//调度Id
	private Integer scheduleID;
	//保单号
	private String policyNo;
	//节点类型
	private String nodeType;
	//模板号
	private String modelNo;
	//节点号
	private String nodeNo;
	//提交标识
	private String commiFlag;
	//、调度标识
	private String schedFlag;
	public String getEditType() {
		return editType;
	}
	public void setEditType(String editType) {
		this.editType = editType;
	}
	public String getRiskCode() {
		return riskCode;
	}
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}
	public String getRegistNo() {
		return registNo;
	}
	public void setRegistNo(String registNo) {
		this.registNo = registNo;
	}
	public Integer getScheduleID() {
		return scheduleID;
	}
	public void setScheduleID(Integer scheduleID) {
		this.scheduleID = scheduleID;
	}
	public String getPolicyNo() {
		return policyNo;
	}
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}
	public String getNodeType() {
		return nodeType;
	}
	public void setNodeType(String nodeType) {
		this.nodeType = nodeType;
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
	public String getCommiFlag() {
		return commiFlag;
	}
	public void setCommiFlag(String commiFlag) {
		this.commiFlag = commiFlag;
	}
	public String getSchedFlag() {
		return schedFlag;
	}
	public void setSchedFlag(String schedFlag) {
		this.schedFlag = schedFlag;
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
