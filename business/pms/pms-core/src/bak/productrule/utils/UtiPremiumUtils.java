package com.sinosoft.pms.core.productrule.utils;


import com.sinosoft.pms.api.productrule.dto.UtiDecisionDto;
import com.sinosoft.pms.api.productrule.dto.UtiFactorDto;
import com.sinosoft.pms.api.productrule.dto.UtiFormulaConditionDto;
import com.sinosoft.pms.api.productrule.dto.UtiFormulaDto;
import com.sinosoft.pms.core.productrule.entity.UtiDecisionTable;
import com.sinosoft.pms.core.productrule.service.ProductCache;
import org.apache.commons.lang3.StringUtils;

import java.util.*;


/**
 * @description 获取保费计算配置工具类
 * @author 王志伟
 * @date 2016年9月19日上午10:48:15
 */
public class UtiPremiumUtils
{

    /**
     * 构造方法
     */
    public UtiPremiumUtils()
    {

    }

    /**
     * @description 封装查询条件map中一些共同字段，空则处理为default
     * @author 王志伟
     * @param input
     * @param paramMap
     * @param defaultValue
     * @date 2016年9月19日上午10:52:35
     */
    public static void setMapCommValue(Map<String, Object> paramMap, UtiFormulaConditionDto input,
                                       String defaultValue)
    {
        if (StringUtils.isNotEmpty(input.getComCode()))
        {
            paramMap.put("comCode", input.getComCode());
        }
        else
        {
            paramMap.put("comCode", defaultValue);
        }
        if (StringUtils.isNotEmpty(input.getRiskCode()))
        {
            paramMap.put("riskCode", input.getRiskCode());
        }
        else
        {
            paramMap.put("riskCode", defaultValue);
        }
        if (StringUtils.isNotEmpty(input.getClauseCode()))
        {
            paramMap.put("clauseCode", input.getClauseCode());
        }
        else
        {
            paramMap.put("clauseCode", defaultValue);
        }
        if (StringUtils.isNotEmpty(input.getKindCode()))
        {
            paramMap.put("kindCode", input.getKindCode());
        }
        else
        {
            paramMap.put("kindCode", defaultValue);
        }
    }

    /**
     * @description 因子集合返回值封装
     * @author 王志伟
     * @param outputList
     * @param factors
     * @date 2016年9月19日下午3:03:03
     */
    public static void packFactorList(List<Map<String, Object>> factors,
                                      List<UtiFactorDto> outputList)
    {
        UtiFactorDto output;
        for (Map<String, Object> factorMap : factors)
        {
            // 封装返回值
            output = new UtiFactorDto();
            output.setFactorCode((String)factorMap.get("factorCode"));
            output.setFactorType((String)factorMap.get("factorType"));
            output.setFromKey((String)factorMap.get("fromColumn"));
            output.setRelatedFactorCodes((String)factorMap.get("relatedFactorCodes"));
            outputList.add(output);
        }
    }

    /**
     * @description 分子因子决策返回集合
     * @param decisionList
     * @param outputList
     * @author 王志伟
     * @param paramMap
     * @date 2016年9月19日下午4:46:24
     */
    public static void packDecisionList(Map<String, Object> paramMap,
                                        List<UtiDecisionTable> decisionList,
                                        List<UtiDecisionDto> outputList)
    {
        UtiDecisionDto utiDecisionDto = null;
        // 查询到的决策放入键值对
        Map<String, UtiDecisionTable> decisionMap = coverDecisionToMap(decisionList);
        @SuppressWarnings("unchecked")
        List<Map<String, Object>> paramMapList = (List<Map<String, Object>>)paramMap.get(
            "factorConditions");
        UtiDecisionTable utiDecisionTable = null;
        StringBuilder builder = new StringBuilder();
        appendToKeyEvenNull(builder, paramMap.get("comCode"));
        appendToKeyEvenNull(builder, paramMap.get("riskCode"));
        appendToKeyEvenNull(builder, paramMap.get("clauseCode"));
        appendToKeyEvenNull(builder, paramMap.get("kindCode"));
        String preKey = builder.toString();
        for (Map<String, Object> param : paramMapList)
        {
            // 根据服务入参拼接key，获得要返回的决策
            utiDecisionTable = getDecisionByCondition(preKey, param, decisionMap);
            if (null != utiDecisionTable)
            {
                utiDecisionDto = new UtiDecisionDto();
                utiDecisionDto.setFactorCode(utiDecisionTable.getFactorCode());
                utiDecisionDto.setFactorValue(utiDecisionTable.getDefaultValue());
                outputList.add(utiDecisionDto);
            }
        }
    }

