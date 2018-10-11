package com.sinosoft.pms.api.salerate.dto;

import com.sinosoft.pms.api.common.dto.PmsRequestDto;


/**
 * @description 查询销售费率入参时使用
 * @author yinqingzhu
 * @date 2016年9月29日上午9:12:22
 */
public class SaleRateQueryConditionDto extends PmsRequestDto implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	//业务来源
	private String businessNature;

	public String getBusinessNature() {
		return businessNature;
	}

	public void setBusinessNature(String businessNature) {
		this.businessNature = businessNature;
	} 
	
}
