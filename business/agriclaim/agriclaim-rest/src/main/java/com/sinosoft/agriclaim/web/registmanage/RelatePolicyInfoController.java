package com.sinosoft.agriclaim.web.registmanage;

import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sinosoft.agriclaim.api.registmanage.RelatePolicyInfoApi;
import com.sinosoft.agriclaim.api.registmanage.dto.RelatePolicyInfoDto;
import com.sinosoft.agriclaim.core.registmanage.service.RelatePolicyInfoService;

/**
 * @author 陈旭
 * @time 2017-11-14 15:38:49.324
 * @description 保单关联信息controller层
 */
@RestController
@RequestMapping(value = RelatePolicyInfoController.PATH)
public class RelatePolicyInfoController implements RelatePolicyInfoApi {

	private static Logger LOGGER = LoggerFactory.getLogger(RelatePolicyInfoController.class);

	@Autowired
	private RelatePolicyInfoService relatePolicyInfoService;

	/**
	 * @description 显示保单关联信息
	 * @param policyNo
	 * @throws Exception
	 */
	@Override
	public RelatePolicyInfoDto showRelateInfo(@RequestBody Map<String, String> policyNoMap) throws Exception {
		return relatePolicyInfoService.showRelateInfo(policyNoMap);
	}

}
