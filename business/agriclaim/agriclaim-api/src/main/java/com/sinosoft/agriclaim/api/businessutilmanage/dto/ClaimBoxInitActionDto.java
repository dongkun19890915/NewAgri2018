package com.sinosoft.agriclaim.api.businessutilmanage.dto;

import java.util.List;
/**
 * @description: 类功能简述：封装参数集合，保持层级关系
 * @author 安齐崇
 * @date 2017年12月9日下午4:32:50
 *
 */
public class ClaimBoxInitActionDto {
	List<ClaimBoxInitDataParamDto> action_result;

	public List<ClaimBoxInitDataParamDto> getAction_result() {
		return action_result;
	}

	public void setAction_result(List<ClaimBoxInitDataParamDto> action_result) {
		this.action_result = action_result;
	}

}
