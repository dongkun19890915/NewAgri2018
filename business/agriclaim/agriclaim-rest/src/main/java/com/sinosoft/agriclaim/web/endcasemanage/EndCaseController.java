package com.sinosoft.agriclaim.web.endcasemanage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sinosoft.agriclaim.api.endcasemanage.EndCaseApi;
import com.sinosoft.agriclaim.api.endcasemanage.dto.EndCaseDto;
import com.sinosoft.agriclaim.core.endcasemanage.service.EndCaseService;

/**
 * @author 周柯宇
 * @time  2017-12-02 
 * @description 赔案controller层
 */
@RestController
@RequestMapping(value = EndCaseController.PATH)
public class EndCaseController implements EndCaseApi{

	private static Logger LOGGER = LoggerFactory.getLogger(EndCaseController.class);

	@Autowired
	private EndCaseService endCseService;
	
	/**
	 *@author 周柯宇
	 *@time  2017-12-02
     *@description 按主键ClaimNo实体
     *@param 
     */
	@Override
	@ResponseBody
	public EndCaseDto findByClaimNo(@RequestParam("claimNo")String claimNo) {
		// TODO Auto-generated method stub
		EndCaseDto endCaseDto = endCseService.findByClaimNo(claimNo);
		return endCaseDto;
	}
	
	
}
