package com.sinosoft.dms.api.dict;

import com.sinosoft.dms.api.DMSConstant;
import com.sinosoft.dms.api.dict.dto.PrpDexchDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@FeignClient(name = DMSConstant.DMS_SERVICE_NAME,path =PrpDexchApi.PATH )
public interface PrpDexchApi {
    public static final String PATH="prpDexch";

    /**
     * 获得距给定日期最近一天的两种币别的兑换率
     * @author: 宋振振
     * @date: 2017/12/8 14:49
     * @param map
     * @return 返回兑换率
     * @throws Exception
     */
    @RequestMapping(value = "getExchangeRate",method = RequestMethod.POST)
    public @ResponseBody Map<String,Double> getExchangeRate(@RequestBody Map<String,String> map) throws Exception;

    /**
     * （PubTools工具类使用方法）
     * @author: 王志文
     * @date: 2018/4/12 16:49
     * @param iBaseCurrency
     * @param iExchCurrency
     * @param iExchDate
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "getCount",method = RequestMethod.POST)
    int getCount(@RequestParam("iBaseCurrency") String iBaseCurrency,@RequestParam("iExchCurrency")String iExchCurrency,@RequestParam("iExchDate")String iExchDate)throws Exception;


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
    @RequestMapping(value = "queryMaxExchDateByConditions",method = RequestMethod.POST)
    List<PrpDexchDto> queryMaxExchDateByConditions(@RequestParam("iBaseCurrency") String iBaseCurrency, @RequestParam("iExchCurrency")String iExchCurrency, @RequestParam("iExchDate")String iExchDate)throws Exception;


}
