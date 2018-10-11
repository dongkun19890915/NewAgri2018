package com.sinosoft.pms.web.rate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sinosoft.pms.api.rate.DeprecateRateApi;
import com.sinosoft.pms.api.rate.dto.DeprecateRateDto;
import com.sinosoft.pms.api.rate.dto.PrpDdepreCateRateDto;
import com.sinosoft.pms.core.rate.service.DeprecateRateService;

/**
 * @description 折旧率controller
 * @author HSQ
 * @date 2017年8月23日 上午11:01:19
 */
@RestController
@RequestMapping(value = DeprecateRateApi.ServicePath)
public class DeprecateRateController implements DeprecateRateApi {
	
	@Autowired
	private DeprecateRateService deprecateRateService;

	/**
	 * @description 获取折旧率
	 * @param deprecateRateDto
	 * @return
	 * @throws Exception
	 * @author HSQ
	 * @date 2017年8月23日 上午11:01:47
	 */
	@Override
	public @ResponseBody PrpDdepreCateRateDto getDeprecateRate(@RequestBody DeprecateRateDto deprecateRateDto) throws Exception {
		PrpDdepreCateRateDto prpDdepreCateRateDto = deprecateRateService.getDeprecateRate(deprecateRateDto);
		return prpDdepreCateRateDto;
	}
	
	

}
