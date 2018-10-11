package com.sinosoft.agriclaim.api.registmanage;


import java.util.Map;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sinosoft.agriclaim.api.AgriClaimConstant;
import com.sinosoft.agriclaim.api.registmanage.dto.RelatePolicyInfoDto;

/**
 * @author 陈旭
 * @time  2017-11-14 15:38:49.324 
 * @description 保单关联信息Api接口
 */
@FeignClient(name = AgriClaimConstant.AGRI_CLAIM_SERVICE_NAME, path = RelatePolicyInfoApi.PATH)
public interface RelatePolicyInfoApi {
	public static final String PATH = "relatePolicyInfo";
	
	@RequestMapping(value = "showRelateInfo",method = {RequestMethod.POST})
	RelatePolicyInfoDto showRelateInfo(@RequestBody Map<String, String>  policyNoMap) throws Exception;
}
