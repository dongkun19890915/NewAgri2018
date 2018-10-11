package com.sinosoft.agriclaim.core.claimmanage.service;


import com.sinosoft.agriclaim.api.claimmanage.dto.*;
import com.sinosoft.agriclaim.api.recasemanage.dto.UndwrtWriteBackReCaseDto;
import com.sinosoft.agriclaim.api.workflowmanage.dto.SwfLogExtendDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;
import java.util.Map;

/**
 * @description 立案服务接口类
 * @author 杨航
 * @date 2017年11月13日
 */
public interface ClaimService {

	/**
	 * @description 承保需要的服务,根据条件查询立案信息主表
	 * @author 杨航
	 * @date 2017年11月13日 下午7:40:23
	 * @param prpLClaimDto
	 *            立案信息对象
	 * @return prpLClaimDtoList 立案基本信息集合对象
	 */
	List<PrpLClaimDto> queryPrpLClaimByCondition(PrpLClaimDto prpLClaimDto);
	
	 /**
	    * 
	     * @description 立案环节提交
	     * @author yk
	     * @date 2017年12月8日 下午3:18:36
	     * @param claimDto
	     * @return 立案号
	    */
	Map<String, String> saveClaim(ClaimDto1 claimDto)throws Exception;

	
	/**
	 * @description:方法功能简述: 立案页面初始化服务接口
	 * @author 安齐崇
	 * @date 2017年11月16日下午2:25:58
	 * @param responseDto
	 * @return responseDto
	 * @throws Exception 
	 */
	ClaimPageInitResDto claimPageInit(ClaimPageInitReqDto requestDto) throws Exception;
	/**
	 * @description 立案查询入口
	 * @author 闫磊
	 * @date 2017年11月24日 
	 * @param prpLClaimQueryInDto 查询入参对象
	 * @return pageInfo 工作流主表信息大对象
	 */
	PageInfo<SwfLogExtendDto> queryByClaimInDto(PrpLClaimQueryInDto PrpLClaimQueryInDto) throws Exception;
	/**
	 * @description 申请注销／拒赔 获取申请信息
	 * @author 马俊玲
	 * @date 2017年11月21日 下午7:40:23
	 * @param claimCancelDtoList
	 * @return prpLClaimDtoList 申请注销／拒赔基本信息集合对象
	 */
	List<ClaimCancelDto> queryClaimCancelDetail(List<ClaimCancelDto> claimCancelDtoList);
	/**
	 * @description 申请注销／拒赔 获取申请信息
	 * @author 马俊玲
	 * @date 2017年11月21日 下午7:40:23
	 * @param claimCancleSubmitDtoList 申请注销／拒赔基本信息集合对象
	 * @return ResponseDto
	 */
	Map<String, String> claimCancelSubmit(List<ClaimCancleSubmitDto> claimCancleSubmitDtoList) throws Exception;

	/**
	 * @description:  调整估损金额
	 * @author 陈旭
	 * @date   2017-11-22 15:39:53.061
	 * @param  modifyDetailClaimDto
	 * @return
	 *
	 * @throw Exception
	 */

	Map<String, String> saveModify(ModifySaveClaimLossDto modifySaveClaimLossDto) throws Exception;

	/**
	 * （重新生成危险单位）
	 * @author: 王志文
	 * @date: 2018/4/11 18:20
	 * @param claimNo
	 * @throws Exception
	 */
	public void getLDangerInfoNewL(String claimNo)throws Exception;

	/**
	 * （生成危险单位）
	 * @author: 王志文
	 * @date: 2018/4/11 18:20
	 * @param prpLclaimDto
	 * @throws Exception
	 */
	public void getLDangerInfo(PrpLClaimDto prpLclaimDto)throws Exception;

	/**
	 * （立案页面生成危险单位查询）
	 * @author: 王志文
	 * @date: 2018/4/13 15:06
	 * @param registNo
	 * @param kindCode
	 * @return
	 * @throws Exception
	 */
	public DangerUnitBackDto makeDangerUnit(String registNo,String kindCode)throws Exception;

	/**
	 * （注销拒赔核赔通过回写方法）
	 * @author: 王志文
	 * @date: 2018/5/4 10:10
	 * @param undwrtWriteBackReCaseDto
	 * @return
	 * @throws Exception
	 */
	public String saveCancelBackByUndwrt(UndwrtWriteBackReCaseDto undwrtWriteBackReCaseDto) throws Exception;
}