package com.sinosoft.agriclaim.core.compensatemanage.service;

import com.sinosoft.agriclaim.api.compensatemanage.dto.CompensatePageResponseDto;
import com.sinosoft.agriclaim.api.compensatemanage.dto.PrpCengageDtoExt;

import java.util.List;

/**
 * @description: 类功能简述：理算页面初始化公共服务接口
 * @author 安齐崇
 * @date 2017年11月30日下午7:47:40
 *
 */
public interface CompensatePageCommonService {
	/**
	 * @description:方法功能简述: 组织理算页面初始化头信息，设置到返参对象
	 * @author 安齐崇
	 * @date 2017年12月1日下午2:18:36
	 * @param responseDto 理算页面初始化返参对象
	 */
	void prePareCommonHead(CompensatePageResponseDto responseDto);
	/**
	 * @description:方法功能简述: 组织理算页面初始化公共信息，如特别约定，险种名称，机构的转换
	 * @author 安齐崇
	 * @date 2017年12月1日下午7:43:27
	 * @param requestDto 请求入参对象
	 */
	void prepareCommonParam(CompensatePageResponseDto responseDto);
	/**
	 * @description:方法功能简述:组织赔付标的信息
	 * @author 安齐崇
	 * @date 2017年12月2日下午2:58:58
	 * @param responseDto  返参对象
	 */
	void prepareCommonPrpLLoss(CompensatePageResponseDto responseDto);
	/**
	 * @description:方法功能简述: 组织文本信息，付款说明，赔款计算过程，理算报告
	 * @author 安齐崇
	 * @date 2017年12月3日上午11:27:12
	 * @param responseDto 返参对象
	 */
	void prepareCommonText(CompensatePageResponseDto responseDto);

	/**
	 * （获取特别约定）
	 * @author: 王志文
	 * @date: 2018/5/22 11:55
	 * @param responseDto
	 * @return
	 */
	public List<PrpCengageDtoExt> setPrpCengageText(CompensatePageResponseDto responseDto);
	/**
	 * @description:方法功能简述: 设置赔款费用信息
	 * @author 安齐崇
	 * @date 2017年12月3日下午2:47:25
	 * @param responseDto
	 */
	void prepareChargeFee(CompensatePageResponseDto responseDto);
	/**
	 * @description:方法功能简述: 设置结案报告信息
	 * @author 安齐崇
	 * @date 2017年12月3日下午11:07:39
	 * @param responseDto
	 */
	void prepareCaseReport(CompensatePageResponseDto responseDto);
	/**
	 * @description:方法功能简述: 设置支付对象信息
	 * @author 安齐崇
	 * @date 2017年12月3日下午11:07:39
	 * @param responseDto
	 */
	void prepareSumPay(CompensatePageResponseDto responseDto);
}
