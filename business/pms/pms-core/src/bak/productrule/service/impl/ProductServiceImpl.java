/**
 * 
 */
package com.sinosoft.pms.core.productrule.service.impl;

import com.sinosoft.framework.core.utils.Constans;
import com.sinosoft.pms.api.productrule.dto.*;
import com.sinosoft.pms.core.productrule.dao.UtiDecisionTableDao;
import com.sinosoft.pms.core.productrule.dao.UtiFactorDao;
import com.sinosoft.pms.core.productrule.dao.UtiFormulaDao;
import com.sinosoft.pms.core.productrule.entity.UtiDecisionTable;
import com.sinosoft.pms.core.productrule.entity.UtiFormula;
import com.sinosoft.pms.core.productrule.service.ProductCache;
import com.sinosoft.pms.core.productrule.service.ProductService;
import com.sinosoft.pms.core.productrule.utils.UtiPremiumUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @description 查询产品配置信息实现类
 * @author 王志伟
 * @date 2016年9月17日上午10:31:35
 */
@Service
public class ProductServiceImpl implements ProductService {

	/**
	 * 公式查询数据库操作类
	 */
	@Autowired
	private UtiFormulaDao utiFormulaDao;
	/**
	 * 因子查询数据库操作类
	 */
	@Autowired
	private UtiFactorDao utiFactorDao;
	/**
	 * 分子因子配置值查询数据库操作类
	 */
	@Autowired
	private UtiDecisionTableDao utiDecisionTableDao;
	/**
	 * 缓存处理
	 */
	@Autowired
	private ProductCache productCache;

	/**
	 * 构造方法
	 */
	public ProductServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.sinosoft.dms.dict.service.ProductService#findUtiFormula(com.sinosoft.dms.
	 * dict.dto.UtiFormulaConditionDto)
	 */
	@Override
	public UtiFormulaDto getPremiumFormula(UtiFormulaConditionDto input) throws Exception {
		UtiFormulaDto output = null;
		try {
			// 封装数据库查询条件
			Map<String, Object> paramMap = new HashMap<String, Object>();
			UtiPremiumUtils.setMapCommValue(paramMap, input, "default");
			if (StringUtils.isNotEmpty(input.getFormulaType())) {
				paramMap.put("formulaType", input.getFormulaType());
			} else {
				paramMap.put("formulaType", Constans.PREMIUM_FORMULA_TYPE);
			}
			// 获取缓存key
			String cacheKey = UtiPremiumUtils.getCacheFormulaKey(paramMap);
			// 从缓存获取
			output = UtiPremiumUtils.getCacheFormula(cacheKey, productCache);
			if (null == output) {
				// 从数据库获取
				UtiFormula utiFormula = utiFormulaDao.selectPremiumFormulaByCondition(
						(String)paramMap.get("riskCode"),(String)paramMap.get("clauseCode"),
						(String)paramMap.get("kindCode"),(String)paramMap.get("comCode"),
						(String)paramMap.get("formulaType")
				);
				output = new UtiFormulaDto();
				output.setFormulaContent(utiFormula.getContent());
				output.setAccuracy(utiFormula.getAccuracy().toString());
				output.setComCode(utiFormula.getComCode());
				// 放入缓存
				UtiPremiumUtils.putCacheFormula(cacheKey, output, productCache);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return output;
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * ProductService#getPremiumFactorList(com.
	 * sinosoft.pms.productrule.dto.UtiFactorConditionDto)
	 */
	@Override
	public List<UtiFactorDto> getPremiumFactorList(UtiFactorConditionDto input) throws Exception {
		List<UtiFactorDto> outputList = null;
		try {
			// 封装数据库查询条件
			Map<String, Object> paramMap = new HashMap<String, Object>();
			UtiPremiumUtils.setMapCommValue(paramMap, input, "default");
			List<String> factorCodeList = input.getFactorCodeList();
			paramMap.put("factorCodeList", factorCodeList);
			// 获取缓存key
			String cacheKey = UtiPremiumUtils.getCacheFactorKey(paramMap);
			// 从缓存获取
			//outputList = UtiPremiumUtils.getCacheFactor(cacheKey, productCache);
			if (null == outputList) {
				// 从数据库获取
				List<Map<String, Object>> factors = utiFactorDao.selectPremiumFactorByCondtion(
						(String)paramMap.get("riskCode"),(String)paramMap.get("clauseCode"),(String)paramMap.get("kindCode"),
						(String)paramMap.get("comCode"),(List<String>) paramMap.get("factorCodeList")
				);
				// 封装返回的集合
				outputList = new ArrayList<UtiFactorDto>();
				UtiPremiumUtils.packFactorList(factors, outputList);
				// 放置到缓存
				UtiPremiumUtils.putCacheFactor(cacheKey, outputList, productCache);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return outputList;
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * ProductService#getPremiumDecisionList(
	 * UtiDecisionConditionDto)
	 */
	@Override
	public List<UtiDecisionDto> getPremiumDecisionList(UtiDecisionConditionDto input) throws Exception {
		List<UtiDecisionDto> outputList = null;
		try {
			// 封装数据库查询条件
			Map<String, Object> paramMap = new HashMap<String, Object>();
			UtiPremiumUtils.setMapCommValue(paramMap, input, "default");
			paramMap.put("factorConditions", input.getParamMapList());
			// 获取缓存key
			String cacheKey = UtiPremiumUtils.getCacheDecisionKey(paramMap);
			// 从缓存获取
			outputList = UtiPremiumUtils.getCacheDecision(cacheKey, productCache);
			if (null == outputList) {
				// 从数据库获取
				List<UtiDecisionTable> decisionList = new ArrayList<UtiDecisionTable>();//utiDecisionTableDao.selectPremiumFactorValue();
				// 封装返回的集合
				outputList = new ArrayList<UtiDecisionDto>();
				UtiPremiumUtils.packDecisionList(paramMap, decisionList, outputList);
				// 放置到缓存
				UtiPremiumUtils.putCacheDecision(cacheKey, outputList, productCache);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return outputList;
	}

	/**
	 * @description 单元测试
	 * @param args
	 * @author 王志伟
	 * @date 2016年9月17日上午10:31:35
	 */
	public static void main(String[] args) {

	}

}