    /**
     * @description 获取决策
     * @param param
     * @param decisionMap
     * @return
     * @author 王志伟
     * @param preKey
     * @date 2016年9月22日下午7:09:52
     */
    private static UtiDecisionTable getDecisionByCondition(String preKey,
                                                           Map<String, Object> param,
                                                           Map<String, UtiDecisionTable> decisionMap)
    {
        StringBuilder builder = new StringBuilder();
        UtiDecisionTable utiDecisionTable = null;
        int lastCondiIndex = -1;
        int loopCount = 0;
        String coverStr = "";
        /*
         * 循环查找对应决策， 从后面的condition到前面的condition 若给定值没有匹配，则改成other匹配， 还没匹配则改成all再来匹配，直到匹配或循环完成
         */
        Object condition = null;
        // 当没有获取到决策并且循环的condition还在1-10之间
        while (null == utiDecisionTable && -1 <= lastCondiIndex)
        {
            builder.setLength(0);
            builder.append(preKey);
            appendToKeyEvenNull(builder, param.get("factorCode"));
            // 拼接key 中的condition
            condition = param.get("condition1");
            lastCondiIndex = appendConditionSingle(builder, loopCount, lastCondiIndex, coverStr,
                condition, 1);
            condition = param.get("condition2");
            lastCondiIndex = appendConditionSingle(builder, loopCount, lastCondiIndex, coverStr,
                condition, 2);
            condition = param.get("condition3");
            lastCondiIndex = appendConditionSingle(builder, loopCount, lastCondiIndex, coverStr,
                condition, 3);
            condition = param.get("condition4");
            lastCondiIndex = appendConditionSingle(builder, loopCount, lastCondiIndex, coverStr,
                condition, 4);
            condition = param.get("condition5");
            lastCondiIndex = appendConditionSingle(builder, loopCount, lastCondiIndex, coverStr,
                condition, 5);
            condition = param.get("condition6");
            lastCondiIndex = appendConditionSingle(builder, loopCount, lastCondiIndex, coverStr,
                condition, 6);
            condition = param.get("condition7");
            lastCondiIndex = appendConditionSingle(builder, loopCount, lastCondiIndex, coverStr,
                condition, 7);
            condition = param.get("condition8");
            lastCondiIndex = appendConditionSingle(builder, loopCount, lastCondiIndex, coverStr,
                condition, 8);
            condition = param.get("condition9");
            lastCondiIndex = appendConditionSingle(builder, loopCount, lastCondiIndex, coverStr,
                condition, 9);
            condition = param.get("condition10");
            lastCondiIndex = appendConditionSingle(builder, loopCount, lastCondiIndex, coverStr,
                condition, 10);
            // 当前condition按照传入值 other all 顺序进行匹配
            if ("".equals(coverStr))
            {
                coverStr = "other";
            }
            else if ("other".equals(coverStr))
            {
                coverStr = "all";
            }
            else
            {
                coverStr = "";
                // 循环到all还没有匹配，则循环前面的condition
                if (loopCount > 0)
                {
                    lastCondiIndex-- ;
                }
            }
            // 根据key，得到当前决策
            utiDecisionTable = decisionMap.get(builder.toString());
            loopCount++ ;
        }
        return utiDecisionTable;
    }

    /**
     * @description 拼接key 中的condition
     * @author 王志伟
     * @param lastCondiIndex
     * @param loopCount
     * @param builder
     * @param condition
     * @param coverStr
     * @date 2016年9月22日下午7:59:54
     */
    private static int appendConditionSingle(StringBuilder builder, int loopCount,
                                             int lastCondiIndex, String coverStr, Object condition,
                                             int conditionIndex)
    {
        // condition 为空的不拼入key
        if (null != condition)
        {
            if (0 == loopCount)
            {
                // 首次循环，得到最后一个不为空的condition序号
                lastCondiIndex = conditionIndex;
            }
            if (conditionIndex == lastCondiIndex)
            {
                // 当前的condition序号和最后一个做转换的condition序号相同，则依次拼接实际值、other、all
                if (!"".equals(coverStr))
                {
                    appendToKeyEvenNull(builder, coverStr);
                }
                else
                {
                    appendToKeyEvenNull(builder, condition);
                }
            }
            else if (conditionIndex > lastCondiIndex)
            {
                // 当前的condition序号比最后一个做转换的condition序号大，则拼接all
                appendToKeyEvenNull(builder, "all");
            }
            else
            {
                // 当前的condition序号比最后一个做转换的condition序号小，则拼接实际值
                appendToKeyEvenNull(builder, condition);
            }
        }
        return lastCondiIndex;
    }

