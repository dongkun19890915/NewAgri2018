package com.sinosoft.agriclaim.api.combinemanage.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
import com.sinosoft.ims.api.kernel.dto.UserDto;

public class ComClaimQueryInDto extends BaseRequest implements Serializable{
	private static final long SerialVersionUID = 1L;
	
	/** 报案号 */
	private String registNo;
	/**保单号*/
	private String policyNo;
	/**立案号*/
	private String claimNo;
	/**被保险人 */
	private String insuredName;
	/**流入起始时间 */
	private String flowInTimeStart;
	/**流入终止时间 */
	private String flowInTimeEnd;
	/**保险大类 */
	private String riskType;
	/**案件状态 */
	private String nodeStatus;
	/**页码 */
	private int pageNo;
	/**页容量 */
	private int pageSize;
	/**并案号*/
	private String combineNo = "";
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
	public String getClaimNo() {
		return claimNo;
	}
	public void setClaimNo(String claimNo) {
		this.claimNo = claimNo;
	}
	public String getInsuredName() {
		return insuredName;
	}
	public void setInsuredName(String insuredName) {
		this.insuredName = insuredName;
	}
	public String getFlowInTimeStart() {
		return flowInTimeStart;
	}
	public void setFlowInTimeStart(String flowInTimeStart) {
		this.flowInTimeStart = flowInTimeStart;
	}
	public String getFlowInTimeEnd() {
		return flowInTimeEnd;
	}
	public void setFlowInTimeEnd(String flowInTimeEnd) {
		this.flowInTimeEnd = flowInTimeEnd;
	}
	public String getRiskType() {
		return riskType;
	}
	public void setRiskType(String riskType) {
		this.riskType = riskType;
	}
	public String getNodeStatus() {
		return nodeStatus;
	}
	public void setNodeStatus(String nodeStatus) {
		this.nodeStatus = nodeStatus;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public String getCombineNo() {
		return combineNo;
	}
	public void setCombineNo(String combineNo) {
		this.combineNo = combineNo;
	}
	
}
