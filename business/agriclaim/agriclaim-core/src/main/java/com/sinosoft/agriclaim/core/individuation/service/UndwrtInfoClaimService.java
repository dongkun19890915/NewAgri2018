package com.sinosoft.agriclaim.core.individuation.service;

import com.sinosoft.agriclaim.api.individuation.dto.UndwrtInfoClaimDto;

/**
 * @author jiaoyunzehn
 * @time  2017年12月18日15:01:16
 * @description 农险理赔审核通过、下发修改回写理赔接口Service层
 */
public interface UndwrtInfoClaimService {
	
	/**
     *@description 审核通过
     *@param
     */
	public int checkPass(UndwrtInfoClaimDto undwrtInfoClaimDto) throws Exception;
	/**
     *@description 下发修改
     *@param
     */
	public void issuedRevise(UndwrtInfoClaimDto undwrtInfoClaimDto) throws Exception;
}
