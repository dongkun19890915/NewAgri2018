package com.sinosoft.agriclaim.api.checkmanage;

import java.util.Map;

import com.sinosoft.agriclaim.api.checkmanage.dto.*;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sinosoft.agriclaim.api.AgriClaimConstant;
import com.sinosoft.agriclaim.api.workflowmanage.dto.SwfLogExtendDto;
import com.sinosoft.framework.dto.PageInfo;

/**
 * @description 查勘定损服务对外提供类
 * @author 杨航
 * @date 2017年11月13日
 */
@FeignClient(name = AgriClaimConstant.AGRI_CLAIM_SERVICE_NAME, path = CheckApi.PATH)
public interface CheckApi {

	public static final String PATH = "check";

	/**
	 * @description:方法功能简述:查勘页面初始化
	 * @author 安齐崇
	 * @date 2017年11月13日下午1:55:28
	 * @param requestDto
	 *            参数接收类
	 * @return responseDto 组装数据类
	 * @throws Exception
	 */
	@RequestMapping(value = "checkPageInit", method = RequestMethod.POST)
	@ResponseBody
	CheckPageResponseDto checkPageInit(@RequestBody CheckPageRequestDto requestDto) throws Exception;

	/**
	 * @description 查勘定损查询入口
	 * @author 闫磊
	 * @date 2017年11月14日 
	 * @param prpLCheckQueryInDto 查询入参对象
	 * @return pageInfo 工作流主表信息大对象
	 */
	@RequestMapping(value = "queryByCheckIn",method = {RequestMethod.POST})
	@ResponseBody PageInfo<SwfLogExtendDto> queryByCheckInDto(@RequestBody PrpLCheckQueryInDto prpLCheckQueryInDto)throws Exception;
	
	/**
	 * @description 根据前端传送的dto进行查勘定损的暂存和提交
	 * @author 杨昆
	 * @date 2017年12月14日 下午11:02:44
	 * @param checkLossDto查勘定损的大对象
	 * @return registNo 报案号
	 * @throws Exception 
	 */
	@RequestMapping(value = "saveCheckLoss", method = { RequestMethod.POST })
	@ResponseBody
	Map<String, String> saveCheckLoss(@RequestBody CheckLossDto checkLossDto) throws Exception;
	/**
	 * @description 耳标号验证
	 * @author 马俊玲
	 * @date 2017年11月20日 下午3:14:03
	 * @param earNoCheckRequestDto
	 * @return EearNoCheckResponseDto
	 * @throws Exception
	 */
	@RequestMapping(value = "earNoCheck",method = {RequestMethod.POST})
	@ResponseBody
	EarNoCheckResponseDto earNoCheck(@RequestBody EarNoCheckRequestDto earNoCheckRequestDto) throws Exception;
}	