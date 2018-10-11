package com.sinosoft.agriclaim.core.workflowmanage.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.sinosoft.agriclaim.api.workflowmanage.dto.PrpLWorkRovePageDto;
import com.sinosoft.agriclaim.api.workflowmanage.dto.QueryMyJobDetailDto;
import com.sinosoft.agriclaim.api.workflowmanage.dto.QueryMyJobSwfLogDto;
import com.sinosoft.framework.dto.PageInfo;

/**
 * @description 工作流转移服务
 * @author 闫磊
 * @date 2017年12月23日 
 */
public interface WorkFlowRoveService {
	
	/**
	 * @description 转交任务初始化页面
	 * @author 闫磊
	 * @date 2017年12月23日
	 * @param prpLWorkRovePageDto 主键字段所在的对象
	 * @return list 工作流主表信息对象
	 */
	List<PrpLWorkRovePageDto> turnPageByPrimary(List<PrpLWorkRovePageDto> prpLWorkRovePageDto);
	
	/**
	 * @description 转交任务提交
	 * @author 闫磊
	 * @date 2017年12月23日
	 * @param prpLWorkRovePageDto 转交对象
	 * @return map 成功或者失败
	 */
	Map<String,String> workRoveByRovePage(List<PrpLWorkRovePageDto> prpLWorkRovePageDto)throws Exception;
	
	/**
	 * @description 放弃任务
	 * @author 闫磊
	 * @date 2017年12月23日
	 * @param  prpLWorkRovePageDto 获取主键的对象
	 * @return map 成功或者失败
	 */
	Map<String,String> giveupTemporary(PrpLWorkRovePageDto prpLWorkRovePageDto)throws Exception;
	
	/**
	 * @description 个人任务查询
	 * @author 闫磊
	 * @param  queryMyJobSwfLogDto 获取主键的对象
	 * @return list 成功或者失败
	 */
	List<QueryMyJobSwfLogDto> queryMyJob(QueryMyJobSwfLogDto queryMyJobSwfLogDto)throws Exception;
	
	/**
	 * @description 工作台任务详查
	 * @author 闫磊
	 * @param  QueryMyJobDetail 入参信息
	 * @return list 返回的数据集合
	 */
	PageInfo queryMyJobDetail(@RequestBody QueryMyJobDetailDto queryMyJobDetailDto)throws Exception;
}
