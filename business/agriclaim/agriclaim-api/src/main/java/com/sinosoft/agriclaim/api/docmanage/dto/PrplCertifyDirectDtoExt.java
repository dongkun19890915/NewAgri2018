package com.sinosoft.agriclaim.api.docmanage.dto;

import java.util.List;

/**
 * @description: 类功能简述：单证收集对象扩展类
 * @author 安齐崇
 * @date 2017年12月9日下午2:51:23
 *
 */
public class PrplCertifyDirectDtoExt extends PrplCertifyDirectDto {

	private static final long serialVersionUID = 1L;
	private List<PrplCertifyDirectDto> prplCertifyDirectDtoList;
	public List<PrplCertifyDirectDto> getPrplCertifyDirectDtoList() {
		return prplCertifyDirectDtoList;
	}
	public void setPrplCertifyDirectDtoList(List<PrplCertifyDirectDto> prplCertifyDirectDtoList) {
		this.prplCertifyDirectDtoList = prplCertifyDirectDtoList;
	}
	
  
}
