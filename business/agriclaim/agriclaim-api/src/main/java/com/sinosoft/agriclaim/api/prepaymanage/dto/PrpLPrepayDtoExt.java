package com.sinosoft.agriclaim.api.prepaymanage.dto;
/**
 * @description: 类功能简述：对特殊赔案主信息进行扩展
 * @author 安齐崇
 * @date 2017年12月7日下午3:26:54
 *
 */
public class PrpLPrepayDtoExt extends PrpLPrepayDto {
	
	private static final long serialVersionUID = 1L;
	/*状态信息*/
	private String status;
	/** 币别中文名*/
	private String currencyName;
	/** 业务归属业务员姓名*/
	private String handler1Name;
	/** 业务归属机构名称*/
	private String comName;
	/** 经办人名称名称*/
	private String handlerName;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCurrencyName() {
		return currencyName;
	}
	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}
	public String getHandler1Name() {
		return handler1Name;
	}
	public void setHandler1Name(String handler1Name) {
		this.handler1Name = handler1Name;
	}
	public String getComName() {
		return comName;
	}
	public void setComName(String comName) {
		this.comName = comName;
	}
	public String getHandlerName() {
		return handlerName;
	}
	public void setHandlerName(String handlerName) {
		this.handlerName = handlerName;
	}

}
