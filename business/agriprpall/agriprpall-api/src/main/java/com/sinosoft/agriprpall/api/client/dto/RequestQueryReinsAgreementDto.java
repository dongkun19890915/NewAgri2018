package com.sinosoft.agriprpall.api.client.dto;

public class RequestQueryReinsAgreementDto {
	//属性 协议共保合约编码
	private String treatyNo;

	/**
	 *  默认构造方法
	 */
	public RequestQueryReinsAgreementDto(){
	}

	public String getTreatyNo() {
		return treatyNo;
	}

	public void setTreatyNo(String treatyNo) {
		this.treatyNo = treatyNo;
	}

	
}
