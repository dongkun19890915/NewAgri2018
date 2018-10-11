package com.sinosoft.pms.core.kernel.service;

import com.sinosoft.pms.api.kernel.dto.PrpDriskDto;
import com.sinosoft.pms.api.kernel.dto.RiskQueryConditionDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @description 险种接口服务service 
 * @author HSQ
 * @date 2017年9月4日 上午10:41:18
 */
public interface RiskService {

	/**
	 * @description 新增险种
	 * @param prpDriskDto
	 * @author HSQ
	 * @date 2017年9月4日 上午9:21:58
	 */
    String saveRisk(PrpDriskDto prpDriskDto) throws Exception;

	/**
	 * @description 删除险种
	 * @param riskCode
	 * @author HSQ
	 * @date 2017年9月4日 上午9:23:06
	 */
    String removeRisk(String riskCode) throws Exception;

	/**
	 * @description 修改险种
	 * @param prpDriskDto
	 * @author HSQ
	 * @date 2017年9月4日 上午9:23:22
	 */
    String modifyRisk(PrpDriskDto prpDriskDto) throws Exception;

	/**
	 * @description 按主键查询险种
	 * @param riskCode
	 * @return
	 * @author HSQ
	 * @date 2017年9月4日 上午9:23:40
	 */
    PrpDriskDto queryRiskByPK(String riskCode) throws Exception;

	/**
	 * @description 险种转译
	 * @param riskCode
	 * @param isChinese
	 * @return
	 * @author HSQ
	 * @date 2017年9月4日 上午9:35:28
	 */
    String translateCode(String riskCode, boolean isChinese) throws Exception;
	
	/**
	 * @description 根据条件查询险种
	 * @param riskQueryConditionDto
	 * @return
	 * @author HSQ
	 * @date 2017年9月4日 下午5:30:59
	 */
    List<PrpDriskDto> findRiskByCondition(RiskQueryConditionDto riskQueryConditionDto);

}