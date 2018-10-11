package com.sinosoft.agriclaim.web.workflowmanage;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sinosoft.agriclaim.api.workflowmanage.WorkFlowRoveApi;
import com.sinosoft.agriclaim.api.workflowmanage.dto.PrpLWorkRovePageDto;
import com.sinosoft.agriclaim.api.workflowmanage.dto.QueryMyJobDetailDto;
import com.sinosoft.agriclaim.api.workflowmanage.dto.QueryMyJobSwfLogDto;
import com.sinosoft.agriclaim.core.workflowmanage.service.WorkFlowRoveService;
import com.sinosoft.framework.dto.PageInfo;

/**
 * @description 工作流转移服务
 * @author 闫磊
 * @date 2017年10月19日 下午3:53:49
 */
@RestController
@RequestMapping(value = WorkFlowRoveApi.PATH)
public class WorkFlowRoveController implements WorkFlowRoveApi {
	
	@Autowired
	private WorkFlowRoveService workFlowRoveService;
	
	/**
	 * @description 转交任务初始化页面
	 * @author 闫磊
	 * @date 2017年12月23日
	 * @param prpLWorkRovePageDto 主键字段所在的对象
	 * @return list 工作流主表信息对象
	 */
	@Override
	public List<PrpLWorkRovePageDto> turnPageByPrimary(@RequestBody List<PrpLWorkRovePageDto> prpLWorkRovePageDto){
		return workFlowRoveService.turnPageByPrimary(prpLWorkRovePageDto);
	}
	
	/**
	 * @description 转交任务提交
	 * @author 闫磊
	 * @date 2017年12月23日
	 * @param prpLWorkRovePageDto 转交对象
	 * @return map 成功或者失败
	 */
	@Override
	public Map<String,String> workRoveByRovePage(@RequestBody List<PrpLWorkRovePageDto> prpLWorkRovePageDto)throws Exception{
		return workFlowRoveService.workRoveByRovePage(prpLWorkRovePageDto);
	}
	
	/**
	 * @description 放弃任务
	 * @author 闫磊
	 * @date 2017年12月23日
	 * @param  prpLWorkRovePageDto 获取主键的对象
	 * @return map 成功或者失败
	 */
	@Override
	public Map<String,String> giveupTemporary(@RequestBody PrpLWorkRovePageDto prpLWorkRovePageDto)throws Exception{
		return workFlowRoveService.giveupTemporary(prpLWorkRovePageDto);
	}
	
	/**
	 * @description 个人任务查询
	 * @author 闫磊
	 * @date 2017年12月23日
	 * @return queryMyJobSwfLogDto 获取主键的对象
	 * @return list 成功或者失败
	 */
	@Override
	public List<QueryMyJobSwfLogDto> queryMyJob(@RequestBody QueryMyJobSwfLogDto queryMyJobSwfLogDto)throws Exception{
		return workFlowRoveService.queryMyJob(queryMyJobSwfLogDto);
	}
	
	/**
	 * @description 工作台任务详查
	 * @author 闫磊
	 * @param  queryMyJobDetailDto 入参信息
	 * @return list 返回的数据集合
	 */
	@Override
	public PageInfo queryMyJobDetail(@RequestBody QueryMyJobDetailDto queryMyJobDetailDto)throws Exception{
		return workFlowRoveService.queryMyJobDetail(queryMyJobDetailDto);
	}
}
