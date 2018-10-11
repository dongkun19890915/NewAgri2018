package com.sinosoft.agriclaim.core.registmanage.service;

import com.sinosoft.agriclaim.api.registmanage.dto.*;
import com.sinosoft.framework.dto.PageInfo;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time 2017-11-08 05:45:22.527
 * @description 报案信息补充说明Core接口
 */
public interface RegistService {

	/**
	 * @param prpLRegistDto 报案信息
	 * @return prpLRegistDtoList 报案信息集合
	 * @description 根据条件查询报案主表的信息
	 * @author 杨航
	 * @date 2017年11月20日 下午3:14:03
	 */
	List<PrpLRegistDto> queryPrpLRegistByCondition(PrpLRegistDto prpLRegistDto);


	/**
	 * @param requestDto
	 * @return
	 * @throws Exception
	 * @description 报案登记根据查询入参分页查询保单列表信息
	 * @author 杨成程
	 * @date 2017/11/09 15:00
	 */
	public PageInfo<ResponseQueryPolicyListInfoDto> queryPolicyListInfo(RequestQueryPolicyListInfoDto requestDto) throws Exception;

	/**
	 * @param requestDto 入参类
	 * @throws Exception
	 * @description:方法功能简述: 组织报案页面初始化参数
	 * @author 安齐崇
	 * @date 2017年11月14日下午5:24:46
	 */
	RegistPageResDto getPageInfo(RegistPageReqDto requestDto) throws Exception;

	/**
	 * @param requestDto 出险信息查询入参类
	 * @return responseDto 出险信息出参对象
	 * @description:方法功能简述: 出险信息查询
	 * @author 安齐崇
	 * @date 2017年11月13日下午9:38:52
	 */
	RiskInfoResponseDto findRiskInfo(String string);

	/**
	 * @return pageInfo
	 * @description 按条件查询报案任务
	 * @author 马俊玲
	 * @date 2017年8月28日 下午2:58:42
	 */
	public PageInfo<PrpLregistResponseDto> queryPrpLregistByCondition(PrpLregistQueryDto prpLregistQueryDTO) throws Exception;

	/**
	 * 查询已经报案的数据，计算出现次数来进行显示
	 *
	 * @param resultMap
	 * @param policyNo
	 * @param curRegistNo
	 * @author 马俊玲
	 */
	public void getSamePolicyRegistInfo(Map<String, Object> resultMap, String policyNo, String curRegistNo);

	/**
	 * 报案登记、提交
	 *
	 * @param registDto 报案大对象
	 * @return map 返参信息
	 * @throws Exception
	 * @author 杨昆
	 * @date 2017年10月28日下午12:53:31
	 */
	public Map<String, String> saveReport(ReportDto registDto) throws Exception;

	/**
	 * @param prpLRegistDto 报案拓展对象
	 * @return map 返参信息
	 * @description 根据传入进来的报案信息dto进行报案撤销
	 * @author 杨昆
	 * @date:2017年10月28日下午12:53:31
	 */
	public Map<String, String> cancelReport(PrpLRegistDtoExtend prpLRegistDto) throws Exception;

	/**
	 * 金禾调用的报案登记接口
	 *
	 * @param registDto 报案对象
	 * @return map 返参对象
	 * @throws Exception
	 * @author 王保良
	 * @date:2017年10月28日下午12:53:31
	 */
	public Map<String, String> gisSaveReport(@RequestBody AgriRegistDto agriRegistDto) throws Exception;

}

