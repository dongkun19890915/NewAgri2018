package com.sinosoft.agriclaim.api.individuation.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;
import java.util.Date;
/**
 * jiaoyunzhen 2018年1月5日16:42:48 
 * @author Administrator
 *
 */
public class UndwrtInfoClaimDto extends BaseRequest implements Serializable {

	
	private static final long serialVersionUID = 1L;
	/** 请求类型 */
	private String requestType ;
	/** 请求序列号*/
	private String requestSeqNo ;
	/** 流入时间*/
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date flowinTime;
	/** 业务类型  C实赔 /Y预赔   */
	private String certiType ;
	/** 预赔登记号或赔款计算书号 */
	private String businessNo ;
	/** 核赔标志*/
	private String undwrtWriteFlag;
	/** 理赔工作流号*/
	private String flowId;
	/** 序号*/
	private String logNo;
	/** 审批意见*/
	private String nitionInfo;
	/** 处理人员代码*/
	private String handlerCode;
	/** 当前节点*/
	private String nodeNo;
	
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
	public String getNitionInfo() {
		return nitionInfo;
	}
	public void setNitionInfo(String nitionInfo) {
		this.nitionInfo = nitionInfo;
	}
	public String getHandlerCode() {
		return handlerCode;
	}
	public void setHandlerCode(String handlerCode) {
		this.handlerCode = handlerCode;
	}
	public String getNodeNo() {
		return nodeNo;
	}
	public void setNodeNo(String nodeNo) {
		this.nodeNo = nodeNo;
	}
	public String getRequestType() {
		return requestType;
	}
	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}
	public String getRequestSeqNo() {
		return requestSeqNo;
	}
	public void setRequestSeqNo(String requestSeqNo) {
		this.requestSeqNo = requestSeqNo;
	}
	public Date getFlowinTime() {
		return flowinTime;
	}
	public void setFlowinTime(Date flowinTime) {
		this.flowinTime = flowinTime;
	}
	public String getCertiType() {
		return certiType;
	}
	public void setCertiType(String certiType) {
		this.certiType = certiType;
	}
	public String getBusinessNo() {
		return businessNo;
	}
	public void setBusinessNo(String businessNo) {
		this.businessNo = businessNo;
	}
	public String getUndwrtWriteFlag() {
		return undwrtWriteFlag;
	}
	public void setUndwrtWriteFlag(String undwrtWriteFlag) {
		this.undwrtWriteFlag = undwrtWriteFlag;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
