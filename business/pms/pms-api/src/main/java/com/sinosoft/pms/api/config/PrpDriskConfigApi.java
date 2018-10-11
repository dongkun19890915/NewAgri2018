package com.sinosoft.pms.api.config;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sinosoft.pms.PMSConstant;
import com.sinosoft.pms.api.config.dto.PrpDriskConfigDto;

@FeignClient(name = PMSConstant.PMS_SERVICE_NAME, path = PrpDriskConfigApi.PATH)
public interface PrpDriskConfigApi {
	String PATH = "riskconfig";
	
	/**
	 * 根据主键（机构代码、险种代码、配置类型）查询配置结果
	 * @param comCode
	 * @param riskCode
	 * @param configCode
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getconfig", method = RequestMethod.POST)
	@ResponseBody
    PrpDriskConfigDto getConfig(@RequestParam("comCode") String comCode, @RequestParam("riskCode") String riskCode, @RequestParam("configCode") String configCode) throws Exception;
	
	/**
	 * 根据自定义内容查询配置
	 * @param comCode
	 * @param riskCode
	 * @param configCode
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getconfigsenior", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    List<PrpDriskConfigDto> getConfigSenior(@RequestBody PrpDriskConfigDto requestPrpDriskConfigDto) throws Exception;
	
	/**
	 * 根据主键（机构代码、险种代码、配置类型）查询配置结果ConfigValue的值
	 * @param comCode
	 * @param riskCode
	 * @param configCode
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getconfigvalue", method = RequestMethod.POST)
    String getConfigValue(@RequestParam("comCode") String comCode, @RequestParam("riskCode") String riskCode, @RequestParam("configCode") String configCode) throws Exception;
	
	/**
	 * 根据主键（机构代码、险种代码、配置类型）查询配置结果ExtendValue的值
	 * @param comCode
	 * @param riskCode
	 * @param configCode
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getextendvalue", method = RequestMethod.POST)
    @ResponseBody
    String getExtendValue(@RequestParam("comCode") String comCode, @RequestParam("riskCode") String riskCode, @RequestParam("configCode") String configCode) throws Exception;

}
