package com.sinosoft.agriclaim.core.businessutilmanage.service;

import com.sinosoft.agriclaim.api.businessutilmanage.dto.ClaimBoxInitRequestVo;
import com.sinosoft.agriclaim.api.businessutilmanage.dto.ClaimBoxInitResponseVo;

/**
 * @description: 类功能简述：下拉框复选框页面初始化服务接口
 * @author 安齐崇
 * @date 2017年12月9日下午4:50:27
 *
 */
public interface ClaimBoxInitService {
	/**@description:下拉框复选框初始化公共服务类
	 * @param requestDto
	 * @throws Exception
	 */
	public ClaimBoxInitResponseVo queryCommonData(ClaimBoxInitRequestVo requestDto) throws Exception;
}
