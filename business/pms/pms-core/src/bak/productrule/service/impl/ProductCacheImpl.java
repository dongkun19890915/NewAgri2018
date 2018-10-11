/**
 * 
 */
package com.sinosoft.pms.core.productrule.service.impl;

import com.sinosoft.pms.core.productrule.service.ProductCache;
import com.sinosoft.pms.api.productrule.dto.UtiDecisionDto;
import com.sinosoft.pms.api.productrule.dto.UtiFactorDto;
import com.sinosoft.pms.api.productrule.dto.UtiFormulaDto;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description 缓存处理实现类
 * @author 王志伟
 * @date 2016年9月20日下午8:49:47
 */
@Service
public class ProductCacheImpl implements ProductCache {

    /**
     * 构造方法
     */
    public ProductCacheImpl() {

    }

    /**
     * @description 单元测试
     * @param args
     * @author 王志伟
     * @date 2016年9月20日下午8:49:47
     */
    public static void main(String[] args) {


    }

    /*
     * (non-Javadoc)
     * @see
     * ProductCache#putCacheFactor(java.lang.
     * String, java.util.List)
     */
    @Override
    @CachePut(value = "UtiFactorDto", key = "caches[0].name+'.'+args[0]")
    public List<UtiFactorDto> putCacheFactor(String cacheKey, List<UtiFactorDto> outputList) {
        return outputList;
    }

    /*
     * (non-Javadoc)
     * @see
     * ProductCache#getCacheFactor(java.lang.
     * String)
     */
    @Override
    @Cacheable(value = "UtiFactorDto", key = "caches[0].name+'.'+args[0]")
    public List<UtiFactorDto> getCacheFactor(String factor) {

        return null;
    }

    /*
     * (non-Javadoc)
     * @see
     * ProductCache#getCacheDecision(java.lang.
     * String)
     */
    @Override
    @Cacheable(value = "UtiDecisionDto", key = "caches[0].name+'.'+args[0]")
    public List<UtiDecisionDto> getCacheDecision(String string) {

        return null;
    }

    /*
     * (non-Javadoc)
     * @see
     * ProductCache#putCacheDecision(java.lang.
     * String, java.util.List)
     */
    @Override
    @CachePut(value = "UtiDecisionDto", key = "caches[0].name+'.'+args[0]")
    public List<UtiDecisionDto> putCacheDecision(String string, List<UtiDecisionDto> outputList) {
        return outputList;
    }

    /*
     * (non-Javadoc)
     * @see
     * ProductCache#putCacheFormula(java.lang.
     * String, UtiFormulaDto)
     */
    @Override
    @CachePut(value = "UtiFormulaDto", key = "caches[0].name+'.'+args[0]")
    public UtiFormulaDto putCacheFormula(String cacheKey, UtiFormulaDto output) {
        return output;
    }

    /*
     * (non-Javadoc)
     * @see
     * ProductCache#getCacheFormula(java.lang.
     * String)
     */
    @Override
    @Cacheable(value = "UtiFormulaDto", key = "caches[0].name+'.'+args[0]")
    public UtiFormulaDto getCacheFormula(String cacheKey) {

        return null;
    }

    /*
     * (non-Javadoc)
     * @see ProductCache#clearFormulaCache()
     */
    @Override
    @CacheEvict(value = "UtiFormulaDto", allEntries = true)
    public void clearFormulaCache()
    {

    }

    /*
     * (non-Javadoc)
     * @see ProductCache#clearFactorCache()
     */
    @Override
    @CacheEvict(value = "UtiFactorDto", allEntries = true)
    public void clearFactorCache()
    {

    }

    /*
     * (non-Javadoc)
     * @see ProductCache#clearDecisionCache()
     */
    @Override
    @CacheEvict(value = "UtiDecisionDto", allEntries = true)
    public void clearDecisionCache()
    {

    }

}
