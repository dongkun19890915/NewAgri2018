package com.sinosoft.agriprpall.api.client.dto;

public class RequestUpdateEnquiryFlagDto {
	/**
	 * ҵ�������
	 */
	private String type;
	/**
	 * ҵ���
	 */
	private String certifyNo;
	/**
	 * ѯ�۵�״̬
	 */
	private String verifyFlag;

	public RequestUpdateEnquiryFlagDto(){
		this.type="";
		this.certifyNo="";
		this.verifyFlag="";
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCertifyNo() {
		return certifyNo;
	}

	public void setCertifyNo(String certifyNo) {
		this.certifyNo = certifyNo;
	}

	public String getVerifyFlag() {
		return verifyFlag;
	}

	public void setVerifyFlag(String verifyFlag) {
		this.verifyFlag = verifyFlag;
	}

}
