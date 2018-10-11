package com.sinosoft.agriclaim.core.workflowmanage.service;

import java.util.List;
import java.util.Map;

import com.sinosoft.agriclaim.api.workflowmanage.dto.InitSwfConditionsDto;
import com.sinosoft.agriclaim.api.workflowmanage.dto.InitSwfModelUseDto;
import com.sinosoft.agriclaim.api.workflowmanage.dto.SwfFlowMainDto;
import com.sinosoft.agriclaim.api.workflowmanage.dto.SwfLogDto;
import com.sinosoft.agriclaim.api.workflowmanage.dto.SwfLogTransferDto;
import com.sinosoft.agriclaim.api.workflowmanage.dto.SwfModelMainDto;
import com.sinosoft.agriclaim.api.workflowmanage.dto.SwfModelUseSaveDto;
import com.sinosoft.agriclaim.api.workflowmanage.dto.WorkFlowDto;
import com.sinosoft.agriclaim.api.workflowmanage.dto.WorkFlowModelDto;
import com.sinosoft.agriclaim.core.workflowmanage.entity.SwfModelMain;
import com.sinosoft.agriclaim.core.workflowmanage.entity.SwfNode;
import com.sinosoft.agriclaim.core.workflowmanage.entity.SwfPath;
import com.sinosoft.framework.dto.PageInfo;

/**
 * @description 工作流服务
 * @author yanghang
 * @date 2017年10月19日 下午3:54:24
 */
public interface WorkFlowService {
	/**
	 * @description 根据保单号查询工作流主表信息
	 * @author 杨航
	 * @date 2017年11月9日 下午3:02:46
	 * @param policyNo
	 * @return swfFlowMainDtoList 工作流主表信息集合
	 */
	List<SwfFlowMainDto> querySwfFlowMainByPolicyNo(String policyNo);
	/**
	 * @description 创建工作流
	 * @author 杨航
	 * @date 2017年11月9日 下午3:15:45
	 * @param workFlowDto 
	 * @return flowID
	 */
	String createFlow(WorkFlowDto workFlowDto);
	/**
	 * @description 获取模板号
	 * @author 杨航
	 * @date 2017年11月9日 下午3:16:54
	 * @param riskCode
	 * @param comCode
	 * @return modelNo
	 */
	int getModelNo(String riskCode, String comCode);
	/**
	 * @description 检查工作流是否关闭
	 * @author 杨航
	 * @date 2017年11月9日 下午3:21:13
	 * @param flowID
	 * @return true:已经关闭，false:没有关闭
	 */
	boolean checkFlowClose(String flowID);
	/**
	 * @description 工作流提交节点
	 * @author 杨航
	 * @date 2017年11月9日 下午3:25:11
	 * @param workFlowDto
	 * @return
	 */
	void submitNode(WorkFlowDto workFlowDto);
	/**
	 * @description 工作流修改节点信息
	 * @author 杨航
	 * @date 2017年11月9日 下午3:30:47
	 * @param workFlowDto
	 * @return
	 */
	void updateNode(WorkFlowDto workFlowDto);
	/**
	  * @description 关闭并转储工作流
	  * @author 杨航
	  * @date 2017年11月9日 下午3:34:38
	  * @param workFlowDto
	  * @return
	 */
	void closeAndStoreFlow(WorkFlowDto workFlowDto) throws Exception;
	
