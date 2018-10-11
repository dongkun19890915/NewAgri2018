/**
 * 
 */
package com.sinosoft.pms.core.productrule.service;

import com.sinosoft.pms.api.productrule.dto.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @description 查询产品配置信息接口
 * @author 王志伟
 * @date 2016年9月17日上午9:57:04
 */
public interface ProductService {

	/**
	 * @description 查找产品配置的计算公式
	 * @param input
	 * @return
	 * @author 王志伟
	 * @date 2016年9月17日上午10:41:35
	 */
	@RequestMapping(value = "/getPremiumFormula", method = RequestMethod.POST)
    UtiFormulaDto getPremiumFormula(UtiFormulaConditionDto input) throws Exception;

	/**
	 * @description 查找产品配置的因子,分子因子要查询出关联原子因子的信息
	 * @param input
	 * @return
	 * @author 王志伟
	 * @date 2016年9月17日下午2:07:53
	 */
	@RequestMapping(value = "/getPremiumFactorList", method = RequestMethod.POST)
	List<UtiFactorDto> getPremiumFactorList(UtiFactorConditionDto input) throws Exception;

	/**
	 * @description 根据分子因子拆分出的原子因子的值，获取配置的分子因子值
	 * @param input
	 * @return
	 * @author 王志伟
	 * @date 2016年9月18日下午1:49:42
	 */
	@RequestMapping(value = "/getPremiumDecisionList", method = RequestMethod.POST)
	List<UtiDecisionDto> getPremiumDecisionList(UtiDecisionConditionDto input) throws Exception;

}
