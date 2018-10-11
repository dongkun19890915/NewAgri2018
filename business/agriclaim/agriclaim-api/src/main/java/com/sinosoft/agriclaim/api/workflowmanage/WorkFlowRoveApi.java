package com.sinosoft.agriclaim.api.workflowmanage;

import java.util.List;
import java.util.Map;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sinosoft.agriclaim.api.AgriClaimConstant;
import com.sinosoft.agriclaim.api.workflowmanage.dto.PrpLWorkRovePageDto;
import com.sinosoft.agriclaim.api.workflowmanage.dto.QueryMyJobDetailDto;
import com.sinosoft.agriclaim.api.workflowmanage.dto.QueryMyJobSwfLogDto;
import com.sinosoft.framework.dto.PageInfo;

/**
 * @description 工作流转移服务
 * @author 闫磊
 * @date 2017年10月19日 下午3:55:50
 */
@FeignClient(name = AgriClaimConstant.AGRI_CLAIM_SERVICE_NAME, path = WorkFlowApi.PATH)
public interface WorkFlowRoveApi {

	public static final String PATH = "workflowRove";
	
	/**
	 * @description 转交任务初始化页面
	 * @author 闫磊
	 * @date 2017年12月23日
	 * @param prpLWorkRovePageDto 主键字段所在的对象
	 * @return list 工作流主表信息对象
	 */
	@RequestMapping(value = "turnPageByPrimary",method = {RequestMethod.POST})
	@ResponseBody List<PrpLWorkRovePageDto> turnPageByPrimary(@RequestBody List<PrpLWorkRovePageDto> prpLWorkRovePageDto);
	
	/**
	 * @description 转交任务提交
	 * @author 闫磊
	 * @date 2017年12月23日
	 * @param prpLWorkRovePageDto 转交对象
	 * @return map 成功或者失败
	 */
	@RequestMapping(value = "workRoveByRovePage",method = {RequestMethod.POST})
	@ResponseBody
	Map<String,String> workRoveByRovePage(@RequestBody List<PrpLWorkRovePageDto> prpLWorkRovePageDto)throws Exception;
	
	/**
	 * @description 放弃任务
	 * @author 闫磊
	 * @date 2017年12月23日
	 * @param  prpLWorkRovePageDto 获取主键的对象
	 * @return map 成功或者失败
	 */
	@RequestMapping(value = "giveupTemporary",method = {RequestMethod.POST})
	@ResponseBody
	Map<String,String> giveupTemporary(@RequestBody PrpLWorkRovePageDto prpLWorkRovePageDto)throws Exception;
	
	/**
	 * @description 个人任务查询
	 * @author 闫磊
	 * @param  queryMyJobSwfLogDto 入参信息
	 * @return list 返回的数据集合
	 */
	@RequestMapping(value = "queryMyJob",method = {RequestMethod.POST})
	@ResponseBody
	List<QueryMyJobSwfLogDto> queryMyJob(@RequestBody QueryMyJobSwfLogDto queryMyJobSwfLogDto)throws Exception;
	
	/**
	 * @description 工作台任务详查
	 * @author 闫磊
	 * @param  queryMyJobDetailDto 入参信息
	 * @return list 返回的数据集合
	 */
	@RequestMapping(value = "queryMyJobDetail",method = {RequestMethod.POST})
	@ResponseBody
	PageInfo queryMyJobDetail(@RequestBody QueryMyJobDetailDto queryMyJobDetailDto)throws Exception;
	
}
