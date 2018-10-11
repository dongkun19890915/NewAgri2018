package com.sinosoft.agriclaim.web.claimmanage;

import com.sinosoft.agriclaim.api.claimmanage.ClaimApi;
import com.sinosoft.agriclaim.api.claimmanage.dto.*;
import com.sinosoft.agriclaim.api.recasemanage.dto.UndwrtWriteBackReCaseDto;
import com.sinosoft.agriclaim.api.workflowmanage.dto.SwfLogExtendDto;
import com.sinosoft.agriclaim.core.claimmanage.service.ClaimService;
import com.sinosoft.framework.dto.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @description 立案控制器类
 * @author 杨航
 * @date 2017年11月13日
 */
@RestController
@RequestMapping(value = ClaimController.PATH)
public class ClaimController implements ClaimApi {

    private static Logger LOGGER = LoggerFactory.getLogger(ClaimController.class);

    @Autowired
    private ClaimService claimService;

    /**
	 * @description 承保需要的服务,根据条件查询立案信息主表
	 * @author 杨航
	 * @date 2017年11月13日 下午7:40:23
	 * @param prpLClaimDto
	 *            立案信息对象
	 * @return prpLClaimDtoList 立案基本信息集合对象
	 */
	public @ResponseBody List<PrpLClaimDto> queryPrpLClaimByCondition(@RequestBody PrpLClaimDto prpLClaimDto) {
		return claimService.queryPrpLClaimByCondition(prpLClaimDto);
	}

	@Override
	public Map<String, String> saveClaim(@RequestBody ClaimDto1 claimDto)throws Exception {
		return claimService.saveClaim(claimDto);
	}
	

	/**
	 * @description:方法功能简述:根据页面参数组装页面参数
	 * @author 安齐崇
	 * @date 2017年11月21日下午2:19:28
	 * @param requestDto
	 *            请求参数dto
	 * @return responseDto 返回包含页面参数的传输对象dto
	 * @throws Exception
	 */
	@Override
	public @ResponseBody ClaimPageInitResDto claimPageInit(@RequestBody ClaimPageInitReqDto requestDto)
			throws Exception {
		return claimService.claimPageInit(requestDto);
	}
	
	/**
	 * @description 立案查询入口
	 * @author 闫磊
	 * @date 2017年11月24日 
	 * @param prpLClaimQueryInDto 查询入参对象
	 * @return pageInfo 工作流主表信息大对象
	 */	
	@Override
	public @ResponseBody PageInfo<SwfLogExtendDto> queryByClaimInDto(@RequestBody PrpLClaimQueryInDto PrpLClaimQueryInDto)throws Exception{
		return claimService.queryByClaimInDto(PrpLClaimQueryInDto);
	}

	/**
	 * @description 申请注销／拒赔 获取申请信息
	 * @author 马俊玲
	 * @date 2017年11月21日 下午7:40:23
	 * @param strCondition sql片段
	 * @return prpLClaimDtoList 申请注销／拒赔基本信息集合对象
	 */
	public @ResponseBody List<ClaimCancelDto> queryClaimCancelDetail(@RequestBody List<ClaimCancelDto> claimCancelDtoList){
		return claimService.queryClaimCancelDetail(claimCancelDtoList);
	}
	/**
	 * @description 申请注销／拒赔 确认
	 * @author 马俊玲
	 * @date 2017年11月21日 下午7:40:23
	 * @return prpLClaimDtoList 申请注销／拒赔处理
	 */
	public @ResponseBody Map<String,String> claimCancelSubmit(@RequestBody List<ClaimCancleSubmitDto> claimCancleSubmitDtoList) throws Exception{
		return claimService.claimCancelSubmit(claimCancleSubmitDtoList);
	}

	/**
	 * @description:  调整估损金额
	 * @author 陈旭
	 * @date   2017-11-22 15:39:53.061
	 * @param  modifySumClaimDto
	 * @return
	 * @throws UserException
	 * @throw Exception
	 */

	@Override
	public Map<String, String> saveModify(@RequestBody ModifySaveClaimLossDto modifySaveClaimLossDto)throws Exception{

		return claimService.saveModify( modifySaveClaimLossDto);
	}

	/**
	 * （生成危险单位）
	 * @author: 王志文
	 * @date: 2018/4/11 18:20
	 * @param claimNo
	 * @throws Exception
	 */
	@Override
	public void getLDangerInfoNewL(@RequestParam("claimNo") String claimNo)throws Exception{
		claimService.getLDangerInfoNewL(claimNo);
	}

	@Override
	public void getLDangerInfo(@RequestBody PrpLClaimDto prpLclaimDto)throws Exception{
		claimService.getLDangerInfo(prpLclaimDto);
	}

	/**
	 * （立案页面生成危险单位查询）
	 * @author: 王志文
	 * @date: 2018/4/13 15:06
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public DangerUnitBackDto makeDangerUnit(@RequestBody Map<String,String> map)throws Exception{
		String registNo = map.get("registNo");
		String kindCode = map.get("kindCode");
		return claimService.makeDangerUnit(registNo,kindCode);
	}

	/**
	 * （注销拒赔核赔通过回写方法）
	 * @author: 王志文
	 * @date: 2018/5/4 10:10
	 * @param undwrtWriteBackReCaseDto
	 * @return
	 * @throws Exception
	 */
	@Override
	public String saveCancelBackByUndwrt(@RequestBody UndwrtWriteBackReCaseDto undwrtWriteBackReCaseDto) throws Exception {
		return claimService.saveCancelBackByUndwrt(undwrtWriteBackReCaseDto);
	}
}
