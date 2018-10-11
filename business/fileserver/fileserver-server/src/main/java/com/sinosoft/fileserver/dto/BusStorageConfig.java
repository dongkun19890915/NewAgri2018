package com.sinosoft.fileserver.dto;
/**
 * 业务类型和存储介质的关联关系
 * @description 
 * @author zkr03
 * @date 2016年11月2日下午8:27:54
 */
public class BusStorageConfig {	
	/**
	 * 业务类型
	 */
	private String busType;
	/**
	 * 存储的Code
	 */
	private String configCode;
	public String getBusType() {
		return busType;
	}
	public void setBusType(String busType) {
		this.busType = busType;
	}
	public String getConfigCode() {
		return configCode;
	}
	public void setConfigCode(String configCode) {
		this.configCode = configCode;
	}
	
}
