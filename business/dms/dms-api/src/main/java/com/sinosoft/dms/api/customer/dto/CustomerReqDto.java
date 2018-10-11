package com.sinosoft.dms.api.customer.dto;

/**
 * @description 客户查询请求参数 
 * @author HSQ
 * @date 2017年8月28日 下午2:29:51
 */
public class CustomerReqDto {
	
	/** 证件类型 */
	private String identifyType;
	
	/** 证件号码 */
	private String identifyNumber;
	
	/** 组织机构代码 */
	private String organizeCode;

	public String getIdentifyType() {
		return identifyType;
	}

	public void setIdentifyType(String identifyType) {
		this.identifyType = identifyType;
	}

	public String getIdentifyNumber() {
		return identifyNumber;
	}

	public void setIdentifyNumber(String identifyNumber) {
		this.identifyNumber = identifyNumber;
	}

	public String getOrganizeCode() {
		return organizeCode;
	}

	public void setOrganizeCode(String organizeCode) {
		this.organizeCode = organizeCode;
	}

}
