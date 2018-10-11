package com.sinosoft.agriprpall.api.client.dto;

/**
 * 查询单证流水号requestDto
 * @Author: 何伟东
 * @Date: 2017/12/1 8:56
 */
public class RequestQueryVisaserialnoDto {
	/**
	 * 单证类型
	 */
	private String visaCode;
	/**
	 * 登录用户归属机构
	 */
	private String comCode;

	public String getVisaCode() {
		return visaCode;
	}
	public void setVisaCode(String visaCode) {
		this.visaCode = visaCode;
	}
	public String getComCode() {
		return comCode;
	}
	public void setComCode(String comCode) {
		this.comCode = comCode;
	}

}