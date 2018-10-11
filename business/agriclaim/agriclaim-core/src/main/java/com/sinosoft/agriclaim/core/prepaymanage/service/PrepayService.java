package com.sinosoft.agriclaim.core.prepaymanage.service;


import java.util.List;
import java.util.Map;

import com.sinosoft.agriclaim.api.prepaymanage.dto.*;
import com.sinosoft.agriclaim.api.workflowmanage.dto.SwfLogExtendDto;
import com.sinosoft.framework.dto.PageInfo;

/**
 * @description 特殊赔案服务接口类
 * @author 杨航
 * @date 2017年11月14日
 */
public interface PrepayService {
	
	/**
	 * @description 承保需要的方法,根据条件查询PrpLPrepay
	 * @author 杨航
	 * @date 2017年11月13日 下午9:30:33
	 * @param prpLPrepayDto
	 *            特殊赔案信息
	 * @return prpLPrepayDtoList
	 */
	List<PrpLPrepayDto> queryPrpLPrepayByCondition(PrpLPrepayDto prpLPrepayDto);
	
	/**
	 * @description 特殊赔案查询
	 * @author 闫磊
	 * @date 2017年11月24日 
	 * @param prpLSpeciQueryInDto 查询入参对象
	 * @return pageInfo 工作流主表信息大对象
	 */
	PageInfo<SwfLogExtendDto> queryBySpeciInDto(PrpLSpeciQueryInDto prpLSpeciQueryInDto)throws Exception;

	/**
	 * @description 特殊赔案前置查询
	 * @author 闫磊
	 * @date 2017年12月11日 
	 * @param prpLSpeciQueryInDto 查询入参对象
	 * @return pageInfo 工作流主表信息大对象
	 */
	PageInfo<SwfLogExtendDto> queryByTurnSpeciInDto(PrpLSpeciQueryInDto prpLSpeciQueryInDto)throws Exception;
	
	/**
     * 
      * @description 特殊赔案申请提交
      * @author yk
      * @date 2017年12月14日 下午11:18:56
      * @param prepayApplicationDto 特殊赔案dto
      * @return String预赔号
     */
	Map<String, String>  savePrepayApplication(PrepayApplicationDto prepayApplicationDto);
	/**
     * @description:方法功能简述: 申请特殊赔案初始化服务方法
     * @author 安齐崇
     * @date 2017年12月16日下午6:08:14
     * @param requestDto
     * @return
     * @throws Exception 
     */
	SpecialCaseResDto specialCaseApplyInit(SpecialCaseReqDto requestDto) throws Exception;
	/**
	 * @description:方法功能简述: 组装特殊赔案页面初始化所需参数
	 * @author 安齐崇
	 * @date 2017年12月7日上午10:11:34
	 * @param requestDto
	 * @return
	 * @throws Exception 
	 */
	PrepayPageResDto prepayPageInit(PrepayPageReqDto requestDto) throws Exception;

	/**
     * 
      * @description 特殊赔案信息提交
      * @author yk
      * @date 2017年12月14日 下午11:18:56
      * @param prepayDto 特殊赔案dto
      * @return String预赔号
     */
	Map<String, String> savePrepay(PrepayDto prepayDto) throws Exception;

	/**
	 * （特殊赔案提交双核）
	 * @author: 王心洋
	 * @date: 2018/2/27
	 * @param prepaySubmitUndwrtXMLDto 提交双核入参
	 * @return 提交成功信息
	 */
	Map<String,String> sendPrepayXMLToUndwrt(PrepaySubmitUndwrtXMLDto prepaySubmitUndwrtXMLDto)throws Exception;
}