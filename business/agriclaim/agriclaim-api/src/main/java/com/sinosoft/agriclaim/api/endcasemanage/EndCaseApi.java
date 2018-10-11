package com.sinosoft.agriclaim.api.endcasemanage;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sinosoft.agriclaim.api.AgriClaimConstant;
import com.sinosoft.agriclaim.api.endcasemanage.dto.EndCaseDto;

/**
 * @author 周柯宇
 * @mail 
 * @time  2017-12-02
 * @description 结案Api接口
 */
@FeignClient(name = AgriClaimConstant.AGRI_CLAIM_SERVICE_NAME, path = EndCaseApi.PATH)
public interface EndCaseApi {

	public static final String PATH = "EndCase";
	
	/**
	 *@author 周柯宇
	 *@time  2017-12-02
     *@description 按主键ClaimNo实体
     *@param 
     */
	@RequestMapping(value = "findByClaimNo",method = {RequestMethod.POST})
	public EndCaseDto findByClaimNo(@RequestParam("claimNo") String claimNo);
}
