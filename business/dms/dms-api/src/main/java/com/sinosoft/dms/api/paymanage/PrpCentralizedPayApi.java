package com.sinosoft.dms.api.paymanage;

import com.sinosoft.dms.api.DMSConstant;
import com.sinosoft.dms.api.paymanage.dto.PrpCentralizedPayInfoDto;
import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.pms.PMSConstant;

import java.util.Map;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time 2017-11-21 08:39:47.289
 * @description PrpCentralizedPayInfoApi接口
 */
@FeignClient(name = DMSConstant.DMS_SERVICE_NAME, path = PrpCentralizedPayApi.PATH)
public interface PrpCentralizedPayApi {

	public static final String PATH = "prpCentralizedPay";

	/**
	 * @description 新增
	 * @param
	 */
	@RequestMapping(value = "save", method = { RequestMethod.POST })
	void save(PrpCentralizedPayInfoDto prpCentralizedPayInfoDto);

	/**
	 * @description 删除
	 * @param
	 */
	@RequestMapping(value = "remove", method = { RequestMethod.POST })
	void remove(String operateId);

	/**
	 * @description 修改
	 * @param
	 */
	@RequestMapping(value = "modify", method = { RequestMethod.POST })
	void modify(PrpCentralizedPayInfoDto prpCentralizedPayInfoDto);

	/**
	 * @description 按主键查询实体
	 * @param
	 */
	@RequestMapping(value = "queryByPK", method = { RequestMethod.POST })
	PrpCentralizedPayInfoDto queryByPK(String operateId);

}