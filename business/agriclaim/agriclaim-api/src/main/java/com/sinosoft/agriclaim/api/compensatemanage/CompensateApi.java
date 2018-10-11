package com.sinosoft.agriclaim.api.compensatemanage;



import java.util.List;
import java.util.Map;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import com.sinosoft.agriclaim.api.AgriClaimConstant;
import com.sinosoft.agriclaim.api.compensatemanage.dto.CompensatePageRequestDto;
import com.sinosoft.agriclaim.api.compensatemanage.dto.CompensatePageResponseDto;
import com.sinosoft.agriclaim.api.compensatemanage.dto.CompensateSaveInDto;
import com.sinosoft.agriclaim.api.compensatemanage.dto.PrpLCompeQueryInDto;
import com.sinosoft.agriclaim.api.compensatemanage.dto.PrpLCompensateDto;
import com.sinosoft.agriclaim.api.workflowmanage.dto.SwfLogExtendDto;
import com.sinosoft.framework.dto.PageInfo;

/**
 * @description 计算书服务提供类
 * @author 杨航
 * @date 2017年11月14日
 */
@FeignClient(name = AgriClaimConstant.AGRI_CLAIM_SERVICE_NAME, path = CompensateApi.PATH)
public interface CompensateApi {

	public static final String PATH = "compensate";

	/**
	  * @description 承保需要的服务,根据条件查询计算书信息集合
	  * @author 杨航
	  * @date 2017年11月14日 上午9:46:52
	  * @param prpLCompensateDto 计算书信息入参
	  * @return prpLCompensateDtoList
	 */
	@RequestMapping(value = "queryPrpLCompensateByCondition", method = RequestMethod.POST)
	public @ResponseBody List<PrpLCompensateDto> queryPrpLCompensateByCondition(@RequestBody PrpLCompensateDto prpLCompensateDto);

	/**
	 * @description 理算查询
	 * @author 闫磊
	 * @date 2017年11月24日 
	 * @param prpLCompeQueryInDto 查询入参对象
	 * @return pageInfo 工作流主表信息大对象
	 */
	@RequestMapping(value = "queryByCompeIn",method = {RequestMethod.POST})
	@ResponseBody PageInfo<SwfLogExtendDto> queryByCompeInDto(@RequestBody PrpLCompeQueryInDto prpLCompeQueryInDto)throws Exception;
	/**
	 * @description 理算暂存提交
	 * @author 闫磊
	 * @date 2017年12月8日 
	 * @param  compensateSaveInDto 获取主键的对象
	 * @return map 成功或者失败
	 */
	@RequestMapping(value = "saveSubmitBySaveIn",method = {RequestMethod.POST})
	Map<String,Object> saveSubmitBySave(@RequestBody CompensateSaveInDto compensateSaveInDto)throws Exception;
	
	/**
	 * @description:方法功能简述:理算页面初始化对外服务方法
	 * @author 安齐崇
	 * @date 2017年11月13日下午1:55:28
	 * @param requestDto 参数接收类
	 * @return responseDto 组装数据类
	 * @throws Exception 
	 */
	@RequestMapping(value = "compensatePageInit", method = RequestMethod.POST)
	@ResponseBody
	CompensatePageResponseDto compensatePageInit(@RequestBody CompensatePageRequestDto requestDto) throws Exception;

	/**
	 * （理算时重新生成危险单位）
	 * @author: 王志文
	 * @date: 2018/4/12 15:08
	 * @param compensateNo
	 * @throws Exception
	 */
	@RequestMapping(value = "getLDangerInfoNewC",method = {RequestMethod.POST})
	void getLDangerInfoNewC(@RequestParam("compensateNo") String compensateNo) throws Exception;
	/**
	 * （理算时生成危险单位）
	 * @author: 王志文
	 * @date: 2018/4/12 15:08
	 * @param prpLcompensateDto
	 * @throws Exception
	 */
	@RequestMapping(value = "getCDangerInfo",method = {RequestMethod.POST})
	public void getCDangerInfo (@RequestBody PrpLCompensateDto prpLcompensateDto) throws Exception;
}