package com.sinosoft.agriprpall.api.client.dto;

import java.util.List;

/**
 * 单证状态回写requestDto
 * @Author: 何伟东
 * @Date: 2017/12/1 8:52
 */
public class RequestVisaStatusWriteBackDto {
	/**
	 * 业务号
	 */
	private String businessNo;
	/**
	 * 归属机构
	 */
	private String comCode;
	/**
	 * 单证流水号
	 */
	private String visaSerialNo;
	/**
	 * 单证类型
	 */
	private String visaCode;
	private String userCode;
	private List<RequestVisaStatusWriteBackDto> backDtoList;

	public List<RequestVisaStatusWriteBackDto> getBackDtoList() {
		return backDtoList;
	}

	public void setBackDtoList(List<RequestVisaStatusWriteBackDto> backDtoList) {
		this.backDtoList = backDtoList;
	}

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

	public String getVisaSerialNo() {
		return visaSerialNo;
	}

	public void setVisaSerialNo(String visaSerialNo) {
		this.visaSerialNo = visaSerialNo;
	}

	public String getVisaCode() {
		return visaCode;
	}

	public void setVisaCode(String visaCode) {
		this.visaCode = visaCode;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
}