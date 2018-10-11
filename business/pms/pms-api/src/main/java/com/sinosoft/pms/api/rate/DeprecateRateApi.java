package com.sinosoft.pms.api.rate;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sinosoft.pms.PMSConstant;
import com.sinosoft.pms.api.rate.dto.DeprecateRateDto;
import com.sinosoft.pms.api.rate.dto.PrpDdepreCateRateDto;

/**
 * @description 折旧率接口服务
 * @author HSQ
 * @date 2017年8月23日 上午9:58:32
 */
@FeignClient(value = PMSConstant.PMS_SERVICE_NAME, path = DeprecateRateApi.ServicePath)
public interface DeprecateRateApi {
	
	String ServicePath = "actualvalue";
	
	/**
	 * @description 获取折旧率
	 * @param deprecateRateDto
	 * @return
	 * @throws Exception
	 * @author HSQ
	 * @date 2017年8月23日 上午10:10:46
	 */
	@RequestMapping(value = "getDeprecateRate",method = {RequestMethod.POST})
    @ResponseBody PrpDdepreCateRateDto getDeprecateRate(@RequestBody DeprecateRateDto deprecateRateDto) throws Exception;

}
