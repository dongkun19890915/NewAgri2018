package com.sinosoft.pms.core.coinsrate.service;


import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.pms.api.coinsrate.dto.CoinsRateQueryConditionDto;
import com.sinosoft.pms.api.coinsrate.dto.CoinsRateReturnDto;
import com.sinosoft.pms.api.coinsrate.dto.CoinsRatesDto;
import com.sinosoft.pms.api.coinsrate.dto.PrpDcoinsRateDto;

import java.util.List;


public interface CoinsRateService {
	/**
	* @description 共保体成员比例查询，此功能供核心系统出单使用，返回CoinsRateDto
	* @param prpDcoinsRateDto
	* @return PrpDcoinsRateDto
	* @author yinqingzhu
	* @date 2016年9月17日 
	*/
	public PrpDcoinsRateDto getCoinsRate(CoinsRateQueryConditionDto prpDcoinsRateDto);
	
	/**
	* @description 共保体成员比例列表查询，此功能供pms系统查询共保体成员比例使用
	* @param queryDto
	* @return PageInfo<PrpDcoinsRateDto>
	* @author yinqingzhu
	* @date 2016年9月17日 
	*/
	public PageInfo<PrpDcoinsRateDto> queryCoinsRateList(CoinsRateQueryConditionDto queryDto) throws Exception;
	/**
	* @description 共保体成员比例有效数据列表查询，此功能供pms系统查询共保体成员比例使用
	* @param queryCoinsDto
	* @return CoinsRateDto
	* @author yinqingzhu
	* @date 2016年9月17日 
	 */
//	public PageInfo<PrpDcoinsRateDto> queryLatePage(CoinsRateQueryConditionDto queryDto);
	
	/**
	 * @description 保存共保比例
	 * @param coinsRatesDto
	 * @return CoinsRateReturnDto
	 * @throws Exception
	 * @author yinqingzhu
	 * @date 2016年9月28日下午9:11:40
	 */

	public CoinsRateReturnDto savePrpdCoinsRateList(CoinsRatesDto coinsRatesDto) throws Exception;
	
	/**
	 * @description 刪除共保比例
	* @param coinsRateDto
	* @return CoinsRateReturnDto
	* @author yinqingzhu
	* @date 2016年9月17日  
	 */
	public CoinsRateReturnDto deletePrpdCoinsRate(PrpDcoinsRateDto coinsRateDto) throws Exception;

    
    /**
     * @description  查詢最新有效的版次
     * @param queryDto
     * @return
     * @author zkr07
     * @date 2016年9月27日下午1:52:50
     */
    public List<PrpDcoinsRateDto> queryLateCoinsRate(CoinsRateQueryConditionDto queryDto) throws Exception;
}
