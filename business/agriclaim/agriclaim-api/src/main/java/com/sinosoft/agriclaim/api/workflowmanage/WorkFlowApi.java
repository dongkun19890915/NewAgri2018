package com.sinosoft.agriclaim.api.workflowmanage;

import java.util.List;
import java.util.Map;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sinosoft.agriclaim.api.AgriClaimConstant;
import com.sinosoft.agriclaim.api.workflowmanage.dto.InitSwfConditionsDto;
import com.sinosoft.agriclaim.api.workflowmanage.dto.InitSwfModelUseDto;
import com.sinosoft.agriclaim.api.workflowmanage.dto.SwfFlowMainDto;
import com.sinosoft.agriclaim.api.workflowmanage.dto.SwfModelMainDto;
import com.sinosoft.agriclaim.api.workflowmanage.dto.SwfModelUseSaveDto;
import com.sinosoft.agriclaim.api.workflowmanage.dto.WorkFlowModelDto;
import com.sinosoft.framework.dto.PageInfo;

/**
 * @description 工作流服务
 * @author 杨航
 * @date 2017年10月19日 下午3:55:50
 */
@FeignClient(name = AgriClaimConstant.AGRI_CLAIM_SERVICE_NAME, path = WorkFlowApi.PATH)
public interface WorkFlowApi {

	public static final String PATH = "workflow";

	/**
	 * @description 根据保单号查询工作流主表信息
	 * @author 杨航
	 * @date 2017年11月9日 下午3:02:46
	 * @param policyNo
	 * @return swfFlowMainDtoList 工作流主表信息集合
	 */
	@RequestMapping(value = "querySwfFlowMainByPolicyNo", method = RequestMethod.POST)
	@ResponseBody
	List<SwfFlowMainDto> querySwfFlowMainByPolicyNo(@RequestParam(value = "policyNo") String policyNo);

	/**
	  * @description 初始化批量分配模板所需数据
	  * @author 杨航
	  * @date 2017年11月9日 下午6:14:18
	  * @param
	  * @throw Exception
	  * @return 初始化批量分配模板所需数据Dto
	 */
	@RequestMapping(value = "initSwfModelUseSave", method = RequestMethod.POST)
	@ResponseBody
	InitSwfModelUseDto initSwfModelUseSave() throws Exception;

	/**
	  * @description 工作流模板批量分配
	  * @author 杨航
	  * @date 2017年11月9日 下午6:16:20
	  * @param swfModelUseSaveDto
	  * @return entity
	 */
	@RequestMapping(value = "saveSwfModelUse", method = RequestMethod.POST)
	@ResponseBody
	Map<String,String> saveSwfModelUse(@RequestBody SwfModelUseSaveDto swfModelUseSaveDto);

	/**
	  * @description 工作流模板路径列表
	  * @author 杨航
	  * @date 2017年11月9日 下午6:19:34
	  * @param modelNo 模板号
	  * @return workFlowModelDto
	 */
	@RequestMapping(value = "initSwfModelPath", method = RequestMethod.POST)
	@ResponseBody
	WorkFlowModelDto initSwfModelPath(@RequestParam(value = "modelNo") Integer modelNo);

	/**
	  * @description 工作流路径条件维护页面初始化
	  * @author 杨航
	  * @date 2017年11月9日 下午6:20:41
	  * @param modelNo 
	  * @param pathNo 
	  * @param pathName 
	  * @return initSwfConditionsDto
	 */
	@RequestMapping(value = "initSwfConditions", method = RequestMethod.POST)
	@ResponseBody
	InitSwfConditionsDto initSwfConditions(@RequestParam(value = "modelNo") Integer modelNo,
			@RequestParam(value = "pathNo") Integer pathNo, @RequestParam(value = "pathName") String pathName);
	/**
	 * @description 初始化新建模板信息
	 * @author 杨航
	 * @date 2017年11月23日 下午4:42:51
	 * @return workFlowModelDto 初始化模板信息
	 */
	@RequestMapping(value = "initWorkFlowModel", method = RequestMethod.POST)
	@ResponseBody
	WorkFlowModelDto initWorkFlowModel();
	/**
	 * @description 按条件查询工作流模板主表信息
	 * @author 杨航
	 * @date 2017年11月17日 下午2:43:23
	 * @param swfModelMainDto 工作模板条件对象
	 * @return pageInfo 工作流模板Dto集合
	 */
	@RequestMapping(value = "querySwfModelMainByCondition", method = RequestMethod.POST)
	@ResponseBody
	PageInfo<SwfModelMainDto> querySwfModelMainByCondition(@RequestBody SwfModelMainDto swfModelMainDto) throws Exception;
	
	/**
	 * @description 新建工作流模板
	 * @author 杨航
	 * @date 2017年11月17日 下午2:43:23
	 * @param workFlowModelDto 创建工作流模板所需对象
	 * @return result 返回信息
	 */
	@RequestMapping(value = "saveWorkFlowModelInfo", method = RequestMethod.POST)
	@ResponseBody
	Map<String,String> saveWorkFlowModelInfo(WorkFlowModelDto workFlowModelDto) throws Exception;
	
	/**
	 * @description 修改模板信息初始化模板数据
	 * @author 杨航
	 * @date 2017年11月18日 下午2:13:23
	 * @param map 模板号对象
	 * @return workFlowModelDto 创建工作流模板所需对象
	 */
	@RequestMapping(value = "modifyWorkFlowModelInfo", method = RequestMethod.POST)
	@ResponseBody
	WorkFlowModelDto modifyWorkFlowModelInfo(@RequestBody Map<String,String> map);
	
}
