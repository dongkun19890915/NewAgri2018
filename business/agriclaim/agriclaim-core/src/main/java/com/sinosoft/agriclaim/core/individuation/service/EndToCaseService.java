package com.sinosoft.agriclaim.core.individuation.service;

import com.sinosoft.agriclaim.api.compensatemanage.dto.PrpLCompensateDto;
import com.sinosoft.agriclaim.core.individuation.entity.EndCaseDto;

/**
 * @author jiaoyunzhen
 * @mail admin@sinosoft.com.cn
 * @time 2017年12月25日11:14:55
 * @description 大对象保证事务一致性
 */
public interface EndToCaseService {
	/**
     *@description 大对象update
     *@param prpLcompensateDto 赔款计算书号
     */
	public void save(EndCaseDto endCaseDto) throws Exception;
}
