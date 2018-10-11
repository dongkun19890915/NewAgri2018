package com.sinosoft.agriclaim.api.workflowmanage.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;

/**
 * @description 创建一个新的工作流流程
 * @author yanghang
 * @date 2017年10月20日
 */
public class CreateWorkFlowInfoDto extends BaseRequest implements Serializable {
	private static final long serialVersionUID = 1L;
	/** 部门代码 */
	private String comCode;
	/** 用户代码 */
	private String userCode;
	/** 用户名称 */
	private String userName;
	// -------以上均为用户信息-----------
	/** 业务号码,如果是报案节点开始的,那么就是报案号码 */
	private String businessNo;
	/** 险种号 */
	private String riskCode;
	/** 保单号码 */
	private String policyNo;
	/** 被保险人 */
	private String insuredName;

	public String getComCode() {
		return comCode;
	}

	public void setComCode(String comCode) {
		this.comCode = comCode;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getBusinessNo() {
		return businessNo;
	}

	public void setBusinessNo(String businessNo) {
		this.businessNo = businessNo;
	}

	public String getRiskCode() {
		return riskCode;
	}

	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}

	public String getPolicyNo() {
		return policyNo;
	}

	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}

	public String getInsuredName() {
		return insuredName;
	}

	public void setInsuredName(String insuredName) {
		this.insuredName = insuredName;
	}

}
