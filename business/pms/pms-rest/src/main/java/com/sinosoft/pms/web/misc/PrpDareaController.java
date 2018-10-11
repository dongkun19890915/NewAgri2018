package com.sinosoft.pms.web.misc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sinosoft.pms.api.misc.PrpDareaApi;
import com.sinosoft.pms.api.misc.dto.PrpDareaDto;
import com.sinosoft.pms.core.misc.service.PrpDareaService;

/**
 * @description Darea表提供controller
 * @author 韩雨怀
 * @date 2017年12月23日 下午16:17:19
 */
@RestController
@RequestMapping(value = PrpDareaApi.PATH)
public class PrpDareaController implements PrpDareaApi{

	@Autowired
	private PrpDareaService prpDareaService;
	/**
     *@description 按主键查询实体
     *@param areaCode
     *@author 韩雨怀
     *@date 2017年12月20日 下午4:05:09
     */
	@Override
	@ResponseBody
	public PrpDareaDto queryByAreaCode(@RequestParam("areaCode")String areaCode) {
		return prpDareaService.queryByAreaCode(areaCode);
	}

}