    /**
     * @description 决策放入键值对，方便获取
     * @param decisionList
     * @return
     * @author 王志伟
     * @date 2016年9月22日下午6:58:58
     */
    private static Map<String, UtiDecisionTable> coverDecisionToMap(List<UtiDecisionTable> decisionList)
    {
        Map<String, UtiDecisionTable> map = new HashMap<String, UtiDecisionTable>();
        StringBuilder builder = new StringBuilder();
        for (UtiDecisionTable utiDecisionTable : decisionList)
        {
            builder.setLength(0);
            appendToKeyEvenNull(builder, utiDecisionTable.getComCode());
            appendToKeyEvenNull(builder, utiDecisionTable.getRiskCode());
            appendToKeyEvenNull(builder, utiDecisionTable.getClauseCode());
            appendToKeyEvenNull(builder, utiDecisionTable.getKindCode());
            appendToKeyEvenNull(builder, utiDecisionTable.getFactorCode());
            appendToKeyWhenNotNull(builder, utiDecisionTable.getCondition1());
            appendToKeyWhenNotNull(builder, utiDecisionTable.getCondition2());
            appendToKeyWhenNotNull(builder, utiDecisionTable.getCondition3());
            appendToKeyWhenNotNull(builder, utiDecisionTable.getCondition4());
            appendToKeyWhenNotNull(builder, utiDecisionTable.getCondition5());
            appendToKeyWhenNotNull(builder, utiDecisionTable.getCondition6());
            appendToKeyWhenNotNull(builder, utiDecisionTable.getCondition7());
            appendToKeyWhenNotNull(builder, utiDecisionTable.getCondition8());
            appendToKeyWhenNotNull(builder, utiDecisionTable.getCondition9());
            appendToKeyWhenNotNull(builder, utiDecisionTable.getCondition10());
            map.put(builder.toString(), utiDecisionTable);
        }
        return map;
    }

    /**
     * @description 拼接condition到key
     * @author 王志伟
     * @param condition
     * @param builder
     * @date 2016年9月26日上午12:14:50
     */
    private static void appendToKeyWhenNotNull(StringBuilder builder, String condition)
    {
        if (null != condition)
        {
            appendToKeyEvenNull(builder, condition);
        }
    }

    /**
     * @description 保费计算公式的缓存key拼装
     * @param paramMap
     * @return
     * @author 王志伟
     * @date 2016年9月21日上午9:30:58
     */
    public static String getCacheFormulaKey(Map<String, Object> paramMap)
    {
        StringBuilder b = new StringBuilder();
        appendCommKey(b, paramMap);
        b.append(paramMap.get("formulaType"));
        return b.toString();
    }

    /**
     * @description 拼接缓存key中公共部分
     * @param b
     * @param paramMap
     * @author 王志伟
     * @date 2016年9月21日上午10:22:35
     */
    private static void appendCommKey(StringBuilder b, Map<String, Object> paramMap)
    {
        appendToKeyEvenNull(b, paramMap.get("comCode"));
        appendToKeyEvenNull(b, paramMap.get("riskCode"));
        appendToKeyEvenNull(b, paramMap.get("clauseCode"));
        appendToKeyEvenNull(b, paramMap.get("kindCode"));
    }

    /**
     * @description 缓存获取保费计算公式
     * @param cacheKey
     * @return
     * @author 王志伟
     * @param productCache
     * @date 2016年9月21日上午9:31:16
     */
    public static UtiFormulaDto getCacheFormula(String cacheKey, ProductCache productCache)
    {
        UtiFormulaDto cacheDto = productCache.getCacheFormula(cacheKey);
        return cacheDto;
    }

    /**
     * @description 保费公式放入缓存
     * @param cacheKey
     * @param output
     * @author 王志伟
     * @param productCache
     * @date 2016年9月21日上午9:31:20
     */
    public static void putCacheFormula(String cacheKey, UtiFormulaDto output,
                                       ProductCache productCache)
    {
        productCache.putCacheFormula(cacheKey, output);
    }

