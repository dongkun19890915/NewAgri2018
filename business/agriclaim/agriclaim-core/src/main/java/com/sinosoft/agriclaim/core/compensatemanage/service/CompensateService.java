package com.sinosoft.agriclaim.core.compensatemanage.service;

import java.util.List;
import java.util.Map;

import com.sinosoft.agriclaim.api.compensatemanage.dto.CompensatePageRequestDto;
import com.sinosoft.agriclaim.api.compensatemanage.dto.CompensatePageResponseDto;
import com.sinosoft.agriclaim.api.compensatemanage.dto.CompensateSaveInDto;
import com.sinosoft.agriclaim.api.compensatemanage.dto.CompensateSubmitUndwrtXMLDto;
import com.sinosoft.agriclaim.api.compensatemanage.dto.PrpLCompeQueryInDto;
import com.sinosoft.agriclaim.api.compensatemanage.dto.PrpLCompensateDto;
import com.sinosoft.agriclaim.api.workflowmanage.dto.SwfLogExtendDto;
import com.sinosoft.framework.dto.PageInfo;

/**
 * @description 计算书业务接口类
 * @author 杨航
 * @date 2017年11月14日
 */
public interface CompensateService {

	/**
	  * @description 承保需要的服务,根据条件查询计算书信息集合
	  * @author 杨航
	  * @date 2017年11月14日 上午9:46:52
	  * @param prpLCompensateDto 计算书信息入参
	  * @return prpLCompensateDtoList
	 */
	List<PrpLCompensateDto> queryPrpLCompensateByCondition(PrpLCompensateDto prpLCompensateDto);
	
	/**
	 * @description 理算查询
	 * @author 闫磊
	 * @date 2017年11月24日 
	 * @param prpLCompeQueryInDto 查询入参对象
	 * @return pageInfo 工作流主表信息大对象
	 */
	public PageInfo<SwfLogExtendDto> queryByCompeInDto(PrpLCompeQueryInDto prpLCompeQueryInDto)throws Exception;

     /**
	 * @description 理算暂存提交
	 * @author 闫磊
	 * @date 2017年12月8日 
	 * @param  compensateSaveInDto 获取主键的对象
	 * @return map 成功或者失败
	 */
	Map<String,Object> saveSubmitBySaveIn(CompensateSaveInDto compensateSaveInDto)throws Exception;

	/**
	 * （理算提交双核实现方法）
	 * @author: 王志文
	 * @date: 2018/2/26 14:49
	 * @param compensateSaveInDto
	 * @return
	 * @throws Exception
	 */
	Map<String,Object> saveSubmitBySave(CompensateSaveInDto compensateSaveInDto)throws Exception;

	/**
	 * （理算提交双核）
	 * @author: 王志文
	 * @date: 2018/2/26 14:47
	 * @param compensateSaveInDto
	 * @param map
	 * @return
	 * @throws Exception
	 */
	Map<String,Object> readySubUndwrt(CompensateSaveInDto compensateSaveInDto,Map<String,Object> map) throws Exception;
	/**
	 * （理算书提交双核发送方法）
	 * @author: 王志文
	 * @date: 2018/1/15 16:00
	 * @param compensateSubmitUndwrtXMLDto 提交双核入参多想
	 * @return 提交成功信息
	 */
	Map<String,String> sendCompensateXMLToUndwrt(CompensateSubmitUndwrtXMLDto compensateSubmitUndwrtXMLDto)throws Exception;

	/**
	 * @description:方法功能简述:理算页面初始化接口
	 * @author 安齐崇
	 * @date 2017年11月30日下午4:48:53
	 * @param requestDto
	 *            入参dto
	 * @return responseDto 出参dto
	 * @throws Exception
	 */
	CompensatePageResponseDto compensatePageInit(CompensatePageRequestDto requestDto) throws Exception;

	/**
	 * （理算页面已注销拒赔列表查询）
	 * @author: 王志文
	 * @date: 2018/3/16 9:16
	 * @param prpLCompeQueryInDto
	 * @return
	 * @throws Exception
	 */
	public PageInfo<SwfLogExtendDto> queryCompensateCancelList(PrpLCompeQueryInDto prpLCompeQueryInDto)throws Exception;

	/**
	 * （理算时重新生成危险单位）
	 * @author: 王志文
	 * @date: 2018/4/12 15:08
	 * @param compensateNo
	 * @throws Exception
	 */
	public void getLDangerInfoNewC(String compensateNo) throws Exception;

	/**
	 * （理算时生成危险单位）
	 * @author: 王志文
	 * @date: 2018/4/12 15:08
	 * @param prpLcompensateDto
	 * @throws Exception
	 */
	public void getCDangerInfo(PrpLCompensateDto prpLcompensateDto) throws Exception;
}