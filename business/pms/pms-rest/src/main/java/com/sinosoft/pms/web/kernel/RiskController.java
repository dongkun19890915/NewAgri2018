package com.sinosoft.pms.web.kernel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sinosoft.pms.api.kernel.RiskApi;
import com.sinosoft.pms.api.kernel.dto.PrpDriskDto;
import com.sinosoft.pms.api.kernel.dto.RiskQueryConditionDto;
import com.sinosoft.pms.core.kernel.service.RiskService;

/**
 * @description 险种接口服务controller 
 * @author HSQ
 * @date 2017年9月5日 上午9:42:15
 */
@RestController
@RequestMapping(value = RiskApi.PATH)
public class RiskController implements RiskApi {
	
	@Autowired
	private RiskService riskService;

	/**
	 * @description 新增险种
	 * @param prpDriskDto
	 * @author HSQ
	 * @date 2017年9月4日 上午9:21:58
	 */
	@Override
	public String saveRisk(@RequestBody PrpDriskDto prpDriskDto) throws Exception {
		return riskService.saveRisk(prpDriskDto);
	}

	/**
	 * @description 删除险种
	 * @param riskCode
	 * @author HSQ
	 * @date 2017年9月4日 上午9:23:06
	 */
	@Override
	public String removeRisk(String riskCode) throws Exception {
		return riskService.removeRisk(riskCode);
	}

	/**
	 * @description 修改险种
	 * @param prpDriskDto
	 * @author HSQ
	 * @date 2017年9月4日 上午9:23:22
	 */
	@Override
	public String modifyRisk(@RequestBody PrpDriskDto prpDriskDto) throws Exception {
		return riskService.modifyRisk(prpDriskDto);
	}

	/**
	 * @description 按主键查询险种
	 * @param riskCode
	 * @return
	 * @author HSQ
	 * @date 2017年9月4日 上午9:23:40
	 */
	@Override
	public @ResponseBody PrpDriskDto queryriskByPK(String riskCode) throws Exception {
		return riskService.queryRiskByPK(riskCode);
	}

	/**
	 * @description 险种转译
	 * @param riskCode
	 * @param isChinese
	 * @return
	 * @author HSQ
	 * @date 2017年9月4日 上午9:35:28
	 */
	@Override
	public String translateCode(String riskCode, boolean isChinese) throws Exception {
		return riskService.translateCode(riskCode, isChinese);
	}

	/**
	 * @description 根据条件查询险种
	 * @param riskQueryConditionDto
	 * @return
	 * @author HSQ
	 * @date 2017年9月4日 下午5:30:59
	 */
	@Override
	public @ResponseBody List<PrpDriskDto> findRiskByCondition(@RequestBody RiskQueryConditionDto riskQueryConditionDto) {
		return riskService.findRiskByCondition(riskQueryConditionDto);
	}

}
