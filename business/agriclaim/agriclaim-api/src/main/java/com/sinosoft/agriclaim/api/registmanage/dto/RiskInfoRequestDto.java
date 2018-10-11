package com.sinosoft.agriclaim.api.registmanage.dto;

import com.sinosoft.framework.dto.BaseRequest;

public class RiskInfoRequestDto extends BaseRequest {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String policyNo;  //保单号
	private String curRegistNo; //报案号
	public String getPolicyNo() {
		return policyNo;
	}
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}
	public String getCurRegistNo() {
		return curRegistNo;
	}
	public void setCurRegistNo(String curRegistNo) {
		this.curRegistNo = curRegistNo;
	}

}
