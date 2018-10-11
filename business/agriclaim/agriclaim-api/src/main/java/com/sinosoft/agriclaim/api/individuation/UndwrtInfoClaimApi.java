package com.sinosoft.agriclaim.api.individuation;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sinosoft.agriclaim.api.AgriClaimConstant;
import com.sinosoft.agriclaim.api.individuation.dto.UndwrtInfoClaimDto;


/**
 * 
 * @author jiaoyunzhen
 * @time  2017-12-18 
 * @description 农险双核核赔通过、下发修改回写理赔接口
 */
@FeignClient(name = AgriClaimConstant.AGRI_CLAIM_SERVICE_NAME, path = UndwrtInfoClaimApi.PATH)
public interface UndwrtInfoClaimApi {
	
	public static final String PATH = "undwrtInfoClaim";
	
	
	/**
     * 核赔审核通过接口
     * @author: jiaoyunzhen钊
     * @date: 2017年12月18日14:38:22
     * @param 
     * @return 
     * @throws Exception
     */
	@RequestMapping(value = "checkPass",method = {RequestMethod.POST})
	void checkPass(@RequestBody UndwrtInfoClaimDto undwrtInfoClaimDto) throws Exception;
	
	/**
     * 核赔下发修改接口
     * @author: jiaoyunzhen
     * @date: 2017年12月18日14:38:28
     * @param 
     * @return 
     * @throws Exception
     */
	@RequestMapping(value = "issuedRevise",method = {RequestMethod.POST})
	public @ResponseBody
	void issuedRevise(@RequestBody UndwrtInfoClaimDto undwrtInfoClaimDto) throws Exception;
}
