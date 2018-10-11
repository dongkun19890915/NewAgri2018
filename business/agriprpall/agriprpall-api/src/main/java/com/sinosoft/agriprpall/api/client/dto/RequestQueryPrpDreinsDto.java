package com.sinosoft.agriprpall.api.client.dto;

public class RequestQueryPrpDreinsDto {
	/**
	 * 查询条件dto
	 */
	private String condition;

	public RequestQueryPrpDreinsDto(){
		this.condition="";
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

}
