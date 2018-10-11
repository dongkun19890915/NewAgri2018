package com.sinosoft.agriprpall.api.client.dto;

/**
 * 查询单证类型和单证流水号requestDto
 * @Author: 何伟东
 * @Date: 2017/12/1 8:55
 */
public class RequestQueryVisaCodesAndVisaSerialNosDto {
	/**
	 * 业务号
	 */
	private String businessNo;
	/**
	 * 归属机构
	 */
	private String comCode;
	private String userCode;

	public String getBusinessNo() {
		return businessNo;
	}
	public void setBusinessNo(String businessNo) {
		this.businessNo = businessNo;
	}
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
}