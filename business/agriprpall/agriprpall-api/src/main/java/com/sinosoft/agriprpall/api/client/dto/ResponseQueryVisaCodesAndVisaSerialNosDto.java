package com.sinosoft.agriprpall.api.client.dto;
/**
 * 查询单证类型和单证流水号responseDto
 * @Author: 何伟东
 * @Date: 2017/12/1 8:57
 */
public class ResponseQueryVisaCodesAndVisaSerialNosDto {
	/**
	 * 单证类型代码
	 */
	private String visaCode;
	/**
	 * 单证类型名称
	 */
	private String visaName;
	/**
	 * 单证流水号
	 */
	private String visaSerisal;

	public String getVisaCode() {
		return visaCode;
	}
	public void setVisaCode(String visaCode) {
		this.visaCode = visaCode;
	}
	public String getVisaName() {
		return visaName;
	}
	public void setVisaName(String visaName) {
		this.visaName = visaName;
	}
	public String getVisaSerisal() {
		return visaSerisal;
	}
	public void setVisaSerisal(String visaSerisal) {
		this.visaSerisal = visaSerisal;
	}


}