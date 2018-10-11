package com.sinosoft.dms.api.paymanage.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;

public class PrpAutoRequsetDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性审核类型/审核类型 */
	private String  auditType;
	/**属性operatorId/operatorId*/
	private String operateId;
	/**属性comCode/comCode*/
	private String comCode;
	/**属性comCode/comCode*/
	private String riskCode;
	public String getAuditType() {
		return auditType;
	}
	public void setAuditType(String auditType) {
		this.auditType = auditType;
	}
	public String getOperateId() {
		return operateId;
	}
	public void setOperateId(String operateId) {
		this.operateId = operateId;
	}
	public String getComCode() {
		return comCode;
	}
	public void setComCode(String comCode) {
		this.comCode = comCode;
	}
	public String getRiskCode() {
		return riskCode;
	}
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}

}
