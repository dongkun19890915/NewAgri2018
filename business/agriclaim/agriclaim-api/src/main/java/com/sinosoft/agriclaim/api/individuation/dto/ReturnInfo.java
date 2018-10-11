package com.sinosoft.agriclaim.api.individuation.dto;

/**
 * 
 * @description 获取信雅达返回对象
 * @author 周柯宇
 * @date 2018年1月18日 上午11:19:57
 */
public class ReturnInfo {

	private String resCode;		//200：成功，400：失败 
	private String resMsg;		//后台返回消息，如果有异常则是异常信息
	private String sumImage;	//批次资料个数总和
	
	public String getResCode() {
		return resCode;
	}
	public void setResCode(String resCode) {
		this.resCode = resCode;
	}
	public String getResMsg() {
		return resMsg;
	}
	public void setResMsg(String resMsg) {
		this.resMsg = resMsg;
	}
	public String getSumImage() {
		return sumImage;
	}
	public void setSumImage(String sumImage) {
		this.sumImage = sumImage;
	}
	
	
}
