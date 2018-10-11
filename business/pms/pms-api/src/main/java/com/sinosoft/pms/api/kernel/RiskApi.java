package com.sinosoft.pms.api.kernel;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sinosoft.pms.PMSConstant;
import com.sinosoft.pms.api.kernel.dto.PrpDriskDto;
import com.sinosoft.pms.api.kernel.dto.RiskQueryConditionDto;

/**
 * @description 险种接口服务api 
 * @author HSQ
 * @date 2017年9月4日 上午9:45:15
 */
@FeignClient(name = PMSConstant.PMS_SERVICE_NAME, path = RiskApi.PATH)
public interface RiskApi {

	String PATH = "risk";

	/**
	 * @description 新增险种
	 * @param prpDriskDto
	 * @author HSQ
	 * @date 2017年9月4日 上午9:21:58
	 */
	@RequestMapping(value = "saveRisk", method = { RequestMethod.POST })
    String saveRisk(@RequestBody PrpDriskDto prpDriskDto) throws Exception;

	/**
	 * @description 删除险种
	 * @param riskCode
	 * @author HSQ
	 * @date 2017年9月4日 上午9:23:06
	 */
	@RequestMapping(value = "removeRisk", method = { RequestMethod.POST })
    String removeRisk(@RequestParam(value = "riskCode") String riskCode) throws Exception;

	/**
	 * @description 修改险种
	 * @param prpDriskDto
	 * @author HSQ
	 * @date 2017年9月4日 上午9:23:22
	 */
	@RequestMapping(value = "modifyRisk", method = { RequestMethod.POST })
    String modifyRisk(@RequestBody PrpDriskDto prpDriskDto) throws Exception;

	/**
	 * @description 按主键查询险种
	 * @param riskCode
	 * @return
	 * @author HSQ
	 * @date 2017年9月4日 上午9:23:40
	 */
	@RequestMapping(value = "queryRiskByPK", method = { RequestMethod.POST })
    @ResponseBody PrpDriskDto queryriskByPK(@RequestParam(value = "riskCode") String riskCode) throws Exception;

	/**
	 * @description 险种转译
	 * @param riskCode
	 * @param isChinese
	 * @return
	 * @author HSQ
	 * @date 2017年9月4日 上午9:35:28
	 */
	@RequestMapping(value = "translateCode", method = { RequestMethod.POST })
    String translateCode(@RequestParam(value = "riskCode") String riskCode,
                         @RequestParam(value = "isChinese") boolean isChinese) throws Exception;

	/**
	 * @description 根据条件查询险种
	 * @param riskQueryConditionDto
	 * @return
	 * @author HSQ
	 * @date 2017年9月4日 下午5:30:59
	 */
	@RequestMapping(value = "findRiskByCondition", method = { RequestMethod.POST })
    @ResponseBody List<PrpDriskDto> findRiskByCondition(@RequestBody RiskQueryConditionDto riskQueryConditionDto);
	
}