package com.sinosoft.ims.api.auth.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseDto;

/** 
* @description 承保系统获登录时校验业务权限，返回有权限的riskCode
* @author libin 
* @date 2017年9月20日 上午11:39:16 
* @version 1.0 
*/
public class CheckPowerPrpallResDto extends BaseDto implements Serializable{

	private static final long serialVersionUID = 1L;
	//服务执行结果代码（0000-成功、9999-失败）
	private String resultCode;
	//提示信息
	private String resultMsg;
	//险种代码
	private String riskCode;
	
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
	public String getRiskCode() {
		return riskCode;
	}
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}
}
