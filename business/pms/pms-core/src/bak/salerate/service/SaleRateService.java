package com.sinosoft.pms.core.salerate.service;

import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.pms.api.salerate.dto.PrpdSalesRateDto;
import com.sinosoft.pms.api.salerate.dto.SaleRateQueryConditionDto;
import com.sinosoft.pms.api.salerate.dto.SaleRateReturnDto;

public interface SaleRateService {
	/**
	 *@description 销售费率查询，此功能供核心系统查询销售费率使用
	* @param  SaleRateQueryConditionDto
	* @return PrpdSalesRateDto
	* @author yinqingzhu
	* @date 2016年9月14日
	*/
	public PrpdSalesRateDto getSaleRate(SaleRateQueryConditionDto saleRateDto) throws Exception;
	
	/**
	* @description 销售费率列表查询，此功能供pms系统查询销售费率使用
	* @param SaleRateQueryConditionDto
	* @return PageInfo<PrpdSalesRateDto>
	* @author yinqingzhu
	* @date 2016年9月12日
	*/
	public PageInfo<PrpdSalesRateDto> quereyPrpdSalesRateList(SaleRateQueryConditionDto saleRatesDto) throws Exception;
	
	/**
	 * @description 保存销售费率相关数据
	* @param PrpdSalesRateDto
	* @return SaleRateReturnDto
	* @author yinqingzhu
	* @date 2016年9月12日
	 */
	public SaleRateReturnDto savePrpdSalesRate(PrpdSalesRateDto prpdSalesRateDto) throws Exception;
	
}
