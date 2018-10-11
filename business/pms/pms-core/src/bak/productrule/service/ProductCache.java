/**
 *
 */
package com.sinosoft.pms.core.productrule.service;


import com.sinosoft.pms.api.productrule.dto.UtiDecisionDto;
import com.sinosoft.pms.api.productrule.dto.UtiFactorDto;
import com.sinosoft.pms.api.productrule.dto.UtiFormulaDto;

import java.util.List;

/**
 * @author 王志伟
 * @description 缓存处理，不提供外部服务
 * @date 2016年9月20日下午8:49:08
 */
public interface ProductCache {

    /**
     * @param cacheKey
     * @param outputList
     * @return
     * @description 放入缓存
     * @author 王志伟
     * @date 2016年9月20日下午8:55:25
     */
    List<UtiFactorDto> putCacheFactor(String cacheKey, List<UtiFactorDto> outputList);

    /**
     * @param factor
     * @description 获取缓存
     * @author 王志伟
     * @date 2016年9月20日下午9:01:50
     */
    List<UtiFactorDto> getCacheFactor(String factor);

    /**
     * @param string
     * @return
     * @description 获取缓存
     * @author 王志伟
     * @date 2016年9月20日下午11:11:28
     */
    List<UtiDecisionDto> getCacheDecision(String string);

    /**
     * @param string
     * @param outputList
     * @return
     * @description 放入缓存
     * @author 王志伟
     * @date 2016年9月20日下午11:11:34
     */
    List<UtiDecisionDto> putCacheDecision(String string, List<UtiDecisionDto> outputList);

    /**
     * @param cacheKey
     * @param output
     * @return
     * @description （用一句话描述这个方法是做什么的）
     * @author 王志伟
     * @date 2016年9月21日上午10:09:44
     */
    UtiFormulaDto putCacheFormula(String cacheKey, UtiFormulaDto output);

    /**
     * @param cacheKey
     * @return
     * @description （用一句话描述这个方法是做什么的）
     * @author 王志伟
     * @date 2016年9月21日上午10:09:56
     */
    UtiFormulaDto getCacheFormula(String cacheKey);

    /**
     * @description 清除公式缓存
     * @author zkr26
     * @date 2016年10月17日下午12:53:10
     */
    void clearFormulaCache();

    /**
     * @description 清除因子缓存
     * @author zkr26
     * @date 2016年10月17日下午12:53:10
     */
    void clearFactorCache();

    /**
     * @description 清除决策缓存
     * @author zkr26
     * @date 2016年10月17日下午12:53:10
     */
    void clearDecisionCache();

}
