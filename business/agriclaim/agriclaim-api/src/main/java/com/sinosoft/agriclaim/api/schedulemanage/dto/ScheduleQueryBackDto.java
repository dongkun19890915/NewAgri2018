package com.sinosoft.agriclaim.api.schedulemanage.dto;

import com.sinosoft.framework.dto.BasePageableRequest;

import java.io.Serializable;
/**
 * @description 调度任务查询返参对象
 * @author 马俊玲
 * @date 2017年10月19日 下午3:55:50
 */
public class ScheduleQueryBackDto extends BasePageableRequest implements Serializable {
	private static final long serialVersionUID = 1L;
	/** 报案号 */
	private String registNo;
	/** 保单号 */
	private String policyNo;
	/** 险种代码 */
	private String riskCode;
	/** 被保险人名称 */
	private String insuredname;

	private String lossItemName;
	private String lossName;
	/** 流入时间 */
	private String flowinTime;
	/** 节点状态 */
	private String nodeStatus;
	/** 操作员名称 */
	private String handlerName;
	/** 工作流logNo、 */
	private int swflogLogNo;
	/** 工作流modelNo */
	private int swflogModelNo;
	/** 节点类型 */
	private String nodeType;
	/** 工作流flowId */
	private String swflogFlowId ;
	/**出险标的*/
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

	public String getInsuredname() {
		return insuredname;
	}

	public void setInsuredname(String insuredname) {
		this.insuredname = insuredname;
	}

	public String getLossItemName() {
		return lossItemName;
	}

	public void setLossItemName(String lossItemName) {
		this.lossItemName = lossItemName;
	}

	public String getFlowinTime() {
		return flowinTime;
	}

	public void setFlowinTime(String flowinTime) {
		this.flowinTime = flowinTime;
	}

	public String getNodeStatus() {
		return nodeStatus;
	}

	public void setNodeStatus(String nodeStatus) {
		this.nodeStatus = nodeStatus;
	}

	public String getHandlerName() {
		return handlerName;
	}

	public void setHandlerName(String handlerName) {
		this.handlerName = handlerName;
	}

	public int getSwflogLogNo() {
		return swflogLogNo;
	}

	public void setSwflogLogNo(int swflogLogNo) {
		this.swflogLogNo = swflogLogNo;
	}

	public int getSwflogModelNo() {
		return swflogModelNo;
	}

	public void setSwflogModelNo(int swflogModelNo) {
		this.swflogModelNo = swflogModelNo;
	}

	public String getNodeType() {
		return nodeType;
	}

	public void setNodeType(String nodeType) {
		this.nodeType = nodeType;
	}

	public String getSwflogFlowId() {
		return swflogFlowId;
	}

	public void setSwflogFlowId(String swflogFlowId) {
		this.swflogFlowId = swflogFlowId;
	}

	public String getLossName() {
		return lossName;
	}

	public void setLossName(String lossName) {
		this.lossName = lossName;
	}



}
