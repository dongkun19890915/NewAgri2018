package com.sinosoft.pms.core.rate.service;

import com.sinosoft.pms.api.rate.dto.DeprecateRateDto;
import com.sinosoft.pms.api.rate.dto.PrpDdepreCateRateDto;

/**
 * @description 折旧率接口服务
 * @author HSQ
 * @date 2017年8月23日 上午10:10:25
 */
public interface DeprecateRateService {
	
	/**
	 * @description 获取折旧率
	 * @param deprecateRateDto
	 * @return
	 * @author HSQ
	 * @throws Exception 
	 * @date 2017年8月23日 上午10:11:54
	 */
    PrpDdepreCateRateDto getDeprecateRate(DeprecateRateDto deprecateRateDto) throws Exception;

}
