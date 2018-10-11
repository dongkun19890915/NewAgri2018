package com.sinosoft.agriclaim.api.compensatemanage.dto;

import java.util.List;

/**
 * @description: 类功能简述：理算文本信息扩展类
 * @author 安齐崇
 * @date 2017年12月3日上午11:48:31
 *
 */
public class PrpLCTextDtoExt extends PrpLCTextDto {

	private static final long serialVersionUID = 1L;
	private List<PrpLCTextDto> prpLCTextDtoList;
	public List<PrpLCTextDto> getPrpLCTextDtoList() {
		return prpLCTextDtoList;
	}
	public void setPrpLCTextDtoList(List<PrpLCTextDto> prpLCTextDtoList) {
		this.prpLCTextDtoList = prpLCTextDtoList;
	}
    
}
