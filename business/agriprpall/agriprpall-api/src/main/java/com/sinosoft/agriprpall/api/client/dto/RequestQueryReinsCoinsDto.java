package com.sinosoft.agriprpall.api.client.dto;

public class RequestQueryReinsCoinsDto {
	//险种代码
	private String riskCode;
	//归属机构代码
	private String comCode;
	//起保日期
	private String startDate;
	
	/**
     *  构造方法
     */
	public RequestQueryReinsCoinsDto(){
	}

	public String getRiskCode() {
		return riskCode;
	}

	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}

	public String getComCode() {
		return comCode;
	}

	public void setComCode(String comCode) {
		this.comCode = comCode;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	
}
