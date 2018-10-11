package com.sinosoft.pms.core.arealimit.service;


import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.pms.api.arealimit.dto.AreaLimitQueryConditionDto;
import com.sinosoft.pms.api.arealimit.dto.AreaLimitReturnDto;
import com.sinosoft.pms.api.arealimit.dto.AreaLimitsDto;
import com.sinosoft.pms.api.arealimit.dto.PrpdAreaLimitDto;

import java.util.List;

public interface AreaLimitService {
	/**
	 * @description 查询区域销售限额,此功能供核心系统出单查询使用 
	 * @param queryAreaLimitsDto
	 * @author yinqingzhu
	 * @return PrpDareaLimit
	 */
	public PrpdAreaLimitDto getAreaLimit(AreaLimitQueryConditionDto queryAreaLimitsDto) throws Exception;
	
	/**
	 * @description 查询区域销售限额列表,此功能供pms系统查询使用 
	 * @param queryAreaLimitsDto
	 * @author yinqingzhu
	 * @return queryAreaLimitsDto
	 */
	public PageInfo<PrpdAreaLimitDto> queryAreaLimitList(AreaLimitQueryConditionDto queryAreaLimitsDto);
	/**
	 * @description 保存区域销售限额,此功能供pms系统维护使用 
	 * @param savereaLimitsDto
	 * @author yinqingzhu
	 * @return queryAreaLimitsDto
	 */
	public AreaLimitReturnDto saveAreaLimits(AreaLimitsDto savereaLimitsDto) throws Exception;

    
    /**
     * @description 查询最近一次有效的版本信息
     * @return PageInfo<PrpdAreaLimitDto>
     * @author yinqingzhu
     * @date 2016年9月27日上午11:05:48
     */
    public List<PrpdAreaLimitDto> queryLateAreaLimit();
	
}
