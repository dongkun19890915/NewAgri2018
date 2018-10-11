package com.sinosoft.agriclaim.api.claimmanage;

import com.sinosoft.agriclaim.api.AgriClaimConstant;
import com.sinosoft.agriclaim.api.claimmanage.dto.*;
import com.sinosoft.agriclaim.api.recasemanage.dto.UndwrtWriteBackReCaseDto;
import com.sinosoft.agriclaim.api.workflowmanage.dto.SwfLogExtendDto;
import com.sinosoft.framework.dto.PageInfo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
/**
 * @description 立案对外提供服务类
 * @author 杨航
 * @date 2017年11月13日
 */
@FeignClient(name = AgriClaimConstant.AGRI_CLAIM_SERVICE_NAME, path = ClaimApi.PATH)
public interface ClaimApi {

    public static final String PATH = "claim";
    /**
	 * @description 承保需要的服务,根据条件查询立案信息主表
	 * @author 杨航
	 * @date 2017年11月13日 下午7:40:23
	 * @param prpLClaimDto
	 *            立案信息对象
	 * @return prpLClaimDtoList 立案基本信息集合对象
	 */
    @RequestMapping(value = "queryPrpLClaimByCondition",method = {RequestMethod.POST})
    @ResponseBody
    List<PrpLClaimDto> queryPrpLClaimByCondition(@RequestBody PrpLClaimDto prpLClaimDto);

    /**
     * 
      * @description 立案提交的保存立案信息
      * @author yk
      * @date 2017年12月8日 下午3:09:16
      * @param claimDto
      * @return map里面包含立案号
     */
    @RequestMapping(value = "saveClaim",method = {RequestMethod.POST})
    Map<String, String> saveClaim(@RequestBody ClaimDto1 claimDto)throws Exception;
    
    /**
     * @description:方法功能简述:根据页面参数组装页面参数
     * @author 安齐崇
     * @date 2017年11月21日下午2:19:28
     * @param requestDto 请求参数dto
     * @return responseDto 返回包含页面参数的传输对象dto
     * @throws Exception 
     * 
     */
    @RequestMapping(value = "claimPageInit",method = {RequestMethod.POST})
    @ResponseBody
    ClaimPageInitResDto claimPageInit(@RequestBody ClaimPageInitReqDto requestDto) throws Exception;
    
    
    /**
   	 * @description 立案查询入口
   	 * @author 闫磊
   	 * @date 2017年11月24日 
   	 * @param prpLClaimQueryInDto 查询入参对象
   	 * @return pageInfo 工作流主表信息大对象
   	 */
   	@RequestMapping(value = "queryByClaimIn",method = {RequestMethod.POST})
   	@ResponseBody PageInfo<SwfLogExtendDto> queryByClaimInDto(@RequestBody PrpLClaimQueryInDto prpLClaimQueryInDto)throws Exception;

	/**
	 * @description 申请注销／拒赔 获取申请信息
	 * @author 马俊玲
	 * @date 2017年11月21日 下午7:40:23
	 * @param strCondition sql片段
	 * @return prpLClaimDtoList 申请注销／拒赔基本信息集合对象
	 */
	@RequestMapping(value = "queryClaimCancelDetail",method = {RequestMethod.POST})
	public @ResponseBody List<ClaimCancelDto> queryClaimCancelDetail(@RequestBody List<ClaimCancelDto> claimCancelDtoList);
	/**
	 * @description 申请注销／拒赔 确认
	 * @author 马俊玲
	 * @date 2017年11月21日 下午7:40:23
	 * @param strCondition sql片段
	 * @return prpLClaimDtoList 申请注销／拒赔处理
	 */
	@RequestMapping(value = "claimCancelSubmit",method = {RequestMethod.POST})
	public @ResponseBody Map<String, String> claimCancelSubmit(@RequestBody List<ClaimCancleSubmitDto> claimCancleSubmitDtoList) throws Exception;

	/**
	 * @description: 保存立案估损信息
	 * @author 陈旭
	 * @date 2017-11-22 15:39:53.061
	 * @param modifySumClaimDto
	 * @return
	 * @throws UserException
	 * @throw Exception
	 */
	@RequestMapping(value = "saveModifyDetail", method = { RequestMethod.POST })
	@ResponseBody Map<String,String> saveModify(@RequestBody ModifySaveClaimLossDto modifySaveClaimLossDto)throws Exception;

	/**
	 * （重新生成危险单位）
	 * @author: 王志文
	 * @date: 2018/4/11 18:20
	 * @param claimNo
	 * @throws Exception
	 */
	@RequestMapping(value = "getLDangerInfoNewL",method = {RequestMethod.POST})
	void getLDangerInfoNewL(@RequestParam("claimNo") String claimNo)throws Exception;

	/**
	 * （生成危险单位）
	 * @author: 王志文
	 * @date: 2018/4/11 18:20
	 * @param prpLclaimDto
	 * @throws Exception
	 */
	@RequestMapping(value = "getLDangerInfo",method = {RequestMethod.POST})
	public void getLDangerInfo(@RequestBody PrpLClaimDto prpLclaimDto)throws Exception;

	/**
	 * （立案页面生成危险单位查询）
	 * @author: 王志文
	 * @date: 2018/4/13 15:06
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "makeDangerUnit",method = {RequestMethod.POST})
	public DangerUnitBackDto makeDangerUnit(@RequestBody Map<String,String> map)throws Exception;

	/**
	 * （注销拒赔核赔通过回写方法）
	 * @author: 王志文
	 * @date: 2018/5/4 10:10
	 * @param undwrtWriteBackReCaseDto
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "saveCancelBackByUndwrt",method = {RequestMethod.POST})
	public String saveCancelBackByUndwrt(@RequestBody UndwrtWriteBackReCaseDto undwrtWriteBackReCaseDto)throws Exception;
}