package com.sinosoft.agriclaim.web.schedulemanage;

import com.sinosoft.agriclaim.api.schedulemanage.ScheduleApi;
import com.sinosoft.agriclaim.api.schedulemanage.dto.*;
import com.sinosoft.agriclaim.core.schedulemanage.service.ScheduleService;
import com.sinosoft.framework.dto.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
/**
 * 调度接口操作API实现类
 * @author 马俊玲
 * @date 2017年12月12日 下午3:14:03
 */
@RestController
@RequestMapping(value = ScheduleApi.PATH)
public class ScheduleController  implements ScheduleApi {

    @Autowired
    private ScheduleService scheduleService;
   
    /**
	 * @description 系统内调度／改派
	 * @author 马俊玲
	 * @date 2017年10月27日
	 * @param
	 * @return
	 */
	@Override
	public @ResponseBody Map<String,String> scheduleSaveDeal(@RequestBody ScheduleSaveDto saveDto) throws Exception {
		return scheduleService.scheduleSaveDeal(saveDto);
	}
	/**
	 * @description 查询调度任务列表接口
	 * @param inParameterTaskSchedulingDto 查询调度任务列表接口入参大对象
	 * @return pageInfo 查询调度任务列表接口反参分页大对象
	 * @author 马俊玲
	 * @date 2017年10月27日 下午18:26
	 */
	@Override
	public @ResponseBody PageInfo<ScheduleQueryBackDto> querySchedulByCondition(@RequestBody InParameterSchedulDto inParameterTaskSchedulingDto) throws Exception{
	    PageInfo<ScheduleQueryBackDto> pageInfo = scheduleService.querySchedulByCondition(inParameterTaskSchedulingDto);
		return pageInfo;
	}

	/**
	 * @description 调度初始化信息查询接口
	 * @param schedulDetailInDto 调度初始化查询入参大对象
	 * @return schedulDetailOutDto 调度初始化查询出参大对象
	 * @author 马俊玲
	 * @throws Exception
	 * @date 2017年10月27日 下午13:58
	 */
	@Override
	public @ResponseBody SchedulDetailOutDto querySchedulDetail(@RequestBody SchedulDetailInDto taskSchedulingDetailedInDto) throws Exception {
		SchedulDetailOutDto taskSchedulingDetailedOutDto = scheduleService.querySchedulDetail(taskSchedulingDetailedInDto);
		return taskSchedulingDetailedOutDto;
	}

	@Override
	public Map<String, String> gisScheduleSaveDeal(@RequestBody AgriScheduleDto agriScheduleDto) throws Exception {
		Map<String,String> map=scheduleService.gisScheduleSaveDeal(agriScheduleDto);
		return map;
	}

}
