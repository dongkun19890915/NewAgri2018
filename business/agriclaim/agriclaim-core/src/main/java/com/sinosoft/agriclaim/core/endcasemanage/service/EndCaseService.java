package com.sinosoft.agriclaim.core.endcasemanage.service;

import com.sinosoft.agriclaim.api.endcasemanage.dto.EndCaseDto;

/**
 * @author 周柯宇
 * @mail 
 * @time 2017-12-02 
 * @description 赔案接口
 */
public interface EndCaseService {

	/**
	 *@author 周柯宇
	 *@time  2017-12-02
     *@description 按主键ClaimNo实体
     *@param 
     */
	public EndCaseDto findByClaimNo(String claimNo);
}
