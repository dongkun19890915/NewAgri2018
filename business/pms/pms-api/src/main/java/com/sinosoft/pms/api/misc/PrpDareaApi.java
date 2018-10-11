package com.sinosoft.pms.api.misc;


import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sinosoft.pms.PMSConstant;
import com.sinosoft.pms.api.misc.dto.PrpDareaDto;

/**
 * @author 韩雨怀
 * @mail hanyuhuai@sinosoft.com.cn
 * @time  2017-12-22 15:01:46.546 
 * @description PrpDareaApi接口
 */
@FeignClient(name = PMSConstant.PMS_SERVICE_NAME, path = PrpDareaApi.PATH)
public interface PrpDareaApi {
	String PATH = "prpDareaApi";
	/**
     *@ 按主键查询实体
     *@param areaCode
     *@author 韩雨怀
     *@return PrpDareaDto对象
     *@date 2017年12月20日 下午4:05:09
     */
	 @RequestMapping(value = "queryByAreaCode",method = {RequestMethod.POST})
	 @ResponseBody PrpDareaDto queryByAreaCode(@RequestParam("areaCode") String areaCode);
}
