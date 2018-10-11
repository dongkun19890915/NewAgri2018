package com.sinosoft.agriclaim.api.registmanage;

import com.sinosoft.agriclaim.api.AgriClaimConstant;
import com.sinosoft.agriclaim.api.registmanage.dto.*;
import com.sinosoft.framework.dto.PageInfo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @description 报案服务
 * @author 杨航
 * @date 2017年11月20日
 */
@FeignClient(name = AgriClaimConstant.AGRI_CLAIM_SERVICE_NAME, path = RegistApi.PATH)
public interface RegistApi {

    public static final String PATH = "regist";

    /**
      * @description 根据条件查询报案主表的信息
      * @author 杨航
      * @date 2017年11月20日 下午3:14:03
      * @param prpLRegistDto 报案信息
      * @return prpLRegistDtoList 报案信息集合
      */
    @RequestMapping(value = "queryPrpLRegistByCondition",method = {RequestMethod.POST})
    @ResponseBody
    List<PrpLRegistDto> queryPrpLRegistByCondition(@RequestBody PrpLRegistDto prpLRegistDto);
    
	/**
	 * @description 报案登记根据查询入参分页查询保单列表信息
	 * @author 杨成程
	 * @date 2017/11/09 15:00
	 * @param requestDto
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "queryPolicyListInfo", method = { RequestMethod.POST })
	@ResponseBody
	PageInfo<ResponseQueryPolicyListInfoDto> queryPolicyListInfo(@RequestBody RequestQueryPolicyListInfoDto requestDto)
			throws Exception;
	/**
	 * @description:方法功能简述: 报案登记页面初始化
	 * @author 安齐崇
	 * @date 2017年11月22日下午7:22:52
	 * @param requestDto 封装入参的传输对象
	 * @return responseDto 包含出参数据传输对象
	 * @throws Exception 
	 * 
	 */
	@RequestMapping(value = "registPageInit", method = RequestMethod.POST)
	@ResponseBody
    RegistPageResDto registPageInit(@RequestBody RegistPageReqDto requestDto) throws Exception;
	/**
	 * @description:方法功能简述: 出险次数信息详细查询
	 * @author 安齐崇
	 * @date 2017年11月28日下午6:09:35
	 * @param policyNo 保单号
	 * @return responseDto 返参dto
	 */
	@RequestMapping(value = "queryPerilInfo", method = RequestMethod.POST)
	@ResponseBody 
	RiskInfoResponseDto queryPerilInfo(@RequestBody Map<String,String>  map);
	/**
     * @description 按条件查询报案任务
     * @author 马俊玲
     * @param prpLregistQueryDto
     * @return pageInfo
     * @throws Exception
     * @date 2017－11－10
     */
    @RequestMapping(value = "queryPrpLregistList", method = RequestMethod.POST)
    public @ResponseBody PageInfo<PrpLregistResponseDto> queryPrpLregistList( @RequestBody PrpLregistQueryDto prpLregistQueryDto) throws Exception;
    
    /**
	 * 报案暂存、提交
	 * @param:reportDto 报案大对象
	 * @return: map
	 * @author: 杨昆
	 * @throws Exception 
	 * @date:2017年10月28日下午12:53:31
	 */
	@RequestMapping(value = "saveReport", method = RequestMethod.POST)
	@ResponseBody Map<String,String> saveReport(@RequestBody ReportDto registDto) throws Exception;

	/**
	 * 报案撤销
	 * @param:报案号
	 * @throws:Exception
	 * @author: 杨昆
	 * @date:2017年10月28日下午12:53:31
	 * @return: map
	 */
	@RequestMapping(value = "cancelReport", method = RequestMethod.POST)
	public Map<String,String> cancelReport(@RequestBody PrpLRegistDtoExtend prpLRegistDto) throws Exception;

	/**
	 * 报案暂存、提交
	 * @param:reportDto 报案大对象
	 * @return: map
	 * @author: 王保良
	 * @throws Exception
	 * @date:2017年10月28日下午12:53:31
	 */
	@RequestMapping(value = "gisSaveReport",method = RequestMethod.POST)
	@ResponseBody Map<String,String> gisSaveReport(@RequestBody AgriRegistDto agriRegistDto)throws Exception;
}