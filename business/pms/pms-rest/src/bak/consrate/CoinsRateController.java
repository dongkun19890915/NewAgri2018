package com.sinosoft.pms.web.consrate;


import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.framework.dto.ResponseDto;
import com.sinosoft.pms.api.coinsrate.CoinsRateApi;
import com.sinosoft.pms.api.coinsrate.dto.CoinsRateQueryConditionDto;
import com.sinosoft.pms.api.coinsrate.dto.CoinsRateReturnDto;
import com.sinosoft.pms.api.coinsrate.dto.CoinsRatesDto;
import com.sinosoft.pms.api.coinsrate.dto.PrpDcoinsRateDto;
import com.sinosoft.pms.core.coinsrate.service.CoinsRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author yinqinzhu
 * @description 共保体比例控制器
 * @date 2016年10月22日下午5:24:15
 */
@RestController
@RequestMapping("/coinsRate")
public class CoinsRateController implements CoinsRateApi {
    @Autowired
    private CoinsRateService coinsRateService;


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
    public ResponseDto getCoinsRate(@RequestBody CoinsRateQueryConditionDto conditionDto)
            throws Exception {
        PrpDcoinsRateDto prpdCoinsRateDto = coinsRateService.getCoinsRate(conditionDto);
        return ResponseDto.instance(prpdCoinsRateDto);
    }


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
    public ResponseDto quereyPrpdCoinsRateList(@RequestBody CoinsRateQueryConditionDto conditionDto)
            throws Exception {
        PageInfo<PrpDcoinsRateDto> page = coinsRateService.queryCoinsRateList(conditionDto);
        return ResponseDto.instance(page);
    }

    /**
     * @return
     * @throws Exception
     * @description 查询最新有效的版次信息
     * @author yinqinzhu
     * @date 2016年10月22日下午5:26:08
     */
    @RequestMapping(value = "queryLateCoinsRate", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDto queryLateCoinsRate()
            throws Exception {
        CoinsRateQueryConditionDto queryDto = new CoinsRateQueryConditionDto();
        List<PrpDcoinsRateDto> listConisRate = coinsRateService.queryLateCoinsRate(
                queryDto);
        return ResponseDto.instance(listConisRate);
    }


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
    public ResponseDto savePrpdCoinsRateList(@RequestBody CoinsRatesDto coinsRatesDto)
            throws Exception {
        CoinsRateReturnDto coinsRateReturnDto = coinsRateService.savePrpdCoinsRateList(
                coinsRatesDto);
        return ResponseDto.instance(coinsRateReturnDto);
    }
}
