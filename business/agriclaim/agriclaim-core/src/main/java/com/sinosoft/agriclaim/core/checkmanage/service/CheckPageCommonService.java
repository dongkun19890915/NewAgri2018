package com.sinosoft.agriclaim.core.checkmanage.service;

import com.sinosoft.agriclaim.api.checkmanage.dto.PrpLcheckDtoExt;
import com.sinosoft.agriclaim.api.checkmanage.dto.PrpLverifyLossDtoExt;
import com.sinosoft.agriclaim.api.workflowmanage.dto.SwfPathDtoExt;

/**
 * @description: 类功能简述：公共服务类此服务通过判断，可以被查勘定损初始化ADD,EDIT,SHOW调用
 * @author 安齐崇
 * @date 2017年11月16日下午9:01:53
 */
public interface CheckPageCommonService {
	/**
	 * @description:方法功能简述: 根据报案号查询是否有查勘信息，若有说明已经进行过查询，直接查询，若没有从报案信息中获取
	 * @author 安齐崇
	 * @date 2017年11月16日下午9:22:20
	 * @param registNo 报案号
	 * @return prplCheckDtoExt 查勘扩展类
	 * @throws Exception 
	 */
	PrpLcheckDtoExt prepareCommonHeadParam(String registNo);

	/**
	 * @description:方法功能简述: 查询工作流可以用来选择的节点内容
	 * @author 安齐崇
	 * @date 2017年11月17日上午12:15:41
	 * @param modeNo 模板类型
	 * @param modeNo 节点类型
	 * @return pathDtoExt
	 */
	SwfPathDtoExt getSubmitNodes(String modelNo, String nodeNo);
	/**
	 * @description:方法功能简述: 根据报案号查询是否有核损信息，，若有说明已经有查勘信息，直接查询，若没有从报案信息中公共属性
	 * @author 安齐崇
	 * @date 2017年11月16日下午9:22:20
	 * @param registNo 报案号
	 * @return prpLverifyLossDtoExt 核损扩展类
	 */
	PrpLverifyLossDtoExt prepareCertainLossView(String registNo) throws Exception;
}