package com.sinosoft.agriclaim.api.registmanage.dto;

import java.util.List;

/**
 * 
 * @description: 类功能简述：出险信息查询返参dto
 * @author 安齐崇
 * @date 2017年11月28日下午6:10:38
 *
 */
public class RiskInfoResponseDto {
	private List<PrpLRegistDtoExt> prpLRegistDtoExtList;

	public List<PrpLRegistDtoExt> getPrpLRegistDtoExtList() {
		return prpLRegistDtoExtList;
	}

	public void setPrpLRegistDtoExtList(List<PrpLRegistDtoExt> prpLRegistDtoExtList) {
		this.prpLRegistDtoExtList = prpLRegistDtoExtList;
	}

}
