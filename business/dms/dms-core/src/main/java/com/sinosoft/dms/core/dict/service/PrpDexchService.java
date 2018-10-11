package com.sinosoft.dms.core.dict.service;

import com.sinosoft.dms.api.dict.dto.PrpDexchDto;

import java.util.List;
import java.util.Map;

public interface PrpDexchService {

    /**
     * 根据入参条件获得距给定日期最近一天的两种币别的兑换率
     * @author: 宋振振
     * @date: 2017/12/8 14:49
     * @param iBaseCurrency 基准币别
     * @param iExchCurrency 兑换币别
     * @param iExchDate 兑换日期 标准的年月日格式
     * @return 返回兑换率
     * @throws Exception
     */
    public Map<String,Double> getExchangeRate(String iBaseCurrency, String iExchCurrency, String iExchDate) throws Exception;

    /**
     * （按主键查最大兑换时间）
     * @author: 王志文
     * @date: 2018/4/14 11:01
     * @param iBaseCurrency
     * @param iExchCurrency
     * @param iExchDate
     * @return
     * @throws Exception
     */
    public List<PrpDexchDto> queryMaxExchDateByConditions(String iBaseCurrency, String iExchCurrency, String iExchDate) throws Exception;
}
