package com.sinosoft.agriclaim.core.registmanage.service;

import com.sinosoft.agriclaim.api.registmanage.dto.RegistDto;

/**
 * @description: 类功能简述：根据报案号查询报案登记大对象<p>
 * @author chong
 * @date 2017年11月9日下午11:30:20
 */
public interface RegistDataService {
	/**
	 * @description:方法功能简述: 根据报案号查询报案相关的大对象
	 * @author chong
	 * @date 2017年11月9日下午11:31:05
	 * @param registNo 报案号
	 * @return registDto
	 */
	RegistDto findRegistDtoByRegistNo(String registNo);
}