	/**
	  * @description 初始化批量分配模板所需数据
	  * @author 杨航
	  * @date 2017年11月9日 下午6:14:18
	  * @param
	  * @return 初始化批量分配模板所需数据Dto
	 */
	InitSwfModelUseDto initSwfModelUseSave() throws Exception;
	/**
	  * @description 工作流模板批量分配
	  * @author 杨航
	  * @date 2017年11月9日 下午6:16:20
	  * @param swfModelUseSaveDto
	  * @return entity
	 */
	Map<String,String> saveSwfModelUse(SwfModelUseSaveDto swfModelUseSaveDto);
	/**
	  * @description 工作流模板路径列表
	  * @author 杨航
	  * @date 2017年11月9日 下午6:19:34
	  * @param modelNo 模板号
	  * @return workFlowModelDto
	 */
	WorkFlowModelDto initSwfModelPath(Integer modelNo);
	/**
	  * @description 工作流路径条件维护页面初始化
	  * @author 杨航
	  * @date 2017年11月9日 下午6:20:41
	  * @param modelNo 
	  * @param pathNo 
	  * @param pathName 
	  * @return initSwfConditionsDto
	 */
	InitSwfConditionsDto initSwfConditions(Integer modelNo, Integer pathNo, String pathName);
	/**
	 * @description 初始化新建模板信息
	 * @author 杨航
	 * @date 2017年11月23日 下午4:42:51
	 * @return workFlowModelDto 初始化模板信息
	 */
	WorkFlowModelDto initWorkFlowModel();
	/**
	 * @description 按条件查询工作流模板主表信息
	 * @author 杨航
	 * @date 2017年11月17日 下午2:43:23
	 * @param swfModelMainDto 工作模板条件对象
	 * @return pageInfo 工作流模板Dto集合
	 */
	PageInfo<SwfModelMainDto> querySwfModelMainByCondition(SwfModelMainDto swfModelMainDto) throws Exception;
	/**
	 * @description 新建工作流模板
	 * @author 杨航
	 * @date 2017年11月17日 下午2:43:23
	 * @param workFlowModelDto 创建工作流模板所需对象
	 * @return result 返回信息
	 */
	Map<String,String> saveWorkFlowModelInfo(WorkFlowModelDto workFlowModelDto) throws Exception;
	/**
	  * @description 工作流处理流程主过程
	  * @author 杨航
	  * @date 2017年12月14日 下午3:57:18
	  * @param workFlowDto 工作流大对象
	  * @return
	 * @throws Exception 
	 */
	void deal(WorkFlowDto workFlowDto) throws Exception;

	/**
	 * @description 重开工作流
	 * @author 杨航
	 * @date 2017年12月14日 下午4:14:22
	 * @param workFlowDto
	 *            工作流大对象
	 * @return
	 * @throws Exception 
	 */
	void reOpenFlow(WorkFlowDto workFlowDto) throws Exception;
	/**
	  * @description 释放用户的占号信息
	  * @author 杨航
	  * @date 2017年12月14日 下午4:32:35
	  * @param workFlowDto
	  * @return 工作流大对象
	 */
	void freeAllHoldNode(WorkFlowDto workFlowDto) throws Exception;
	/**
	 * @description 回收工作流
	 * @author: 王志文
	 * @date: 2017/11/20 8:54
	 * @param workFlowDto 工作流Dto
	 * @throws Exception
	 */
	public void recycleFlow(WorkFlowDto workFlowDto) ;
	/**
	 * @description 关闭工作流
	 * @author: 王志文
	 * @date: 2017/11/20 8:55
	 * @param workFlowDto 工作流Dto
	 * @throws Exception
	 */
	void closeFlow(WorkFlowDto workFlowDto);
	/**
     * @description 按报案号删除所有的工作流
     * @author: 王志文
     * @date: 2017/11/18 18:44
     * @param registNo 报案号
     * @throws Exception
     */
	void deleteByRegistNo(String registNo);
	/**
	  * @description 对工作流进行占号操作
	  * @author 杨航
	  * @date 2017年12月14日 下午8:07:54
	  * @param flowID 流程代码
	  * @param logNo 节点代码
	  * @param userCode 用户代码
	  * @param userName 用户名称
	  * @return swfLogDto 工作流对象
	  */
	SwfLogDto holdNode(String flowID, int logNo, String userCode, String userName) ;
	/**
	 * 校验工作流DTO是不是合法可以处理的dto
	 * @author 杨昆
	 * @param workFlowDto 工作流对象
	 * @throws Exception
	 * @return boolean true-合法，false-不合法
	 */
	boolean checkDealDto(WorkFlowDto workFlowDto) ;
	/**
	 * @description 工作流入口
	 * @author 闫磊
	 * @date 2017年12月17日 
	 * @param  SwfLogTransferDto 工作流中转对象
	 * @return 
	 * */
	WorkFlowDto viewToDto(SwfLogTransferDto swfLogTransferDto);
	/**
	 * @description 修改模板信息初始化模板数据
	 * @author 杨航
	 * @date 2017年11月18日 下午2:13:23
	 * @param modelNo 模板号
	 * @return workFlowModelDto 创建工作流模板所需对象
	 */
	WorkFlowModelDto modifyWorkFlowModelInfo(Integer modelNo);
	/**
	 * @description:方法功能简述: 为防止两个人同时操作同一个待处理的理算任务，临时写了实赔结点
	 * @author 安齐崇
	 * @date 2017年12月8日上午10:28:54
	 * @param flowID
	 * @param logNo
	 * @param userCode
	 * @param userName
	 */
	void avoidUpdateSampCompe(String flowID,int logNo,String userCode,String userName);

}
