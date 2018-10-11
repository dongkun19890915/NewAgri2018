package com.sinosoft.pms.api.coinsrate;


import com.sinosoft.framework.dto.ResponseDto;
import com.sinosoft.pms.PMSConstant;
import com.sinosoft.pms.api.coinsrate.dto.CoinsRateQueryConditionDto;
import com.sinosoft.pms.api.coinsrate.dto.CoinsRatesDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@FeignClient(name = PMSConstant.PMS_SERVICE_NAME, path = CoinsRateApi.PATH)
public interface CoinsRateApi {
    public static final String PATH = "coinsRate";

    /**
     * @param conditionDto
     * @return
     * @throws Exception
     * @description 查询共保比例
     * @author yinqinzhu
     * @date 2016年10月22日下午5:24:35
     */
    @RequestMapping(value = "getCoinsRate", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDto getCoinsRate(@RequestBody CoinsRateQueryConditionDto conditionDto) throws Exception;


    /**
     * @param conditionDto
     * @return
     * @throws Exception
     * @description 共保比例查询列表
     * @author yinqinzhu
     * @date 2016年10月22日下午5:25:58
     */
    @RequestMapping(value = "quereyCoinsRateList", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDto quereyPrpdCoinsRateList(@RequestBody CoinsRateQueryConditionDto conditionDto) throws Exception;

    /**
     * @return
     * @throws Exception
     * @description 查询最新有效的版次信息
     * @author yinqinzhu
     * @date 2016年10月22日下午5:26:08
     */
    @RequestMapping(value = "queryLateCoinsRate", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDto queryLateCoinsRate() throws Exception;


    /**
     * @param coinsRatesDto
     * @return
     * @throws Exception
     * @description 保存共保比例
     * @author yinqinzhu
     * @date 2016年10月22日下午5:26:18
     */
    @RequestMapping(value = "saveCoinsRateList", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDto savePrpdCoinsRateList(@RequestBody CoinsRatesDto coinsRatesDto) throws Exception;
}