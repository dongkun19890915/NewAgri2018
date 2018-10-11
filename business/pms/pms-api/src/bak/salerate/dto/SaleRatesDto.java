package com.sinosoft.pms.api.salerate.dto;

import java.util.List;

import com.sinosoft.pms.api.common.dto.PmsRequestDto;


/**
 * @description 保存销售费率传入数据时使用 
 * @author yinqingzhu
 * @date 2016年9月29日上午9:22:40
 */
public class SaleRatesDto extends PmsRequestDto implements java.io.Serializable{
    
    private static final long serialVersionUID = 1L;
    List<PrpdSalesRateDto> salesRateList ;

	public List<PrpdSalesRateDto> getSalesRateList() {
		return salesRateList;
	}

	public void setSalesRateList(List<PrpdSalesRateDto> salesRateList) {
		this.salesRateList = salesRateList;
	}
	
}
