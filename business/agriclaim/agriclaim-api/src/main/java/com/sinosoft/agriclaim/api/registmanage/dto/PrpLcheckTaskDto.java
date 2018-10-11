package com.sinosoft.agriclaim.api.registmanage.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BasePageableRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-11 09:09:58.263 
 * 工作流表Api操作对象
 */
public class PrpLcheckTaskDto extends BasePageableRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String 	registNo;
	private String 	flowInTime;//调度时间;
	private String 	beforeHandlerName;
	private String 	editType;//编辑类型
	private String 	nodeType;//调取去向(查勘:check;车辆定损:certa;人伤:wound;财产损失:propc)
	private String 	handlerName;
	private String 	lossItemName;//调度对象
	private String 	statu;//调度状态（新提交，已提交）
	private String  NhandlerCode;//定损人
	private String  lossItemCode;
	private String  flowID;
	private String  logNo;
	private String  policyNo;
	private String  handleDept;
	private String  riskCode;
	private String insuredName;//被保险人
	
	
	
	public String getInsuredName() {
		return insuredName;
	}
	public void setInsuredName(String insuredName) {
		this.insuredName = insuredName;
	}
	public String getLossItemCode() {
		return lossItemCode;
	}
	public void setLossItemCode(String lossItemCode) {
		this.lossItemCode = lossItemCode;
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
	public String getPolicyNo() {
		return policyNo;
	}
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}
	public String getHandleDept() {
		return handleDept;
	}
	public void setHandleDept(String handleDept) {
		this.handleDept = handleDept;
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
	public String getFlowInTime() {
		return flowInTime;
	}
	public void setFlowInTime(String flowInTime) {
		this.flowInTime = flowInTime;
	}
	public String getBeforeHandlerName() {
		return beforeHandlerName;
	}
	public void setBeforeHandlerName(String beforeHandlerName) {
		this.beforeHandlerName = beforeHandlerName;
	}
	public String getEditType() {
		return editType;
	}
	public void setEditType(String editType) {
		this.editType = editType;
	}
	public String getNodeType() {
		return nodeType;
	}
	public void setNodeType(String nodeType) {
		this.nodeType = nodeType;
	}
	public String getHandlerName() {
		return handlerName;
	}
	public void setHandlerName(String handlerName) {
		this.handlerName = handlerName;
	}
	public String getLossItemName() {
		return lossItemName;
	}
	public void setLossItemName(String lossItemName) {
		this.lossItemName = lossItemName;
	}
	public String getStatu() {
		return statu;
	}
	public void setStatu(String statu) {
		this.statu = statu;
	}
	public String getNhandlerCode() {
		return NhandlerCode;
	}
	public void setNhandlerCode(String nhandlerCode) {
		NhandlerCode = nhandlerCode;
	}
	
		
}
