package com.sinosoft.agriclaim.api.combinemanage.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;

/**
 * @descption 合并案件查询服务出餐参dto
 * @author liyang	
 * @date 2017-11-26
 */
public class ComCaseQueryOutDto extends BaseRequest implements Serializable{
	private static final long SerialVersionUID = 1L;
	/** 序列号 */
	private int serialNo;
	/** 报案号 */
	private String registNo;
	/**保单号*/
	private String policyNo;
	/**事故号*/
	private String accidentNo;
	/**险种*/
	private String riskCode;
	/**被保险人*/
	private String insuredName;
	/**节点类型*/
	private String nodeName;
	/**状态*/
	private String nodeStatus;
	/** 流程编号*/
	private String swfLogFlowID;
	/** 序号*/
	private String swfLogLogNo;
	
	public int getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}
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
	public String getAccidentNo() {
		return accidentNo;
	}
	public void setAccidentNo(String accidentNo) {
		this.accidentNo = accidentNo;
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
	public String getNodeName() {
		return nodeName;
	}
	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}
	public String getNodeStatus() {
		return nodeStatus;
	}
	public void setNodeStatus(String nodeStatus) {
		this.nodeStatus = nodeStatus;
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