    /**
     * @description 因子缓存key的拼装
     * @param paramMap
     * @return
     * @author 王志伟
     * @date 2016年9月21日上午9:45:04
     */
    public static String getCacheFactorKey(Map<String, Object> paramMap)
    {
        StringBuilder b = new StringBuilder();
        appendCommKey(b, paramMap);
        @SuppressWarnings("unchecked")
        List<String> factorCodeList = (List<String>)paramMap.get("factorCodeList");
        String[] strArray = factorCodeList.toArray(new String[] {});
        Arrays.sort(strArray);
        b.append(Arrays.toString(strArray));
        return b.toString();
    }

    /**
     * @description 缓存获取因子集合
     * @param cacheKey
     * @return
     * @author 王志伟
     * @param productCache
     * @date 2016年9月21日上午9:45:10
     */
    public static List<UtiFactorDto> getCacheFactor(String cacheKey, ProductCache productCache)
    {
        List<UtiFactorDto> cacheDto = productCache.getCacheFactor(cacheKey);
        return cacheDto;
    }

    /**
     * @description 因子集合放入缓存
     * @param cacheKey
     * @param outputList
     * @param productCache
     * @author 王志伟
     * @date 2016年9月21日上午9:45:16
     */
    public static void putCacheFactor(String cacheKey, List<UtiFactorDto> outputList,
                                      ProductCache productCache)
    {
        productCache.putCacheFactor(cacheKey, outputList);
    }

    /**
     * @description 决策缓存key的拼装
     * @param paramMap
     * @return
     * @author 王志伟
     * @date 2016年9月21日上午9:51:08
     */
    public static String getCacheDecisionKey(Map<String, Object> paramMap)
    {
        StringBuilder b = new StringBuilder();
        appendCommKey(b, paramMap);
        @SuppressWarnings("unchecked")
        List<Map<String, Object>> factorMap = (List<Map<String, Object>>)paramMap.get(
            "factorConditions");
        List<String> factorList = new ArrayList<String>();
        StringBuilder factorBuilder = new StringBuilder();
        for (Map<String, Object> factor : factorMap)
        {
            factorBuilder.setLength(0);
            appConditions(factor, factorBuilder);
            factorList.add(factorBuilder.toString());
        }
        String[] strArray = factorList.toArray(new String[] {});
        Arrays.sort(strArray);
        b.append(Arrays.toString(strArray));
        return b.toString();
    }

    /**
     * @description 拼接单个决策key中condition
     * @author 王志伟
     * @param factorBuilder
     * @param factor
     * @date 2016年9月22日下午7:00:21
     */
    private static void appConditions(Map<String, Object> factor, StringBuilder factorBuilder)
    {
        appendToKeyEvenNull(factorBuilder, factor.get("factorCode"));
        appendToKeyEvenNull(factorBuilder, factor.get("condition1"));
        appendToKeyEvenNull(factorBuilder, factor.get("condition2"));
        appendToKeyEvenNull(factorBuilder, factor.get("condition3"));
        appendToKeyEvenNull(factorBuilder, factor.get("condition4"));
        appendToKeyEvenNull(factorBuilder, factor.get("condition5"));
        appendToKeyEvenNull(factorBuilder, factor.get("condition6"));
        appendToKeyEvenNull(factorBuilder, factor.get("condition7"));
        appendToKeyEvenNull(factorBuilder, factor.get("condition8"));
        appendToKeyEvenNull(factorBuilder, factor.get("condition9"));
        appendToKeyEvenNull(factorBuilder, factor.get("condition10"));
    }

    /**
     * @description 拼接字符串
     * @param factorBuilder
     * @param object
     * @author 王志伟
     * @date 2016年9月26日上午12:20:27
     */
    private static void appendToKeyEvenNull(StringBuilder factorBuilder, Object object)
    {
        factorBuilder.append(object);
        factorBuilder.append("_");
    }

    /**
     * @description 缓存获取决策值
     * @param cacheKey
     * @param productCache
     * @return
     * @author 王志伟
     * @date 2016年9月21日上午9:51:12
     */
    public static List<UtiDecisionDto> getCacheDecision(String cacheKey, ProductCache productCache)
    {
        List<UtiDecisionDto> cacheDto = productCache.getCacheDecision(cacheKey);
        return cacheDto;
    }

    /**
     * @description 决策值放入缓存
     * @param cacheKey
     * @param outputList
     * @param productCache
     * @author 王志伟
     * @date 2016年9月21日上午9:51:26
     */
    public static void putCacheDecision(String cacheKey, List<UtiDecisionDto> outputList,
                                        ProductCache productCache)
    {
        productCache.putCacheDecision(cacheKey, outputList);
    }

}
