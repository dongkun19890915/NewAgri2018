package com.sinosoft.pms.api.config;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sinosoft.pms.PMSConstant;

@FeignClient(name = PMSConstant.PMS_SERVICE_NAME, path = SysConfigApi.PATH)
public interface SysConfigApi {
	String PATH = "sysconfig";
	
	/**
	 * 根据主键（机构代码、险种代码、配置类型）查询配置结果
	 * @param comCode
	 * @param riskCode
	 * @param configCode
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getvalue", method = RequestMethod.POST)
	@ResponseBody
    String getValue(@RequestParam("key") String key) throws Exception;
}
