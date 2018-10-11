package com.sinosoft.agriclaim.core.claimmanage.service;

import com.sinosoft.agriclaim.api.claimmanage.dto.ClaimPageInitResDto;

/**
 * @description: 类功能简述：立案页面初始化相关服务接口
 * @author 安齐崇
 * @date 2017年11月25日下午4:16:09
 *
 */
public interface ClaimViewService {
	/**
	 * @description:方法功能简述: 组装立案头信息（立案头信息处理）
	 * @author 安齐崇
	 * @date 2017年11月25日下午3:51:47
	 * @param responseDto
	 *            立案登记组装返参类
	 */
	void prepareCommonHead(ClaimPageInitResDto responseDto);

	/**
	 * @description:方法功能简述:养殖险耳标号的处理，页面需要显示耳标号信息
	 * @author 安齐崇
	 * @date 2017年11月25日下午4:09:08
	 * @param responseDto
	 *            页面初始化类
	 */
	void prepareCompensateEar(ClaimPageInitResDto responseDto);

	/**
	 * @description:方法功能简述: 种植险有危险单位信息需要显示
	 * @author 安齐崇
	 * @date 2017年11月25日下午4:15:00
	 * @param responseDto
	 */
	void prepareDangerUnit(ClaimPageInitResDto responseDto);
    /**
     * @description:方法功能简述: 设置估损金额信息
     * @author 安齐崇
     * @date 2017年11月26日下午5:33:56
     * @param responseDto
     */
	void prepareCommonClaimLoss(ClaimPageInitResDto responseDto) throws Exception;
}
