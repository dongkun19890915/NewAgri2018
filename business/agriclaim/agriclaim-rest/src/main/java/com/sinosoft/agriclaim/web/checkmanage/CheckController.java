package com.sinosoft.agriclaim.web.checkmanage;

import java.util.Map;

import com.sinosoft.agriclaim.api.checkmanage.dto.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sinosoft.agriclaim.api.checkmanage.CheckApi;
import com.sinosoft.agriclaim.api.workflowmanage.dto.SwfLogExtendDto;
import com.sinosoft.agriclaim.core.checkmanage.service.CheckService;
import com.sinosoft.framework.dto.PageInfo;

/**
 * @description 查勘定损控制器
 * @author 杨航
 * @date 2017年11月13日
 */
@RestController
@RequestMapping(value = CheckController.PATH)
public class CheckController implements CheckApi {

    private static Logger LOGGER = LoggerFactory.getLogger(CheckController.class);

	@Autowired
	private CheckService checkService;
	 /**
	  * 查勘页面初始化 
	  * @author 安齐崇
	  * @date 2017年11月13日下午1:55:28
	  * @param requestDto 参数接收类
	  * @return responseDto 组装数据类
	 * @throws Exception 
	  */
	@Override
	public @ResponseBody CheckPageResponseDto checkPageInit(@RequestBody CheckPageRequestDto requestDto) throws Exception {
		return checkService.checkPageInit(requestDto);
	}
	
	/**
	 * 查勘定损查询入口
	 * @author 闫磊
	 * @date 2017年11月14日 
	 * @param prpLCheckQueryInDto 查询入参对象
	 * @return pageInfo 工作流主表信息大对象
	 */
	@Override
	public @ResponseBody PageInfo<SwfLogExtendDto> queryByCheckInDto(@RequestBody PrpLCheckQueryInDto prpLCheckQueryInDto) throws Exception{
		return checkService.queryByCheckInDto(prpLCheckQueryInDto);
	}
	
	/**
	  * 根据前端传送的dto进行查勘定损的暂存和提交
	  * @author 杨昆
	  * @date 2017年12月14日 下午11:09:13
	  * @param checkLossDto 查勘定损的大对象
	  * @return registNo 报案号
	  * @throws Exception 
	  */
	@Override
	public  Map<String, String> saveCheckLoss(@RequestBody CheckLossDto checkLossDto) throws Exception {
		return checkService.saveCheckLoss(checkLossDto);
	}
	/**
	 * @description 耳标号验证
	 * @author 马俊玲
	 * @date 2017年11月20日 下午3:14:03
	 * @param earNoCheckRequestDto
	 * #return EearNoCheckResponseDto
	 * @throws Exception
	 */
	@Override
	public @ResponseBody  EarNoCheckResponseDto earNoCheck(@RequestBody EarNoCheckRequestDto earNoCheckRequestDto) throws Exception {
		return checkService.earNoCheck(earNoCheckRequestDto);
	}
}
