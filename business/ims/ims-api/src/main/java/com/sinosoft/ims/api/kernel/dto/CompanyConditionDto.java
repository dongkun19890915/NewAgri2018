package com.sinosoft.ims.api.kernel.dto;

/**
 * @description 机构查询参数 
 * @author HSQ
 * @date 2017年8月30日 上午10:31:07
 */
public class CompanyConditionDto {

	/** 机构代码 */
	private String comCode;
	
	/** 机构名称 */
	private String comCName;
	
	/** 联系地址 */
	private String addressCName;
	
	/** 上级机构代码 */
	private String upperComCode;
	
	/** 效力状态 */
	private String validStatus;
	//机构级别
	private String comLevel;

	public String getComCode() {
		return comCode;
	}

	public void setComCode(String comCode) {
		this.comCode = comCode;
	}

	public String getComCName() {
		return comCName;
	}

	public void setComCName(String comCName) {
		this.comCName = comCName;
	}

	public String getAddressCName() {
		return addressCName;
	}

	public void setAddressCName(String addressCName) {
		this.addressCName = addressCName;
	}

	public String getUpperComCode() {
		return upperComCode;
	}

	public void setUpperComCode(String upperComCode) {
		this.upperComCode = upperComCode;
	}

	public String getValidStatus() {
		return validStatus;
	}

	public void setValidStatus(String validStatus) {
		this.validStatus = validStatus;
	}

	public String getComLevel() {
		return comLevel;
	}

	public void setComLevel(String comLevel) {
		this.comLevel = comLevel;
	}
}
