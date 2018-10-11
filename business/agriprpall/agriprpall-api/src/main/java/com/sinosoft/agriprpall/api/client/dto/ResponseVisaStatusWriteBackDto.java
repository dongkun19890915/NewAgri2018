package com.sinosoft.agriprpall.api.client.dto;

/**
 * 单证状态回写responseDto
 * @Author: 何伟东
 * @Date: 2017/12/1 8:53
 */
public class ResponseVisaStatusWriteBackDto {
	/**
	 * 回写单证状态:1  :成功---0  :失败
	 */
	private String returnStatus;

	public String getReturnStatus() {
		return returnStatus;
	}

	public void setReturnStatus(String returnStatus) {
		this.returnStatus = returnStatus;
	}
}