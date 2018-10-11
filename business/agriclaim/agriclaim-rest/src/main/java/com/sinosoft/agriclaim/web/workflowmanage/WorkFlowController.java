package com.sinosoft.agriclaim.web.workflowmanage;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sinosoft.agriclaim.api.workflowmanage.WorkFlowApi;
import com.sinosoft.agriclaim.api.workflowmanage.dto.InitSwfConditionsDto;
import com.sinosoft.agriclaim.api.workflowmanage.dto.InitSwfModelUseDto;
import com.sinosoft.agriclaim.api.workflowmanage.dto.SwfFlowMainDto;
import com.sinosoft.agriclaim.api.workflowmanage.dto.SwfModelMainDto;
import com.sinosoft.agriclaim.api.workflowmanage.dto.SwfModelUseSaveDto;
import com.sinosoft.agriclaim.api.workflowmanage.dto.WorkFlowModelDto;
import com.sinosoft.agriclaim.core.workflowmanage.service.WorkFlowService;
import com.sinosoft.framework.dto.PageInfo;

/**
 * @description 工作流服务
 * @author yanghang
 * @date 2017年10月19日 下午3:53:49
 */
@RestController
@RequestMapping(value = WorkFlowApi.PATH)
public class WorkFlowController implements WorkFlowApi {

	@Autowired
	private WorkFlowService workFlowService;

	/**
	 * @description 根据保单号查询工作流主表信息
	 * @author 杨航
	 * @date 2017年11月9日 下午3:02:46
	 * @param policyNo
	 * @return swfFlowMainDtoList 工作流主表信息集合
	 */
	public List<SwfFlowMainDto> querySwfFlowMainByPolicyNo(String policyNo) {
		return workFlowService.querySwfFlowMainByPolicyNo(policyNo);
	}
	
	/**
	  * @description 初始化批量分配模板所需数据
	  * @author 杨航
	  * @date 2017年11月9日 下午6:14:18
	  * @param
	  * @return 初始化批量分配模板所需数据Dto
	 */
	public InitSwfModelUseDto initSwfModelUseSave() throws Exception {
		return workFlowService.initSwfModelUseSave();
	}

	/**
	  * @description 工作流模板批量分配
	  * @author 杨航
	  * @date 2017年11月9日 下午6:16:20
	  * @param swfModelUseSaveDto
	  * @return entity
	 */
	public Map<String,String> saveSwfModelUse(@RequestBody SwfModelUseSaveDto swfModelUseSaveDto) {
		return workFlowService.saveSwfModelUse(swfModelUseSaveDto);
	}

	/**
	  * @description 工作流模板路径列表
	  * @author 杨航
	  * @date 2017年11月9日 下午6:19:34
	  * @param modelNo 模板号
	  * @return workFlowModelDto
	 */
	public WorkFlowModelDto initSwfModelPath(Integer modelNo) {
		return workFlowService.initSwfModelPath(modelNo);
	}

	/**
	  * @description 工作流路径条件维护页面初始化
	  * @author 杨航
	  * @date 2017年11月9日 下午6:20:41
	  * @param modelNo 
	  * @param pathNo 
	  * @param pathName 
	  * @return initSwfConditionsDto
	 */
	public InitSwfConditionsDto initSwfConditions(Integer modelNo, Integer pathNo, String pathName) {
		return workFlowService.initSwfConditions(modelNo,pathNo,pathName);
	}
	/**
	 * @description 初始化新建模板信息
	 * @author 杨航
	 * @date 2017年11月23日 下午4:42:51
	 * @return workFlowModelDto 初始化模板信息
	 */
	public WorkFlowModelDto initWorkFlowModel() {
		return workFlowService.initWorkFlowModel();
	}
	/**
	 * @description 按条件查询工作流模板主表信息
	 * @author 杨航
	 * @date 2017年11月17日 下午2:43:23
	 * @param swfModelMainDto 工作模板条件对象
	 * @return pageInfo 工作流模板Dto集合
	 */
	public @ResponseBody PageInfo<SwfModelMainDto> querySwfModelMainByCondition(@RequestBody SwfModelMainDto swfModelMainDto)throws Exception {
		return workFlowService.querySwfModelMainByCondition(swfModelMainDto);
	}

	/**
	 * @description 新建工作流模板
	 * @author 杨航
	 * @date 2017年11月17日 下午2:43:23
	 * @param workFlowModelDto 创建工作流模板所需对象
	 * @return result 返回信息
	 */
	@Override
	public Map<String,String> saveWorkFlowModelInfo(@RequestBody WorkFlowModelDto workFlowModelDto) throws Exception{
		return workFlowService.saveWorkFlowModelInfo(workFlowModelDto);
	}
	/**
	 * @description 修改模板信息初始化模板数据
	 * @author 杨航
	 * @date 2017年11月18日 下午2:13:23
	 * @param map 模板号对象
	 * @return workFlowModelDto 创建工作流模板所需对象
	 */
	@Override
	public WorkFlowModelDto modifyWorkFlowModelInfo(@RequestBody Map<String,String> map) {
		String modelNo = map.get("modelNo");
		return workFlowService.modifyWorkFlowModelInfo(Integer.parseInt(modelNo.trim()));
	}

}
