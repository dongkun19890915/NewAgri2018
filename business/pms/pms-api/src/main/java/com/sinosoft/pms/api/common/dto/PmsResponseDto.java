package com.sinosoft.pms.api.common.dto;

/**
 * @description 服务返回基类
 * @author 王志伟
 * @date 2016年9月18日下午5:04:33
 */
public class PmsResponseDto implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	/** 返回结果code  */
	public String resultCode;
	
	/** 返回结果msg  */
	public String resultMsg;

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public String getResultMsg() {
		return resultMsg;
	}

	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}
	
}
