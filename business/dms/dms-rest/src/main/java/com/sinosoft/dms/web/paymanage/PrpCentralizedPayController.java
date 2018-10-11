package com.sinosoft.dms.web.paymanage;

import com.sinosoft.dms.api.paymanage.PrpCentralizedPayApi;
import com.sinosoft.dms.api.paymanage.dto.PrpCentralizedPayInfoDto;
import com.sinosoft.dms.core.paymanage.service.PrpCentralizedPayService;
import com.sinosoft.framework.dto.PageInfo;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time 2017-11-21 08:39:47.289
 * @description PrpCentralizedPayInfocontroller层
 */
@RestController
@RequestMapping(value = PrpCentralizedPayController.PATH)
public class PrpCentralizedPayController implements PrpCentralizedPayApi {

	private static Logger LOGGER = LoggerFactory.getLogger(PrpCentralizedPayController.class);

	@Autowired
	private PrpCentralizedPayService prpCentralizedPayService;

	/**
	 * @description 新增
	 * @param
	 */
	public void save(@RequestBody PrpCentralizedPayInfoDto prpCentralizedPayInfoDto) {
		prpCentralizedPayService.save(prpCentralizedPayInfoDto);
	}

	/**
	 * @description 删除
	 * @param
	 */
	public void remove(@RequestBody String operateId) {
		prpCentralizedPayService.remove(operateId);
	}

	/**
	 * @description 修改
	 * @param
	 */
	public void modify(@RequestBody PrpCentralizedPayInfoDto prpCentralizedPayInfoDto) {
		prpCentralizedPayService.modify(prpCentralizedPayInfoDto);
	}

	/**
	 * @description 按主键查询实体
	 * @param
	 */
	public PrpCentralizedPayInfoDto queryByPK(@RequestBody String operateId) {
		return prpCentralizedPayService.queryByPK(operateId);
	}


}

