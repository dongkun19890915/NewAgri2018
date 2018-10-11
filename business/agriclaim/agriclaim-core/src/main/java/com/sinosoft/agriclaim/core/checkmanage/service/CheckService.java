package com.sinosoft.agriclaim.core.checkmanage.service;


import java.util.Map;

import com.sinosoft.agriclaim.api.checkmanage.dto.*;
import com.sinosoft.agriclaim.api.workflowmanage.dto.SwfLogExtendDto;
import com.sinosoft.framework.dto.PageInfo;

/**
 * @description 查勘定损服务接口类
 * @author 杨航
 * @date 2017年11月13日
 */
public interface CheckService {
	/**
	 * 查勘登记页面初始化对内接口
	 * @author 安齐崇
	 * @date 2017年11月15日下午8:23:20
	 * @param requestDto 入参dto
	 * @return responseDto 出参dto
	 * @throws Exception 
	 */
	CheckPageResponseDto checkPageInit(CheckPageRequestDto requestDto) throws Exception;
    
	/**
	 * 查勘定损查询入口
	 * @author 闫磊
	 * @date 2017年11月14日 
	 * @param prpLCheckQueryInDto 查询入参对象
	 * @return pageInfo 工作流主表信息大对象
	 */
	PageInfo<SwfLogExtendDto> queryByCheckInDto(PrpLCheckQueryInDto prpLCheckQueryInDto) throws Exception;
	
	/**
	 * 查勘定损的暂存和提交
	 * @param: checkLossDto 查勘定损暂存、提交大对象
	 * @author: 杨昆
	 * @date:2017年10月28日下午1:07:09
	 * @return map 里面只有报案号
	 * @throws Exception 
	 */
	Map<String, String> saveCheckLoss(CheckLossDto checkLossDto) throws Exception;
	/**
	 * @description 耳标号验证
	 * @author 马俊玲
	 * @date 2017年11月20日 下午3:14:03
	 * @param earNoCheckRequestDto
	 * #return EearNoCheckResponseDto
	 * @throws Exception
	 */
	EarNoCheckResponseDto earNoCheck(EarNoCheckRequestDto earNoCheckRequestDto) throws Exception;

}