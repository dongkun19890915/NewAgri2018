package com.sinosoft.agriclaim.api.businessutilmanage.dto;

import java.util.List;

/**
 * @description: 类功能简述：页面复选框，下拉框的所需参数初始化类
 * @author 安齐崇
 * @date 2017年12月9日下午4:11:02
 *
 */
public class ClaimBoxInitResponseVo {
	private String msg;
	private String code;
	private List<ClaimBoxInitDataDto> data;
    
	public List<ClaimBoxInitDataDto> getData() {
		return data;
	}

	public void setData(List<ClaimBoxInitDataDto> data) {
		this.data = data;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}


}
