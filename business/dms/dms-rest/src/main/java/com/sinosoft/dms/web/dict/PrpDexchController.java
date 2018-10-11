package com.sinosoft.dms.web.dict;

import com.sinosoft.dms.api.dict.PrpDexchApi;
import com.sinosoft.dms.api.dict.dto.PrpDexchDto;
import com.sinosoft.dms.core.dict.service.PrpDexchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = PrpDexchController.PATH)
public class PrpDexchController implements PrpDexchApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpDcurrencyController.class);
    @Autowired
    private PrpDexchService prpDexchService;

    /**
     * 获得距给定日期最近一天的两种币别的兑换率
     * @author: 宋振振
     * @date: 2017/12/8 14:49
     * @param map
     * @return 返回兑换率
     * @throws Exception
     */
    public @ResponseBody Map<String,Double> getExchangeRate(@RequestBody Map<String,String> map) throws Exception{
        String iBaseCurrency=map.get("iBaseCurrency");//基准币别
        String iExchCurrency=map.get("iExchCurrency");//兑换币别
        String iExchDate=map.get("iExchDate");//兑换日期 标准的年月日格式
        return prpDexchService.getExchangeRate(iBaseCurrency,iExchCurrency,iExchDate);
    }

    /**
     * （PubTools工具类使用方法）
     * @author: 王志文
     * @date: 2018/4/12 16:49
     * @param iBaseCurrency 基准币别
     * @param iExchCurrency 兑换币别
     * @param iExchDate 兑换日期
     * @return
     * @throws Exception
     */
    @Override
    public int getCount(String iBaseCurrency, String iExchCurrency, String iExchDate) throws Exception {

        return 0;
    }

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
    @Override
    public List<PrpDexchDto> queryMaxExchDateByConditions(@RequestParam("iBaseCurrency") String iBaseCurrency, @RequestParam("iExchCurrency")String iExchCurrency, @RequestParam("iExchDate")String iExchDate) throws Exception {
        return prpDexchService.queryMaxExchDateByConditions(iBaseCurrency,iExchCurrency,iExchDate);
    }
}
