package com.sinosoft.agriclaim.api.schedulemanage;

import com.sinosoft.agriclaim.api.AgriClaimConstant;
import com.sinosoft.agriclaim.api.schedulemanage.dto.*;
import com.sinosoft.framework.dto.PageInfo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;
/**
 * @description 调度服务API
 * @author 杨航
 * @date 2017年11月24日
 */
@FeignClient(name = AgriClaimConstant.AGRI_CLAIM_SERVICE_NAME, path = ScheduleApi.PATH)
public interface ScheduleApi {
	
	public static final String PATH = "schedule";

	/**
	 * 系统内调度／改派
	 * @author 马俊玲
	 * @date 2017年10月27日
	 * @param scheduleSaveDto 调度，改派入参大对象
	 * @return map 返参信息
	 * @throws Exception
	 */
	@RequestMapping(value = "scheduleSaveDeal", method = { RequestMethod.POST })
	@ResponseBody Map<String,String> scheduleSaveDeal(@RequestBody ScheduleSaveDto scheduleSaveDto) throws Exception;
	/**
     * 根据条件查询,显示调度列表功能
     * @param inParameterSchedulDto 调度列表查询入参对象
     * @return pageInfo 调度列表查询结果集
     * @author 马俊玲
     * @throws Exception
     * @date 2017年10月27日 下午5:31
     */
    @RequestMapping(value = "querySchedulByCondition", method = RequestMethod.POST)
    @ResponseBody PageInfo<ScheduleQueryBackDto> querySchedulByCondition(@RequestBody InParameterSchedulDto inParameterSchedulDto) throws Exception;

    /**
     * 调度的详询、改派、调度的页面初始化
     * @param schedulDetailInDto
     * @return schedulDetailOutDto
     * @author 马俊玲
     * @throws Exception
     * @date 2017年11月6日 下午13:30
     */
    @RequestMapping(value = "querySchedulDetail", method = RequestMethod.POST)
    @ResponseBody SchedulDetailOutDto querySchedulDetail(@RequestBody SchedulDetailInDto schedulDetailInDto) throws Exception;


	/**
	 * 系统内调度／改派
	 * @author 王保良
	 * @date 2017年10月27日
	 * @param scheduleSaveDto 调度，改派入参大对象
	 * @return map 返参信息
	 * @throws Exception
	 */
	@RequestMapping(value = "gisScheduleSaveDeal", method = { RequestMethod.POST })
	@ResponseBody Map<String,String> gisScheduleSaveDeal(@RequestBody AgriScheduleDto agriScheduleDto) throws Exception;
}
