package com.sinosoft.agriclaim.core.schedulemanage.service;

import com.sinosoft.agriclaim.api.schedulemanage.dto.*;
import com.sinosoft.framework.dto.PageInfo;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

/**
 * @author 马俊玲
 * @time 2017-10-25 05:53:05.936
 * @description 调度接口
 */
public interface ScheduleService {
	/**
	 * @description 系统内调度（插入）
	 * @param saveDto
	 * @return map
	 * @author 马俊玲
	 * @throws Exception
	 * @date 2017年11月30日 下午1:52
	 */
	public Map<String, String> scheduleSaveDeal(ScheduleSaveDto saveDto) throws Exception;

	/**
	 * @description 根据条件查询
	 * @param inParameterTaskSchedulingDto
	 * @return pageInfo
	 * @author zhangjin
	 * @throws Exception
	 * @date 2017年10月30日 下午1:52
	 */
	public PageInfo<ScheduleQueryBackDto> querySchedulByCondition(InParameterSchedulDto inParameterTaskSchedulingDto) throws Exception;
	/**
	 * @description 调度初始化接口
	 * @param schedulDetailInDto 调度初始化接口入参大对象
	 * @return schedulDetailOutDto 调度初始化接口出参大对象
	 * @author 马俊玲
	 * @throws Exception 
	 * @date 2017年10月30日 下午1:52
	 */
	SchedulDetailOutDto querySchedulDetail(SchedulDetailInDto schedulDetailInDto) throws Exception;


	public Map<String, String> gisScheduleSaveDeal(@RequestBody AgriScheduleDto agriScheduleDto) throws Exception ;

	}